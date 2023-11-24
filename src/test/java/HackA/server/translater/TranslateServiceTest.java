package HackA.server.translater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TranslateServiceTest {

	@Autowired
	TranslateService translateService;

	@BeforeEach
	public void setUp() {
		// Set the language to English before each test
		translateService.setLanguage("en");
	}

	@Test
	public void testTranslateByPapago() {
		// Perform translation
		String result = translateService.translateByPapago("안녕하세요");

		// Assert the result based on your expectations
		// For example, you might expect the translation result in a certain format or language
		assertEquals("Hello", result);
	}
}
