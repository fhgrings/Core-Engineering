package com.github.vinifkroth.coreeng.tema9.util;

import java.util.Optional;

import com.github.vinifkroth.coreeng.tema9.dto.CharacterApiDTO;
import com.github.vinifkroth.coreeng.tema9.dto.MovieApiDTO;
import com.github.vinifkroth.coreeng.tema9.model.Character;
import com.github.vinifkroth.coreeng.tema9.model.Movie;

public class EntityParser {

	public static Optional<Character> characterMapping(CharacterApiDTO characterDTO) {
		Character character = new Character();
		character.setName(characterDTO.getName());
		character.setHeight(characterDTO.getHeight());
		character.setMass(characterDTO.getMass());
		character.setHairColor(characterDTO.getHair_color());
		character.setSkinColor(characterDTO.getSkin_color());
		character.setEyeColor(characterDTO.getEye_color());
		character.setBirthYear(characterDTO.getBirth_year());
		character.setGender(characterDTO.getGender());
		character.setHomeworld(characterDTO.getHomeworld());
		return Optional.of(character);
	}

	public static Optional<Movie> movieMapping(MovieApiDTO movieDTO) {
		Movie movie = new Movie();
		movie.setTitle(movieDTO.getTitle());
		movie.setOpeningCrawl(movieDTO.getOpening_crawl());
		movie.setDirector(movieDTO.getDirector());
		movie.setReleaseDate(movieDTO.getRelease_date());
		return Optional.of(movie);
	}
}
