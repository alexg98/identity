package wavy.global.identity.utilities;

public enum EnumPolicies {
	
	FORCE_EXPIRE_PASSWORD_CHANGE("forceExpiredPasswordChange(%d)"),
	LENGTH("length(%d)"),
	HASH_ITERATIONS("hashIterations(%d)"),
	SPECIAL_CHARS("specialChars(%d)"),
	PASSWORD_HISTORY("passwordHistory(%d)"),
	LOWER_CASE("lowerCase(%d)"),
	REGEX_PATTERN("regexPattern(%s)"),
	NOT_USERNAME("notUsername(undefined)"),
	DIGITS("digits(%d)"),
	HASH_ALGORITHM("hashAlgorithm(%s)"),
	UPPERCASE("upperCase(%d)");
	
	private String policy;
	
	EnumPolicies(String policy) {
		this.policy = policy;
	}
	
	public String getPolicy() {
		return policy;
	}
	
	public static boolean existPolicy(String value) {
		for(EnumPolicies enu : values()) {
			if(enu.getPolicy().equals(value)) {
				return true;
			}
		} 
		return false;
	}
}
