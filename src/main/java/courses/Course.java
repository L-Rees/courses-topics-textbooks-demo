package courses;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Course {

	
	@Id
	@GeneratedValue
	private long id;
	private String description;
	private String name;
	
	@ManyToMany
	private Collection<Topic> topics;
	
	@OneToMany(mappedBy = "course")
	private Collection<Textbook> textbooks;
	
	public Collection<Textbook> getTextbooks() {
		
		return textbooks;
	}
	public long getId() {
		return id;
	}
	public Object getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Collection<Topic> getTopics() {
		return topics;
	}
	public Course() {
		
	}
	public Course(String name, String description, Topic...topics) {
		this.name = name;
		this.description = description;
		this.topics = new HashSet<>(Arrays.asList(topics));
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
