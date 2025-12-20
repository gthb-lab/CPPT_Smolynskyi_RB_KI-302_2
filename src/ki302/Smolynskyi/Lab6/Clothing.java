package ki302.Smolynskyi.Lab6;

/**
 * Клас @code Clothing реалізує {@link SuitcaseItem}
 * і представляє предмет одягу.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Clothing implements SuitcaseItem {
    private String type;
    private double weight;

    /**
     * Створює предмет одягу.
     * @param type Тип одягу (напр., "Сорочка", "Джинси").
     * @param weight Вага у кілограмах.
     */
    public Clothing(String type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getDescription() {
        return "Одяг: " + type;
    }
    
    @Override
    public String toString() {
        return getDescription();
    }
}