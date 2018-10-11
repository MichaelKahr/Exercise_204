
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class AnlagenModel extends AbstractTableModel {

    private LinkedList<Anlage> anlagen = new LinkedList<>();

    private static String[] colNames = {"Bezeichnung", "AK", "Inbetr.na...", "ND", "bish. ND","AfA bisher", "Wert vor ...", "AfA d. J.", "BW 31.12"};

    public double convert(String in) {
        if (in.contains(",")) {
            in = in.replaceAll(",", ".");
            return Double.parseDouble(in);
        }
        return Double.parseDouble(in);
    }

    public void add(Anlage a) {
        anlagen.add(a);
        fireTableRowsInserted(anlagen.size() - 1, anlagen.size() - 1);
    }

    public void load(File f) {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data[1].contains(".")) {
                    data[1] = data[1].replace(".", "");
                }
                anlagen.add(new Anlage(data[0], Double.parseDouble(data[1]), convert(data[2]), convert(data[3])));
                fireTableDataChanged();
            }

        } catch (Exception e) {
            
        }
        System.out.println("test");
    }

    public void update() {
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return anlagen.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Anlage anlage = anlagen.get(rowIndex);
        return anlage;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    public int listSize() {
        return anlagen.size();
    }
}
