
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class AnlagenModel extends AbstractTableModel {

    private static String[] colNames = {"Bezeichnung", "AK", "Inbetriebname", "ND", "bish. ND", "AfA bisher", "Wert vor...", "AfA d. J.", "BW 31.12"};
    private LinkedList<Entry> entries = new LinkedList<>();

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    @Override
    public int getRowCount() {
        return entries.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Entry e = entries.get(rowIndex);
        return e;
    }

}
