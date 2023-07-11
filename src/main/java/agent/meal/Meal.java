package agent.meal;

import java.util.Collections;
import java.util.List;

public class Meal {
    private final String name;
    private final List<String> ingredients;

    public Meal(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }
}
