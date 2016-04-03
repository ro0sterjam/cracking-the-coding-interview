package com.ro0sterjam.ctci;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by kenwang on 2016-03-13.
 */
public class Arrays {

    public static <T> boolean containsDistinct(T[] a) {
        if (a.length == 0) {
            return true;
        }

        Set<T> seen = new HashSet<>();
        for (T t : a) {
            if (seen.contains(t)) {
                return false;
            } else {
                seen.add(t);
            }
        }
        return true;
    }

    public static <T> void reverseInPlace(T[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            swap(a, i++, j--);
        }
    }

    public static <T> boolean arePermutations(T[] a1, T[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        Map<T, Integer> counter = new HashMap<>();
        for (T t : a1) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }
        for (T t : a2) {
            if (counter.getOrDefault(t, 0) == 0) {
                return false;
            } else {
                counter.put(t, counter.get(t) - 1);
            }
        }
        return true;
    }

    public static <T> void rotate(T[][] matrix) {
        if (matrix.length > 0 && matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Dimensions of matrix must be equal");
        }
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                T temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }

    public static void cascadeZeroes(int[][] matrix) {
        int[] cols = new int[matrix.length];
        int[] rows = new int[matrix.length > 0? matrix[0].length : 0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    cols[i] = 1;
                    rows[j] = 1;
                }
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == 1) {
                matrix[i] = new int[matrix[i].length];
            }
        }
        for (int j = 0; j < rows.length; j++) {
            if (rows[j] == 1) {
               for (int i = 0; i < matrix.length; i++) {
                   matrix[i][j] = 0;
               }
            }
        }
    }

    public static <T> T[] resizeArray(T[] a, int size) {
        T[] a2 = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
        copyElements(a, a2);
        return a2;
    }

    public static <T> void copyElements(T[] source, T[] target) {
        for (int i = 0; i < source.length && i < target.length; i++) {
            target[i] = source[i];
        }
    }

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
