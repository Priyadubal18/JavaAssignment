package org.javaiw.model;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibDaoImplementation {

		SessionFactory factory;

		public SessionFactory getFactory() {
			return factory;
		}

		@Autowired
		public void setFactory(SessionFactory factory) {
			this.factory = factory;
		}
		
		public void showAll(){		
			
			Session session = factory.openSession();		
			Transaction tx =session.beginTransaction();
			Employee e1= new Employee(1, "raj", "mechanical", 78945);
			Employee e2= new Employee(2, "rajjj", "mechajjnical", 78945);
			Employee e4= new Employee(5, "priya", "Software", 745945);
			Employee e5= new Employee(4, "sonu", "ghg", 78945);
			session.persist(e1);
			session.persist(e2);
			session.persist(e4);
			session.persist(e5);
			tx.commit();
			session.close();
		  		
			
		}
		public void selectall(){		
			
			Session session = factory.openSession();		
			Transaction tx =session.beginTransaction();
			Query query = session.createQuery("select ename from Employee");
			List<String> list = query.list();
			for(String p1: list){				
				System.out.println( "Ename name is  "+ p1 );
				//" Brand is "+ p1.getBrand()+ " Price is "+p1.getPrice());
				//System.out.println(" ");
			}
			
		  		
			
		}	
}
