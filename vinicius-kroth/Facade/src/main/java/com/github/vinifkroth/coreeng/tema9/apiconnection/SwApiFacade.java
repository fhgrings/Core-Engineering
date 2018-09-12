package com.github.vinifkroth.coreeng.tema9.apiconnection;

import java.util.Optional;
import com.github.vinifkroth.coreeng.tema9.model.Character;
import com.github.vinifkroth.coreeng.tema9.model.Movie;

public class SwApiFacade {

	private ApiConnection api;

	public SwApiFacade() {
		api = new ApiConnection();
	}

	public String getMovieById(String id) {
		Optional<Movie> movie = api.getMovieById(id);
		if (movie.isPresent())
			return movie.get().toString();
		return "No info returned, a problem may have occured, or the id informed does not exist in our database";
	}

	public String getCharacterById(String id) {
		Optional<Character> character = api.getCharacterById(id);
		if (character.isPresent())
			return character.get().toString();
		return "No info returned, a problem may have occured, or the id informed does not exist in our database";
	}

}
