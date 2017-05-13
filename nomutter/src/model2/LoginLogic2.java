package model2;

public class LoginLogic2 {
	public boolean execute(User2 user) {
		if(user.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
