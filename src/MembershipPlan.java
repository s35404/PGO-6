public class MembershipPlan {
    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;
    private String planType;


    public MembershipPlan(String planCode, String clientName, int onths, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }
    public String getPlanCode() {
        return planCode;
    }
    public String getClientName() {
        return clientName;
    }
    public  int getMonths() {
        return months;
    }
    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }
    public boolean isAutoRenew() {
        return autoRenew;
    }
    public String getPlanType() {
        return planType;
    }
    public double calculateMonthlyNetPrice() {
        double monthlyNetPrice = 0;
    }

 }
