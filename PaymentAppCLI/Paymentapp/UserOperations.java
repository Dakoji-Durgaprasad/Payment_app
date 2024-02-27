import java.util.List;

public class UserOperations {
	
	public List<User> users=null;
	
	public UserOperations() {
		users = RunPaymentsApp.userList;
	}
	public User doUserRegistration(String fname,String lname,long phnum,String dob,String addr,String pswd) {
		User u = new User();
		u.setFirstName(fname);
		u.setLastName(lname);
		u.setPhoneNumber(phnum);
		u.setDateofBirth(dob);
		u.setAddressd(addr);
		u.setPassword(pswd);
		
		u.setUserId((int)(Math.random()*1000)+100); 
		
		return u;
	}
	
	public void printUsersList(List<User> users) {
		for(User u:users) {
			if(users!=null) {
				System.out.println("User Details of : "+u.getFirstName());
				System.out.println(u);
			}
		}
	}
	
	public boolean verifyUserLogin(String uId,String pswd) {
		for(int i=0;i<users.size();i++) {
			if(String.valueOf(users.get(i).getUserId()).equals(uId)) {
				if(pswd.equals(users.get(i).getPassword())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void printCurrUserDetails(int UserId) {
		for(User u:users) {
			if(u.getUserId()==UserId) {
				System.out.println(u);
			}
			else {
				System.out.println("No user logged in");
			}
		}
	}
}
