package entities;

import java.util.ArrayList;

import gui.Interface;

public class Tree {
	
	private Node root;
	
	private Interface graphInterface;
	private ArrayList<Node> nodes = new ArrayList<>();
	
	public Tree() {

		this.graphInterface = new Interface();

	}
	
	public Tree(Node root, int graph) {
		
		this.root = root;
		
		//Criando interface gráfica junto com o construtor da arvore binaria
		if(graph == 0) {
			this.graphInterface = new Interface(1);
		} else {	
			this.graphInterface = new Interface();
		}

	}
		
	public Node inOrder(Node root, Node min) {
		
		if(root != null) {
			inOrder(root.getLeft(), min);
			if(root.getInfo() > min.getInfo()) {
				min = root;
			}
			min = inOrder(root.getRight(), min);
		}
		
		return min;
	}
	
	public void insertNode(Integer info) {
		
		if(root == null) {
			
			root = new Node(info, null);
			
			graphInterface.addNode(root);
			nodes.add(root);
			
			return;
			
		}
		
		//Define se o numero ja foi inserido
		boolean insertStatus = false;
		
		//Nó anterior
		Node previous = this.root;
		//Nó atual
		Node current = this.root;
		
		//Enquanto o numero nao for inserido
		while(!insertStatus) {
			//Se o nó atual nao for nulo
			if(current != null) {
				
				//Salva o nó atual antes de mudar
				previous = current;
				
				//Se o numero inserido for MENOR que o do nó atual
				if(info < current.getInfo()) {
					current = current.getLeft(); //Vá para esquerda
					
				//Se o numero inserido for MAIOR que o do nó atual
				} else {
					current = current.getRight(); //Vá para direita
				}
				
			} 
			
			//Se nó atual for nulo
			else {
					
				Node insertNode = new Node(info, previous);
				
				//Se o numero inserido for MENOR que o do nó raiz
				if(info < previous.getInfo()) {					
					previous.setLeft(insertNode); //Insere na esquerda
					
				//Se o numero inserido for MAIOR que o do nó atual
				} else {
					previous.setRight(insertNode); //Insere na direita
					
				}
				
				//Inserindo no grafico
				this.graphInterface.addNode(insertNode);
				this.graphInterface.connectNode(previous, insertNode);
				nodes.add(insertNode);
				
				insertStatus = true; //Muda o status da inserção para true
			}
		}
	}
	
	//Essa função remove um dado de dentro da arvore binária
	public void removeNode(int info){
		
		//Achando nó para ser removido
		Node nodeToRemove = searchNode(info, this.root, 0);
		
		if(nodeToRemove == null) return;
		
		//System.out.println("Removing: " + nodeToRemove.getInfo());
		
		//Achando nó pai do nó a ser removido
		Node supper = nodeToRemove.getSupper();
		
		//Lado do nó filho referente ao nó pai
		String side = "LeftOrRight";
		
		
		//Removendo nó do gráfico
		graphInterface.removeNode(nodeToRemove);
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
			
			Node sub = null;
			
			//Se nó tem elemento somente na esquerda
			if(nodeToRemove.getLeft() != null && nodeToRemove.getRight() == null) {
				
				sub = nodeToRemove.getLeft();
				
			//Se nó tem elemento somente na direita
			} else if(nodeToRemove.getRight() != null && nodeToRemove.getLeft() == null) {
			
				sub = nodeToRemove.getRight();
				
			} else if(nodeToRemove.getRight() != null && nodeToRemove.getLeft() != null) {
				
				//Achando maior nó da subarvore a esquerda
				sub = inOrder(nodeToRemove.getLeft(), new Node(-1, null));
				
				//Nó a esquerda
				Node left = nodeToRemove.getLeft();
				
				//Nó a esquerda
				Node right = nodeToRemove.getRight();
				
				if(left.getInfo() != sub.getInfo() || sub.getLeft() == null) {
					removeNode(sub.getInfo());
					graphInterface.addNode(sub);
				}
						
				if(left != null && left.getInfo() != sub.getInfo()) {
					left.setSupper(sub);
					sub.setLeft(left);
					graphInterface.connectNode(sub, left);
				} 
				
				right.setSupper(sub);
				sub.setRight(right);
				graphInterface.connectNode(sub, right);
								
			}
			
			if(nodeToRemove == this.root) {
				root = sub;
			} else {
				//Ligar nós no gráfico
				graphInterface.connectNode(supper, sub);	
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
	
	//Essa função busca um dado dentro da arvore binária
	public Node searchNode(int info, Node actualNode, int steps) {
				
		if(actualNode == null) {
			//System.out.println("Node not exists!");
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
	
	public void getNodes() {
		
		for(Node node : nodes) {
			System.out.print(node + " --> " + node.getInfo() + "\n");
		}
		
	}
	
	public void printTree(Node node) {
		if(node != null) {
			System.out.println("Node: " + node);
			System.out.println("  Right: " + node.getRight());
			System.out.println("  Left: " + node.getLeft());
			printTree(node.getRight());
			printTree(node.getLeft());
		}
	}
	
	public Node getRoot() {
		
		return root;
		
	}
}
