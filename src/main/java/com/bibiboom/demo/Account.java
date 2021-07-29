package com.bibiboom.demo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Annie
 * @date 2021年06月29日 15:25
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    // 锁:保护账户余额
    final Object balLock = new Object();
    // 账户余额
    Integer balance;

    // 锁:保护账户密码
    final Object pwLock = new Object();
    // 账号密码
    String password;

    // 取款
    void withdraw(Integer amt) {
        synchronized (balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }
    // 查看密码
}
