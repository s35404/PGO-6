public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {
    private int emplyeecount;
    private int workshopPerMonth;
    private boolean onlineDashboard;

    public int getEmplyeecount() {
        return emplyeecount;
    }

    public int getWorkshopPerMonth() {
        return workshopPerMonth;
    }

    public boolean isOnlineDashboard() {
        return onlineDashboard;
    }

    public CorporateWellnessPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew, int emplyeecount, int workshopPerMonth, boolean onlineDashboard) {
        super(planCode,  clientName, months, baseMonthlyFee, autoRenew);
        this.emplyeecount = emplyeecount;
        this.workshopPerMonth = workshopPerMonth;
        this.onlineDashboard = onlineDashboard;
    }
    @Override
    public String getPlanType() {
        return "CorporateWellness";
    }
    @Override
    public double calculateMonthlyNetPrice(){
        double price = getBaseMonthlyFee();
        price += (emplyeecount * 18);
        price += (workshopPerMonth * 220);
        if(emplyeecount > 20){
            price -= (price*0.12);
        }
        if(onlineDashboard == true){
            price += 80;
        }
        return price;
    }
    @Override
    public String toString() {
        return "Gym membersip plan{ " + "Plan Code= " + getPlanCode() +
                '\'' + ", Client name= " + getClientName() +
                '\'' + ", Months= " + getMonths() +
                '\'' + ", Base Monthly Fee= " + getBaseMonthlyFee() +
                '\'' + ", Auto Renew= " + isAutoRenew() +
                '\'' + ", Employee Count= " + emplyeecount +
                '\'' + ", Workshop per month= " + workshopPerMonth +
                '\'' + ", Online Dashboard= " + isOnlineDashboard() + "}";
     }



        @Override
    public boolean hasOnlineAccess() {
        return this.onlineDashboard;
    }
    @Override
    public boolean canFreeze() {
        return this.getMonths() >= 6 && this.getWorkshopPerMonth() == 0;
    }
}
