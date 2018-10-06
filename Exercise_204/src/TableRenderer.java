
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Entry e = (Entry) value;
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (column) {
            case 0:
                label.setText(e.getName());
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 1:
                label.setText(e.getAk() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 2:
                label.setText(e.getBeginning().toString());
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 3:
                label.setText(e.getNd() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 4:
                label.setText(e.getBnd() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 5:
                label.setText(e.getAfabisher() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 6:
                label.setText(e.getWertvorher() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;
            case 7:
                label.setText(e.getAfadj() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
            case 8:
                label.setText(e.getBw() + "");
                if (label.getText().equals("0")) {
                    label.setBackground(Color.red);
                }
                break;

        }

        return label;
    }

}
