package ki302.Smolynskyi.Lab6;

/**
 * Інтерфейс @code SuitcaseItem описує будь-який предмет,
 * який можна покласти у валізу.
 * <p>
 * Він успадковує {@link Comparable}, щоб предмети можна було
 * сортувати або знаходити серед них мінімальний (за вагою).
 *
 * @author Smolynskyi
 * @version 1.0
 */
public interface SuitcaseItem extends Comparable<SuitcaseItem> {

    /**
     * Повертає вагу предмета.
     * @return Вага у кілограмах.
     */
    double getWeight();

    /**
     * Повертає опис предмета.
     * @return Рядок з описом.
     */
    String getDescription();

    /**
     * Реалізація методу порівняння за замовчуванням.
     * <p>
     * Порівнює предмети за їхньою вагою ({@link #getWeight()}).
     * @param other інший предмет для порівняння.
     * @return -1, 0, або 1, якщо цей предмет легший,
     * такий самий, або важчий за інший.
     */
    @Override
    default int compareTo(SuitcaseItem other) {
        return Double.compare(this.getWeight(), other.getWeight());
    }
}