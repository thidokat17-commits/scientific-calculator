/**
    * Scientific Calculator - SDN150S Software Design 1
    * @author Thato Kgomo 261180355
    * Onelizo Zamagquma Bandezi 241321573
    * Sinesipho Chulumanco Mkundlu 240590759
    * Zubenathi Mafilika 241312817
    */


public class convertor extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(convertor.class.getName());

    /**
     * Creates new form convertor
     */
    public convertor() {
        initComponents();
        
        // Category list (replaces what the designer put in the combo box)
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "Length", "Time", "Temperature" }));

        // When the category changes, refill the two unit boxes
        jComboBox3.addActionListener(evt -> fillUnits());

        // Fill the unit boxes for the first category
        fillUnits();

        // The answer box only shows the answer, you can't type in it
        jText2.setEditable(false);
    }
    // Show only the units that belong to the chosen category
   private  void fillUnits() {
        String category = (String) jComboBox3.getSelectedItem();
        String[] units;

        if (category.equals("Length")) {
            units = new String[] { "mm", "m", "km" };
        } else if (category.equals("Time")) {
            units = new String[] { "ms", "s", "ks" };
        } else {
            units = new String[] { "Celsius", "Kelvin" };
        }

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(units));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(units));

        jText2.setText("");
    }

    // How big each unit is compared to m (length) or s (time)
   private double factor(String unit) {
        switch (unit) {
            case "mm": return 0.001;
            case "m":  return 1;
            case "km": return 1000;
            case "ms": return 0.001;
            case "s":  return 1;
            case "ks": return 1000;
            default:   throw new RuntimeException("Unknown unit");
        }
    }

    // The convert method
   private void convert() {
        double value;
        try {
            value = Double.parseDouble(jText.getText().trim());
        } catch (NumberFormatException ex) {
            jText2.setText("Enter a number");
            return;
        }

        String category = (String) jComboBox3.getSelectedItem();
        String from = (String) jComboBox1.getSelectedItem();
        String to = (String) jComboBox2.getSelectedItem();

        double result;

        if (category.equals("Temperature")) {
            double kelvin;
            if (from.equals("Celsius")) {
                kelvin = value + 273.15;
            } else {
                kelvin = value;
            }

            if (kelvin < 0) {
                jText2.setText("Below absolute zero");
                return;
            }

            if (to.equals("Celsius")) {
                result = kelvin - 273.15;
            } else {
                result = kelvin;
            }
        } else {
            double baseValue = value * factor(from);
            result = baseValue / factor(to);
        }

        result = Math.rint(result * 1e10) / 1e10;
        jText2.setText(java.math.BigDecimal.valueOf(result).stripTrailingZeros().toPlainString());
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jText2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 12, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("UNIT CONVERTOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 340, 60));
        getContentPane().add(jText, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 330, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("MAGNITUDE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("FROM ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 60, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("CONVERTED MAGNITUDE ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "mm", "km", "s", "ms", "ks", "Kelvin ", "Celcius" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 330, 30));

        jText2.addActionListener(this::jText2ActionPerformed);
        getContentPane().add(jText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 390, 40));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "mm", "km", "s", "ks", "ms", "Celcius   ", "Kelvin  " }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 330, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("category ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mass", "Time", "Temperature" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 330, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton2.setText("convert");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 160, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton3.setText("clear");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 130, -1));

        pack();
    }// </editor-fold>                        

    private void jText2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
        convert();
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
        jText.setText("");
        jText2.setText("");
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
             Calculator e = new Calculator();
this.setVisible(false);
e.setVisible(true);
dispose();
        
        
    }                                        

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new convertor().setVisible(true));
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText;
    private javax.swing.JTextField jText2;
    // End of variables declaration                   
}
