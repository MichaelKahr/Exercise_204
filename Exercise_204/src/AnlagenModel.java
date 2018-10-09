
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
            String s;

            while ((s = br.readLine()) != null) {
                String[] split = s.split(";");
                if (split[1].contains(".")) {
                    split[1] = split[1].replace(".", "");

                }
                anlagen.add(new Anlage(split[0], Double.parseDouble(split[1]), convert(split[2]), convert(split[3])));
                fireTableDataChanged();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("lul");
    }

    public void update() {
        fireTableCellUpdated(0, anlagen.size() - 1);
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
    public Object getValueAt(int i, int i1) {
        Anlage a = anlagen.get(i);
        return a;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    public int listSize() {
        return anlagen.size();
    }
}
