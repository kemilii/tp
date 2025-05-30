package pantrypal.general.commands.general;

import pantrypal.general.commands.Command;
import pantrypal.general.commands.inventory.AddIngredient;
import pantrypal.general.commands.inventory.ConvertIngredient;
import pantrypal.general.commands.inventory.DeleteIngredient;
import pantrypal.general.commands.inventory.IncreaseQuantity;
import pantrypal.general.commands.inventory.DecreaseQuantity;
import pantrypal.general.commands.inventory.SetAlert;
import pantrypal.general.commands.inventory.CheckStock;
import pantrypal.general.commands.inventory.ViewIngredientsByCategory;
import pantrypal.general.commands.inventory.ViewLowStock;
import pantrypal.general.commands.mealplan.AddPlan;
import pantrypal.general.commands.mealplan.AddPlanToDay;
import pantrypal.general.commands.mealplan.AddRecipeToPlan;
import pantrypal.general.commands.mealplan.RemovePlan;
import pantrypal.general.commands.mealplan.RemoveRecipeFromPlan;
import pantrypal.general.commands.mealplan.RemovePlanFromDay;
import pantrypal.general.commands.mealplan.ViewPlan;
import pantrypal.general.commands.mealplan.ViewPlanForDay;
import pantrypal.general.commands.mealplan.ViewPlanForWeek;
import pantrypal.general.commands.mealplan.ExecutePlanForDay;
import pantrypal.general.commands.mealplan.FindPlan;
import pantrypal.general.commands.mealplan.ViewPlanList;
import pantrypal.general.commands.recipe.AddRecipe;
import pantrypal.general.commands.recipe.ListRecipe;
import pantrypal.general.commands.recipe.RemoveRecipe;
import pantrypal.general.commands.recipe.ViewRecipe;
import pantrypal.general.commands.shoppinglist.AddShoppingItem;
import pantrypal.general.commands.shoppinglist.RemoveShoppingItem;
import pantrypal.general.commands.shoppinglist.ViewShoppingList;
import pantrypal.general.commands.shoppinglist.EditShoppingItem;
import pantrypal.general.commands.shoppinglist.GenerateShoppingList;
import pantrypal.general.commands.shoppinglist.MarkShoppingItemAsPurchased;
import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.MealPlanManager;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Help extends GeneralCommand {
    private static final List<Command> commandList = Arrays.asList(
            new Exit(), new Help(),
            new AddIngredient(), new IncreaseQuantity(), new DecreaseQuantity(), new SetAlert(), new CheckStock(),
            new ViewLowStock(), new ConvertIngredient(), new ViewIngredientsByCategory(), new UnitList(),
            new CategoryList(), new DeleteIngredient(),

            new AddShoppingItem(), new GenerateShoppingList(), new RemoveShoppingItem(), new EditShoppingItem(),
            new MarkShoppingItemAsPurchased(), new ViewShoppingList(),

            new AddRecipe(), new ViewRecipe(), new RemoveRecipe(), new ListRecipe(),

            new AddPlan(), new AddPlanToDay(), new AddRecipeToPlan(), new ExecutePlanForDay(),
            new FindPlan(), new RemovePlanFromDay(), new RemoveRecipeFromPlan(), new ViewPlanForDay(),
            new ViewPlanForWeek(), new ViewPlanList(), new ViewPlan(), new RemovePlan()
    );

    public Help() {
        super("help", "List all commands");
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list, RecipeManager recipes,
                        MealPlanManager plans, Scanner in) {
        ui.printHelpMessage(commandList.toArray(new Command[0]));
    }
}
