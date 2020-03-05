package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import com.atguigu.elastic.bean.Book;
import com.atguigu.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Springboot03ElasticApplicationTests {
    @Autowired
    JestClient jestClient;
   @Autowired
    BookRepository bookRepository;
    @Test
    void contextLoads() {
        //1.给ES中索引(保存)一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("hello world");
        //构建一个索引功能
        Index  index = new Index.Builder(article).index("atguigu").type("news").build();
        //执行
        try {
             jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //测试搜索
    @Test
    public void search(){
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试ElasticsearchRepository的子接口操作ES
    @Test
    public void test02(){
        Book book=new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
        for (Book book1 : bookRepository.findBookNameLike("游")) {
            System.out.println(book1);
        }
        ;

    }
}
