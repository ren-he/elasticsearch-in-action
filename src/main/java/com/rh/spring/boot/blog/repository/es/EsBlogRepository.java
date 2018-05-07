/**
 * @Title:  EsBlogRepository.java
 * @Package com.rh.spring.boot.blog.repository.es
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RH
 * @date  2018年5月4日 下午2:40:32
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
*/
package com.rh.spring.boot.blog.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.rh.spring.boot.blog.domain.es.EsBlog;

/**
 * @ClassName: EsBlogRepository
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author RH
 * @date 2018年5月4日 下午2:40:32
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     *
     * @Title: findDistinctedEsBlog
     * @Description: 查询博客（去重）
     * @author RH
     * @date  2018年5月4日 下午2:43:19
     * @param id
     * @param summary
     * @param content
     * @param pageable
     * @return
     */
   Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
            String id, String summary, String content, Pageable pageable);
}
