	package com.cs.online_bank.admin.security;
	
	import java.util.Collection;
	
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.GrantedAuthority;
	
	public class JwtAuthenticatioToken extends UsernamePasswordAuthenticationToken {
	
		private static final long serialVersionUID = 1L;
		
		private String token;
	
	    public JwtAuthenticatioToken(Object principal, Object credentials){
	        super(principal, credentials);
	    }
	    
	    public JwtAuthenticatioToken(Object principal, Object credentials, String token){
	    	super(principal, credentials);
	    	this.token = token;
	    }
	
	    
		public String getToken() {
			return token;
		}
	
		public void setToken(String token) {
			this.token = token;
		}
	
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
	}
