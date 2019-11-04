package top.oldwei.netty.util;

import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import top.oldwei.netty.constant.Attribute;
import top.oldwei.netty.domain.Session;

import java.util.Map;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public class SessionUtil {

    private final static  Map<String, ChannelGroup> groupIdChannelGroupMap = Maps.newConcurrentMap();

    private final static Map<String, Channel> userNameSessionMap = Maps.newConcurrentMap();


    public static void bindSession(Session session, Channel channel){
        channel.attr(Attribute.SESSION).set(session);
        userNameSessionMap.put(session.getUserName(),channel);
    }


    public static Session getSession(Channel channel){
        return channel.attr(Attribute.SESSION).get();
    }


    public static Channel getChannel(String userId){
        return userNameSessionMap.get(userId);
    }


    public static boolean isLogin(Channel channel){
        return channel.hasAttr(Attribute.SESSION);
    }


    public static void addChannelGroup(String groupId,ChannelGroup channelGroup){
        groupIdChannelGroupMap.put(groupId,channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupId){
        return groupIdChannelGroupMap.get(groupId);
    }


}
