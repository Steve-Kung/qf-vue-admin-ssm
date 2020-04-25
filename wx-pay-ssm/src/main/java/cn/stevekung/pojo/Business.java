package cn.stevekung.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Business {
    private Long id;
    private Long bisId;
    private String bisName;
    private String bisTel;
    private Integer bisFlag;
    private String bisEmail;
    private String bisAddr;
}
