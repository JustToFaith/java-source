package cn.personalweb.test.list;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-12-18 09:59
 **/
public class AutoList<E> {

    public static void main(String[] args) {
        AutoList<Integer> list = new AutoList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println(list.size);
//        list.add(3, 3);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(list.get(i));
//        }

    }


    private static final int DEFAULT_CAPICITY = 10;
    private int size;
    private Object[] elements;
    private int capacity;
    final transient ReentrantLock lock = new ReentrantLock();

    public AutoList() {
        this.capacity = DEFAULT_CAPICITY;
        this.elements = new Object[capacity];
    }

    public AutoList(int initialCapicity) {
        if (initialCapicity > 0) {
            this.capacity = initialCapicity;
            this.elements = new Object[initialCapicity];
        } else if (initialCapicity == 0) {
            this.capacity = 0;
            this.elements = new Object[0];
        } else {
            throw new IllegalArgumentException("argument Excepting" + initialCapicity);
        }
    }

    public boolean add(E e) {
        ReentrantLock lock = this.lock;
        lock.lock();
        try{
            ensurCapacity(size + 1);
            elements[size++] = e;
            return true;
        }finally {
            lock.unlock();
        }

    }


    public boolean add(int index, E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] copyElements = elements;
            int len = copyElements.length;
            if (index < 0 || index > len) {
                throw new IndexOutOfBoundsException();
            }
            ensurCapacity(size + 1);
            if (len == index) {
                add(e);
            } else {
                System.arraycopy(elements, index, e, index + 1, size - index);
                size++;
                elements[index] = e;
                // 5 0~4  1 2 3 4 5  add(3, 3) -> 1 2 3 3 4 5
            }
            return true;
        }finally {
            lock.unlock();
        }
    }

    public boolean ensurCapacity(int ensureSize) {
        if(ensureSize < capacity) {
            return true;
        }else {
            int newCapacity = capacity + (capacity >> 1);

            if(ensureSize > newCapacity) {
                newCapacity = ensureSize + (ensureSize >> 1);
            }
            elements = Arrays.copyOf(elements, newCapacity);
            return true;
        }
    }

    public E get(int index) {
        if (index < size) {
            return (E)elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

}
