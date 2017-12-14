package ioc;


public class LoginService {
	private AdminDAO adminDAO;
	
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
		System.out.println("asas");
	}





	public LoginService() {
		System.out.println("LoginService()");
	}
	
}
