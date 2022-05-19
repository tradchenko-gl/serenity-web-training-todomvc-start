package todomvc.tests;

import net.serenitybdd.core.Serenity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenDeletingATask extends ToDoListConfClass{


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