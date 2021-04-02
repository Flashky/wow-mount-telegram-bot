package brv.telegram.bots.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import brv.telegram.bots.configurations.properties.BotProperties;

@Component
public class WoWMountBot extends TelegramLongPollingBot {
	
	private String botUsername;
	private String botToken;
	
	public WoWMountBot(@Autowired BotProperties botProperties) {
		this.botUsername = botProperties.getUsername();
		this.botToken = botProperties.getToken();
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub

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
