package lists;

/**
 * @author Jose Acuna
 * @version 1.0
 * @since 29-08-2018
 */
public class Board {

    private static Board instance = null;
    private int rows;
    private int columns;
    private Node head;

    /** Private constructor **/
    private Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.head = make_columns();
    }

    /**
     * Singleton constructor
     * @param rows int: amount of rows in the BoardGame
     * @param columns int: amount of columns in the BoardGame
     * @return returns a lists.Board instance
     */
    public static synchronized Board init(int rows, int columns){
        if (instance == null) instance = new Board(rows,columns);
        return instance;
    }

    /**
     * Resets the lists.Board Size to new values
     * @param rows int: amount of rows in the BoardGame
     * @param columns int: amount of columns in the BoardGame
     */
    public final void setBoardSize(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.head = make_columns();
    }

    /**
     * Gets a the node in the given index
     * @param row int: in which row to search
     * @param column int: in which column to search
     * @return Node
     */
    public Node getIndex(int row, int column){
        Node node = head;
        int i = 0;
        while (i < row){
            node = node.bottom;
            i++;
        }
        int j = 0;
        while (j < column) {
            node = node.right;
            j++;
        }
        return node;
    }

    /**
     * Gets the first Node in the matrix
     * @return Node
     */
    public Node getBoardHead(){
        return head;
    }

    /**
     * Sets a double link between continuous nodes
     * @return SimpleList white the head of each row
     */
    private SimpleList make_rows(){
        SimpleList rows_list = new SimpleList<Node>();
        int i = 1;
        while (i <= rows) {
            Node tmp = new Node();
            rows_list.addAtEnd(tmp);
            int j = 2;
            while (j <= columns) {
                tmp.right = new Node();
                tmp.right.left = tmp;
                tmp = tmp.right;
                j++;
            }
            i++;
        }
        return rows_list;
    }

    /**
     * Sets the vertical and diagonal link between nodes
     * @return the first node of the Board
     */
    private Node make_columns(){
        Node tmp = make_rows().getFirst();
        Node first_node = (Node) tmp.getValue();

        // Mode between rows
        while (tmp.next != null){
            Node first_row = (Node) tmp.getValue();
            Node second_row = (Node) tmp.next.getValue();

            // Match the columns
            while (first_row != null){
                first_row.bottom = second_row;
                first_row.bottom_left = second_row.left;
                first_row.bottom_right = second_row.right;

                second_row.top = first_row;
                second_row.top_left = first_row.left;
                second_row.top_right = first_row.right;

                // Move to next lists.Node
                first_row = first_row.right;
                second_row = second_row.right;
            }
            tmp = tmp.next;
        }
        return first_node;
    }

    /* Getters and Setters */

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
