package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    private Integer[] intArray;

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
        this.intArray = sortedArray(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int counter = 0;
        int length = intArray.length;

        if (maxNumberOfDuplications == 0 || maxNumberOfDuplications == 1) {
            return new Integer[0];
        }

        for (int i = 0; i < intArray.length; i++) {
            if (numberOfDuplications(intArray, intArray[i]) >= maxNumberOfDuplications) {
                length = length-numberOfDuplications(intArray, intArray[i]);
                i += numberOfDuplications(intArray, intArray[i])-1;
            }
        }

        Integer[] newArr = new Integer[length];

        for (int i = 0; i < intArray.length; i++) {
            if (numberOfDuplications(intArray, intArray[i]) >= maxNumberOfDuplications) {
                continue;
            }
            newArr[counter] = intArray[i];
            counter++;
        }

        return newArr;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int counter = 0;
        int length = intArray.length;

        for (int i = 0; i < intArray.length; i++) {
            if (numberOfDuplications(intArray, intArray[i]) == exactNumberOfDuplications) {
                length = length-exactNumberOfDuplications;
                i += exactNumberOfDuplications-1;
            }
        }

        Integer[] newArr = new Integer[length];

        for (int i = 0; i < intArray.length; i++) {
            if (numberOfDuplications(intArray, intArray[i]) == exactNumberOfDuplications) {
                continue;
            }
            newArr[counter] = intArray[i];
            counter++;
        }

        return newArr;
    }

    public Integer numberOfDuplications(Integer[] arr, Integer checkNum) {
        Integer counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == checkNum) {
                counter++;
            }
        }
        return counter;
    }

    public Integer[] sortedArray(Integer[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
