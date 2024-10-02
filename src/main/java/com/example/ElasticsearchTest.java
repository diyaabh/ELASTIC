package com.example;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

public class ElasticsearchTest {
    public static void main(String[] args) {
        // Create a RestHighLevelClient
        try (RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder("http://localhost:9200"))) {

            // Index a sample document
            IndexRequest request = new IndexRequest("songs");
            String jsonString = "{" +
                    "\"title\":\"Shape of You\"," +
                    "\"artist\":\"Ed Sheeran\"," +
                    "\"lyrics\":\"The club isn't the best place to find a lover...\"" +
                    "}";
            request.id("1").source(jsonString, XContentType.JSON);
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
            System.out.println("Document indexed with ID: " + indexResponse.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
