package com.ro0sterjam.ctci;

/**
 * Created by kenwang on 2016-05-06.
 */
public class Binary {

    public static String toBinary(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while (value > 0) {
            binary.append(value % 2);
            value = value >> 1;
        }
        return binary.reverse().toString();
    }

    public static String toBinary(double value) {
        if (value == 0.0) {
            return "0.0";
        }
        StringBuilder binary = new StringBuilder("0.");
        double place = 0.5;
        while (place > 0.0000000001 && value > 0) {
            if (value >= place) {
                binary.append(1);
                value -= place;
            } else {
                binary.append(0);
            }
            place /= 2.0;
        }
        return binary.toString();
    }

    public static int fromBinary(String binary) {
        int n = 0;
        for (char c : binary.toCharArray()) {
            n <<= 1;
            if (c == '1') {
                n += 1;
            }
        }
        return n;
    }

    public static int replace(int target, int source, int start, int end) {
        int mask = (~0 << (start + 1)) | ((1 << end) - 1);
        target &= mask;
        source <<= end;
        return target | source;
    }

    public static int nextWithSameParity(int n) {
        if (n == 0 || n == Integer.MAX_VALUE) {
            return -1;
        }
        int offset = 0;
        while (n % 2 == 0) {
            offset++;
            n /= 2;
        }
        int mask = 1;
        while (n % 2 == 1) {
            mask <<= 1;
            offset++;
            n /= 2;
            if (n == 0) {
                return -1;
            }
        }
        n += 1;
        n <<= offset;
        mask = (mask >> 1) - 1;
        return n | mask;
    }

    public static int prevWithSameParity(int n) {
        if (n == 0 || n == Integer.MAX_VALUE) {
            return -1;
        }
        int mask = 1;
        int offset = 0;
        while (n % 2 == 1) {
            mask <<= 1;
            offset++;
            n /= 2;
        }
        mask = (mask << 1) - 1;
        while (n % 2 == 0) {
            mask <<= 1;
            offset++;
            n /= 2;
            if (n == 0) {
                return -1;
            }
        }
        n -= 1;
        n <<= offset;
        mask = (mask >> 1);
        return n | mask;
    }

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }
}
