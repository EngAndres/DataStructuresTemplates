package Trees;


/*
# Recovery Trees based on Tree Traversals.
#
# Created by Msc. Carlos Andres Sierra on April 2018.
# Copyright (c) 2018  Msc. Carlos Andres Sierra. Research Group on Artificial Life - ALIFE. All rights reserved.
#
# This file is part of DataStructuresTemplates.
#
# DataStructuresTemplates is free software: you can redistribute it and/or modify it under the terms of the
# GNU General Public License as published by the Free Software Foundation, version 3.
*/

/**
 * This class represents the behavior of Recovery Trees based on Tree Traversals
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class RecoveryTrees {

	
	/**
	 * Zero - parameters constructor
	 */
	public RecoveryTrees() {}
	
	
	/**
	 * 
	 * @param postorder
	 * @param inorder
	 * @return
	 */
	public void in_post2pre(String postorder, String inorder)
	{
		BinaryTree recovery = new BinaryTree();
		recovery = recovery_subtree_inpost(inorder, postorder);
		recovery.preorder(recovery.root);
	}
	
	
	/**
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public void in_pre2post(String preorder, String inorder)
	{
		BinaryTree recovery = new BinaryTree();
		recovery = recovery_subtree_inpre(inorder, preorder);
		recovery.postorder(recovery.root);
	}

	
	/**
	 * 
	 * @param sub_inorder
	 * @param preorder
	 * @return
	 */
	public BinaryTree recovery_subtree_inpre(String sub_inorder, String preorder)
	{
		if(sub_inorder.length() == 0)
			return new BinaryTree();
		else
		{
			BinaryTree temp = new BinaryTree();
			
			if((sub_inorder.length() == 1))
				temp.root = new RecoveryNode(sub_inorder);
			else
			{
				int[] indexes = new int[sub_inorder.length()];
				
				for(int i = 0; i < sub_inorder.length(); i++)
					indexes[i] = preorder.indexOf( sub_inorder.substring(i, i + 1) );
				
				int less = Integer.MAX_VALUE, index = -1;
				for(int i = 0; i < indexes.length; i++)
					if(indexes[i] < less)
					{
						index = i;
						less = indexes[i]; 
					}
				
				temp.root = new RecoveryNode( sub_inorder.substring(index, index + 1) );
				temp.root.setLeft( recovery_subtree_inpre(sub_inorder.substring(0,index), preorder).root );
				temp.root.setRight( recovery_subtree_inpre(sub_inorder.substring(index + 1), preorder).root );
			}	
			
			return temp;
		}
	}

	
	/**
	 * 
	 * @param sub_inorder
	 * @param postorder
	 * @return
	 */
	public BinaryTree recovery_subtree_inpost(String sub_inorder, String postorder)
	{
		if(sub_inorder.length() == 0)
			return new BinaryTree();
		else
		{
			BinaryTree temp = new BinaryTree();
			
			if((sub_inorder.length() == 1))
				temp.root = new RecoveryNode(sub_inorder);
			else
			{
				int[] indexes = new int[sub_inorder.length()];
				
				for(int i = 0; i < sub_inorder.length(); i++)
					indexes[i] = postorder.indexOf( sub_inorder.substring(i, i + 1) );
				
				int greater = Integer.MIN_VALUE, index = -1;
				for(int i = 0; i < indexes.length; i++)
					if(indexes[i] > greater)
					{
						index = i;
						greater = indexes[i]; 
					}
				
				temp.root = new RecoveryNode( sub_inorder.substring(index, index + 1) );
				temp.root.setLeft( recovery_subtree_inpost(sub_inorder.substring(0,index), postorder).root );
				temp.root.setRight( recovery_subtree_inpost(sub_inorder.substring(index + 1), postorder).root );
			}	
			
			return temp;
		}
	}
	
	
	public static void main(String[] args) {
		RecoveryTrees com = new RecoveryTrees();
		com.in_post2pre("ACBFGED", "ABCDEFG");
	}

}