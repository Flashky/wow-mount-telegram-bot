package brv.telegram.bots.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import brv.telegram.bots.configurations.properties.BotProperties;

@Service
public class WoWMountBot extends TelegramLongPollingBot {
	
	private String botUsername;
	private String botToken;
	
	@Autowired
	private WebClient webClient;
	
	public WoWMountBot(@Autowired BotProperties botProperties) {
		this.botUsername = botProperties.getUsername();
		this.botToken = botProperties.getToken();
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		
		String response = webClient.get()
				.uri("https://eu.api.blizzard.com/data/wow/mount/125")
				.header("Battlenet-Namespace", "static-eu")
				.retrieve()
				.bodyToMono(String.class)
				.block();
				
		System.out.println(response);

	}
	
	@Override
	public String getBotUsername() {
		return botUsername;
	}

	@Override
	public String getBotToken() {
		return botToken;
	}

}
