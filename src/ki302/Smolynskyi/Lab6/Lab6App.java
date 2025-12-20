package ki302.Smolynskyi.Lab6;

/**
 * Клас-драйвер @code Lab6App демонструє роботу
 * параметризованого класу {@link Suitcase}.
 * <p>
 * Програма створює одну валізу та додає до неї об'єкти
 * двох різних класів ({@link Clothing} та {@link Electronics}),
 * після чого тестує методи контейнера.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Lab6App {
	
    public static void main(String[] args) {
        
        // Створюємо одну валізу, яка може містити
        // будь-який об'єкт, що реалізує SuitcaseItem
        Suitcase<SuitcaseItem> mySuitcase = new Suitcase<>();

        System.out.println("--- Наповнення валізи ---");
        // Тестуємо 1-й метод (addItem)
        // Додаємо 2 різні класи екземплярів
        mySuitcase.addItem(new Clothing("Джинси", 0.7));
        mySuitcase.addItem(new Electronics("Ноутбук", 1.8));
        mySuitcase.addItem(new Clothing("Футболка", 0.2));
        mySuitcase.addItem(new Electronics("Зарядний пристрій", 0.3));

        System.out.println();
        
        // Тестуємо 4-й метод (displayContents)
        mySuitcase.displayContents();
        System.out.println();

        // Тестуємо 3-й метод (findMinItem)
        System.out.println("--- Пошук найлегшого предмета ---");
        SuitcaseItem minItem = mySuitcase.findMinItem();
        if (minItem != null) {
            System.out.println("Знайдено найлегший предмет: " + minItem.getDescription());
            System.out.println("Вага: " + minItem.getWeight() + " кг");
        } else {
            System.out.println("Не вдалося знайти мінімум (валіза порожня).");
        }
        
        System.out.println();

        // Тестуємо 2-й метод (removeItem)
        System.out.println("--- Видалення найлегшого предмета ---");
        if (minItem != null) {
            mySuitcase.removeItem(minItem);
        }

        System.out.println();
        
        // Показуємо вміст знову
        mySuitcase.displayContents();
    }
}