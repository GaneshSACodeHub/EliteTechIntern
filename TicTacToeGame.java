import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private boolean playerXTurn = true;

    public TicTacToeGame() {
        setTitle("Tic-Tac-Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        // Initialize buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Times New Roman", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        // Check if the button is already clicked
        if (!clickedButton.getText().equals("")) {
            return;
        }

        // Set "X" or "O" based on the turn
        if (playerXTurn) {
            clickedButton.setText("X");
        } else {
            clickedButton.setText("O");
        }

        // Check for winner
        if (checkWinner()) {
            JOptionPane.showMessageDialog(this,
                    (playerXTurn ? "Player X" : "Player O") + " wins!");
            resetBoard();
            return;
        }

        // Check for draw
        if (isBoardFull()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            resetBoard();
            return;
        }

        // Switch turns
        playerXTurn = !playerXTurn;
    }

    private boolean checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText()) &&
                !buttons[i][0].getText().equals("")) {
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText()) &&
                !buttons[0][i].getText().equals("")) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            !buttons[0][0].getText().equals("")) {
            return true;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()) &&
            !buttons[0][2].getText().equals("")) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        playerXTurn = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToeGame game = new TicTacToeGame();
            game.setVisible(true);
        });
    }
}
