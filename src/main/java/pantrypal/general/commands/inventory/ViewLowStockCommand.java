package pantrypal.general.commands.inventory;

import pantrypal.general.commands.Command;
import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;

public class ViewLowStockCommand extends Command {

    public ViewLowStockCommand() {
        super("viewLowStock", "View low stock of inventory");
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory) {
        inventory.viewLowStock();
    }
}
