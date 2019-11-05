package top.oldwei.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.GroupMessageResponsePacket;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    private final static Logger logger = LoggerFactory.getLogger(GroupMessageResponseHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        logger.info("群组【{}】收到【{}】的消息【{}】",groupMessageResponsePacket.getGroupName(),groupMessageResponsePacket.getFromUserName(),groupMessageResponsePacket.getMsg());

    }
}
