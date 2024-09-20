package qh.synji.services;

import qh.synji.models.UserModel;

public interface IUserService {
	UserModel findByUsername(String username);
	UserModel login(String username, String password);
}
