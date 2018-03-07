package com.gupao.dal;

import com.gupao.dal.dao.BlogMapper;
import com.gupao.dal.entity.BlogExample;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by 中国第一美男子 on 2018/3/7.
 * 帅哥,写点注释哦!!
 */
public class BootStrap {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("config");
        ctx.refresh();
        SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
        BlogMapper blogMapper = ctx.getBean(BlogMapper.class);
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(1);
        blogMapper.selectByExample(blogExample);


    }
}
