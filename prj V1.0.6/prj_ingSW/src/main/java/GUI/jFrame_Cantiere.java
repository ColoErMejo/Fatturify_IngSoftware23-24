/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import controller.Return_Avalaible_Data;
import database.DB;

/**
 *
 * @author Merlo
 */
public class jFrame_Cantiere extends javax.swing.JFrame {
	
	private static String nomeUtente;
	private DB db;
	private Return_Avalaible_Data Avalaible_Data;

	// da togliere, serviva a me per fare i test
	private  Object[][] data = {
            {"John", "Doe", 25},
            {"Jane", "Smith", 30},
            {"Bob", "Johnson", 28}
    };
	
	

	private String nomeCantiere;
	
    /**
     * Creates new form jFrame_Cantiere
     * @param nomeCantiere 
     */
    public jFrame_Cantiere(String nomeCantiere, String nomeUtente) {
    	this.nomeCantiere=nomeCantiere;
    	this.nomeUtente=nomeUtente;
        this.db= new DB(nomeUtente);
        this.Avalaible_Data= new Return_Avalaible_Data();
        initComponents();
        jComboBox_Categoria_Cant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String categoriaSelezionata = jComboBox_Categoria_Cant.getSelectedItem().toString();
                
                // Carica i prodotti basati sulla categoria selezionata
                String[] prodottiCategoria = null;
				try {
					prodottiCategoria = db.SelectNomeProdotto(categoriaSelezionata);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jComboBox_Prodotto_Cant.setVisible(true);
                // Pulisci la seconda JComboBox
                jComboBox_Prodotto_Cant.removeAllItems();
                
                // Popola la seconda JComboBox con i prodotti della categoria selezionata
                for (String prodotto : prodottiCategoria) {
                    jComboBox_Prodotto_Cant.addItem(prodotto);
                }
            }
        });
        jButton_Aggiungi_Cant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	startAttCantTables();  	
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Cantiere_Left = new javax.swing.JPanel();
        jButton_Home_Cant = new javax.swing.JButton();
        jButton_Back_Cant = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Bot_Cant = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Top_Cant = new javax.swing.JTable();
        jLabel_NomeCanti = new javax.swing.JLabel();
        jPanel_Cantiere_Right = new javax.swing.JPanel();
        jComboBox_Pers_Cant = new javax.swing.JComboBox<>();
        jComboBox_Categoria_Cant = new javax.swing.JComboBox<>();
        jComboBox_Prodotto_Cant = new javax.swing.JComboBox<>();
        jButton_ToFAttura_Cant = new javax.swing.JButton();
        jButton_Aggiungi_Cant = new javax.swing.JButton();
        jButton_NuovoProd_Cant = new javax.swing.JButton();
        jTextField_Descrizione_Cant = new javax.swing.JTextField();
        jTextField_Quantita_Cant = new javax.swing.JTextField();
        jTextField_Nore_Cant = new javax.swing.JTextField();
        jLabel_Descrizione_Cant = new javax.swing.JLabel();
        jLabel_Nore_Cant = new javax.swing.JLabel();
        jLabel_Quantita_Cant = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_NuovaCat_Cant = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Cantiere_Left.setBackground(new java.awt.Color(0, 153, 255));
        jPanel_Cantiere_Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_Home_Cant.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Home_Cant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Home.png"))); // NOI18N
        
        jPanel_Cantiere_Left.add(jButton_Home_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_Back_Cant.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Back_Cant.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Back.png"))); // NOI18N
       
        jPanel_Cantiere_Left.add(jButton_Back_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jTable_Bot_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Bot_Cant.setBorder(null);
        jTable_Bot_Cant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dipendente", "Ore", "Descrizione"
            }
        ));
        jScrollPane1.setViewportView(jTable_Bot_Cant);

        jPanel_Cantiere_Left.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 230));

        jTable_Top_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Top_Cant.setBorder(null);
        jTable_Top_Cant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
            	"Nome Prodotto", "Quantità", "Costo totale"
            }
        ));
        jScrollPane2.setViewportView(jTable_Top_Cant);

        jPanel_Cantiere_Left.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 220));

        jLabel_NomeCanti.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel_NomeCanti.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_NomeCanti.setText("jLabel3");
        jPanel_Cantiere_Left.add(jLabel_NomeCanti, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        getContentPane().add(jPanel_Cantiere_Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        jPanel_Cantiere_Right.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Cantiere_Right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox_Pers_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Pers_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Pers_Cant.setMaximumRowCount(200);
        jComboBox_Pers_Cant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        
        jPanel_Cantiere_Right.add(jComboBox_Pers_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 80, 30));

        jComboBox_Categoria_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Categoria_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Categoria_Cant.setMaximumRowCount(200);
        jComboBox_Categoria_Cant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
       
        jPanel_Cantiere_Right.add(jComboBox_Categoria_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, 30));

        jComboBox_Prodotto_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Prodotto_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox_Prodotto_Cant.setMaximumRowCount(200);
        jComboBox_Prodotto_Cant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
       
        jPanel_Cantiere_Right.add(jComboBox_Prodotto_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 80, 30));

        jButton_ToFAttura_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jButton_ToFAttura_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_ToFAttura_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jButton_ToFAttura_Cant.setText("Fattura");
        
        jPanel_Cantiere_Right.add(jButton_ToFAttura_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 180, -1));

        jButton_Aggiungi_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Aggiungi_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_Aggiungi_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Aggiungi_Cant.setText("Aggiungi");
        
        jPanel_Cantiere_Right.add(jButton_Aggiungi_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 180, -1));

        jButton_NuovoProd_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jButton_NuovoProd_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_NuovoProd_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jButton_NuovoProd_Cant.setText("Aggiungi nuovo prodotto");
        
        jPanel_Cantiere_Right.add(jButton_NuovoProd_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 210, -1));

        jTextField_Descrizione_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Descrizione_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField_Descrizione_Cant.setForeground(new java.awt.Color(0, 0, 0));
        
        jPanel_Cantiere_Right.add(jTextField_Descrizione_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 380, 110));

        jTextField_Quantita_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Quantita_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField_Quantita_Cant.setForeground(new java.awt.Color(0, 0, 0));
        
        jPanel_Cantiere_Right.add(jTextField_Quantita_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 120, -1));

        jTextField_Nore_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Nore_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField_Nore_Cant.setForeground(new java.awt.Color(0, 0, 0));
        
        jPanel_Cantiere_Right.add(jTextField_Nore_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 120, -1));

        jLabel_Descrizione_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Descrizione_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Descrizione_Cant.setText("Descrizione");
        jPanel_Cantiere_Right.add(jLabel_Descrizione_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel_Nore_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Nore_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Nore_Cant.setText("Numero ore");
        jPanel_Cantiere_Right.add(jLabel_Nore_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, 20));

        jLabel_Quantita_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel_Quantita_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Quantita_Cant.setText("Quantità");
        jPanel_Cantiere_Right.add(jLabel_Quantita_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel_Cantiere_Right.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
        jPanel_Cantiere_Right.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        jButton_NuovaCat_Cant.setBackground(new java.awt.Color(255, 255, 255));
        jButton_NuovaCat_Cant.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton_NuovaCat_Cant.setForeground(new java.awt.Color(51, 51, 51));
        jButton_NuovaCat_Cant.setText("Aggiungi nuova categoria");
        
        jPanel_Cantiere_Right.add(jButton_NuovaCat_Cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 210, -1));

        getContentPane().add(jPanel_Cantiere_Right, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 500, 600));

        pack();
        setLocationRelativeTo(null);
        
        jLabel_Descrizione_Cant.setVisible(false);
        jTextField_Descrizione_Cant.setVisible(false);
        jLabel_Quantita_Cant.setVisible(false);
        jLabel_Nore_Cant.setVisible(false);
        jTextField_Quantita_Cant.setVisible(false);
        jTextField_Nore_Cant.setVisible(false);
        jComboBox_Prodotto_Cant.setVisible(false);        
        jLabel_NomeCanti.setText(nomeCantiere);
        
        startAttCantTables();  
        comboBoxvisible(jComboBox_Categoria_Cant);
        comboBoxvisible(jComboBox_Pers_Cant);
        
        try {
			populatejComboBox(jComboBox_Categoria_Cant, Avalaible_Data.ReadDataByListOfArrayToComboBoxCat(db.SelectCategoria()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			populatejComboBox(jComboBox_Pers_Cant, Avalaible_Data.extractNames(db.SelectPersonale()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
              
        
    }
    	
  
    /*
    	jLabel_Descrizione_Cant.setVisible(false);
        jTextField_Descrizione_Cant.setVisible(false);
        jLabel_Quantita_Cant.setVisible(false);
        jLabel_Nore_Cant.setVisible(false);
        jTextField_Quantita_Cant.setVisible(false);
        jTextField_Nore_Cant.setVisible(false);
        jComboBox_Prodotto_Cant.setVisible(false);        
        jLabel_NomeCanti.setText(nomeCantiere);
        
        populateTable(jTable_Top_Cant, data);
        populateTable(jTable_Bot_Cant, data);
        
        comboBoxvisible(jComboBox_Categoria_Cant);
        comboBoxvisible(jComboBox_Pers_Cant);
     */
   
    
    public final static String[] Column_top = {"Nome Prodotto", "Quantità", "Costo totale"};
    public final static String[] Column_bot = {"Dipendente", "Ore", "Descrizione"};

    /*public void populateTable(JTable table,Object[][] data, String[] Column)
    {
    	DefaultTableModel tblmodel = new DefaultTableModel(data, Column) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        table.setModel(tblmodel);
    }*/
    public void startAttCantTables() {
    	restartTabProd();
    	restartTabPers();
    	DefaultTableModel modelTop = (DefaultTableModel) jTable_Top_Cant.getModel();
    	DefaultTableModel modelBot = (DefaultTableModel) jTable_Bot_Cant.getModel();
    	int idAttivita = db.getIdAttivitaFromNomeCantiere(nomeCantiere);
    	setTableProdotto(modelTop, idAttivita);
    	setTablePersonale(modelBot, idAttivita);
    	System.out.println("Inizializzazione Completata");
    }
    private void setTableProdotto(DefaultTableModel model, int idAttivita) {
    	populateTable(model, db.getProductsForIdAttivita(idAttivita));
		
	}


	private void setTablePersonale(DefaultTableModel model, int idAttivita) {
		populateTable(model, db.getPersonalForIdAttivita(idAttivita));
		
	}
	
	public static void populateTable(DefaultTableModel model, Object[][] prodotti) {
        // Popola la tabella con i nuovi dati
        for (Object[] riga : prodotti) {
            model.addRow(riga);
        }
    }


	public void restartTabProd() {
        DefaultTableModel model = (DefaultTableModel) jTable_Top_Cant.getModel();
        model.setRowCount(0);
    }
	public void restartTabPers() {
        DefaultTableModel model = (DefaultTableModel) jTable_Bot_Cant.getModel();
        model.setRowCount(0);
    }
	
	public void aggiornaTabPers(String nomeDipendente, String nOre, String Descrizione) {
		//restartTabPers();
		Object[] rowPers = {nomeDipendente, nOre, Descrizione};
		DefaultTableModel model = (DefaultTableModel) jTable_Bot_Cant.getModel();
		model.addRow(rowPers);
		System.out.println("Tabella Personale aggiornata con successo");
	}
	
	public void aggiornaTabProd(String nomeProdotto, int numero) throws SQLException {
		//restartTabProd();
		float costoTotale = numero*(db.getProductPriceByName(nomeProdotto));
		Object[] rowProd = {nomeProdotto, numero, costoTotale };
		DefaultTableModel model = (DefaultTableModel) jTable_Top_Cant.getModel();
		model.addRow(rowProd);
		System.out.println("Tabella Prodotti aggiornata con successo");
	}
    
    //FUNZIONE PER IMPORTARE DA DB NOMI ARRAY DI NOMI
    private String[] readDataArray() {
    	String[] items = {"cant 1", "cant 2", "cant 3"};
		return items;
	}
    
    //SETTA COMBOBOX VISIBILE E LA POPOLA CON PRODOTTI, PRENDE PARAMETRO CATEGORIA
    /*public void comboBoxvisible(JComboBox<String> jComboBox, String categoria)
    {
    	jComboBox.setVisible(true);
    	String[] items = readCategorieOrProdotti(categoria);
    	populatejComboBox(jComboBox, items);
    }*/
    
    
    //RITORNA ARRAY DI STRINGHE PER POPOLARE COMBOBOX PRODOTTI, PARAMETRO CATEGORIA
    /*private String[] readCategorieOrProdotti(String Categoria) {
    	String categoria[] = {"1","2","3"}; //SOLO PER TESTARE, DA TOGLIERE
		return categoria;
	}*/
    
    //SETTA COMBOBOX VISIBILE E LA POPOLA CON CATEGORIE O PERSONALE
    public void comboBoxvisible(JComboBox<String> jComboBox)
    {
    	jComboBox.setVisible(true);
    	/*String[] items = readCategorieOrProdotti();
    	populatejComboBox(jComboBox, items);*/
    }
    
    //RITORNA ARRAY DI STRINGHE PER POPOLARE COMBOBOX CATEGORIE O PERSONALE
    private String[] readCategorieOrProdotti() {
    	String categoria[] = {"1","2","3"}; //SOLO PER TESTARE, DA TOGLIERE
		return categoria;
	}

    //PER POPOLARE COMBOBOX
	public void populatejComboBox(JComboBox<String> comboBox,String[] items)
    {
    	for (String item : items) {
            comboBox.addItem(item);
        }
    }
	
	//SETTA JLABLE JFIELDTEXT VISIBLE
	public void jLablevisible(JLabel jlabel, JTextField jTextfield)
	{
		jlabel.setVisible(true);
		jTextfield.setVisible(true);
	}
    
	// GETTER AND SETTER
	
	public javax.swing.JLabel getjLabel_Descrizione_Cant() {
		return jLabel_Descrizione_Cant;
	}


	public void setjLabel_Descrizione_Cant(javax.swing.JLabel jLabel_Descrizione_Cant) {
		this.jLabel_Descrizione_Cant = jLabel_Descrizione_Cant;
	}


	public javax.swing.JLabel getjLabel_Nore_Cant() {
		return jLabel_Nore_Cant;
	}


	public void setjLabel_Nore_Cant(javax.swing.JLabel jLabel_Nore_Cant) {
		this.jLabel_Nore_Cant = jLabel_Nore_Cant;
	}


	public javax.swing.JLabel getjLabel_Quantita_Cant() {
		return jLabel_Quantita_Cant;
	}


	public void setjLabel_Quantita_Cant(javax.swing.JLabel jLabel_Quantita_Cant) {
		this.jLabel_Quantita_Cant = jLabel_Quantita_Cant;
	}


	public javax.swing.JButton getjButton_NuovaCat_Cant() {
		return jButton_NuovaCat_Cant;
	}

	public void setjButton_NuovaCat_Cant(javax.swing.JButton jButton_NuovaCat_Cant) {
		this.jButton_NuovaCat_Cant = jButton_NuovaCat_Cant;
	}

	public String getNomeCantiere() {
		return nomeCantiere;
	}

	public void setNomeCantiere(String nomeCantiere) {
		this.nomeCantiere = nomeCantiere;
	}

	public javax.swing.JButton getjButton_Aggiungi_Cant() {
		return jButton_Aggiungi_Cant;
	}

	public void setjButton_Aggiungi_Cant(javax.swing.JButton jButton_Aggiungi_Cant) {
		this.jButton_Aggiungi_Cant = jButton_Aggiungi_Cant;
	}

	public javax.swing.JButton getjButton_Back_Cant() {
		return jButton_Back_Cant;
	}

	public void setjButton_Back_Cant(javax.swing.JButton jButton_Back_Cant) {
		this.jButton_Back_Cant = jButton_Back_Cant;
	}

	public javax.swing.JButton getjButton_Home_Cant() {
		return jButton_Home_Cant;
	}

	public void setjButton_Home_Cant(javax.swing.JButton jButton_Home_Cant) {
		this.jButton_Home_Cant = jButton_Home_Cant;
	}

	public javax.swing.JButton getjButton_NuovoProd_Cant() {
		return jButton_NuovoProd_Cant;
	}

	public void setjButton_NuovoProd_Cant(javax.swing.JButton jButton_NuovoProd_Cant) {
		this.jButton_NuovoProd_Cant = jButton_NuovoProd_Cant;
	}

	public javax.swing.JButton getjButton_ToFAttura_Cant() {
		return jButton_ToFAttura_Cant;
	}

	public void setjButton_ToFAttura_Cant(javax.swing.JButton jButton_ToFAttura_Cant) {
		this.jButton_ToFAttura_Cant = jButton_ToFAttura_Cant;
	}

	public javax.swing.JComboBox<String> getjComboBox_Categoria_Cant() {
		return jComboBox_Categoria_Cant;
	}

	public void setjComboBox_Categoria_Cant(javax.swing.JComboBox<String> jComboBox_Categoria_Cant) {
		this.jComboBox_Categoria_Cant = jComboBox_Categoria_Cant;
	}

	public javax.swing.JComboBox<String> getjComboBox_Pers_Cant() {
		return jComboBox_Pers_Cant;
	}

	public void setjComboBox_Pers_Cant(javax.swing.JComboBox<String> jComboBox_Pers_Cant) {
		this.jComboBox_Pers_Cant = jComboBox_Pers_Cant;
	}

	public javax.swing.JComboBox<String> getjComboBox_Prodotto_Cant() {
		return jComboBox_Prodotto_Cant;
	}

	public void setjComboBox_Prodotto_Cant(javax.swing.JComboBox<String> jComboBox_Prodotto_Cant) {
		this.jComboBox_Prodotto_Cant = jComboBox_Prodotto_Cant;
	}

	public javax.swing.JLabel getjLabel_NomeCanti() {
		return jLabel_NomeCanti;
	}

	public void setjLabel_NomeCanti(javax.swing.JLabel jLabel_NomeCanti) {
		this.jLabel_NomeCanti = jLabel_NomeCanti;
	}

	public javax.swing.JTable getjTable_Bot_Cant() {
		return jTable_Bot_Cant;
	}

	public void setjTable_Bot_Cant(javax.swing.JTable jTable_Bot_Cant) {
		this.jTable_Bot_Cant = jTable_Bot_Cant;
	}

	public javax.swing.JTable getjTable_Top_Cant() {
		return jTable_Top_Cant;
	}

	public void setjTable_Top_Cant(javax.swing.JTable jTable_Top_Cant) {
		this.jTable_Top_Cant = jTable_Top_Cant;
	}

	public javax.swing.JTextField getjTextField_Descrizione_Cant() {
		return jTextField_Descrizione_Cant;
	}

	public void setjTextField_Descrizione_Cant(javax.swing.JTextField jTextField_Descrizione_Cant) {
		this.jTextField_Descrizione_Cant = jTextField_Descrizione_Cant;
	}

	public javax.swing.JTextField getjTextField_Nore_Cant() {
		return jTextField_Nore_Cant;
	}

	public void setjTextField_Nore_Cant(javax.swing.JTextField jTextField_Nore_Cant) {
		this.jTextField_Nore_Cant = jTextField_Nore_Cant;
	}

	public javax.swing.JTextField getjTextField_Quantita_Cant() {
		return jTextField_Quantita_Cant;
	}

	public void setjTextField_Quantita_Cant(javax.swing.JTextField jTextField_Quantita_Cant) {
		this.jTextField_Quantita_Cant = jTextField_Quantita_Cant;
	}


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Aggiungi_Cant;
    private javax.swing.JButton jButton_Back_Cant;
    private javax.swing.JButton jButton_Home_Cant;
    private javax.swing.JButton jButton_NuovaCat_Cant;
    private javax.swing.JButton jButton_NuovoProd_Cant;
    private javax.swing.JButton jButton_ToFAttura_Cant;
    private javax.swing.JComboBox<String> jComboBox_Categoria_Cant;
    private javax.swing.JComboBox<String> jComboBox_Pers_Cant;
    private javax.swing.JComboBox<String> jComboBox_Prodotto_Cant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Descrizione_Cant;
    private javax.swing.JLabel jLabel_NomeCanti;
    private javax.swing.JLabel jLabel_Nore_Cant;
    private javax.swing.JLabel jLabel_Quantita_Cant;
    private javax.swing.JPanel jPanel_Cantiere_Left;
    private javax.swing.JPanel jPanel_Cantiere_Right;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Bot_Cant;
    private javax.swing.JTable jTable_Top_Cant;
    private javax.swing.JTextField jTextField_Descrizione_Cant;
    private javax.swing.JTextField jTextField_Nore_Cant;
    private javax.swing.JTextField jTextField_Quantita_Cant;
    // End of variables declaration//GEN-END:variables
}
