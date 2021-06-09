import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Hero Player1 = new Player("Player's name", 100, 5, 100, 50, 50);
        Hero Skeleton1 = new Skeleton("Скелетон", 100, 3, 10, 20, 50);
        Hero Goblin1 = new Goblin("Гоблин", 100, 2, 10, 30, 20);
        Hero[] Heroes = new Hero[2];
        Heroes[0] = Skeleton1;
        Heroes[1] = Goblin1;
        Battle battle1 = new Battle();
        Market market1 = new Market();
        Random random = new Random();
        boolean isFinish = false;

        System.out.println("Добро пожаловать в игру!\nВведите своё имя:");
        Scanner scanner = new Scanner(System.in);
        Player1.setName(scanner.next());
        System.out.println("В нашем мире появился " + Player1.toString());
        do {
            System.out.println(Player1.getName() + ", выберите действие:\n" + "1. К торговцу\n" + "2. В тёмный лес\n" + "3. Статус\n" + "4. На выход\n");
            Scanner scanner2 = new Scanner(System.in);
            char operation = scanner2.next().charAt(0);
            switch (operation) {
                case '1':
                    market1.Welcome(Player1);
                    break;
                case '2':
                    Hero ActiveEnemy = Heroes[random.nextInt(2)];
                    System.out.println("На дороге встретился " + ActiveEnemy.getName() + ".\n" + Player1.toString() + "\n" + ActiveEnemy.toString() + "\nИ завязался бой не на жизнь, а на смерть!");
                    if (battle1.Fighting(Player1, ActiveEnemy)) {
                        System.out.println("Жизнь прекрасна!");
       //                 System.out.println(Player1.toString());
                    } else {
                        System.out.println("Конец игры");
                        isFinish = true;
                    }
                    System.out.println("==============================================================");
                    break;
                case '3':
                    System.out.println("***************************************************************");
                    System.out.printf("%s, у вас сейчас:\nЗдоровье:\t%d\nЗолото:\t\t%d\nСила:\t\t%d\nЛовкость:\t%d\nОпыт:\t\t%d\n",Player1.getName(),Player1.getHealth(),Player1.getGold(),Player1.getPower(),Player1.getSkill(),Player1.getExperience());
                    System.out.println("***************************************************************");
                    break;
                case '4':
                    System.out.println("До свидания!");
                    isFinish = true;
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
        while (!isFinish);
    }
}
