package test;

import test.Exception.ElementNotFoundException;
import test.Exception.NextNullException;
import test.Exception.NextOneException;

import java.util.Arrays;

public class IntListenImpl implements Listen {

    private Integer[] storage;
    private static final int DEFAULT_CAPACITY = 100;
    private int size;

    IntListenImpl() {
        this.storage = new Integer[DEFAULT_CAPACITY];
    }


    @Override
    public Integer add(Integer item) {
        checkIfNull(item);
        if (size == storage.length) {
            growStorage();
        }
        storage[size++] = item;
        return item;
    }


    private void growStorage() {
        int newCapacity = (int) (storage.length * 1.5);
        storage = Arrays.copyOf(storage, newCapacity);
    }


    @Override
    public Integer add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new NextOneException("Элемент индекса");
        }
        checkIfNull(item);
        if (size == storage.length) {
            growStorage();
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }


    private void checkIfNull(Integer item) {
        if (item == null) {
            throw new NextNullException("Вводимые параметры NULL");
        }

    }


    @Override
    public Integer set(int index, Integer item) {
        checkIfNull(item);
        if (index < 0 || index > size) {
            throw new NextOneException("Элемент индекса");
        }
        Integer lastElement = storage[index];
        storage[index] = item;
        return lastElement;
    }


    @Override
    public Integer remove(Integer item) {
        checkIfNull(item);
        int removeElementIndex = indexOf(item);

        if (removeElementIndex == -1) {
            throw new ElementNotFoundException("Элемент не найден");
        }
        System.arraycopy(storage, removeElementIndex, storage, removeElementIndex + 1,
                size - removeElementIndex);
        size--;
        return item;
    }


    @Override
    public Integer remove(int index) {
        if (index < 0 || index > size) {
            throw new NextOneException("Элемент индекса");
        }
        Integer removeElement = storage[index];
        System.arraycopy(storage, index, storage, index + 1,
                size - index);
        size--;
        return removeElement;
    }


    @Override
    public boolean contains(Integer item) {
        checkIfNull(item);
        Integer[] storageCopy = storage.clone();
        //sortSelection(storageCopy);
        quickSort(storageCopy, 0, storageCopy.length -1);
        return binarySearch(storageCopy, item) != -1;
    }

    private void quickSort(Integer[] storageCopy, int begin, int end) {
        if (begin < end){
           int partitionIndex = partition(storageCopy, begin, end);

           quickSort(storageCopy, begin, partitionIndex - 1);
           quickSort(storageCopy, partitionIndex + 1, end);
        }
    }
    private static int partition(Integer[] arr, int begin, int end){
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++  ) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, 1, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }


    private Integer binarySearch(Integer[] array, Integer element) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element.equals(array[mid])) {
                return mid;
            }
            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }


    // private void sortSelection(Integer[] arr) {
        //for (int i = 0; i < arr.length - 1; i++) {
           // int minElementIndex = i;
           // for (int j = i + 1; j < arr.length; j++) {
             //   if (arr[j] < arr[minElementIndex]) {
               //     minElementIndex = j;
              //  }
           // }
           // swapElements(arr, i, minElementIndex);
        //}
   // }

    public static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    @Override
    public int indexOf(Integer item) {
        checkIfNull(item);
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkIfNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > size) {
            throw new NextOneException("Элемент индекса");
        }

        return storage[index];
    }

    @Override
    public boolean equals(Listen otherList) {
        if (otherList == null || size != otherList.size()) {
            return false;
        }
        for (int i = 0; i <= size - 1; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }

        return true;
    }


        @Override
        public int size () {
            return size;
        }

        @Override
        public boolean isEmpty () {
            return size == 0;
        }

        @Override
        public void clear () {
        storage = new Integer[DEFAULT_CAPACITY];
        size = 0;
        }

        @Override
        public Integer[] toArray () {
            return Arrays.copyOf(storage, size);
        }
    }


