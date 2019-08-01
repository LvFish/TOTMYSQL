package com.lvfish.test;


import java.util.concurrent.*;

class TestExecutor implements Runnable{

    private int i;
    TestExecutor(int i){
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println("启动线程"+i);
        Thread.yield();
        System.out.println("结束线程"+i);
    }
}

public class ExecutorTest {
    private static final int POOL_NUMBER = 5;
    public static void main(String[] args) {
        System.out.println("---------------------------");
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUMBER; i++) {
            executor.execute(new TestExecutor(i));
        }
        executor.shutdown();
        executor.shutdownNow();
        System.out.println("---------------------------");
        executor = Executors.newCachedThreadPool();
        for (int i = 0; i < POOL_NUMBER; i++) {
            executor.execute(new TestExecutor(i));
        }
        executor.shutdown();
        executor.shutdownNow();
        System.out.println("---------------------------");
        executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < POOL_NUMBER; i++) {
            executor.execute(new TestExecutor(i));
        }
        executor.shutdown();
        executor.shutdownNow();

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and executor every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
        try{
            Thread.sleep(5000);
            scheduledThreadPool.shutdown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        executor = new ThreadPoolExecutor(1,1,0,TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < POOL_NUMBER; i++) {
            executor.execute(new TestExecutor(i));
        }
        executor.shutdown();
        executor.shutdownNow();
    }
}
