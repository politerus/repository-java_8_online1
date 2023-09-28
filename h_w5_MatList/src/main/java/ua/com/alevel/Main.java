package ua.com.alevel;
import java.util.*;
import static ua.com.alevel.MatList.getUserInputInt;
import static ua.com.alevel.MatList.getUserInputIntArray;


public class Main {

    public static void main(String[] args) {
        MatList<Integer> matList = new MatList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Add an element");
            System.out.println("2. Add multiple elements");
            System.out.println("3. Join with other MatList");
            System.out.println("4. Intersection with other MatList");
            System.out.println("5. Sort in descending order");
            System.out.println("6. Sort in descending order within a range");
            System.out.println("7. Sort in descending order from an element");
            System.out.println("8. Sort in ascending order");
            System.out.println("9. Sort in ascending order within a range");
            System.out.println("10. Sort in ascending order from an element");
            System.out.println("11. Get an element by index");
            System.out.println("12. Get the maximum element");
            System.out.println("13. Get the minimum element");
            System.out.println("14. Get the average value");
            System.out.println("15. Get the median");
            System.out.println("16. Convert to an array");
            System.out.println("17. Convert to an array within a range");
            System.out.println("18. Cut a sublist");
            System.out.println("19. Clear the collection");
            System.out.println("20. Clear specific numbers");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character


                switch (choice) {
                    case 1:
                        System.out.println("Enter an element:");
                        int element = getUserInputInt(scanner);
                        matList.add(element);
                        break;
                    case 2:
                        System.out.println("Enter multiple elements separated by spaces:");
                        Integer[] intNumbers = getUserInputIntArray(scanner);
                        matList.add(intNumbers);
                        break;
                case 3:
                    System.out.println("Enter elements to join separated by spaces:");
                    String input3 = scanner.nextLine();
                    String[] numbers3 = input3.split(" ");
                    Integer[] intNumbers3 = new Integer[numbers3.length];
                    for (int i = 0; i < numbers3.length; i++) {
                        intNumbers3[i] = Integer.parseInt(numbers3[i]);
                    }
                    MatList<Integer> otherList = new MatList<>(intNumbers3);
                    matList.join(otherList);
                    break;
                case 4:
                    System.out.println("Enter elements for intersection separated by spaces:");
                    String input4 = scanner.nextLine();
                    String[] numbers4 = input4.split(" ");
                    Integer[] intNumbers4 = new Integer[numbers4.length];
                    for (int i = 0; i < numbers4.length; i++) {
                        intNumbers4[i] = Integer.parseInt(numbers4[i]);
                    }
                    MatList<Integer> intersectList = new MatList<>(intNumbers4);
                    matList.intersection(intersectList);
                    break;
                case 5:
                    matList.sortDesc();
                    matList.print();
                    break;
                case 6:
                    System.out.println("Enter the first index:");
                    int firstIndex = scanner.nextInt();
                    System.out.println("Enter the last index:");
                    int lastIndex = scanner.nextInt();
                    matList.sortDesc(firstIndex, lastIndex);
                    matList.print();
                    break;
                case 7:
                    System.out.println("Enter the element to start sorting from:");
                    int startValue = scanner.nextInt();
                    matList.sortDesc(startValue);
                    matList.print();
                    break;
                case 8:
                    matList.sortAsc();
                    matList.print();
                    break;
                case 9:
                    System.out.println("Enter the first index:");
                    int ascFirstIndex = scanner.nextInt();
                    System.out.println("Enter the last index:");
                    int ascLastIndex = scanner.nextInt();
                    matList.sortAsc(ascFirstIndex, ascLastIndex);
                    matList.print();
                    break;
                case 10:
                    System.out.println("Enter the element to start sorting from:");
                    int ascStartValue = scanner.nextInt();
                    matList.sortAsc(ascStartValue);
                    matList.print();
                    break;
                case 11:
                    System.out.println("Enter the index:");
                    int index = scanner.nextInt();
                    Number num = matList.get(index);
                    System.out.println("Element at index " + index + ": " + num);
                    break;
                case 12:
                    Number max = matList.getMax();
                    System.out.println("Maximum element: " + max);
                    break;
                case 13:
                    Number min = matList.getMin();
                    System.out.println("Minimum element: " + min);
                    break;
                case 14:
                    double average = matList.getAverage();
                    System.out.println("Average value: " + average);
                    break;
                case 15:
                    double median = matList.getMedian();
                    System.out.println("Median: " + median);
                    break;
                case 16:
                    Number[] array = matList.toArray();
                    System.out.println("Array: " + Arrays.toString(array));
                    break;
                case 17:
                    System.out.println("Enter the first index:");
                    int arrFirstIndex = scanner.nextInt();
                    System.out.println("Enter the last index:");
                    int arrLastIndex = scanner.nextInt();
                    Number[] arrayInRange = matList.toArray(arrFirstIndex, arrLastIndex);
                    System.out.println("Array within the specified range: " + Arrays.toString(arrayInRange));
                    break;
                case 18:
                    System.out.println("Enter the first index of the sublist:");
                    int sublistFirstIndex = scanner.nextInt();
                    System.out.println("Enter the last index of the sublist:");
                    int sublistLastIndex = scanner.nextInt();
                    MatList<Integer> cutList = matList.cut(sublistFirstIndex, sublistLastIndex);
                    cutList.print();
                    break;
                case 19:
                    matList.clear();
                    System.out.println("Collection cleared.");
                    break;
                case 20:
                    System.out.println("Enter numbers to clear separated by spaces:");
                    String numbersToClear = scanner.nextLine();
                    String[] clearNumbers = numbersToClear.split(" ");
                    Integer[] intClearNumbers = new Integer[clearNumbers.length];
                    for (int i = 0; i < clearNumbers.length; i++) {
                        intClearNumbers[i] = Integer.parseInt(clearNumbers[i]);
                    }
                    matList.clear(intClearNumbers);
                    break;
                    case 0:
                        System.out.println("Thank you for using the program. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
        }
    }
}