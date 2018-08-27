package persistence;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Url;

public class UrlDao {
	
	EntityManager em;
	
	public void persist(Url u)throws Exception{
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public void merge(Url u)throws Exception{
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Url u)throws Exception{
		em=HibernateUtil.getEmf().createEntityManager();
		u = em.find(Url.class, u.getId()); 
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeById(Url u)throws Exception{
		em=HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		em.remove(u.getId());
		em.getTransaction().commit();
		em.close();	
	}
	
	public Url findUrl(Integer id)throws Exception{
		em=HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		Url u = em.find(Url.class, id);
		em.close();
		return u;
	}
	
	public List<Url> findAll()throws Exception{
		em = HibernateUtil.getEmf().createEntityManager();
		em.getTransaction().begin();
		List<Url> lista = em.createNamedQuery("url.findAll").getResultList();  
		em.close();
		return lista;
	}
	
}
