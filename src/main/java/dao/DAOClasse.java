package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import config.HibernateUtil;
import model.Classe;

@Transactional 
public class DAOClasse {
		
	public static List<Classe> getAllClasses(){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			List<?> objectList = session.createQuery("from Classe classe").list();
			List<Classe> classeList = new ArrayList<Classe>();
			for(Object o : objectList){
				Classe cl = (Classe)o;				
				classeList.add(cl);
			}
			
			session.getTransaction().commit();
			session.close();
			return classeList;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getAllClasses" );
	        return null;
	    }
	}
	
	public static Classe getClasseById(int id){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select classe from Classe classe ");
			hql.append(" where classe.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Classe classe = (Classe) query.list().get(0);
			
			session.getTransaction().commit();
			session.close();
			return classe;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getClasseById");
	        return null;
	    }
	}
	
	public static void createClasse(Classe classe){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			        
			session.save(classe);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : createClasse");
	    }
	}
	
	public static void updateClasse(Classe classe){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(classe);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : updateClasse");
	    }
	}
	
	public static void deleteClasse(Classe classe){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(classe);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : deleteClasse");
	    }
	}

	public static Classe getClasseByIdEagerly(int id) {
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select classe from Classe classe ");
			hql.append(" where classe.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Classe classe = (Classe) query.list().get(0);
			Hibernate.initialize(classe.getStudents());
			
			session.getTransaction().commit();
			session.close();
			return classe;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getClasseById");
	        return null;
	    }
	}
}
