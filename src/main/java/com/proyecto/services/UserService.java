package com.proyecto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.converters.UserConverter;
import com.proyecto.dto.LoginDTO;
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
		return this.converter.toDTO(this.userRepository.save(this.converter.toEntity(dUser, 'P')));
	}
	
	public UserDTOOut updateUser(String username, UserDTOIn user) {
		User entity=this.userRepository.findById(username).orElse(null);
		entity.setAdmitido(user.getAdmitido());
		entity.setEmail(user.getEmail());
		entity.setRutas(this.rutaRepository.findAllById(user.getRutas()));
		entity.setUsername(user.getUsername());
		this.userRepository.save(entity);
		return this.converter.toDTO(entity);
	}
	
	public void deleteUser(String username) {
		this.userRepository.deleteById(username);
	}
	
	public UserDTOOut validateUser(LoginDTO credentials) {
		User usuarioAEncontrar=this.userRepository.findById(credentials.getUsername()).orElse(null);
		if(usuarioAEncontrar!=null && usuarioAEncontrar.getPassword().equals(credentials.getPassword())) {
			return this.converter.toDTO(usuarioAEncontrar);
		}
		return null;
	}

	public List<UserDTOOut> getAllStandByUsers() {
		List<User> usuarios=this.userRepository.findAll();
		List<UserDTOOut> aDevolver=new ArrayList<UserDTOOut>();
		for(User u:usuarios) {
			if (u.getAdmitido()=="P".charAt(0)){
				aDevolver.add(this.converter.toDTO(u));
			}
		}
		return aDevolver;
	}

	public List<UserDTOOut> findAllConductores() {
		List<UserDTOOut> usuarios=this.findAll();
		List<UserDTOOut> aDevolver=new ArrayList<UserDTOOut>();
		for(UserDTOOut usuario:usuarios) {
			if(usuario.getTipo().equals("c")) {
				aDevolver.add(usuario);
			}
		}
		return aDevolver;
	}
}
