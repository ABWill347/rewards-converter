import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }

    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 150.0;
        RewardValue reward = new RewardValue(cashValue);
        int milesValue = reward.getMilesValue();
        assertEquals((int) (cashValue / RewardValue.conversionRate), milesValue);
    }

    @Test
    void convert_from_miles_to_cash() {
        int milesValue = 100000;
        RewardValue reward = new RewardValue(milesValue);
        double cashValue = reward.getCashValue();
        assertEquals(milesValue * RewardValue.conversionRate, cashValue, 0.0001);
    }
}