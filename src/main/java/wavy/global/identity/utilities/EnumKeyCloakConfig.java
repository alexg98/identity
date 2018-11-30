package wavy.global.identity.utilities;

public enum EnumKeyCloakConfig {

	URL("http://localhost:8080/auth"),
	REALM_MASTER("master"),
	USER("admin"),
	PASSWORD("admin"),
	CLIENT_ID("admin-cli");
	
	private String value;
	
	EnumKeyCloakConfig(String value){
		this.value = value;
	}
	
	public String val() {
		return value;
	}
}
