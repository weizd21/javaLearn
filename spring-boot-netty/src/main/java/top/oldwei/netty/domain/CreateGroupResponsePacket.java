package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-11-6
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    private String msg;

    private Boolean success;

    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}
