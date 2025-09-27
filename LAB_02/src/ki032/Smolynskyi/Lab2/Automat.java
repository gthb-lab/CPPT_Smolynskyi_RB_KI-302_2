/**
 * 
 */
package ki032.Smolynskyi.Lab2;

import java.io.*;

/**
 * Клас {@code Automat} моделює автоматичну зброю.
 * <p>
 * Має три основні складові:
 * <ul>
 *   <li>{@link Barrel} – ствол;</li>
 *   <li>{@link Trigger} – курок;</li>
 *   <li>{@link Magazine} – магазин.</li>
 * </ul>
 * Методи класу ведуть протокол своєї діяльності
 * у текстовий файл <b>automat_log.txt</b>.
 * </p>
 */
public class Automat {
    private Barrel barrel;
    private Trigger trigger;
    private Magazine magazine;
    private PrintWriter logWriter;

    /**
     * Конструктор за замовчуванням.
     * <p>Створює автомат із типовим магазином на 30 набоїв.</p>
     *
     * @throws IOException якщо не вдалося відкрити файл протоколу
     */
    public Automat() throws IOException {
        this(new Barrel(), new Trigger(), new Magazine(30));
    }

    /**
     * Конструктор з параметрами.
     *
     * @param barrel   об’єкт ствола
     * @param trigger  об’єкт курка
     * @param magazine об’єкт магазину
     * @throws IOException якщо не вдалося відкрити файл протоколу
     */
    public Automat(Barrel barrel, Trigger trigger, Magazine magazine) throws IOException {
        this.barrel = barrel;
        this.trigger = trigger;
        this.magazine = magazine;
        logWriter = new PrintWriter(new FileWriter("automat_log.txt", true));
        log("Автомат створено");
    }

    /**
     * Виконує один постріл.
     * Постріл можливий лише за умови наявності патронів у магазині
     * та натиснутого курка.
     */
    public void fireSingle() {
        if (magazine.hasBullets() && trigger.isPressed()) {
            magazine.useBullet();
            log("Постріл! Залишилось куль: " + magazine.getBullets());
        } else {
            log("Неможливо здійснити постріл");
        }
    }

    /**
     * Виконує серію пострілів (чергу).
     *
     * @param count кількість пострілів у черзі
     */
    public void fireBurst(int count) {
        log("Спроба черги на " + count + " пострілів");
        for (int i = 0; i < count; i++) {
            fireSingle();
        }
    }

    /**
     * Перезаряджає магазин.
     *
     * @param bullets кількість патронів для заряджання
     */
    public void reload(int bullets) {
        magazine.reload(bullets);
        log("Магазин перезаряджено. Куль: " + magazine.getBullets());
    }

    /** Натискає на курок. */
    public void pressTrigger() {
        trigger.press();
        log("Курок натиснуто");
    }

    /** Відпускає курок. */
    public void releaseTrigger() {
        trigger.release();
        log("Курок відпущено");
    }

    /**
     * Повертає кількість наявних патронів.
     *
     * @return кількість куль у магазині
     */
    public int getRemainingBullets() {
        return magazine.getBullets();
    }

    /** Повністю спорожнює магазин. */
    public void clearMagazine() {
        magazine.clear();
        log("Магазин спорожнено");
    }

    /**
     * Перевіряє готовність автомата до стрільби.
     * Умови готовності: є кулі та ствол не перегрітий.
     *
     * @return {@code true}, якщо можна стріляти;
     *         {@code false} – якщо ні
     */
    public boolean isReady() {
        boolean ready = magazine.hasBullets() && !barrel.isOverheated();
        log("Перевірка готовності: " + ready);
        return ready;
    }

    /**
     * Коректне завершення роботи з файлом протоколу.
     * <p>Цей метод необхідно викликати перед виходом із програми.</p>
     */
    public void dispose() {
        log("Автомат вимкнено");
        logWriter.close();
    }

    /**
     * Допоміжний метод для запису повідомлення у лог.
     *
     * @param message текст повідомлення
     */
    private void log(String message) {
        logWriter.println(message);
        logWriter.flush();
    }
}
