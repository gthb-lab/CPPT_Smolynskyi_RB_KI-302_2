"""
Модуль 'automat'
Містить абстрактний базовий клас 'Automat'.
"""

from abc import ABC, abstractmethod

class Automat(ABC):
    """
    Абстрактний базовий клас 'Automat'.

    Описує базову поведінку автоматичної зброї, таку як
    перезарядка та стрільба. Має абстрактний метод
    для отримання типу зброї.
    """
    
    def __init__(self, magazine_capacity: int):
        """
        Конструктор базового класу.

        Args:
            magazine_capacity (int): Максимальна кількість набоїв.
        """
        self._magazine_capacity = magazine_capacity
        self._bullets_count = 0
        self._log("Створено базовий 'Автомат'")

    def _log(self, message: str):
        """
        Допоміжний "захищений" метод для логування дій.
        
        Args:
            message (str): Повідомлення для виведення.
        """
        print(f"[LOG: {self.__class__.__name__}] {message}")

    @abstractmethod
    def get_weapon_type(self) -> str:
        """
        Абстрактний метод для отримання типу зброї.
        Має бути реалізований у похідних класах.

        Returns:
            str: Назва типу зброї.
        """
        pass

    def reload(self, bullets: int):
        """
        Перезаряджає магазин.

        Args:
            bullets (int): Кількість набоїв для заряджання.
        """
        if bullets > self._magazine_capacity:
            self._bullets_count = self._magazine_capacity
            self._log(f"Перезаряджено. У магазині {self._bullets_count} набоїв (максимум).")
        else:
            self._bullets_count = bullets
            self._log(f"Перезаряджено. У магазині {self._bullets_count} набоїв.")

    def fire_single(self):
        """
        Виконує один постріл.
        """
        if self._bullets_count > 0:
            self._bullets_count -= 1
            self._log(f"Постріл! Залишилось набоїв: {self._bullets_count}")
        else:
            self._log("Неможливо стріляти: магазин порожній.")

    def get_remaining_bullets(self) -> int:
        """
        Повертає кількість наявних набоїв.

        Returns:
            int: Кількість набоїв.
        """
        return self._bullets_count