package com.smart.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 简单的ThreadLocal实现版本
 */
public class SimpleThreadLocal {

    // 键为线程对象，值为本线程的变量副本
    private Map<Thread, Object> valueMap = Collections.synchronizedMap(new HashMap<Thread, Object>());

    public void set(Object value)
    {
        valueMap.put(Thread.currentThread(), value);
    }

    public Object get()
    {
        Thread currentThread = Thread.currentThread();
        Object o = valueMap.get(currentThread);
        if (o == null && !valueMap.containsKey(currentThread))
        {
            o = initialValue();
            valueMap.put(currentThread, o);
        }
        return o;
    }

    public void remove()
    {
        valueMap.remove(Thread.currentThread());
    }

    public Object initialValue()
    {
        return null;
    }

}
