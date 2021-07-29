package util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class pojo {

    long roleId  ;
    int payMoneySum ;
    int lastLoginServerId ;
    long ownSdkUserId ;
    Integer id;
    String name;
}
