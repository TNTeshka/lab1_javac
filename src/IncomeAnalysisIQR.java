import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class for analyzing monthly income and identifying outliers.
 */
public class IncomeAnalysisIQR {

    public static Map<String, Long> analyzeMonthlyIncome(List<SurveyParticipant> participants) {
        List<Integer> incomes = participants.stream()
                .map(SurveyParticipant::getMonthlyIncome)
                .sorted()
                .toList();
        int Q1 = incomes.get((int) Math.ceil(0.25 * incomes.size()) - 1);
        int Q3 = incomes.get((int) Math.ceil(0.75 * incomes.size()) - 1);
        int IQR = Q3 - Q1;
        Map<Boolean, Long> result = participants.stream()
                .collect(Collectors.partitioningBy(
                        participant ->
                                participant.getMonthlyIncome() >= Q1 - 1.5 * IQR &&
                                        participant.getMonthlyIncome() <= Q3 + 1.5 * IQR,
                        Collectors.counting()
                ));
        Map<String, Long> finalResult = new HashMap<>();
        finalResult.put("data", result.get(true));
        finalResult.put("outliers", result.get(false));
        return finalResult;
    }
}