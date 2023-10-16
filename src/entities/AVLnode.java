package entities;

public class AVLnode extends Node{
	
	private AVLnode right;
	private AVLnode left;
	private Integer info;
	private Integer balance;
	
	//Só usado na interface
	private AVLnode supper;
	
	public AVLnode(){}
	
	public AVLnode(Integer info, AVLnode supper) {
		this.info = info;
		this.right = null;
		this.left = null;
		this.supper = supper;
		this.balance = 0;
	}
	
	public Integer getHeight(AVLnode node) {
		
		if(node == null) {
			return -1;
		}
		
		int left = getHeight(node.getLeft());
		int right = getHeight(node.getRight());
		
		if(left > right) {
			return left + 1;
		}
		return right + 1;
		
	}
	
	public void calcBalance() {
		this.balance = getHeight(this.getLeft()) - getHeight(this.getRight());
	}
	
	public AVLnode checkBalance() {
		if(this.balance >= 2) {
			
			if(this.getLeft().getBalance() == -1) {
				
				return doubleRotateRight();
			} else {
				return simpleRotateRight();
			}
			
		}
		else if(this.balance <= -2) {
			if(this.getRight().getBalance() == 1) {
				return doubleRotateLeft();
			} else {
				return simpleRotateLeft();
			}
		}
		return this;
	}
	
	public AVLnode simpleRotateRight() {
		
		AVLnode newRoot = this.getLeft();
		AVLnode temp = newRoot.getRight();
		
		newRoot.setRight(this);
		this.setLeft(temp);
		
		newRoot.setSupper(this.supper);
		this.setSupper(newRoot);
		
		return newRoot;
		
	}
	
	public AVLnode doubleRotateRight() {
		this.setLeft(this.getLeft().simpleRotateLeft());
		return simpleRotateRight();
	}
	
	public AVLnode simpleRotateLeft() {
		
		AVLnode newRoot = this.getRight();
		AVLnode temp = newRoot.getLeft();
		
		newRoot.setLeft(this);
		this.setRight(temp);
		
		newRoot.setSupper(this.supper);
		this.setSupper(newRoot);
		
		return newRoot;
	}
	
	public AVLnode doubleRotateLeft() {
		this.setRight(this.getRight().simpleRotateRight());
		return this.simpleRotateLeft();
	}
	
	public Integer getBalance() {
		this.calcBalance();
		return balance;
	}
	
	public AVLnode getRight() {
		return right;
	}

	public AVLnode getLeft() {
		return left;
	}

	public Integer getInfo() {
		return info;
	}
	
	public AVLnode getSupper() {
		return supper;
	}

	public void setRight(AVLnode right) {
		this.right = right;
	}

	public void setLeft(AVLnode left) {
		this.left = left;
	}

	public void setInfo(Integer info) {
		this.info = info;
	}
	
	public void setSupper(AVLnode supper) {
		this.supper = supper;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "->" + this.getInfo();
	}
}
