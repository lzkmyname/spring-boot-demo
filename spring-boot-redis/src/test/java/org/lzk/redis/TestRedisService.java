package org.lzk.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lzk.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisService {
    @Autowired
    private RedisService redisService;

    @Test
    public void testString() throws Exception {
        redisService.set("neo", "ityouknow");
        Assert.assertEquals("ityouknow", redisService.get("neo"));
    }
}
