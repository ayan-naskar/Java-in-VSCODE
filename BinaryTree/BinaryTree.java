import java.util.*;
class BinaryTree{
	static class Node{
		int val;
		Node left, right;
		Node(int val){
			this.val = val;
			this.left = this.right = null;
		}
	}

	static class CreateBinaryTree{
		int idx = -1;
		public Node buildTree(int[] nodes){
			idx++;
			if(nodes[idx] == -1){
				return null;
			}

			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);

			return newNode;
		}
	}

	static class display{
		public void preorder(Node root){
			if(root == null)
				return;

			System.out.print(root.val+" ");
			preorder(root.left);
			preorder(root.right);
		}

		public void inorder(Node root){
			if(root == null)
				return;

			inorder(root.left);
			System.out.print(root.val+" ");
			inorder(root.right);
		}

		public void postorder(Node root){
			if(root == null)
				return;

			postorder(root.left);
			postorder(root.right);
			System.out.print(root.val+" ");
		}

		public void levelorder(Node root){
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while(!q.isEmpty()){
				Node currNode = q.remove();
				if(currNode == null){
					if(q.isEmpty())
						return;
					else
					{
						System.out.println();
						q.add(null);
					}
				}else{
					System.out.print(currNode.val+" ");
					if(currNode.left != null){
						q.add(currNode.left);
					}
					if(currNode.right != null){
						q.add(currNode.right);
					}
				}
			}
		}
	}

	public static int countNodes(Node root){
		if(root == null)
			return 0;

		int left = countNodes(root.left);
		int right = countNodes(root.right);

		return left+right+1;
	}

	public static int sumNodes(Node root){
		if(root == null)
			return 0;

		int left = sumNodes(root.left);
		int right = sumNodes(root.right);

		return left + right + root.val;
	}

	public static int height(Node root){
		if(root == null)
			return 0;

		int left = height(root.left);
		int right = height(root.right);

		return Math.max(left, right)+1;
	}

	// static int max = -1;
	public static int diameter(Node root){ // (TC : O(N^2))
		if(root == null)
			return 0;
		int diam = height(root.left) + height(root.right) + 1;
        int maxdia = Math.max(diameter(root.left),diameter(root.right));

		return Math.max(diam, maxdia);
	}

    // private static int diam(Node root,int[] max){
    //     if(root == null) return 0;
    //     int lefth = diam(root.left,max), righth = diam(root.right,max);
    //     max[0] = Math.max(max[0],lefth+righth+1);
    //     //System.out.println(root.val + " = ("+ lefth + "," + righth + ")" + " --> " + (Math.max(lefth,righth)+1));
    //     return Math.max(lefth,righth)+1;
    // }

    // public static int diameter(Node root){ // (TC : O(N))
    //     int max[]=new int[1];
    //     diam(root,max);
    //     return max[0];
    // }

	public static void main(String s[]){
		int nodes[] = {1, 2, 4, 8, 9, -1, -1, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
		CreateBinaryTree tree = new CreateBinaryTree();
		Node root = tree.buildTree(nodes);
		System.out.println(root.val);
		display ob = new display();
		// ob.preorder(root);
		ob.inorder(root);
		// ob.postorder(root);
		// ob.levelorder(root);

		System.out.println("\nHeight of tree: "+height(root));
		System.out.println("\nDiameter of tree: "+diameter(root));
	}
}