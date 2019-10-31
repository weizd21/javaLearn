package top.oldwei.netty.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session implements Serializable {

    private String userId;

    private String userName;

}
