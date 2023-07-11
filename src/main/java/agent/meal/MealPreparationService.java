package agent.meal;

import java.util.List;
import java.util.Optional;

public interface MealPreparationService {
    Optional<Meal> prepareMeal(MealType mealType, List<String> ingredients);
}
