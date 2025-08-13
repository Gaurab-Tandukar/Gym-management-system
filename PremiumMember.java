/*
 * child class name PremiumMember is created that extends from GymMember class that has all logic for manipulation and displaying premium member data
 * different method is created for different functionality 
 * constructor is created that also calls its parent class
*/
public class PremiumMember extends GymMember {
    //declaring variable
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructing a constructor
    PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,
                    String personalTrainer) {
        // Calling the GymMember constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.premiumCharge = 50000.00d;
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0d;
        this.discountAmount = 0;
    }
    
    //Accessor method to access private attributes
    public double getPremiumCharge() {
        return this.premiumCharge;
    }
    
    public String getPersonalTrainer() {
        return this.personalTrainer;
    }
    
    public boolean getIsFullPayment() {
        return this.isFullPayment;
    }
    
    public double getPaidAmount() {
        return this.paidAmount;    
    }
    
    public double getDiscountAmount() {
        return this.discountAmount;
    }
    
    //code execute when customer pays amount
    public String payDueAmount(double paidAmount) {
        if(this.isFullPayment == true) {
            return "Your Payment is already complete";
        }
        
        if(paidAmount > premiumCharge) {
            System.out.println("You paid " + paidAmount + "and Premium Charge is only 50000.00");
            return "payment is Greater than Premium charge";
        }
        
        double totalPaidAmount = this.paidAmount + paidAmount;
        if(totalPaidAmount > premiumCharge){
            return "Payment exceeds the remaining amount due.";
        }
        else {
            this.paidAmount = totalPaidAmount;  
            double remainingAmount = premiumCharge - this.paidAmount;
            String output = "payment Sucessful \npaid Amount = "+this.paidAmount+ "\nRemaining Amount = "+remainingAmount;
            if(this.paidAmount == premiumCharge) {
                isFullPayment = true;
            }
            else {
                isFullPayment = false;
            }
            return output;
            }
    }
    
    //calculating discount 
    public void calculateDiscount() {
        if(isFullPayment == true) {
            double discountPercent = 10d; //discount percent
            discountAmount = (discountPercent/100.00)*premiumCharge; //discount amponut
            System.out.println("Customer you have received "+discountPercent+"% discount");
            System.out.println("Discounted amount = "+discountAmount);
        }
        else {
            discountAmount = 0;
        }
    }
        
    //code to revert premium member
    public void revertPremiumMember(){
        super.resetMember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0;
        discountAmount = 0;
    }
    
    //implementing mark attendance abstract method
    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 10;
    }
    
    //code to display details of the customer
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: "+personalTrainer);
        System.out.println("Full Payment: "+isFullPayment);
        System.out.println("Paid Amount: "+paidAmount);
        System.out.println("Remaning Amount: "+(premiumCharge - this.paidAmount));
        if(discountAmount != 0) {
            System.out.println("Discount Amount:" +discountAmount);
        }
        System.out.println();
    }
}