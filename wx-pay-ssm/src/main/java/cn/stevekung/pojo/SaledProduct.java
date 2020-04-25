package cn.stevekung.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaledProduct {
    private Long id;
    private Long pid;
    private String pname;
    private Long price;
    private String pimg;

    private Long saledCount;
    private Long saledPrice;
}
