package eatsycom.actions;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class UpdateSettingsPage extends UIInteractionSteps {

    private final By UPDATE_PRIVACY_SETTINGS_MODAL = By.cssSelector("#gdpr-privacy-settings");
    private final String PRIVACY_SETTINGS_MODAL_TITLE = "#gdpr-full-settings-overlay-title";
    private final String DONE_BUTTON = "//button//p[.='Done']";
    private final String SITE_CUSTOMIZATION_LABEL = "//label[contains(@class, 'wt-text-caption') and @for='personalization_consent']";
    private final String SITE_CUSTOMIZATION_CONTROL = "//label[@class='wt-switch__toggle' and @for='personalization_consent']";
    private final String PERSONALIZED_ADVERTISING_LABEL = "//label[contains(@class, 'wt-text-caption') and @for='third_party_consent']";
    private final String PERSONALIZED_ADVERTISING_CONTROL = "//label[@class='wt-switch__toggle' and @for='third_party_consent']";

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

    public String getSiteCustomizationValue() {
        return $(SITE_CUSTOMIZATION_LABEL).getText();
    }

    public String getPersonalizedAdvertisingLabelValue() {
        return $(PERSONALIZED_ADVERTISING_LABEL).getText();
    }

    @Step("Set Site Customization to {0}")
    public void setSiteCustomizationTo(String value) {
        if(value!="On" && value !="Off") {
            System.out.println("Site customization should be On or Off");
        } else {
            String actualValue = getSiteCustomizationValue();
            if (actualValue != value) {
                $(SITE_CUSTOMIZATION_CONTROL).click();
            }
        }
    }

    @Step("Set personalized advertising to {0}")
    public void setPersonalizedAdvertisingTo(String value) {
        if(value!="On" && value !="Off") {
            System.out.println("Personalised Advertising should be On or Off");
        } else {
            String actualValue = getPersonalizedAdvertisingLabelValue();
            if (actualValue != value) {
                $(PERSONALIZED_ADVERTISING_CONTROL).click();
            }
        }
    }
}
