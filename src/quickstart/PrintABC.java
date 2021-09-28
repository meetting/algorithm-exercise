package quickstart;


/**
 * <p>
 * Description：三个线程交替打印 “a” “b” “c”
 * <p>
 * 解题思路 ：synchronized + wait + notifyAll
 *
 *
 *
 * <p>
 *
 * @author 余新洁
 * @since 2021/6/2
 */
public class PrintABC {

    private Object lock = new Object();
    // 也可以是使用这个原子类，因为通过sync锁住了
    private volatile int currentCount = 0;

    class MyThread extends Thread {
        private String val;
        private int runFlag;

        public MyThread(String val, int runFlag) {
            this.val = val;
            this.runFlag = runFlag;
        }

        @Override
        public void run() {
            /**
             * 如果不使用lock控制，会出现多打印的情况，加上lock就不会
             * 原因：在运行到currentCount=8后，可能有多个线程执行到sync，然后"C"线程执行了
             * 此时currentCount=9，按道理说其他线程也该不能继续执行，但由于之前判断的时候是currentCount=8，所以这些线程此时进入sync，
             * 那么虽然之前判断等于8，但内部再获取值后判断的结果是9.
             *
             * 解决超出打印的方法
             * （1）使用双检锁的方式，在进入sync后在检查一次。
             * （2）wait + notifyAll
             */
            while (currentCount < 9) {
                synchronized (lock) {
                    // if (currentCount.get() < 9) {
                        if (currentCount % 3 == runFlag) {
                            System.out.println(val);
                            currentCount ++;
                            lock.notifyAll();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    // }
                }
            }
            // System.out.println(currentCount);

        }
    }


    public static void main(String[] args) {
        PrintABC abc = new PrintABC();
        PrintABC.MyThread thread1 = abc.new MyThread("A", 0);
        PrintABC.MyThread thread2 = abc.new MyThread("B", 1);
        PrintABC.MyThread thread3 = abc.new MyThread("C", 2);
        thread1.start();
        thread2.start();
        thread3.start();


    }

}
