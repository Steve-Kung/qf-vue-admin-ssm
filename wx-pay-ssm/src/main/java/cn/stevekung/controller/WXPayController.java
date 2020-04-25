package cn.stevekung.controller;

import cn.stevekung.config.MyWXPayConfig;
import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPay;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import io.goeasy.GoEasy;
import org.junit.rules.ErrorCollector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WXPayController {

//    private String orderId = null;
//    private String productId = null;

    @RequestMapping("/showPay")
    public String showPay(Model model){

        // 用于生成订单辅号的随机数
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderIdPrefix = sdf.format(date);
        String productId = "00001"; // 1号商品
        String orderId = orderIdPrefix + productId;

        //  隧道名可以使用订单编号
        // 订单编号是唯一的
        // 解决一次推送所有客户端都会被推送的问题
        model.addAttribute("my_channel", orderId);
        System.out.println("/showPay------------" + orderId);
        return "MyPay";
    }

    @RequestMapping("/qrcode")
    public void qrcode(HttpServletResponse response){
        // 二维码需要包含的链接内容
        String url = "http://www.baidu.com";
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try{
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
            System.out.println("创建二维码完成");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    编写下单接口
    @RequestMapping("/doPay")
    public void dopay(Long orderId,Long pid, Long orderPrice,HttpServletResponse response) throws Exception {
//        // 用于生成订单辅号的随机数
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String orderIdPrefix = sdf.format(date);
//        String productId = "00001"; // 1号商品
//        String orderId = orderIdPrefix + productId;

        // 用于生成订单辅号的随机数
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//        String orderIdPrefix = sdf.format(date);
//        productId = "00001"; // 1号商品
//        orderId = orderIdPrefix + productId;

//        this.orderId = String.valueOf(orderId);

        //1.创建配置类对象
        MyWXPayConfig config = new MyWXPayConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<String, String>();
        data.put("body", "付款显示账单标题"); // 付款显示账单标题
        data.put("out_trade_no", String.valueOf(orderId));// 订单编号
        data.put("device_info", "");// 设备信息
        data.put("fee_type", "CNY");// 货币单位 分
//        data.put("total_fee", String.valueOf(orderPrice));// 金额
        data.put("total_fee", "1");// 金额
        data.put("spbill_create_ip", "123.12.12.123");
//        需要有一个回调的接口，获取此次微信支付的信息
        data.put("notify_url", "http://gasxa3.natappfree.cc/notify_url"); // 回调地址
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        data.put("product_id", String.valueOf(pid)); // 商品ID 与订单编号后几位相同？

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            // 二维码 code_url 图片生成
//            String url = "http://www.baidu.com";
            String url = resp.get("code_url");

            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.MARGIN, 2);
            try{
                BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 200, 200, hints);
                MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
                System.out.println("创建二维码完成");
            } catch (Exception e){
                e.printStackTrace();
            }

//            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    返回正确回答消息给微信后台
    @RequestMapping("/notify_url")
    public void getNotifyURL(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        byte[] b  =new byte[1024];
        int len=0;
        StringBuffer sb = new StringBuffer();
        while ((len=inputStream.read(b))!=-1){
            String str = new String(b,0,len);
            sb.append(str);
        }
        System.out.println(sb.toString());
        String sbStr = sb.toString();
        int count = "<out_trade_no><![CDATA[".length();
        int begin = sbStr.indexOf("<out_trade_no><![CDATA[");
        int end = sbStr.indexOf("]]></out_trade_no>");
        String substring = sbStr.substring(begin+count, end);
        System.out.println(substring);

        String orderId = substring;


        // 返回一个标准格式的回信给微信后台
        response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
//  用Java在服务器端发送消息
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-b5e939205b4146e08f46c49e3f44a5a9");
//        服务器向浏览器客户端 推送
        System.out.println("/notify_url------------" + orderId);
//        goEasy.publish(orderId, "支付成功");
//        也可以发布一个json数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "支付成功");
        String result = JSON.toJSONString(map);
        System.out.println(result);
        goEasy.publish(orderId, result);
    }
}
