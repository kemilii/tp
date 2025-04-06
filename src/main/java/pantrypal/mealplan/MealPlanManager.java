package pantrypal.mealplan;

import pantrypal.general.control.Ui;

import java.util.ArrayList;

public class MealPlanManager {
    private Plan[] weeklyPlans = new Plan[7]; //7 days in a week
    private ArrayList<Plan> planList = new ArrayList<>();


    public MealPlanManager() {}

    public void addPlanToList(String planName) {
        Plan plan = new Plan(planName);
        planList.add(plan);
        Ui.showMessage("Plan added: " + plan.getPlanName() +
                "\nThere are " + planList.size() + " created plans currently.");
    }

    public void addPlanToDay(int planIndex, Day day) {
        int dayIndex = day.ordinal();
        Plan plan = planList.get(planIndex);
        if (weeklyPlans[dayIndex] == null) {
            weeklyPlans[dayIndex] = plan;
            Ui.showMessage("Plan for " + day.name() + " added: " + plan.getPlanName());
        } else {
            Ui.showMessage("There is already a plan for " + day.name());
        }
    }

    public void removePlanFromWeek(Day day) {
        int dayIndex = day.ordinal();
        if (weeklyPlans[dayIndex] != null) {
            weeklyPlans[dayIndex] = null;
        } else {
            Ui.showMessage("There is no plan for " + day.name());
        }
    }

    public void viewPlanForDay(Day day) {
        int dayIndex = day.ordinal();
        if (weeklyPlans[dayIndex] != null) {
            Ui.showMessage("Plan for " + day.name() + ": " + weeklyPlans[dayIndex]);
        } else {
            Ui.showMessage("There is no plan for " + day.name());
        }
    }

    public void viewPlanForWeek() {
        for (Plan plan : weeklyPlans) {
            if (plan != null) {
                Ui.showMessage(plan.toString());
            }
        }
    }

    public boolean findInCreatedPlans(String planName) {
        boolean found = false;
        for (Plan plan : planList) {
            if (plan.getPlanName().contains(planName)) {
                found = true;
                Ui.showMessage((planList.indexOf(plan)+1) + //plus 1 for matching to user view
                        ": " + plan.getPlanName());
            }
        }
        return found;
    }

    public Plan[] getWeeklyPlans() {
        return weeklyPlans;
    }

    public Plan getPlanForDay(Day day) {
        return weeklyPlans[day.ordinal()];
    }

    public Plan getPlanDetails(int planIndex) {
        return planList.get(planIndex);
    }


}
