package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.DB;
import model.Categoria;
import model.Prodotto;

public class Return_Avalaible_Data {

	public Return_Avalaible_Data() {
		
	}

	public String[] ReadDataByListOfArray(List<String[]> lista) throws SQLException {
		String string = "";
		for (String[] riga : lista) {
			for (String valore : riga) {
				System.out.print(valore + " ");
				string = string + valore + ",";
			}
			System.out.println();
		}
		String[] data = string.split(",");
		System.out.println(data);
		return data;
	}
	
	
	public String[] ReadDataByListOfArrayToComboBoxCat(List<Categoria> lista) throws SQLException {
	
		String[] risultati = new String[lista.size()];
		List<Categoria> cat = lista;
		for (int i=0; i<cat.size(); i++)
		{
			risultati[i]=cat.get(i).getNomeCategoria();
			System.out.println(risultati[i]);
		}
		return risultati;
	}

	public static String[][] ReadDataByListOfArrayBiDimensional(List<String> lista) {
		int dimensioneLista = lista.size();
		String[][] data = new String[dimensioneLista][1];

		for (int i = 0; i < dimensioneLista; i++) {
			data[i][0] = lista.get(i);
		}

		for (String[] riga : data) {
			System.out.println(java.util.Arrays.toString(riga));
		}
		return data;
	}
	
	public String[][] DataPerCategoriaTable(List<Categoria> lista)
	{
		String[][] risultati = new String[lista.size()][2];
		List<Categoria> cat = lista;
		for (int i=0; i<cat.size(); i++)
		{
			risultati[i][0]=cat.get(i).getNomeCategoria();
			risultati[i][1]=cat.get(i).NumeroDiProdotti();
			System.out.println(risultati[i][0] + "-" + risultati[i][1]);
		}
		return risultati;
	}
	
	public String[][] DataPerProdottiTable(List<String[]> lista)
	{
		int numeroRighe = lista.size();
        int numeroColonne = lista.get(0).length;
        String[][] data = new String[numeroRighe][numeroColonne];

        for (int i = 0; i < numeroRighe; i++) {
        	data[i] = lista.get(i);
        }
        
        return data;
	}
	
	public void populateTable(JTable table,Object[][] data)
    {
        DefaultTableModel tblmodel =  (DefaultTableModel)table.getModel();
        for (Object[] row : data) {     
            	tblmodel.addRow(row);
        }
    }
	
	public void AddProdottoToCategoria(Categoria cat, Prodotto prod)
	{
		cat.AddProdotto(prod);
	}
}
