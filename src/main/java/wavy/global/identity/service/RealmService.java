package wavy.global.identity.service;

import java.util.stream.Collectors;

import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wavy.global.identity.domain.RealmDTO;
import wavy.global.identity.utilities.EnumPolicies;

@Service
public class RealmService {

	@Autowired
	private KeycloakService keycloakService;
	
	
	public void createRealm(RealmDTO realm) {
		
		RealmRepresentation realmTmp = new RealmRepresentation();		
		realmTmp.setLoginWithEmailAllowed(realm.isLoginWithEmailAllowed()); 		
		realmTmp.setBruteForceProtected(realm.isBruteForceProtected() );
		realmTmp.setFailureFactor(realm.getFailureFactor());		
		realmTmp.setPasswordPolicy( addPolicies(realm) );		
		realmTmp.setRealm(realm.getName());		
		keycloakService.getRealmAdmin().create(realmTmp);		
	}
	
	public RealmRepresentation getRealmRepresentation(String realmName) {
		return keycloakService.getRealmResource(realmName).toRepresentation();
	}
	
	public void updatePolicies(RealmDTO realm) {
		RealmResource resource = keycloakService.getRealmResource(realm.getName());
		RealmRepresentation realObj = resource.toRepresentation();
		realObj.setPasswordPolicy(addPolicies(realm));	
		resource.update(realObj);
	}
	
	public void remove(String realmName) {
		keycloakService.getRealmAdmin().realm(realmName).remove();
	}
	
	private String addPolicies(RealmDTO realm) {
		if(realm.getPolicies() != null && !realm.getPolicies().isEmpty()) {
			return realm.getPolicies().stream()
				.filter(p -> EnumPolicies.existPolicy(p.getPolicy()) )
				.map(enu -> String.format( enu.getPolicy(), enu.getValue()))
				.collect(Collectors.joining( " and " ));			
		}
		return null;
	}
	
	
	
}