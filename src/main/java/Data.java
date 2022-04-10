import java.util.Random;

public class Data {
    public static final int HUMANS_COUNT = 6;
    public static final Human[] HUMANS = new Human[HUMANS_COUNT];
    public static final int START_HUMAN_HEALTH = 100;
    public static final int START_HUMAN_HITS = 20;

    public static final int ORCS_COUNT = 3;
    public static final Orc[] ORCS = new Orc[ORCS_COUNT];
    public static final int START_ORC_HEALTH = 180;
    public static final int START_ORC_HITS = 30;

    public static final Random RANDOM = new Random();

    // Вывод поля на экран
    public static void printField() {
        StringBuilder field = new StringBuilder();
        for (Human h : HUMANS) {
            if (!h.isAlive()) {
                field.append("-");
            } else if (h.getHealth() < START_HUMAN_HEALTH / 2) {
                field.append("h");
            } else {
                field.append("H");
            }
            field.append(" ");
        }
        field.append("   ");
        for (Orc o : ORCS) {
            if (!o.isAlive()) {
                field.append("_");
            } else if (o.getHealth() < START_ORC_HEALTH / 2) {
                field.append("o");
            } else {
                field.append("O");
            }
            field.append(" ");
        }
        System.out.println(field);
    }

    // Проверка того закончилась ли битва
    public static boolean checkFinish() {
        boolean hasHumansAlive = false;
        for (Human human : HUMANS) {
            if (human.isAlive()) hasHumansAlive = true;
        }
        if (!hasHumansAlive) {
            System.out.println("ПОБЕДИЛА ОРДА!");
            return true;
        }

        boolean hasOrcsAlive = false;
        for (Orc orc : ORCS) {
            if (orc.isAlive()) hasOrcsAlive = true;
        }
        if (!hasOrcsAlive) {
            System.out.println("ПОБЕДИЛ АЛЬЯНС!");
            return true;
        }

        return false;
    }

    // Метод для случайного выбора живого орка
    public static Orc selectOrc() {
        while (true) {
            Orc orc = ORCS[RANDOM.nextInt(ORCS_COUNT)];
            if (orc.isAlive()) return orc;
        }
    }

    // Метод для случайного выбора живого человека
    public static Human selectHuman() {
        while (true) {
            Human human = HUMANS[RANDOM.nextInt(HUMANS_COUNT)];
            if (human.isAlive()) return human;
        }
    }
}