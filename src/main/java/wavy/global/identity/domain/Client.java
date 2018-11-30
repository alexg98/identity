package wavy.global.identity.domain;

import java.util.List;

public class Client {

	protected String id;
    protected String clientId;
    protected String name;
    protected String description;
    protected String rootUrl;
    protected String adminUrl;
    protected String baseUrl;
    protected boolean surrogateAuthRequired;
    protected boolean enabled;
    protected String clientAuthenticatorType;
    protected String secret;
    protected String registrationAccessToken;
    protected String[] defaultRoles;
    protected List<String> redirectUris;
    protected List<String> webOrigins;
    protected Integer notBefore;
    protected boolean bearerOnly;
    protected boolean consentRequired;
    protected boolean standardFlowEnabled;
    protected boolean implicitFlowEnabled;
    protected boolean directAccessGrantsEnabled;
    protected boolean serviceAccountsEnabled;
    protected boolean authorizationServicesEnabled;
    
    protected boolean publicClient;
    protected boolean fullScopeAllowed;
    protected boolean frontchannelLogout;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRootUrl() {
		return rootUrl;
	}
	public void setRootUrl(String rootUrl) {
		this.rootUrl = rootUrl;
	}
	public String getAdminUrl() {
		return adminUrl;
	}
	public void setAdminUrl(String adminUrl) {
		this.adminUrl = adminUrl;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public boolean isSurrogateAuthRequired() {
		return surrogateAuthRequired;
	}
	public void setSurrogateAuthRequired(boolean surrogateAuthRequired) {
		this.surrogateAuthRequired = surrogateAuthRequired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getClientAuthenticatorType() {
		return clientAuthenticatorType;
	}
	public void setClientAuthenticatorType(String clientAuthenticatorType) {
		this.clientAuthenticatorType = clientAuthenticatorType;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getRegistrationAccessToken() {
		return registrationAccessToken;
	}
	public void setRegistrationAccessToken(String registrationAccessToken) {
		this.registrationAccessToken = registrationAccessToken;
	}
	public String[] getDefaultRoles() {
		return defaultRoles;
	}
	public void setDefaultRoles(String[] defaultRoles) {
		this.defaultRoles = defaultRoles;
	}
	public List<String> getRedirectUris() {
		return redirectUris;
	}
	public void setRedirectUris(List<String> redirectUris) {
		this.redirectUris = redirectUris;
	}
	public List<String> getWebOrigins() {
		return webOrigins;
	}
	public void setWebOrigins(List<String> webOrigins) {
		this.webOrigins = webOrigins;
	}
	public Integer getNotBefore() {
		return notBefore;
	}
	public void setNotBefore(Integer notBefore) {
		this.notBefore = notBefore;
	}
	public boolean isBearerOnly() {
		return bearerOnly;
	}
	public void setBearerOnly(boolean bearerOnly) {
		this.bearerOnly = bearerOnly;
	}
	public boolean isConsentRequired() {
		return consentRequired;
	}
	public void setConsentRequired(boolean consentRequired) {
		this.consentRequired = consentRequired;
	}
	public boolean isStandardFlowEnabled() {
		return standardFlowEnabled;
	}
	public void setStandardFlowEnabled(boolean standardFlowEnabled) {
		this.standardFlowEnabled = standardFlowEnabled;
	}
	public boolean isImplicitFlowEnabled() {
		return implicitFlowEnabled;
	}
	public void setImplicitFlowEnabled(boolean implicitFlowEnabled) {
		this.implicitFlowEnabled = implicitFlowEnabled;
	}
	public boolean isDirectAccessGrantsEnabled() {
		return directAccessGrantsEnabled;
	}
	public void setDirectAccessGrantsEnabled(boolean directAccessGrantsEnabled) {
		this.directAccessGrantsEnabled = directAccessGrantsEnabled;
	}
	public boolean isServiceAccountsEnabled() {
		return serviceAccountsEnabled;
	}
	public void setServiceAccountsEnabled(boolean serviceAccountsEnabled) {
		this.serviceAccountsEnabled = serviceAccountsEnabled;
	}
	public boolean isAuthorizationServicesEnabled() {
		return authorizationServicesEnabled;
	}
	public void setAuthorizationServicesEnabled(boolean authorizationServicesEnabled) {
		this.authorizationServicesEnabled = authorizationServicesEnabled;
	}
	public boolean isPublicClient() {
		return publicClient;
	}
	public void setPublicClient(boolean publicClient) {
		this.publicClient = publicClient;
	}
	public boolean isFullScopeAllowed() {
		return fullScopeAllowed;
	}
	public void setFullScopeAllowed(boolean fullScopeAllowed) {
		this.fullScopeAllowed = fullScopeAllowed;
	}
	public boolean isFrontchannelLogout() {
		return frontchannelLogout;
	}
	public void setFrontchannelLogout(boolean frontchannelLogout) {
		this.frontchannelLogout = frontchannelLogout;
	}	
}
