package org.example;

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int column, String value) {
        super("Недопустимый формат данных в ячейке [" + row + "][" + column + "]: " + value);
    }
}