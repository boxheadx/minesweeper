import java.util.*;

class Minesweeper{

        boolean hasCompleted = false;

        static Mine [] mines;
        static Table t;
        static int _p, _q;

        public static void main(String [] args){

                t = new Table();

                Scanner sc = new Scanner(System.in);

                System.out.print("Rows: ");
                _p = sc.nextInt();

                System.out.print("Column: ");
                _q = sc.nextInt();

                t.makeTable(_p,_q);

                System.out.println("Enter number of mines: ");
                int n = sc.nextInt();

                mines = new Mine[n];

                initMines(n, _p, _q);


        }

        static void getNumbers(){
                for(Mine m : mines){
                        int [] current_mine = m.getPosition();
                        if(current_mine[0] == 0){
                                if(current_mine[1] == 0){
                                }
                                if(current_mine[1] == _q){
                                }

                        }
                        if(current_mine[0] == _p){
                                if(current_mine[1] == 0){
                                }
                                if(current_mine[1] == _q){
                                }
                        }
                }
        }

        static void initMines(int n, int p, int q){
                Integer [] x = new Integer[n];
                Integer [] y = new Integer[n];
                for(int i = 0; i <= n-1; i++){
                        x[i] = i;
                }
                for(int j = 0; j <= n-1; j++){
                        y[j] = j;
                }

                Collections.shuffle(Arrays.asList(x));
                Collections.shuffle(Arrays.asList(y));

                int count = 0;

                for(Mine mine : mines){
                        mine = new Mine(t, new int[]{x[count], y[count]});
                        count++;
                }
        }
}

class Table{

        private String [][] table;

        public Table(){

        }

        public void updateTable(int x, int y, String val){
                table[x][y] = val;
                display();
        }

        public void makeTable(int p, int q){

                table = new String[p][q];

                for(String [] row : table){
                        for(int k = 0; k < row.length; k++){
                                row[k] = "[ ]";
                        }
                }

                display();

        }

        void display(){
                for(String [] row : table){
                        for(String col : row){
                                System.out.print(col);
                        }

                        System.out.println();
                }
        }
}


class Mine{
        private static int TOTAL_MINES;
        private int [] pos;
        private Table table;

        public Mine(Table table, int [] pos){
                this.pos = pos;
                this.table = table;
                TOTAL_MINES++;

                System.out.println("(" + TOTAL_MINES + ")" +" A mine has been added.");

                table.updateTable(pos[0], pos[1], "[*]");
        }


        public int [] getPosition(){
                return this.pos;
        }
}
