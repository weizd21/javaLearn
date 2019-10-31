package top.oldwei.netty.util;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import top.oldwei.netty.constant.Attribute;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
public class LoginUtil {


    public static void markAsLogin(Channel channel){

       channel.attr(Attribute.LOGIN).set(true);

    }


    public static boolean hasLogin(Channel channel){

        return channel.hasAttr(Attribute.LOGIN)? channel.attr(Attribute.LOGIN).get(): false;
    }






}
