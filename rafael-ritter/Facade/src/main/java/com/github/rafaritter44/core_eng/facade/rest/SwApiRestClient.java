package com.github.rafaritter44.core_eng.facade.rest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwApiRestClient {

    private final static String URL = "http://swapi.co/api/species/";

    public String findSpeciesByID(String id) throws Exception {
        try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet httpGet = new HttpGet(URL + id);
            httpGet.addHeader("User-Agent", "Mozilla/5.0");
            return processResponse(httpClient, httpGet);
        }
    }

    private String processResponse(CloseableHttpClient httpClient, HttpGet httpGet) throws Exception {
        try(CloseableHttpResponse response = httpClient.execute(httpGet);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null)
                builder.append(line);
            return builder.toString();
        }
    }
}
