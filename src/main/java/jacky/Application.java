package jacky;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jacky.model.Movie;



public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
//		int[] p = new int[]{1,2};
//		System.out.println(maxProfit(1, p));
//		addMovies();
//		printMoviesReport();
		emf.close();
	}


	private static void printMoviesReport() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {

			tx.begin();

			List<Movie> movies = em.createQuery("Select m from Movie").getResultList();

			for (Movie m : movies) {

				System.out.println(m);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

//			Movie movie = new Movie();
//			movie.setName("Titanic");
//			Set<Category> categories = new HashSet<>();
//			categories.add(Category.DRAMA);
//			categories.add(Category.ROMANCE);
//
//			movie.setCateogries(categories);
////			movie.setR
//
//			Artist actor1 = new Artist();
//			actor1.setName("Lionardo");
//			actor1.setRating(Rating.GOOD);
//			actor1.setCharacter("Lover");
//
//			Artist actress1 = new Artist();
//			actor1.setName("Kate Winslet");
//			actor1.setRating(Rating.GOOD);
//			actor1.setCharacter("Lover");
//
//			List<Artist> actors = new ArrayList<>();
//			actors.add(actor1);
//			actors.add(actress1);
//
//			movie.getActors().add(actor1);
////
//			List<String> comments = new ArrayList<>();
//			comments.add("It was very good");
//			comments.add("It was average movie");
//
//			movie.setComments(comments);
//
////			Path p = FileSystems.getDefault().getPath("", "titanic.jpg");
////			byte[] fileData = Files.readAllBytes(p);
////
////			movie.setCover(fileData);
//			System.out.print("hahha");
//			Address a1 = new Address();
//			Address a2 = new Address();
//			Person p = new Person();
//
//
//			em.persist(p);
//			p = em.find(Person.class, 1);
////			List<Address> addresses = p.getAddresses();
////			addresses.add(a1);
////			addresses.add(a2);
////			p.setAddresses(addresses);
////			em.persist(a1);
////			em.persist(a2);
//			em.merge(p);
//
////			em.persist(movie);
////			em.persist(actor1);

			tx.commit();
		} catch (Throwable e) {
			System.out.print("@@@"+e);
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
