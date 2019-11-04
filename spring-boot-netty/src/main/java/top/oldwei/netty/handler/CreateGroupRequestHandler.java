package top.oldwei.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-11-4
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestHandler> {

    private final static Logger logger = LoggerFactory.getLogger(CreateGroupRequestHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupRequestHandler createGroupRequestHandler) throws Exception {

        // 创建群聊
        ChannelGroup channelGroup = new DefaultChannelGroup(channelHandlerContext.executor());







    }
}
