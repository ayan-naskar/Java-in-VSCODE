class SegmentTreeNode{
    int start,end,sum;
    SegmentTreeNode left,right;
    SegmentTreeNode(){}
    SegmentTreeNode(int start, int end, SegmentTreeNode left, SegmentTreeNode right){
        this.start=start;
        this.end=end;
        this.left=left;
        this.right=right;
        sum=0;  
    }
}

class SegTree{
    SegmentTreeNode root;
    SegTree(){
        root=null;
    }
    private SegmentTreeNode buildTree(int nums[],int start,int end){
        if(start==end){
            SegmentTreeNode node = new SegmentTreeNode(start, end,null,null);
            node.sum=nums[start];
            return node;
        }else{
            SegmentTreeNode leftptr = buildTree(nums, start, (start+end)/2);
            SegmentTreeNode rightptr = buildTree(nums, (start+end)/2+1, end);
    
            SegmentTreeNode node = new SegmentTreeNode(start, end, leftptr,rightptr);
            node.sum = leftptr.sum+rightptr.sum;
            return node;
        }
    }
    public void initializeTree(int[] nums){
        root = buildTree(nums, 0, nums.length-1);
    }

    private int getRangeSum(int start, int end,SegmentTreeNode node){
        if(start==node.start && end==node.end){
            return node.sum;
        }else{
            int l=0,r=0;
            int mid = (node.start+node.end)/2;
            if(start<=mid && mid<end){
                l=getRangeSum(start, mid, node.left);
                r=getRangeSum(mid+1, end, node.right);
            }else if(start<=mid && end<=mid){
                l=getRangeSum(start, end, node.left);
            }else if(mid<start && mid<end){
                r=getRangeSum(start, end, node.right);
            }
            return l+r;
        }
    }

    public int getRangeSum(int start, int end){
        return getRangeSum(start, end, root);
    }

    private void updateValue(int index, int newvalue, SegmentTreeNode node) {
        int mid = (node.start+node.end)/2;
        if(node.start==index && node.end==index){
            node.sum=newvalue;
            return;
        }
        else if(mid<index) updateValue(index, newvalue, node.right);
        else updateValue(index, newvalue, node.left);
        node.sum=node.left.sum+node.right.sum;
    }

    public void updateValue(int index, int newvalue){
        updateValue(index, newvalue, root);
    }
}

public class segmentTree {
    public static void main(String[] Args){
        int nums[]=new int[]{1,2,3,4,5,6,7,8,9};
        SegTree ob = new SegTree();
        ob.initializeTree(nums);
        // System.out.println("the sum is : " + ob.getRangeSum(1, 5));
        System.out.println("the sum is : " + ob.getRangeSum(0, 8));
        System.out.println(ob.root.sum);
        ob.updateValue(6, 8);
        System.out.println("the sum is : " + ob.getRangeSum(0, 8));
        System.out.println(ob.root.sum);//+" "+treeHead.left.sum+" "+treeHead.right.sum);
    }

}
