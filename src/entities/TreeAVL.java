package entities;

import java.util.ArrayList;

public class TreeAVL {

	private AVLnode root;

	private ArrayList<AVLnode> nodes = new ArrayList<>();

	public TreeAVL() {


	}

	public TreeAVL(AVLnode root) {

		this.root = root;


	}

	public AVLnode inOrder(AVLnode root, AVLnode min) {

		if (root != null) {
			inOrder(root.getLeft(), min);
			if (root.getInfo() > min.getInfo()) {
				min = root;
			}
			min = inOrder(root.getRight(), min);
		}

		return min;
	}

	public void insertNode(Integer info) {

		if (root == null) {

			root = new AVLnode(info, null);

			return;

		}

		// Define se o numero ja foi inserido
		boolean insertStatus = false;

		// Nó anterior
		AVLnode previous = this.root;
		// Nó atual
		AVLnode current = this.root;

		// Enquanto o numero nao for inserido
		while (!insertStatus) {
			// Se o nó atual nao for nulo
			if (current != null) {

				// Salva o nó atual antes de mudar
				previous = current;

				// Se o numero inserido for MENOR que o do nó atual
				if (info < current.getInfo()) {
					current = current.getLeft(); // Vá para esquerda

					// Se o numero inserido for MAIOR que o do nó atual
				} else {
					current = current.getRight(); // Vá para direita
				}

			}

			// Se nó atual for nulo
			else {

				AVLnode insertNode = new AVLnode(info, previous);

				// Se o numero inserido for MENOR que o do nó raiz
				if (info < previous.getInfo()) {

					previous.setLeft(insertNode); // Insere na esquerda

					// Se o numero inserido for MAIOR que o do nó atual
				} else {

					previous.setRight(insertNode); // Insere na direita

				}

				nodes.add(insertNode);

				insertStatus = true; // Muda o status da inserção para true
			}
		}
	}
		
	public AVLnode searchNode(int info, AVLnode actualNode, int steps) {
		
		if(actualNode == null) {
			//System.out.println("AVLnode not exists!");
			return null;
		}
		
		//Verifica se a informação requisitada está no nó atual
		if(actualNode.getInfo() == info) {
			//Retorna total de passos feitos
			//System.out.println("Number find in: " + steps + " steps");
			return actualNode;
			
		} else {
			
			//Se a informação for menor vá para a esquerda e some 1 aos passos
			if(info < actualNode.getInfo()) {
				return searchNode(info, actualNode.getLeft(), steps+1);
				
			//Se a informação for maior vá para a direita e some 1 aos passos
			} else {
				return searchNode(info, actualNode.getRight(), steps+1);
			}
			
		}
		
	}
	
	//Essa função remove um dado de dentro da arvore binária
	public void removeNode(int info){
		
		//Achando nó para ser removido
		AVLnode nodeToRemove = searchNode(info, this.root, 0);
		
		if(nodeToRemove == null) return;
		
		//System.out.println("Removing: " + nodeToRemove.getInfo());
		
		//Achando nó pai do nó a ser removido
		AVLnode supper = nodeToRemove.getSupper();
		
		//Lado do nó filho referente ao nó pai
		String side = "LeftOrRight";
		
		nodes.remove(nodeToRemove);
		
		//Removendo nó da árvore
		if(nodeToRemove != root) {
			if(supper.getRight() == nodeToRemove) {
				//Definindo o lado referente ao nó pai
				side = "Right";
				
			} else if (supper.getLeft() == nodeToRemove) {
				//Definindo o lado referente ao nó pai
				side = "Left";
			}
		}
		
		//Se nao for a ponta da arvore
		if(nodeToRemove.getLeft() != null || nodeToRemove.getRight() != null) {
			
			AVLnode sub = null;
			
			//Se nó tem elemento somente na esquerda
			if(nodeToRemove.getLeft() != null && nodeToRemove.getRight() == null) {
				
				sub = nodeToRemove.getLeft();
				
			//Se nó tem elemento somente na direita
			} else if(nodeToRemove.getRight() != null && nodeToRemove.getLeft() == null) {
			
				sub = nodeToRemove.getRight();
				
			} else if(nodeToRemove.getRight() != null && nodeToRemove.getLeft() != null) {
				
				//Achando maior nó da subarvore a esquerda
				sub = inOrder(nodeToRemove.getLeft(), new AVLnode(-1, null));
				
				//Nó a esquerda
				AVLnode left = nodeToRemove.getLeft();
				
				//Nó a esquerda
				AVLnode right = nodeToRemove.getRight();
				
				if(left.getInfo() != sub.getInfo() || sub.getLeft() == null) {
					removeNode(sub.getInfo());
				}
						
				if(left != null && left.getInfo() != sub.getInfo()) {
					left.setSupper(sub);
					sub.setLeft(left);
				} 
				
				right.setSupper(sub);
				sub.setRight(right);
								
			}
			
			if(nodeToRemove == this.root) {
				root = sub;
			} 
			//Ligar a sub árvore a esquerda
			sub.setSupper(supper);
		

			//Ligar superior a sub arvore
			if(nodeToRemove != root) {
				switch(side) {
				
				case "Right":
					
					supper.setRight(sub);
					
					break;
				case "Left":
					
					supper.setLeft(sub);
					
					break;
				}
			}
			
		} else {
			
			if(nodeToRemove == root) {
				root = null;
			} else {
				switch(side) {
				
				case "Right":
					
					supper.setRight(null);
					
					break;
				case "Left":
					
					supper.setLeft(null);
					
					break;
				}
			}
		}	
	}
	
	public void checkBalance() {
		if(root != null) {
			root.calcBalance();
			root = root.checkBalance();
		}
	}
	
	public void printTree(AVLnode node) {
		if(node != null) {
			System.out.println("Node: " + node);
			System.out.println("  Right: " + node.getRight());
			System.out.println("  Left: " + node.getLeft());
			printTree(node.getRight());
			printTree(node.getLeft());
		}
	}
	
	public AVLnode getRoot() {
		return this.root;
	}
}
