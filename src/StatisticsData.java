/**
 * Holds statistical data for monthly income of survey participants.
 */
public record StatisticsData(
        int minIncome,
        int maxIncome,
        double avgIncome,
        double stdDeviation) {
}