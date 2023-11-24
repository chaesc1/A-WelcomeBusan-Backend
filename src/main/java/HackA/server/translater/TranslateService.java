package HackA.server.translater;

public interface TranslateService {
	String translateByPapago(String text);

	void setLanguage(String lan);
}
