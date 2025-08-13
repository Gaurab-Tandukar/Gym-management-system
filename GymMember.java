/*
 * abstract class name GymMember is created for a blueprint of how the member data are traced
 * different method is created for different functionality 
 * abstract method are overrided by its sub class
*/

//parent abstract class gymMember
public abstract class GymMember {
    //declaring variable with protected modifier
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //constructor created 
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        
        //initial value given
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }
    
    //accessor method for all variables
    public int getId() {
        return this.id; 
    }
    
    public String getName() { 
        return this.name; 
    }
    
    public String getLocation() { 
        return this.location; 
    }
    
    public String getPhone() { 
        return this.phone; 
    }
    
    public String getEmail() { 
        return this.email; 
    }
    
    public String getGender() { 
        return this.gender; 
    }
    
    public String getDOB() { 
        return this.DOB; 
    }
    
    public String getMembershipStartDate() { 
        return this.membershipStartDate; 
    }

    public int getAttendance() { 
        return this.attendance; 
    }
    
    public double getLoyaltyPoints() { 
        return this.loyaltyPoints; 
    }
    
    public boolean isActiveStatus() { 
        return this.activeStatus; 
    }
    
    //abstract method markAttendanceto track attendance
    abstract void markAttendance();
    
    //membership status method is created
    protected void activeMembership() {
        activeStatus = true;
    }
    
    protected void deactiveMembership(boolean activeStatus) {
        //execute only if activeStatus is true
        if(activeStatus == true) {
            this.activeStatus = false;
        }
        //else {
        //    System.out.println("Membership Status id already disable");
        //}
    }
    
    //reset member method is created to reset activeStatus, attendance and loyalty points.
    protected void resetMember() {
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }
    
    //method to display everything
    public void display() {
        System.out.println("+------------------------------------+");
        System.out.println(this.name+" Status");
        System.out.println("+------------------------------------+");
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("location: "+location);
        System.out.println("Phone no: "+phone);
        System.out.println("Email address: "+email);
        System.out.println("Gender: "+gender);
        System.out.println("Date of Birth: "+DOB);
        System.out.println("Membership Start Date: "+membershipStartDate);
        System.out.println("Attendance: "+attendance);
        System.out.println("Loyalty Points: "+loyaltyPoints);
        System.out.println("Active status: "+activeStatus);
    }
}