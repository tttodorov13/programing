package com.programing.dataStructures.tree;

/**
 * Represents a binary tree structure.
 */
public class BinaryTree<T> {

	/**
	 * Represents a binary tree node.
	 *
	 * @param <T> - the type of the values in nodes.
	 */
	public static class BinaryTreeNode<T> {

		// Contains the value of the node
		private T value;

		// Shows whether the current node has parent
		private boolean hasParent;

		// Contains the left child of the node
		private BinaryTreeNode<T> leftChild;
		// Contains the right child of the node
		private BinaryTreeNode<T> rightChild;

		/**
		 * Constructs a binary tree node.
		 *
		 * @param value      - the value of the node.
		 * @param leftChild  - the left child of the node.
		 * @param rightChild - the right child of the node.
		 */
		public BinaryTreeNode(T value, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}

		/**
		 * Constructs a binary tree node with no children.
		 *
		 * @param value - the value of the node.
		 */
		public BinaryTreeNode(T value) {
			this(value, null, null);
		}

		/**
		 * @return the value of the node.
		 */
		public T getValue() {
			return this.value;
		}

		/**
		 * Sets the value of the node.
		 *
		 * @param value - the value to be dictionary.
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * @return the left child or null if it does not exists.
		 */
		public BinaryTreeNode<T> getLeftChild() {
			return this.leftChild;
		}

		/**
		 * Sets the left child.
		 *
		 * @param value - the new left child to be dictionary.
		 */
		public void setLeftChild(BinaryTreeNode<T> value) {
			if (value == null || value.hasParent) {
				throw new IllegalArgumentException();
			}
			value.hasParent = true;
			this.leftChild = value;
		}

		/**
		 * @return the right child or null if it does not exists.
		 */
		public BinaryTreeNode<T> getRightChild() {
			return this.rightChild;
		}

		/**
		 * Sets the right child.
		 *
		 * @param value - the new right child to be dictionary.
		 */
		public void setRightChild(BinaryTreeNode<T> value) {
			if (value == null || value.hasParent) {
				throw new IllegalArgumentException();
			}
			value.hasParent = true;
			this.rightChild = value;
		}
	}

	// The root of the tree
	private BinaryTreeNode<T> root;

	/**
	 * Constructs the tree.
	 *
	 * @param value      - the value of the node.
	 * @param leftChild  - the children of the node.
	 * @param rightChild - the children of the node.
	 */
	public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		BinaryTreeNode<T> leftChildNode = leftChild != null ? leftChild.root : null;
		BinaryTreeNode<T> rightChildNode = rightChild != null ? rightChild.root : null;
		this.root = new BinaryTreeNode<T>(value, leftChildNode, rightChildNode);
	}

	/**
	 * Constructs the tree.
	 *
	 * @param value - the value of the node.
	 */
	public BinaryTree(T value) {
		this(value, null, null);
	}

	/**
	 * @return the root of the tree.
	 */
	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * @return the left child of the root.
	 */
	public BinaryTreeNode<T> getLeftChildNode() {
		if (this.root != null) {
			return this.root.getLeftChild();
		}
		return null;
	}

	/**
	 * @return the right child of the root.
	 */
	public BinaryTreeNode<T> getRightChildNode() {
		if (this.root != null) {
			return this.root.getRightChild();
		}
		return null;
	}

	/**
	 * Traverses binary tree in pre-order manner.
	 *
	 * @param root - the binary tree to be traversed.
	 */
	private void printPreOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}

		// 1. Visit the left child.
		printPreOrder(root.getLeftChild());
		// 2. Visit the root of this subtree.
		System.out.print(root.getValue() + " ");
		// 3. Visit the right child.
		printPreOrder(root.getRightChild());
	}

	/**
	 * Traverses and prints the binary
	 * tree in pre-order manner.
	 */
	public void printPreOrder() {
		printPreOrder(this.root);
		System.out.println();
	}

	/**
	 * Traverses binary tree in in-order manner.
	 *
	 * @param root - the binary tree to be traversed.
	 */
	private void printInOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}

		// 1. Visit the root of this subtree.
		System.out.print(root.getValue() + " ");
		// 2. Visit the left child.
		printInOrder(root.getLeftChild());
		// 3. Visit the right child.
		printInOrder(root.getRightChild());
	}

	/**
	 * Traverses and prints the binary
	 * tree in pre-order manner.
	 */
	public void printInOrder() {
		printInOrder(this.root);
		System.out.println();
	}

	/**
	 * Traverses binary tree in post-order manner.
	 *
	 * @param root - the binary tree to be traversed.
	 */
	private void printPostOrder(BinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}

		// 1. Visit the right child.
		printPostOrder(root.getRightChild());
		// 2. Visit the root of this subtree.
		System.out.print(root.getValue() + " ");
		// 3. Visit the left child.
		printPostOrder(root.getLeftChild());
	}

	/**
	 * Traverses and prints the binary
	 * tree in pre-order manner.
	 */
	public void printPostOrder() {
		printPostOrder(this.root);
		System.out.println();
	}
}
