package pantrypal.general.commands.shoppinglist;

import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.MealPlanManager;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class RemoveShoppingItem extends ShoppingListCommand {
    private String name;

    public RemoveShoppingItem() {
        super("removeShoppingItem <name>", "Delete an item from the ShoppingList");
    }

    public RemoveShoppingItem(String name) {
        super("removeShoppingItem <name>", "Delete an item from the ShoppingList");
        this.name = name;
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list,
                        RecipeManager recipes, MealPlanManager plans, Scanner in) {
        if (list == null) {
            Ui.showMessage("Error: ShoppingList is not initialized.");
            return;
        }
        boolean removed = list.removeItem(name);
        if (removed) {
            System.out.println("Removed '" + name + "' from the shopping list.");
        } else {
            System.out.println("Item '" + name + "' not found in the shopping list.");
        }
        Ui.printLine();
    }
}
