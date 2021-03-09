import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
public class Program {

	private JFrame frmCalculator;
	private JTextField val1;
	private JTextField val2;
	
	GraphicsDevice gDevice;
	int currentScreenW, currentScreenH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	
	private void initialize() {
		
		GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gDevice = gEnvironment.getDefaultScreenDevice();
		
		currentScreenW = 380;
		currentScreenH = 357;
		
		int tnp_x = (int) Math.round(currentScreenW * 0.015789473684211);
		int tnp_y = (int) Math.round(currentScreenH * 0.089635854341737);
		int tnp_w = (int) Math.round(currentScreenW * 0.968421052631579);
		int tnp_h = (int) Math.round(currentScreenH * 0.112044817927171);
		
		
		
		frmCalculator = new JFrame();
		frmCalculator.setResizable(false);
		frmCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/dhairyadodia/Downloads/icon.jpg"));
		frmCalculator.setTitle("Calculator");
		frmCalculator.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmCalculator.getContentPane().setBackground(Color.BLACK);
		frmCalculator.setBounds(100, 100, currentScreenW, currentScreenH );
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		//records the signs
	    JLabel recorder = new JLabel("");
		recorder.setBounds(16, 321, 6, 8);
		frmCalculator.getContentPane().add(recorder);
		
		//Text Fields
		val1 = new JTextField();
		val1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String value = val1.getText();
	            
	            if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')  || e.getKeyChar() == '-' || e.getKeyChar() == '+' || 
	            	e.getKeyChar() == '*' || e.getKeyChar() == '/' || e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SHIFT) {
	                
	            	
	            	if (e.getKeyChar() == '+') {
	                	val2.setText(val1.getText());
	                	val1.setText("");  
	                	recorder.setText("add"); 	
	                	
	                }
	                
	                if (e.getKeyChar() == '-') {
	                	val2.setText(val1.getText());
	                	val1.setText("");
	                	recorder.setText("sub");
	                }
	                
	                if (e.getKeyChar() == '/') {
	                	val2.setText(val1.getText());
	                	val1.setText("");
	                	recorder.setText("div");
	                }
	                
	                if (e.getKeyChar() == '*') {
	                	val2.setText(val1.getText());
	                	val1.setText("");
	                	recorder.setText("times");
	                }
	               
	                
	               
	                
	                
	                
	                if(e.getKeyCode() == KeyEvent.VK_ENTER ) {

	                	double num2;
	                	double num1 = Double.parseDouble(val2.getText());
	                	if(val1.getText().substring(0,1).equals("-")) {
	       				 num2 = Double.parseDouble(val1.getText());
	       				}
	       				else {
	       				 num2 = Double.parseDouble(val1.getText().substring(1));
	       				}
	                	
	                	
	    				
	    				
	    				
	    				
                        
	    				
	    			  
	    				if(recorder.getText().equals("add")) {
	    					double add = num1 + num2;
	    					val2.setText(String.valueOf(add));
	    					
	    				}
	    				
	    				if(recorder.getText().equals("sub")) {
	    					
	    					double sub = num1 - (num2 * -1);
	    					val2.setText(String.valueOf(sub));
	    					
	    				}
	    				
	    				
	    				
	    				if(recorder.getText().equals("div")) {
	    					double div = num1 / num2;
	    					val2.setText(String.valueOf(div));
	    				}
	    				
	    				if(recorder.getText().equals("times")) {
	    					double times = num1 * num2;
	    					val2.setText(String.valueOf(times));
	    					
	    				
	    				}
	    				val1.setText("");
	                	
	                }
	                
	                
	            	
	            	val1.setEditable(true);
	               
	            } else {
	               val1.setEditable(false);
	               val1.setText("");
	            }
			}
			
		});
		
		val1.setFont(new Font("Courier", Font.PLAIN, 25));
		val1.setHorizontalAlignment(SwingConstants.RIGHT);
		val1.setBorder(null);
		val1.setBounds(tnp_x, tnp_y, tnp_w, tnp_h);
		frmCalculator.getContentPane().add(val1);
		val1.setColumns(10);
		
		int val2x = (int) Math.round (currentScreenW * 0.015789473684211);
		int val2y = (int) Math.round (currentScreenH * 0.019607843137255);
		int val2w = (int) Math.round (currentScreenW * 0.968421052631579);
		int val2h = (int) Math.round (currentScreenH * 0.084033613445378);
		int valfont = (int) Math.round(currentScreenH * 0.039473684210526);
		
		
		val2 = new JTextField();
		val2.setEnabled(false);
		val2.setEditable(false);
		val2.setHorizontalAlignment(SwingConstants.RIGHT);
		val2.setFont(new Font("Courier New", Font.PLAIN, valfont));
		val2.setBorder(null);
		val2.setColumns(10);
		val2.setBounds(val2x, val2y, val2w, val2h);
		frmCalculator.getContentPane().add(val2);
		
		
		//Numbers 
		
		int btn0x = (int) Math.round (currentScreenW * 0.015789473684211);
		int btn0y = (int) Math.round (currentScreenH * 0.761904761904762);
		int btnw = (int) Math.round (currentScreenW * 0.310526315789474);
		int btn0h = (int) Math.round (currentScreenH * 0.084033613445378);
		int btn0font = (int) Math.round(currentScreenH * 0.142857142857143);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(UIManager.getFont("CheckBox.font"));
		
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 0);
			}
		});
		
		btn0.setBounds(6, 272, 118, 51);
		frmCalculator.getContentPane().add(btn0);
		
		
		
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 1);
			}
		});
		btn1.setBounds(6, 210, 53, 51);
		frmCalculator.getContentPane().add(btn1);
		
		
		
		
		
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 2);
			}
		});
		btn2.setBounds(71, 210, 53, 51);
		frmCalculator.getContentPane().add(btn2);
		
		
		
		
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 3);
			}
		});
		btn3.setBounds(136, 210, 53, 51);
		frmCalculator.getContentPane().add(btn3);
		
		
		
		
		
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 4);
			}
		});
		
		btn4.setBounds(6, 147, 53, 51);
		frmCalculator.getContentPane().add(btn4);
		
		
		
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText()+5);
			}
		});
		btn5.setBounds(71, 147, 53, 51);
		frmCalculator.getContentPane().add(btn5);
		
		
		
		
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 6);
			}
		});
		btn6.setBounds(136, 147, 53, 51);
		frmCalculator.getContentPane().add(btn6);
		
		
		
		
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 7);
			}
		});
		btn7.setBounds(6, 84, 53, 51);
		frmCalculator.getContentPane().add(btn7);
		
		
		
		
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 8);
				}
		});
		btn8.setBounds(71, 84, 53, 51);
		frmCalculator.getContentPane().add(btn8);
		
		
		
		
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + 9);
				}
		});
		btn9.setBounds(136, 84, 53, 51);
		frmCalculator.getContentPane().add(btn9);
		
		
		
		
		
		
		//Signs
		
		JButton btnadd = new JButton("+");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    val2.setText(val1.getText());
			    val1.setText("");
			    recorder.setText("add");
			}
		});
		btnadd.setBounds(201, 147, 79, 51);
		frmCalculator.getContentPane().add(btnadd);
		
		
		
		
		
		JButton btndiv = new JButton("/");
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    val2.setText(val1.getText());
			    val1.setText("");
			    recorder.setText("div");
			}
		});
		btndiv.setBounds(201, 210, 79, 51);
		frmCalculator.getContentPane().add(btndiv);
		
		
		
		
		
		
		
		JButton btnsub = new JButton("-");
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    val2.setText(val1.getText());
			    val1.setText("");
			    recorder.setText("sub");
			}
		});
		btnsub.setBounds(292, 147, 79, 51);
		frmCalculator.getContentPane().add(btnsub);
		
		
		
		
		
		JButton btntimes = new JButton("*");
		btntimes.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btntimes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    val2.setText(val1.getText());
			    val1.setText("");
			    recorder.setText("times");
			}
		});
		btntimes.setBounds(292, 210, 79, 51);
		frmCalculator.getContentPane().add(btntimes);
		
		
		
		
		
		JButton btndec = new JButton(".");
		btndec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				val1.setText(val1.getText() + '.');	
			}
		});
	    
		btndec.setBounds(136, 272, 53, 51);
		frmCalculator.getContentPane().add(btndec);
		
		
		
		//Clear All
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    val2.setText("");
			    val1.setText("");
			    
			}
		});
		btnC.setBounds(292, 84, 79, 51);
		frmCalculator.getContentPane().add(btnC);
		
		
		
		
		JButton btnAC = new JButton("AC");
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
			    val1.setText("");
			    
			}
		});
		btnAC.setBounds(201, 84, 79, 51);
		frmCalculator.getContentPane().add(btnAC);
		
		
		//Equal equations
		JButton btneq = new JButton("=");
				
			
			
		btneq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(val2.getText());
				double num2;
				
				 num2 = Double.parseDouble(val1.getText());
				
				
			 
				if(recorder.getText().equals("add")) {
					double add = num1 + num2;
					val2.setText(String.valueOf(add));
				}
				
				if(recorder.getText().equals("sub")) {
					double sub = num1 - num2;
					val2.setText(String.valueOf(sub));
				}
				
				if(recorder.getText().equals("div")) {
					double div = num1 / num2;
					val2.setText(String.valueOf(div));
				}
				
				if(recorder.getText().equals("times")) {
					double times = num1 * num2;
					val2.setText(String.valueOf(times));
				
				}
				
			}
		});
		btneq.setBounds(292, 272, 79, 51);
		frmCalculator.getContentPane().add(btneq);
		
		
		
		
		
		JButton btnneg = new JButton("(-)");
		btnneg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
			    val1.setText("-");
			    
			}
		});
		
		btnneg.setBounds(201, 272, 79, 51);
		frmCalculator.getContentPane().add(btnneg);
		
		
		setFullScreen();
		
		
	}
	
	public void createFont() {
		
	}
	public void setFullScreen() {
		//gDevice.setFullScreenWindow(frmCalculator);
	}
}
