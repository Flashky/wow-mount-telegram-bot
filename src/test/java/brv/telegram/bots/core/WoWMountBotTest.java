package brv.telegram.bots.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import brv.telegram.bots.configurations.properties.BotProperties;

@RunWith(MockitoJUnitRunner.class)
class WoWMountBotTest {

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void constructorTest() {
		
		// Prepare POJOs
		BotProperties botProperties = new BotProperties();
		botProperties.setUsername("username");
		botProperties.setToken("token");
		
		// Execute method
		WoWMountBot bot = new WoWMountBot(botProperties);
		
		// Assertions
		assertEquals("username", bot.getBotUsername());
		assertEquals("token", bot.getBotToken());
	}
	
}
