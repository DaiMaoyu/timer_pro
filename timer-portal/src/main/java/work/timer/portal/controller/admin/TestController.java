package work.timer.portal.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import work.timer.serivce.api.TestService;

@Controller
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("test")
    public void test(){
//        int count = testService.count();

        redisTemplate.opsForValue().set("daimao","呆猫");
    }

}
