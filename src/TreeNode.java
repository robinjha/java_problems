
public class TreeNode {
	int data;
	TreeNode parent;
	TreeNode leftChild;
	TreeNode rightChild;
	
	public TreeNode(int data){
		this.data = data;
		parent = leftChild = rightChild = null;
	}
	
	public void setLeft(TreeNode node){
		leftChild = node;
	}
	
	public void setRight(TreeNode node){
		rightChild = node;
	}
	
	public TreeNode getLeft(){
		return leftChild;
	}
	
	public TreeNode getRight(){
		return rightChild;
	}
	
	public int getData(){
		return data;
	}
	
	public TreeNode getParent(){
		return parent;
	}
	
	public void setParent(TreeNode node){
		parent = node;
	}
	
	/*
	 * takes in a node to be inserted
	 */
	public void insert(TreeNode node){
		if(node.leftChild.data > node.data){
			if(node.leftChild != null){
				setLeft(node);
			}
		}
		else{
			if(node.rightChild != null){
				
			}
			setRight(node);
		}
	}

}
