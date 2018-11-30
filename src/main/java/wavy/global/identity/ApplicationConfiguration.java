package wavy.global.identity;

import static wavy.global.identity.utilities.EnumKeyCloakConfig.*;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import wavy.global.identity.utilities.ModelMapperUtil;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "wavy.global.identity")
public class ApplicationConfiguration {
 
	@Bean
    public Keycloak transferService() {
		return KeycloakBuilder.builder()
		.serverUrl(URL.val())
		.realm(REALM_MASTER.val())
		.username(USER.val())
		.password(PASSWORD.val())
		.clientId(CLIENT_ID.val())
		.resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
		.build();
    } 
	
	@Bean
	public ModelMapperUtil modelMapper() {
		return new ModelMapperUtil();
	}
}