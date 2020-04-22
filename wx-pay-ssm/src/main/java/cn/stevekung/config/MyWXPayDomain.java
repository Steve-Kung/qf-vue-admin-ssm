package cn.stevekung.config;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;

public class MyWXPayDomain implements IWXPayDomain {
    public void report(String s, long l, Exception e) {

    }

    public DomainInfo getDomain(WXPayConfig wxPayConfig) {
        DomainInfo domainInfo = new DomainInfo("api.mch.weixin.qq.com", true);
        return domainInfo;
    }
}
