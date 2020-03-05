package com.atguigu.elastic.repository;
import com.atguigu.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    //参考https://docs.spring.io/spring-data/elasticsearch/docs/3.2.0.RELEASE/reference/html/#elasticsearch.repositories
    public List<Book> findBookNameLike(String bookName);
}
