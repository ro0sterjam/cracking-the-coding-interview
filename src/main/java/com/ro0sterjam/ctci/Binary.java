package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-05-06.
 */
public class Binary {

    public static int[] toBinaryArray(int value) {
        int[] binary = new int[32];
        int i = 32;
        while (value > 0) {
            binary[--i] = value % 2;
            value = value >> 1;
        }
        return binary;
    }

    public static int replace(int target, int source, int start, int end) {
        int mask = (~0 << (start + 1)) | ((1 << end) - 1);
        target &= mask;
        source = source << end;
        return target | source;
    }

}
