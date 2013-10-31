package io_dbrown;

public class Contact {
	
	public String name,email,phone;
	
	Contact(String[] contactInfo)
	{
		name = contactInfo[0];
		email = contactInfo[1];
		phone = contactInfo[2];
		
	}
	
	@Override
	public String toString()
	{
		return name+","+email+","+phone;
	}
}
