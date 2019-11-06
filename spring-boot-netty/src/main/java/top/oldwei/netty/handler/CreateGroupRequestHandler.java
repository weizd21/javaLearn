package top.oldwei.netty.handler;

import cn.hutool.core.util.StrUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.domain.CreateGroupRequestPacket;
import top.oldwei.netty.domain.CreateGroupResponsePacket;
import top.oldwei.netty.util.ObjUtil;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-11-4
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    private final static Logger logger = LoggerFactory.getLogger(CreateGroupRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {

        System.out.println("------------>");

        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();

        if(ObjUtil.isEmpty(SessionUtil.getChannelGroup(createGroupRequestPacket.getGroupName()))){
            // 创建群聊
            ChannelGroup channelGroup = new DefaultChannelGroup(channelHandlerContext.executor());
            SessionUtil.addChannelGroup(createGroupRequestPacket.getGroupName(),channelGroup);
            logger.info("---> 创建群聊【{}】成功",createGroupRequestPacket.getGroupName());
            createGroupResponsePacket.setMsg("创建成功");
            createGroupResponsePacket.setSuccess(true);
        }else{
            logger.info("---> 群聊【{}】已存在",createGroupRequestPacket.getGroupName());
            createGroupResponsePacket.setMsg("【"+createGroupRequestPacket.getGroupName()+"】"+"已存在");
            createGroupResponsePacket.setSuccess(false);
        }
        channelHandlerContext.channel().writeAndFlush(createGroupResponsePacket);

    }
}
