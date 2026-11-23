/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Veiculo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{
    private List<Veiculo> listaProdutos = new ArrayList<>();
    private String[] colunas = {"Tipo", "Placa", "Modelo", "ValorBase"};
    
    @Override
    public int getRowCount() {
        return listaProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            
            case 0:
                return listaProdutos.get(rowIndex).getTipo();
                
                case 1:
                return listaProdutos.get(rowIndex).getPlaca();
                
            case 2:
                return listaProdutos.get(rowIndex).getModelo();
                
            case 3:
                return listaProdutos.get(rowIndex).getValorBase();
                
            default:
                return null;
                
        }
    }
    
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void addRow(Veiculo v){
        listaProdutos.add(v);
    }
    
}
