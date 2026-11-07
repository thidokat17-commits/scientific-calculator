   import java.util.ArrayList;
   import javax.swing.JOptionPane;
   public class PROJECT1 extends javax.swing.JFrame {
   private double val;
   private double ans;
   private double memory;
   private int calc;
   private ArrayList<Double> statData;
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PROJECT1.class.getName());

    public PROJECT1() {
        initComponents();
    
    this.val = 0.0;
    this.ans = 0.0;
    this.memory = 0.0;
    this.calc = 0;
    this.statData = new ArrayList<Double>();
    }
    public void arithmetic_op(){
    try{
        double secondVal = Double.parseDouble(disTF.getText());
        switch(calc){
            case 1:
                ans = val + secondVal;
                disTF.setText(Double.toString(ans));
                break;
                
                case 2:
                ans = val - secondVal;
                disTF.setText(Double.toString(ans));
                break;
                
                case 3:
                ans = val * secondVal;
                disTF.setText(Double.toString(ans));
                break;
                
                case 4:
                if(secondVal == 0.0){
                disTF.setText(Double.toString(ans));
                }
                break;
                
                case 5:
                ans = Math.pow(val, secondVal);
                disTF.setText(Double.toString(ans));
                break;
                
                default:
                break;
        }} catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Please enter a valid number first", "Math Error", JOptionPane.ERROR_MESSAGE);
        }
    }      
        private double calculateFactorial(int n){
        if(n < 0){
        return Double.NaN;
        }
        double result = 1.0;
         for(int i = 1; i <= n; i++){
         result *= i;
         }
        return result;     
        }
   
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        disTF = new javax.swing.JTextField();
        sinBn = new javax.swing.JButton();
        cosBn = new javax.swing.JButton();
        tanBn = new javax.swing.JButton();
        squareBn = new javax.swing.JButton();
        sqrtBn = new javax.swing.JButton();
        logBn = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        mPlusBn = new javax.swing.JButton();
        mrBn = new javax.swing.JButton();
        factBn = new javax.swing.JButton();
        meanBn = new javax.swing.JButton();
        sumBn = new javax.swing.JButton();
        delBn = new javax.swing.JButton();
        clearBn = new javax.swing.JButton();
        sevenBn = new javax.swing.JButton();
        eightBn = new javax.swing.JButton();
        nineBn = new javax.swing.JButton();
        divideBn = new javax.swing.JButton();
        fourBn = new javax.swing.JButton();
        fiveBn = new javax.swing.JButton();
        sixBn = new javax.swing.JButton();
        multiBn = new javax.swing.JButton();
        oneBn = new javax.swing.JButton();
        twoBn = new javax.swing.JButton();
        threeBn = new javax.swing.JButton();
        subBn = new javax.swing.JButton();
        zeroBn = new javax.swing.JButton();
        dotBn = new javax.swing.JButton();
        equalBn = new javax.swing.JButton();
        addBn = new javax.swing.JButton();
        historyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setText("CASIO");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTextField2.setText("NATURAL-V.P.A.M.");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextField3.setText("fx-82 ZA PLUS ||");
        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        disTF.setEditable(false);
        disTF.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        disTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        sinBn.setText("sin");
        sinBn.addActionListener(this::sinBnActionPerformed);

        cosBn.setText("cos");
        cosBn.addActionListener(this::cosBnActionPerformed);

        tanBn.setText("tan");
        tanBn.addActionListener(this::tanBnActionPerformed);

        squareBn.setText("xÂ²");
        squareBn.addActionListener(this::squareBnActionPerformed);

        sqrtBn.setText("âˆš");
        sqrtBn.addActionListener(this::sqrtBnActionPerformed);

        logBn.setText("log");
        logBn.addActionListener(this::logBnActionPerformed);

        jButton7.setText("ln");
        jButton7.addActionListener(this::jButton7ActionPerformed);

        mPlusBn.setText("M+");
        mPlusBn.addActionListener(this::mPlusBnActionPerformed);

        mrBn.setText("MR");
        mrBn.addActionListener(this::mrBnActionPerformed);

        factBn.setText("n!");
        factBn.addActionListener(this::factBnActionPerformed);

        meanBn.setText("Mean");
        meanBn.addActionListener(this::meanBnActionPerformed);

        sumBn.setText("sum");
        sumBn.addActionListener(this::sumBnActionPerformed);

        delBn.setText("DEL");
        delBn.addActionListener(this::delBnActionPerformed);

        clearBn.setText("AC");
        clearBn.addActionListener(this::clearBnActionPerformed);

        sevenBn.setText("7");
        sevenBn.addActionListener(this::sevenBnActionPerformed);

        eightBn.setText("8");
        eightBn.addActionListener(this::eightBnActionPerformed);

        nineBn.setText("9");
        nineBn.addActionListener(this::nineBnActionPerformed);

        divideBn.setText("Ã·");
        divideBn.addActionListener(this::divideBnActionPerformed);

        fourBn.setText("4");
        fourBn.addActionListener(this::fourBnActionPerformed);

        fiveBn.setText("5");
        fiveBn.addActionListener(this::fiveBnActionPerformed);

        sixBn.setText("6");
        sixBn.addActionListener(this::sixBnActionPerformed);

        multiBn.setText("Ã—");
        multiBn.addActionListener(this::multiBnActionPerformed);

        oneBn.setText("1");
        oneBn.addActionListener(this::oneBnActionPerformed);

        twoBn.setText("2");
        twoBn.addActionListener(this::twoBnActionPerformed);

        threeBn.setText("3");
        threeBn.addActionListener(this::threeBnActionPerformed);

        subBn.setText("-");
        subBn.addActionListener(this::subBnActionPerformed);

        zeroBn.setText("0");
        zeroBn.addActionListener(this::zeroBnActionPerformed);

        dotBn.setText(".");
        dotBn.addActionListener(this::dotBnActionPerformed);

        equalBn.setText("=");
        equalBn.addActionListener(this::equalBnActionPerformed);

        addBn.setText("+");
        addBn.addActionListener(this::addBnActionPerformed);

        historyLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(zeroBn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(oneBn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fourBn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sevenBn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mPlusBn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(sinBn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cosBn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mrBn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(eightBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fiveBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dotBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(twoBn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tanBn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(factBn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(nineBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sixBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(threeBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(equalBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(squareBn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(divideBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(multiBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(subBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(meanBn))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sqrtBn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumBn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(logBn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delBn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(clearBn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(addBn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(disTF, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(historyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(historyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(disTF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sinBn)
                    .addComponent(cosBn)
                    .addComponent(tanBn)
                    .addComponent(squareBn)
                    .addComponent(sqrtBn)
                    .addComponent(logBn)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mPlusBn)
                    .addComponent(mrBn)
                    .addComponent(factBn)
                    .addComponent(meanBn)
                    .addComponent(sumBn)
                    .addComponent(delBn)
                    .addComponent(clearBn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sevenBn)
                    .addComponent(eightBn)
                    .addComponent(nineBn)
                    .addComponent(divideBn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fourBn)
                    .addComponent(fiveBn)
                    .addComponent(sixBn)
                    .addComponent(multiBn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oneBn)
                    .addComponent(twoBn)
                    .addComponent(threeBn)
                    .addComponent(subBn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zeroBn)
                    .addComponent(dotBn)
                    .addComponent(equalBn)
                    .addComponent(addBn))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    private void mrBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrBnActionPerformed
      disTF.setText(Double.toString(memory));
    }//GEN-LAST:event_mrBnActionPerformed

    private void sumBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumBnActionPerformed
       double total = 0.0;
   for (double num : statData) {
    total += num;
}
disTF.setText(Double.toString(total));
    }//GEN-LAST:event_sumBnActionPerformed

    private void fiveBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveBnActionPerformed
     disTF.setText(disTF.getText() + "5");
    }//GEN-LAST:event_fiveBnActionPerformed

    private void subBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subBnActionPerformed
     val = Double.parseDouble(disTF.getText());
     calc = 2;
      historyLabel.setText(disTF.getText());
     disTF.setText("");
    }//GEN-LAST:event_subBnActionPerformed

    private void twoBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoBnActionPerformed
    disTF.setText(disTF.getText() + "2");
    }//GEN-LAST:event_twoBnActionPerformed

    private void zeroBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroBnActionPerformed
       disTF.setText(disTF.getText() + "0");
    }//GEN-LAST:event_zeroBnActionPerformed

    private void oneBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneBnActionPerformed
    disTF.setText(disTF.getText() + "1");
    }//GEN-LAST:event_oneBnActionPerformed

    private void threeBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeBnActionPerformed
      disTF.setText(disTF.getText() + "3");
    }//GEN-LAST:event_threeBnActionPerformed

    private void fourBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourBnActionPerformed
         disTF.setText(disTF.getText() + "4");
    }//GEN-LAST:event_fourBnActionPerformed

    private void sixBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sixBnActionPerformed
         disTF.setText(disTF.getText() + "6");
    }//GEN-LAST:event_sixBnActionPerformed

    private void nineBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nineBnActionPerformed
   disTF.setText(disTF.getText() + "9");    }//GEN-LAST:event_nineBnActionPerformed

    private void eightBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightBnActionPerformed
        disTF.setText(disTF.getText() + "8");
    }//GEN-LAST:event_eightBnActionPerformed

    private void sevenBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sevenBnActionPerformed
        disTF.setText(disTF.getText() + "7");
    }//GEN-LAST:event_sevenBnActionPerformed

    private void dotBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dotBnActionPerformed
        disTF.setText(disTF.getText() + ".");
    }//GEN-LAST:event_dotBnActionPerformed

    private void clearBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBnActionPerformed
    disTF.setText("");
     historyLabel.setText(disTF.getText());
    }//GEN-LAST:event_clearBnActionPerformed

    private void delBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBnActionPerformed
   int length = disTF.getText().length();
   int num = length - 1;
   String store;
   
   if(length>0){
   StringBuilder backspace = new StringBuilder(disTF.getText());
   backspace.deleteCharAt(num);
   store = backspace.toString();
   disTF.setText(store);
   }
    }//GEN-LAST:event_delBnActionPerformed

private void equalBnActionPerformed(java.awt.event.ActionEvent evt) {                                        
    String secondStr = disTF.getText();
    String opSymbol = "";
    switch(calc) {
        case 1: opSymbol = " + "; break;
        case 2: opSymbol = " - "; break;
        case 3: opSymbol = " Ã— "; break;
        case 4: opSymbol = " Ã· "; break;
        case 5: opSymbol = " ^ "; break;
    }
    historyLabel.setText(val + opSymbol + secondStr + " =");
    arithmetic_op();
}
    private void addBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBnActionPerformed
        val = Double.parseDouble(disTF.getText());
        calc = 1;
        historyLabel.setText(disTF.getText());
        disTF.setText("");
    }//GEN-LAST:event_addBnActionPerformed

    private void multiBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiBnActionPerformed
    val = Double.parseDouble(disTF.getText());
        calc = 3;
        historyLabel.setText(disTF.getText());
        disTF.setText("");
    }//GEN-LAST:event_multiBnActionPerformed

    private void divideBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_divideBnActionPerformed
  val = Double.parseDouble(disTF.getText());
        calc = 4;
         historyLabel.setText(disTF.getText());
        disTF.setText("");
    }//GEN-LAST:event_divideBnActionPerformed

    private void squareBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareBnActionPerformed
     val = Double.parseDouble(disTF.getText());
     ans = Math.pow(val, 2);
    disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_squareBnActionPerformed

    private void sinBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinBnActionPerformed
       val = Double.parseDouble(disTF.getText());
       ans = Math.sin(Math.toRadians(val));
       disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_sinBnActionPerformed

    private void cosBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cosBnActionPerformed
       val = Double.parseDouble(disTF.getText());
       ans = Math.cos(Math.toRadians(val));
       disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_cosBnActionPerformed

    private void tanBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanBnActionPerformed
        val = Double.parseDouble(disTF.getText());
       ans = Math.tan(Math.toRadians(val));
       disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_tanBnActionPerformed

    private void sqrtBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqrtBnActionPerformed
       val = Double.parseDouble(disTF.getText());
       if(val<0){
       disTF.setText("ERROR");
       }else{
      ans = Math.sqrt(val);
      disTF.setText(Double.toString(ans));
       }
    }//GEN-LAST:event_sqrtBnActionPerformed

    private void logBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logBnActionPerformed
       val = Double.parseDouble(disTF.getText());
   ans = Math.log10(val);
    disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_logBnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    val = Double.parseDouble(disTF.getText());
   ans = Math.log(val);
   disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void factBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_factBnActionPerformed
      val = Double.parseDouble(disTF.getText());
  ans = calculateFactorial((int) val);
   disTF.setText(Double.toString(ans));
    }//GEN-LAST:event_factBnActionPerformed

    private void mPlusBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPlusBnActionPerformed
     double entry = Double.parseDouble(disTF.getText());
     statData.add(entry);
     memory += entry;
     javax.swing.JOptionPane.showMessageDialog(this, "Entry " + entry + "saved! (Total entries: " + statData.size() + ") ");
    }//GEN-LAST:event_mPlusBnActionPerformed

    private void meanBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meanBnActionPerformed
if (statData.isEmpty()) {
    disTF.setText("No Data");
} else {
    double total = 0.0;
    for (double num : statData) {
        total += num;
    }
    ans = total / statData.size();
    disTF.setText(Double.toString(ans));
}
    }//GEN-LAST:event_meanBnActionPerformed


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new PROJECT1().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBn;
    private javax.swing.JButton clearBn;
    private javax.swing.JButton cosBn;
    private javax.swing.JButton delBn;
    private javax.swing.JTextField disTF;
    private javax.swing.JButton divideBn;
    private javax.swing.JButton dotBn;
    private javax.swing.JButton eightBn;
    private javax.swing.JButton equalBn;
    private javax.swing.JButton factBn;
    private javax.swing.JButton fiveBn;
    private javax.swing.JButton fourBn;
    private javax.swing.JLabel historyLabel;
    private javax.swing.JButton jButton7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton logBn;
    private javax.swing.JButton mPlusBn;
    private javax.swing.JButton meanBn;
    private javax.swing.JButton mrBn;
    private javax.swing.JButton multiBn;
    private javax.swing.JButton nineBn;
    private javax.swing.JButton oneBn;
    private javax.swing.JButton sevenBn;
    private javax.swing.JButton sinBn;
    private javax.swing.JButton sixBn;
    private javax.swing.JButton sqrtBn;
    private javax.swing.JButton squareBn;
    private javax.swing.JButton subBn;
    private javax.swing.JButton sumBn;
    private javax.swing.JButton tanBn;
    private javax.swing.JButton threeBn;
    private javax.swing.JButton twoBn;
    private javax.swing.JButton zeroBn;
    // End of variables declaration//GEN-END:variables
}
