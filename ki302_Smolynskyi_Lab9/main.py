"""
Модуль 'main' - Точка входу до програми.

Цей модуль створює об'єкт 'AssaultRifle'
та демонструє його методи.
"""

# Відносний імпорт класу з модуля 'assault_rifle'
from .assault_rifle import AssaultRifle
# Ми також могли б імпортувати Automat, але він нам тут не потрібен
# from .automat import Automat 

def main():
    """
    Головна функція програми.
    """
    print("--- Створення Штурмової гвинтівки ---")
    rifle = AssaultRifle()
    
    print("\n--- Інформація про зброю ---")
    # Виклик методу, реалізованого у похідному класі
    print(f"Тип: {rifle.get_weapon_type()}")
    
    print("\n--- Тестування методів базового класу ---")
    # Виклик успадкованих методів
    print(f"Набоїв зараз: {rifle.get_remaining_bullets()}")
    rifle.reload(20)
    print(f"Набоїв після перезарядки: {rifle.get_remaining_bullets()}")
    rifle.fire_single() # Виклик перевизначеного методу
    
    print("\n--- Тестування методів похідного класу ---")
    print(f"Чи є приціл? {rifle.has_scope()}")
    rifle.attach_scope()
    print(f"Чи є приціл? {rifle.has_scope()}")
    
    # Постріл з прицілом (демонстрація перевизначення)
    rifle.fire_single()


if __name__ == "__main__":
    """
    Ця конструкція гарантує, що функція main()
    виконається, лише якщо цей файл запущено як
    головний скрипт, а не імпортовано.
    """
    main()