import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main class that demonstrates filtering, grouping, statistical analysis,
 * and income analysis of a list of SurveyParticipant objects.
 */
public class Main {

  public static void main(String[] args) {
    int N = 5;
    String cityToSkip = "Kyiv";

    List<SurveyParticipant> participants = SurveyParticipantGenerator.generateParticipants()
            .filter(participant -> !participant.getCity().equals(cityToSkip))
            .limit(500)
            .collect(Collectors.toList());
    for (SurveyParticipant participant : participants) {
      System.out.println(participant);
    }

    Map<String, List<SurveyParticipant>> groupedParticipants = participants.stream()
            .filter(participant -> participant.getBirthDate().isAfter(LocalDate.now().minusYears(100)))
            .collect(Collectors.groupingBy(SurveyParticipant::getCity));
    for (Map.Entry<String, List<SurveyParticipant>> entry : groupedParticipants.entrySet()) {
      System.out.println("Кількість '" + entry.getKey() + "': " + entry.getValue().size());
    }

    StatisticsData statistics = participants.stream()
            .collect(new SurveyParticipantStatisticsCollector());
    System.out.println(statistics);

    Map<String, Long> incomeAnalysis = IncomeAnalysisIQR.analyzeMonthlyIncome(participants);
    System.out.println(incomeAnalysis);
  }
}