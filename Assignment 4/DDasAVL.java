public class DDasAVL<K extends Comparable<? super K>, D> implements DD<K,D>{
	
	AVLtree<K,D> root;
	private int size, deleteCount;
	
	public DDasAVL(){
		root = null;
		} //Constructor
	
	public void makeEmpty(){
		root = null;
		}
	
	public boolean isEmpty(){
		return root == null;
		}
	
	public void insert(K k, D d){
		root = insert(root, k, d);
		}
	
	public D find(K k){
		return find(root, k);
		}
	
	public void remove(K k){
		root = remove(root, k);
		}
	
	public int height(){
		return height(root);
		}// Not relevant to DD's -- used for comparing performance with AVL trees

	private AVLtree<K,D> insert(AVLtree<K,D> t, K k, D d){
		if(t == null) {
			return new AVLtree<>(k,d, null, null);
		}
		
		if(t.deleteStatus==true) {
			t.deleteStatus=false;
			
			size++;
			deleteCount--;
			return t;
		}
		int compareResult = k.compareTo(t.element);
		
		if(compareResult<0) {
			t.left = insert(t.left, k ,d );
		}else if(compareResult>0) {
			t.right = insert(t.right, k ,d);
		} else {
			;
		}
		return balance(t);
	} // Complete this
	
	private D find(AVLtree<K,D> t, K k){
		while(t!= null) {
			if(k.compareTo(t.element)<0) {
				t = t.left;
			} else if(k.compareTo(t.element)>0) {
				t = t.right;
			} else {
				if(t.deleteStatus==false){
				return t.data;
				}else {
				if(t.deleteStatus==true){
					break;
				}
				}
			}
		}
		
		return null;
	} // Complete this
	
	private AVLtree<K,D> findMin(AVLtree<K,D> t){
		if(t==null) {
			return t;
		}
		while(t.left !=null) {
			t=t.left;
		}
		return t;
		
		
	}//Complete this
	
	private AVLtree<K,D> remove(AVLtree<K,D> t, K k){
		if(t==null) {
			return null;
		}
		
		int compareResult = k.compareTo(t.element);
		
		if(compareResult<0) {
			t.left = remove(t.left, k);
		} else if(compareResult>0) {
			t.right = remove(t.right, k);
		} else if(!t.deleteStatus) {
			t.deleteStatus= true;
			size--;
			deleteCount++;
		}
		return t;
		
	} //Implement using LAZY DELETE!!

	private int height(AVLtree<K,D> t){ 
		return ( t == null)? -1 : t.height;
		}

	private AVLtree<K,D> balance(AVLtree<K,D> t){
		if (t == null) return t;
		if (height(t.left) - height(t.right) > 1)
			if (height(t.left.left) >= height(t.left.right))
				t = rotateLL(t);  //do an LL rotation
			else
				t = rotateLR(t);  //do an LR rotation
		else
			if (height(t.right) - height(t.left) > 1)
				if (height( t.right.right) >= height(t.right.left))
					t = rotateRR(t);  //do an RR rotation
				else
					t = rotateRL(t);  //do an RL rotation

		t.height = 1 + Math.max(height(t.left), height(t.right));
		return t;
	}
	
	private AVLtree<K,D> rotateLL(AVLtree<K,D> k2){
		AVLtree k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = Math.max(height(k2.left), height(k2.right))+1;
		k1.height = Math.max(height(k1.left), k2.height)+1;
		return k1;
	
	}  // Complete this
	
	private AVLtree<K,D> rotateLR(AVLtree<K,D> k2){
		k2.left = rotateRR(k2.left);
		return rotateLL(k2);
	} // Complete this
	
	private AVLtree<K,D> rotateRR(AVLtree<K,D> k2){
		AVLtree k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = Math.max( height( k1.right ), k2.height ) + 1;
        return k1;
	
	} // Complete this
	
	private AVLtree<K,D> rotateRL(AVLtree<K,D> k2){
		k2.right = rotateLL(k2.right);
		return rotateRR(k2);
	} // Complete this

	/*
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		DDasAVLprinter testerPrint = new DDasAVLprinter();
		DDasAVL tester = new DDasAVL();
		
		tester.insert(1, "My");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(1));
		
		tester.insert(4, "Name");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(3,  "Is");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(3));
		
		tester.insert(5,  "Ashish");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(5));
		
		tester.insert(8, "and");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(8));
		
		tester.insert(7, "I");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(7));
		
		tester.remove(4);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(4, "Name");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(34, "think");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(34));
		
		tester.insert(10, "this");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(10));
		
		tester.insert(9, "finally");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(9));
		
		tester.insert(12, "works");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(12));
		
		tester.insert(2, "yay");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(2));
		//removes
		tester.remove(1);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(1));
		
		tester.remove(4);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.remove(3);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(3));
		
		tester.remove(5);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(5));
		
		tester.remove(8);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(8));
		
		tester.remove(7);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(7));
		
		tester.remove(34);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(34));
		
		tester.remove(10);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(10));
		
		tester.remove(9);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(9));
		
		tester.remove(12);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(12));
		
		tester.remove(2);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(2));
		///insert again
		
		tester.insert(1, "My");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(1));
		
		tester.insert(4, "Name");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(3,  "Is");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(3));
		
		tester.insert(5,  "Ashish");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(5));
		
		tester.insert(8, "and");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(8));
		
		tester.insert(7, "I");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(7));
		
		tester.remove(4);
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(4, "Name");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(4));
		
		tester.insert(34, "think");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(34));
		
		tester.insert(10, "this");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(10));
		
		tester.insert(9, "finally");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(9));
		
		tester.insert(12, "works");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(12));
		
		tester.insert(2, "yay");
		testerPrint.printDiagram(tester.root);
		System.out.println(tester.find(2));
		
	}*/

	/*public AVLtree getRoot() {
		// TODO Auto-generated method stub
		return root;
	}*/

	/*public AVLtree getRoot() {
		// TODO Auto-generated method stub
		return root;
	}*/
	
	
	
}