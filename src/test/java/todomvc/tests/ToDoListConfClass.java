package todomvc.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.ToDosForm;

@RunWith(SerenityRunner.class)
public class ToDoListConfClass {
    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    ToDosForm toDosForm;

    @Before
    public void openPage() {
        toDosForm.openToDoList();
    }
}
