package test;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Collections;
import java.util.Properties;
public class CreateTopic {
    public static void main(String[] args) {
        // 配置 Kafka 连接
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // 创建 AdminClient
        try (AdminClient adminClient = AdminClient.create(props)) {
            // 定义 Topic：名称、分区数、副本数
            NewTopic newTopic = new NewTopic("test-topic", 1, (short) 1);
            // 执行创建
            adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
            System.out.println("Topic 'test-topic' 创建成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}