package wavy.global.identity.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.ClientResource;
import org.keycloak.admin.client.resource.ClientsResource;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RealmsResource;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.admin.client.resource.RolesResource;
import org.keycloak.admin.client.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wavy.global.identity.utilities.IdentityRuntimeException;

@Service
public class KeycloakService {

	@Autowired
	private Keycloak Keycloak;
	
	public RealmsResource getRealmAdmin() {
		return Keycloak.realms();
	}
	/**
	 * Get RealmResource from a realName
	 * @param realmName
	 * @return
	 */
	public RealmResource getRealmResource(String realmName) {	
		RealmResource rs = Keycloak.realm(realmName);
		if(rs == null) {
			throw new IdentityRuntimeException("Realm not exists");
		}
		return rs;
	}
	
	/**
	 * Get UserResource from realName and id User
	 * @param realmName
	 * @param id
	 * @return
	 */
	public UserResource getUserResource(String realmName, String id){		
		UserResource userResource = this.getRealmResource(realmName).users().get(id);
		if(userResource == null) {
			throw new IdentityRuntimeException("Realm not exists");
		}
		return userResource;
	}
	
	/**
	 * Get RolesResource from a realName
	 * @param realmName
	 * @return
	 */
	public RolesResource getRoleResource(String realmName) {
		RolesResource rolesResource = this.getRealmResource(realmName).roles();		
		if(rolesResource == null) {
			throw new IdentityRuntimeException("Roles not exists");
		}
		return rolesResource;
	}
	/**
	 * Get RoleResource from a realName and rol name
	 * @param realmName
	 * @return
	 */
	public RoleResource getRoleResource(String realmName,String roleName) {
		RoleResource rolesResource = this.getRealmResource(realmName).roles().get(roleName);		
		if(rolesResource == null) {
			throw new IdentityRuntimeException("Roles not exists");
		}
		return rolesResource;
	}
	/**
	 * Get ClientsResource from a realName
	 * @param realmName
	 * @return
	 */
	public ClientsResource getClientResource(String realmName) {
		ClientsResource clientResource = this.getRealmResource(realmName).clients();
		if(clientResource == null) {
			throw new IdentityRuntimeException("Clients not exists");
		}
		return clientResource;
	}
	/**
	 * Get ClientResource from a realName and clientId
	 * @param realmName
	 * @return
	 */
	public ClientResource getClientResource(String realmName, String id) {
		ClientResource clientResource = this.getRealmResource(realmName).clients().get(id);
		if(clientResource == null) {
			throw new IdentityRuntimeException("Clients not exists");
		}
		return clientResource;
	}
}
