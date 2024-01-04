package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import GUI.JDialog_AggiungiCategoria;
import GUI.JDialog_ModificaCategoria;
import GUI.JDialog_EliminaCategoria;
import GUI.JDialog_AggiungiProdotto;
import GUI.JDialog_EliminaProdotto;
import GUI.JDialog_ModificaProdotto;
import GUI.jFrame_Inventario;

import GUI.jFrame_principale;
import database.DB;
import database.DB_Login;
import model.Categoria;
import model.Prodotto;

public class Controller_Inventario implements ActionListener{
	

	private String NomeUtente;
	private DB db;
	private jFrame_Inventario jFrame_inventario;

	public Controller_Inventario(jFrame_Inventario jFrame, String NomeUtente) {
		this.jFrame_inventario = jFrame;
		this.NomeUtente = NomeUtente;
		this.db = new DB(NomeUtente);

		jFrame.getjButton_AddProd().addActionListener(this);
		jFrame.getjButton_Back_Invent().addActionListener(this);
		jFrame.getjButton_ChangeCat1().addActionListener(this);
		jFrame.getjButton_ChangeProd().addActionListener(this);
		jFrame.getjButton_EliminaCat().addActionListener(this);
		jFrame.getjButton_EliminaProd().addActionListener(this);
		jFrame.getjButton_Home_Invent().addActionListener(this);
		jFrame.getjButtonAddCategoria().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jFrame_inventario.getjButton_AddProd())
			jButton_AddProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_Back_Invent())
			jButton_Back_InventActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_ChangeCat1())
			jButton_ChangeCat1ActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_ChangeProd())
			jButton_ChangeProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_EliminaCat())
			jButton_EliminaCatActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_EliminaProd())
			jButton_EliminaProdActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButton_Home_Invent())
			jButton_Home_InventActionPerformed();
		else if (e.getSource() == jFrame_inventario.getjButtonAddCategoria())
			jButtonAddCategoriaActionPerformed();
	}

	private void jButtonAddCategoriaActionPerformed() {
		openDialogForNuovaCategoria();
		

	}

	private void jButton_Home_InventActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);

		jframe_principale.setVisible(true);
		jFrame_inventario.setVisible(false);
		System.out.println("open jframe_principale");
	}

	private void jButton_Back_InventActionPerformed() {
		jFrame_principale jframe_principale = new jFrame_principale();
		Controller_Principale controller_principale = new Controller_Principale(jframe_principale, NomeUtente);

		jframe_principale.setVisible(true);
		jFrame_inventario.setVisible(false);
		System.out.println("open jframe_principale");
	}

	private void jButton_ChangeCat1ActionPerformed() {
		JDialog_ModificaCategoria Jdialog_modificacategoria = new JDialog_ModificaCategoria(jFrame_inventario, true, NomeUtente);
		Jdialog_modificacategoria.setVisible(true);
		
		String VecchiaCategoria = Jdialog_modificacategoria.getjComboBox_Categoria_POP().getSelectedItem().toString();
		String NuovaCategoria = Jdialog_modificacategoria.getjTextField_NomeCategoria_POP().getText();
		boolean CheckBox = Jdialog_modificacategoria.getjCheckBox1_Elimina().isSelected();
		
		boolean ERROR = false;
		if (VecchiaCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificacategoria, "Selezionare una categoria");
			ERROR = true;
		} else if (NuovaCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificacategoria, "Inserire il nuovo nome");
			ERROR = true;
		}
		if (!ERROR) {
			try {
				System.out.println(NuovaCategoria);
				if(CheckBox == true) {
					db.deleteProdottoByCategoria(VecchiaCategoria);
				}
				modificaCategoria(VecchiaCategoria, NuovaCategoria);
				if(jFrame_inventario!=null) {
					jFrame_inventario.aggiornaTabCat();
					jFrame_inventario.aggiornaTabProd();
				}
				
			} catch (ArithmeticException e) {
				e.printStackTrace();
				}
			}
		}
	

	private void jButton_EliminaCatActionPerformed() {
		JDialog_EliminaCategoria Jdialog_eliminacategoria = new JDialog_EliminaCategoria(jFrame_inventario, true, NomeUtente);
		Jdialog_eliminacategoria.setVisible(true);
		
		String Categoria = Jdialog_eliminacategoria.getjComboBox_Categoria_POP().getSelectedItem().toString();
		boolean ERROR = false;
		if (Categoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_eliminacategoria, "Selezionare una categoria");
			ERROR = true;
		}
		if (!ERROR) {
			try {
				System.out.println(Categoria);
				JOptionPane.showMessageDialog(Jdialog_eliminacategoria, "Eliminando questa categoria, verranno rimossi anche tutti i prodotti ad essa associati");
				eliminaCategoria(Categoria);
				if(jFrame_inventario!=null) {
					jFrame_inventario.aggiornaTabCat();
					jFrame_inventario.aggiornaTabProd();
				}
				
			} catch (ArithmeticException e) {
				e.printStackTrace();
				}
			}

	}

	private void jButton_ChangeProdActionPerformed() {
		JDialog_ModificaProdotto Jdialog_modificaprodotto = new JDialog_ModificaProdotto(jFrame_inventario, true, NomeUtente);
		Jdialog_modificaprodotto.setVisible(true);
		
		String NuovoNomeProdotto = Jdialog_modificaprodotto.getjTextField_NuovoNome_POP().getText().trim();
		String PrezzoUnitario = Jdialog_modificaprodotto.getjTextField_NuovoPrezzo_POP().getText().trim();
		String Categoria = Jdialog_modificaprodotto.getjComboBox_Categoria_POP().getSelectedItem().toString();
		String VecchioNomeProdotto = Jdialog_modificaprodotto.getjComboBox_Prodotto_POP().getSelectedItem().toString();
		
		boolean ERROR = false;
		if (NuovoNomeProdotto.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificaprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (PrezzoUnitario.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_modificaprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		}
		if (!ERROR) {
			boolean errorFloat = true;
			try {
				float PrezzoUnitarioFloat = Float.parseFloat(PrezzoUnitario);
				System.out.println(NuovoNomeProdotto + PrezzoUnitarioFloat + Categoria);
				errorFloat = false;
				modificaProdotto(VecchioNomeProdotto, NuovoNomeProdotto, PrezzoUnitarioFloat, Categoria);
				if(jFrame_inventario!=null) {
					jFrame_inventario.aggiornaTabProd();
				}
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} finally {
				if (errorFloat) {
					JOptionPane.showMessageDialog(Jdialog_modificaprodotto, "il costo deve essere un numero");
				}
			}
		}
		
		
	}

	private void jButton_AddProdActionPerformed() {
		JDialog_AggiungiProdotto Jdialog_aggiungiprodotto = new JDialog_AggiungiProdotto(jFrame_inventario, true, NomeUtente);
		Jdialog_aggiungiprodotto.setVisible(true);
		
		
		String NomeProdotto = Jdialog_aggiungiprodotto.getjTextField_Nome_POP().getText().trim();
		String PrezzoUnitario = Jdialog_aggiungiprodotto.getjTextFieldPrezzo_POP().getText().trim();
		String Categoria = Jdialog_aggiungiprodotto.getjComboBox_Categoria_POP().getSelectedItem().toString();

		boolean ERROR = false;
		if (NomeProdotto.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (PrezzoUnitario.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} else if (Categoria.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		}
		if (!ERROR) {
			boolean errorFloat = true;
			try {
				float PrezzoUnitarioFloat = Float.parseFloat(PrezzoUnitario);
				System.out.println(NomeProdotto + PrezzoUnitarioFloat + Categoria);
				errorFloat = false;
				addProdotto(NomeProdotto, PrezzoUnitarioFloat, Categoria);
				if(jFrame_inventario!=null) {
					jFrame_inventario.aggiornaTabCat();
					jFrame_inventario.aggiornaTabProd();
				}
			} catch (ArithmeticException e) {
				e.printStackTrace();
			} finally {
				if (errorFloat) {
					JOptionPane.showMessageDialog(Jdialog_aggiungiprodotto, "il costo deve essere un numero");
				}
			}
		}

	}

	private void jButton_EliminaProdActionPerformed() {
		JDialog_EliminaProdotto Jdialog_eliminaprodotto = new JDialog_EliminaProdotto(jFrame_inventario, true, NomeUtente);
		Jdialog_eliminaprodotto.setVisible(true);
	
		String NomeProdotto = (String) Jdialog_eliminaprodotto.getjComboBox_Prodotto_POP().getSelectedItem();
		
		
		boolean ERROR = false;
		if (NomeProdotto.isEmpty()) {
			JOptionPane.showMessageDialog(Jdialog_eliminaprodotto, "i campi non possono essere vuoti");
			ERROR = true;
		} 
		if (!ERROR) {
			try {
				System.out.println(NomeProdotto);
				rimuoviProdotto(NomeProdotto);
				if(jFrame_inventario!=null) {
					jFrame_inventario.aggiornaTabCat();
					jFrame_inventario.aggiornaTabProd();
				}
			} catch (ArithmeticException e) {
				e.printStackTrace();
			}
		}
		

	}

	private void addProdotto(String nomeProdotto, float prezzoUnitario, String categoria) {
	    // Recuperare la categoria esistente dal database
	    Categoria cat = db.recuperaCategoriaPerNome(categoria);

	    if (cat != null) {
	        // La categoria esiste già nel database
	        Prodotto prod = new Prodotto(nomeProdotto, prezzoUnitario, categoria);
	        
	        // Aggiungi il prodotto all'oggetto Categoria esistente
	        cat.AddProdotto(prod);
	        
	        // Esegui l'inserimento del nuovo prodotto nel database
	        db.insertNuovoProdotto(prod);
	        
	        System.out.println("Prodotto " + prod.toString() + " inserito correttamente nella categoria " + cat.toString());
	    } /*else {
	        System.out.println("La categoria " + categoria + " non esiste nel database.");
	    }*/
	}
	
	private void modificaProdotto(String vecchioNomeProdotto, String nuovoNomeProdotto, float prezzoUnitario, String categoria) {
	    // Recuperare la categoria esistente dal database
	    Categoria cat = db.recuperaCategoriaPerNome(categoria);

	    if (cat != null) {
	        // La categoria esiste già nel database
	        cat.ModificaProdotto(vecchioNomeProdotto, nuovoNomeProdotto, prezzoUnitario);
	        // Esegui la modifica del nuovo prodotto nel database
	        db.changeProdotto(vecchioNomeProdotto, nuovoNomeProdotto, prezzoUnitario, categoria);
	        
	        System.out.println("Prodotto inserito correttamente nella categoria " + cat.toString());
	    } /*else {
	        System.out.println("La categoria " + categoria + " non esiste nel database.");
	    }*/
	}

	
	private void rimuoviProdotto(String NomeProdotto) {
		//cancellare dal DB
		db.deleteProdotto(NomeProdotto);
	}
	
	// AGGIUNGE NUOVA CATEGORIA
		private void openDialogForNuovaCategoria() {
				JDialog_AggiungiCategoria Jdialog_aggiungicategoria = new JDialog_AggiungiCategoria(jFrame_inventario, true);
				Jdialog_aggiungicategoria.setVisible(true);

				String NomeCategoria = Jdialog_aggiungicategoria.getjTextField_NomeCat_POP().getText().trim();
				if (NomeCategoria.isEmpty()) {
					JOptionPane.showMessageDialog(Jdialog_aggiungicategoria, "i campi non possono essere vuoti");
				} else {
					addCategoria(NomeCategoria);
					if(jFrame_inventario!=null) {
						jFrame_inventario.aggiornaTabCat();
					}
				}
			}

	// SALVARE IN DB NUOVA CATEGORIA (CHIAMATA DA openDialogForNuovaCategoria())
	private void addCategoria(String nomeCategoria) {
			db.insertNuovaCategoria(nomeCategoria);
		}
	private void modificaCategoria(String vecchioNomecategoria, String nuovoNomecategoria) {
		Categoria cat = db.recuperaCategoriaPerNome(vecchioNomecategoria);
		 if (cat != null) {
		        // La categoria esiste già nel database
		        cat.setNomeCategoria(nuovoNomecategoria);
		        // Esegui la modifica della categoria nel database
		        db.changeCategoria(vecchioNomecategoria, nuovoNomecategoria);
		        
		        System.out.println("Categoria modificata correttamente " + cat.toString());
		    }
		
	}
	
	private void eliminaCategoria(String nomeCategoria) {
		//eliminando una categoria devo rimuovere anche tutti i prodotti associati ad essa
		db.deleteProdottoByCategoria(nomeCategoria);
		//procedo ad eliminare la categoria dal db
		db.deleteCategoria(nomeCategoria);
	}

	
	  


}
