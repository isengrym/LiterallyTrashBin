package sortings;

import java.util.Collections;
import java.util.List;

public class QuickSort implements Sorting {
    @Override
    public List<Integer> sort(List<Integer> items) {
        recursivelySort(items, 0, items.size() - 1);
        return items;
    }

    public void recursivelySort(List<Integer> items, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(items, low, high);
            recursivelySort(items, low, pivotIndex - 1);
            recursivelySort(items, pivotIndex + 1, high);
        }
    }

    private int partition(List<Integer> items, int low, int high) {
        int pivotIndex = high;
        int pivot = items.get(pivotIndex);
        int smallerElementIndex = low - 1;

        for (int loopVariable = low; loopVariable < high; loopVariable++) {
            if (items.get(loopVariable) <= pivot) {
                smallerElementIndex++;
                Collections.swap(items, smallerElementIndex, loopVariable);
            }
        }
        smallerElementIndex++;
        Collections.swap(items, smallerElementIndex, pivotIndex);
        pivotIndex = smallerElementIndex;

        return pivotIndex;
    }

    //Другая реализация
    //    public void recursivelySort(List<Integer> items, int low, int high) {
//        if (low < high) {
//            int pivot = low;
//            int leftPointer = pivot + 1;
//            int rightPointer = high;
//            int pivotValue = items.get(pivot);
//
//            while (leftPointer <= rightPointer) {
//                if (leftPointer <= high && pivotValue >= items.get(leftPointer)) {
//                    leftPointer++;
//                }
//
//                if (rightPointer > low && pivotValue < items.get(rightPointer)) {
//                    rightPointer--;
//                }
//
//                if (leftPointer < rightPointer) {
//                    Collections.swap(items, leftPointer, rightPointer);
//                }
//            }
//            Collections.swap(items, pivot, leftPointer - 1);
//
//            recursivelySort(items, low, rightPointer - 1);
//            recursivelySort(items, rightPointer + 1, high);
//        }
//    }

}
