package top.oldwei.netty.handler;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:weizd
 * @Date:19-11-6
 */
public class HttpMessageHandler extends SimpleChannelInboundHandler<HttpMessage> {

    private final static Logger loggger = LoggerFactory.getLogger(HttpMessageHandler.class);


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage) throws Exception {
        loggger.info(JSONObject.toJSONString(httpMessage));
    }




}
