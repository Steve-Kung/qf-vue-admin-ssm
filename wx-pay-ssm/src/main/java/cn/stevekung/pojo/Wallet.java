package cn.stevekung.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet {
    private Long id;
    private Long userId;
    private Long userAmount;
    private Long userFrozen;
}
