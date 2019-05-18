package nim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Move {

    private final long id;
    private final int matchesOnTable;
    private final int takenMatches;
    private final String exception;

    public Move(long id, int matchesOnTable, int takenMatches, String exception) {
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

    public String getException() {
        return exception;
    }

    @Override
    public String toString() {
        return "id: " + id + ", matchesOnTable: " + matchesOnTable + ", takenMatches: " + takenMatches;
    }
}
