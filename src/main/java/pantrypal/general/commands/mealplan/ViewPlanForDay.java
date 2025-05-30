package pantrypal.general.commands.mealplan;

import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.MealPlanManager;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class ViewPlanForDay extends MealPlanCommand {

    String day;

    public ViewPlanForDay() {
        super("viewPlanForDay <day>", "View a day's plan");
    }

    public ViewPlanForDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list, RecipeManager recipes,
                        MealPlanManager plans, Scanner in) {
        try {
            plans.viewPlanForDay(getDay(day));
        } catch (NullPointerException e) {
            Ui.showMessage("Invalid day index provided. Please enter a valid day name.");
        } catch (IllegalArgumentException e) {
            Ui.showMessage("Invalid plan index provided. Please enter a valid plan index.");
        }
    }
}
