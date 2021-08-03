package com.testvagrant.ekam.commons.tests.cache;

import com.testvagrant.ekam.commons.locale.LocaleClient;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetSystemProperty;

@SetSystemProperty(key = "locale.dir", value = "locale_main")
public class LocaleTests {

  private final LocaleClient client;

  public LocaleTests() {
    client = new LocaleClient();
  }

  @Test
  @SetSystemProperty(key = "locale", value = "en")
  public void shouldValidateEnLocale() {
    Locale sample_locales = client.getLocale("sample_locales", Locale.class);
    Assertions.assertEquals(sample_locales.locale, "English");
  }

  @Test
  @SetSystemProperty(key = "locale", value = "fr")
  public void shouldValidateFrLocale() {
    Locale sample_locales = client.getLocale("sample_locales", Locale.class);
    Assertions.assertEquals(sample_locales.locale, "French");
  }

  @Test
  @SetSystemProperty(key = "locale", value = "ka")
  public void shouldValidateKaTranslation() {
    Locale sample_locales = client.getLocale("translations", Locale.class);
    Assertions.assertEquals(
        sample_locales.locale,
        "ನಿಮ್ಮ ಬ್ರೌಸಿಂಗ್, ಶಾಪಿಂಗ್ ಹಾಗೂ ಸಂವಹನಕ್ಕಾಗಿ ನಿಮಗೆ ಸಹಾಯ ಮಾಡಲು ಮಾಹಿತಿಯನ್ನು ಅನುವಾದಿಸುತ್ತೇವೆ. ನಾವು Amazon.in ನಲ್ಲಿ ಕನ್ನಡ ಭಾಷೆ ಅನುಭವವನ್ನು ನಿರಂತರವಾಗಿ ಸುಧಾರಿಸುತ್ತಿದ್ದೇವೆ. ಈ ಅನುವಾದಗಳ ಬಗ್ಗೆ ನಿಮಗೆ ಪ್ರತಿಕ್ರಿಯೆ ನೀಡಬೇಕು ಎಂದೆನಿಸಿದರೆ, ದಯವಿಟ್ಟು ಗ್ರಾಹಕರ ಸಹಾಯ ಕೇಂದ್ರವನ್ನು ಸಂಪರ್ಕಿಸಿ. ಅನುವಾದಗಳನ್ನು ಅನುಕೂಲಕ್ಕಾಗಿ ಮಾತ್ರ ಒದಗಿಸಲಾಗಿರುತ್ತದೆ ಎಂಬುದು ನಿಮ್ಮ ಗಮನಕ್ಕಿರಲಿ ಮತ್ತು ಬಳಕೆಯ ನಿಬಂಧನೆಗಳು ಸೇರಿದಂತೆ Amazon.in ನ ಇಂಗ್ಲೀಷ್‌ ಆವೃತ್ತಿಯೇ ನಿರ್ಣಾಯಕವಾದದ್ದು.");
  }

  @Test
  @SetSystemProperty(key = "locale", value = "tn")
  public void shouldValidateTamilTranslation() {
    Locale sample_locales = client.getLocale("translations", Locale.class);
    Assertions.assertEquals(
        sample_locales.locale,
        "நீங்கள் உலாவுவதற்கும் ஷாப்பிங் செய்வதற்கும் விவரங்களைப் பரிமாற்றுவதற்கும் உதவிட தகவல்களை மொழிபெயர்ப்போம். Amazonனில் தமிழ் மொழி அனுபவத்தைத் தொடர்ந்து மேம்படுத்தி வருகிறோம். இந்த மொழிபெயர்ப்புகள் குறித்து நீங்கள் கருத்துத் தெரிவிக்க விரும்பினால், வாடிக்கையாளர் ஆதரவு மையத்தைத் தொடர்புகொள்ளவும். உங்கள் வசதிக்காக மட்டுமே மொழிபெயர்ப்புகள் வழங்கப்படுகின்றன. எங்கள் பயன்பாட்டு நிபந்தனைகள் உட்பட Amazon.inனின் ஆங்கிலப் பதிப்பே திட்டவட்டமான பதிப்பாகும்.");
  }

  @Getter
  @Setter
  private static class Locale {
    private String locale;
  }
}
