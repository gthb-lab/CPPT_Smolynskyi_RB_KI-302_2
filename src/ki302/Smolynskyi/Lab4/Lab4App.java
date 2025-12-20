package ki302.Smolynskyi.Lab4;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас-драйвер {@code Lab4App} демонструє роботу класу {@link EquationSolver}.
 * <p>
 * Програма запитує у користувача значення 'x',
 * обчислює вираз <code>y = tg(4x) / x</code>,
 * та записує результат або повідомлення про помилку у файл "result.txt".
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Lab4App {
    public static void main(String[] args) {
        
        String outputFileName = "result.txt";

        // Try-with-resources, щоб Scanner
        // та PrintWriter/FileWriter гарантовано закрилися
        try (Scanner scanner = new Scanner(System.in);
             FileWriter fileWriter = new FileWriter(outputFileName);
             PrintWriter writer = new PrintWriter(fileWriter)) {

            System.out.println("Програма обчислює вираз y = tg(4x) / x");
            System.out.print("Будь ласка, введіть значення x (в радіанах): ");

            double x;
            try {
                // 1. Спроба зчитати X
                x = scanner.nextDouble();
                
                // 2. Спроба обчислити Y
                EquationSolver solver = new EquationSolver();
                double y = solver.calculate(x);

                // 3. Успішний результат
                String successMessage = "Обчислення успішне: y = " + y;
                System.out.println(successMessage);
                
                // Запис у файл
                writer.println("Вхідне значення x = " + x);
                writer.println("Результат y = " + y);

            } catch (InputMismatchException e) {
                // 4. Помилка: введено не число
                String errorMessage = "Помилка вводу: Введено нечислове значення.";
                System.err.println(errorMessage);
                writer.println(errorMessage);

            } catch (CalcException e) {
                // 5. Помилка: наше власне виключення
                String errorMessage = "Помилка обчислення: " + e.getMessage();
                System.err.println(errorMessage);
                writer.println("Помилка при x = (не вдалося обробити ввід)");
                writer.println(errorMessage);
            
            } catch (Exception e) {
                // 6. Помилка: будь-яка інша непередбачена помилка
                String errorMessage = "Виникла непередбачена помилка: " + e.getMessage();
                System.err.println(errorMessage);
                writer.println(errorMessage);
            }

            System.out.println("Результат (або помилка) записано у файл: " + outputFileName);

        } catch (IOException e) {
            // 7. Помилка: не вдалося відкрити/записати файл
            System.err.println("Критична помилка: Неможливо записати у файл " + outputFileName);
            e.printStackTrace();
        }
    }
}