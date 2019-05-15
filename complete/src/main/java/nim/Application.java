package nim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    // TODO change application URL from "greeting" to something more correspondent
    static final String URL = "http://localhost:8080/greeting?matchesOnTable={matchesOnTableValue}&matchesTaken={matchesTakenValue}";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static Move takeMatches(final RestTemplate restTemplate, final int matchesOnTable, final int matchesTaken) {
        Map<String, Object> uriParams = new HashMap<>();
        uriParams.put("matchesOnTableValue", matchesOnTable);
        uriParams.put("matchesTakenValue", matchesTaken);
        return restTemplate.getForObject(URL, Move.class, uriParams);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {

            final int initialMatches = 13;
            Scanner in = new Scanner(System.in);

            int matchesOnTable = initialMatches;
            while (matchesOnTable > 1) {
                System.out.println("\nThere are " + matchesOnTable + " matches on the table.");
                System.out.println("Your turn! Please take up to 3 matches!");

                int userInput = 0;
                if (in.hasNext("\\d{1}")) { // what if huge value taken?
                    userInput = in.nextInt();
                } else if (in.hasNext()) {
                    in.next();
                    System.out.println("Invalid input! Try again!");
                }

                Move compAnswer = takeMatches(restTemplate, matchesOnTable, userInput);
                if (compAnswer.getException() != null) {
                    System.out.println(compAnswer.getException().getMessage());
                } else {
                    matchesOnTable = compAnswer.getMatchesOnTable();
                    System.out.println("Computer took " + compAnswer.getTakenMatches() + " matches.\n");

                    if (compAnswer.getMatchesOnTable() == 1) {
                        System.out.println("One match left on the table. You lost!\n");
                        matchesOnTable = initialMatches;
                    } else if (compAnswer.getMatchesOnTable() < 1) {
                        System.out.println("The computer took the last match. You won!\n");
                        matchesOnTable = initialMatches;
                    }
                }
            }
        };
    }
}
