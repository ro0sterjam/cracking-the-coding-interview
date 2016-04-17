package com.ro0sterjam.ctci;

import java.lang.reflect.Array;
import java.util.*;

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

    public static <T extends Comparable<T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static <T extends Comparable<T>> T quickselect(T[] a, int k) {
        if (k < 1 || k > a.length) {
            throw new IllegalArgumentException("k must be between 1 and a.length (inclusive)");
        }
        return quickselect(a, 0, a.length - 1, k);
    }

    public static <T extends Comparable<T>> Set<T> quickselectArray(T[] a, int k) {
        if (k < 1 || k > a.length) {
            throw new IllegalArgumentException("k must be between 1 and a.length (inclusive)");
        }
        quickselect(a, 0, a.length - 1, k);
        Set<T> results = new HashSet<>();
        for (k--; k >= 0; k--) {
            results.add(a[k]);
        }
        return results;
    }

    public static <T> Set<T> asSet(T[] a) {
        Set<T> set = new HashSet<>();
        for (T element : a) {
            set.add(element);
        }
        return set;
    }

    private static <T extends Comparable<T>> T quickselect(T[] a, int i, int j, int k) {
        int pivot = partition(a, i, j);
        if (pivot == k - 1) {
            return a[pivot];
        } else if (pivot > k - 1) {
            return quickselect(a, i, pivot - 1, k);
        } else {
            return quickselect(a, pivot + 1, j, k);
        }
    }

    private static <T extends Comparable<T>> void quicksort(T[] a, int i, int j) {
        if (i >= j) {
            return;
        }
        int pivot = partition(a, i, j);
        quicksort(a, i, pivot - 1);
        quicksort(a, pivot + 1, j);
    }

    private static <T extends Comparable<T>> int partition(T[] a, int i, int j) {
        T pivot = a[(int) Math.random() * (j - i + 1) + i];
        while (i < j) {
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            while (a[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i < j) {
                if (a[i] == a[j]) {
                    i++;
                } else {
                    T tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        return i;
    }

}
