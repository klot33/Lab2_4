fun calculate(num1: Double, num2: Double, operator: Char): Double? {
    return when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> if (num2 != 0.0) num1 / num2 else null
        else -> null
    }
}

fun main() {
    println("Программа выполняет операции над двумя числами. Доступные операции: +, -, *, /.")

    while (true) {
        println("Введите два числа и символ операции (или введите 'exit' для выхода):")
        val input = readln().trim()

        if (input.equals("exit", ignoreCase = true)) {
            println("Выход из программы.")
            break
        }

        // Разделение строки на части
        val parts = input.split(" ")

        if (parts.size != 3) {
            println("Ошибка: необходимо ввести два числа и символ операции, разделённые пробелами. Попробуйте снова.")
            continue
        }

        val num1 = try {
            parts[0].toDouble()
        } catch (e: NumberFormatException) {
            println("Ошибка: первое число введено некорректно. Попробуйте снова.")
            continue
        }

        val num2 = try {
            parts[1].toDouble()
        } catch (e: NumberFormatException) {
            println("Ошибка: второе число введено некорректно. Попробуйте снова.")
            continue
        }

        val operator = parts[2].firstOrNull()

        if (operator == null || operator !in listOf('+', '-', '*', '/')) {
            println("Ошибка: операция введена некорректно. Доступные операции: +, -, *, /. Попробуйте снова.")
            continue
        }

        val result = calculate(num1, num2, operator)

        if (result == null && operator == '/') {
            println("Ошибка: деление на ноль невозможно.")
        } else if (result != null) {
            println("Результат: $num1 $operator $num2 = $result")
        }
    }
}