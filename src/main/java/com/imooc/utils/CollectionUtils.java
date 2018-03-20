package com.imooc.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合工具类
 * created by wangbao02
 * 2018/01/29
 */
public final class CollectionUtils<T>  extends org.springframework.util.CollectionUtils{

    /**
     * 将List转为集合
     * created by jintian chen
     * 2018/01/29
     * @param list
     * @return
     */
    public static<T> Set<T> convertListToSet(List<T> list) {
        Set<T> set = new HashSet<>();
        set.addAll(list);
        return set;
    }
}
