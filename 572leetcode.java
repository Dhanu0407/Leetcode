import java.util.TreeMap;

class solution{
    public boolean IsIdentical(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.val==subRoot.val){
            return IsIdentical(root.left,subRoot.left)&&IsIdentical(root.right,subRoot.right);
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if(subRoot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(root.val==subRoot.val){
            if(IsIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }
}
