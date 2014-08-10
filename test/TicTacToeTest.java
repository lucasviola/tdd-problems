import org.junit.Test;
import ticTacToe.Match;
import ticTacToe.Player;
import ticTacToe.Symbol;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TicTacToeTest {

    @Test
    public void shouldAlternateTurns() throws Exception {
        Player firstPlayer = new Player(Symbol.x);
        Player secondPlayer = new Player(Symbol.circle);
        Match newMatch = new Match(firstPlayer, secondPlayer);

        newMatch.start();
        newMatch.nextMove();
        Player result = newMatch.whosTurnIsIt();

        assertThat(result, is(secondPlayer));

    }
}
