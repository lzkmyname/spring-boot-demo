package org.lzk.activemq;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.activemq.dao.QueueProducer;
import org.lzk.activemq.dao.TopicProducer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveMqTests {
    @Resource

    private QueueProducer producer;

    @Resource(name = "topicProducer")
    
    private TopicProducer topic;


    @Rule
    public OutputCapture outputCapture = new OutputCapture();


    @Test
    public void sendSimpleQueueMessage() throws InterruptedException {
        this.producer.sendQueue("Test queue message");
        Thread.sleep(1000*2L);

    }

    @Test
    public void send100QueueMessage() throws InterruptedException {
        for (int i=0;i<100;i++){
            this.producer.sendQueue("Test queue message"+i);
        }
        Thread.sleep(1000L);
    }
    @Test
    public void sendSimpleTopicMessage() throws InterruptedException {
        this.topic.sendTopic("Test Topic message");
        Thread.sleep(1000L);
    }
}