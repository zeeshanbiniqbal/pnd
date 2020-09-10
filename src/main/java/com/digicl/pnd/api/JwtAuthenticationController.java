package com.digicl.pnd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digicl.pnd.dto.AdminUserDTO;
import com.digicl.pnd.dto.JwtRequest;
import com.digicl.pnd.dto.JwtResponse;
import com.digicl.pnd.model.AdminUser;
import com.digicl.pnd.security.JwtTokenUtil;
import com.digicl.pnd.security.customuserdetails.CustomUserDetails;
import com.digicl.pnd.security.service.CustomUserDetailsService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@PostMapping(value = "/sign-in")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping(value = "/sign-up")
	public ResponseEntity<?> saveAdmin(@RequestBody AdminUserDTO admin) throws Exception {

		AdminUser adminUser  = userDetailsService.save(admin);
		final CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(adminUser.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping(value = "/sign-out")
	public void logOut() throws Exception {

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
