package com.ruriel.ldap.model;
   
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties; 

import javax.naming.Name; 

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Persistable;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
 
@NoArgsConstructor
@Data
@Entry(objectClasses = { "inetOrgPerson" })
@JsonIgnoreProperties(value = { "dn" })
public final class User implements Persistable<String> {

	
	@Id
	private Name dn;
	
	@Schema(name ="dn", title = "DN", description = "Stands for domain component, which means that this string holds one component, a label of a DNS domain name." ,example = "marry")
	@Attribute(name = "uid")
	private String uid;
	
	@Schema(name ="cn", title = "CN", description = "Stands for common name.Composed from the givenName attribute, concatenated to the SN attribute." ,example = "Marry")
	@Attribute(name = "cn")
	private String cn;
	
	
	@Schema(name ="sn", title = "SN", description = "Stands for surname (or last name)." ,example = "Doe")
	@Attribute(name = "sn")
	private String sn;
	
	  
	public String getDn() {
		if (dn == null)
			return null;
		return dn.toString();
	}

	public void setDn(Name dn) {
		this.dn = dn;
	}
	@Override
	public String toString() {
		return "uid=" + uid + ",cn=" + cn + ",sn=" + sn;
	}

	@JsonIgnore
	@Override
	public String getId() {
		return getDn() ;
	}

	@JsonIgnore
	@Override
	public boolean isNew() {
		if (dn == null)
			return false;
		return true;
	}

}