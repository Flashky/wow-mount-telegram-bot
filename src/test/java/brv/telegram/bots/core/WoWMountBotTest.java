package brv.telegram.bots.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import brv.telegram.bots.configurations.properties.BotProperties;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
class WoWMountBotTest {

	private static PodamFactory podamFactory; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		podamFactory = new PodamFactoryImpl();
		
	}
	

	@BeforeEach
	void setUp() throws Exception {
		// TODO fill if needed
	}

	@Test
	void constructorTest() {
		
		// Prepare POJOs
		BotProperties botProperties = podamFactory.manufacturePojo(BotProperties.class);
		
		// Execute method
		WoWMountBot bot = new WoWMountBot(botProperties);
		
		// Assertions
		assertEquals(botProperties.getUsername(), bot.getBotUsername());
		assertEquals(botProperties.getToken(), bot.getBotToken());
	}
	
}
