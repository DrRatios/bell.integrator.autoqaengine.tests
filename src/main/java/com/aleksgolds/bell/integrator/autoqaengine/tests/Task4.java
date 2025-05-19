package com.aleksgolds.bell.integrator.autoqaengine.tests;

public class Task4 {
    public static void main(String[] args) {
        int[][] testArray = new int[6][6];
        test(testArray);
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                System.out.printf("%4d", testArray[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] test(int[][] array) {
        int firstLenght = array.length;
        int secondLenght = array[0].length;
        if (firstLenght % 2 != 0 || firstLenght != secondLenght) {
            throw new IllegalArgumentException("Размерности массива должен быть равными и чётными!!!");
        }
        int half = firstLenght / 2;
        for (int i = 0; i < firstLenght; i++) {
            for (int j = 0; j < firstLenght; j++) {
                // Расстояние до ближайшего из 4-х центральных нулей
                int dist1 = Math.max(Math.abs(i - (half - 1)), Math.abs(j - (half - 1)));
                int dist2 = Math.max(Math.abs(i - (half - 1)), Math.abs(j - half));
                int dist3 = Math.max(Math.abs(i - half), Math.abs(j - (half - 1)));
                int dist4 = Math.max(Math.abs(i - half), Math.abs(j - half));

                // Минимальное расстояние из четырёх вариантов
                array[i][j] = Math.min(Math.min(dist1, dist2), Math.min(dist3, dist4));
            }
        }
        return array;
    }
}
