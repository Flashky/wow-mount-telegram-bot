package brv.telegram.bots.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	
	@Bean
	public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
																 OAuth2AuthorizedClientService authorizedClientService ) {
	
		// Provider
	    OAuth2AuthorizedClientProvider authorizedClientProvider = 
	            OAuth2AuthorizedClientProviderBuilder.builder()
	            .clientCredentials()
	            .build();
	    
	    // Create manager and attach provider
	    AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = 
	    		new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientService);
	
	    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
	
	    return authorizedClientManager;
	}
	
	@Bean
	public WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
	
	    ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = 
	            new ServletOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
	
	    oauth2Client.setDefaultClientRegistrationId("blizzard");
	    oauth2Client.setDefaultOAuth2AuthorizedClient(true);
	    
	    return WebClient.builder()
	            .apply(oauth2Client.oauth2Configuration())
	            .build();
	}
	
}
