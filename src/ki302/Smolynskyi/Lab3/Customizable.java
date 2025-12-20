/**
 * 
 */
package ki302.Smolynskyi.Lab3;

/**
 * Інтерфейс {@code Customizable} описує об'єкти,
 * які можна модифікувати, додаючи або знімаючи аксесуари.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public interface Customizable {
    /**
     * Встановлює приціл на зброю.
     */
    void attachScope();

    /**
     * Знімає приціл зі зброї.
     */
    void detachScope();

    /**
     * Перевіряє, чи встановлено приціл.
     *
     * @return true, якщо приціл є, інакше false
     */
    boolean hasScope();
}