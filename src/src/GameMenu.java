import Heroes.*;
import Strategy.*;
import Decorator.*;
import Observer.*;
import Factory.HeroFactory;
import java.util.*;

public class GameMenu {
    private final List<Hero> heroes = new ArrayList<>();
    private final GameObserver announcer = new BattleAnnouncer();
    private final GameObserver logger = new DamageLogger();
    private final Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== HERO BATTLE GAME ===");
            System.out.println("1. Create Hero");
            System.out.println("2. Show Heroes");
            System.out.println("3. Change Hero Strategy");
            System.out.println("4. Apply Decorator");
            System.out.println("5. Start Battle");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> createHeroMenu();
                case "2" -> listHeroes();
                case "3" -> changeHeroStrategyMenu();
                case "4" -> applyDecoratorMenu();
                case "5" -> startBattleMenu();
                case "6" -> {
                    System.out.println("🏁 Game over. See you next time!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void createHeroMenu() {
        System.out.print("Enter hero name: ");
        String name = sc.nextLine();
        System.out.println("Choose type: 1) Warrior  2) Mage  3) Archer");
        String typeChoice = sc.nextLine();
        String type = switch (typeChoice) {
            case "1" -> "Warrior";
            case "2" -> "Mage";
            case "3" -> "Archer";
            default -> "Warrior";
        };

        Hero hero = HeroFactory.createHero(type, name);
        hero.registerObserver(announcer);
        hero.registerObserver(logger);
        heroes.add(hero);
        System.out.println("Hero created: " + name + " the " + type);
    }

    private void listHeroes() {
        if (heroes.isEmpty()) {
            System.out.println("No heroes created yet.");
            return;
        }
        System.out.println("\nCurrent Heroes:");
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
            System.out.println((i + 1) + ". " + h.getName() + " (" + h.getClass().getSimpleName() + ") - HP: " + h.getHealth());
        }
    }

    private void changeHeroStrategyMenu() {
        if (heroes.isEmpty()) return;

        listHeroes();
        System.out.print("Choose hero to change strategy: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();

        Hero hero = heroes.get(idx);
        System.out.println("Choose strategy: 1) Melee  2) Ranged  3) Magic");
        int s = sc.nextInt();
        sc.nextLine();

        AttackStrategy strategy = switch (s) {
            case 1 -> new MeleeAttack();
            case 2 -> new RangedAttack();
            case 3 -> new MagicAttack();
            default -> new MeleeAttack();
        };

        hero.setStrategy(strategy);
        System.out.println(hero.getName() + " now uses " + strategy.getClass().getSimpleName());
    }

    private void applyDecoratorMenu() {
        if (heroes.isEmpty()) {
            System.out.println("No heroes to decorate!");
            return;
        }

        listHeroes();
        System.out.println("Choose decorator: 1) Power Boost  2) Armor");
        int type = sc.nextInt();
        sc.nextLine();

        System.out.print("Choose hero number: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();

        Hero hero = heroes.get(idx);
        Hero decorated = switch (type) {
            case 1 -> new PowerBoostDecorator(hero);
            case 2 -> new ArmorDecorator(hero);
            default -> hero;
        };

        heroes.set(idx, decorated);
        System.out.println(decorated.getName() + " upgraded with " + decorated.getClass().getSimpleName());
    }

    private void startBattleMenu() {
        if (heroes.size() < 2) {
            System.out.println("Need at least two heroes to battle!");
            return;
        }

        listHeroes();
        System.out.print("Choose hero 1: ");
        int h1 = sc.nextInt() - 1;
        System.out.print("Choose hero 2: ");
        int h2 = sc.nextInt() - 1;
        sc.nextLine();

        Hero hero1 = heroes.get(h1);
        Hero hero2 = heroes.get(h2);

        System.out.println("\nBattle starts between " + hero1.getName() + " and " + hero2.getName() + "!");

        int round = 1;
        while (hero1.getHealth() > 0 && hero2.getHealth() > 0) {
            System.out.println("\n===== ROUND " + round + " =====");

            System.out.println(hero1.getName() + "'s turn:");
            hero1.attack(hero2);
            if (hero2.getHealth() <= 0) break;

            System.out.println(hero2.getName() + "'s turn:");
            hero2.attack(hero1);
            if (hero1.getHealth() <= 0) break;

            postRoundMenu();
            round++;
        }

        Hero winner = hero1.getHealth() > 0 ? hero1 : hero2;
        System.out.println(winner.getName() + "wins the battle!");
    }

    private void postRoundMenu() {
        while (true) {
            System.out.println("\n=== INTER-ROUND MENU ===");
            System.out.println("1. Change hero strategy");
            System.out.println("2. Apply Power Boost");
            System.out.println("3. Apply Armor");
            System.out.println("4. Show heroes status");
            System.out.println("5. Continue to next round");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> changeHeroStrategyMenu();
                case 2 -> applySpecificDecorator("power");
                case 3 -> applySpecificDecorator("armor");
                case 4 -> listHeroes();
                case 5 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void applySpecificDecorator(String type) {
        if (heroes.isEmpty()) {
            System.out.println("No heroes available!");
            return;
        }

        listHeroes();
        System.out.print("Choose hero: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();

        Hero hero = heroes.get(idx);
        Hero decoratedHero = switch (type) {
            case "power" -> new PowerBoostDecorator(hero);
            case "armor" -> new ArmorDecorator(hero);
            default -> hero;
        };

        heroes.set(idx, decoratedHero);
        System.out.println(decoratedHero.getName() + " is now enhanced with " + decoratedHero.getClass().getSimpleName());
    }
}
