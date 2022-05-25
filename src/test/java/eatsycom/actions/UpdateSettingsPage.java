package eatsycom.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class UpdateSettingsPage extends UIInteractionSteps {

    private final String PRIVACY_SETTINGS_MODAL = "#gdpr-privacy-settings";
    private final String PRIVACY_SETTINGS_MODAL_TITLE = "#gdpr-full-settings-overlay-title";
    private final String DONE_BUTTON = "//button//p[.='Done']";


    public String getPrivacySettingsModalTitle() {
        return $(PRIVACY_SETTINGS_MODAL_TITLE).getText();
    }

    public boolean privacySettingsModalIsVisible(){
        return $(PRIVACY_SETTINGS_MODAL).isVisible();
    }
}
