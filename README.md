# Clothing Analysis

## Автор

- [Павлюк Назар](https://t.me/TNTeshka2245)
- Група ІО-25

## Опис проєкту

Цей проєкт виконує генерацію та аналіз даних про учасників опитування на DOU. Реалізовано Нескінченний генератор у стрімі, що створює об'єкти учасників із випадковими характеристиками. Фільтрацію учасників за певними умовами за допомогою кастомного Gatherer, який пропускає задану кількість учасників із певного міста проживання. Групування учасників за кількістю повних років з відбором тих, чий дохід знаходиться у вказаних межах. Статистичний аналіз місячного доходу учасників. Виявлення викидів у доходах учасників за допомогою аналізу на основі міжквартильного діапазону.

## Збірка та запуск

### Вимоги

- JDK 21+

### Інструкція зі збірки та запуску

1. **Клонуйте репозиторій собі на комп'ютер**:
    ```bash
    git clone https://github.com/TNTeshka/lab1_javac.git
    ```

2. **Запуск проекту**:
    - Переконайтесь що в модулі проєкту `lab1_javac` рівень мови встановлений на preview.
    - Запустіть клас `Main`.
