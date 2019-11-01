package top.oldwei.netty.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.oldwei.netty.domain.MessageRequestPacket;
import top.oldwei.netty.domain.MessageResponsePacket;
import top.oldwei.netty.domain.Session;
import top.oldwei.netty.util.ObjUtil;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    private final static Log logger = LogFactory.get();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageRequestPacket messageRequestPacket) throws Exception {

        logger.info("---> messageRequestHandler:{}", JSONObject.toJSONString(messageRequestPacket));

        // 获取此channel的回话信息
        Session session = SessionUtil.getSession(channelHandlerContext.channel());

        // 根据
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMsg(messageRequestPacket.getMsg());
        messageResponsePacket.setFromUserName(session.getUserName());

        // 获取接收方的 channel
        Channel receiveChannel = SessionUtil.getChannel(messageRequestPacket.getToUserName());
        if(!ObjUtil.isEmpty(receiveChannel) && SessionUtil.isLogin(receiveChannel)){
            receiveChannel.writeAndFlush(messageResponsePacket);
        }else {
            logger.info("---> 用户【{}】离线中",messageRequestPacket.getToUserName());
        }





    }
}
