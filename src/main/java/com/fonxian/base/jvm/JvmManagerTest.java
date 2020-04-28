package com.fonxian.base.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * @author Michael Fang
 * @since 2020-04-22
 */
public class JvmManagerTest {

    public static void main(String[] args) {
        System.out.println("===============程序运行参数==================");
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
//JVM启动参数
        System.out.println(runtimeMXBean.getInputArguments());
//系统属性
        System.out.println(runtimeMXBean.getSystemProperties());
//JVM名字
        System.out.println(runtimeMXBean.getVmName());


        System.out.println("================内存状态===========================");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
//获取堆内存使用情况，包括初始大小，最大大小，已使用大小等，单位字节
        System.out.println(memoryMXBean.getHeapMemoryUsage().toString());
//获取堆外内存使用情况。
        System.out.println(memoryMXBean.getNonHeapMemoryUsage().toString());

        System.out.println("================堆内存状态======================");
//这里会返回老年代，新生代等内存区的使用情况，按需自取就好
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        memoryPoolMXBeans.forEach((pool) -> {
            System.out.println(pool.getName());
            System.out.println(pool.getUsage());
        });


    }

}
