package Polizas.Marcas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MarcasTM extends AbstractTableModel {
    protected List<Marca> marcasLista;
    protected String[] encabezados = {"id", "nombre"};
    
    public MarcasTM() {
        marcasLista = new ArrayList<>();
        this.setColumnNames(encabezados);
    }
    
    @Override
    public String getColumnName(int cantidad) {
        return encabezados[cantidad];
    }
    
    public void setColumnNames(String[] nuevosNombres) {
        if (nuevosNombres.length == encabezados.length) {
            this.encabezados = nuevosNombres;
            fireTableStructureChanged();
        } else {
            throw new IllegalArgumentException("Valida los campos");
        }
    }
    
    public void vaciarLista() {
        marcasLista.clear();
    }
    
    @Override
    public int getRowCount() {
        return marcasLista.size();
    }
    
    @Override
    public int getColumnCount() {
        return encabezados.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex != -1) {
            Marca m = marcasLista.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return m.getId();
                case 1:
                    return m.getNombre();
                default:
                    return null;
            }
        }
        return null;
    }
    
    public void addMarca(Marca m) {
        marcasLista.add(m);
        fireTableRowsInserted(marcasLista.size() - 1, marcasLista.size() - 1);
    }
    
    public void updateMarca(int fila, Marca nueva) {
        marcasLista.set(fila, nueva);
        fireTableRowsUpdated(fila, fila);
    }
    
    public Marca getMarca(int fila) {
        return marcasLista.get(fila);
    }
    
    public void removeMarca(int fila) {
        marcasLista.remove(fila);
        fireTableRowsDeleted(fila, fila);
    }
    
    void llenar(List<Marca> lista) {
        this.marcasLista = lista;
    }
}