package com.digicl.pnd.dto;

import com.digicl.pnd.model.AdminRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserDTO {
	
	public AdminUserDTO(Long id) {
		super();
		this.id = id;
	}

	private Long id;
    private String name;
    private String email;
    private String password;
    private AdminRole role;

}
