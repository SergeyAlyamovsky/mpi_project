package cinema.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Film")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String englishTitle;
	private String title;
	private int releaseYear;
	private String genre;
	private String director;	
	private int time;	
	private String ageRating;
	private String description;
	private String image;
	
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "films")
	@JsonIgnore
	private Set<User> users = new HashSet<User>();
	
	public Film() {
	}
	
	public Film(int id, String englishTitle, String title, int releaseYear, String genre,
			String director, int time, String ageRating, String description,
			String image) {
		this.id = id;
		this.englishTitle = englishTitle;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.director = director;
		this.time = time;
		this.ageRating = ageRating;
		this.description = description;
		this.image = image;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnglishTitle() {
		return this.englishTitle;
	}
	public void setEnglishTitle(String englishTitle) {
		this.englishTitle = englishTitle;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getReleaseYear() {
		return this.releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return this.director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getTime() {
		return this.time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getAgeRating() {
		return this.ageRating;
	}
	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
