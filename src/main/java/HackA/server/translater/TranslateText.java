package HackA.server.translater;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
public class TranslateText {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String inputText;
	private String targetLan = "ko";

	public String getInputText() {
		return inputText;
	}
	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getTargetLan() {
		return targetLan;
	}

	public void setTargetLan(String targetLan) {
		this.targetLan = targetLan;
	}

	@Override
	public String toString() {
		return "TranslateText{" +
			"inputText='" + inputText + '\'' +
			", targetLan='" + targetLan + '\'' +
			'}';
	}
}
