package com.ruriel.ldap.dto;
    
 

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@NoArgsConstructor
@Data  
@JsonIgnoreProperties(value = { "uid" })
public final class UserDTO  
{
	@Schema(name ="dn", title = "DN", description = "Stands for domain component, which means that this string holds one component, a label of a DNS domain name." ,example = "marry")
	private String dn;
	
	  
	@Schema(name ="cn", title = "CN", description = "Stands for common name.Composed from the givenName attribute, concatenated to the SN attribute." ,example = "Marry")
	private String cn;
	
	
	@Schema(name ="sn", title = "SN", description = "Stands for surname (or last name)." ,example = "Doe")
	private String sn;
	
	 

	 
//	@Override
//	public String toString() {
//		return "uid=" + uid + ",cn=" + cn + ",sn=" + sn;
//	} 

}