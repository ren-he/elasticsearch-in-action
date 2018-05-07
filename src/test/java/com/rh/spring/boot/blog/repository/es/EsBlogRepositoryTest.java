/**
 * @Title:  EsBlogRepository.java
 * @Package com.rh.spring.boot.blog.repository.es
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RH
 * @date  2018年5月4日 上午10:06:16
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
*/
package com.rh.spring.boot.blog.repository.es;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rh.spring.boot.blog.domain.es.EsBlog;

/**
 * @ClassName: EsBlogRepository
 * @Description: EsBlog Repository接口测试
 * @author RH
 * @date 2018年5月4日 上午10:06:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData(){
        // 清除所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog(
                "登鹳雀楼",
                "王之涣的登鹳雀楼",
                "白日依山尽，黄河入海流，欲穷千里目，更上一层楼"));
        esBlogRepository.save(new EsBlog(
                "相思",
                "王维的相思",
                "红豆生南国，春来发几枝，愿君多采撷，此物最相思"));
        esBlogRepository.save(new EsBlog(
                "静夜思",
                "李白的静夜思",
                "床前明月光，疑是地上霜，举头望明月，低头思故乡"));
    }

    @Test
    public void testFindDistinctEsBlog() {

        @SuppressWarnings("deprecation")
        Pageable pageable = new PageRequest(0, 20);

        String title = "楼";
        String summary = "楼";
        String content = "楼";
        Page<EsBlog> page = esBlogRepository.
                findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
                        title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);

        System.out.println("----------- start ----------");
        System.out.println();

        page.getContent().forEach(esblog -> {
            System.out.println(esblog.toString());
        });

        System.out.println();
        System.out.println("---------- end ----------");

    }

}
