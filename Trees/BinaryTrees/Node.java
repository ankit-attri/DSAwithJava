package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;

    }
     static Scanner sc=new Scanner(System.in);

    public static  Node createTree(){
        System.out.println("Enter data : ");
        int data=sc.nextInt();
        if(data==-1)return null;
        Node root=new Node(data);
        System.out.println("Enter data for left of "+data);
        root.left=createTree();
        System.out.println("Enter data for right of "+data);
        root.right=createTree();
        return root;
    }

    public static void inorderTraversal(Node root){

        if(root==null)return;

        inorderTraversal(root.left);
        System.out.print(root.data+ " ");
        inorderTraversal(root.right);

    }
    public static void preorderTraversal(Node root){
        if(root==null)return;

        
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);

    }public static void postorderTraversal(Node root){
        if(root==null)return;

        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+ " ");

    }
    
    public static void levelOrderTraversal(Node root){
        if(root==null)return;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            System.out.print( temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }

        }



    }
    public static void main(String[] args) {
        
        Node root=createTree();
        System.out.print("Inorder : ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("Preorder : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Postorder : ");
        postorderTraversal(root);
        System.out.println();
        System.out.print("Level order : ");
        levelOrderTraversal(root);
    }
}

