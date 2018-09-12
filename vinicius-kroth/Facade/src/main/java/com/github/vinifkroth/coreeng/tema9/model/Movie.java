package com.github.vinifkroth.coreeng.tema9.model;

public class Movie {

	private String title;
	private String openingCrawl;
	private String director;
	private String releaseDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpeningCrawl() {
		return openingCrawl;
	}

	public void setOpeningCrawl(String openingCrawl) {
		this.openingCrawl = openingCrawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\nOpening Crawl: " + openingCrawl + "\nDirector: " + director + "\nReleaseDate: "
				+ releaseDate;
	}

}
