import java.util.Scanner;

abstract class Coffee {
    public abstract void prepare();
}

class Espresso extends Coffee {
    @Override
    public void prepare() {
        System.out.println("Приготовление Эспрессо");
    }
}

class Americano extends Coffee {
    @Override
    public void prepare() {
        System.out.println("Приготовление Американо");
    }
}

class CoffeeFactory {
    public static Coffee createCoffee(String type) {
        return switch (type.toLowerCase()) {
            case "эспрессо" -> new Espresso();
            case "американо" -> new Americano();
            default -> throw new IllegalArgumentException("Неизвестный тип кофе");
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип кофе, который вы хотите (эспрессо/американо): ");
        String coffeeType = scanner.nextLine();

        try {
            Coffee coffee = CoffeeFactory.createCoffee(coffeeType);
            coffee.prepare();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}