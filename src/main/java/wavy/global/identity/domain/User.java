package wavy.global.identity.domain;

public class User {

	protected String id;
	protected Long createdTimestamp;
	protected String username;
	protected Boolean enabled;
	protected Boolean totp;
	protected Boolean emailVerified;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String federationLink;
	protected String serviceAccountClientId;
	protected String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getCreatedTimestamp() {
		return createdTimestamp;
	}
	public void setCreatedTimestamp(Long createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getTotp() {
		return totp;
	}
	public void setTotp(Boolean totp) {
		this.totp = totp;
	}
	public Boolean getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFederationLink() {
		return federationLink;
	}
	public void setFederationLink(String federationLink) {
		this.federationLink = federationLink;
	}
	public String getServiceAccountClientId() {
		return serviceAccountClientId;
	}
	public void setServiceAccountClientId(String serviceAccountClientId) {
		this.serviceAccountClientId = serviceAccountClientId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
