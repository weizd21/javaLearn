package top.oldwei.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.GroupMessageRequestPacket;
import top.oldwei.netty.domain.GroupMessageResponsePacket;
import top.oldwei.netty.util.ObjUtil;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {

    private final static Logger logger = LoggerFactory.getLogger(GroupMessageRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageRequestPacket groupMessageRequestPacket) throws Exception {

        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupMessageRequestPacket.getGroupName());
        if(!ObjUtil.isEmpty(channelGroup)){
            GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
            groupMessageResponsePacket.setFromUserName(SessionUtil.getSession(channelHandlerContext.channel()).getUserName());
            groupMessageResponsePacket.setGroupName(groupMessageRequestPacket.getGroupName());
            groupMessageResponsePacket.setMsg(groupMessageRequestPacket.getMsg());
            channelGroup.writeAndFlush(groupMessageResponsePacket);
            logger.info("--->【】群聊发送成功");
        }else {
            logger.info("---> 不存在群聊【{}】",groupMessageRequestPacket.getGroupName());
        }

    }
}
