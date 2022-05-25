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
public class WhenAcceptingPrivacyPolicyTests {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    PrivacySettingsModal privacySettingsModal;

    @Steps
    UpdateSettingsPage updateSettingsPage;

    @Steps
    LandingPage landingPage;

    @Before
    public void openPage() {
        landingPage.openHomePage();
    }

    @Test
    public void whenAcceptingPrivacyPolicy() {
        privacySettingsModal.privacySettingsModal().shouldBeVisible();
//        Serenity.reportThat("Verify that privacy settings modal is displayed",
//                () -> assertThat(privacySettingsModal.privacySettingsModalIsDisplayed()).isEqualTo(true));
        privacySettingsModal.acceptPrivacySettings();
        privacySettingsModal.waitForPrivacyModalToDisappear();
        privacySettingsModal.privacySettingsModal().shouldNotBeVisible();
//        Serenity.reportThat("Verify that privacy settings modal is closed",
//                ()-> assertThat(privacySettingsModal.privacySettingsModalIsDisplayed()).isEqualTo(false));
    }

    @Test
    public void whenPrivacySettingsModalIsDisplayed() {
        String text = "In order to give you the best experience, we use cookies and similar technologies for performance, analytics, personalization, advertising, and to help our site function. Want to know more? Read our Cookie Policy. You can change your preferences any time in your Privacy Settings.";
        //String text = "This is a test text";
        privacySettingsModal.privacySettingsModal().shouldBeVisible();
        Serenity.reportThat("Verify that valid text is displayed",
                () -> assertThat(privacySettingsModal.privacySettingsModalText()).isEqualTo(text));
    }

    @Test
    public void whenClickingUpdateSettings() {
        privacySettingsModal.privacySettingsModal().shouldBeVisible();
        privacySettingsModal.openPrivacySettings();
        updateSettingsPage.waitForUpdatePrivacySettingsModalToAppear();
        //privacySettingsModal.privacySettingsModal().shouldNotBeVisible();
        //updateSettingsPage.updatePrivacySettingsModal().shouldBeVisible();
        Serenity.reportThat("Verify that Update Settings page is displayed",
                () -> assertThat(updateSettingsPage.updatePrivacySettingsModal().shouldBeVisible()));


    }

}
