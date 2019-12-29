package com.biz.esp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.esp.domain.UserDTO;
import com.biz.esp.persistence.UserDao;

/*
 * interface를 imp하여 생성한 클래스에 @Service를 붙여주면
 * @Autowired를 수행할때
 * 
 * Interface 객체 형식으로 코드를 작성하면
 * 자동으로 해당 객체를 가져와서 객체를 초기화 하여준다.
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	SqlSession sqlSession;

	UserDao uDao;
	
	@Autowired
	public void newUserDao() {
		uDao = sqlSession.getMapper(UserDao.class);
	}
	
	@Override
	public int userJoin(UserDTO userDTO) {
		
		return uDao.userInsert(userDTO);
	}

	@Override
	public boolean userIdCheck(String u_id) {
		// TODO Auto-generated method stub
		
		UserDTO userDTO = uDao.findById(u_id);
		if(userDTO != null && userDTO.getU_id().equalsIgnoreCase(u_id)) {
			return true;			
		}
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		String inU_id = userDTO.getU_id();
		String inU_pass = userDTO.getU_password();
		
		UserDTO userRDTO = uDao.findById(inU_id);
		
		if(userRDTO == null) {
			return false;
		}
		String sU_id = userRDTO.getU_id();
		String sPassword = userRDTO.getU_password();
		if(sU_id.equals(inU_id) && sPassword.equals(inU_pass)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserDTO getUser(String u_id) {
		
		return uDao.findById(u_id);
	}

}
