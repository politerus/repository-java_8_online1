package ua.com.alevel;



import java.util.*;

public class MatList<T extends Number & Comparable<? super T>> {
    private final List<T> data;
    //  private List<Integer> elements;


    public MatList() {
      data = new LinkedList<>();
   }
    public void sortAscFromElement(T value) {
                int startIndex = data.indexOf(value);

        if (startIndex != -1) {
            List<T> sublist = data.subList(startIndex, data.size());
            sublist.sort(Comparator.comparingDouble(Number::intValue));
        } else {
            System.out.println("Элемент не найден в списке.");
        }
    }
    @SafeVarargs
    public MatList(T[]... numbers) {
        this();
        for (T[] arr : numbers) {
            if (arr != null) {
                data.addAll(Arrays.asList(arr));
            }
        }
    }



    public void add(T n) {
        data.add(n);
    }


    @SafeVarargs
    public final void join(MatList<T>... ml) {
        for (MatList<T> list : ml) {
            data.addAll(list.data);
        }
    }



    public void sortDesc() {
        data.sort(Collections.reverseOrder());
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < data.size()) {
            List<T> sublist = data.subList(firstIndex, lastIndex + 1);
            sublist.sort(Collections.reverseOrder());
        }
    }

    public void sortDesc(T value) {
        int index = data.indexOf(value);
        if (index >= 0) {
            sortDesc(index, data.size() - 1);
        }
    }

    public void sortAsc() {
        data.sort(Comparable::compareTo);
    }


    public Number get(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        }
        return null;
    }

    public Number getMax() {
        if (!data.isEmpty()) {
            return data.stream()
                    .max(Comparator.naturalOrder())
                    .get();
        }
        return null;
    }

    public Number getMin() {
        if (!data.isEmpty()) {
            return data.stream()
                    .min(Comparator.naturalOrder())
                    .get();
        }
        return null;
    }

    public Number getAverage() {
        if (!data.isEmpty()) {
            double sum = data.stream()
                    .mapToDouble(Number::doubleValue)
                    .sum();
            return sum / data.size();
        }
        return null;
    }

    public Number getMedian() {
        if (!data.isEmpty()) {
            List<T> sortedData = new ArrayList<>(data);
            sortedData.sort(Comparator.naturalOrder());

            int middle = sortedData.size() / 2;
            if (sortedData.size() % 2 == 0) {
                return (sortedData.get(middle - 1).doubleValue() + sortedData.get(middle).doubleValue()) / 2;
            } else {
                return sortedData.get(middle);
            }
        }
        return null;
    }

    public Number[] toArray() {
        return data.toArray(new Number[0]);
    }





    public void clear() {
        data.clear();
    }



    public void print() {
        System.out.println(data);
    }

    public MatList<T> cut(int firstIndex, int lastIndex) {
        MatList<T> cutList = new MatList<>();

        if (firstIndex >= 0 && firstIndex <= lastIndex && lastIndex < data.size()) {
            cutList.data.addAll(data.subList(firstIndex, lastIndex + 1));
        } else {
            System.out.println("Некорректные индексы для вырезания подсписка.");
        }

        return cutList;
    }


    public Number[] toArrayWithIndices() {
        Number[] array = new Number[data.size()];
        for (int i = 0; i < data.size(); i++) {
            array[i] = data.get(i);
        }
        return array;
    }
    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < data.size()) {
            List<T> sublist = data.subList(firstIndex, lastIndex + 1);
            sublist.sort(Comparator.naturalOrder());
        }
    }

    public void removeElement(int element) {
        if (data != null) {
            // Удаляем элемент из списка
            data.removeIf(item -> item.intValue() == element);
        }
    }

}
