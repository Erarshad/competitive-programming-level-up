class Solution
{
    //https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1/#
    
    private Tree rec(Tree node, HashMap<Integer, Tree> map)
    {
        if(node==null) return null;
        
        Tree root;
        
        if(map.containsKey(node.data))
        {
            //The node already exists so we don't create a new node.
            root = map.get(node.data);
        }
        else
        {
            //The node does not exist so we create a new node and add it to the HashMap.
            root = new Tree(node.data);
            map.put(root.data, root);
        }
        
        
        if(node.random!=null)
        {
            //If the node's random pointer is not null
            if(map.containsKey(node.random.data))
            {
                //If the map contains node.random
                root.random = map.get(node.random.data);
            }
            else
            {
                //Else create a new node and add it to the map.
                root.random = new Tree(node.random.data);
                map.put(root.random.data, root.random);
            }
        }
        
        //Recursively travel left and right;
        root.left = rec(node.left, map);
        root.right = rec(node.right, map);
        
        //Return the root;
        return root;
    }
    
    public Tree cloneTree(Tree tree)
    {
        Tree root = rec(tree, new HashMap<>());
        return root;
    }
}