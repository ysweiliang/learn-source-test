package cn.yuans.test.netty.serialize.Impl;

import cn.yuans.test.netty.serialize.Serializer;
import cn.yuans.test.netty.serialize.SerializeAlgorithm;
import com.alibaba.fastjson.JSON;

/**
 * 使用fastjson做序列化工具实现
 *
 * @author ys
 * @create 2021/10/27 14:37
 */
public class JSONSerializer implements Serializer {

    @Override
    public byte getSerializerAlgorithm() {
        return SerializeAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
