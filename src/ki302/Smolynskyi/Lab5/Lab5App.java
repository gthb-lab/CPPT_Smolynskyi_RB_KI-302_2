package ki302.Smolynskyi.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас-драйвер {@code Lab5App} тестує клас {@link EquationProcessor},
 * перевіряючи коректність запису та читання результатів
 * у текстовому та двійковому форматах.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Lab5App {
    public static void main(String[] args) {
        
        String textFile = "text_result.txt";
        String binaryFile = "binary_result.dat";

        EquationProcessor processor = new EquationProcessor();

        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Програма обчислює y = tg(4x) / x");
            System.out.print("Будь ласка, введіть значення x (в радіанах): ");
            double x = scanner.nextDouble();

            // 1. Обчислюємо та зберігаємо
            processor.calculate(x);
            double originalResult = processor.getResult();
            System.out.println("Обчислено (оригінал): " + originalResult);

            // 2. Тестуємо ТЕКСТОВИЙ запис/читання
            System.out.println("\n--- Тест текстового формату ---");
            processor.writeResultAsText(textFile);
            System.out.println("Результат записано у " + textFile);
            
            // "Обнуляємо" об'єкт для чистоти експерименту
            processor = new EquationProcessor(); 
            
            processor.readResultAsText(textFile);
            System.out.println("Результат зчитано з " + textFile + ": " + processor.getResult());
            
            if (processor.getResult() == originalResult) {
                System.out.println("ПЕРЕВІРКА ТЕКСТУ: Успішно!");
            } else {
                System.err.println("ПЕРЕВІРКА ТЕКСТУ: Помилка!");
            }

            // 3. Тестуємо ДВІЙКОВИЙ (бінарний) запис/читання
            System.out.println("\n--- Тест двійкового формату ---");
            // Повертаємо оригінальний результат в об'єкт
            processor.calculate(x); 
            
            processor.writeResultAsBinary(binaryFile);
            System.out.println("Результат записано у " + binaryFile);

            // "Обнуляємо" об'єкт
            processor = new EquationProcessor();
            
            processor.readResultAsBinary(binaryFile);
            System.out.println("Результат зчитано з " + binaryFile + ": " + processor.getResult());

            if (processor.getResult() == originalResult) {
                System.out.println("ПЕРЕВІРКА ДВІЙКОВОГО ФОРМАТУ: Успішно!");
            } else {
                System.err.println("ПЕРЕВІРКА ДВІЙКОВОГО ФОРМАТУ: Помилка!");
            }
            
        } catch (InputMismatchException e) {
            System.err.println("Помилка вводу: Введено нечислове значення.");
        } catch (CalcException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачувана помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}