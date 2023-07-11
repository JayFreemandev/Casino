package agent.agent;

import agent.exchange.ExchangeService;
import agent.meal.MealPreparationService;
import agent.reservation.ReservationService;

public class Agent {
    private final String agentName;
    private final ReservationService reservationService;
    private final ExchangeService exchangeService;
    private final MealPreparationService mealPreparationService;

    public Agent(String agentName, ReservationService reservationService, ExchangeService exchangeService, MealPreparationService mealPreparationService) {
        this.agentName = agentName;
        this.reservationService = reservationService;
        this.exchangeService = exchangeService;
        this.mealPreparationService = mealPreparationService;
    }

    public String getAgentName() {
        return agentName;
    }
}
