package program;

import java.util.Random;
import java.util.Scanner;

import entities.Tree;
import entities.TreeAVL;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int treeType = 0;
		
		System.out.println("Choose tree type!");
		System.out.println("1. Normal");
		System.out.println("2. AVL");
		System.out.println("3. Tests");
		
		treeType = sc.nextInt();
		
		if(treeType == 1) {
			
			Tree tree = new Tree(null, 1);
			
			int choose = 1;
			while(choose != 0) {
				
				System.out.println("\n0. Exit");
				System.out.println("1. Insert");
				System.out.println("2. Remove");
				System.out.println("3. Search");
				
				choose = sc.nextInt();
				
				switch(choose) {
				case 1:
					System.out.print("\nNode data (Number): ");
					tree.insertNode(sc.nextInt());
					//tree.printTree(tree.getRoot());
					break;
				case 2:
					System.out.print("\nNode data (Number): ");
					tree.removeNode(sc.nextInt());
					//tree.printTree(tree.getRoot());
					break;
				case 3:
					System.out.print("\nNumber to search: ");
					tree.searchNode(sc.nextInt(), tree.getRoot(), 0);
					break;
				default:
					System.out.println("Saindo...");
					choose = 0;
					break;
				}
			}
			
		} else if (treeType == 2) {
			
			TreeAVL tree = new TreeAVL(null);
			
			int choose = 1;
			while(choose != 0) {
				
				System.out.println("\n0. Exit");
				System.out.println("1. Insert");
				System.out.println("2. Remove");
				System.out.println("3. Search");
				
				choose = sc.nextInt();
				
				switch(choose) {
				case 1:
					System.out.print("\nNode data (Number): ");
					tree.insertNode(sc.nextInt());
					tree.checkBalance();
					tree.printTree(tree.getRoot());
					break;
				case 2:
					System.out.print("\nNode data (Number): ");
					tree.removeNode(sc.nextInt());
					tree.checkBalance();
					tree.printTree(tree.getRoot());
					break;
				case 3:
					System.out.print("\nNumber to search: ");
					tree.searchNode(sc.nextInt(), tree.getRoot(), 0);
					break;
				default:
					System.out.println("Saindo...");
					choose = 0;
					break;
				}
			}
						
		} else {
			
	        Random random = new Random();
	        
	        Tree tree = new Tree(null, 0);
	        
	        long startTime;
	        long endTime;
	        long elapsedTime;
	        
	        System.out.println("Normal Tree ------------------------------------------------\n");
	        
	        //INSERT
	        startTime = System.currentTimeMillis();
	        //100 números aleatórios
	        for (int i = 0; i < 100; i++) {
	            int randomNumber = random.nextInt();
	            tree.insertNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 100 numbers: " + elapsedTime + " miliseconds");
	        
	        //500 números aleatórios
	        tree = new Tree(null, 0);
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 500; i++) {
	        	int randomNumber = random.nextInt();
	            tree.insertNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 500 numbers: " + elapsedTime + " miliseconds");
	        
	        //1000 números aleatórios
	        tree = new Tree(null, 0);
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 1000; i++) {
	        	int randomNumber = random.nextInt();
	            tree.insertNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 1000 numbers: " + elapsedTime + " miliseconds");
	        
	        //10000 números aleatórios
	        tree = new Tree(null, 0);
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 10000; i++) {
	        	int randomNumber = random.nextInt();
	            tree.insertNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 10000 numbers: " + elapsedTime + " miliseconds");
	        
	        //20000 números aleatórios
	        tree = new Tree(null, 0);
	        startTime = System.currentTimeMillis();
	        for (int i = 0; i < 20000; i++) {
	        	int randomNumber = random.nextInt(500000) + 1;
	            tree.insertNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 20000 numbers: " + elapsedTime + " miliseconds\n");
	        
	        //SEARCH
	        startTime = System.currentTimeMillis();
	        //10000 números aleatórios
	        for (int i = 0; i < 20000; i++) {
	            int randomNumber = random.nextInt(50000) + 1;
	            tree.searchNode(randomNumber, tree.getRoot(), 0);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for search 20000 numbers: " + elapsedTime + " miliseconds\n");
	        
	        //REMOVE
	        startTime = System.currentTimeMillis();
	        //10000 números aleatórios
	        for (int i = 0; i < 10000; i++) {
	            int randomNumber = random.nextInt(50000) + 1;
	            tree.removeNode(randomNumber);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for remove 10000 numbers: " + elapsedTime + " miliseconds\n");
	        
	        System.out.println("------------------------------------------------------------\n");
	        System.out.println("AVL Tree ---------------------------------------------------\n");
	        
	        //INSERT
	        TreeAVL treeAVL = new TreeAVL(null);
	        startTime = System.currentTimeMillis();
	        //100 números aleatórios
	        for (int i = 0; i < 100; i++) {
	            int randomNumber = random.nextInt();
	            treeAVL.insertNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 100 numbers: " + elapsedTime + " miliseconds");

	        treeAVL = new TreeAVL(null);
	        startTime = System.currentTimeMillis();
	        //500 números aleatórios
	        for (int i = 0; i < 500; i++) {
	            int randomNumber = random.nextInt();
	            treeAVL.insertNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 500 numbers: " + elapsedTime + " miliseconds");
	        
	        treeAVL = new TreeAVL(null);
	        startTime = System.currentTimeMillis();
	        //500 números aleatórios
	        for (int i = 0; i < 1000; i++) {
	            int randomNumber = random.nextInt();
	            treeAVL.insertNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 1000 numbers: " + elapsedTime + " miliseconds");
	        
	        treeAVL = new TreeAVL(null);
	        startTime = System.currentTimeMillis();
	        //10000 números aleatórios
	        for (int i = 0; i < 10000; i++) {
	            int randomNumber = random.nextInt();
	            treeAVL.insertNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 10000 numbers: " + elapsedTime + " miliseconds");
	        
	        treeAVL = new TreeAVL(null);
	        startTime = System.currentTimeMillis();
	        //20000 números aleatórios
	        for (int i = 0; i < 20000; i++) {
	            int randomNumber = random.nextInt();
	            treeAVL.insertNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for insert 20000 numbers: " + elapsedTime + " miliseconds\n");
	        
	        //SEARCH
	        startTime = System.currentTimeMillis();
	        //10000 números aleatórios
	        for (int i = 0; i < 20000; i++) {
	            int randomNumber = random.nextInt(50000) + 1;
	            treeAVL.searchNode(randomNumber, treeAVL.getRoot(), 0);
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for search 20000 numbers: " + elapsedTime + " miliseconds\n");
	        
	        //REMOVE
	        startTime = System.currentTimeMillis();
	        //10000 números aleatórios
	        for (int i = 0; i < 10000; i++) {
	            int randomNumber = random.nextInt(50000) + 1;
	            treeAVL.removeNode(randomNumber);
	            treeAVL.checkBalance();
	        }
	        endTime = System.currentTimeMillis();
	        elapsedTime = endTime - startTime;
	        System.out.println("Total time for remove 10000 numbers: " + elapsedTime + " miliseconds\n");
        
		}
			
		sc.close();
		
	}

}
