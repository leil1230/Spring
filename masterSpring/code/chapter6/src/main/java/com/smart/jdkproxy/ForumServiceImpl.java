package com.smart.jdkproxy;

public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        System.out.println("模拟删除Topic记录：" + topicId);

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
