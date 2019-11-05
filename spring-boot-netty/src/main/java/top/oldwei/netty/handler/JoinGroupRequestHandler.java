package top.oldwei.netty.handler;

import cn.hutool.core.util.StrUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;
import top.oldwei.netty.constant.Attribute;
import top.oldwei.netty.domain.JoinGroupRequestPacket;
import top.oldwei.netty.util.ObjUtil;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket>{

    private final static Logger logger = LoggerFactory.getLogger(JoinGroupRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupRequestPacket joinGroupRequestPacket) throws Exception {
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(joinGroupRequestPacket.getGroupName());

        if(!ObjUtil.isEmpty(channelGroup)){
            logger.info("---> 【{}】加入【{}】成功",channelHandlerContext.channel().attr(Attribute.SESSION).get().getUserName(),joinGroupRequestPacket.getGroupName());
            channelGroup.add(channelHandlerContext.channel());
        }else {
            logger.info("---> 【{}】不存在",joinGroupRequestPacket.getGroupName());
        }

    }
}
