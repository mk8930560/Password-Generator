
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;  
class Password  
{  
	Password()
	{
		
	}
	public static void main(String args[])  
    {  
		//Creating Frame
	    JFrame f= new JFrame("Password Genrator");  
	    
	    //Creating Label
	    JLabel l1=new JLabel("Password Length");  
	    l1.setBounds(10,10,130,30);
	    
	    //Creating TextFiled
	    JTextField tf=new JTextField();
	    tf.setBounds(140,15,100,25);
	    
	    //Creating Label Upper case 
	    JLabel l2=new JLabel("UpperCase (A-Z)");  
	    l2.setBounds(10,40,120,30);
	    
	    //checkBox
	    JCheckBox cbox1=new JCheckBox();
	    cbox1.setBounds(135,45,20,20);

	    
	    //Creating Label Lower case 
	    JLabel l3=new JLabel("LowerCase (a-z)");  
	    l3.setBounds(10,70,120,30);
	    
	    //checkBox
	    JCheckBox cbox2=new JCheckBox();
	    cbox2.setBounds(135,75,20,20);

	    
	    //Creating Label Number
	    JLabel l4=new JLabel("Numbers (0-9)");  
	    l4.setBounds(10,100,120,30);
	    
	    //checkBox
	    JCheckBox cbox3=new JCheckBox();
	    cbox3.setBounds(135,105,20,20);

	    
	    //Creating Label Special Symbols
	    JLabel l5=new JLabel("Symbols (@#$%)");  
	    l5.setBounds(10,130,120,30);
	    
	    //checkBox
	    JCheckBox cbox4=new JCheckBox();
	    cbox4.setBounds(135,135,20,20);
	    
	    //Creating Label Output
	    JLabel l6=new JLabel("Output Password");  
	    l6.setBounds(10,165,130,30);
	    
	    //Creating TextFiled
	    JTextField tf1=new JTextField();
	    tf1.setBounds(140,170,100,25);
	    
	    //Image fetching from image  
	    JButton b1=new JButton("copy");
	    b1.setBounds(244,170,39,25);
	    b1.setMargin(new Insets(0,0,0,0));
	    
	    JButton b2=new JButton("Generate");
	    b2.setBounds(140,210,100,30);
	    b2.setMargin(new Insets(0,0,0,0));
	    
	    f.add(b2);
	    f.add(b1);
	    f.add(cbox4);
	    f.add(cbox3);
	    f.add(cbox2);
	    f.add(cbox1);
	    f.add(l5);
	    f.add(l6);
	    f.add(l4);
	    f.add(l2);
	    f.add(l3);
	    f.add(tf);
	    f.add(tf1);
	    f.add(l1);  
	    f.setSize(400,300);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Password p=new Password();
	    
	    //for copying the content of the output password
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		StringSelection stringSelection = new StringSelection (tf1.getText());
	    	    Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
	    	    clpbrd.setContents (stringSelection, null);
	    	}
	    });
	    
	    //Algorithm
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    	    String len=tf.getText();
	    	    int num;
	    	    if(len.equals(""))
	    	    {
	    	    	num=0;
	    	    }
	    	    else
	    	    {
	    	    	num=Integer.parseInt(len);
	    	    }
	    	    
	    	    String Capital_chars; 
	    	    String Small_chars;
	    	    String numbers;
	    	    String symbols;
	    	    if(cbox1.isSelected()){
	    	    	Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";             
	    	    }
	    	    else{
	    	    	Capital_chars="";
	    	    }
	    	    if(cbox2.isSelected()){
	    	    	Small_chars = "abcdefghijklmnopqrstuvwxyz";
	    	    }
	    	    else{
	    	    	Small_chars="";
	    	    }
	    	    if(cbox3.isSelected()){
	    	    	numbers = "0123456789";
	    	    }
	    	    else{
	    	    	numbers="";
	    	    }
	    	    if(cbox4.isSelected()){
	    	    	symbols = "!@#$%^&*_=+-/.?<>)";
	    	    }
	    	    else{
	    	    	symbols="";
	    	    }
	    	    
	    	    String values = Capital_chars + Small_chars + numbers + symbols;
	    	    if(num==0){
	    	    	JFrame dialog=new JFrame();
					JOptionPane.showMessageDialog(dialog,"Please Enter Password Length");
					tf1.setText("");
	    	    }
	    	    if(values.equals("")){
					JFrame dialog1=new JFrame();
					JOptionPane.showMessageDialog(dialog1,"Please check any CheckBox");
					tf1.setText("");
				}

	    	    else{
	    	    	Random rndm_method = new Random();
	    	    	char[] password = new char[num];
	    	    	for (int i = 0; i < num; i++){ 
	    	    		password[i] = values.charAt(rndm_method.nextInt(values.length())); 
	    	    	}
	    	    	String out = String.valueOf(password);
	    	    	tf1.setText(out);	
	    	    } 
	    	}
	    });
    }  
}  
