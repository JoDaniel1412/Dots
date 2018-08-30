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
    public static synchronized Board getBoard(int rows, int columns){
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

    public Node getBoardHead(){return head;}

    private List make_rows(){
        List rows_list = new List();
        int i = 0;
        while (i < rows) {
            Node tmp = new Node();
            rows_list.append(tmp);
            int j = 0;
            while (j < columns) {
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
        Node tmp = make_rows().head;
        Node first_node = tmp;

        // Mode between rows
        while (tmp.next != null){
            Node first_row = tmp;
            Node second_row = tmp.next;

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
