package brv.telegram.bots.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "bot")
@Getter
@Setter
public class BotConfig {
	
	private String token;
	private String username;

}