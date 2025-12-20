/**
 * 
 */
package ki032.Smolynskyi.Lab2;

/**
 * Клас-драйвер {@code AutomatApp} демонструє
 * роботу класу {@link Automat}.
 */
public class AutomatApp {
	/**
	 * Точка входу в програму
	 * @param args аргументи командного рядка (не використовуються)
	 */
    public static void main(String[] args) {
        try {
            Automat ak = new Automat();

            ak.pressTrigger();
            ak.fireSingle();
            ak.fireBurst(3);
            ak.releaseTrigger();

            ak.reload(25);
            ak.clearMagazine();

            ak.isReady();
            ak.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}