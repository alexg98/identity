package wavy.global.identity.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wavy.global.identity.domain.AuthRequest;
import wavy.global.identity.domain.AuthResponse;

@RestController
@RequestMapping(value = "/auth")
public class LoginController {

	@PostMapping
	public AuthResponse create(@RequestBody AuthRequest authRequest) {		
		
		try {			
			return exampleLogin(authRequest);			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		/*Keycloak keycloak = Keycloak.getInstance(
			    "http://localhost:8080/auth",
			    "basic",
			    "alexg98",
			    "admin",
			    "account");
			RealmRepresentation realm = keycloak.realm("basic").toRepresentation();
			
		Keycloak keycloak2 = Keycloak.getInstance(
				URL.val(),
				authRequest.getRealmName(),      
				authRequest.getUserName(),       
				authRequest.getPassword(),       
				authRequest.getClientId()); 
		   		    
		Keycloak keycloak = KeycloakBuilder.builder()
				.serverUrl("http://localhost:8080/auth")
				.realm("basic")
				.username("alexg98")
				.password("admin")
				.clientId("account")
				.clientSecret("6aa35c4d-662b-44a2-85c7-f24082fab957")
				.build();
		
		//RealmRepresentation realm = keycloak.realm("basic").toRepresentation();
		
		Keycloak keycloak = KeycloakBuilder.builder()
				.serverUrl(URL.val())
				.realm(authRequest.getRealmName())
				.username(authRequest.getUserName())
				.password(authRequest.getPassword())
				.clientId(authRequest.getClientId())
				.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
				.build();
		
		RealmRepresentation realm = keycloak.realm(authRequest.getRealmName()).toRepresentation();
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setAuthToken(keycloak.tokenManager().getAccessTokenString());
		authResponse.setOldLifespan(realm.getAccessTokenLifespan());
		authResponse.setSessionState(keycloak.tokenManager().getAccessToken().getSessionState());
		return authResponse;	
		*/	
	}	
	
	public AuthResponse exampleLogin (AuthRequest authRequest) throws Exception{
		String uri = "http://localhost:8080/auth/realms/"+authRequest.getRealmName() +"/protocol/openid-connect/token";
		
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(uri);
        post.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
        
        List<BasicNameValuePair> urlParameters = new ArrayList<BasicNameValuePair>();
        urlParameters.add(new BasicNameValuePair("grant_type", "password"));
        urlParameters.add(new BasicNameValuePair("client_id", authRequest.getClientId() ));
        urlParameters.add(new BasicNameValuePair("username", authRequest.getUserName() ));
        urlParameters.add(new BasicNameValuePair("password", authRequest.getPassword()));        
        post.setEntity(new UrlEncodedFormEntity(urlParameters));   
        
        HttpResponse response = client.execute(post);
        
        AuthResponse authResponse = new AuthResponse();
        authResponse.setCodeResponse(response.getStatusLine().getStatusCode());
        if(authResponse.getCodeResponse() == HttpStatus.NOT_FOUND.value() ) {
        	return authResponse;
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line1 = "";
        while ((line1 = rd.readLine()) != null) {
            result.append(line1);
        }  
        
        JSONObject jsonObject = new JSONObject(result.toString());
        
        if(authResponse.getCodeResponse() == HttpStatus.OK.value()  ) {
        	authResponse.setAuthToken( (String)jsonObject.get("access_token")  );
            authResponse.setRefreshExpiresIn((int)jsonObject.get("refresh_expires_in"));
            authResponse.setNotBeforePolicy((int)jsonObject.get("not-before-policy"));
            authResponse.setScope( (String)jsonObject.get("scope"));
            authResponse.setTokenType((String)jsonObject.get("token_type"));
            authResponse.setSessionState((String)jsonObject.get("session_state"));
            authResponse.setRefreshExpiresIn((int)jsonObject.get("expires_in"));
        }else {
        	authResponse.setMessage((String)jsonObject.get("error_description"));        	
        }        
        return authResponse;
	}
}