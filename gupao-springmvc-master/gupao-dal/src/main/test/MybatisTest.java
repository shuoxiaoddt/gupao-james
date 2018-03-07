import com.gupao.dal.dao.BlogMapper;
import com.gupao.dal.entity.BlogExample;
import config.MybatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by 中国第一美男子 on 2018/3/7.
 * 帅哥,写点注释哦!!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis2.xml" } )
public class MybatisTest {
    @Autowired
    private BlogMapper blogMapper;
    @Test
    public void test(){
        BlogExample blogExample = new BlogExample();
        blogExample.createCriteria().andIdEqualTo(1);
        blogMapper.selectByExample(blogExample);
    }
}
