package org.yuanxing.bootdruid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;

/**
 * @author yuan
 * @create 2019-05-13 11:13
 * @see 1.druid 配置类
 * @version 1.0.0
 */

@Configuration
@ConditionalOnClass(com.alibaba.druid.pool.DruidDataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type",
                       havingValue = "com.alibaba.druid.pool.DruidDataSource",
                       matchIfMissing = true)
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        System.out.println("*************** druid-begin **************");
        System.out.println("dataSource  --------  " + dataSource.toString());
        System.out.println("*************** druid-end **************");
        return  dataSource;
    }

    /**
     * @return p52
     * @date 2019/2/16
     * 1.配置druid WEB监控 配置一个管理后台的servlet
     */
    @Bean
    public ServletRegistrationBean<Servlet> druidServlet() {

        System.out.println("*************** druidServlet-begin **************");

        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();

        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings("/druid/*");  //访问路径

        //白名单
        registrationBean.addInitParameter("allow", "192.168.1.107");
        //黑名单 (共同存在时，deny优先于ljs)
        registrationBean.addInitParameter("deny", "192.168.2.105");
        //druid/login.html登录时账号密码
        registrationBean.addInitParameter("loginUsername", "root");
        registrationBean.addInitParameter("loginPassword", "123456");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        registrationBean.addInitParameter("resetEnable", "false");

        System.out.println("*************** druidServlet-end **************");
        return registrationBean;
    }

    /**
     * @return p52
     * @date 2019/2/16
     * 1.配置一个web监控的filter
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        System.out.println("*************** webStatFilter-begin **************");

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //监控选项过滤器
        filterRegistrationBean.addInitParameter("WebStatFilter", "/*");
        //添加不需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        //配置profileEnable能够监控单个url调用的sql列表
        //filterRegistrationBean.addInitParameter("profileEnable", "true");
        //当前的cookie的用户.
        //filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        //当前的session的用户
        //filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");

        System.out.println("*************** webStatFilter-end **************");
        return filterRegistrationBean;
    }
}
