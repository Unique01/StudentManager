package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import config.HibernateUtil;
import model.Event;

@Transactional 
public class DAOEvent {
		
	public static List<Event> getAllEvents(){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			List<?> objectList = session.createQuery("from Event event").list();
			List<Event> eventList = new ArrayList<Event>();
			for(Object o : objectList){
				Event event = (Event)o;				
				eventList.add(event);
			}
			
			session.getTransaction().commit();
			session.close();
			return eventList;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getAllEvents" );
	        return null;
	    }
	}
	
	public static Event getEventById(int id){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select event from Event event ");
			hql.append(" where event.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Event event = (Event) query.list().get(0);
			
			session.getTransaction().commit();
			session.close();
			return event;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getEventById");
	        return null;
	    }
	}
	
	public static void createEvent(Event event){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			        
			session.save(event);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : createEvent");
	    }
	}
	
	public static void updateEvent(Event event){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(event);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : updateEvent");
	    }
	}
	
	public static void deleteEvent(Event event){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(event);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : deleteEvent");
	    }
	}

	public static Event getEventByIdEagerly(int id) {
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select event from Event event ");
			hql.append(" where event.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Event event = (Event) query.list().get(0);
			Hibernate.initialize(event.getClasses());
			
			session.getTransaction().commit();
			session.close();
			return event;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getEventByIdEagerly");
	        return null;
	    }
	}
}
