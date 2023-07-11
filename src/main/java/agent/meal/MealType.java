package agent.meal;

public enum MealType {
    BREAKFAST("Chicken"),
    LUNCH("Chicken"),
    DINNER("Chicken");

    private final String name;

    MealType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
