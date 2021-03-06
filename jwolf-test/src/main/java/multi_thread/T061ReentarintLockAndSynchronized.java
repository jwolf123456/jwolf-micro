package multi_thread;

/**
 * 1.首先synchronized是java内置关键字，在jvm层面，Lock是个java类；
 * <p>
 * 2.synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁；
 * <p>
 * 3.synchronized会自动释放锁(a 线程执行完同步代码会释放锁 ；b 线程执行过程中发生异常会释放锁)，Lock需在finally中手工释放锁（unlock()方法释放锁），否则容易造成线程死锁；
 * <p>
 * 4.用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2则会一直等待下去，而Lock锁就不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了；
 * <p>
 * 5.synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平（两者皆可）
 */
public class T061ReentarintLockAndSynchronized {
    public static void main(String[] args) {
        T061ReentarintLockAndSynchronized test = new T061ReentarintLockAndSynchronized();
        test.method1();

    }

    private synchronized void method1() {
        System.out.println(Thread.currentThread().getId() + "<<method1");
        method2();

    }

    private synchronized void method2() {
        System.out.println(Thread.currentThread().getId() + "<<method2");
    }
}