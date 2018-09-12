package com.github.fhgrings._facade;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapiRestClient {

    private String url = "http://swapi.co/api/people/";

    public String findSpeciesById(int id) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()){
            HttpGet request = new HttpGet(url + id );
            HttpResponse response = client.execute(request);
            response.getStatusLine().getStatusCode();
            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line;
            while((line=rd.readLine())!=null)
                result.append(line);
            return result.toString();
        } catch (
            IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
