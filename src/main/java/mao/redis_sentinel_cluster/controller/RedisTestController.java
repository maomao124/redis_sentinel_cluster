package mao.redis_sentinel_cluster.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：redis_sentinel_cluster
 * Package(包名): mao.redis_sentinel_cluster.controller
 * Class(类名): RedisTestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/5/23
 * Time(创建时间)： 12:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
public class RedisTestController
{
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("set/{key}/{value}")
    public Boolean set(@PathVariable String key, @PathVariable String value)
    {
        stringRedisTemplate.opsForValue().set(key, value);
        return true;
    }

    @GetMapping("get/{key}")
    public String get(@PathVariable String key)
    {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
