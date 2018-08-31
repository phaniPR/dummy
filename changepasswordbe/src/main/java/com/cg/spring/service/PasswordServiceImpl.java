package com.cg.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.beans.Password;
import com.cg.spring.repo.IPasswordRepo;

import aj.org.objectweb.asm.Attribute;

@Service
public class PasswordServiceImpl implements IPasswordService{

	@Autowired
	IPasswordRepo repo;

	@Override
	public String changePassword(String email, String password, String nPassword) {
		if(repo.existsById(email)) {
			/*if(!(password.equals(nPassword))) {
				Password pwd= new Password();
				pwd.setEmailId(email);
				pwd.setPassword(nPassword);
				repo.save(pwd);
			}*/
			Password existUser=repo.findById(email).get();
			if(password.equals(existUser.getPassword())) {
				existUser.setPassword(nPassword);
				repo.save(existUser);
				return "Password changed succesfully";
			
			}
			return "You have entered wrong current password";
		}
		return "Email Id doesnt exists";
		
	}

}

