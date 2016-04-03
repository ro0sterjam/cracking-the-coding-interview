package main.java;

import static main.java.Arrays.resizeArray;

/**
 * Created by kenwang on 2016-04-02.
 */
public class Strings {

    public static String encodeSpaces(String s) {
        int spaceCount = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        int i = chars.length - 1;
        int j = chars.length + spaceCount * 2 - 1;
        chars = toPrimitiveArray(resizeArray(toObjectArray(chars), j + 1));
        while (i != j) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
                i--;
            } else {
                chars[j--] = chars[i--];
            }
        }
        return new String(chars);
    }

    public static String compress(String s) {
        if (s.length() <= 2) {
            return s;
        }
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            int count = 1;
            while (++i < s.length() && s.charAt(i) == c) {
                count++;
            }
            compressed.append(c).append(count);
        }
        return compressed.length() >= s.length()? s : compressed.toString();
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    private static char[] toPrimitiveArray(Character[] chars) {
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[i] != null? chars[i] : ' ';
        }
        return newChars;
    }

    private static Character[] toObjectArray(char[] chars) {
        Character[] newChars = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[i];
        }
        return newChars;
    }
}
