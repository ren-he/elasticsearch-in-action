/**
 * @Title:  EsBlog.java
 * @Package com.rh.spring.boot.blog.domain.es
 * @Description: TODO(用一句话描述该文件做什么)
 * @author RH
 * @date  2018年5月3日 下午4:29:02
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 ******************************************************
*/
package com.rh.spring.boot.blog.domain.es;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @ClassName: EsBlog
 * @Description: Blog文档
 * @author RH
 * @date 2018年5月3日 下午4:29:02
 */
@Document(indexName = "blog", type = "blog") // 文档
public class EsBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // 主键
    private String id;

    private String title;

    private String summary;

    private String content;

    protected EsBlog() {

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title 要设置的 title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary 要设置的 summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content 要设置的 content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format(
                "EsBlog[id='%s',title='%s',summary='%s',content='%s']",
                id, title, summary, content);
    }

}
