/*package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //1. реализуйте задачу,
        // которая принимает строку с консоли и вычленяет все
        // числа и находит их сумму
        //Пример:
        //Входные данные: 1w4tt!7 Выходные данные: 12
        System.out.println("Введите входные данные для первого задания");
        String numbers = bufferedReader.readLine();

        System.out.println(ua.com.alevel.Decision.getNumber(numbers));
        //2. реализуйте задачу, которая принимает строку с консоли
        // и вычленяет все символы латиницы/кириллицы и сортирует их,
        // указывая количество вхождений каждого символа
        //Пример:
        //Входные данные: 1w4tt!7мс
        // Выходные данные: 1. t - 2 2. w - 1

        System.out.println("Введите входные данные для второго задания");
        String letters = bufferedReader.readLine();

        ua.com.alevel.Decision.getLetters(letters);
        System.out.println();
//3. Конец уроков
//В некоторой школе занятия начинаются в 9:00.
// Продолжительность урока — 45 минут, после 1-го, 3-го, 5-го и т.д.
// уроков перемена 5 минут, а после 2-го, 4-го, 6-го и т.д. — 15 минут.
//Определите, когда заканчивается указанный урок.
//Данные вводятся с консоли
//Входные данные: Дан номер урока (число от 1 до 10).
//Выходные данные: Выведите два целых числа: время окончания урока в часах и минутах.
//При решении этой задачи нельзя пользоваться цыклами и условными операторами инструкциями!!!
//Примеры:
//Входные данные: 3
//Выходные данные:11 35
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер урока: ");
        int lessonNumber = scanner.nextInt();
        // Рассчитываю общую продолжительность уроков и перемен до окончания указанного урока
        int totalDuration = (lessonNumber ) * 45 + (lessonNumber / 2) * 20;
        // Рассчитываю часы и минуты окончания урока
        int hours = 9 + totalDuration / 60;
        int minutes = totalDuration % 60;
        // Вывожу время окончания урока
        System.out.println("Время окончания урока: " + hours + ":" + minutes);
    }
}


 */