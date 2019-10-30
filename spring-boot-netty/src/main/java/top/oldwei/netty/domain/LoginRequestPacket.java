package top.oldwei.netty.domain;

import lombok.Data;
import top.oldwei.netty.constant.Command;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
@Data
public class LoginRequestPacket extends Packet {

    private Long userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
