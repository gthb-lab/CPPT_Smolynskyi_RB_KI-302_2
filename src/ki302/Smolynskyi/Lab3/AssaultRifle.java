/**
 * 
 */
package ki302.Smolynskyi.Lab3;

/**
 * 
 */
import java.io.IOException;

/**
 * Клас {@code AssaultRifle} моделює штурмову гвинтівку.
 * <p>
 * Цей клас є підкласом {@link Automat} і реалізує інтерфейс {@link Customizable}.
 * Він успадковує всю базову функціональність автомата та додає
 * можливість встановлення прицілу.
 * </p>
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class AssaultRifle extends Automat implements Customizable {

    private boolean scopeAttached;

    /**
     * Конструктор за замовчуванням для штурмової гвинтівки.
     * <p>Створює гвинтівку зі стандартним магазином на 30 набоїв.</p>
     *
     * @throws IOException якщо не вдалося відкрити файл протоколу
     */
    public AssaultRifle() throws IOException {
        // Явний виклик конструктора суперкласу [cite: 391, 395]
        super();
        this.scopeAttached = false;
        // Використовуємо 'log' метод, успадкований від 'Automat'
        log("Створено підклас: Штурмова гвинтівка");
    }

    /**
     * Конструктор з параметрами.
     *
     * @param barrel   об’єкт ствола
     * @param trigger  об’єкт курка
     * @param magazine об’єкт магазину
     * @throws IOException якщо не вдалося відкрити файл протоколу
     */
    public AssaultRifle(Barrel barrel, Trigger trigger, Magazine magazine) throws IOException {
        // Явний виклик конструктора суперкласу з параметрами [cite: 391]
        super(barrel, trigger, magazine);
        this.scopeAttached = false;
        log("Створено підклас: Штурмова гвинтівка (з параметрами)");
    }

    // --- Реалізація абстрактного методу з Automat ---

    /**
     * {@inheritDoc}
     * <p>Повертає тип зброї "Штурмова гвинтівка".</p>
     */
    @Override
    public String getWeaponType() {
        return "Штурмова гвинтівка";
    }

    // --- Реалізація методів інтерфейсу Customizable --- [cite: 460]

    /**
     * {@inheritDoc}
     * <p>Встановлює приціл на гвинтівку.</p>
     */
    @Override
    public void attachScope() {
        this.scopeAttached = true;
        log("Приціл встановлено на гвинтівку.");
    }

    /**
     * {@inheritDoc}
     * <p>Знімає приціл з гвинтівки.</p>
     */
    @Override
    public void detachScope() {
        this.scopeAttached = false;
        log("Приціл знято з гвинтівки.");
    }

    /**
     * {@inheritDoc}
     * <p>Перевіряє наявність прицілу на гвинтівці.</p>
     */
    @Override
    public boolean hasScope() {
        log("Перевірка прицілу: " + (scopeAttached ? "встановлено" : "відсутній"));
        return this.scopeAttached;
    }

    /**
     * Демонструє прицільну стрільбу (нова функціональність).
     * Якщо встановлено приціл, точність (умовно) вища.
     */
    public void aimAndFire() {
        if (hasScope()) {
            log("Прицільний постріл з прицілом!");
        } else {
            log("Прицільний постріл (без прицілу).");
        }
        // Виклик методу з суперкласу [cite: 385, 387]
        super.fireSingle();
    }
}