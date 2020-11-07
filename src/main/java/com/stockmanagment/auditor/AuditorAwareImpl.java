package com.stockmanagment.auditor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.stockmanagment.model.User;
import com.stockmanagment.repository.UserRepository;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Autowired
	UserRepository userRepository;
	
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	//Optional<User> user=userRepository.findByUsername(userDetails.getUsername());
		return Optional.of(userDetails.getUsername());
}
}