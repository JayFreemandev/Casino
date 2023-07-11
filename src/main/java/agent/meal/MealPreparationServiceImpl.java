package agent.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MealPreparationServiceImpl implements MealPreparationService {
    private final List<Meal> availableMeals;

    public MealPreparationServiceImpl(List<Meal> availableMeals) {
        this.availableMeals = availableMeals;
    }

    @Override
    public Optional<Meal> prepareMeal(MealType mealType, List<String> ingredients) {

        Meal chickenMeal = availableMeals.stream()
                .filter(meal -> meal.getName().equalsIgnoreCase(MealType.BREAKFAST.name()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("죄송합니다 치킨을 준비 못했습니다.."));

        List<String> newIngredients = new ArrayList<>(chickenMeal.getIngredients());
        newIngredients.addAll(ingredients);

        return Optional.of(new Meal(chickenMeal.getName(), newIngredients));
    }
}
