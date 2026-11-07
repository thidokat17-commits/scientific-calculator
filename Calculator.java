
   /**
    * Scientific Calculator - SDN150S Software Design 1
    * @author Thato Kgomo 261180355
    * Onelizo Zamagquma Bandezi 241321573
    * Sinesipho Chulumanco Mkundlu 240590759
    * Zubenathi Mafilika 241312817
    */





public class Calculator extends javax.swing.JFrame {
    
   
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Calculator.class.getName());

    public Calculator() {
        initComponents();    
            loadSavedFromFile();
    }
 java.util.ArrayList<String> savedEquations = new java.util.ArrayList<>();
    static final String SAVE_FILE = "saved_equations.txt";

    boolean degreesMode = false;
    boolean  calculatorOn =true ;
 static final double PI = Math.PI;
    

   
String text;   // the sum we are reading, e.g. "sin(30)+2"
int pos;       // which letter we are looking at right now

java.util.HashMap<String, Integer> useCount = new java.util.HashMap<>();

int getCount(String eq) {
    return useCount.getOrDefault(eq, 0);
}


 public double angleBack(double x) {
    if (degreesMode) {
        return Math.toDegrees(x);
    } else {
        return x;
    }
}


// Start here: give it a sum, it gives back the answer
 public double evaluate(String sum) {
    text = sum.replace(" ", "");
    pos = 0;
    double result = readPlusMinus();
    if (pos < text.length()) {
        throw new RuntimeException("Bad input");
    }
    return result;
}

// Job 1: handle + and - (these happen LAST)
 public double readPlusMinus() {
    double result = readTimesDivide();
    while (pos < text.length()) {
        char c = text.charAt(pos);
        if (c == '+') {
            pos++;
            result = result + readTimesDivide();
        } else if (c == '-') {
            pos++;
            result = result - readTimesDivide();
        } else {
            break;
        }
    }
    return result;
}

// Job 2: handle * and / (these happen before + and -)
 public double readTimesDivide() {
    double result = readPower();
    while (pos < text.length()) {
        char c = text.charAt(pos);
        if (c == '*') {
            pos++;
            result = result * readPower();
        } else if (c == '/') {
            pos++;
            result = result / readPower();
        } else {
            break;
        }
    }
    return result;
}

// Job 3: handle ^ (power)
 public double readPower() {
    double result = readAfterNumber();
    if (pos < text.length() && text.charAt(pos) == '^') {
        pos++;
        result = Math.pow(result, readPower());
    }
    return result;
}

// Job 4: handle ! and % that sit AFTER a number
 public double readAfterNumber() {
    double result = readBasic();
    while (pos < text.length()) {
        char c = text.charAt(pos);
        if (c == '!') {
            pos++;
            result = factorial(result);
        } else if (c == '%') {
            pos++;
            result = result / 100;
        } else {
            break;
        }
    }
    return result;
}

// Job 5: the smallest pieces: numbers, brackets, pi, e, sin, cos...
 public double readBasic() {
    if (pos >= text.length()) {
        throw new RuntimeException("Incomplete");
    }
    char c = text.charAt(pos);

    // a minus sign in front, like -5
    if (c == '-') {
        pos++;
        return -readBasic();
    }

    // brackets: work out what is inside them
    if (c == '(') {
        pos++;
        double result = readPlusMinus();
        if (pos < text.length() && text.charAt(pos) == ')') {
            pos++;   // skip the closing bracket
        }
        return result;
    }

    // a number like 12 or 3.5
    if (Character.isDigit(c) || c == '.') {
        int start = pos;
        while (pos < text.length()
                && (Character.isDigit(text.charAt(pos)) || text.charAt(pos) == '.')) {
            pos++;
        }
        return Double.parseDouble(text.substring(start, pos));
    }

    // a word like sin, cos, pi, e ...
    if (Character.isLetter(c)) {
        int start = pos;
        while (pos < text.length() && Character.isLetter(text.charAt(pos))) {
            pos++;
        }
        String word = text.substring(start, pos);

       if (word.equals("pi")) {
    return PI;
}
        if (word.equals("e")) {
            return Math.E;
        }

        // for sin, cos, etc. read the bracket that comes next
        double x = readBasic();

        switch (word) {
            case "sin":  return Math.sin(angle(x));
            case "cos":  return Math.cos(angle(x));
            case "tan":  return Math.tan(angle(x));
            case "log":  return Math.log10(x);
            case "ln":   return Math.log(x);
            case "sqrt": return Math.sqrt(x);
            case "arcsin": return angleBack(Math.asin(x));
    case "arccos": return angleBack(Math.acos(x));
    case "arctan": return angleBack(Math.atan(x));
            default:     throw new RuntimeException("Unknown word");
        }
    }

    throw new RuntimeException("Bad input");
}

// Degrees or radians? Java's sin/cos/tan only understand radians,
// so if DEG is chosen we convert first.
 public double angle(double x) {
    if (degreesMode) {
        return Math.toRadians(x);
    } else {
        return x;
    }
}

// 5! = 5*4*3*2*1
  public double factorial(double n) {
    if (n < 0 || n != Math.floor(n)) {
        throw new RuntimeException("Bad factorial");
    }
    double f = 1;
    for (int i = 2; i <= n; i++) {
        f = f * i;
    }
    return f;
}

// ====== ON / OFF: one method for all the buttons ======
public void setButtonsEnabled(boolean on) {
    javax.swing.JButton[] all = {AC, DEL, SIN, COS, TAN, LOG, ln, SQRT, E, pi,
        FACTORIAL, PERCENTAGE, Power, Add, subtractor, multiply, devide,
        lBracket, rBracket, dot, zero, one, two, three, four, five, six,
        seven, eight, nine, jButton28,jButton5,jButton2,jButton1,jButton3};
    for (javax.swing.JButton b : all) {
        b.setEnabled(on);
    }
}
    
    
    // Read saved equations from the text file into the list
 private  void loadSavedFromFile() {
    savedEquations.clear();
    useCount.clear();
    java.io.File f = new java.io.File(SAVE_FILE);
    if (!f.exists()) {
        return;
    }
    try (java.util.Scanner in = new java.util.Scanner(f)) {
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            int bar = line.lastIndexOf('|');
            if (bar == -1) {
                savedEquations.add(line);
            } else {
                String eq = line.substring(0, bar);
                int n = Integer.parseInt(line.substring(bar + 1));
                savedEquations.add(eq);
                useCount.put(eq, n);
            }
        }
    } catch (java.io.IOException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Could not read saved equations.");
    }
}
 private void writeSavedToFile() {
    try (java.io.PrintWriter out = new java.io.PrintWriter(SAVE_FILE)) {
        for (String eq : savedEquations) {
            out.println(eq + "|" + getCount(eq));
        }
    } catch (java.io.IOException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "Could not save equations.");
    }
}
  private void saveCurrent() {
    String eq = jText.getText().trim();
    if (eq.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Type an equation first.");
    } else if (savedEquations.contains(eq)) {
        javax.swing.JOptionPane.showMessageDialog(this, "That equation is already saved.");
    } else {
        savedEquations.add(eq);
        writeSavedToFile();
        javax.swing.JOptionPane.showMessageDialog(this, "Saved: " + eq);
    }
}

 private  void useSaved() {
    if (savedEquations.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "No saved equations yet.");
        return;
    }
    java.util.ArrayList<String> sorted = new java.util.ArrayList<>(savedEquations);
    sorted.sort((a, b) -> getCount(b) - getCount(a));   // biggest count first

    String chosen = (String) javax.swing.JOptionPane.showInputDialog(this,
            "Pick an equation (most used first):", "Saved Equations",
            javax.swing.JOptionPane.QUESTION_MESSAGE, null,
            sorted.toArray(), sorted.get(0));
    if (chosen != null) {
        jText.setText(chosen);
    }
}

 public void deleteSaved() {
    if (savedEquations.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "No saved equations yet.");
        return;
    }
    String chosen = (String) javax.swing.JOptionPane.showInputDialog(this,
            "Delete which equation?", "Delete Saved",
            javax.swing.JOptionPane.QUESTION_MESSAGE, null,
            savedEquations.toArray(), savedEquations.get(0));
   if (chosen != null) {
    savedEquations.remove(chosen);
    useCount.remove(chosen);
    writeSavedToFile();
}
}
    
    
   
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        AC = new javax.swing.JButton();
        DEL = new javax.swing.JButton();
        SIN = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        COS = new javax.swing.JButton();
        TAN = new javax.swing.JButton();
        LOG = new javax.swing.JButton();
        E = new javax.swing.JButton();
        FACTORIAL = new javax.swing.JButton();
        PERCENTAGE = new javax.swing.JButton();
        Power = new javax.swing.JButton();
        Add = new javax.swing.JButton();
        lBracket = new javax.swing.JButton();
        rBracket = new javax.swing.JButton();
        nine = new javax.swing.JButton();
        six = new javax.swing.JButton();
        seven = new javax.swing.JButton();
        devide = new javax.swing.JButton();
        eight = new javax.swing.JButton();
        two = new javax.swing.JButton();
        three = new javax.swing.JButton();
        four = new javax.swing.JButton();
        five = new javax.swing.JButton();
        multiply = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        one = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        dot = new javax.swing.JButton();
        subtractor = new javax.swing.JButton();
        zero = new javax.swing.JButton();
        ln = new javax.swing.JButton();
        SQRT = new javax.swing.JButton();
        pi = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        RAD = new javax.swing.JRadioButton();
        DEG = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton32 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jText2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jText.setEditable(false);
        jText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel3.add(jText, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 51, 287, 55));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAlignmentX(0.1F);
        jSeparator1.setAlignmentY(0.1F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 42, 287, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Scientific  Calculator ");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 8, 287, 28));

        AC.setBackground(new java.awt.Color(255, 153, 0));
        AC.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AC.setText("AC");
        AC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AC.addActionListener(this::ACActionPerformed);
        jPanel3.add(AC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 151, 47, -1));

        DEL.setBackground(new java.awt.Color(255, 153, 0));
        DEL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DEL.setText("DEL");
        DEL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DEL.addActionListener(this::DELActionPerformed);
        jPanel3.add(DEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 151, 49, -1));

        SIN.setBackground(new java.awt.Color(0, 0, 0));
        SIN.setForeground(new java.awt.Color(255, 255, 255));
        SIN.setText("sin");
        SIN.addActionListener(this::SINActionPerformed);
        jPanel3.add(SIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 149, 56, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setAlignmentX(0.1F);
        jSeparator2.setAlignmentY(0.1F);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 122, -1, 267));

        COS.setBackground(new java.awt.Color(0, 0, 0));
        COS.setForeground(new java.awt.Color(255, 255, 255));
        COS.setText("cos");
        COS.addActionListener(this::COSActionPerformed);
        jPanel3.add(COS, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 149, 65, -1));

        TAN.setBackground(new java.awt.Color(0, 0, 0));
        TAN.setForeground(new java.awt.Color(255, 255, 255));
        TAN.setText("tan");
        TAN.addActionListener(this::TANActionPerformed);
        jPanel3.add(TAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 149, 60, -1));

        LOG.setBackground(new java.awt.Color(51, 51, 51));
        LOG.setForeground(new java.awt.Color(255, 255, 255));
        LOG.setText("log");
        LOG.addActionListener(this::LOGActionPerformed);
        jPanel3.add(LOG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 182, 58, -1));

        E.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        E.setText("e");
        E.addActionListener(this::EActionPerformed);
        jPanel3.add(E, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 62, -1));

        FACTORIAL.setText("x!");
        FACTORIAL.addActionListener(this::FACTORIALActionPerformed);
        jPanel3.add(FACTORIAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 182, 54, -1));

        PERCENTAGE.setText("%");
        PERCENTAGE.addActionListener(this::PERCENTAGEActionPerformed);
        jPanel3.add(PERCENTAGE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 47, -1));

        Power.setText("x^y");
        Power.addActionListener(this::PowerActionPerformed);
        jPanel3.add(Power, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 55, -1));

        Add.setText("+");
        Add.addActionListener(this::AddActionPerformed);
        jPanel3.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 72, -1));

        lBracket.setText("(");
        lBracket.addActionListener(this::lBracketActionPerformed);
        jPanel3.add(lBracket, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 40, -1));

        rBracket.setText(")");
        rBracket.addActionListener(this::rBracketActionPerformed);
        jPanel3.add(rBracket, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 41, -1));

        nine.setText("9");
        nine.addActionListener(this::nineActionPerformed);
        jPanel3.add(nine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 41, -1));

        six.setText("6");
        six.addActionListener(this::sixActionPerformed);
        jPanel3.add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 41, -1));

        seven.setText("7");
        seven.addActionListener(this::sevenActionPerformed);
        jPanel3.add(seven, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 41, -1));

        devide.setText("/");
        devide.addActionListener(this::devideActionPerformed);
        jPanel3.add(devide, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 48, -1));

        eight.setText("8");
        eight.addActionListener(this::eightActionPerformed);
        jPanel3.add(eight, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 40, -1));

        two.setText("2");
        two.addActionListener(this::twoActionPerformed);
        jPanel3.add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 41, -1));

        three.setText("3");
        three.addActionListener(this::threeActionPerformed);
        jPanel3.add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 41, -1));

        four.setText("4");
        four.addActionListener(this::fourActionPerformed);
        jPanel3.add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 40, -1));

        five.setText("5");
        five.addActionListener(this::fiveActionPerformed);
        jPanel3.add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 41, -1));

        multiply.setText("*");
        multiply.addActionListener(this::multiplyActionPerformed);
        jPanel3.add(multiply, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 48, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setAlignmentX(0.1F);
        jSeparator3.setAlignmentY(0.1F);
        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 112, 287, 4));

        one.setText("1");
        one.addActionListener(this::oneActionPerformed);
        jPanel3.add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 41, -1));

        jButton28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton28.setText("=");
        jButton28.addActionListener(this::jButton28ActionPerformed);
        jPanel3.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 310, -1));

        dot.setText(".");
        dot.addActionListener(this::dotActionPerformed);
        jPanel3.add(dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 41, -1));

        subtractor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        subtractor.setText("-");
        subtractor.addActionListener(this::subtractorActionPerformed);
        jPanel3.add(subtractor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 48, -1));

        zero.setText("0");
        zero.addActionListener(this::zeroActionPerformed);
        jPanel3.add(zero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 40, -1));

        ln.setBackground(new java.awt.Color(0, 0, 0));
        ln.setForeground(new java.awt.Color(255, 255, 255));
        ln.setText("ln");
        ln.addActionListener(this::lnActionPerformed);
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 48, 97));

        SQRT.setText("sqrt");
        SQRT.addActionListener(this::SQRTActionPerformed);
        jPanel3.add(SQRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 182, 110, -1));

        pi.setText("pi");
        pi.addActionListener(this::piActionPerformed);
        jPanel3.add(pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 44, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("ON");
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 122, 47, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("OFF");
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 122, 54, -1));

        RAD.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(RAD);
        RAD.setForeground(new java.awt.Color(255, 255, 255));
        RAD.setSelected(true);
        RAD.setText("RAD");
        RAD.addActionListener(this::RADActionPerformed);
        jPanel3.add(RAD, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 122, 56, -1));

        DEG.setBackground(new java.awt.Color(0, 0, 0));
        buttonGroup2.add(DEG);
        DEG.setForeground(new java.awt.Color(255, 255, 255));
        DEG.setText("DEG");
        DEG.addActionListener(this::DEGActionPerformed);
        jPanel3.add(DEG, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 122, 64, -1));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("arcsin");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, 20));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 153, 0));
        jButton2.setText("arccos");
        jButton2.addActionListener(this::jButton2ActionPerformed);
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 120, 20));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 153, 0));
        jButton3.setText("arctan");
        jButton3.addActionListener(this::jButton3ActionPerformed);
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 80, 20));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 204, 204));
        jButton5.setText("STATISTICS");
        jButton5.addActionListener(this::jButton5ActionPerformed);
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 231, 310, 30));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        jLabel2.setText("History ");

        jSeparator4.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jButton32.setBackground(new java.awt.Color(0, 0, 0));
        jButton32.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Clear");
        jButton32.addActionListener(this::jButton32ActionPerformed);

        jButton41.setBackground(new java.awt.Color(0, 0, 0));
        jButton41.setForeground(new java.awt.Color(255, 255, 255));
        jButton41.setText("UNIT CONVERTOR ");
        jButton41.addActionListener(this::jButton41ActionPerformed);

        jButton42.setText("Recall");
        jButton42.addActionListener(this::jButton42ActionPerformed);

        jButton43.setBackground(new java.awt.Color(0, 0, 0));
        jButton43.setForeground(new java.awt.Color(255, 255, 255));
        jButton43.setText("Save Caluculation");
        jButton43.addActionListener(this::jButton43ActionPerformed);

        jText2.setEditable(false);
        jText2.setColumns(20);
        jText2.setRows(5);
        jScrollPane3.setViewportView(jText2);

        jButton4.setText("Delete saved");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton32)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void ACActionPerformed(java.awt.event.ActionEvent evt) {                                   
 
        jText.setText("");
        
    }                                  

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {                                          
 String sum = jText.getText();           // what the user typed

    try {
        double answer = evaluate(sum);      // work it out

        if (Double.isNaN(answer) || Double.isInfinite(answer)) {
            jText.setText("Error");         // e.g. dividing by zero
            return;
        }

        // tidy tiny errors: sin(180) gives 0.0000000000000001, we want 0
        answer = Math.rint(answer * 1e10) / 1e10;

        String shown;
        if (answer == Math.floor(answer) && Math.abs(answer) < 1e15) {
            shown = String.valueOf((long) answer);
        } else {
            shown = String.valueOf(answer);
        }

        jText2.append(sum + " = " + shown + "\n");   // add to History
        jText.setText(shown);                            // show the answer

    } catch (Exception ex) {
        jText.setText("Error");
    }        
        
      if (savedEquations.contains(sum)) {
    useCount.put(sum, getCount(sum) + 1);
    writeSavedToFile();
}  

        
        
    }                                         

    private void zeroActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        jText.setText(jText.getText()+"0");
    }                                    

    private void oneActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        jText.setText(jText.getText()+"1");
    }                                   

    private void twoActionPerformed(java.awt.event.ActionEvent evt) {                                    

        // TODO add your handling code here:
        jText.setText(jText.getText()+"2");
    }                                   

    private void threeActionPerformed(java.awt.event.ActionEvent evt) {                                      

        jText.setText(jText.getText()+"3");
    }                                     

    private void fourActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        jText.setText(jText.getText()+"4");
    }                                    

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        
        jText.setText(jText.getText()+"5");
    }                                    

    private void sixActionPerformed(java.awt.event.ActionEvent evt) {                                    

        jText.setText(jText.getText()+"6");
        
    }                                   

    private void sevenActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        jText.setText(jText.getText()+"7");
    }                                     

    private void eightActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        jText.setText(jText.getText()+"8");
    }                                     

    private void nineActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        jText.setText(jText.getText()+"9");
    }                                    

    private void dotActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        jText.setText(jText.getText()+".");
    }                                   

    private void DELActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        // adds zero to any other text on the display screen
String backSpace =null;
if (jText.getText().length()>0){
    StringBuilder b = new StringBuilder(jText.getText());
    
    b.deleteCharAt(jText.getText().length()-1);
    backSpace = b.toString();
    jText.setText(backSpace);
}
        
    }                                   

    private void PERCENTAGEActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
         jText.setText(jText.getText()+"%");
        
    }                                          

    private void lBracketActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+"(");
    }                                        

    private void rBracketActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+")");
        
    }                                        

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
         jText.setText(jText.getText()+"ln(");
    }                                  

    private void subtractorActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
         jText.setText(jText.getText()+"-");
    }                                          

    private void multiplyActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+"*");
    }                                        

    private void devideActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
         jText.setText(jText.getText()+"/");
    }                                      

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        
         jText.setText(jText.getText()+"+");
         
    }                                   

    private void piActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
         jText.setText(jText.getText()+"pi");
    }                                  

    private void PowerActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
         jText.setText(jText.getText()+"^");
    }                                     

    private void SINActionPerformed(java.awt.event.ActionEvent evt) {                                    
         jText.setText(jText.getText()+"sin(");
    }                                   

    private void COSActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        jText.setText(jText.getText()+"cos(");
    }                                   

    private void TANActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        jText.setText(jText.getText()+"tan(");
        
    }                                   

    private void LOGActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        jText.setText(jText.getText()+"log(");
    }                                   

    private void SQRTActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        jText.setText(jText.getText()+"sqrt(");
        
    }                                    

    private void FACTORIALActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        jText.setText(jText.getText()+"!");
    }                                         

    private void RADActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
   degreesMode = false;
  
    }                                   

    private void DEGActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
        degreesMode = true; 
    
    }                                   

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        calculatorOn=true;
       
        setButtonsEnabled(true);
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        calculatorOn=false;
        jText.setText("");
    setButtonsEnabled(false);
    }                                             

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+"arcsin(");
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+"arctan(");
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jText.setText(jText.getText()+"arccos(");
    }                                        

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
        saveCurrent();
        
        
    }                                         

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        
         useSaved();
    }                                         

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         deleteSaved();
        // TODO add your handling code here:
    }                                        

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {                                          
       jText2.setText("");
    savedEquations.clear();
    useCount.clear();
    writeSavedToFile(); 
    }                                         

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {                                          
      convertor page = new convertor();
this.setVisible(false);
page.setVisible(true);
dispose();
        
        
    }                                         

    private void EActionPerformed(java.awt.event.ActionEvent evt) {                                  
        // TODO add your handling code here:
        jText.setText(jText.getText() + "e");
        
    }                                 

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         Statistics page = new Statistics();
this.setVisible(false);
page.setVisible(true);
dispose();
        
    }                                        

    
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> new Calculator().setVisible(true));
    }

    // Variables declaration - do not modify                     
    javax.swing.JButton AC;
    javax.swing.JButton Add;
    javax.swing.JButton COS;
    javax.swing.JRadioButton DEG;
    javax.swing.JButton DEL;
    javax.swing.JButton E;
    javax.swing.JButton FACTORIAL;
    javax.swing.JButton LOG;
    javax.swing.JButton PERCENTAGE;
    javax.swing.JButton Power;
    javax.swing.JRadioButton RAD;
    javax.swing.JButton SIN;
    javax.swing.JButton SQRT;
    javax.swing.JButton TAN;
    javax.swing.ButtonGroup buttonGroup1;
    javax.swing.ButtonGroup buttonGroup2;
    javax.swing.ButtonGroup buttonGroup3;
    javax.swing.ButtonGroup buttonGroup4;
    javax.swing.JButton devide;
    javax.swing.JButton dot;
    javax.swing.JButton eight;
    javax.swing.JButton five;
    javax.swing.JButton four;
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton28;
    javax.swing.JButton jButton3;
    javax.swing.JButton jButton32;
    javax.swing.JButton jButton4;
    javax.swing.JButton jButton41;
    javax.swing.JButton jButton42;
    javax.swing.JButton jButton43;
    javax.swing.JButton jButton5;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JPanel jPanel4;
    javax.swing.JPanel jPanel5;
    javax.swing.JRadioButton jRadioButton1;
    javax.swing.JRadioButton jRadioButton2;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JSeparator jSeparator2;
    javax.swing.JSeparator jSeparator3;
    javax.swing.JSeparator jSeparator4;
    javax.swing.JTextField jText;
    javax.swing.JTextArea jText2;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JTextArea jTextArea2;
    javax.swing.JButton lBracket;
    javax.swing.JButton ln;
    javax.swing.JButton multiply;
    javax.swing.JButton nine;
    javax.swing.JButton one;
    javax.swing.JButton pi;
    javax.swing.JButton rBracket;
    javax.swing.JButton seven;
    javax.swing.JButton six;
    javax.swing.JButton subtractor;
    javax.swing.JButton three;
    javax.swing.JButton two;
    javax.swing.JButton zero;
    // End of variables declaration                   
}
