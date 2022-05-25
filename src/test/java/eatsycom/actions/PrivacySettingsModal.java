package eatsycom.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://www.etsy.com/")
public class PrivacySettingsModal extends UIInteractionSteps {

    //private final String applicationURL = "https://www.etsy.com/";
    private final String PRIVACY_SETTINGS_MODAL = "#gdpr-single-choice-overlay";
    private final String ACCEPT_BUTTON = "//button[@data-gdpr-single-choice-accept='true']";
    private final String UPDATE_SETTING_BUTTON = "//button[@data-gdpr-open-full-settings]";
    private final String COOKIE_POLICY_LINK = "//a[.='Cookie Policy']";

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

    public boolean privacySettingsModalIsDisplayed() {
        return $(PRIVACY_SETTINGS_MODAL).isVisible();
    }



}
