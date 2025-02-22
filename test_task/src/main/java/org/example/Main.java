package org.example;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример: ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new Exception("Неправильный формат. Используйте формат: a + b");
        }

        int a = parseNumber(tokens[0]);
        int b = parseNumber(tokens[2]);
        String operator = tokens[1];

        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) throw new Exception("Деление на ноль запрещено");
                result = a / b;
                break;
            default:
                throw new Exception("Некорректная операция");
        }

        return String.valueOf(result);
    }

    private static int parseNumber(String str) throws Exception {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 10) {
                throw new Exception("Число только от 1 до 10 включительно");
            }
            return num;
        } catch (NumberFormatException e) {
            throw new Exception("Неверное число");
        }
    }
}
