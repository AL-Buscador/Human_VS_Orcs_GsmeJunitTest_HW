import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestsForGame {

    @Test
    public void testingIsAlive() {
        final Human human1 = new Human("Test1", 20, 20);
        final Human human2 = new Human("Test2", 0, 20);

        final boolean expectedYes = true;
        final boolean expectedNo = false;

        boolean returnIsAliveYes = human1.isAlive();
        boolean returnIsAliveNo = human2.isAlive();

        Assertions.assertEquals(expectedYes, returnIsAliveYes);
        Assertions.assertEquals(expectedNo, returnIsAliveNo);

    }

    @Test
    public void testing_hit() {
        Human human = new Human("Human", 30, 20);
        Orc orc = new Orc("Orc", 20, 20);

         int humanHealth = 10;
         orc.hit(human);
         int afterResult = human.getHealth();

        Assertions.assertEquals(humanHealth, afterResult);
    }

    @Test
    public void testing_getName() {
        final Human human = new Human("Test", 50, 50);

        String expName = "Test";
        String actName = human.getName();

        Assertions.assertEquals(expName,actName);
    }
}