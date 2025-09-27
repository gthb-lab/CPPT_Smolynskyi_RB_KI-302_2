/**
 * 
 */
package ki032.Smolynskyi.Lab2;

/**
 * Клас {@code Trigger} моделює курок автомата.
 * Має два стани: натиснутий або відпущений.
 */
public class Trigger {
    private boolean pressed;

    /** Створює курок у стані "відпущений". */
    public Trigger() { pressed = false; }

    /** Натискає курок. */
    public void press() { pressed = true; }

    /** Відпускає курок. */
    public void release() { pressed = false; }

    /**
     * Перевіряє стан курка.
     *
     * @return {@code true}, якщо натиснутий;
     *         {@code false} – якщо відпущений
     */
    public boolean isPressed() { return pressed; }
}
