package config;

import java.util.*;
import java.io.File;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by James
 * on 16/8/16.
 * Description:
 */
@Configuration
@MapperScan(basePackages = "com.gupao.dal.dao")
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {
    @Autowired
    @Qualifier("dataSource")
    public DataSource dataSource;


    @Lazy(false)
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory localSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(getResources("com/gupao/dal/dao/"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "txManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
    public  Resource[] getResources(String path){
        String prefixPath = this.getClass().getClassLoader().getResource("").getPath();
        String realPath = prefixPath + path;
        File file = new File(realPath);
        List<Resource> res = new ArrayList<Resource>();
        int index = 0;
        for(File xmlFile : file.listFiles()){
            if(xmlFile.getName().endsWith(".xml")){
                res.add(new FileSystemResource(xmlFile));
            }

        }
        return  res.toArray(new Resource[res.size()]);
    }

}
