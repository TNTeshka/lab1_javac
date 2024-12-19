import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * Collector for calculating basic statistics of SurveyParticipant monthly income.
 */
public class SurveyParticipantStatisticsCollector implements
        Collector<SurveyParticipant, List<Integer>, StatisticsData> {

    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, SurveyParticipant> accumulator() {
        return (accumulator, participant) -> accumulator.add(participant.getMonthlyIncome());
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, StatisticsData> finisher() {
        return incomes -> {
            int min = incomes.stream()
                    .min(Integer::compare).orElse(0);
            int max = incomes.stream()
                    .max(Integer::compare).orElse(0);
            double avg = incomes.stream()
                    .mapToDouble(Integer::doubleValue)
                    .average().orElse(0);
            double stdDev = Math.sqrt(incomes.stream()
                    .mapToDouble(income -> Math.pow(income - avg, 2))
                    .average().orElse(0));
            return new StatisticsData(min, max, avg, stdDev);
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> characteristics = new HashSet<>();
        characteristics.add(Characteristics.CONCURRENT);
        return characteristics;
    }
}