package com.digicl.pnd.security.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digicl.pnd.dto.AdminUserDTO;
import com.digicl.pnd.model.AdminRole;
import com.digicl.pnd.model.AdminUser;
import com.digicl.pnd.model.ServiceProvider;
import com.digicl.pnd.repository.AdminRepository;
import com.digicl.pnd.repository.AdminRoleRepository;
import com.digicl.pnd.repository.ServiceProviderRepository;
import com.digicl.pnd.security.customuserdetails.CustomUserDetails;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private AdminRoleRepository adminRoleRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		ServiceProvider sp = serviceProviderRepository.findBySpEmail(email);
		
		if(sp != null) {
			return new CustomUserDetails(sp.getSpEmail(), sp.getSpPassword(), "user", sp);
		}else {
			AdminUser admin = adminRepository.findByEmail(email);
			if(admin != null) {
				return new CustomUserDetails(admin.getEmail(), admin.getPassword(), admin.getRoleId().getRoleName(), admin);
			}
		}
		
		throw new UsernameNotFoundException("User with email '" + email + "' not found");
	}

	public AdminUser save(AdminUserDTO dto) {
		AdminUser adminUser = new AdminUser();
		
		adminUser.setName(dto.getName());
		adminUser.setEmail(dto.getEmail());
		adminUser.setPassword(bcryptEncoder.encode(dto.getPassword()));
		adminUser.setCreatedTime(new Date());
		adminUser.setModifiedTime(new Date());
		adminUser.setCreatedBy(null);
		adminUser.setModifiedBy(null);
		
		AdminRole role = new AdminRole();
		role.setRoleName(dto.getRole().getRoleName());
		adminRoleRepository.save(role);
		
		adminUser.setRoleId(role);
		
		return adminRepository.save(adminUser);
	}

}