
public class UserOperation {
	
	public User doUserRegisteration(String FirstName,String LastName,String DateOfBirth,long PhoneNumber,String Address,String Password) {
		User u = new User();
		u.setFirstName(FirstName);
		u.setLastName(LastName);
		u.setDateOfBirth(DateOfBirth);
		u.setPhoneNumber(PhoneNumber);
		u.setAddress(Address);
		u.setPassword(Password);
		u.setUserId(1234);
		return u;
	
	}
	
	void printUserDetails(User[] users) {
		for(int i=0;i<users.length;i++) {
			if(users[i] != null) {
				System.out.println("User Details of "+ users[i].getFirstName());
				System.out.println(users[i]);
			}
	}
	
}
}

