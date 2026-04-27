public class GymMembershipPlan extends MembershipPlan {
private int  entriesPerMonth;
private boolean saunaAccess;

public GymMembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee,boolean autoRenew, int  entriesPerMonth,boolean saunaAccess){
    super(planCode, clientName, months, baseMonthlyFee, autoRenew);
    this.entriesPerMonth = entriesPerMonth;
    this.saunaAccess = saunaAccess;
}
@Override
public double calculateMonthlyNetPrice() {
    double monthlyNetPrice = getBaseMonthlyFee() + (entriesPerMonth*4);
    if(saunaAccess == true){
        monthlyNetPrice += 25;
    }
    if(getAutoRenew() == true){
        monthlyNetPrice -= 10;
    }
    return monthlyNetPrice;
}
@Override
public String getPlanType() {
    return "Gym Membership Plan";
}
@Override
    public String toString() {
    return "Gym membersip plan{ " + "Plan Code= " + planCode +
            '\'' + ", Client name= " + clientName +
            '\'' + ", Months= " + months +
            '\'' + ", Base Monthly Fee= " + baseMonthlyFee +
            '\'' + ", Auto Renew= " + autoRenew;
}
}
