import java.util.ArrayList;

public class TreeNode<E> {

	private E value;
	private ArrayList<TreeNode<E>> children;
	
	public TreeNode(E value) {
		this.value = value;
		this.children = new ArrayList<TreeNode<E>>();
	}
	
	public E getValue() {
		return value;
	}
	
	public ArrayList<TreeNode<E>> getChildren() {
		return children;
	}
	
	public void setValue(E value) {
		this.value = value;
	}
	
	public void addChild(TreeNode<E> child) {
		children.add(child);
	}
	
	public void removeChild(TreeNode<E> child) {
		children.remove(child);
	}
	
}
