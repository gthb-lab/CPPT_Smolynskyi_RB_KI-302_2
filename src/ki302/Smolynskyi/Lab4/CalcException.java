package ki302.Smolynskyi.Lab4;

/**
 * Клас {@code CalcException} є спеціалізованим виключенням,
 * що використовується для сигналізації про помилки під час
 * обчислення математичних виразів у цій лабораторній роботі.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class CalcException extends Exception {

    /**
     * Конструктор, що приймає повідомлення про помилку.
     * @param message Детальний опис причини виключення.
     */
    public CalcException(String message) {
        super(message);
    }
}