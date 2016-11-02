package org.javaiw.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.javaiw.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class JDBCDaoImplemention {
	
JdbcTemplate template;

@Autowired
public void setDataSource(DataSource datasource){
	
	template = new JdbcTemplate(datasource);	
}

public void show(){
	List<Employee> list;
	
	list=template.query("select * from employeee", new RowMapper<Employee>(){

		@Override
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			 Employee e=new Employee();  
		     e.setEmpno(rs.getInt(1));  
		     e.setEname(rs.getString(2));
		     e.setJob(rs.getString(3));
		     e.setSal(rs.getInt(4)); 
		     return e;
		     
		}

		
		
		
	});
	
	for(Employee e1:list){		
		System.out.println( e1.getEname());
	}
}


}
