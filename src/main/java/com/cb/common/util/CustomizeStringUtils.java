package com.cb.common.util;

/**
 * 有关处理String类型变量的工具类
 */
public class CustomizeStringUtils {
    /**
     * mysql模糊查询特殊字符处理
     * @param str 待处理字符穿
     * @param escapeChar 转义字符
     * @return 转义好的字符
     */
    public static String escapeMysqlLikeChar(String str, char escapeChar) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        // 先转义转义字符本身，避免冲突
        String escaped = str.replace(String.valueOf(escapeChar), escapeChar + String.valueOf(escapeChar));
        // 再转义 MySQL 中的通配符 % 和 _
        escaped = escaped.replace("%", escapeChar + "%")
                .replace("_", escapeChar + "_");
        return escaped;
    }
}
