package cn.personalweb.test;

import java.util.LinkedHashMap;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-11-30 23:25
 **/
public class LRU extends LinkedHashMap<Integer, Integer> {
    public LRU(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
}
