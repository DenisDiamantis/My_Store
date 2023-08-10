import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class OrderRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Order) {
            setText("Order Code: " + ((Order)value).getOrderCode() + " | Product: " + ((Order)value).getOrderProduct().getModel() 
            		+ " | Full Name: " + ((Order)value).getCustomerName() + " " + ((Order)value).getCustomerSurname());
        }
        return this;
    }
}