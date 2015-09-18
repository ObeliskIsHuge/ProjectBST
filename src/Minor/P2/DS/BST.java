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
    public T find( T x ) { return null;}

    // Insert element x into BST, unless it is already stored.  Return true
    // if insertion is performed and false otherwise.
    // Pre:   x is null or points to a valid object of type T
    // Post:  the binary tree contains x
    public boolean insert( T x ) { return false; }

    // Delete element matching x from the BST, if present.  Return true if
    // matching element is removed from the tree and false otherwise.
    // Pre:   x is null or points to a valid object of type T
    // Post:  the binary tree does not contain x
    public boolean remove( T x ) { return false; }

    // Remove from the tree all values y such that y > x, according to
    // compareTo().
    // Pre:   x is null or points to a valid object of type T
    // Post:  if the tree contains no value y such that compareTo()
    //           indicates y > x
    public void cap( T x ) { //TODO
    }

    // Return the tree to an empty state.
    // Pre:   none
    // Post:  the binary tree contains no elements
    public void clear( ) { //TODO
    }

    // Return true iff other is a BST that has the same physical structure
    // and stores equal data values in corresponding nodes.  "Equal" should
    // be tested using the data object's equals() method.
    // Pre:   other is null or points to a valid BST<> object, instantiated
    //           on the same data type as the tree on which equals() is invoked
    // Post:  both binary trees are unchanged
    public boolean equals(Object other) { return false; }

    // Return number of levels in the tree.  (An empty tree has 0 levels.)
    // Pre:   tree is a valid BST<> object
    // Post:  the binary tree is unchanged
    public int levels() { return -1; }
}