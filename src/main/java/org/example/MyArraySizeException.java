package org.example;

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("матрица должна быть 4x4!");
    }
}