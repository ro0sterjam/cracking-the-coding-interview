package com.ro0sterjam.ctci;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kenwang on 2016-04-18.
 */
public class Sets {

    public static <T> Set<T> newHashSet(T... elements) {
        Set<T> set = new HashSet<>();
        for (T element: elements) {
            set.add(element);
        }
        return set;
    }

}
