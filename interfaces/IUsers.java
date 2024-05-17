package interfaces;

import model.User;
import java.lang.*;
public interface IUsers{
	void addUser(User u);
	User getUser(int index);
	void deleteUser(User u);
	void updateUser(User oldUser, User updatedUser);
}