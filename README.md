# scientific-calculator
A scientific calculator built in Java Swing. It solves typed equations with the correct order of operations, handles trig, logs, powers and factorials, keeps a history, and lets you save and recall equations. It also has a unit convertor and a statistics window.

# Scientific Calculator (Java Swing)

Project 18 for Software Design 1 (SDN150S), Cape Peninsula University of Technology.

## How the System Works

The application is built with Java Swing. Its JFrame classes provide the three screens, and each one handles its own part of the work.

When the application starts, `Calculator.java` opens the main calculator window. From there, a user can type and solve equations, switch between degrees and radians, view the history, and save or recall equations. The user can also open the unit convertor or the statistics window and go back to the calculator at any time.

## Class Descriptions

- **`Calculator.java`** - Main window and entry point of the application. It reads the equation typed with the buttons and solves it using a recursive-descent parser, so the order of operations is correct. It supports +, -, *, /, powers, brackets, percentages, factorials, sin, cos, tan and their inverses, log, ln, sqrt, pi and e. It also has DEG/RAD mode, an ON/OFF switch, a History area, and Save, Recall and Delete for frequently used equations. Saved equations are stored in `saved_equations.txt` with a usage count, and the most used are shown first.
- **`convertor.java`** - Unit convertor window. It converts length (mm, m, km), time (ms, s, ks) and temperature (Celsius, Kelvin). It checks the input and rejects values below absolute zero.
- **`Statistics.java`** - Statistics window. It reads numbers separated by commas and shows the count, sum, mean, median, minimum, maximum and sample standard deviation.

## Application Flow

1. `Calculator.java` starts the program and opens the calculator window.
2. The user types an equation with the buttons and presses `=`. The answer is shown and added to the History.
3. The user can save the equation, recall a saved one, or delete one. Saved equations are read from the file again when the program starts.
4. The UNIT CONVERTOR button opens `convertor.java`. BACK returns to the calculator.
5. The STATISTICS button opens `Statistics.java`. Back returns to the calculator.

## How to Run

1. Open the project in NetBeans.
2. Run `Calculator.java`.

## Team and Contributions

| Area | Done by |
|------|---------|
| Calculator class | Thato Katlego (261180355)|
| convertor class | Sinesipho Chulumanco Mkundlu 240590759|
| Statistics class | Zubenathi Mafilika 241312817 |
| Technical report |Tshiamo Sepogwane  260097004 |
| Software design |  Onelizo Zamagquma Bandezi 241321573|
| UML diagram | Mvubu Londiwe 261365541 |
| Pseudocode | Mabogoane Tebatso 241199549 |
| Video demonstration |Vandala siyakha  260897392 |




