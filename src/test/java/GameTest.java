import org.example.Game;
import org.example.NotRegisteredException;
import org.example.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game manager = new Game();

    @Test
    public void PlayerTest() throws NotRegisteredException {

        Player player1 = new Player(2, "Ira", 3);
        Player player2 = new Player(3, "Inna", 2);
        Player player3 = new Player(4, "Ira", 5);
        Player player4 = new Player(5, "Ira", 2);
        Player player5 = new Player(6, "Ira", 2);

        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);

        Assertions.assertEquals(1, manager.round(player1, player2));
        Assertions.assertEquals(2, manager.round(player2, player3));
        Assertions.assertEquals(0, manager.round(player2, player4));

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round(player5, player4);
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round(player4, player5);
        });

    }
}

