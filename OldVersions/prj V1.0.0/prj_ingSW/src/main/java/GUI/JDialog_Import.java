/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Merlo
 */
public class JDialog_Import extends javax.swing.JDialog {

	/**
	 * Creates new form JDialog_Import
	 */
	public JDialog_Import(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jPanel_Right_NuovoUtente = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel_NuovaCat_POP = new javax.swing.JLabel();
		jButton_ImportPers_POP = new javax.swing.JButton();
		jButton_ImportCant_POP = new javax.swing.JButton();
		Button_ImportProd_POP = new javax.swing.JButton();
		jButton_ImportCat_POP = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel2.setBackground(new java.awt.Color(0, 153, 255));
		jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 300));

		jPanel_Right_NuovoUtente.setBackground(new java.awt.Color(255, 255, 255));
		jPanel_Right_NuovoUtente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lineaBlu4.png"))); // NOI18N
		jPanel_Right_NuovoUtente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, -1, -1));

		jLabel_NuovaCat_POP.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
		jLabel_NuovaCat_POP.setForeground(new java.awt.Color(51, 51, 51));
		jLabel_NuovaCat_POP.setText("import");
		jPanel_Right_NuovoUtente.add(jLabel_NuovaCat_POP,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 30));

		jButton_ImportPers_POP.setBackground(new java.awt.Color(255, 255, 255));
		jButton_ImportPers_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
		jButton_ImportPers_POP.setForeground(new java.awt.Color(51, 51, 51));
		jButton_ImportPers_POP.setText("Import Personale");
		jButton_ImportPers_POP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_ImportPers_POPActionPerformed(evt);
			}
		});
		jPanel_Right_NuovoUtente.add(jButton_ImportPers_POP,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 160, -1));

		jButton_ImportCant_POP.setBackground(new java.awt.Color(255, 255, 255));
		jButton_ImportCant_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
		jButton_ImportCant_POP.setForeground(new java.awt.Color(51, 51, 51));
		jButton_ImportCant_POP.setText("Import Cantieri");
		jButton_ImportCant_POP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_ImportCant_POPActionPerformed(evt);
			}
		});
		jPanel_Right_NuovoUtente.add(jButton_ImportCant_POP,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 160, -1));

		Button_ImportProd_POP.setBackground(new java.awt.Color(255, 255, 255));
		Button_ImportProd_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
		Button_ImportProd_POP.setForeground(new java.awt.Color(51, 51, 51));
		Button_ImportProd_POP.setText("Import Prodotti");
		Button_ImportProd_POP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Button_ImportProd_POPActionPerformed(evt);
			}
		});
		jPanel_Right_NuovoUtente.add(Button_ImportProd_POP,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 160, -1));

		jButton_ImportCat_POP.setBackground(new java.awt.Color(255, 255, 255));
		jButton_ImportCat_POP.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
		jButton_ImportCat_POP.setForeground(new java.awt.Color(51, 51, 51));
		jButton_ImportCat_POP.setText("Import Categorie");
		jButton_ImportCat_POP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_ImportCat_POPActionPerformed(evt);
			}
		});
		jPanel_Right_NuovoUtente.add(jButton_ImportCat_POP,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 160, -1));

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/ingranaggio_1.png"))); // NOI18N
		jPanel_Right_NuovoUtente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

		getContentPane().add(jPanel_Right_NuovoUtente,
				new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 300));

		pack();
		setLocationRelativeTo(null);
	}

	public void ImportFile() {

		JFileChooser fileChooser = new JFileChooser();

		// Impostare un filtro per i file .txt
		FileNameExtensionFilter filter = new FileNameExtensionFilter("File di testo (.txt)", "txt");
		fileChooser.setFileFilter(filter);
		
		int result = fileChooser.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			File fileSelezionato = fileChooser.getSelectedFile();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileSelezionato));
				String linea;

				while ((linea = reader.readLine()) != null) {
					// SALVARE IN DB ---- IMPORTANTE ----
					System.out.println(linea);
				}

				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Operazione annullata dall'utente.");
		}
	}

	private void jButton_ImportPers_POPActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("jButton_ImportPers_POPActionPerformed");
		ImportFile();
		dispose();
	}

	private void jButton_ImportCant_POPActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("jButton_ImportCant_POPActionPerformed");
		ImportFile();
		dispose();
	}

	private void Button_ImportProd_POPActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("Button_ImportProd_POPActionPerformed");
		ImportFile();
		dispose();
	}

	private void jButton_ImportCat_POPActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("jButton_ImportCat_POPActionPerformed");
		ImportFile();
		dispose();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton Button_ImportProd_POP;
	private javax.swing.JButton jButton_ImportCant_POP;
	private javax.swing.JButton jButton_ImportCat_POP;
	private javax.swing.JButton jButton_ImportPers_POP;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel_NuovaCat_POP;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel_Right_NuovoUtente;
	// End of variables declaration//GEN-END:variables
}
