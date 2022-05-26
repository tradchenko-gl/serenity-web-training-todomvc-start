package eatsycom.tests;

import eatsycom.actions.LandingPage;
import eatsycom.actions.PrivacySettingsModal;
import eatsycom.actions.UpdateSettingsPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenUpdatingPrivacySettingsTests {
    @Managed(driver = "firefox")
    WebDriver driver;

    LandingPage landingPage;
    PrivacySettingsModal privacySettingsModal;

    @Steps
    UpdateSettingsPage updateSettingsPage;

    @Before
    public void openPage() {
        landingPage.openHomePage();
        privacySettingsModal.openPrivacySettings();
        updateSettingsPage.waitForUpdatePrivacySettingsModalToAppear();
    }

    @Test
    public void whenUpdatingSiteCustomizationSettings() {
        Serenity.reportThat("Verify that Site Customization is set to Off",
                () -> assertThat(updateSettingsPage.getSiteCustomizationValue()).isEqualTo("Off"));
        updateSettingsPage.setSiteCustomizationTo("On");
        Serenity.reportThat("Verify that Site Customization is set to On",
                () -> assertThat(updateSettingsPage.getSiteCustomizationValue()).isEqualTo("On"));
    }

    @Test
    public void whenUpdatingPersonalizedAdvertisingSettings() {
        Serenity.reportThat("Verify that Personalized Advertising is set to Off",
                () -> assertThat(updateSettingsPage.getPersonalizedAdvertisingLabelValue()).isEqualTo("Off"));
        updateSettingsPage.setPersonalizedAdvertisingTo("On");
        Serenity.reportThat("Verify that Personalized Advertising is set to On",
                () -> assertThat(updateSettingsPage.getPersonalizedAdvertisingLabelValue()).isEqualTo("On"));
    }

}
