package com.layman.netty;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName VoteNettyBoot
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/19 19:22
 * @Version 3.0
 **/
@Component
public class VoteNettyBoot implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        VoteNettyServer.getInstance().start();
    }
}
