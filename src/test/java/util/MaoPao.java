package util;

import kotlin.HashCodeKt;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MaoPao {
// 123
    /**
     * @param args
     * 规则1：什么是有效的阶梯
     * 对第一阶梯来说，新增设备>=0 且 扣量比例>0 且 扣量比例<=1则表示有效
     * 对第二阶梯来说，新增设备必须>第一阶梯的新增设备  且 且扣量比例>0 且扣量比例<=1  且 第一阶梯必须是有效的
     * 对第三阶梯来说，新增设备必须>第二阶梯的新增设备  且 且扣量比例>0 且扣量比例<=1  且 第二阶梯必须是有效的
     *
     * 规则2：报错情况
     * 1、扣量比例<0 或者 扣量比例>1 报错
     * 2、新增设备为空报错，新增设备不是整数报错
     * 3、扣量比例为空报错，扣量比例<0报错，扣量比例>1报错
     * 4、对第二、三阶梯，如果新增设备>0，扣量比例<=0，则报错
     */
    public static void main(String[] args) {

        Integer id = 11;

        Integer i1 = 0; Double s1 = 0.1;
        Integer i2 = 3; Double s2 = 0.2;
        Integer i3 = 4; Double s3 = 0.2;


        if (null == i1 || null == s1) {
            System.out.println("第一阶梯不允许为空!");
            return;
        }
        if ((id == null) || (null != i1 && null == s1)) {
            System.out.println("扣量比例1为空!");
            return;
        } else if (s1 < 0.0 || s1 > 1.0) {
            System.out.println("扣量比例1范围异常!");
            return;
        } else if (null == i1 && null != s1) {
            System.out.println("新增设备1为空!");
            return;
        }

        if ((id == null) || (null != i2 && null == s2)) {
            System.out.println("扣量比例2为空!");
            return;
        } else if ((null != s2 && s2 < 0.0) || (null != s2 && s2 > 1.0)) {
            System.out.println("扣量比例2范围异常!");
            return;
        } else if (null == i2 && null != s2) {
            System.out.println("新增设备2为空!");
            return;
        }

        if ((id == null) || (null != i3 && null == s3)) {
            System.out.println("扣量比例3为空!");
            return;
        } else if ((null != s3 && s3 < 0.0) || (null != s3 && s3 > 1.0)) {
            System.out.println("扣量比例3范围异常!");
            return;
        } else if (null == i3 && null != s3) {
            System.out.println("新增设备3为空!");
            return;
        }

        if (null != i2 && null != s2) {
            if ((i2 < i1) || (i2 == i1) || (i2 > i1 && s2 <= 0.0)) {
                System.out.println("阶梯2规则异常!");
                return;
            }
        }

        if (null != i1 && null != i3) {
            if (null == i2 || null == s2) {
                System.out.println("阶梯二规则异常!");
                return;
            }
        }

        if ((null != i3 && null != s3)) {
            if ((i3 < i2) || (i3 == i2) || (i3 > i2 && s3 <= 0.0)) {
                System.out.println("阶梯3规则异常!");
                return;
            }
        }
        System.out.println("程序结束...");
    }

}
