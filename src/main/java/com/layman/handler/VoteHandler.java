package com.layman.handler;

import com.layman.entity.VoteMessage;
import com.layman.utils.JsonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName VoteHandler
 * @Description TODO
 * @Author 叶泽文
 * @Data 2019/9/19 19:29
 * @Version 3.0
 **/
public class VoteHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    Logger logger = LoggerFactory.getLogger(VoteHandler.class.getName());

    private static List<ChannelHandlerContext> clients = new ArrayList<>();

    /**
     * @Author 叶泽文
     * @Description 信道消息读取
     * @Date 19:30 2019/9/19
     * @Param [ctx, msg]
     * @return void
     **/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println(msg);
    }


    /**
     * @Author 叶泽文
     * @Description 新建连接时触发执行
     * @Date 15:33 2019/9/10
     * @Param [ctx]
     * @return void
     **/
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx);
    }


    /**    
     * @Author 叶泽文
     * @Description 消息解析
     * @Date 22:58 2019/9/21
     * @Param [msg]
     * @return com.layman.entity.VoteMessage
     **/
    private static VoteMessage parseMsg(TextWebSocketFrame msg) {
        //获取客户端传输过来的消息
        String content = msg.text();

        VoteMessage customerMessage = JsonUtils.jsonToPojo(content, VoteMessage.class);

        return customerMessage;
    }
}
