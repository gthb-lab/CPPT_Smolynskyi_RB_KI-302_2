/**
 * 
 */
package ki302.Smolynskyi.Lab3;

import java.io.IOException;

/**
 * Клас-драйвер {@code Lab3App} демонструє
 * роботу класу {@link AssaultRifle}, спадкування від {@link Automat}
 * та реалізацію інтерфейсу {@link Customizable}.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class Lab3App {
    public static void main(String[] args) {
        try {
            // Демонстрація поліморфізму:
            // Створюємо об'єкт підкласу AssaultRifle,
            // але посилаємося на нього через змінну суперкласу Automat 
            Automat rifle = new AssaultRifle();

            // Виклик методу, реалізованого у підкласі
            System.out.println("Тип зброї: " + rifle.getWeaponType());

            // Виклик методів, успадкованих від Automat
            rifle.pressTrigger();
            rifle.fireSingle();
            rifle.fireBurst(5);
            rifle.releaseTrigger();
            rifle.reload(30);

            System.out.println("\n--- Тестування функцій інтерфейсу ---");

            // Щоб викликати методи з інтерфейсу Customizable,
            // нам потрібно перевірити тип і виконати приведення типів [cite: 430]
            if (rifle instanceof Customizable) {
                // Використовуємо оператор instanceof для безпеки 
                // Виконуємо спадне приведення (downcasting) [cite: 416, 421]
                Customizable customizableRifle = (Customizable) rifle;

                System.out.println("Чи є приціл? " + customizableRifle.hasScope());
                customizableRifle.attachScope();
                System.out.println("Чи є приціл? " + customizableRifle.hasScope());

                // Ми також можемо привести до конкретного класу AssaultRifle
                // для виклику його власних (не інтерфейсних) методів
                AssaultRifle ar = (AssaultRifle) rifle;
                ar.aimAndFire(); // Виклик нового методу з AssaultRifle

                customizableRifle.detachScope();
                System.out.println("Чи є приціл? " + customizableRifle.hasScope());
            }

            // Завершення роботи та закриття файлу журналу
            rifle.dispose();

            System.out.println("\nРоботу завершено. Перевірте файл 'automat_log.txt'.");

        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом журналу: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Виникла непередбачувана помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}