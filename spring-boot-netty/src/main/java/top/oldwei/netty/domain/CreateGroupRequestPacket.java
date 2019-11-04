package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.base.PacketCodeC;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-11-4
 */
@Data
public class CreateGroupRequestPacket extends Packet {

    private String groupName;

    private String groupId;


    @Override
    public Byte getCommand() {
        return Command.CREATE_GROUP_REQUEST;
    }
}
