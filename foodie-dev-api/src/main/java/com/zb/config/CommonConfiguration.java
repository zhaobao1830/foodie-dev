package com.zb.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhaobao1830
 * @Date 2024-02-18 15:53
 * @Description: 公共配置
 */
@Configuration
public class CommonConfiguration {

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则
     * 只有加上这个，查询后IPage里的total才能有值，不然就是0
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
