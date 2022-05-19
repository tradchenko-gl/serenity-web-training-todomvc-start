package todomvc.actions;

public enum FilterCriteria {
    ALL("All"),
    ACTIVE("Active"),
    COMPLETED("Completed");

    private final String filterCriteria;

    FilterCriteria(String filterCriteria) {
        this.filterCriteria = filterCriteria;
    }

    public String getFilterCriteria() {
        return this.filterCriteria;
    }
}
