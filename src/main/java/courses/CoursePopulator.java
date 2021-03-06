package courses;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class CoursePopulator implements CommandLineRunner {

	
	@Resource
	private  CourseRepository courseRepo;
	
	@Resource
	private TopicRepository topicRepo;
	
	@Resource
	private TextbookRepository textbookRepo;

	@Override
	public void run(String... args) throws Exception {

		Topic java = new Topic("Java");
		java = topicRepo.save(java);
		Topic spring = new Topic("Spring");
		spring = topicRepo.save(spring);
		Topic tdd = new Topic("TDD");
		tdd = topicRepo.save(tdd);
		
		Course java101 = new Course("Intro to Java", "Learn the fundamentals of Java programming", java);
		java101 = courseRepo.save(java101);
		Course java102 = new Course("Advanced Java", "Learn how to fully test a JPA app", java, tdd, spring);
		java102 = courseRepo.save(java102);
		
		textbookRepo.save(new Textbook("Head First Java", java101));
		textbookRepo.save(new Textbook("Head First Design Patterns", java102));
		textbookRepo.save(new Textbook("Clean Code", java102));
		textbookRepo.save(new Textbook("Intro to JPA", java102));
		
	}
}
