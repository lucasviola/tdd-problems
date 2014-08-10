import org.junit.Before;
import org.junit.Test;
import ticTacToe.Match;
import ticTacToe.Player;
import ticTacToe.Symbol;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TicTacToeTest {

        Player firstPlayer;
        Player secondPlayer;
        Match newMatch;
    @Before
    public void setUp() throws Exception {
        firstPlayer = new Player(Symbol.x);
        secondPlayer = new Player(Symbol.circle);
        newMatch = new Match(firstPlayer, secondPlayer);
        newMatch.start();
    }

    @Test
    public void shouldAlternateTurns() throws Exception {


        newMatch.nextMove();
        Player result = newMatch.whosTurnIsIt();

        assertThat(result, is(secondPlayer));

        newMatch.nextMove();
        
        assertThat(newMatch.whosTurnIsIt(), is(firstPlayer));
    }

    @Test
    public void firstPlayerShouldPlay() throws Exception {
        newMatch.nextMove();

        String firstField = newMatch.getMatchMap().get("firstField");

        assertThat(firstField, is("circle"));

    }
}
