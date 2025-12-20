"""
Модуль для Лабораторної роботи №8, Варіант 22.

Цей модуль обчислює вираз y = tg(4x) / x та
реалізує функції для запису та читання результату
в текстовому та двійковому форматах.
"""

import math
import sys
import struct  # Для роботи з двійковими даними
import os      # Для перевірки існування файлу

# --- Функція обчислення ---

def calculate(x: float) -> float:
    """
    Обчислює вираз y = tg(4x) / x.
    
    Генерує виключення ValueError, якщо x = 0 (ділення на нуль)
    або cos(4x) = 0 (невизначений тангенс).

    Args:
        x (float): Вхідний аргумент в радіанах.

    Returns:
        float: Результат обчислення y.
    
    Raises:
        ValueError: Якщо обчислення неможливе.
    """
    
    # 1. Перевірка на ділення на нуль (x = 0)
    if x == 0:
        raise ValueError("Помилка: Ділення на нуль (x = 0).")

    # 2. Перевірка на невизначеність тангенса
    cos_4x = math.cos(4 * x)
    
    # Використовуємо малу дельту (epsilon) для порівняння з нулем
    if abs(cos_4x) < 1e-10:
        raise ValueError("Помилка: Невизначений тангенс (cos(4x) = 0).")

    # 3. Обчислення
    y = math.tan(4 * x) / x
    
    if math.isnan(y) or math.isinf(y):
        raise ValueError("Помилка: Результат є нескінченним або невизначеним (NaN).")
        
    return y

# --- Функції роботи з файлами ---

def write_result_text(filename: str, result: float):
    """
    Записує результат (float) у текстовий файл.

    Args:
        filename (str): Ім'я файлу для запису.
        result (float): Результат обчислення.
    
    Raises:
        IOError: Якщо виникає помилка запису.
    """
    print(f"[Запис TXT]... у файл '{filename}'")
    # 'w' - режим запису (write), 'utf-8' - кодування
    with open(filename, 'w', encoding='utf-8') as f:
        f.write(str(result))

def read_result_text(filename: str) -> float:
    """
    Читає результат (float) з текстового файлу.

    Args:
        filename (str): Ім'я файлу для читання.

    Returns:
        float: Зчитане значення.
        
    Raises:
        FileNotFoundError: Якщо файл не знайдено.
        ValueError: Якщо вміст файлу не є числом.
        IOError: Якщо виникає помилка читання.
    """
    print(f"[Читання TXT]... з файлу '{filename}'")
    with open(filename, 'r', encoding='utf-8') as f:
        data_str = f.read()
        return float(data_str)

def write_result_binary(filename: str, result: float):
    """
    Записує результат (float) у двійковий файл.

    Args:
        filename (str): Ім'я файлу для запису.
        result (float): Результат обчислення.
    
    Raises:
        IOError: Якщо виникає помилка запису.
    """
    print(f"[Запис BIN]... у файл '{filename}'")
    # 'wb' - режим двійкового запису (write binary)
    with open(filename, 'wb') as f:
        # 'd' - означає C-тип double (8 байт), 
        # що є float у Python
        f.write(struct.pack('d', result))

def read_result_binary(filename: str) -> float:
    """
    Читає результат (float) з двійкового файлу.

    Args:
        filename (str): Ім'я файлу для читання.

    Returns:
        float: Зчитане значення.
        
    Raises:
        FileNotFoundError: Якщо файл не знайдено.
        IOError: Якщо файл пошкоджено або порожній.
        struct.error: Якщо структура файлу неправильна.
    """
    print(f"[Читання BIN]... з файлу '{filename}'")
    # 'rb' - режим двійкового читання (read binary)
    with open(filename, 'rb') as f:
        # Читаємо 8 байт (розмір типу 'd' - double)
        data_bytes = f.read(8)
        if len(data_bytes) < 8:
            raise IOError(f"Файл '{filename}' пошкоджено або порожній.")
            
        # struct.unpack повертає кортеж, беремо [0]-й елемент
        return struct.unpack('d', data_bytes)[0]

# --- Головний блок (драйвер) ---

def main():
    """
    Головна функція-драйвер.
    Обробляє введення, викликає обчислення та
    тестує функції читання/запису.
    """
    
    # Визначення імен файлів
    txt_file = "calculation_result.txt"
    bin_file = "calculation_result.dat"
    
    x_input = None  # <--- ВИРІШЕННЯ: Ініціалізуємо змінну тут

    try:
        x_input = input("Введіть значення x (в радіанах): ")
        x = float(x_input)
    except ValueError:
        # Тепер Pylance знає, що 'x_input' 100% існує
        print(f"Помилка: Введено нечислове значення '{x_input}'.", file=sys.stderr)
        sys.exit(1) # Коректне переривання роботи

    try:
        # 1. Обчислення
        y_original = calculate(x)
        print(f"Обчислено: y = {y_original}")
        
        print("-" * 30)

        # 2. Запис у файли
        write_result_text(txt_file, y_original)
        write_result_binary(bin_file, y_original)
        
        print("-" * 30)
        
        # 3. Читання з файлів
        y_from_txt = read_result_text(txt_file)
        y_from_bin = read_result_binary(bin_file)

        print("-" * 30)
        
        # 4. Верифікація
        print(f"Оригінал: \t{y_original}")
        print(f"З тексту: \t{y_from_txt}")
        print(f"З бінарного: \t{y_from_bin}")
        
        if y_original == y_from_txt == y_from_bin:
            print("\nВерифікація успішна: Всі значення збігаються.")
        else:
            print("\nПОМИЛКА ВЕРИФІКАЦІЇ!", file=sys.stderr)

    except (ValueError, IOError, struct.error) as e:
        # Обробка всіх очікуваних помилок (обчислення, файли)
        print(f"\nСталася помилка: {e}", file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        # Обробка будь-яких інших помилок
        print(f"\nВиникла непередбачувана помилка: {e}", file=sys.stderr)
        sys.exit(1)

# Точка входу: цей код виконається, 
# лише якщо файл запущено як головний скрипт
if __name__ == "__main__":
    main()