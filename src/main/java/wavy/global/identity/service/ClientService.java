package wavy.global.identity.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wavy.global.identity.domain.Client;
import wavy.global.identity.domain.User;
import wavy.global.identity.utilities.IdentityRuntimeException;
import wavy.global.identity.utilities.ModelMapperUtil;

@Service
public class ClientService {

	@Autowired
	private KeycloakService keycloakService;
	
	@Autowired
	private ModelMapperUtil mapper;
	
	/**
	 * Create a ClientRepresentation from a client for a realmName
	 * @param client
	 * @param realmName
	 * @return
	 */
	public Client createClient(Client client, String realmName) {
		RealmResource rs = keycloakService.getRealmResource(realmName);
		ClientRepresentation identity = mapper.map(client, ClientRepresentation.class );
		identity.setEnabled(true);
		identity.setFullScopeAllowed(true);
		identity.setPublicClient(true);
		identity.setDirectAccessGrantsEnabled(true);
		identity.setBearerOnly(true);
		Response response = rs.clients().create(identity);
		if (response.getStatus()  != 201) {
			throw new IdentityRuntimeException("Couldn't create client.");
		}		
		ClientsResource resource = keycloakService.getClientResource(realmName);
		ClientRepresentation cli = resource.findByClientId(client.getClientId()).stream().findFirst().get();		
		return mapper.map(cli, Client.class);
	}
	
	/**
	 * Create user of a realm
	 * @param realmName
	 * @param usuario
	 */	
	public User createUser(String realmName, User usuario) {				
		RealmResource rs = keycloakService.getRealmResource(realmName); 

		CredentialRepresentation credential = new CredentialRepresentation();
		credential.setType(CredentialRepresentation.PASSWORD);
		credential.setValue(usuario.getPassword() );
		UserRepresentation user = mapper.map(usuario, UserRepresentation.class);
		user.setCredentials(Arrays.asList(credential));	
		Response res = rs.users().create(user); 
		if (res.getStatus()  != 201) {
			throw new IdentityRuntimeException("Couldn't create user.");
		}
		UserRepresentation ur = rs.users().search(usuario.getUsername()).stream().findFirst().get();
		res.close();
		return mapper.map(ur, User.class );
	}	
	
	/**
	 * Find user by username from Keycloak
	 * @param realmName
	 * @param userName
	 * @return
	 */
	public UserRepresentation findUserByUserName(String realmName, String userName) {
		RealmResource rs = keycloakService.getRealmResource(realmName);
		Optional<UserRepresentation> user = rs.users().search(userName).stream().findFirst();
		if(user.isPresent()) {
			return user.get();
		}
		throw new IdentityRuntimeException("User not exists");		
	}	
	
	/**
	 * Update user 
	 * @param realmName
	 * @param usuario
	 * @return
	 */
	public User updateUser(String realmName, User usuario) {		
		UserRepresentation userRepre = this.findUserByUserName(realmName, usuario.getUsername());
		UserResource userResource = keycloakService.getUserResource(realmName, userRepre.getId());		
		UserRepresentation usetTmp =  mapper.map(usuario, UserRepresentation.class);
		usetTmp.setId(userRepre.getId());		
		userResource.update(usetTmp);		
		return usuario;
	}
	/**
	 * Activate user
	 * @param realmName
	 * @param username
	 */
	public void activateUser(String realmName, String username) {
		UserRepresentation userRepre = this.findUserByUserName(realmName, username);
		UserResource userResource = keycloakService.getUserResource(realmName, userRepre.getId());
		userRepre.setEnabled(true);
		userResource.update(userRepre);	
	}
	
	/**
	 * Get all user from realmName
	 * @param realmName
	 * @return
	 */
	public List<User> findAllUser(String realmName) {
		RealmResource rs = keycloakService.getRealmResource(realmName);
		return mapper.mapAll(rs.users().list(), User.class); 
	}
	
}