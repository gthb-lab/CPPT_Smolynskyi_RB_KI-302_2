package ki302.Smolynskyi.Lab5;

import java.io.*;

/**
 * Клас {@code EquationProcessor} виконує обчислення виразу
 * <code>y = tg(4x) / x</code> та надає методи для збереження
 * і читання результату у текстовому та двійковому форматах.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class EquationProcessor {

    private double result;

    /**
     * Обчислює вираз <code>y = tg(4x) / x</code> та зберігає
     * результат у внутрішньому полі класу.
     *
     * @param x Вхідний аргумент (в радіанах).
     * @throws CalcException Якщо обчислення неможливе
     * (ділення на нуль або невизначений тангенс).
     */
    public void calculate(double x) throws CalcException {
        
        // 1. Перевірка на ділення на нуль
        if (x == 0) {
            throw new CalcException("Помилка: Ділення на нуль (x = 0).");
        }

        // 2. Перевірка на невизначеність тангенса
        double cos4x = Math.cos(4 * x);
        double epsilon = 1e-6; // Використовуємо більший epsilon
        
        if (Math.abs(cos4x) < epsilon) {
            throw new CalcException("Помилка: Невизначений тангенс (cos(4x) = 0).");
        }

        // 3. Обчислення
        double y = Math.tan(4 * x) / x;

        if (Double.isNaN(y) || Double.isInfinite(y)) {
            throw new CalcException("Помилка: Результат є нескінченним або невизначеним (NaN).");
        }

        this.result = y;
    }

    /**
     * Повертає останній обчислений результат.
     * @return Значення <code>y</code>.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Записує останній обчислений результат у текстовий файл.
     *
     * @param filename Ім'я файлу для запису.
     * @throws IOException Якщо виникає помилка запису.
     */
    public void writeResultAsText(String filename) throws IOException {
        // Використовуємо try-with-resources для автоматичного закриття файлу
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(this.result);
        }
    }

    /**
     * Читає результат з текстового файлу та зберігає його у полі класу.
     *
     * @param filename Ім'я файлу для читання.
     * @throws IOException Якщо виникає помилка читання.
     * @throws NumberFormatException Якщо дані у файлі не є числом.
     */
    public void readResultAsText(String filename) throws IOException, NumberFormatException {
        // Використовуємо try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                this.result = Double.parseDouble(line);
            } else {
                throw new IOException("Файл порожній.");
            }
        }
    }

    /**
     * Записує останній обчислений результат у двійковий (бінарний) файл.
     *
     * @param filename Ім'я файлу для запису.
     * @throws IOException Якщо виникає помилка запису.
     */
    public void writeResultAsBinary(String filename) throws IOException {
        // Використовуємо try-with-resources
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeDouble(this.result);
        }
    }

    /**
     * Читає результат з двійкового файлу та зберігає його у полі класу.
     *
     * @param filename Ім'я файлу для читання.
     * @throws IOException Якщо виникає помилка читання (напр., кінець файлу).
     */
    public void readResultAsBinary(String filename) throws IOException {
        // Використовуємо try-with-resources
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            this.result = dis.readDouble();
        }
    }
}