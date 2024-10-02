package com.example;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;

import java.io.IOException;

public class ElasticsearchLowLevelTest {
    public static void main(String[] args) {
        // Create a RestClientBuilder
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"));

        // Create the client
        try (RestHighLevelClient client = new RestHighLevelClient(builder)) {
            // Perform a simple health check
            Response response = client.getLowLevelClient().performRequest("GET", "/_cluster/health");
            System.out.println("Response: " + EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
