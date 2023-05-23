package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UserConverter;
import com.proyecto.dto.UserDTOIn;
import com.proyecto.dto.UserDTOOut;
import com.proyecto.models.User;
import com.proyecto.repositories.ParadaRepository;
import com.proyecto.repositories.RutaRepository;
import com.proyecto.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RutaRepository rutaRepository;
	@Autowired
	private ParadaRepository paradaRepository;

	@Autowired
	private UserConverter converter;
	
	public List<UserDTOOut> findAll() {
		List<UserDTOOut> usersDTO=new ArrayList<UserDTOOut>();
		for(User user:userRepository.findAll()) {
			usersDTO.add(this.converter.toDTO(user));
		}
		return usersDTO;
	}

	public UserDTOOut findById(String username) {
		return this.converter.toDTO(this.userRepository.findById(username).orElse(null));
	}
	
	public UserDTOOut saveUser(UserDTOIn dUser) {
		return this.converter.toDTO(this.userRepository.save(this.converter.toEntity(dUser, 'N')));
	}
	
	public UserDTOOut updateUser(String username, UserDTOIn user) {
		User entity=this.userRepository.findById(username).orElse(null);
		this.userRepository.delete(entity);
		entity.setAdmitido(user.getAdmitido());
		entity.setEmail(user.getEmail());
		entity.setParadas(this.paradaRepository.findAllById(user.getParadas()));
		entity.setRutas(this.rutaRepository.findAllById(user.getRutas()));
		entity.setUsername(user.getUsername());
		this.userRepository.save(entity);
		return this.converter.toDTO(entity);
	}
	
	public void deleteUser(String username) {
		this.userRepository.deleteById(username);
	}
}
