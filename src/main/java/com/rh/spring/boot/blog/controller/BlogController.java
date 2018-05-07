/**
 * @Title:  HelloController.java
 * @Package com.rh.spring.boot.blog.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RH
 * @date  2018年4月8日 下午5:29:46
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
*/
package com.rh.spring.boot.blog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rh.spring.boot.blog.domain.es.EsBlog;
import com.rh.spring.boot.blog.repository.es.EsBlogRepository;

/**
 * @ClassName: BlogController
 * @Description: Blog 控制器
 * @author RH
 * @date 2018年4月8日 下午5:29:46
 */

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping
    public List<EsBlog> getBlogList(EsBlog esBlog,
            @RequestParam(value="pageIndex", defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize", defaultValue="10") int pageSize) {

        @SuppressWarnings("deprecation")
        Pageable pageable = new PageRequest(0, 20);
        String title = esBlog.getTitle();
        String summary = esBlog.getSummary();
        String content = esBlog.getContent();
        Page<EsBlog> page = esBlogRepository.
                findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
                        title, summary, content, pageable);

        return page.getContent();
    }
}
