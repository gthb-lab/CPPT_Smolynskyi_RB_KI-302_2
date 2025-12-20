package ki302.Smolynskyi.Lab6;

import java.util.ArrayList;
import java.util.Collections; // Будемо використовувати для пошуку мінімуму

/**
 * Параметризований клас @code Suitcase реалізує контейнер "Валіза".
 * <p>
 * Клас може зберігати будь-які об'єкти, тип яких
 * успадковує інтерфейс {@link SuitcaseItem}.
 *
 * @param <T> Тип предметів, що зберігаються у валізі.
 * Має реалізовувати {@link SuitcaseItem}.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Suitcase<T extends SuitcaseItem> {

    private ArrayList<T> items;

    /**
     * Створює нову порожню валізу.
     */
    public Suitcase() {
        items = new ArrayList<>();
    }

    /**
     * Метод 1: Додає предмет у валізу.
     *
     * @param item Предмет, який потрібно додати.
     */
    public void addItem(T item) {
        items.add(item);
        System.out.println("Додано у валізу: " + item.getDescription());
    }

    /**
     * Метод 2: Виймає (видаляє) предмет з валізи.
     *
     * @param item Предмет, який потрібно видалити.
     * @return {@code true} якщо предмет було знайдено та видалено,
     * {@code false} інакше.
     */
    public boolean removeItem(T item) {
        boolean removed = items.remove(item);
        if (removed) {
            System.out.println("Видалено з валізи: " + item.getDescription());
        }
        return removed;
    }

    /**
     * Метод 3 (Варіант 22): Знаходить мінімальний (найлегший)
     * предмет у валізі.
     *
     * @return Найлегший предмет, або {@code null} якщо валіза порожня.
     */
    public T findMinItem() {
        if (items.isEmpty()) {
            return null;
        }
        // Використовуємо Collections.min,
        // це можливо, оскільки T реалізує Comparable
        return Collections.min(items);
    }

    /**
     * Метод 4: Показує весь вміст валізи.
     */
    public void displayContents() {
        if (items.isEmpty()) {
            System.out.println("Валіза порожня.");
            return;
        }
        
        System.out.println("--- Вміст валізи ---");
        double totalWeight = 0.0;
        for (T item : items) {
            System.out.println("- " + item.getDescription() + " (Вага: " + item.getWeight() + " кг)");
            totalWeight += item.getWeight();
        }
        System.out.printf("Загальна вага: %.2f кг\n", totalWeight);
        System.out.println("----------------------");
    }
}