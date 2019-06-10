package com.test.thread;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by ban on 2018/6/15.
 * 将集合拆分为队列任务并适用设定的线程执行
 */
@Component
public class QueueThreadUtils {
    //DI

    @Autowired(required = false)
    @Qualifier(value = "threadPool")
    private ThreadPoolTaskExecutor threadPool;

    private Logger logger = Logger.getLogger(QueueThreadUtils.class);
    //DI END

    /**
     * 将集合拆分为多个集合，分给多线程处理，并提供回调在原函数中处理回调逻辑
     *
     * @param listSize   单线程执行的集合大小 示例：list的size为100，listSize为10，则将list分为以大小10为单元的最小集合
     * @param threadSize 线程数量（此线程的配置要结合线程池的核心线程数使用）
     * @param list       想要分配的集合
     * @param callBack   回调函数
     * @param <T>        集合类型
     * @throws Exception 异常需要捕获
     */
    public <T> void executeListData(int listSize, int threadSize, List<T> list, CallBack<String, List<T>> callBack) throws Exception {
        if (list == null || list.size() <= 0) {
            logger.info("集合数据为空");
            return;
        }
        //获取集合内容
        //每个队列的数据量
        int size = listSize;
        //计算需要截取的长度
        int length = list.size() / size;
        if (list.size() % size > 0) {
            length = length + 1;
        }
        // 创建任务队列
        LinkedBlockingDeque<List<T>> accumulateQueue = new LinkedBlockingDeque<>(length);
        int step = 0;
        //拆分集合
        for (int i = 0; i < length; i++) {
            //计算需要截取的数据
            List<T> chartList = list.subList(step, list.size() - step > size ? step + size : list.size());
            //计算步长
            if (list.size() - step > size) {
                step += size;
            } else {
                //若计算的数量大于步长，则为最后一次计数
                step = list.size();
            }
            //加入队列
            accumulateQueue.offer(chartList);
        }
        // 定义线程监视器
        Map<Integer, Future<String>> results = new HashMap<>();
        // 创建线程任务，并放入线程池
        // 线程数
        int threadCount = threadSize;
        for (int i = 0; i < threadCount; i++) {
            // 延迟10毫秒开始执行线程
            TaskCallable task = new TaskCallable(callBack, accumulateQueue, 10);
            //执行
            results.put(i, threadPool.submit(task));
        }

    }

    /**
     * 集合数据较少，直接分成队列任务
     *
     * @param threadSize 线程数量
     * @param list       要加入队列的集合
     * @param callBack   回调
     * @param <T>        集合类型
     * @throws Exception
     */
    public <T> void executeData(int threadSize, List<T> list, CallBack<String, T> callBack) throws Exception {
        if (list == null || list.size() <= 0) {
            logger.info("集合数据为空");
            return;
        }
        //队列的数据量
        int length = list.size();
        // 创建任务队列
        LinkedBlockingDeque<T> accumulateQueue = new LinkedBlockingDeque<>(length);
        for (int i = 0; i < length; i++) {
            T data = list.get(i);
            //加入队列
            accumulateQueue.offer(data);
        }

        // 定义线程监视器
        Map<Integer, Future<String>> results = new HashMap<>();
        // 创建线程任务，并放入线程池
        // 线程数
        int threadCount = threadSize;
        for (int i = 0; i < threadCount; i++) {
            // 延迟10毫秒开始执行线程
            TaskCallable task = new TaskCallable(callBack, accumulateQueue, 10);
            //执行
            results.put(i, threadPool.submit(task));
        }

    }

}
