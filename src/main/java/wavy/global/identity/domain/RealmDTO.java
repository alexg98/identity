package wavy.global.identity.domain;

import java.util.List;

public class RealmDTO {

	private String name;
	private List<PolicyVO> policies;
	private boolean loginWithEmailAllowed;
	private boolean bruteForceProtected;
	private int failureFactor;
	
	public String getName() {
		return name;
	}
	public List<PolicyVO> getPolicies() {
		return policies;
	}
	public boolean isLoginWithEmailAllowed() {
		return loginWithEmailAllowed;
	}
	public boolean isBruteForceProtected() {
		return bruteForceProtected;
	}
	public int getFailureFactor() {
		return failureFactor;
	}	
}
