/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author Merlo
 */
public class jFrame_fattura extends javax.swing.JFrame {

    
    public jFrame_fattura() {
        initComponents();
    }

    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton_Home_Fattura = new javax.swing.JButton();
        jButton_Back_Fattura = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_MargineNetto = new javax.swing.JLabel();
        jLabel_SpesaMateriali = new javax.swing.JLabel();
        jLabel_SpesaDipendenti = new javax.swing.JLabel();
        jLabel_Imposte = new javax.swing.JLabel();
        jLabel_TotaleSpese = new javax.swing.JLabel();
        jLabel_SpesaMateriali_OUT = new javax.swing.JLabel();
        jLabel_SpesaDipendenti_OUT = new javax.swing.JLabel();
        jLabel_Imposte_OUT = new javax.swing.JLabel();
        jLabel_TotaleSpese_OUT = new javax.swing.JLabel();
        jLabel_MargineNetto_OUT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSlider1.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(50);
        jSlider1.setMinorTickSpacing(2);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(10);
        jPanel2.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 400, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nome Cantiere");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jButton_Home_Fattura.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Home_Fattura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Home.png"))); // NOI18N
        
        jPanel2.add(jButton_Home_Fattura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_Back_Fattura.setBackground(new java.awt.Color(0, 153, 255));
        jButton_Back_Fattura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Back.png"))); // NOI18N
       
        jPanel2.add(jButton_Back_Fattura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_MargineNetto.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_MargineNetto.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_MargineNetto.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_MargineNetto.setText("Margine Netto");
        jPanel1.add(jLabel_MargineNetto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel_SpesaMateriali.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_SpesaMateriali.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_SpesaMateriali.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_SpesaMateriali.setText("Spesa Materiali");
        jPanel1.add(jLabel_SpesaMateriali, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel_SpesaDipendenti.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_SpesaDipendenti.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_SpesaDipendenti.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_SpesaDipendenti.setText("Spesa Dipendenti");
        jPanel1.add(jLabel_SpesaDipendenti, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel_Imposte.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Imposte.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_Imposte.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Imposte.setText("Imposte");
        jPanel1.add(jLabel_Imposte, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        jLabel_TotaleSpese.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_TotaleSpese.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_TotaleSpese.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_TotaleSpese.setText("Totale Spese");
        jPanel1.add(jLabel_TotaleSpese, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jLabel_SpesaMateriali_OUT.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_SpesaMateriali_OUT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_SpesaMateriali_OUT.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_SpesaMateriali_OUT.setText("outputSP");
        jPanel1.add(jLabel_SpesaMateriali_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jLabel_SpesaDipendenti_OUT.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_SpesaDipendenti_OUT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_SpesaDipendenti_OUT.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_SpesaDipendenti_OUT.setText("outSD");
        jPanel1.add(jLabel_SpesaDipendenti_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        jLabel_Imposte_OUT.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_Imposte_OUT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_Imposte_OUT.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_Imposte_OUT.setText("outImposte");
        jPanel1.add(jLabel_Imposte_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        jLabel_TotaleSpese_OUT.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_TotaleSpese_OUT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_TotaleSpese_OUT.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_TotaleSpese_OUT.setText("outTotale ");
        jPanel1.add(jLabel_TotaleSpese_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        jLabel_MargineNetto_OUT.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_MargineNetto_OUT.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel_MargineNetto_OUT.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_MargineNetto_OUT.setText("outMargine ");
        jPanel1.add(jLabel_MargineNetto_OUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("export su desktop");
       
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 510, 600));

        pack();
        setLocationRelativeTo(null);
    }

    
    
    public javax.swing.JButton getjButton1() {
		return jButton1;
	}

	public void setjButton1(javax.swing.JButton jButton1) {
		this.jButton1 = jButton1;
	}

	public javax.swing.JButton getjButton_Back_Fattura() {
		return jButton_Back_Fattura;
	}

	public void setjButton_Back_Fattura(javax.swing.JButton jButton_Back_Fattura) {
		this.jButton_Back_Fattura = jButton_Back_Fattura;
	}

	public javax.swing.JButton getjButton_Home_Fattura() {
		return jButton_Home_Fattura;
	}

	public void setjButton_Home_Fattura(javax.swing.JButton jButton_Home_Fattura) {
		this.jButton_Home_Fattura = jButton_Home_Fattura;
	}

	public javax.swing.JLabel getjLabel_Imposte_OUT() {
		return jLabel_Imposte_OUT;
	}

	public void setjLabel_Imposte_OUT(javax.swing.JLabel jLabel_Imposte_OUT) {
		this.jLabel_Imposte_OUT = jLabel_Imposte_OUT;
	}

	public javax.swing.JLabel getjLabel_MargineNetto_OUT() {
		return jLabel_MargineNetto_OUT;
	}

	public void setjLabel_MargineNetto_OUT(javax.swing.JLabel jLabel_MargineNetto_OUT) {
		this.jLabel_MargineNetto_OUT = jLabel_MargineNetto_OUT;
	}

	public javax.swing.JLabel getjLabel_SpesaDipendenti_OUT() {
		return jLabel_SpesaDipendenti_OUT;
	}

	public void setjLabel_SpesaDipendenti_OUT(javax.swing.JLabel jLabel_SpesaDipendenti_OUT) {
		this.jLabel_SpesaDipendenti_OUT = jLabel_SpesaDipendenti_OUT;
	}

	public javax.swing.JLabel getjLabel_SpesaMateriali_OUT() {
		return jLabel_SpesaMateriali_OUT;
	}

	public void setjLabel_SpesaMateriali_OUT(javax.swing.JLabel jLabel_SpesaMateriali_OUT) {
		this.jLabel_SpesaMateriali_OUT = jLabel_SpesaMateriali_OUT;
	}

	public javax.swing.JLabel getjLabel_TotaleSpese_OUT() {
		return jLabel_TotaleSpese_OUT;
	}

	public void setjLabel_TotaleSpese_OUT(javax.swing.JLabel jLabel_TotaleSpese_OUT) {
		this.jLabel_TotaleSpese_OUT = jLabel_TotaleSpese_OUT;
	}

	public javax.swing.JSlider getjSlider1() {
		return jSlider1;
	}

	public void setjSlider1(javax.swing.JSlider jSlider1) {
		this.jSlider1 = jSlider1;
	}



	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Back_Fattura;
    private javax.swing.JButton jButton_Home_Fattura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Imposte;
    private javax.swing.JLabel jLabel_Imposte_OUT;
    private javax.swing.JLabel jLabel_MargineNetto;
    private javax.swing.JLabel jLabel_MargineNetto_OUT;
    private javax.swing.JLabel jLabel_SpesaDipendenti;
    private javax.swing.JLabel jLabel_SpesaDipendenti_OUT;
    private javax.swing.JLabel jLabel_SpesaMateriali;
    private javax.swing.JLabel jLabel_SpesaMateriali_OUT;
    private javax.swing.JLabel jLabel_TotaleSpese;
    private javax.swing.JLabel jLabel_TotaleSpese_OUT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
