package com.zb.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author zhaobao1830
 * @Date 2024-02-19 09:45
 * @Description: 分页工具类
 */
public class PageUtil {
    private PageUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> PagedGridResult<T> build(IPage<T> iPage) {
        return new PagedGridResult<>(iPage.getCurrent(), iPage.getPages(), iPage.getTotal(), iPage.getRecords());
    }

    public static <K, T> PagedGridResult<K> build(IPage<T> iPage, List<K> records) {
        return new PagedGridResult<>(iPage.getCurrent(), iPage.getPages(), iPage.getTotal(), iPage.getRecords());
    }
}
