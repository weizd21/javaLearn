package top.oldwei.netty.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.oldwei.netty.domain.MessageResponsePacket;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    private final static Log logger = LogFactory.get();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket messageResponsePacket) throws Exception {

        logger.info("---> messageResponseHandler:{}", JSONObject.toJSONString(messageResponsePacket));



    }
}
