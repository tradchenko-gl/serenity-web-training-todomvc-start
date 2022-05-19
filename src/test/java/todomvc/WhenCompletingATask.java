package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.ToDosForm;
import static org.assertj.core.api.Assertions.assertThat;

import static todomvc.actions.FilterCriteria.*;

@RunWith(SerenityRunner.class)
public class WhenCompletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    ToDosForm toDosForm;

    @Before
    public void openPage() {
        toDosForm.openToDoList();
    }

    // TODO: Exercise 3
    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        String[] tasks = {"Feed The Cat", "Walk the dog"};
        int numberOfTasksAdded = tasks.length;

        // Add "Feed The Cat" and "Walk the dog" to the list
       toDosForm.enterTasks(tasks);
        // Complete "Feed the cat"
        toDosForm.completeTaskFor(tasks[0]);
        // Filter by "Active"
        toDosForm.filterTasksBy(ACTIVE);
        // Check that only "Walk the dog" appears
        Serenity.reportThat("Verify that tasks list contains only " + tasks[1],
                () -> assertThat(toDosForm.tasksList()).containsOnly(tasks[1]));

    }

    // TODO: Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        String[] tasks = {"Feed The Cat", "Walk the dog"};
        int numberOfTasksAdded = tasks.length;

        // Add "Feed The Cat" and "Walk the dog" to the list
        toDosForm.enterTasks(tasks);
        // Complete "Feed the cat"
        toDosForm.completeTaskFor(tasks[0]);

        // Filter by "Completed"
        toDosForm.filterTasksBy(COMPLETED);
        // Check that only "Feed the cat" appears
        Serenity.reportThat("Verify that tasks list contains only " + tasks[0],
                () -> assertThat(toDosForm.tasksList()).containsOnly(tasks[0]));
    }
}
