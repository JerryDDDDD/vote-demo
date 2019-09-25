package com.layman.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName HeartBeatHandler
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/9 16:37
 * @Version 3.0
 **/
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class.getName());

    /**
     * @return void
     * @Author 叶泽文
     * @Description 用户时间触发
     * @Date 17:04 2019/9/9
     * @Param [ctx, evt]
     **/
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                // 读空闲
                case READER_IDLE: {
                    logger.info("信道\"" + ctx.channel().id() + "\"读空闲");
                    break;
                }
                // 写空闲
                case WRITER_IDLE: {
                    logger.info("信道\"" + ctx.channel().id() + "\"写空闲");
                    break;
                }
                // 读写空闲
                case ALL_IDLE: {
                    // 关闭channel
                    logger.info("信道\"" + ctx.channel().id() + "\"读写空闲");
                    ctx.channel().close();
                    break;
                }
            }
        }
    }
}
