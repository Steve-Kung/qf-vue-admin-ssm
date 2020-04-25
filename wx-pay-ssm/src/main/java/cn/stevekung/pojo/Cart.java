package cn.stevekung.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    private Long id;
    private Long cartId;
    private Long userId;
    private Long pid;
    private Long pcount;
}
