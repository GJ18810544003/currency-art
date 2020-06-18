package com.twilight.currency.art.first;

import java.util.Queue;

/**
 * @Description:
 * @Author: guojun
 * @Date: 2020/6/17
 */
public class ProducerAndConsumer {

    private Queue queue;
    private int MAX_SIZE=20;

    public void producer() {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.add(null);
            queue.notifyAll();
        }

    }

    public void consumer() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            queue.poll();
            queue.notifyAll();
        }


    }

}
