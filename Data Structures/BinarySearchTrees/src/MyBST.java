  // Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

public class MyBST
{
	private TreeNode root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value)
	{
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value)
	{
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value)
	{
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString()
	{
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value)
	{
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value)
	{
		if(node==null)
			return new TreeNode(value);
		else {
			int diff = ((Comparable<Object>)node.getValue()).compareTo((Comparable<Object>)value);
			
			if(diff<0) {
				if(node.getRight()!=null)
					add(node.getRight(), value);
				else
					node.setRight(new TreeNode(value));
			}
			else {
				if(node.getLeft()!=null)
					add(node.getLeft(), value);
				else
					node.setLeft(new TreeNode(value));
			}
			
			return node;
		}
	}
	
	private boolean isLeaf(TreeNode node) {
		if(node.getLeft()==null && node.getRight()==null)
			return true;
		return false;
	}
	
	

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Object value)
	{
		if (node == null)
			return null;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return removeRoot(node);
			else if (diff < 0)
				node.setLeft(remove(node.getLeft(), value));
			else // if (diff > 0)
				node.setRight(remove(node.getRight(), value));
			return node;
		}
	}

	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root)
	{
		TreeNode min = null;
		TreeNode trail = null;

		if(root.getLeft()==null&&root.getRight()==null) {
			return null;
		}
		else if(root.getRight()!=null) {
			min=root.getRight();
			trail = root.getRight();
			if(min.getLeft()!=null)
				min=min.getLeft();
			while(min.getLeft()!=null) {
				min=min.getLeft();
				trail=trail.getLeft();
			}
			if(!min.equals(trail)) {
				if(min.getRight()==null) {
					trail.setLeft(null);
				}
				else {
					trail.setLeft(min.getRight());
				}
				min.setRight(root.getRight());
				min.setLeft(root.getLeft());
				return min;
			}
			else {
				min.setLeft(root.getLeft());
				return min;
			}
		}
		else
			return root.getLeft();
	}

	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node)
	{
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}

}
