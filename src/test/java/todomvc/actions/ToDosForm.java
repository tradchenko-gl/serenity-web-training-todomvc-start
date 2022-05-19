package todomvc.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ToDosForm extends UIInteractionSteps {

    private final String applicationURL = "https://todomvc.com/examples/angularjs/#/";
    private final By toDoInputField = By.className("new-todo");
    private final By toDoTasks = By.xpath("//*[@class='todo-list']//label");
    private final String toDoTaskFor = "//*[@class='todo-list']//label[.='{0}']";
    private final String completeTaskCheckBox = "//div[@class='view'][contains(., '{0}' )]//*[@type='checkbox']";
    private final String filterButton = "//a[.='{0}']";
    private final String removeTaskButton = "//*[@class='todo-list']//*[contains(.,'{0}')]//button";



    public List<String> tasksList() {
        return findAll(toDoTasks).textContents();
    }

    @Step("Navigate to ToDo list page")
    public void openToDoList() {
        openUrl(applicationURL);
    }

    @Step("Enter a task - {0}")
    public void enterTaskWithName(String taskName) {
        $(toDoInputField).sendKeys(taskName + "\n");
    }

    @Step("Complete task - {0}")
    public void completeTaskFor(String taskName) {
        $(completeTaskCheckBox, taskName).click();
    }

    @Step("Filter tasks by {0}")
    public void filterTasksBy(FilterCriteria filterCriteria) {
        $(filterButton, filterCriteria.getFilterCriteria()).click();
    }

    public WebElement removeIcon(String taskName) {
        return $(removeTaskButton, taskName);
    }

    @Step("Remove {0} task from To Do list")
    public void removeTak(String taskName) {
        $(toDoTaskFor, taskName).click();
        $(removeTaskButton, taskName).click();
    }


    public void enterTasks(String[] tasks) {
        for(String task : tasks) {
            enterTaskWithName(task);
        }
    }
}
