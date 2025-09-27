/**
 * 
 */
package ki032.Smolynskyi.Lab2;

/**
 * Клас {@code Barrel} моделює ствол автомата.
 * Має стан перегріву, який впливає на можливість стрільби.
 */
public class Barrel {
    private boolean overheated;

    /** Створює ствол у нормальному стані (не перегрітий). */
    public Barrel() {
        overheated = false;
    }

    /** Перегріває ствол. */
    public void overheat() { overheated = true; }

    /** Охолоджує ствол. */
    public void coolDown() { overheated = false; }

    /**
     * Перевіряє, чи перегрітий ствол.
     *
     * @return {@code true}, якщо перегрітий; {@code false} – якщо ні
     */
    public boolean isOverheated() { return overheated; }
}
