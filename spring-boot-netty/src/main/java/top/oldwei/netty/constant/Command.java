package top.oldwei.netty.constant;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte CREATE_GROUP_REQUEST = 5;

    Byte CREATE_GROUP_RESPONSE = 6;

    Byte JOIN_GROUP_REQUEST = 7;

    Byte JOIN_GROUP_RESPONSE = 8;

    Byte SEND_GROUP_MESSAGE_REQUEST = 9;

    Byte SEND_GROUP_MESSAGE_RESPONSE = 10;


    String LOGIN = "login";

    String SEND_MESSAGE = "sendMsg";

    String CREATE_GROUP = "createGroup";

    String JOIN_GROUP = "joinGroup";

    String SEND_CROUP_MSG = "sendGroupMsg";


}
