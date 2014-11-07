package dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import config.HibernateUtil;
import model.Classe;
import model.Event;
import model.Login;
import model.Student;
import model.Subject;
import model.User;

public class DAOLogin   {

	static{
	    /*try
	    {    	
	        Session session = HibernateUtil.getSessionFactory().openSession();        
	        session.beginTransaction();
	        
	        //Add a user and his credentials
	        User user = new User("Teacher", "Nice", null);
	        String salt = service.ServiceLogin.generateSalt();
	        Login login = new Login("myLogin@aa.aa",service.ServiceLogin.generateSecurePassword("myPassword", salt), salt );
	        user.setLogin(login);
	        session.save(user);
	        session.save(login);
	        
	        //Add a class, a student and an event
	        Classe classe = new Classe("3A", "2014-2015", "7 rue du General De Gaulle, 75008, Paris", null);
	        List<Student> studentList = new ArrayList<Student>();
	        List<Classe> classeList = new ArrayList<Classe>();
	        classeList.add(classe);
	        
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Event event = new Event(simpleDateFormat.parse("10/05/2014"),"DST Maths",Subject.Maths,15 ,classeList);
	        List<Event> eventList = new ArrayList<Event>();
	        eventList.add(event);
	        Student student = new Student("Pierre", "Dubois", classe, 15, eventList,simpleDateFormat.parse("25/12/1992"));
	        studentList.add(student);
	        classe.setStudents(studentList);
	        	        
	        session.save(classe);
	        session.save(event);
	        session.save(student);
   
	        session.getTransaction().commit();
	        session.close();
	    }
	    catch( Exception e )
	    {
	        System.out.println( e.getMessage() + " : static action in DAOLogin" );
	    }*/
	}
	

	public static User getUserByCredential(String email) {
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();

			StringBuffer hql = new StringBuffer("select login from Login login ");
			hql.append(" where login.email= :email ");
			Query query = session.createQuery(hql.toString());		
			query.setString("email",email);
			Login login = (Login) query.list().get(0);
			
			hql = new StringBuffer("select user from User user ");
			hql.append(" where user.id= ? ");
			query = session.createQuery(hql.toString());		
			query.setParameter(0,login.getUser().getId());
			User user = (User) query.list().get(0);
			
			session.getTransaction().commit();
			session.close();	
			return user;		
	    }
	    catch( Exception e )
	    {
	        System.out.println( e.getMessage() + " : getUserByCredential" );
	        return null;
	    }	
	}
	
	public List<User> getAllUsers(){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			List<?> objectList = session.createQuery("from User user").list();
			List<User> userList = new ArrayList<User>();
			for(Object o : objectList){
				userList.add((User)o);
			}
			
			session.getTransaction().commit();
			session.close();
			return userList;
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getAllUsers" );
	        return null;
	    }
	}
	
	public User getUserById(int id){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select user from User user ");
			hql.append(" where user.id=:id ");
			Query query = session.createQuery(hql.toString());
			
			query.setString(id,"id");
			User user = (User) query.list().get(0);
			
			session.getTransaction().commit();
			session.close();
			return user;
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getUserById" );
	        return null;
	    }
	}
	
	public void createUser(User user){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.save(user);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : createUser" );
	    }
	}
	
	public void updateUser(User user){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(user);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : updateUser" );
	    }
	}
	
	public void deleteUser(User user){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(user);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : deleteUser" );
	    }
	}

}
