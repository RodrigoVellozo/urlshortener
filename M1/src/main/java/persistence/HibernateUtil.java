package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEmf() throws Exception{
		if (emf==null) {
			
			emf= Persistence.createEntityManagerFactory("M1");
		}
		return emf;
	}
	public static void close() throws Exception {
		emf.close();
	}

	
}
