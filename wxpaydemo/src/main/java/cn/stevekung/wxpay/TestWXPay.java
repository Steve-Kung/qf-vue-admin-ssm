package cn.stevekung.wxpay;

import cn.stevekung.config.MyWXPayConfig;
import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class TestWXPay {
    public static void main(String[] args) throws Exception {
        MyWXPayConfig config = new MyWXPayConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值"); // 付款显示账单标题
        data.put("out_trade_no", "2020042016555900000015");// 订单编号
        data.put("device_info", "");// 设备信息
        data.put("fee_type", "CNY");// 货币单位 分
        data.put("total_fee", "1");// 金额
        data.put("spbill_create_ip", "123.12.12.123");
//        需要有一个回调的接口，获取此次微信支付的信息
        data.put("notify_url", "http://6scyfw.natappfree.cc/notify_url"); // 回调地址
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", "12"); // 商品ID 与订单编号后几位相同？

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
