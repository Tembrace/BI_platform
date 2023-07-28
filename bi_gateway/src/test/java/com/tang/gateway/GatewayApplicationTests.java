package com.tang.gateway;

import org.jinyu.common.utils.JsonUtils;
import com.tang.gateway.test.EnvironQueueRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class GatewayApplicationTests {

    @Test
    void contextLoads() {
        String json = "{\n" +
                "  \"collectionTime\": \"2023-05-07 12:20:09\",\n" +
                "  \"environs\": [\n" +
                "    {\"environId\": \"1\", \"temperature\": \"22.1\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"2\", \"temperature\": \"22.2\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"3\", \"temperature\": \"22.3\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"4\", \"temperature\": \"22.4\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"5\", \"temperature\": \"22.6\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"6\", \"temperature\": \"22.7\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"7\", \"temperature\": \"22.9\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"8\", \"temperature\": \"22.8\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"9\", \"temperature\": \"23.1\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"10\", \"temperature\": \"24.1\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"11\", \"temperature\": \"25.1\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"},\n" +
                "    {\"environId\": \"12\", \"temperature\": \"23.2\", \"humidity\": \"20.1\", \"co2\": \"1024\", \"pm25\": \"1024\", \"pm10\": \"1024\"}\n" +
                "  ]\n" +
                "}";
        EnvironQueueRequest request = JsonUtils.parseObject(json, EnvironQueueRequest.class);
        Date collectionTime = request.getCollectionTime();
        System.out.println(collectionTime.toString());
    }

}
