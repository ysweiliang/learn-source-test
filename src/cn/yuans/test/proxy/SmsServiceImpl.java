package cn.yuans.test.proxy;

/**
 * @author yuans
 * @create 2021-04-09-15:12
 */
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
