package wavy.global.identity.controller;

import java.util.Arrays;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wavy.global.identity.domain.BaseResponse;
import wavy.global.identity.domain.PaymentRequest;
 
@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    private final String sharedKey = "SHARED_KEY";
    
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;
    
    
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public BaseResponse payM(@RequestParam(value = "key") String key) {
    	BaseResponse response = new BaseResponse();
    	
    	Keycloak kc = KeycloakBuilder.builder() //
				.serverUrl("http://localhost:8080/auth") //
				.realm("master")//
				.username("admin") //
				.password("admin") //
				.clientId("admin-cli") //
				//.clientSecret("501c0566-9356-4590-905a-62425e722d45")
				.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build()) //
				.build();		
		
		RealmRepresentation realm = new RealmRepresentation();
		realm.setRealm("demo1");		
		//kc.realms().create(realm);
		kc.realms().realm("demo1").remove();
		
		CredentialRepresentation credential = new CredentialRepresentation();
		credential.setType(CredentialRepresentation.PASSWORD);
		credential.setValue("test123");
		UserRepresentation user = new UserRepresentation();
		user.setUsername("testuser");
		user.setFirstName("Test");
		user.setLastName("User");
		user.setCredentials(Arrays.asList(credential));
		user.setEnabled(true) ;
		Response result = kc.realm("master").users().create(user);	
		
		if (result.getStatus() != 201) {
			System.err.println("Couldn't create user.");
			System.exit(0);
		}		
    	return response;
    }
 
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
        
        BaseResponse response = new BaseResponse();
        if(sharedKey.equalsIgnoreCase(key))
        {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            
            // Process the request
            // ....
            // Return success response to the client.
            
            response.setStatus(SUCCESS_STATUS);
            response.setCode(CODE_SUCCESS);
        }
        else
        {
            response.setStatus(ERROR_STATUS);
            response.setCode(AUTH_FAILURE);
        }
        return response;
    }
}