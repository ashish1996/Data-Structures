
public class AVLtree<K extends Comparable<? super K>, D> {
	public K element;
	public D data;
	public AVLtree<K, D> left;
	public AVLtree<K, D> right;
	public int height;
	public boolean deleteStatus;
	public AVLtree<K,D> root;
	
	
	public AVLtree(K k, D d, AVLtree<K, D> lt, AVLtree<K, D> rt) {
		this.element = k;
		this.data = d;
		this.left = lt;
		this.right = rt;
		this.height = 0;
		this.deleteStatus = false;
		if(left==null && right==null) {
			height = 0;
		}
	}
	
	
	
	

}
