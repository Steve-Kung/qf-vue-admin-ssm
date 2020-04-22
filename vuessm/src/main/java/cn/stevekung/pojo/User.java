package cn.stevekung.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String email;
    private int password;
    private int gender;
    private String hobby;
    private Date gmtCreate;
    private Date gmtModify;
}
