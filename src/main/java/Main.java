class Main {

    public static void main(String[] args) throws Exception {
        // Заполняем массивы армий
        for (int i = 0; i < Data.HUMANS_COUNT; i++) {
            Data.HUMANS[i] = new Human("Чел-" + (i + 1), Data.START_HUMAN_HEALTH, Data.START_HUMAN_HITS);
        }
        for (int i = 0; i < Data.ORCS_COUNT; i++) {
            Data.ORCS[i] = new Orc("Орк-" + (i + 1), Data.START_ORC_HEALTH, Data.START_ORC_HITS);
        }

        int round = 1;
        while (!Data.checkFinish()) {
            System.out.println();
            System.out.println("ROUND " + round++);
            // Люди учатся друг у друга
            for (Human human : Data.HUMANS) {
                if (!human.isAlive()) continue;
                Human otherHuman = Data.selectHuman();
                if (human == otherHuman) continue;
                human.learnFrom(otherHuman);
            }
            // Орки выбирают наставников
            for (Orc orc : Data.ORCS) {
                if (!orc.isAlive()) continue;
                Orc otherOrc = Data.selectOrc();
                if (orc == otherOrc) continue;
                orc.follow(otherOrc);
            }
            // Человек ли сейчас пойдёт в атаку?
            if (Data.RANDOM.nextBoolean()) {
                Human attacker = Data.selectHuman();
                Orc defender = Data.selectOrc();
                attacker.hit(defender); // человек атакует
                if (defender.isAlive()) defender.hit(attacker); // орк атакует
            } else {
                Orc attacker = Data.selectOrc();
                Human defender = Data.selectHuman();
                attacker.hit(defender); // орк атакует
                if (defender.isAlive()) defender.hit(attacker); // человек атакует
            }
            Data.printField();
            Thread.sleep(1000);
        }
    }
}