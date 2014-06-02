package com.example.hacku4;

import javax.security.auth.PrivateCredentialPermission;

public class Service1 {

private	int id;
	private  String name;
 private  String code;
private	String url;
private	String values;
private String wantedv;
private String type;
	
	
	public Service1(String _name,String _code,String _url,String _values,String _wantedvalues,String _type) {
		// TODO Auto-generated constructor stub
	
	// id=_id;
	name=_name;
	code=_code;
	url=_url;
	values=_values;
	wantedv=_wantedvalues;
	type=_type;
	
	}

	public void putId(int a)
	{
		id=a;
		
	}
	

	public String getType() {
		return type;
	}

	public String getWantedv() {
		return wantedv;
	}

	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getCode() {
		return code;
	}


	public String getUrl() {
		return url;
	}


	public String getValues() {
		return values;
	}
	
	
	
}
