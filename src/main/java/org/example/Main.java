package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"258745", "211111", "345897", "512574"},
                {"845678", "123123", "225", "343434"},
                {"555544", "891245", "81", "233222"},
                {"377565", "610451", "166375", "159711"}
        };
        try {
            System.out.println("сумма массива: " + method(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        int number;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    number = Integer.parseInt(array[i][j]);
                    sum += number;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
                try {
                    if (isPerfectSquare(number)) {
                        throw new MyPowException(number + " идеальный квадрат");
                    }
                    if (isPerfectCube(number)) {
                        throw new MyPowException(number + " идеальный куб");
                    }
                } catch (MyPowException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }

    public static boolean isPerfectSquare(int number) {
        double squareRoot = Math.sqrt(number);
        return squareRoot % 1 == 0;
    }

    public static boolean isPerfectCube(int number) {
        double cubeRoot = Math.cbrt(number);
        return cubeRoot % 1 == 0;
    }
}