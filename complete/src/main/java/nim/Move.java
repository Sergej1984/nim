package nim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Move {

    private final long id;
    private final int matchesOnTable;
    private final int takenMatches;
    private final Exception exception; // TODO look for a better concept

    public Move(long id, int matchesOnTable, int takenMatches, Exception exception) {
        this.id = id;
        this.matchesOnTable = matchesOnTable;
        this.takenMatches = takenMatches;
        this.exception = exception;
    }

    public long getId() {
        return id;
    }

    public int getMatchesOnTable() {
        return matchesOnTable;
    }

    public int getTakenMatches() {
        return takenMatches;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "id: " + id + ", matchesOnTable: " + matchesOnTable + ", takenMatches: " + takenMatches;
    }
}
