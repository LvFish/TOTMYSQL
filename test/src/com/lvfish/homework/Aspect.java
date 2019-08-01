package com.lvfish.homework;

/**
 *
 * 主要定义两个方法，实现Log和Transaction的接口的解析
 * @author lvFish
 * @date 2019/8/1
 */
public interface Aspect{
    /**
     * 主要表示注解方法运行前的动作
     * @return void
     */
    void before();

    /**
     * 主要表示注解方法运行后的动作
     * @return void
     */
    void after();
}
