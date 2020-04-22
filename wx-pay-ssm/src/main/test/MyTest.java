import com.alibaba.fastjson.JSON;

import java.util.HashMap;

import static javax.swing.UIManager.put;

public class MyTest {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "支付成功");
        String result = JSON.toJSONString(map);
        System.out.println(result);
    }
}
