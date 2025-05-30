package pantrypal.general.commands.mealplan;

import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.MealPlanManager;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class AddPlanToDay extends MealPlanCommand {
    private int planIndex;
    private String day;

    public AddPlanToDay() {
        super("addPlanToDay <plan index> <day>",
                "Add a plan to a specific day");
    }

    public AddPlanToDay(int planIndex, String day) {
        this.planIndex = planIndex;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public int getPlanIndex() {
        return planIndex;
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list,RecipeManager recipes,
                        MealPlanManager plans, Scanner in){
        try {
            plans.addPlanToDay(planIndex, getDay(day));
            Ui.showMessage("Plan for " + getDay(day).name() + " added: " +
                    plans.getPlanDetails(planIndex).getPlanName());
        } catch (NullPointerException e) {
            Ui.showMessage("Invalid day index provided. Please enter a valid day name.");
        } catch (IllegalArgumentException e) {
            Ui.showMessage(e.getMessage());
        }
    }
}
