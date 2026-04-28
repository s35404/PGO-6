public class OnlineCoachingPlan extends MembershipPlan implements RemoteAccess{
    private int videoConsultations;
    private boolean mealPlanIncluded;
    private boolean recordedLibraryAccess;

    public int videoConsultations(){
        return videoConsultations;
    }
    public boolean mealPlanIncluded(){
        return mealPlanIncluded;
    }
    public boolean recordedLibraryAccess(){
        return recordedLibraryAccess;
    }
    public OnlineCoachingPlan(String planCode, String clientName, int months, double baseMonthlyFee,boolean autoRenew, int videoConsultations, boolean mealPlanIncluded, boolean recordedLibraryAccess) {
        super(planCode,  clientName, months, baseMonthlyFee, autoRenew );
        this.videoConsultations = videoConsultations;
        this.mealPlanIncluded = mealPlanIncluded;
        this.recordedLibraryAccess = recordedLibraryAccess;
    }
    @Override
    public String getPlanType() {
        return "OnlineCoachingPlan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();
        price = price + (videoConsultations * 45);
        if (mealPlanIncluded == true){
            price += 60;
        }
        if (recordedLibraryAccess == true){
            price += 20;
        }
        if(isAutoRenew() == true){
            price -= 12;
        }
        return price;
    }
    @Override
    public boolean hasOnlineAccess() {
        return true;
    }

}
