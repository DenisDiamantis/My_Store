import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ProductRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Product) {
            setText(
            		"Product Code: " + ((Product)value).getCode() 
            		+ " | Product: " + ((Product)value).getModel()
            		+ " | Quantity: " + CatalogLoader.productsCatalog.get((Product)value)
            );
        }
        return this;
    }
}