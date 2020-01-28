
public class examPrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DDasAVLprinter testerPrint = new DDasAVLprinter();
		DDasAVL tester3 = new DDasAVL();
		
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);
		tester3.insert(1, 1);

		testerPrint.printDiagram(tester3.root);
		
		
	}

}
