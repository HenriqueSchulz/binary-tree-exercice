package entities;

public class Node {
	
	private Node right;
	private Node left;
	private Integer info;
	
	//Só usado na interface
	private Node supper;
	
	public Node(){}
	
	public Node(Integer info, Node supper) {
		this.info = info;
		this.right = null;
		this.left = null;
		this.supper = supper;
	}
	
	public Node getRight() {
		return right;
	}

	public Node getLeft() {
		return left;
	}

	public Integer getInfo() {
		return info;
	}
	
	public Node getSupper() {
		return supper;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
	
	public void setSupper(Node supper) {
		this.supper = supper;
	}
	
	public String toString() {
		return "->" + this.getInfo();
	}

	
}
