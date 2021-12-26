package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class UI extends JFrame {
	private static Pokemon p;
	private static Pokemon opponent;
	private static AI AI;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Pair<Pokemon, Pokemon> pokes = Engine.setup();
		p = pokes.getFirst();
		opponent = pokes.getSecond();
		AI = new AI(opponent);
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
		
		JLabel lblNewLabel_7 = new JLabel(opponent.getName()+" Lv."+opponent.getLvl());
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(178, 10, 168, 20);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(p.getName()+ " Lv."+p.getLvl());
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(469, 270, 176, 20);
		contentPane.add(lblNewLabel_8);
		
		if(p.getMove(0)!=null) {
			JButton move1Button = new JButton(p.getMove(0).getName());
			move1Button.setBackground(p.getMove(0).getType().getLabelColor());
			move1Button.setForeground(Color.white);
			move1Button.setName("0");
			move1Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectMove(e);
				}
			});
			move1Button.setBounds(127, 340, 242, 72);
			contentPane.add(move1Button);
			JLabel lblNewLabel_1 = new JLabel(p.getMove(0).getType().getType());
			lblNewLabel_1.setBounds(300, 320, 69, 20);
			lblNewLabel_1.setForeground(Color.white);
			move1Button.add(lblNewLabel_1);
		}
		
		if(p.getMove(1)!=null) {
			JButton move2Button = new JButton(p.getMove(1).getName());
			move2Button.setBackground(p.getMove(1).getType().getLabelColor());
			move2Button.setForeground(Color.white);
			move2Button.setName("1");
			move2Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectMove(e);
				}
			});
			move2Button.setBounds(447, 340, 242, 72);
			contentPane.add(move2Button);
			JLabel lblNewLabel_2 = new JLabel(p.getMove(1).getType().getType());
			lblNewLabel_2.setBounds(620, 320, 69, 20);
			lblNewLabel_2.setForeground(Color.white);
			move2Button.add(lblNewLabel_2);
		}
			
		if(p.getMove(2)!=null) {
			JButton move3Button = new JButton(p.getMove(2).getName());
			move3Button.setBackground(p.getMove(2).getType().getLabelColor());
			move3Button.setForeground(Color.white);
			move3Button.setName("2");
			move3Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectMove(e);
				}
			});
			move3Button.setBounds(127, 428, 242, 72);
			contentPane.add(move3Button);
			JLabel lblNewLabel_3 = new JLabel(p.getMove(2).getType().getType());
			lblNewLabel_3.setBounds(300, 409, 69, 20);
			lblNewLabel_3.setForeground(Color.white);
			move3Button.add(lblNewLabel_3);
		}
		
		if(p.getMove(3)!=null) {
			JButton move4Button = new JButton(p.getMove(3).getName());
			move4Button.setBackground(p.getMove(3).getType().getLabelColor());
			move4Button.setForeground(Color.white);
			move4Button.setName("3");
			move4Button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectMove(e);
				}
			});
			move4Button.setBounds(447, 428, 242, 72);
			contentPane.add(move4Button);
			JLabel lblNewLabel_4 = new JLabel(p.getMove(3).getType().getType());
			lblNewLabel_4.setBounds(620, 409, 69, 20);
			lblNewLabel_4.setForeground(Color.white);
			move4Button.add(lblNewLabel_4);
		}
	}
	
	public void selectMove(MouseEvent e) {
		BattleUtils.battleTurn(p, p.getMove(Integer.parseInt(e.getComponent().getName())), AI.getPokemon(), AI.pickMove(p));
		//USER HEALTH
		JProgressBar pc1 = (JProgressBar)contentPane.getComponent(1);
		pc1.setValue(p.getHp());
		JLabel pc2 = (JLabel)contentPane.getComponent(2);
		pc2.setText(p.getHp() + "/" + p.getStat(Stat.HP));
		//OPP HEALTH
		JLabel po1 = (JLabel)contentPane.getComponent(3);
		po1.setText(opponent.getHp() + "/" + opponent.getStat(Stat.HP));
		JProgressBar po2 = (JProgressBar)contentPane.getComponent(4);
		po2.setValue(opponent.getHp());
	}
}
