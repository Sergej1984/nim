package nim;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MoveControllerTest {

    @Mock
    Move moveMock;

    @InjectMocks
    MoveController testee;

    @org.junit.jupiter.api.Test
    void answer() {
    }

    @org.junit.jupiter.api.Test
    void userInputValidation() {
    }

    @org.junit.jupiter.api.Test
    void compTakeMatches() {
        when(moveMock.getMatchesOnTable()).thenReturn(7);

        assertEquals(4, testee.compTakeMatches(moveMock.getMatchesOnTable()));
    }

    @org.junit.jupiter.api.Test
    void compTakeMatchesEnhanced() {

    }
}