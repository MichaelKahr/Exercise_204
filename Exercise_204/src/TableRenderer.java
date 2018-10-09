import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {

        Anlage a = (Anlage) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(bln ? new Color(150,150,150) : new Color(240, 240, 240));
        label.setForeground(Color.BLACK);
        String formatPattern = "###,###.##";
        DecimalFormat df = new DecimalFormat(formatPattern);
        switch (i1) {
            case 0:
                label.setText(a.getText());
                break;
            case 1:
                label.setText(String.format("%,.2f",a.getAk()));
                break;
            case 2:
                label.setText(""+a.getYear());
                break;
            case 3:
                label.setText(""+a.getDuration());
                break;
            case 4:
                label.setText(""+a.calcDurUntilNow(AnlagenGUI.year));
                break;
            case 5:
                label.setText(String.format("%,.2f",a.calcAfAUntilNow(AnlagenGUI.year)));
                break;
            case 6:
                label.setText(String.format("%,.2f",a.calcValueBefore(AnlagenGUI.year)));
                break;
            case 7:
                label.setText(String.format("%,.2f",a.calcAfA(AnlagenGUI.year)));
                break;
            case 8:
                label.setText(String.format("%,.2f",a.calcBW(AnlagenGUI.year)));
                break;

        }
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        return label;
    }

}