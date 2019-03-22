package com.zyc.springbootelasticsearch.controller;

import com.zyc.springbootelasticsearch.bean.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月22日 15:34
 * @desc JestController
 */
/**
 * SpringBoot默认支持两种技术来和ES交互；
 * 1、Jest（默认不生效）
 * 	需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2、SpringData ElasticSearch【ES版本有可能不合适】
 * 		版本适配说明：https://github.com/spring-projects/spring-data-elasticsearch
 *		如果版本不适配：2.4.6
 *			1）、升级SpringBoot版本
 *			2）、安装对应版本的ES
 *
 * 		1）、Client 节点信息clusterNodes；clusterName
 * 		2）、ElasticsearchTemplate 操作es
 *		3）、编写一个 ElasticsearchRepository 的子接口来操作ES；
 *	两种用法：https://github.com/spring-projects/spring-data-elasticsearch
 *	1）、编写一个 ElasticsearchRepository
 */
@RestController
public class JestController {

    private static volatile int i = 1;

    @Autowired
    JestClient jestClient;

    @GetMapping("/jestadd")
    public String jestAdd(){
        Book book = new Book();
        book.setId(String.valueOf(i));
        book.setName("西游记");
        book.setAntor("吴承恩");
        //构建一个索引功能
        Index index = new Index.Builder(book).index("test").type("books").build();
        try {
            jestClient.execute(index);
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/jestsearch")
    public String jestSearch(){
        //查询表达式
        String json ="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"西游记\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("test").addType("books").build();
        try {
            SearchResult result = jestClient.execute(search);
            return result.getJsonString();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
