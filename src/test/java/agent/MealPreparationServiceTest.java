package agent;

import agent.meal.Meal;
import agent.meal.MealPreparationService;
import agent.meal.MealPreparationServiceImpl;
import agent.meal.MealType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("MealPreparationService 테스트")
public class MealPreparationServiceTest {
    @Test
    @DisplayName("치킨 식사 준비")
    public void testPrepareMeal() {
        // Given
        List<Meal> availableMeals = new ArrayList<>();
        List<String> ingredients = new ArrayList<>();
        ingredients.add("IngredientA");
        availableMeals.add(new Meal("Chicken", ingredients));
        MealPreparationService mealPreparationService = new MealPreparationServiceImpl(availableMeals);

        // When
        Optional<Meal> preparedMeal = mealPreparationService.prepareMeal(MealType.BREAKFAST, ingredients);

        // Then
        assertTrue(preparedMeal.isPresent());
        assertEquals("Chicken", preparedMeal.get().getName());
        assertEquals(2, preparedMeal.get().getIngredients().size());
        assertTrue(preparedMeal.get().getIngredients().contains("IngredientA"));
        assertTrue(preparedMeal.get().getIngredients().contains("IngredientB"));
    }
}