// The test harness will belong to the following package; the BST
// implementation will belong to it as well.  In addition, the BST
// implementation will specify package access for the inner node class
// and all data members in order that the test harness may have access
// to them.
//
package Minor.P2.DS;

// BST<> provides a generic implementation of a binary search tree
//
// BST<> implementation constraints:
//   - The tree uses package access for root, and for the node type.
//   - The node type uses package access for its data members.
//   - The tree never stores two objects for which compareTo() returns 0.
//   - All tree traversals are performed recursively.
//   - Optionally, the BST<> employs a pool of deleted nodes.
//     If so, when an insertion is performed, a node from the pool is used 
//     unless the pool is empty, and when a deletion is performed, the
//     (cleaned) deleted node is added to the pool, unless the pool is
//     full.  The maximum size of the pool is set via the constructor.
//
// User data type (T) constraints:
//   - T implements compareTo() and equals() appropriately
//   - compareTo() and equals() are consistent; that is, compareTo()
//     returns 0 in exactly the same situations equals() returns true
//

//On my honor:
//
//- I have not discussed the Java language code in my program with
//anyone other than my instructor or the teaching assistants
//assigned to this course.
//
//- I have not used Java language code obtained from another student,
//or any other unauthorized source, either modified or unmodified.
//
//- If any Java language code or documentation used in my program
//was obtained from another source, such as a text book or course
//notes, that has been clearly noted with a proper citation in
//the comments of my program.
//
//- I have not designed this program in such a way as to defeat or
//interfere with the normal operation of the Curator System.
//
//<Brandon Emerson Potts>
public class BST<T extends Comparable<? super T>> {

    class BinaryNode {
        // Initialize a childless binary node.
        // Pre:   elem is not null
        // Post:  (in the new node)
        //        element == elem
        //        left == right == null
        public BinaryNode( T elem ) {

            this.element = elem;
            this.right = null;
            this.left = null;

        }
        // Initialize a binary node with children.
        // Pre:   elem is not null
        // Post:  (in the new node)
        //        element == elem
        //        left == lt, right == rt
        public BinaryNode( T elem, BinaryNode lt, BinaryNode rt ) {

            this.element = elem;
            this.right = rt;
            this.left = lt;

        }

        T          element;  // the data in the node
        BinaryNode left;     // pointer to the left child
        BinaryNode right;    // pointer to the right child
    }

    BinaryNode root;        // pointer to root node, if present
    BinaryNode pool;        // pointer to first node in the pool
    int        pSize;       // size limit for node pool

    // Initialize empty BST with no node pool.
    // Pre:   none
    // Post:  (in the new tree)
    //        root == null, pool == null, pSize = 0
    public BST() {

        this.root = null;
        this.pool = null;
        this.pSize = 0;
    }

    // Initialize empty BST with a node pool of up to pSize nodes.
    // Pre:   none
    // Post:  (in the new tree)
    //        root == null, pool = null, pSize == Sz 
    public BST( int Sz ) {

        this.root = null;
        this.pool = null;
        this.pSize = Sz;

    }

    // Return true iff BST contains no nodes.
    // Pre:   none
    // Post:  the binary tree is unchanged
    public boolean isEmpty( ) {

        if(this.root == null){
            return true;
        }

        return false;
    }

    // Return pointer to matching data element, or null if no matching
    // element exists in the BST.  "Matching" should be tested using the
    // data object's compareTo() method.
    // Pre:  x is null or points to a valid object of type T
    // Post: the binary tree is unchanged
    public T find( T x ) {

        if(x == null){
            return null;
        }

        BinaryNode foundNode = findHelper(this.root , x);

        // Will be null when the value isn't in the tree
        if(foundNode == null){
            return null;
        }

        return foundNode.element;
    }

    /***
     * Performs the actual Binary Searching to find the element
     * @param node node that is being parsed
     * @param soughtValue element that is being looked for
     * @return element that was saught for
     *         null otherwise
     */
    private BinaryNode findHelper(BinaryNode node, T soughtValue){

        if(node == null){
            return null;
        }

        int comparedResult = soughtValue.compareTo(node.element);

        // Will be true when the node is greater than the soughtValue
        if(comparedResult > 0){
            return findHelper(node.right , soughtValue);
            // Will be true when the node element is greater than soughtValue
        } else if (comparedResult < 0){
            return findHelper(node.left , soughtValue);
        }

        return node;
    }

    // Insert element x into BST, unless it is already stored.  Return true
    // if insertion is performed and false otherwise.
    // Pre:   x is null or points to a valid object of type T
    // Post:  the binary tree contains x
    public boolean insert( T x ) {

        if(x == null){
            return false;
        } else if (this.root == null){
            this.root = new BinaryNode(x);
        } else {
            // Checks to see if the value is in the tree or not
            if(find(x) != null){
                return false;
            }
            this.root = insertHelper(this.root, x);
        }

        return true;
    }



    /***
     * Inserts an element into the Binary Search Tree
     * @param node current Node that is being processed
     * @param soughtValue element that is being inserted
     * @return BinaryNode if the element was inserted
     *         null if the element already existed in the tree
     */
    private BinaryNode insertHelper(BinaryNode node , T soughtValue){

        // Will be true when the correct spot has been found
        if(node == null){
            return new BinaryNode(soughtValue);
        }

        int comparedResult = soughtValue.compareTo(node.element);
        // Will be true when the node is greater than the soughtValue
        if(comparedResult > 0){
            node.right = insertHelper(node.right, soughtValue);
            // Will be true when the node element is greater than soughtValue
        } else if (comparedResult < 0){
            node.left = insertHelper(node.left, soughtValue);
        }

        return node;
    }


    // Delete element matching x from the BST, if present.  Return true if
    // matching element is removed from the tree and false otherwise.
    // Pre:   x is null or points to a valid object of type T
    // Post:  the binary tree does not contain x
    public boolean remove( T x ) {

        // Error checking
        if(x == null){
            return false;
        }

        if(find(x) == null){
            return false;
        }

        this.root = removeHelper(this.root, x);
//        if(node == null){
//            return false;
//        }
        return true;
    }


    /***
     * Removes a node from the tree
     * @param node current node that is being processed
     * @param soughtValue value that is being sought
     * @return deleted BinaryNode
     *         null otherwise
     */
    private BinaryNode removeHelper(BinaryNode node , T soughtValue){

        if(node == null){
            return null;
        }

        int compareResult = soughtValue.compareTo(node.element);
        // Will be true when the node is greater than the soughtValue
        if(compareResult > 0){
            node.right = removeHelper(node.right, soughtValue);
            // Will be true when the node element is greater than soughtValue
        } else if (compareResult < 0){
            node.left = removeHelper(node.left, soughtValue);
            // We've found the node
        } else {

            if(node.left == null){
                return node.right;
            } else if (node.right == null){
                return node.left;
                // Node has two children
            } else {

                BinaryNode minNode = getMinBinaryNode(node.right);
                node.right = deleteMinBinaryNode(node.right);
                minNode.left = node.left;
                minNode.right = node.right;
                return minNode;
            }
        }
        return node;
    }


    /***
     * Returns the largest Node in a Binary Tree
     * @param node current BinaryNode that is being processed
     * @return largest BinaryNode in a tree
     *         null otherwise
     */
    private BinaryNode getMinBinaryNode(BinaryNode node){

        if(node.left == null){
            return node;
        }

        return getMinBinaryNode(node.left);
    }

    /***
     * Deletes the largest BinaryNode in a tree
     * @param node currentNode that is being processed
     * @return BinaryNode that was deleted
     *         null otherwise
     */
    private BinaryNode deleteMinBinaryNode(BinaryNode node){

        if(node.left == null){
            return node.right;
        }

        node.left = deleteMinBinaryNode(node.left);
        return node;
    }



    // Remove from the tree all values y such that y > x, according to
    // compareTo().
    // Pre:   x is null or points to a valid object of type T
    // Post:  if the tree contains no value y such that compareTo()
    //           indicates y > x
    public void cap( T x ) { //TODO
    }

    private BinaryNode capHelper(BinaryNode node , T ceilingValue){
        return null;
    }

    // Return the tree to an empty state.
    // Pre:   none
    // Post:  the binary tree contains no elements
    public void clear( ) {
        this.root = null;
    }

    // Return true iff other is a BST that has the same physical structure
    // and stores equal data values in corresponding nodes.  "Equal" should
    // be tested using the data object's equals() method.
    // Pre:   other is null or points to a valid BST<> object, instantiated
    //           on the same data type as the tree on which equals() is invoked
    // Post:  both binary trees are unchanged
    public boolean equals(Object other) {

        if (other == null){
            return false;
        }
        BST node = (BST)other;
        return equalsHelper(this.root , node.root);
    }

    /****
     *  Performs the compare operation
     * @param node first node that is being compared
     * @param comparedNode second node that is being compared
     * @return true if the trees are equal
     *         false otherwise 
     */
    private boolean equalsHelper(BinaryNode node , BinaryNode comparedNode){

        if (node == null || comparedNode == null) {
            return node == comparedNode;
        } else if (comparedNode.equals(node)) {
            return true;
        }

        return ((node.element == comparedNode.element)
                && equalsHelper(node.left, comparedNode.left)
                && equalsHelper(node.right, comparedNode.right));
    }

    // Return number of levels in the tree.  (An empty tree has 0 levels.)
    // Pre:   tree is a valid BST<> object
    // Post:  the binary tree is unchanged
    public int levels() {

        return levelsHelper(this.root);
    }

    /***
     * Returns the number of levels in a tree
     * @param node current node that is being processed
     * @return number of levels below the node
     */
    private int levelsHelper(BinaryNode node){

        if (node == null){
            return 0;
        }

        return 1 + Math.max(levelsHelper(node.left) , levelsHelper(node.right));
    }
}