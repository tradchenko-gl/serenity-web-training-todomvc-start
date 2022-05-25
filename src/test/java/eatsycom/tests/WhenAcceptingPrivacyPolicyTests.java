package eatsycom.tests;

import eatsycom.actions.LandingPage;
import eatsycom.actions.PrivacySettingsModal;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenAcceptingPrivacyPolicyTests {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    PrivacySettingsModal privacySettingsModal;

    @Steps
    LandingPage landingPage;

    @Test
    public void whenAcceptingPrivacyPolicy() {
        landingPage.openHomePage();
        Serenity.reportThat("Verify that privacy settings modal is displayed",
                () -> assertThat(privacySettingsModal.privacySettingsModalIsDisplayed()).isEqualTo(true));
        privacySettingsModal.acceptPrivacySettings();
        Serenity.reportThat("Verify that privacy settings modal is closed",
                ()-> assertThat(privacySettingsModal.privacySettingsModalIsDisplayed()).isEqualTo(false));
    }

}
