package Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Practice01 {
    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3};
        List<Integer> list = List.of(ints);
        list.forEach(System.out::println);
        System.out.println();
        ints[0]=3;
        list.forEach(System.out::println);

    }
}

/**
 * 静态内部类方式
 */
class Singleton {

    //私有构造方法
    private Singleton() {}

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //对外提供静态方法获取该对象
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}