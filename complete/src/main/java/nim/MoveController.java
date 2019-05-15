package nim;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoveController {

    private final AtomicLong counter = new AtomicLong();
    private final Random random = new Random();

    @RequestMapping("/greeting")
    public Move answer(@RequestParam(value = "matchesOnTable", defaultValue = "0") int matchesOnTable,
            @RequestParam(value = "matchesTaken", defaultValue = "0") int matchesTaken) {

        int matchesLeftAfterPlayer = matchesOnTable - matchesTaken;

        String validationResult = userInputValidation(matchesLeftAfterPlayer, matchesTaken);
        if (validationResult != null) {
            return new Move(counter.incrementAndGet(), matchesLeftAfterPlayer, matchesTaken,
                    new Exception(validationResult));
        }

        int takenByComp = compTakeMatches(matchesLeftAfterPlayer);
        int matchesLeftAfterComp = matchesLeftAfterPlayer - takenByComp;

        return new Move(counter.incrementAndGet(), matchesLeftAfterComp, takenByComp, null);
    }

    // TODO write test
    protected String userInputValidation(int matchesLeftAfterPlayer, int matchesTaken) {
        if (matchesTaken < 1 || matchesTaken > 3) {
            return "Please take either one, two or three matches from the table.";
        } else if (matchesLeftAfterPlayer < 1) {
            return "You are not allowed to take more matches than are left on the table.";
        }
        return null;
    }

    // TODO write test for case matchesOnTable > 1
    // TODO write test for case matchesOnTable == 1
    // TODO other cases to test?
    protected int compTakeMatches(int matchesOnTable) {
        int amount = random.nextInt(matchesOnTable < 4 ? matchesOnTable : 4);
        return amount > 0 ? amount : 1;
    }

    // TODO write tests
    protected int compTakeMatchesEnhanced(int matchesOnTable) {
        // TODO implement
        return 0;
    }
}
