import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game manager = new Game();

    @Test
    public void PlayerTest() throws NotRegisteredException {

        Player playerName1 = new Player(2, "Ira", 3);
        Player playerName2 = new Player(3, "Slava", 2);
        Player playerName3 = new Player(4, "Olivia", 5);
        Player playerName4 = new Player(5, "King", 2);
        Player playerName5 = new Player(6, "Anna", 2);

        manager.register(playerName1);
        manager.register(playerName2);
        manager.register(playerName3);
        manager.register(playerName4);

        Assertions.assertEquals(1, manager.round("Ira", "Slava"));
        Assertions.assertEquals(2, manager.round("Slava", "Olivia"));
        Assertions.assertEquals(0, manager.round("Slava", "King"));

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Anna", "King");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("King", "Anna");
        });

    }
}

