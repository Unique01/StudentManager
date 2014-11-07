package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import config.HibernateUtil;
import model.Student;

@Transactional 
public class DAOStudent {
		
	public static List<Student> getAllStudents(){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			List<?> objectList = session.createQuery("from Student student").list();
			List<Student> studentList = new ArrayList<Student>();
			for(Object o : objectList){
				Student student = (Student)o;				
				studentList.add(student);
			}
			
			session.getTransaction().commit();
			session.close();
			return studentList;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getAllStudents" );
	        return null;
	    }
	}
	
	public static Student getStudentById(int id){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select student from Student student ");
			hql.append(" where student.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Student student = (Student) query.list().get(0);
			
			session.getTransaction().commit();
			session.close();
			return student;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getStudentById");
	        return null;
	    }
	}
	
	public static void createStudent(Student student){
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			        
			session.save(student);
			
			session.getTransaction().commit();
			session.close();
			
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : createStudent");
	    }
	}
	
	public static void updateStudent(Student student){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.update(student);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : updateStudent");
	    }
	}
	
	public static void deleteStudent(Student student){
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			session.delete(student);
			
			session.getTransaction().commit();
			session.close();
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : deleteStudent");
	    }
	}

	public static Student getStudentByIdEagerly(int id) {
	    try
	    {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			StringBuffer hql = new StringBuffer("select student from Student student ");
			hql.append(" where student.id= ? ");
			Query query = session.createQuery(hql.toString());
			
			query.setParameter(0, id);
			Student student = (Student) query.list().get(0);
			Hibernate.initialize(student.getEvents());
			Hibernate.initialize(student.getClasse());

			session.getTransaction().commit();
			session.close();
			return student;
		
	    }catch(Exception e){
	        System.out.println( e.getMessage() + " : getStudentByIdEagerly");
	        return null;
	    }
	}

}
