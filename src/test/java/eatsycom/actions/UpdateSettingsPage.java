package eatsycom.actions;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class UpdateSettingsPage extends UIInteractionSteps {

    private final By UPDATE_PRIVACY_SETTINGS_MODAL = By.cssSelector("#gdpr-privacy-settings");
    private final String PRIVACY_SETTINGS_MODAL_TITLE = "#gdpr-full-settings-overlay-title";
    private final String DONE_BUTTON = "//button//p[.='Done']";


    public String getPrivacySettingsModalTitle() {
        return $(PRIVACY_SETTINGS_MODAL_TITLE).getText();
    }

    public boolean privacySettingsModalIsVisible(){
        return $(UPDATE_PRIVACY_SETTINGS_MODAL).isVisible();
    }

    public WebElementState updatePrivacySettingsModal() {
        return $(UPDATE_PRIVACY_SETTINGS_MODAL);
    }

    public void waitForUpdatePrivacySettingsModalToAppear() {
        withTimeoutOf(Duration.ofSeconds(3))
                .waitFor(
                        ExpectedConditions.visibilityOf($(UPDATE_PRIVACY_SETTINGS_MODAL))
                );
    }
}
