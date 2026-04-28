public class PersonalTrainingPlan extends MembershipPlan implements Billable{
    private int sessionsPerMonth;
    private int trainerLevel;
    private boolean dietConsultationIncluded;

    public int sessionsPerMonth() {
        return sessionsPerMonth;
    }
    public int trainerLevel() {
        return trainerLevel;
    }
    public boolean dietConsultationIncluded() {
        return dietConsultationIncluded;
    }


    public PersonalTrainingPlan(String planCode, String clientName, int months, double baseMonthlyFee,boolean autoRenew, int sessionsPerMonth, int trainerLevel, boolean dietConsultationIncluded) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.sessionsPerMonth = sessionsPerMonth;
        this.trainerLevel = trainerLevel;
        this.dietConsultationIncluded = dietConsultationIncluded;
        if(trainerLevel< 1 || trainerLevel>3){
            throw new IllegalArgumentException("Trainer level must be between 1 and 3");
        }
    }
    @Override
    public String getPlanType() {
        return "PersonalTraining Plan";
    }


    @Override
    public double calculateMonthlyNetPrice(){
        double price = this.getBaseMonthlyFee();
        price = price + this.sessionsPerMonth * 70;
        if(trainerLevel == 2){
            price += 90;
        }
        if(trainerLevel == 3){
            price += 180;
        }
        if (dietConsultationIncluded == true) {
        price += 50;
        }
        if(isAutoRenew() == true){
            price -= 15;
        }
        return price;
    }
    @Override
    public String toString(){
        return "Gym membersip plan{ " + "Plan Code= " + getPlanCode() +
                '\'' + ", Client name= " + getClientName() +
                '\'' + ", Months= " + getMonths() +
                '\'' + ", Base Monthly Fee= " + getBaseMonthlyFee() +
                '\'' + ", Auto Renew= " + isAutoRenew() +
                '\'' + ", Sessions per month =" + sessionsPerMonth +
                '\'' + ", Trainer level= " + trainerLevel +
                '\'' + ", Diet consultation included= " + dietConsultationIncluded + "}";


    }
}
