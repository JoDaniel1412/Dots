/**
 * @author José Acuña
 * @version 1.0
 * @since 29-08-2018
 */
public class Board {

    private static Board instance = null;
    private int rows;
    private int columns;
    private Node head;

    // Private constructor
    private Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.head = make_columns();
    }

    /**
     * Singleton constructor
     * @param rows amount of rows in the BoardGame
     * @param columns amount of columns in the BoardGame
     * @return returns a Board instance
     */
    public static synchronized Board init(int rows, int columns){
        if (instance == null) instance = new Board(rows,columns);
        return instance;
    }

    /**
     * Resets the Board Size to new values
     * @param rows amount of rows in the BoardGame
     * @param columns amount of columns in the BoardGame
     */
    public void setBoardSize(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.head = make_columns();
    }

    public Node getBoardHead(){
        return head;
    }

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

                // Move to next Node
                first_row = first_row.right;
                second_row = second_row.right;
            }
            tmp = tmp.next;
        }
        return first_node;
    }
}
