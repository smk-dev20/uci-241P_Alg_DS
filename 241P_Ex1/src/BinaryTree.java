/*University of California, Irvine 
 * MSWE - 241P
 * Sherlin Mary Koshy (smkoshy)*/

//Binary Tree implementation based on https://www.youtube.com/watch?v=M6lYob8STMI
public class BinaryTree {
	/*
	 * private Node class generates each node of tree - each node stores the String
	 * value and pointers to left and right sub-trees
	 */
	private class Node {
		private String word;
		private Node left;
		private Node right;

		private Node(String str) {
			this.word = str;
			this.left = null;
			this.right = null;
		}
	}

	// reference to root of tree
	Node root;
	int treeSize = 0;

	public void addToTree(String word) {
		Node newNode = new Node(word);

		if (root == null) {
			root = newNode;
		} else {
			Node current;
			current = root;
			Node parent = null;
			while (true) {
				parent = current;
				if ((newNode.word.compareTo(current.word)) < 0) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public boolean contains(String lookUpWord){
		if(root == null) {
			return false;
		}
		else {
			Node current = root;
			while(current != null) {
			if(current.word.equals(lookUpWord))
				return true;
			else if((lookUpWord.compareTo(current.word))<0)
					current=current.left;
			else if((lookUpWord.compareTo(current.word))>0)
					current = current.right;		 	
		 }
			return false;
		}
	}

	public int treeCount() {
		Node current = root;
		traverseTree(current);
		return treeSize;
	}

	public void traverseTree(Node node) {
		if (node != null) {
			treeSize++;
			traverseTree(node.left);
			traverseTree(node.right);
		}
	}
}