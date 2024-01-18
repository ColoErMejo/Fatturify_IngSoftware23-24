package controller;

import java.sql.SQLException;
import java.util.List;

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
}
