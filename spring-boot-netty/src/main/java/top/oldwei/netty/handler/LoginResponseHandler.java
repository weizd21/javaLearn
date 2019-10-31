package top.oldwei.netty.handler;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import top.oldwei.netty.domain.LoginResponsePacket;
import top.oldwei.netty.util.LoginUtil;

/**
 * @Author:weizd
 * @Date:19-10-30
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    private final static Log logger = LogFactory.get();

//    private WebSocketServerHandshakerFactory webSocketServerHandshakerFactory ;


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {


//        logger.info("---> loginResponseHandler:{}", JSONObject.toJSONString(loginResponsePacket));


        LoginUtil.markAsLogin(channelHandlerContext.channel());




    }
}
