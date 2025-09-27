/**
 * 
 */
package ki032.Smolynskyi.Lab2;

/**
 * Клас {@code Magazine} моделює магазин автомата.
 * Містить певну кількість патронів та має максимальну місткість.
 */
public class Magazine {
    private int bullets;
    private int capacity;

    /**
     * Створює магазин із заданою місткістю.
     * За замовчуванням він повністю заряджений.
     *
     * @param capacity максимальна кількість патронів
     */
    public Magazine(int capacity) {
        this.capacity = capacity;
        this.bullets = capacity;
    }

    /**
     * Перевіряє, чи є патрони.
     *
     * @return {@code true}, якщо є хоча б один патрон
     */
    public boolean hasBullets() { return bullets > 0; }

    /**
     * Повертає кількість патронів.
     *
     * @return кількість патронів у магазині
     */
    public int getBullets() { return bullets; }

    /** Використовує один патрон (якщо є). */
    public void useBullet() {
        if (bullets > 0) bullets--;
    }

    /**
     * Перезаряджає магазин новими патронами.
     *
     * @param count кількість патронів для заряджання
     */
    public void reload(int count) {
        bullets = Math.min(capacity, count);
    }

    /** Повністю очищає магазин. */
    public void clear() { bullets = 0; }
}

