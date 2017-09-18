public class App {

    private static final String field1 = ".*.*\n....\n*...";
    private static final String field2 = ".*..*\n*....\n*....";
    private static final String field3 = ".*.*\n....\n*......";

    public static void main(String[] args){
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        mineSweeper.setMineField(field1);
        String result = mineSweeper.getHintField();
        System.out.println("Field 1: ");
        System.out.println(result);

        mineSweeper.setMineField(field2);
        result = mineSweeper.getHintField();
        System.out.println("Field 2: ");
        System.out.println(result);

        mineSweeper.setMineField(field3);
        result = mineSweeper.getHintField();
        System.out.println("Field 3: ");
        System.out.println(result);

    }

}
