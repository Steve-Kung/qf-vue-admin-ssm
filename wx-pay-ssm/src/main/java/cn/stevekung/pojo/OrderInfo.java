package cn.stevekung.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo {
    private Long id;
    private Long orderId;
    private Long pid;
    private Long pcount;
}
