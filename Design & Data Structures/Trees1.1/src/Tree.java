
public class Tree<E> {

	private TreeNode<E> root;
	
	public Tree () {
		root = null;
	}
	
	public void printValues(TreeNode node) {
		if(node==null)
			return;
		System.out.println(node);
		for(int i = 0; i < node.getChildren().size(); i++) {
			printValues((TreeNode)node.getChildren().get(i));
		}
	}
	
	public void printSpecial(TreeNode node) {
		while(node.getChildren()!=null) {
			System.out.println(node);
			
		}
	}
	
	public int size(TreeNode node) {
		int tommyboy=0;
		if(node==null)
			return tommyboy;
		tommyboy++;
		for(int i = 0; i < node.getChildren().size(); i++) {
			tommyboy+=size((TreeNode)node.getChildren().get(i));
		}
		return tommyboy;
	}
	
}
