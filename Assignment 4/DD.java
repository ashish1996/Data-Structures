//Dynamic Dictionary Interface.
public interface DD<K extends Comparable<? super K>, D>{
	public void insert(K k, D d);
	public D find(K k);
	public void remove(K k);
}