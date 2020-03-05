package com.atguigu.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot默认支持两种技术和ES交互
 * 1.Jest(默认不生效)
 * 需要导入jest的工具包（io.searchbox.client.JestClient）
 * 2.SpringData ElasticSearch
 *    1）Client 节点信息clusterNodes; clusterName
 *    2）ElasticsearchTemplate 操作ES（参考https://docs.spring.io/spring-data/elasticsearch/docs/3.2.0.RELEASE/reference/html/#elasticsearch.misc.filter）
 *    3)ElasticsearchRepository的子接口操作ES
 *
 *
 */
@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
