package com.user.model;

import java.util.Calendar;

public class AppUser {
    private String fullName;
    private String address;
    private String nationality;
    private String NIC;
    private String birthday;
    private int age;
    private String gender;
    private Boolean validity;
    
    
	public AppUser(String fullName, String address, String nationality, String NIC, String birthday, int age,
			String gender) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.nationality = nationality;
		this.NIC = NIC;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
		 
	}

	public AppUser() {
		// TODO Auto-generated constructor stub
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNIC() {
		 
		return NIC;
	}
	public void setNIC(String nIC) {
		NIC = nIC;
	}
	public String getBirthday() {
		System.out.println("Birthday :" +birthday);
		return birthday;
	}

	public int getAge() {
		System.out.println("Age :" +age);
		return age;
	}

	public Boolean getValidity() {
		return validity;
	}
	public void setValidity(Boolean validity) {
		this.validity = validity;
	}
	public String getGender() {
		System.out.println("Gender :" +gender);
		return gender;
	}
	//Define the gender of the user using nic number
	public void setGender(String NIC) {
		this.gender = gender;
		boolean validity = false;

	        String nicNo =NIC;
	        int nicLength= nicNo.length();
	        
	        // check the nic no lenght to determine the type of nic(new or old)
	        if(nicLength==10) {
	        	validity =true;
	        	//call the function to check the validity of nic
	        	setValidity(validity);
	        	
	        	//get the birth year
	            int year=Integer.parseInt((String) nicNo.substring(0,2));
	             year = (1900+year);
	             int dateGap =Integer.parseInt((String) nicNo.substring(2,5));
	             //dateGap variable keeps the date gap since jan 1st to birthday
	             if(dateGap <500) {
	            	 //Identify the user's gender using dateGap
	                 gender ="Male";
	                 
	                 setBirthday(dateGap,year);
	             }else{
	                 gender="Female";
	                 dateGap=dateGap-500;
	                 setBirthday(dateGap,year);
	             }

	        }else if(nicLength ==12){
	        	validity =true;
	        	setValidity(validity);
	            int year=Integer.parseInt((String) nicNo.substring(0,4));
	            int dateGap =Integer.parseInt((String) nicNo.substring(4,7));
	            if(dateGap <500) {
	                gender ="Male";
	                setBirthday(dateGap,year);
	            }else{
	                gender="Female";
	                dateGap=dateGap-500;
	                setBirthday(dateGap,year);
	            }
	        }else {
	           validity =false;
	           setValidity(validity);
	        }
	         
	    }
	//Identify the birthday
	  public void setBirthday(int dateGap,int year){
		    int birthYear=year;
		    int birthMonth=0;
		    int birthdate=0;

		    //set the No of days into arry
		    int [] daysOfmonth ={31,29,31,30,31,30,31,31,30,31,30,31};

		    //loop through the arry and reduce the number of dates from the dateGap
		    for (int i = 0; i < daysOfmonth.length; i++) {
		        if (daysOfmonth[i] < dateGap) {
		            dateGap = dateGap - daysOfmonth[i];
		            
		            //set the birth month as the element of arry
		            birthMonth = i + 2;
		            //set the birthdate as reminder of the dategap
		            birthdate = dateGap;

		        } else {
		            birthMonth = i + 1;
		            birthdate = dateGap;
		            break;

		        }
		    }
		    birthday= birthYear +"/"+birthMonth+"/"+birthdate;
		    setAge(birthYear);

		}
	  //set age using birthyear
	  public void setAge(int birthYear){
	        int currntyear = Calendar.getInstance().get(Calendar.YEAR);
	        age=currntyear-birthYear;

	}
}
