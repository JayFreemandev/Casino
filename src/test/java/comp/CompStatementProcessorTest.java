package comp;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import comp.analyzer.CompStatementProcessor;
import comp.comp.CompTransaction;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("CompStatementProcessor 클래스 테스트")
public class CompStatementProcessorTest {

    @Nested
    @DisplayName("calculateTotalAmount 메소드 테스트")
    class CalculateTotalAmountTest {
        private CompStatementProcessor processor;
        private List<CompTransaction> transactions;

        @BeforeEach
        void setUp() {
            transactions = Arrays.asList(
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
            );
            processor = new CompStatementProcessor(transactions);
        }

        @Test
        @DisplayName("총 금액을 계산하여 예상 값과 비교")
        public void calculateTotalAmount() {
            // when
            double totalAmount = processor.calculateTotalAmount();

            // then
            assertEquals(-27000, totalAmount, 0.001);
        }
    }

    @Nested
    @DisplayName("calculateTotalInMonth 메소드 테스트")
    class CalculateTotalInMonthTest {
        private CompStatementProcessor processor;
        private List<CompTransaction> transactions;

        @BeforeEach
        void setUp() {
            transactions = Arrays.asList(
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
            );
            processor = new CompStatementProcessor(transactions);
        }

        @Test
        @DisplayName("월의 총 금액을 계산하여 예상 값과 비교")
        public void calculateTotalInMonth() {
            // when
            double totalInMay = processor.calculateTotalInMonth(Month.MAY);

            // then
            assertEquals(-27000, totalInMay, 0.001);
        }
    }

    @Nested
    @DisplayName("calculateTotalForCategory 메소드 테스트")
    class CalculateTotalForCategoryTest {
        private CompStatementProcessor processor;
        private List<CompTransaction> transactions;

        @BeforeEach
        void setUp() {
            transactions = Arrays.asList(
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 3), -22000, "마라탕"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 4), 5000, "커피"),
                    new CompTransaction(LocalDate.of(2023, Month.MAY, 5), -10000, "점심")
            );
            processor = new CompStatementProcessor(transactions);
        }

        @Test
        @DisplayName("카테고리의 총 금액을 계산하여 예상 값과 비교")
        public void calculateTotalForCategory() {
            // when
            double totalForFood = processor.calculateTotalForCategory("마라탕");

            // then
            assertEquals(-22000, totalForFood, 0.001);
        }
    }
}