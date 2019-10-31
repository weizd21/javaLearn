package top.oldwei.netty.util;

import cn.hutool.core.util.StrUtil;

/**
 * @Author:weizd
 * @Date:19-10-31
 */
public class ObjUtil extends StrUtil {

    public static boolean isEmpty(Object o){
        return (o == null || "".equals(o));
    }





}
