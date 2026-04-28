public class GymMembershipPlan extends MembershipPlan implements Freezable{
private int  entriesPerMonth;
private boolean saunaAccess;

public boolean isSaunaAccess() {
    return saunaAccess;
}

public int getEntriesPerMonth() {
    return entriesPerMonth;
}

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
    if(isAutoRenew() == true){
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
    return "Gym membersip plan{ " + "Plan Code= " + getPlanCode() +
            '\'' + ", Client name= " + getClientName() +
            '\'' + ", Months= " + getMonths() +
            '\'' + ", Base Monthly Fee= " + getBaseMonthlyFee() +
            '\'' + ", Auto Renew= " + isAutoRenew() +
            '\'' + "' Entries per month= " + entriesPerMonth +
            '\'' + "' Sauna access= " + saunaAccess + "}";
    }


@Override
public boolean canFreeze(){
    return this.getMonths() >= 3;
}
}
