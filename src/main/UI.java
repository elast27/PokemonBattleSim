package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class UI extends JFrame {
	private static Pokemon p;
	private static Pokemon opponent;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pair<Pokemon, Pokemon> pokes = Engine.setup();
		p = pokes.getFirst();
		opponent = pokes.getSecond();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public UI() {
		createAndShowUI();
	}
	public void createAndShowUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblNewLabel = new JLabel("What will " + p.getName() + " do?");
		lblNewLabel.setBounds(50, 291, 296, 33);
		contentPane.add(lblNewLabel);
		
		JProgressBar hp = new JProgressBar();
		hp.setMaximum((int)p.getStat(Stat.HP));
		hp.setValue(p.getHp());
		hp.setBounds(469, 291, 344, 33);
		hp.setForeground(Color.green);
		hp.setBackground(Color.red);
		contentPane.add(hp);
		
		JLabel lblNewLabel_5 = new JLabel("HP: "+p.getHp()+"/"+p.getStat(Stat.HP));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(660, 270, 153, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("HP: "+opponent.getHp()+"/"+opponent.getStat(Stat.HP));
		lblNewLabel_6.setBounds(10, 10, 153, 20);
		contentPane.add(lblNewLabel_6);
		
		JProgressBar oppHP = new JProgressBar();
		oppHP.setMaximum((int)opponent.getStat(Stat.HP));
		oppHP.setValue(opponent.getHp());
		oppHP.setBounds(10, 30, 344, 33);
		oppHP.setForeground(Color.green);
		oppHP.setBackground(Color.red);
		contentPane.add(oppHP);
		
		JLabel lblNewLabel_7 = new JLabel(opponent.getName());
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(178, 10, 168, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(p.getName());
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(469, 270, 176, 20);
		contentPane.add(lblNewLabel_8);
		
		if(p.getMove(0)!=null) {
			JButton btnNewButton = new JButton(p.getMove(0).getName());
			btnNewButton.setBackground(p.getMove(0).getType().getLabelColor());
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.attack(opponent, p.getMove(0));
					oppHP.setValue(opponent.getHp());
					lblNewLabel_6.setText("HP: "+opponent.getHp()+"/"+opponent.getStat(Stat.HP));
				}
			});
			btnNewButton.setBounds(127, 340, 242, 72);
			contentPane.add(btnNewButton);
			JLabel lblNewLabel_1 = new JLabel(p.getMove(0).getType().getType());
			lblNewLabel_1.setBounds(300, 320, 69, 20);
			btnNewButton.add(lblNewLabel_1);
		}
		
		if(p.getMove(1)!=null) {
			JButton button = new JButton(p.getMove(1).getName());
			button.setBackground(p.getMove(1).getType().getLabelColor());
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.attack(opponent, p.getMove(1));
					oppHP.setValue(opponent.getHp());
					lblNewLabel_6.setText("HP: "+opponent.getHp()+"/"+opponent.getStat(Stat.HP));
				}
			});
			button.setBounds(447, 340, 242, 72);
			contentPane.add(button);
			JLabel lblNewLabel_2 = new JLabel(p.getMove(1).getType().getType());
			lblNewLabel_2.setBounds(620, 320, 69, 20);
			button.add(lblNewLabel_2);
		}
		
		if(p.getMove(3)!=null) {
			JButton button_2 = new JButton(p.getMove(3).getName());
			button_2.setBackground(p.getMove(3).getType().getLabelColor());
			button_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.attack(opponent, p.getMove(3));
					oppHP.setValue(opponent.getHp());
					lblNewLabel_6.setText("HP: "+opponent.getHp()+"/"+opponent.getStat(Stat.HP));
				}
			});
			button_2.setBounds(447, 428, 242, 72);
			contentPane.add(button_2);
			JLabel lblNewLabel_4 = new JLabel(p.getMove(3).getType().getType());
			lblNewLabel_4.setBounds(620, 409, 69, 20);
			button_2.add(lblNewLabel_4);
		}
			
		if(p.getMove(2)!=null) {
			JButton button_1 = new JButton(p.getMove(2).getName());
			button_1.setBackground(p.getMove(2).getType().getLabelColor());
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.attack(opponent, p.getMove(2));
					oppHP.setValue(opponent.getHp());
					lblNewLabel_6.setText("HP: "+opponent.getHp()+"/"+opponent.getStat(Stat.HP));
				}
			});
			button_1.setBounds(127, 428, 242, 72);
			contentPane.add(button_1);
			JLabel lblNewLabel_3 = new JLabel(p.getMove(2).getType().getType());
			lblNewLabel_3.setBounds(300, 409, 69, 20);
			button_1.add(lblNewLabel_3);
		}
	}
}
