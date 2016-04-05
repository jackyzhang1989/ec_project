package jacky.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@ElementCollection
	//@JoinTable(name = "Comment", joinColumns = @JoinColumn(name = "Movie_Id"))
	//@OrderColumn(name = "Position")
	//@Column(name = "Message")
	private List<String> comments = new ArrayList<>();

	@ElementCollection
	private Set<Genre> genres = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private Rating rating;

	private byte[] poster;

	@ManyToMany
	@JoinTable(name="MOVIE_ARTIST",
			joinColumns = @JoinColumn(name="movieId"),
			inverseJoinColumns = @JoinColumn(name="artistId"))
	private List<Artist> artists = new ArrayList<>();

	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ElementCollection
	private List<String> characters = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="MOVIE_Director",
			joinColumns = @JoinColumn(name="movieId"),
			inverseJoinColumns = @JoinColumn(name="directorId"))
	private List<Director> direstors = new ArrayList<>();
	
	private String summary;
	
	private String title;
//	year character director summary title

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void addArtist(Artist artist) {
		artists.add(artist);
		artist.addMovie(this);
	}
	
	public void removeArtist(Artist artist) {
		artists.remove(artist);
		artist.removeMovie(this);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<String> getCharacters() {
		return characters;
	}

	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}

	public List<Director> getDirestors() {
		return direstors;
	}

	public void setDirestors(List<Director> direstors) {
		this.direstors = direstors;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
