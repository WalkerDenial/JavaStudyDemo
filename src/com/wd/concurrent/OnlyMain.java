package com.wd.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 输出线程信息
 */
public class OnlyMain {

    public static void main(String[] args) {
        // 虚拟机线程管理接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 获去线程信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 输出线程信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + " " + threadInfo.getThreadName());
        }
    }

}
