package com.ruriel.ldap.model;
   
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.naming.Name; 
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.domain.Persistable;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
 
@NoArgsConstructor
@Data
@Entry(objectClasses = { "inetOrgPerson" })
public final class User implements Persistable<String> {

	
	@Id
	private Name dn;
	
	@Attribute(name = "uid")
	private String uid;
	
	@Attribute(name = "cn")
	private String cn;
	
	
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