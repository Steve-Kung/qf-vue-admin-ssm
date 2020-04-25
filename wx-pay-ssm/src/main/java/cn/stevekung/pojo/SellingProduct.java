package cn.stevekung.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellingProduct {
    private Long id;
    private Long pid;
    private String pname;
    private Long price;
    private String pimg;

    private Long sellingCount;
    private Long sellingPrice;
}
