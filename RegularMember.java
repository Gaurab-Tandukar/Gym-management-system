/*
 * child class name RegularMember is created that extends from GymMember class that has all logic for manipulation and displaying regular member data
 * different method is created for different functionality 
 * constructor is created that also calls its parent class
*/

public class RegularMember extends GymMember {
    //Initializing attributes of Regular member
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //created constructor    
    RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,
                    String referralSource) {
       // Calling the GymMember constructor
       super(id, name, location, phone, email, gender, DOB, membershipStartDate);
       this.attendanceLimit = 30;
       this.isEligibleForUpgrade = false;
       this.removalReason = "";
       this.referralSource = referralSource;
       this.plan = "basic";
       this.price = 6500d;
    }
    
    //accessor method of attributes
    public int getAttendanceLimit() {
        return this.attendanceLimit; 
    }
    
    public boolean getIsEligibleforUpgrade() {
        return this.isEligibleForUpgrade; 
    }
    
    public String getRemovalReason(){
        return this.removalReason;
    }
    
    public String getReferralSource(){
        return this.referralSource;
    }
    
    public String getPlan(){
        return this.plan;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    //implementing mark attendance abstract method
    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 5;
    }
    
    //method to get price of the plan using switch statement
    public double getPlanPrice(String plan) {
        //plan = "basic";
        switch (plan.toLowerCase()) {
            case "basic":
                price = 6500;
                break;
            
            case "standard":
                price = 12500;
                break;
            
            case "deluxe":
                price = 18500;
                break;
            
            default:
                price = -1;
                System.out.println("Please select appropriate plan");
        }
        return price;
    }
    
    //code to update plan which takes previous plan as parameter
    public String updatePlan(String plan) {
        String msg = "";
        if(this.plan.toLowerCase().equals(plan.toLowerCase()))  { 
            //compares previous plan with this keyword
            //code will execute if the same plan is selected
            msg = "You have already subscribed with the choosen plan. please select another if you want to Update";
        }
        else {
            //code will execute if the plan is different then current
            if(getAttendance() >= attendanceLimit) {
                //code will execute if attendance is greater of equal than attandance limit
                isEligibleForUpgrade = true;
                if(isEligibleForUpgrade == true) {
                    this.plan = plan;
                    msg = "Plan updated to "+plan;
                    //this keyword shows the plan is from instance variable and now it's value is set what is in local variable
                }
            }
            else{   
                msg = "You are no eligible for Update as your attendance is "+getAttendance();
            }
        }
        return msg;
    }
    
    //code to revert Regular Member
    public void revertRegularMember(String removalReason) {
        resetMember();
        this.removalReason = removalReason;
        isEligibleForUpgrade = false;
        plan = "basic";
        price = 6500d;
    }
    
    //overriding display method of parent class
    @Override
    public void display() {
        super.display();
        System.out.println("plan: "+plan);
        if(price > 0) {
            System.out.println("Price: "+price);
        }
        else {
            System.out.println("Price not known");
        }
        
        if(removalReason != "") {
            System.out.println("Removal Reason: "+removalReason);
        }
        System.out.println();
    }
}