package cn.stevekung.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private Long userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String userTel;
    private Integer userFlag;
}
