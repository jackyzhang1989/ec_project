package jacky.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Director")
public class Director extends Person{
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="direstors")
	private List<Movie> movies = new ArrayList<>();

}
