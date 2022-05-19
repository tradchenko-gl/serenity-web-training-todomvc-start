package todomvc.tests;

import net.serenitybdd.core.Serenity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenAddingTasks extends ToDoListConfClass {

    // TODO: Exercise 1
    @Test
    public void addingASingleTask() {
        // Add "Feed The Cat" to the list
        String task1 = "Feed the cat";
        toDosForm.enterTaskWithName(task1);
        // Check that tasks list size is equal to 1
        Serenity.reportThat("Verify that task list size is equal to 1",
                () -> assertThat(toDosForm.tasksList().size()).isEqualTo(1));
        // Check that "Feed The Cat" appears in the list
        Serenity.reportThat("Verify that entered task appears in the list",
                () -> assertThat(toDosForm.tasksList()).contains(task1));
    }


    // TODO: Exercise 2
    @Test
    public void addingMultipleTasks() {
        String[] tasks = {"Feed The Cat", "Walk the dog"};
        int numberOfTasksAdded = tasks.length;

        // Add "Feed The Cat" and "Walk the dog" to the list
       toDosForm.enterTasks(tasks);

       Serenity.reportThat("Verify that task list size is equal to " + numberOfTasksAdded,
                () -> assertThat(toDosForm.tasksList().size()).isEqualTo(numberOfTasksAdded));
        // Check that they all appear in the list
       for(String task : tasks) {
           Serenity.reportThat("Verify that entered task appears in the list - " + task,
                   ()->assertThat(toDosForm.tasksList()).contains(task));
       }

    }

}
