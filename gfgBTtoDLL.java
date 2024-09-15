class Solution{
    Node prev = null;

    Node Inorder(Node root){
        if(root==null) return null;

        Node head = Inorder(root.left);

        if(prev==null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        Inorder(root.right);
        return head;
    }

    Node bToDLL(Node root){
        if(root==null) return null;

        Node head = Inorder(root);

        return head;
    }
}