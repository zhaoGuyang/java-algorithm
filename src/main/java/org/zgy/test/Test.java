package org.zgy.test;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author z
 * @create 2022/9/2 16:32
 */
public class Test {
  //共享资源
  static AtomicInteger i = new AtomicInteger(0);

  public static void increase() {
    i.getAndIncrement();
  }

  public static void main(String[] args) throws InterruptedException {
    Runnable r = () -> {
      for (int j = 0; j < 1000; j++) {
        increase();
      }
    };

    List<Thread> threads = new ArrayList<>();
    for (int j = 0; j < 1; j++) {
      Thread thread = new Thread(r);
      threads.add(thread);
      thread.start();
    }

    //确保前面10个线程都走完
    for (Thread thread : threads) {
      thread.join();
    }
    System.out.println(i);
  }
}
