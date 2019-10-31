package top.oldwei.netty.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.oldwei.netty.domain.LoginRequestPacket;
import top.oldwei.netty.domain.LoginResponsePacket;
import top.oldwei.netty.domain.Session;
import top.oldwei.netty.util.LoginUtil;
import top.oldwei.netty.util.SessionUtil;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    private final static Log logger = LogFactory.get();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestPacket) throws Exception {


        logger.info("--->loginRequestHandler:{}", JSONObject.toJSONString(loginRequestPacket));
        // 验证登录信息合法性

        // 合法则记录登录回话
        SessionUtil.bindSession(new Session(loginRequestPacket.getUserId().toString(),loginRequestPacket.getUsername()),channelHandlerContext.channel());

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setMsg("connect success");
        loginResponsePacket.setSuccess(true);


        channelHandlerContext.channel().writeAndFlush(loginResponsePacket);

    }
}
