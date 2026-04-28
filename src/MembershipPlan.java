abstract class MembershipPlan {
    public static final double stawkaWat = 0.25;

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;


    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public abstract String getPlanType();


    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }



    public abstract double calculateMonthlyNetPrice();

    public double calculateMonthlyGrossPrice(){
        return this.calculateMonthlyNetPrice() * (1+stawkaWat) ;
    }

    double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice()*this.getMonths();
    }
    public final void printSummary() {
        System.out.println("Plan Code: " + planCode);
        System.out.println("Client Name: " + clientName);
        System.out.println("Months: " + months);
        System.out.println("Base Monthly Fee: " + baseMonthlyFee);
        System.out.println("Auto Renew: " + autoRenew);
        System.out.println("Monthly Net Price: " + this.calculateMonthlyNetPrice());
        System.out.println("Monthly Gross Price: " + this.calculateMonthlyGrossPrice());
        System.out.println("Total Net Price: " + this.calculateTotalNetPrice());

    }
    @Override
    public String toString() {
        return "Membership Plan{" + "Plan Code= " + planCode +
                '\'' + ", Client name= " + clientName +
                '\'' + ", Months= " + months +
                '\'' + ", Base Monthly Fee= " + baseMonthlyFee +
                '\'' + ", Auto Renew= " + autoRenew;


    }
 }
