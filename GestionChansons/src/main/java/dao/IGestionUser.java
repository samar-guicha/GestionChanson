package dao;

import dao.entities.User;

public interface IGestionUser {
	public String getUsername(String login , String password);
	public void addUser(User user);
}
