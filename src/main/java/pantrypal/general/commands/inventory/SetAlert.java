package pantrypal.general.commands.inventory;

import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.MealPlanManager;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class SetAlert extends InventoryCommand {
    private String name;
    private double threshold;
    private String unit;

    public SetAlert() {
        super("setAlert <name> <threshold>",
                "Sets the alert for a specific ingredient");
    }

    public SetAlert(String name, double threshold) {
        this.name = name;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public double getThreshold() {
        return threshold;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list, RecipeManager recipes,
                        MealPlanManager plans, Scanner in) {
        if (inventory.getInventory().containsKey(name)) {
            inventory.setAlert(name, threshold);
            Ui.printSetAlertMessage(name, threshold);
        } else {
            Ui.printIngredientNotFoundMessage();
        }
    }
}
