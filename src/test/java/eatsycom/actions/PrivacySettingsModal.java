package eatsycom.actions;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class PrivacySettingsModal extends UIInteractionSteps {

    //private final String applicationURL = "https://www.etsy.com/";
    private final By PRIVACY_SETTINGS_MODAL = By.cssSelector("#gdpr-single-choice-overlay");
    private final String ACCEPT_BUTTON = "//button[@data-gdpr-single-choice-accept='true']";
    private final String UPDATE_SETTING_BUTTON = "//button[@data-gdpr-open-full-settings]";
    private final String COOKIE_POLICY_LINK = "//a[.='Cookie Policy']";
    private final String PRIVACY_SETTINGS_MODAL_TEXT = "//div[@id='gdpr-single-choice-overlay']//p";

    @Step("Accept privacy settings")
    public void acceptPrivacySettings() {
        if(privacySettingsModalIsDisplayed()) {
            $(ACCEPT_BUTTON).click();
        }
    }

    @Step("Open Privacy Settings")
    public void openPrivacySettings() {
        if(privacySettingsModalIsDisplayed()) {
            $(UPDATE_SETTING_BUTTON).click();
        }
    }

    public void waitForPrivacyModalToDisappear() {
        withTimeoutOf(Duration.ofSeconds(3)).waitForElementsToDisappear(PRIVACY_SETTINGS_MODAL);
        //waitForRenderedElementsToDisappear(PRIVACY_SETTINGS_MODAL);
    }

    public boolean privacySettingsModalIsDisplayed() {
        return $(PRIVACY_SETTINGS_MODAL).isVisible();
    }

    public WebElementState privacySettingsModal() {
        return $(PRIVACY_SETTINGS_MODAL);
    }

    public String privacySettingsModalText() {
        return $(PRIVACY_SETTINGS_MODAL_TEXT).getText();
    }



}
