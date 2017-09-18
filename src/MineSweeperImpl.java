public class MineSweeperImpl implements MineSweeper {

    private char[][] field;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {

        boolean validatedString = validateString(mineField);
        if (!validatedString) {
            throw new IllegalArgumentException();
        } else {
            String[] rows = mineField.split("\n");
            char[] row;
            field = new char[rows.length][rows[0].length()];
            for (int i = 0; i < rows.length; i++) {
                row = rows[i].toCharArray();
                for (int j = 0; j < row.length; j++) {
                    field[i][j] = row[j];
                }
            }
        }
    }


    @Override
    public String getHintField() throws IllegalStateException {
        StringBuffer result = new StringBuffer();
        if (field == null) {
            throw new IllegalStateException();
        }
        int columnAmount = field[0].length;
        int rowsAmount = field.length;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                if (field[row][col] == '*') {
                    result.append("*");
                } else {
                    int counter = 0;
                    if (row - 1 >= 0 && col - 1 >= 0 && field[row - 1][col - 1] == '*')
                        counter++;
                    else if (row - 1 >= 0 && field[row - 1][col] == '*')
                        counter++;
                    else if (row - 1 >= 0 && col + 1 <= columnAmount - 2 && field[row - 1][col + 1] == '*')
                        counter++;
                    else if (col - 1 >= 0 && field[row][col - 1] == '*')
                        counter++;
                    else if (col + 1 <= columnAmount - 2 && field[row][col + 1] == '*')
                        counter++;
                    else if (row + 1 <= rowsAmount - 2 && col - 1 >= 0 && field[row + 1][col] == '*')
                        counter++;
                    else if (row + 1 <= rowsAmount - 2 && field[row + 1][col] == '*')
                        counter++;
                    else if (row + 1 <= rowsAmount - 2 && col + 1 <= columnAmount - 2 && field[row + 1][col + 1] == '*')
                        counter++;

                   result.append(counter);
                }
            }
            result.append("\\n");

        }
        return result.toString();
    }

    private boolean validateString(String field) {
        String[] rows = field.split("\n");
        int rowsAmount = rows.length;
        boolean result = true;
        int rowLength = rows[0].length();
        for (int i = 0; i < rowsAmount; i++) {
            if (rows[i].length() != rowLength || !rows[i].matches("[*.]+"))
                result = false;
        }
        return result;

    }
}




