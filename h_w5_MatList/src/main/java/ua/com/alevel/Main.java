package ua.com.alevel;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MatList<Integer> matList = new MatList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Добавить несколько элементов");
            System.out.println("3. Объединить с другими MatList");
            System.out.println("4. Отсортировать по убыванию");
            System.out.println("5. Отсортировать по убыванию с индексами");
            System.out.println("6. Отсортировать по убыванию с элемента");
            System.out.println("7. Отсортировать по возрастанию");
            System.out.println("8. Отсортировать по возрастанию с индексами");
            System.out.println("9. Отсортировать по возрастанию с элемента");
            System.out.println("10. Получить элемент по индексу");
            System.out.println("11. Получить максимальный элемент");
            System.out.println("12. Получить минимальный элемент");
            System.out.println("13. Получить среднее значение");
            System.out.println("14. Получить медиану");
            System.out.println("15. Преобразовать в массив");
            System.out.println("16. Преобразовать в массив с индексами");
            System.out.println("17. Вырезать подсписок");
            System.out.println("18. Очистить коллекцию");
            System.out.println("19. Удалить элементы по значению");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите элемент:");
                    int element = scanner.nextInt();
                    matList.add(element);
                    break;
                case 2:
                    System.out.println("Введите элементы другого списка через пробел:");

                    String input = scanner.nextLine();
                    String[] numbers = input.split(" ");
                    Integer[] intNumbers = new Integer[numbers.length];
                    for (int i = 0; i < numbers.length; i++) {
                        intNumbers[i] = Integer.parseInt(numbers[i]);
                    }
                    MatList<Integer> otherList = new MatList<>(intNumbers);
                    matList.join(otherList);

                    break;
                case 3:
                    System.out.println("Введите элементы для объединения через пробел:");

                    String input3 = scanner.nextLine();
                    String[] numbers3 = input3.split(" ");

                    // Добавляем элементы из введенной строки в текущий MatList
                    for (String num : numbers3) {

                        matList.add(Integer.parseInt(num));
                    }

                    System.out.println("Элементы успешно объединены.");
                    break;
                case 4:
                    matList.sortDesc();
                    matList.print();
                    break;
                case 5:
                    System.out.println("Введите начальный индекс:");
                    int firstIndex = scanner.nextInt();
                    System.out.println("Введите конечный индекс:");
                    int lastIndex = scanner.nextInt();

                    matList.sortDesc(firstIndex, lastIndex);
                    matList.print();
                    break;
                case 6:
                    System.out.println("Введите элемент, с которого начнется сортировка по убыванию:");
                    int value = scanner.nextInt();

                    matList.sortDesc(value);
                    matList.print();
                    break;
                case 7:
                    matList.sortAsc();
                    matList.print();
                    break;
                case 8:
                    System.out.println("Введите начальный индекс:");
                int oneIndex = scanner.nextInt();
                System.out.println("Введите конечный индекс:");
                int finIndex = scanner.nextInt();

                matList.sortAsc(oneIndex, finIndex);
                matList.print();
                break;

                case 9:
                    System.out.println("Введите элемент, с которого начнется сортировка по возрастанию:");
                    int value9 = scanner.nextInt();

                    matList.sortAscFromElement(value9);
                    matList.print();
                    break;
                case 10:
                    System.out.println("Введите индекс:");
                    int index = scanner.nextInt();
                    Number num = matList.get(index);
                    System.out.println("Элемент по индексу " + index + ": " + num);
                    break;
                case 11:
                    Number max = matList.getMax();
                    System.out.println("Максимальный элемент: " + max);
                    break;
                case 12:
                    Number min = matList.getMin();
                    System.out.println("Минимальный элемент: " + min);
                    break;
                case 13:
                    Number average = matList.getAverage();
                    System.out.println("Среднее значение: " + average);
                    break;
                case 14:
                    Number median = matList.getMedian();
                    System.out.println("Медиана: " + median);
                    break;
                case 15:
                    Number[] array = matList.toArray();
                    System.out.println("Массив: " + Arrays.toString(array));
                    break;
                case 16:
                    Number[] array16 = matList.toArrayWithIndices();
                    System.out.println("Массив с индексами:");
                    for (int i = 0; i < array16.length; i++) {
                        System.out.println("Индекс " + i + ": " + array16[i]);
                    }
                    break;
                case 17:
                    System.out.println("Введите первый индекс подсписка:");
                    int perIndex = scanner.nextInt();

                    System.out.println("Введите последний индекс подсписка:");
                    int posIndex = scanner.nextInt();

                    MatList<Integer> cutList = matList.cut(perIndex,posIndex);
                    cutList.print();
                    break;
                case 18:
                    matList.clear();
                    System.out.println("Коллекция очищена.");
                    break;
                case 19:
                    System.out.println("Введите элементы для удаления через пробел:");
                    String elementsToRemoveInput = scanner.nextLine().trim();

                    if (elementsToRemoveInput.isEmpty()) {
                        System.out.println("Вы ввели пустую строку. Ничего не удалено.");
                    } else {
                        Scanner elementScanner = new Scanner(elementsToRemoveInput);
                        List<Integer> elementsToRemoveList = new ArrayList<>();

                        while (elementScanner.hasNextInt()) {
                            int element19 = elementScanner.nextInt();
                            elementsToRemoveList.add(element19);
                        }

                        for (Integer element19 : elementsToRemoveList) {
                            matList.removeElement(element19);
                        }

                        System.out.println("Элементы удалены.");
                    }
                    break;
                case 0:
                    System.out.println("Спасибо за пользыванием программой досвидание.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
    }
}