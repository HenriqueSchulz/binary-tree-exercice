package gui;

import org.graphstream.graph.EdgeRejectedException;
import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.IdAlreadyInUseException;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.HierarchicalLayout;
import org.graphstream.ui.view.Viewer;

import entities.Node;

public class Interface {
	
	private Graph graph;
	
	public Interface(){
		//CSS dos gráficos
		String styleSheet =
	            "node {" +
	            "	text-alignment: right;" +
	            "	text-offset: 10px, 0px;" +
	            "   size: 5px, 5px;" +
	            "}" +
	            "node.marked {" +
	            "	fill-color: red;" +
	            "}";
		
		System.setProperty("org.graphstream.ui", "swing");
		
		
		//Instanciando grafico na criação de uma Interface
		graph = new SingleGraph("BinaryTree");
		
		//Criando Layout
		HierarchicalLayout layout = new HierarchicalLayout();
		
		//Estilização
		graph.setAttribute("ui.stylesheet", styleSheet);
		
		//Viewer com configurações do Layout
		
		graph.display();
		
	}
	
	public Interface(int disable) {
		//CSS dos gráficos
		String styleSheet =
	            "node {" +
	            "	text-alignment: right;" +
	            "	text-offset: 10px, 0px;" +
	            "   size: 5px, 5px;" +
	            "}" +
	            "node.marked {" +
	            "	fill-color: red;" +
	            "}";
		
		System.setProperty("org.graphstream.ui", "swing");
		
		
		//Instanciando grafico na criação de uma Interface
		graph = new SingleGraph("BinaryTree");
		
		//Criando Layout
		HierarchicalLayout layout = new HierarchicalLayout();
		
		//Estilização
		graph.setAttribute("ui.stylesheet", styleSheet);
		
		//Viewer com configurações do Layout
		
		//graph.display();
	}
	
	//Adiciona Node usando o GraphStream
	public void addNode(Node node) {
		
		
		//Passa valor de Node de int --> String
		String indexNode = String.valueOf(node);
		try {
			graph.addNode(indexNode);
			graph.getNode(indexNode).setAttribute("ui.label", String.valueOf(node.getInfo()));
		} catch (IdAlreadyInUseException e) {
			
		}
		
	}
	
	public void removeNode(Node node) {
		
		String indexNode = String.valueOf(node);
		
		String nodeToRemove = String.valueOf(graph.getNode(indexNode));
		
		try {	
			graph.removeNode(nodeToRemove);
		} catch(ElementNotFoundException e) {
			
		}
		
		//System.out.println("Removed");
		
	}
	
	//Conecta Nodes usando o GraphStream
	public void connectNode(Node sup, Node sub) {
		
		String indexSup = String.valueOf(sup);//Nó pai
		String indexSub = String.valueOf(sub);//Nó filho
		
		try {
			graph.addEdge(indexSup + indexSub, indexSup, indexSub);
		} catch (EdgeRejectedException e) {
			
		} catch (IdAlreadyInUseException e) {
			
		} catch (ElementNotFoundException e) {
			
		}
		
	}
	
	public void disconnetcNode(Node sup, Node sub) {
		
		String indexSup = String.valueOf(sup);//Nó pai
		String indexSub = String.valueOf(sub);//Nó filho
		
		graph.removeEdge(indexSup, indexSub);
		
	}

}
