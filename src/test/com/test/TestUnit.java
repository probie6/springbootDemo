package com.test;

import org.junit.Test;

/**
 * @author caomin
 * @date 2018/2/12
 * @说明
 */
public class TestUnit {

    @Test
    public void  test(){
        final Holder holder = TestFinal.holder;

        System.out.println(holder.getCount()+"===");
        holder.setCount(11);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(holder.getCount()+"child");
            }
        };
        runnable.run();
    }

}
