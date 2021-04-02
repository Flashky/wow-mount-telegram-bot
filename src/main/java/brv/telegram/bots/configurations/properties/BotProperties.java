package brv.telegram.bots.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
public class BotProperties {
	
	private String token;
	private String username;

}