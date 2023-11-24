package HackA.server.translater;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translate")
public class TranslateController {

	private final TranslateService translateService;

	@Autowired
	public TranslateController(TranslateService translateService) {
		this.translateService = translateService;
	}

	@PostMapping("/papago")
	public String translateByPapago(@RequestBody TranslateText translateText) {
		translateService.setLanguage(translateText.getTargetLan());

		String translatedText = translateService.translateByPapago(translateText.getInputText());
		System.out.println(translatedText);

		return "{\"translatedText\": \"" + translatedText + "\"}";
	}



}
