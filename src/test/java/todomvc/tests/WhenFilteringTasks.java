package todomvc.tests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import todomvc.actions.FilterCriteria;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.*;
import static todomvc.actions.FilterCriteria.*;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class WhenFilteringTasks extends ToDoListConfClass{

    private FilterCriteria filterCriteria;
    private List<String> toDoList;
    private String itemToComplete;
    private List<String> filteredItems;

    public WhenFilteringTasks(FilterCriteria filterCriteria, List<String> toDoList, String itemToComplete, List<String> filteredItems) {
        this.filterCriteria = filterCriteria;
        this.toDoList = toDoList;
        this.itemToComplete = itemToComplete;
        this.filteredItems = filteredItems;
    }

    @TestData(columnNames = "Filter by, ToDo items, Competed item, Filtered items")
    public static Collection<Object[]> testData(){
        return asList(new Object[][] {
                {ACTIVE, asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Walk the dog")},
                {COMPLETED, asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat")},
                {ALL, asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat","Walk the dog")}
        });
    }

    @Test
    public void whenFilteringByActiveTasks() {
        toDosForm.openToDoList();
        toDosForm.enterTasks(toDoList);
        toDosForm.completeTaskFor(itemToComplete);
        toDosForm.filterTasksBy(filterCriteria);
        Serenity.reportThat("Verify that when filtered by " + filterCriteria.getFilterCriteria() + "the following tasks are displayed" + filteredItems.toString(),
                () -> assertThat(toDosForm.tasksList()).containsExactlyElementsOf(filteredItems));

    }

}
