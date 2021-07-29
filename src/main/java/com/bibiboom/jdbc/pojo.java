package com.bibiboom.jdbc;

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
    int orderBy;


    String roleId1  ;
    String payMoneySum1 ;
    String lastLoginServerId1 ;
    String ownSdkUserId1 ;
    String orderBy1;

    public String getRoleId1() {
        return "\t" + " 角色ID: " + roleId;
    }

    public String getPayMoneySum1() {
        return "\t" + " 充值金额: " + payMoneySum;
    }

    public String getLastLoginServerId1() {
        return "\t" + " 游戏ID: " + lastLoginServerId;
    }

    public String getOwnSdkUserId1() {
        return "\t" + " 账号ID: " + ownSdkUserId;
    }

    public String getOrderBy1() {
        return "\t" + " 排名: " + orderBy;
    }
}
