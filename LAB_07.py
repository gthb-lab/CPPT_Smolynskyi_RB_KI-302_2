"""
Модуль для Лабораторної роботи №7, Варіант 2.

Цей модуль генерує та виводить зубчастий масив,
що представляє заштриховану область квадратної матриці.
"""

import sys

def generate_jagged_array(size: int, filler: str) -> list[list[str]]:
    """
    Створює матрицю, що містить заштриховані області
    (два трикутники).

    Args:
        size (int): Розмір квадратної матриці (n x n).
        filler (str): Символ-заповнювач для заштрихованих областей.

    Returns:
        list[list[str]]: Двовимірний масив (список списків) символів.
    """
    
    # Створюємо матрицю n x n, заповнену пробілами
    matrix = [[' ' for _ in range(size)] for _ in range(size)]

    for i in range(size):
        # Логіка Java: if (i < n / 2)
        if i < size // 2:
            # Верхня половина: від j = 0 до j = i
            for j in range(i + 1):
                matrix[i][j] = filler
        else:
            # Нижня половина: від j = n/2 до j = n/2 + (i - n/2)
            start_j = size // 2
            count = i - size // 2 + 1
            for j in range(start_j, start_j + count):
                matrix[i][j] = filler
                
    return matrix

def print_array(matrix: list[list[str]]):
    """
    Виводить масив у консоль.

    Args:
        matrix (list[list[str]]): Масив, який потрібно вивести.
    """
    for row in matrix:
        # Створюємо рядок з елементами через пробіл
        line = " ".join(row)
        
        # Виводимо у консоль
        print(line)

def main():
    """
    Головна функція-драйвер. Організовує увесь процес роботи.
    """
    
    # --- Крок 1. Введення розміру матриці ---
    try:
        size_input = input("Введіть розмір квадратної матриці: ")
        if not size_input:
             print("Помилка: Розмір не введено.")
             sys.exit(1) # Коректне переривання роботи
             
        size = int(size_input)
        
        if size <= 0:
            print("Помилка: Розмір має бути додатним числом.")
            sys.exit(1)
            
    except ValueError:
        print("Помилка: Введено нечислове значення для розміру.")
        sys.exit(1) # Коректне переривання роботи

    # --- Крок 2. Введення символу-заповнювача ---
    filler = input("Введіть символ-заповнювач: ")

    # Перевірка на коректність символу (аналогічно Java)
    if len(filler) != 1:
        print("Помилка: потрібно ввести рівно один символ!")
        sys.exit(1) # Коректне переривання роботи

    # --- Крок 3. Створення масиву ---
    try:
        jagged_array = generate_jagged_array(size, filler)
        
        # --- Крок 4. Вивід у консоль ---
        print("\nРезультат:")
        print_array(jagged_array)

    except Exception as e:
        print(f"Виникла непередбачувана помилка: {e}")
        sys.exit(1)

# --- Точка входу до програми ---
# Цей код виконається, лише якщо файл запущено напряму
if __name__ == "__main__":
    main()