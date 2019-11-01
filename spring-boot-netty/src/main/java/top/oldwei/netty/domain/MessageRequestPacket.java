package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
@Data
public class MessageRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }

    private String msg;

    private String toUserName;



}
