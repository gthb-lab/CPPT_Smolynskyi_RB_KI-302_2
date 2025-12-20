"""
Модуль 'assault_rifle'
Містить похідний клас 'AssaultRifle'.
"""

# Відносний імпорт з модуля 'automat' у цьому ж пакеті
from .automat import Automat

class AssaultRifle(Automat):
    """
    Похідний клас 'Штурмова гвинтівка'.
    
    Успадковує 'Automat' та реалізує його абстрактні методи.
    Додає нову функціональність (встановлення прицілу).
    """
    
    def __init__(self, magazine_capacity: int = 30):
        """
        Конструктор похідного класу.
        Викликає конструктор базового класу.

        Args:
            magazine_capacity (int, optional): Розмір магазину. За замовч. 30.
        """
        # Виклик конструктора базового класу
        super().__init__(magazine_capacity)
        self._has_scope = False
        self._log("Створено похідний клас 'Штурмова гвинтівка'.")

    # --- Реалізація абстрактного методу ---
    
    def get_weapon_type(self) -> str:
        """
        Реалізація абстрактного методу з базового класу.
        
        Returns:
            str: Тип зброї.
        """
        return "Штурмова гвинтівка"

    # --- Нова функціональність похідного класу ---
    
    def attach_scope(self):
        """
        Встановлює приціл.
        """
        self._has_scope = True
        self._log("Приціл встановлено.")

    def has_scope(self) -> bool:
        """
        Перевіряє, чи встановлено приціл.

        Returns:
            bool: True, якщо приціл є, інакше False.
        """
        return self._has_scope

    # --- Перевизначення (Override) методу ---
    
    def fire_single(self):
        """
        Перевизначений метод пострілу.
        Додає перевірку на приціл перед викликом базового методу.
        """
        if self._has_scope:
            self._log("Прицільний постріл...")
        
        # Виклик реалізації методу з базового класу
        super().fire_single()