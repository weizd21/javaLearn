package top.oldwei.netty.constant;

import io.netty.util.AttributeKey;
import top.oldwei.netty.domain.Session;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
public interface Attribute {


    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");


    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");


}
