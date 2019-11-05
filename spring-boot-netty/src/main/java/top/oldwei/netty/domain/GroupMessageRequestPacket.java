package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-11-5
 */
@Data
public class GroupMessageRequestPacket extends Packet {

    private String groupName;

    private String msg;


    @Override
    public Byte getCommand() {
        return Command.SEND_GROUP_MESSAGE_REQUEST;
    }
}
