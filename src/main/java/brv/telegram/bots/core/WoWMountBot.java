package brv.telegram.bots.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import brv.telegram.bots.config.BotConfig;

@Component
public class WoWMountBot extends TelegramLongPollingBot {
    
	@Autowired
	private BotConfig config;
	
	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getBotUsername() {
		return config.getUsername();
	}

	@Override
	public String getBotToken() {
		return config.getToken();
	}

}
