package top.oldwei.netty.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.oldwei.netty.domain.MessageRequestPacket;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    private final static Log logger = LogFactory.get();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageRequestPacket messageRequestPacket) throws Exception {

        logger.info("---> messageRequestHandler:{}", JSONObject.toJSONString(messageRequestPacket));






    }
}
