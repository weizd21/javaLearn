package top.oldwei.netty.serializer;

import com.alibaba.fastjson.JSONObject;
import top.oldwei.netty.constant.SerializerAlgorithm;

/**
 * @Author:weizd
 * @Date:19-10-28
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSONObject.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSONObject.parseObject(bytes,clazz);
    }
}
