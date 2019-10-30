package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-10-29
 */
@Data
public class LoginResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }

    private Boolean success;

    private String msg;

}
