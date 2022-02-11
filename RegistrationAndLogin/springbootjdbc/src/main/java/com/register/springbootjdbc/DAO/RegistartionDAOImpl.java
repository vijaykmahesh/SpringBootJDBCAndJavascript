package com.register.springbootjdbc.DAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.register.springbootjdbc.entity.Registration;

@Repository
public class RegistartionDAOImpl implements RegistrationDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public int save(Registration e) {
		return jdbcTemplate.update("INSERT INTO tbl_registration (name,email,mobile,password,address) VALUES (?,?,?,?, ?)", new Object[] {e.getName(), e.getEmail(), e.getMobile(),e.getPassword(),e.getAddress()});
	}
	
	@Override
	public List<Registration> findAll() {
		return jdbcTemplate.query("SELECT * FROM tbl_registration", new BeanPropertyRowMapper<Registration>(Registration.class));
	}

	public String getSignupPassword(String email) {
		String passworddetails = null;
		
			passworddetails = jdbcTemplate.queryForObject(
					"select password from tbl_registration where email='" +email + "';",
					String.class);
			System.out.println(passworddetails);
			if(passworddetails == null) {
				return "invalid details";
			}
			else
		return passworddetails;	
	}
	
	public String getSignupEmail(String password) {
		String emailDetails = null;
		try {
			emailDetails = jdbcTemplate.queryForObject(
					"select email from tbl_registration where password='" +password + "';",
					String.class);
			System.out.println(emailDetails );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailDetails ;
		
	}

	@Override
	public String userUpdateDAO(Registration registration) {
		String sql="update tbl_registration set name='"+registration.getName()+"',mobile='"+registration.getMobile()+"',address='"+registration.getAddress()+"' where email='"+registration.getEmail()+"'";  
	   int update=jdbcTemplate.update(sql); 
	  System.out.print(update);
	   return "success";
	   
	}


}