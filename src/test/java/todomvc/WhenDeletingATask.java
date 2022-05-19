package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import todomvc.actions.ToDosForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDeletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    ToDosForm toDosForm;

    @Before
    public void openPage() {
        toDosForm.openToDoList();
    }

    // TODO: Exercise 5
    @Test
    public void deletedItemsShouldDisappearFromTheList() {
        String[] tasks = {"Feed The Cat", "Walk the dog"};
        int numberOfTasksAdded = tasks.length;
        // Add "Feed the cat" and "Walk the dog" to the list
        toDosForm.enterTasks(tasks);
        // Delete "Feed the cat"
        toDosForm.removeTak(tasks[0]);

        // Check that only "Walk the dog" appears
        Serenity.reportThat("Verify that tasks list contains only " + tasks[1],
                () -> assertThat(toDosForm.tasksList()).containsOnly(tasks[1]));

    }
}