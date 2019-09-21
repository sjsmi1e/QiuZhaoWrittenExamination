import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author smi1e
 * Date 2019/7/26 10:15
 * Description
 */
public class ThreadAlgorithm {

    static class Foo {
        private volatile int flag = 1;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag++;


        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (flag != 2) {
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (flag != 3) {
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    static class FooBar {
        private int n;
        private ReentrantLock lock = new ReentrantLock();
        private Condition fooCon = lock.newCondition();
        private Condition barCon = lock.newCondition();
        private boolean Prifoo = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (!Prifoo) {
                        fooCon.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    Prifoo = false;
                    barCon.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    while (Prifoo) {
                        barCon.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    Prifoo = true;
                    fooCon.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ZeroEvenOdd {
        private int n;
        private ReentrantLock lock = new ReentrantLock();
        private Condition jicondition = lock.newCondition();
        private Condition oucondition = lock.newCondition();
        private Condition zerocondition = lock.newCondition();
        private int e = 2;
        private int o = 1;
        private boolean isJoO = true;//true表示可以打印基数了
        //        private int flag = 1;
        private volatile int flag = 0;//0 打印0 1 打印基数 2 打印偶数

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                for (int i = 0; i < n; ) {
                    while (flag != 0) {
                        zerocondition.await();
                    }
                    printNumber.accept(0);
                    if (isJoO) {
                        flag = 1;
                        jicondition.signalAll();
//                        System.out.println(flag);
                    } else {
                        flag = 2;
                        oucondition.signal();
//                        System.out.println(flag);
                    }
                    i++;

                }
            } finally {
                lock.unlock();
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                for (; e <= n; ) {
                    while (flag != 2) {
                        oucondition.await();
                    }
                    printNumber.accept(e);
                    isJoO = true;
                    flag = 0;
                    zerocondition.signalAll();
                    e = e + 2;
                }
            } finally {
                lock.unlock();
            }


        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            try {
                lock.lock();
                for (; o <= n; ) {
                    while (flag != 1) {
                        jicondition.await();
                    }
                    printNumber.accept(o);
                    isJoO = false;
                    flag = 0;
                    zerocondition.signalAll();
                    o = o + 2;
                }
            } finally {
                lock.unlock();
            }


        }
    }


    class H2O {
        private volatile boolean flag = true;//true表示打印H
        private ReentrantLock lock = new ReentrantLock();
        private Condition hcondition = lock.newCondition();
        private Condition ocondition = lock.newCondition();
        private int i = 0;

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException{
            try {
                lock.lock();
                while (!flag) {
                    hcondition.await();
                }
                // releaseHydrogen.run() outputs "H". Do not change or remove this line.
                releaseHydrogen.run();
                i++;
                if (i % 2 == 0) {
                    flag = false;
                    ocondition.signalAll();
                }
            } finally {
                lock.unlock();
            }


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            try {
                lock.lock();
                while (flag) {
                    ocondition.await();
                }
                // releaseOxygen.run() outputs "H". Do not change or remove this line.
                releaseOxygen.run();
                flag = true;
                hcondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(51);
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }

}
