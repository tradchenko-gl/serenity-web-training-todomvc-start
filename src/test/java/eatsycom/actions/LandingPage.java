package eatsycom.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("https://www.etsy.com/")
public class LandingPage extends UIInteractionSteps {
    private final String APPLICATION_URL = "https://www.etsy.com/";

    @Step("Open home page")
    public void openHomePage(){
        openUrl(APPLICATION_URL);
    }

}
