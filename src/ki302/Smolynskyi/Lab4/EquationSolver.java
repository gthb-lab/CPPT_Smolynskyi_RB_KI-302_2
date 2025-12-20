package ki302.Smolynskyi.Lab4;

/**
 * Клас {@code EquationSolver} надає метод для обчислення
 * виразу <code>y = tg(4x) / x</code>.
 * <p>
 * Клас включає обробку потенційних математичних помилок,
 * таких як ділення на нуль та невизначеність тангенса.
 *
 * @author Smolynskyi
 * @version 1.0
 */
public class EquationSolver {

    /**
     * Обчислює вираз <code>y = tg(4x) / x</code>.
     *
     * @param x Вхідний аргумент (в радіанах).
     * @return Результат обчислення <code>y</code>.
     * @throws CalcException Якщо обчислення неможливе
     * (ділення на нуль або невизначений тангенс).
     */
    public double calculate(double x) throws CalcException {
        
        // 1. Перевірка на ділення на нуль (x = 0)
        if (x == 0) {
            throw new CalcException("Помилка: Ділення на нуль (x = 0).");
        }

        // 2. Перевірка на невизначеність тангенса
        // tg(a) невизначений, коли cos(a) = 0.
        // У нашому випадку a = 4x.
        // Це відбувається, коли 4x = π/2 + n*π
        double cos4x = Math.cos(4 * x);
        
        // Використовуємо малу дельту (epsilon) для порівняння з нулем,
        // оскільки обчислення з плаваючою комою неточні.
        double epsilon = 1e-6; 
        
        if (Math.abs(cos4x) < epsilon) {
            throw new CalcException("Помилка: Невизначений тангенс (cos(4x) = 0).");
        }

        // 3. Обчислення, якщо всі перевірки пройшли
        double y = Math.tan(4 * x) / x;

        // Додаткова перевірка на NaN (Not-a-Number) або нескінченність
        if (Double.isNaN(y) || Double.isInfinite(y)) {
            throw new CalcException("Помилка: Результат є нескінченним або невизначеним (NaN).");
        }

        return y;
    }
}