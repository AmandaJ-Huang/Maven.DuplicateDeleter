package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    private String[] strArray;

    public StringDuplicateDeleter(String[] strArray) {
        super(strArray);
        this.strArray = sortedArray(strArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int counter = 0;
        int length = strArray.length;

        if (maxNumberOfDuplications == 0 || maxNumberOfDuplications == 1) {
            return new String[0];
        }

        for (int i = 0; i < strArray.length; i++) {
            if (numberOfDuplications(strArray, strArray[i]) >= maxNumberOfDuplications) {
                length = length-numberOfDuplications(strArray, strArray[i]);
                i += numberOfDuplications(strArray, strArray[i])-1;
            }
        }

        String[] newArr = new String[length];

        for (int i = 0; i < strArray.length; i++) {
            if (numberOfDuplications(strArray, strArray[i]) >= maxNumberOfDuplications) {
                continue;
            }
            newArr[counter] = strArray[i];
            counter++;
        }

        return newArr;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int counter = 0;
        int length = strArray.length;

        for (int i = 0; i < strArray.length; i++) {
            if (numberOfDuplications(strArray, strArray[i]) == exactNumberOfDuplications) {
                length = length-exactNumberOfDuplications;
                i += exactNumberOfDuplications-1;
            }
        }

        String[] newArr = new String[length];

        for (int i = 0; i < strArray.length; i++) {
            if (numberOfDuplications(strArray, strArray[i]) == exactNumberOfDuplications) {
                continue;
            }
            newArr[counter] = strArray[i];
            counter++;
        }

        return newArr;
    }

    public Integer numberOfDuplications(String[] arr, String checkStr) {
        Integer counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(checkStr)) {
                counter++;
            }
        }
        return counter;
    }

    public String[] sortedArray(String[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) < 0) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
