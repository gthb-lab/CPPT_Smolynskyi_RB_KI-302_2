package ki302.Smolynskyi.Lab6;

/**
 * Клас @code Electronics реалізує {@link SuitcaseItem}
 * і представляє електронний пристрій.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Electronics implements SuitcaseItem {
    private String deviceName;
    private double weight;

    /**
     * Створює електронний пристрій.
     * @param deviceName Назва пристрою (напр., "Ноутбук").
     * @param weight Вага у кілограмах.
     */
    public Electronics(String deviceName, double weight) {
        this.deviceName = deviceName;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getDescription() {
        return "Електроніка: " + deviceName;
    }
    
    @Override
    public String toString() {
        return getDescription();
    }
}