package wavy.global.identity.domain;

public class AuthResponse {

	
	private String sessionState;
	private String authToken;
	private int oldLifespan;
	private int refreshExpiresIn;
	private int notBeforePolicy;
	private String scope;
	private String tokenType;
			
	private int codeResponse;
	private String message;
	
	public String getSessionState() {
		return sessionState;
	}
	public void setSessionState(String sessionState) {
		this.sessionState = sessionState;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public int getOldLifespan() {
		return oldLifespan;
	}
	public void setOldLifespan(int oldLifespan) {
		this.oldLifespan = oldLifespan;
	}
	public int getCodeResponse() {
		return codeResponse;
	}
	public void setCodeResponse(int codeResponse) {
		this.codeResponse = codeResponse;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRefreshExpiresIn() {
		return refreshExpiresIn;
	}
	public void setRefreshExpiresIn(int refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}
	public int getNotBeforePolicy() {
		return notBeforePolicy;
	}
	public void setNotBeforePolicy(int notBeforePolicy) {
		this.notBeforePolicy = notBeforePolicy;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}	
}