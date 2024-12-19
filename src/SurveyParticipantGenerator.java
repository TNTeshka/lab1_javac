import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates random SurveyParticipant objects using Stream API.
 */
public class SurveyParticipantGenerator {

    private static final String[] NAMES = {"Ivan", "Petro", "Olena", "Oksana", "Andriy"};
    private static final String[] SURNAMES = {"Shevchenko", "Kovalenko", "Boyko", "Tkachenko", "Bondarenko"};
    private static final String[] CITIES = {"Kyiv", "Lviv", "Odessa", "Kharkiv", "Dnipro"};
    private static final Random RANDOM = new Random();

    public static Stream<SurveyParticipant> generateParticipants() {
        return Stream.generate(() -> {
            SurveyParticipant participant = new SurveyParticipant();
            participant.setName(getRandomName());
            participant.setSurname(getRandomSurname());
            participant.setBirthDate(LocalDate.now().minusYears(18 + RANDOM.nextInt(42)));
            participant.setCity(getRandomCity());
            participant.setMonthlyIncome(5000 + RANDOM.nextInt(45000));
            return participant;
        });
    }

    private static String getRandomName() {
        return NAMES[RANDOM.nextInt(NAMES.length)];
    }

    private static String getRandomSurname() {
        return SURNAMES[RANDOM.nextInt(SURNAMES.length)];
    }

    private static String getRandomCity() {
        return CITIES[RANDOM.nextInt(CITIES.length)];
    }
}