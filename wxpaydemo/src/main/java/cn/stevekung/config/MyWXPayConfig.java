package cn.stevekung.config;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

public class MyWXPayConfig extends WXPayConfig{
//    商家注册微信支付之后会生成一个应用ID
    public String getAppID() {
        return "wx632c8f211f8122c6";
    }
//   商户Id
    public String getMchID() {
        return "1497984412";
    }

    public String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    }

    public InputStream getCertStream() {
        return null;
    }

    public IWXPayDomain getWXPayDomain() {
        MyWXPayDomain myWXPayDomain = new MyWXPayDomain();
        return myWXPayDomain;
    }
}
