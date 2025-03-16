
package hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostel.model.Customer;
import hostel.model.Employee;
import hostel.connection.ConnectionManager;


public class EmployeeDAO {

  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static Statement stmt = null;
  private static ResultSet rs = null;
  private static String sql;
  
  //insert shawl
  public static void addEmployee(Employee employee){
    
    //complete the code here  
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        sql = "INSERT INTO employee(employee_name,employee_position,employee_ic,employee_email,employee_phone,employee_address,employee_bankid,employee_username,employee_password)VALUES(?,?,?,?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        //get values from Shawl object and set parameter values
        ps.setString(1, employee.getEmployee_name());
        ps.setString(2, employee.getEmployee_position());
        ps.setString(3, employee.getEmployee_ic());
        ps.setString(4, employee.getEmployee_email());
        ps.setString(5, employee.getEmployee_phone());
        ps.setString(6, employee.getEmployee_address());
        ps.setInt(7, employee.getEmployee_bankid());
        ps.setString(8, employee.getEmployee_username());
        ps.setString(9, employee.getEmployee_password());
        
        //4. execute query
        ps.executeUpdate();
        
        //5. close connection
        con.close();
        
      }catch(SQLException e) {
        e.printStackTrace();
      }
    
  }  
  
  
  //update shawl
  public static void updateEmployee(Employee employee){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      
      //3. create statement and get the values from Shawl object
      sql = "UPDATE employee SET employee_name=?, employee_position=?, employee_ic=?, employee_email=?, employee_phone=?, employee_address=?, employee_bankid=?, employee_username=?, employee_password=? WHERE employeeid=?";
      ps = con.prepareStatement(sql);
      
      //get values from Shawl object and set parameter values
      ps.setString(1, employee.getEmployee_name());
      ps.setString(2, employee.getEmployee_position());
      ps.setString(3, employee.getEmployee_ic());
      ps.setString(4, employee.getEmployee_email());
      ps.setString(5, employee.getEmployee_phone());
      ps.setString(6, employee.getEmployee_address());
      ps.setInt(7, employee.getEmployee_bankid());
      ps.setString(8, employee.getEmployee_username());
      ps.setString(9, employee.getEmployee_password());
      ps.setInt(10, employee.getEmployeeid());
      
      //4. execute query
      ps.executeUpdate();
      
      //5. close connection
      con.close();
      
      }catch(Exception e) {
        e.printStackTrace();
      }
    
  }  
  
  
  //delete shawl
  public static void deleteEmployee(int employeeid){
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      sql = "DELETE FROM employee WHERE employeeid=?";
      ps = con.prepareStatement(sql);
      //set parameter values
      ps.setInt(1, employeeid);
      //4. execute query
      ps.executeUpdate();
      //5. close connection
      con.close();
      }catch(SQLException e) {
        e.printStackTrace();
      }
  }
  
  
  //get shawl by id
  public static Employee getEmployee(int employeeid) {
    
    // create shawl object
	  Employee employee = new Employee();
    
    //complete the code here
    try {
      //call getConnection() method
      con = ConnectionManager.getConnection();
      //3. create statement
      sql = "SELECT * FROM employee WHERE employeeid=?";
      ps = con.prepareStatement(sql);
      //set parameter values
      ps.setInt(1, employeeid);
      //4. execute query
      rs = ps.executeQuery();
      //process ResultSet and set the values to the Shawl object
      if(rs.next()) {
    	  employee.setEmployeeid(rs.getInt("employeeid"));
          employee.setEmployee_name(rs.getString("employee_name")); 
          employee.setEmployee_position(rs.getString("employee_position"));
          employee.setEmployee_ic(rs.getString("employee_ic"));
          employee.setEmployee_email(rs.getString("employee_email")); 
          employee.setEmployee_phone(rs.getString("employee_phone"));
          employee.setEmployee_address(rs.getString("employee_address"));
          employee.setEmployee_bankid(rs.getInt("employee_bankid"));
          employee.setEmployee_username(rs.getString("employee_username"));
          employee.setEmployee_password(rs.getString("employee_password"));
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return employee;
  }
  
  
  //get all shawls
  public static List<Employee> getAllEmployee(){

List<Employee> employees= new ArrayList<Employee>();

    //complete the code here
    try {
        //call getConnection() method
        con = ConnectionManager.getConnection();
        //3. create statement
        stmt = con.createStatement();
        String sql = "SELECT * FROM employee ORDER BY employeeid";
        //4. execute query
        rs = stmt.executeQuery(sql);
        //process ResultSet and set the values to the Shawl object
        while(rs.next()) {
        	Employee employee = new Employee();
            employee.setEmployeeid(rs.getInt("employeeid"));
            employee.setEmployee_name(rs.getString("employee_name")); 
            employee.setEmployee_position(rs.getString("employee_position"));
            employee.setEmployee_ic(rs.getString("employee_ic"));
            employee.setEmployee_email(rs.getString("employee_email")); 
            employee.setEmployee_phone(rs.getString("employee_phone"));
            employee.setEmployee_address(rs.getString("employee_address"));
            employee.setEmployee_bankid(rs.getInt("employee_bankid"));
            employee.setEmployee_username(rs.getString("employee_username"));
            employee.setEmployee_password(rs.getString("employee_password"));
            employees.add(employee);
      }
      //5. close connection
      con.close();
      }catch(Exception e) {
        e.printStackTrace();
      }
    
    
    return employees;
  }  
  public static boolean isEmailUsed(String email) {
	   
	    try {
	    	con = ConnectionManager.getConnection();	 
	    	sql = "SELECT COUNT(*) FROM employee WHERE employee_email = ?";
	    	 
	        ps = con.prepareStatement(sql);
	        
	        ps.setString(1, email);
	         rs = ps.executeQuery(); 
	        		 
	            if (rs.next()) {
	            return rs.getInt(1) > 0;
	            }
	        
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return false;
	}
  
  
  public static Employee login(Employee employee) {
	  
	  System.out.println("akid in dao");
	  try {
			//call getConnection() method 
			con = ConnectionManager.getConnection();
			
			//3. create statement
			sql = "SELECT * FROM  employee WHERE employee_email = ? AND employee_password = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, employee.getEmployee_email());
			ps.setString(2, employee.getEmployee_password());
			
		    //4. execute query
			rs = ps.executeQuery();

			// if user exists set the isValid variable to true
			if (rs.next()) {
				employee.setEmployeeid(rs.getInt("employeeid"));
				employee.setEmployee_name(rs.getString("employee_name")); 
		        employee.setEmployee_position(rs.getString("employee_position"));
		        employee.setEmployee_ic(rs.getString("employee_ic"));
		        employee.setEmployee_email(rs.getString("employee_email")); 
		        employee.setEmployee_phone(rs.getString("employee_phone"));
		        employee.setEmployee_address(rs.getString("employee_address"));
		        employee.setEmployee_bankid(rs.getInt("employee_bankid"));
		        employee.setEmployee_username(rs.getString("employee_username"));
		        employee.setEmployee_password(rs.getString("employee_password"));
				employee.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else{
				employee.setValid(false);
			}

			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return employee;
  }
//get Employee by Id
	/*public static int getEmployeeById(int employeeid) {
		Employee employee = new Employee();
		try {
			//call getConnection() method
			con = ConnectionManager.getConnection();

			//3. create statement 
			sql = "SELECT * FROM customer WHERE customerid = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, employeeid);

			//4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {	            
				employee.setEmployeeid(rs.getInt("customerid"));	  
				employee.setEmployee_position(rs.getString("customer_name"));
				employee.setEmployee_ic(rs.getString("customer_phone"));
				employee.setEmployee_email(rs.getString("customer_ic"));
				employee.setEmployee_phone(rs.getString("customer_email"));
				employee.setEmployee_address(rs.getString("customer_address"));
				employee.setEmployee_bankid(rs.getInt("customer_address"));
				employee.setEmployee_username(rs.getString("customer_address"));
				employee.setEmployee_password(rs.getString("customer_address"));
			}

			//5. close connection
			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

		return employee;
	}*/
}