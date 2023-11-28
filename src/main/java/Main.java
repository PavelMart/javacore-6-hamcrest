import java.util.Scanner;

public class Main {
    public static int[] PRICES = {50, 14, 80, 200};
    public static String[] PRODUCTS = {"Молоко", "Хлеб", "Гречневая крупа", "Шоколадный торт"};

    public static void greeting() {
        System.out.println("Привет! В нашем магазине есть следующие продукты:");
        for (int i = 0; i < PRODUCTS.length; i++) {
            System.out.printf("%d. %s %d руб/шт\n", i + 1, PRODUCTS[i], PRICES[i]);
        }
    }

    public static String[] createShoppingCart(int[] productsCount) {
        String[] shoppingCart = new String[PRODUCTS.length];
        for (int i = 0; i < PRODUCTS.length; i++) {
            if (productsCount[i] != 0) {
                shoppingCart[i] = PRODUCTS[i]
                        + " "
                        + productsCount[i]
                        + " шт "
                        + PRICES[i]
                        + " руб/шт "
                        + productsCount[i] * PRICES[i]
                        + " руб в сумме";
            }
        }
        return shoppingCart;
    }

    public static void showShoppingCart(String[] shoppingCart, int result) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < PRODUCTS.length; i++) {
            if (shoppingCart[i] != null) {
                System.out.println(shoppingCart[i]);
            }
        }
        System.out.printf("Итого: %d руб", result);
    }

    static int calculateResult(int[] productsCount) {
        int result = 0;
        for (int i = 0; i < PRODUCTS.length; i++) {
            result += productsCount[i] * PRICES[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        greeting();

        int[] productsCount = new int[PRODUCTS.length];
        String[] shoppingCart = new String[PRODUCTS.length];

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] choice = input.split(" ");
            if (choice.length != 2) {
                System.out.println("Вы ввели неверное значение, введите в формате \"номер_товара количество\"");
                continue;
            }
            productsCount[Integer.parseInt(choice[0]) - 1] += Integer.parseInt(choice[1]);

            shoppingCart = createShoppingCart(productsCount);
        }

        int result = calculateResult(productsCount);

        showShoppingCart(shoppingCart, result);
    }
}