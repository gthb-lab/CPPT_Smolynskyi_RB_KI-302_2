import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас {@code Lab1SmolynskyiKI302} реалізує програму для створення зубчатого масиву,
 * що містить лише заштриховані області квадратної матриці відповідно до варіанта.
 * <p>
 * Програма виконує наступні дії:
 * <ul>
 *   <li>запитує у користувача розмір квадратної матриці та символ-заповнювач;</li>
 *   <li>перевіряє коректність введення символу-заповнювача (має бути один символ);</li>
 *   <li>будує зубчатий масив із заштрихованими областями;</li>
 *   <li>виводить результат на екран;</li>
 *   <li>зберігає результат у текстовий файл {@code Lab1Result.txt}.</li>
 * </ul>
 *
 * @author Smolynskyi R.
 * @version 1.2
 */
public class Lab1SmolynskyiKI302 {

    /**
     * Головний метод програми. Організовує увесь процес роботи:
     * <ol>
     *     <li>Зчитує дані від користувача;</li>
     *     <li>Створює зубчатий масив;</li>
     *     <li>Виводить масив у консоль та у файл.</li>
     * </ol>
     *
     * @param args аргументи командного рядка (не використовуються у програмі)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Крок 1. Введення розміру матриці ---
        System.out.print("Введіть розмір квадратної матриці: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // очищаємо буфер після nextInt

        // --- Крок 2. Введення символу-заповнювача ---
        System.out.print("Введіть символ-заповнювач: ");
        String input = scanner.nextLine();

        // Перевірка на коректність символу
        if (input.length() != 1) {
            System.out.println("Помилка: потрібно ввести рівно один символ!");
            scanner.close(); // закриваємо перед виходом
            return;
        }
        char fillChar = input.charAt(0);

        // --- Крок 3. Створення зубчатого масиву ---
        char[][] jaggedArray = generateJaggedArray(n, fillChar);

        // --- Крок 4. Вивід у консоль та у файл ---
        printAndSaveArray(jaggedArray, "Lab1Result.txt");

        // --- Закриття scanner ---
        scanner.close();
    }

    /**
     * Створює зубчатий масив, що містить лише заштриховані області
     * квадратної матриці відповідно до варіанта.
     *
     * @param n        розмір квадратної матриці
     * @param fillChar символ-заповнювач для заштрихованих областей
     * @return двовимірний зубчатий масив символів
     */
    public static char[][] generateJaggedArray(int n, char fillChar) {
        char[][] jaggedArray = new char[n][];
        for (int i = 0; i < n; i++) {
            jaggedArray[i] = new char[n];
            for (int j = 0; j < n; j++) {
                // умови для заштрихованих областей
                if ((i < j && i < n / 2) || (i > j && i >= n / 2)) {
                    jaggedArray[i][j] = fillChar;
                } else {
                    jaggedArray[i][j] = ' ';
                }
            }
        }
        return jaggedArray;
    }

    /**
     * Виводить зубчатий масив у консоль та зберігає його у текстовий файл.
     *
     * @param jaggedArray масив, який потрібно вивести
     * @param filename    назва файлу для збереження результату
     */
    public static void printAndSaveArray(char[][] jaggedArray, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < jaggedArray.length; i++) {
                for (int j = 0; j < jaggedArray[i].length; j++) {
                    System.out.print(jaggedArray[i][j] + " ");
                    writer.write(jaggedArray[i][j] + " ");
                }
                System.out.println();
                writer.write("\n");
            }
            System.out.println("Результат записано у файл " + filename);
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
