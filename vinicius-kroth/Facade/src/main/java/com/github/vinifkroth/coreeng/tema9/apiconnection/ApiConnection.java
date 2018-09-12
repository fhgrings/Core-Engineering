package com.github.vinifkroth.coreeng.tema9.apiconnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.github.vinifkroth.coreeng.tema9.model.Character;
import com.github.vinifkroth.coreeng.tema9.model.Movie;
import com.github.vinifkroth.coreeng.tema9.dto.CharacterApiDTO;
import com.github.vinifkroth.coreeng.tema9.dto.MovieApiDTO;
import com.github.vinifkroth.coreeng.tema9.util.EntityParser;
import com.google.gson.Gson;

class ApiConnection {

	private static final String baseUrl = "https://swapi.co/api/";

	public Optional<Character> getCharacterById(String id) {
		Gson parser = new Gson();
		String requestUrl = baseUrl + "people/" + id;
		Optional<Character> character = Optional.empty();
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet getRequest = new HttpGet(requestUrl);
			HttpResponse httpResponse = httpClient.execute(getRequest);
			character = EntityParser
					.characterMapping(parser.fromJson(processHttpReponse(httpResponse), CharacterApiDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return character;
	}

	public Optional<Movie> getMovieById(String id) {
		Gson parser = new Gson();
		String requestUrl = baseUrl + "films/" + id;
		Optional<Movie> movie = Optional.empty();
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet getRequest = new HttpGet(requestUrl);
			HttpResponse httpResponse = httpClient.execute(getRequest);
			movie = EntityParser.movieMapping(parser.fromJson(processHttpReponse(httpResponse), MovieApiDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}

	private String processHttpReponse(HttpResponse response) throws Exception {
		StringBuilder str = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
			while (br.ready()) {
				str.append(br.readLine());
			}
			return str.toString();
		} catch (Exception e) {
			throw e;
		}
	}

}
