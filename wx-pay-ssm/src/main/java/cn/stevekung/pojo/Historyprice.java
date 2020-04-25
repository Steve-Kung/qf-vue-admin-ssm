package cn.stevekung.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Historyprice {
    private Long id;
    private Long pid;
    private Long price;
    private Date startTime;
    private Date endTime;
}
