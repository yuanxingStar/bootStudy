package org.yuanxing.bootdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yuanxing
 * @create 2019-06-24 11:20
 * @see (1) 调用 {@link MultipleDataSource#setDataSourceKey(String)} 切换数据源，
 *  *       业务处理完毕后务必调用 {@link MultipleDataSource#removeDataSourceKey()} 切换至主数据源。
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

    public static final String MAIN_DATA_SOURCE = "mainDataSource";
    public static final String YUANING_DATA_SOURCE = "yuanxingDataSource";

    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    /**
     * 设置数据源。
     * @param dataSource 数据源标识。
     */
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    /**
     * 删除线程中的数据源标识，并切换到主数据源。
     */
    public static void removeDataSourceKey() {
        dataSourceKey.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
