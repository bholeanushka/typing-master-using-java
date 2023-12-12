import java.io.*;
import java.awt.*;
//import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


class Home extends JFrame{
	String []s ={"          Tutorial No 1          ","          Tutorial No 2          ","          Tutorial No 3          ","          Tutorial No 4          ",
				 "          Tutorial No 5          ","          Tutorial No 6          ","          Tutorial No 7          ","          Tutorial No 8          ",
				 "          Tutorial No 9          ","          Tutorial No 10          "};
	JButton before1,b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,dash,equalto,backspace,tab,Q,W,E,R,T,Y,U,I,O,P,opensqbkt,closesqbkt,bkslash,capslock,A,S,D,F,G,H,J,K,L,semicol,singlein,enter,
			shiftl,Z,X,C,V,B,N,M,comma,fullstop,fwslash,shiftr,ctrll,windowsys,altl,space,altr,file,ctrlr;
	String [] rowchar = {"`","1","2","3","4","5","6","7","8","9","0","-","=","backspace","tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\","caps lock",
						 "A","S","D","F","G","H","J","K","L",";","'","enter","shiftl","Z","X","C","V","B","N","M",",",".","/","shiftr","ctrll","windowsys.png",
			   		 	 "altl","space","altr","fileimg.png","ctrlr"};
	String []tutorial1 = {"A","S","D","F","32","59","L","K","J","32"};							//32=keycode of spacebar, 59=keycode of semicolon
	String []tutorial2 = {"A","S","D","F","G","F","32","59","L","K","J","H","J","32"};
	String []tutorial3 = {"A","S","D","F","G","L","K","J","H","32","59"};
	String []tutorial4 = {"Q","W","E","R","T","32","P","O","I","U","Y","32"};
	String []tutorial5 = {"A","S","D","F","G","L","K","J","H","Q","W","E","R","T","P","O","I","U","Y","32","59"};
	String []tutorial6 = {"Z","X","C","V","32",",","M","N","B","32"};
	String []tutorial7 = {"A","S","D","F","G","L","K","J","H","Q","W","E","R","T","P","O","I","U","Y","Z","X","C","V","M","N","B","44","32","59"};	//44=keycode of comma
	String []tutorial8 = {"1","2","3","4","5","32","0","9","8","7","6","32"};
	JButton []bref=new JButton[60];
	JPanel pc1 = new JPanel();   //for learning page
	JPanel pc2 = new JPanel();   //for practicing page
	JPanel pc3 = new JPanel();   //for home page buttons
	JPanel p = new JPanel();

	CardLayout cl = new CardLayout();

	Home(){
		setTitle("Typing Learner");
		setSize(1700,1000);

		//setting layout of at center of frame
		p.setLayout(cl);
		add(p);

		//adding cards on center panel and setting their layouts
		pc1.setLayout(new BorderLayout(10,10));
		pc2.setLayout(new BorderLayout(10,10));
		p.add("Home",pc3);
		p.add("Learning",pc1);
		p.add("Practice",pc2);

		//adding panel at center of frame and adding buttons on it
		pc3.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(30,30,20,20);
		gbc.gridx=0;
		gbc.gridy=0;
		EventHandler ev = new EventHandler();
		for(int i=1;i<=10;i++){
			//JPanel jp = new JPanel();
			JButton b = new JButton("          Tutorial No "+i+"          ");
			b.setFont(new Font("Brush Script MT",Font.PLAIN,22));
			b.addActionListener(ev);
			//jp.add(b);
			//pc3.add(jp);
			pc3.add(b,gbc);
			gbc.gridy+=1;

		}
		//add(pc3,"Center");

		//creating menu
		JMenuBar mb = new JMenuBar();
		JMenu about = new JMenu("About");
		//JMenu exit = new JMenu("Exit");
		about.setFont(new Font("Brush Script MT",Font.PLAIN,22));
		//exit.setFont(new Font("Brush Script MT",Font.PLAIN,22));
		mb.add(about);
		//mb.add(exit);
		setJMenuBar(mb);
		about.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				/*JFrame g = new JFrame();
				g.setVisible(true);
				g.setSize(500,500);*/
				String info = "HI!! \n This is project by  CO5I students named \n TANUJ \n ANUSHKA \n KALPESH \n KAUSTUBH";
				JOptionPane.showMessageDialog(new Home(),info,"About",JOptionPane.INFORMATION_MESSAGE);
			}
			public void menuCanceled(MenuEvent s){}
			public void menuDeselected(MenuEvent e){}
		});

		/*creating panel in north section of frame
		*/

		//creating panel in south of frame
		JLabel south = new JLabel("<html><h2>Improve Your Typing Speed With TypingLearner</h2></html>",JLabel.CENTER);
		south.setFont(new Font("Brush Script MT",Font.PLAIN,48));
		add(south,"South");

	}

	//Event Handling Class
	class EventHandler extends KeyAdapter implements ActionListener{
		JPanel center = new JPanel();
		JPanel center1 = new JPanel();
		JPanel pj1 = new JPanel();
		JPanel pj2 = new JPanel();
		JPanel pj3 = new JPanel();
		JPanel pj4 = new JPanel();
		JButton prev = new JButton("Prev");
		String tutorialno;
		//String [] tutorial1 = {"a","s","d","f",";","l","k","j"};

		//eventhandling of all buttons in program and setting the concurrent pages on the event
		public void actionPerformed(ActionEvent e){
			Object ref = e.getSource();
			String str = e.getActionCommand();
			for(String st : s){
				if(st.equals(str)){
					tutorialno = str.trim();
					String image=(st.trim())+".jpeg";

					cl.next(p);
					center.setLayout(new GridLayout(2,1));
					pj2.setLayout(new BorderLayout());
					JLabel label = new JLabel(new ImageIcon(image));						//adding label to the upper panel of the frame added in center section
					pc1.add(center);
					pj1.add(label);
					center.add(pj1);
					center.add(pj2);


					//Taking the relevant file of data for learning
					str = (str.trim())+".txt";
					try{
						FileInputStream stream = new FileInputStream(str);
						int x = stream.read();
						String note = "";
						while(x!=-1){
							note += (char)x;
							x = stream.read();
						}
						JTextArea ta = new JTextArea(note);
						JScrollPane sp1 = new JScrollPane(ta);
						ta.setFont(new Font("Times New Roman",Font.PLAIN,22));
						ta.setEditable(false);
						pj2.add(sp1);
						stream.close();
					}
					catch(IOException io){
						System.out.print(io);
					}


					//adding previous and next button on the second card
					JPanel north = new JPanel();
					JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT));
					JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
					JButton next = new JButton("Next");
					north.setLayout(new GridLayout(1,2));
					prev.setFont(new Font("Brush Script MT",Font.PLAIN,22));
					next.setFont(new Font("Brush Script MT",Font.PLAIN,22));
					prev.setBackground(Color.cyan);
					next.setBackground(Color.cyan);
					prev.addActionListener(this);
					next.addActionListener(this);
					left.add(prev);
					right.add(next);
					north.add(left);
					north.add(right);
					pc1.add(north,"North");

				}
			}
			if(str.equals("Next")){
				//setting the third page format and adding component on it
				cl.show(p,"Practice");
				pj3.setLayout(new BorderLayout());
				center1.setLayout(new GridLayout(2,1));
				JPanel one = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JButton pb = new JButton("Prev");
				pb.setFont(new Font("Brush Script MT",Font.PLAIN,22));
				pb.setBackground(Color.cyan);
				pb.addActionListener(this);
				one.add(pb);
				pc2.add(one,"North");
				pc2.add(center1);
				center1.add(pj3);
				center1.add(pj4);
				JTextArea prac = new JTextArea("Type Here And Practice");
				prac.setLineWrap(true);
				prac.addKeyListener(this);
				JScrollPane scrollprac = new JScrollPane(prac);
				prac.setFont(new Font("Times New Roman",Font.PLAIN,22));
				pj3.add(scrollprac);
				//System.out.println("next button is clicked");

				//adding keyboard on bottompanel of page3
				pj4.setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.HORIZONTAL;
				/*
				String [] rowchar = {"`","1","2","3","4","5","6","7","8","9","0","-","=","backspace","tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\","caps lock",
										"A","S","D","F","G","H","J","K","L",";","'","enter","shiftl","Z","X","C","V","B","N","M",",",".","/","shiftr","ctrll","windowsys.png",
										"altl","space","altr","fileimg.png","ctrlr"};
				*/
				//String [] upperrow ={"Q","W","E","R","T","Y","U","I","O","P","[","]","\\"};
				//String [] homerow = {"A","S","D","F","G","H","J","K","L",";","'"};
				//String [] bottomrow = {"Z","X","C","V","B","N","M",",",".","/"};
				int i=0;
				//int j=0;
				c.insets = new Insets(20,10,0,0);
				c.gridx = 0;
				c.gridy = 0;
				c.ipadx = 20;
				c.ipady = 20;
				/*for(int x=0;x<.length;x++){
					c.gridx = x;
					pj4.add(new JButton([i]),c);
					i+=1;
				}*/
				//numberrow placing
				before1 = new JButton(rowchar[i]);
				bref[i]=before1;
				pj4.add(before1,c);
				i+=1;
				c.gridx = 1;
					b1 = new JButton(rowchar[i]);
					bref[i]=b1;
					pj4.add(b1,c);
				i+=1;
				c.gridx = 2;
					b2 = new JButton(rowchar[i]);
					bref[i]=b2;
					pj4.add(b2,c);
				i+=1;
				c.gridx = 3;
					b3= new JButton(rowchar[i]);
					bref[i]=b3;
					pj4.add(b3,c);
				i+=1;
				c.gridx = 4;
					b4 = new JButton(rowchar[i]);
					bref[i]=b4;
					pj4.add(b4,c);
				i+=1;
				c.gridx = 5;
					b5 = new JButton(rowchar[i]);
					bref[i]=b5;
					pj4.add(b5,c);
				i+=1;
				c.gridx = 6;
					b6 = new JButton(rowchar[i]);
					bref[i]=b6;
					pj4.add(b6,c);
				i+=1;
				c.gridx = 7;
					b7 = new JButton(rowchar[i]);
					bref[i]=b7;
					pj4.add(b7,c);
				i+=1;
				c.gridx = 8;
					b8 = new JButton(rowchar[i]);
					bref[i]=b8;
					pj4.add(b8,c);
				i+=1;
				c.gridx = 9;
					b9 = new JButton(rowchar[i]);
					bref[i]=b9;
					pj4.add(b9,c);
				i+=1;
				c.gridx = 10;
					b0 = new JButton(rowchar[i]);
					bref[i]=b0;
					pj4.add(b0,c);
				i+=1;
				c.gridx = 11;
					dash = new JButton(rowchar[i]);
					bref[i]=dash;
					pj4.add(dash,c);
				i+=1;
				c.gridx = 12;
					equalto = new JButton(rowchar[i]);
					bref[i]=equalto;
					pj4.add(equalto,c);
				i+=1;
				c.gridx = 13;
				c.gridwidth = 2;
					backspace = new JButton(rowchar[i]);
					bref[i]=backspace;
					pj4.add(backspace,c);
				i+=1;

				//upperrow placing
				c.gridwidth = 1;
				c.gridx = 0;
				c.gridy = 1;
				c.ipadx = 40;
				tab = new JButton(rowchar[i]);
				bref[i]=tab;
				pj4.add(tab,c);
				c.ipadx=20;
				i+=1;
				c.gridx = 1;
					Q = new JButton(rowchar[i]);
					bref[i]=Q;
					pj4.add(Q,c);
				i+=1;
				c.gridx = 2;
					W = new JButton(rowchar[i]);
					bref[i]=W;
					pj4.add(W,c);
				i+=1;
				c.gridx = 3;
					E = new JButton(rowchar[i]);
					bref[i]=E;
					pj4.add(E,c);
				i+=1;
				c.gridx = 4;
					R = new JButton(rowchar[i]);
					bref[i]=R;
					pj4.add(R,c);
				i+=1;
				c.gridx = 5;
					T = new JButton(rowchar[i]);
					bref[i]=T;
					pj4.add(T,c);
				i+=1;
				c.gridx = 6;
					Y = new JButton(rowchar[i]);
					bref[i]=Y;
					pj4.add(Y,c);
				i+=1;
				c.gridx = 7;
					U = new JButton(rowchar[i]);
					bref[i]=U;
					pj4.add(U,c);
				i+=1;
				c.gridx = 8;
					I = new JButton(rowchar[i]);
					bref[i]=I;
					pj4.add(I,c);
				i+=1;
				c.gridx = 9;
					O = new JButton(rowchar[i]);
					bref[i]=O;
					pj4.add(O,c);
				i+=1;
				c.gridx = 10;
					P = new JButton(rowchar[i]);
					bref[i]=P;
					pj4.add(P,c);
				i+=1;
				c.gridx = 11;
					opensqbkt = new JButton(rowchar[i]);
					bref[i]=opensqbkt;
					pj4.add(opensqbkt,c);
				i+=1;
				c.gridx = 12;
					closesqbkt = new JButton(rowchar[i]);
					bref[i]=closesqbkt;
					pj4.add(closesqbkt,c);
				i+=1;
				c.gridx = 13;
					bkslash = new JButton(rowchar[i]);
					bref[i]=bkslash;
					pj4.add(bkslash,c);
				i+=1;
				c.gridx = 14;
				pj4.add(new JButton(" "),c);

				//homerow placing
				c.gridx = 0;
				c.gridy = 2;
				c.ipadx = 50;
				c.gridwidth=2;
				capslock = new JButton(rowchar[i]);
				bref[i]=capslock;
				pj4.add(capslock,c);
				i+=1;
				c.gridwidth=1;
				c.ipadx = 20;
				c.gridx = 2;
					A = new JButton(rowchar[i]);
					bref[i]=A;
					pj4.add(A,c);
				i+=1;
				c.gridx = 3;
					S = new JButton(rowchar[i]);
					bref[i]=S;
					pj4.add(S,c);
				i+=1;
				c.gridx = 4;
					D = new JButton(rowchar[i]);
					bref[i]=D;
					pj4.add(D,c);
				i+=1;
				c.gridx = 5;
					F = new JButton(rowchar[i]);
					bref[i]=F;
					pj4.add(F,c);
				i+=1;
				c.gridx = 6;
					G = new JButton(rowchar[i]);
					bref[i]=G;
					pj4.add(G,c);
				i+=1;
				c.gridx = 7;
					H = new JButton(rowchar[i]);
					bref[i]=H;
					pj4.add(H,c);
				i+=1;
				c.gridx = 8;
					J = new JButton(rowchar[i]);
					bref[i]=J;
					pj4.add(J,c);
				i+=1;
				c.gridx = 9;
					K = new JButton(rowchar[i]);
					bref[i]=K;
					pj4.add(K,c);
				i+=1;
				c.gridx = 10;
					L = new JButton(rowchar[i]);
					bref[i]=L;
					pj4.add(L,c);
				i+=1;
				c.gridx = 11;
					semicol = new JButton(rowchar[i]);
					bref[i]=semicol;
					pj4.add(semicol,c);
				i+=1;
				c.gridx = 12;
					singlein = new JButton(rowchar[i]);
					bref[i]=singlein;
					pj4.add(singlein,c);
				i+=1;
				c.gridx = 13;
				c.gridwidth = 2;
					enter = new JButton(rowchar[i]);
					bref[i]=enter;
					pj4.add(enter,c);
				i+=1;

				//downrow placing
				c.gridx = 0;
				c.gridy = 3;
				c.gridwidth = 3;
				shiftl = new JButton(rowchar[i]);
				bref[i]=shiftl;
				pj4.add(shiftl,c);
				i+=1;
				c.gridwidth=1;
				c.ipadx = 20;
				c.gridx = 3;
					Z = new JButton(rowchar[i]);
					bref[i]=Z;
					pj4.add(Z,c);
				i+=1;
				c.gridx = 4;
					X = new JButton(rowchar[i]);
					bref[i]=X;
					pj4.add(X,c);
				i+=1;
				c.gridx = 5;
					C = new JButton(rowchar[i]);
					bref[i]=C;
					pj4.add(C,c);
				i+=1;
				c.gridx = 6;
					V = new JButton(rowchar[i]);
					bref[i]=V;
					pj4.add(V,c);
				i+=1;
				c.gridx = 7;
					B = new JButton(rowchar[i]);
					bref[i]=B;
					pj4.add(B,c);
				i+=1;
				c.gridx = 8;
					N = new JButton(rowchar[i]);
					bref[i]=N;
					pj4.add(N,c);
				i+=1;
				c.gridx = 9;
					M = new JButton(rowchar[i]);
					bref[i]=M;
					pj4.add(M,c);
				i+=1;
				c.gridx = 10;
					comma = new JButton(rowchar[i]);
					bref[i]=comma;
					pj4.add(comma,c);
				i+=1;
				c.gridx = 11;
					fullstop = new JButton(rowchar[i]);
					bref[i]=fullstop;
					pj4.add(fullstop,c);
				i+=1;
				c.gridx = 12;
					fwslash = new JButton(rowchar[i]);
					bref[i]=fwslash;
					pj4.add(fwslash,c);
				i+=1;
				c.gridx = 13;
				c.gridwidth = 2;
					shiftr = new JButton(rowchar[i]);
					bref[i]=shiftr;
					pj4.add(shiftr,c);
				i+=1;

				//setting system keys row
				c.gridx = 0;
				c.gridy = 4;
				c.gridwidth = 1;
					ctrll = new JButton(rowchar[i]);
					bref[i]=ctrll;
					pj4.add(ctrll,c);
				i+=1;
				c.gridx = 1;
					windowsys = new JButton(new ImageIcon(rowchar[i]));
					bref[i]=windowsys;
					pj4.add(windowsys,c);
				i+=1;
				c.gridx = 2;
					altl = new JButton(rowchar[i]);
					bref[i]=altl;
					pj4.add(altl,c);
				i+=1;
				c.gridx = 3;
				c.gridwidth = 9;
					space = new JButton(rowchar[i]);
					bref[i]=space;
					pj4.add(space,c);
				i+=1;
				c.gridx = 12;
				c.gridwidth = 1;
					altr = new JButton(rowchar[i]);
					bref[i]=altr;
					pj4.add(altr,c);
				i+=1;
				c.gridx = 13;
					file = new JButton(new ImageIcon(rowchar[i]));
					bref[i]=file;
					pj4.add(file,c);
				i+=1;
				c.gridx = 14;
					ctrlr = new JButton(rowchar[i]);
					bref[i]=ctrlr;
				pj4.add(ctrlr,c);
			}

			if(str.equals("Prev")){
				cl.show(p,"Learning");
				pc2.removeAll();
				center1.removeAll();
				pj3.removeAll();
				pj4.removeAll();

			}
			if(ref == prev){
				cl.show(p,"Home");
				pc1.removeAll();
				center.removeAll();
				pj1.removeAll();
				pj2.removeAll();
			}
		}
		int count=0,countw=0,tem=0,check=-1;
		String che="myteam";

		public void keyPressed(KeyEvent ke){
			Color clr = bref[28].getBackground();
			//String temarray = tutorial7.toString();
			char key = ke.getKeyChar();
			int code = ke.getKeyCode();
			String skey = ""+key;
			try{
				//Tutorial1 logic
				if(tutorialno.equals("Tutorial No 1")){
					if(skey.equalsIgnoreCase(tutorial1[count])||code==Integer.parseInt(tutorial1[count])){			//32=keycode of spacebar, 59=keycode of semicolon
						for(int index=0;index<rowchar.length;index++){
							if(skey.equalsIgnoreCase(rowchar[index])){
								bref[index].setBackground(Color.green);
								count++;
								space.setBackground(clr);
								semicol.setBackground(clr);
								if(count>=0){
									bref[index-1].setBackground(clr);
									bref[index+1].setBackground(clr);

								}
							}
						}
						if(code==32){																				//32=keycode of spacebar
							space.setBackground(Color.green);
							F.setBackground(clr);
							count++;
						}
						if(code==59){																				//59=keycode of semicolon
							semicol.setBackground(Color.green);
							//count++;
						}
					}
					else
						throw new NumberFormatException();
					if(count==tutorial1.length){
						count=0;
						J.setBackground(clr);
					}
				}

				//Tutorial2 logic
				if(tutorialno.equals("Tutorial No 2")){
					if(skey.equalsIgnoreCase(tutorial2[count])||code==Integer.parseInt(tutorial2[count])){			//32=keycode of spacebar, 59=keycode of semicolon
						for(int index=0;index<rowchar.length;index++){
							if(skey.equalsIgnoreCase(rowchar[index])){
								bref[index].setBackground(Color.green);
								count++;
								space.setBackground(clr);
								semicol.setBackground(clr);
								if(count>=0){
									bref[index-1].setBackground(clr);
									bref[index+1].setBackground(clr);

								}
							}
						}
						if(code==32){																				//32=keycode of spacebar
							space.setBackground(Color.green);
							F.setBackground(clr);
							count++;
						}
						if(code==59){																				//59=keycode of semicolon
							semicol.setBackground(Color.green);
							//count++;
						}
					}
					else
						throw new NumberFormatException();
					if(count==tutorial2.length){
						count=0;
						J.setBackground(clr);
					}
				}

				//Tutorial3 logic
				if(tutorialno.equals("Tutorial No 3")){
					for(int x=0;x<tutorial3.length;x++){
						if(skey.equalsIgnoreCase(tutorial3[x])){			//32=keycode of spacebar, 59=keycode of semicolon
							check=0;
							for(int index=0;index<rowchar.length;index++){
								if(skey.equalsIgnoreCase(rowchar[index])){
									bref[index].setBackground(Color.green);
									che=skey;
									space.setBackground(clr);
									semicol.setBackground(clr);
									if(count>=0){
										bref[tem].setBackground(clr);
										//bref[index+1].setBackground(clr);
									}
									tem = index;

								}
							}
							/*if(code==32){																				//32=keycode of spacebar
								space.setBackground(Color.green);
								//T.setBackground(clr);
								//count++;
							}*/
						}
						else
						if(x == tutorial3.length-1 || x == tutorial3.length){
								//check=0;
								if(code==32){
									space.setBackground(Color.green);
									bref[tem].setBackground(clr);
									semicol.setBackground(clr);
								}
								if(code==59){
									semicol.setBackground(Color.green);
									bref[tem].setBackground(clr);
									space.setBackground(clr);
								}
						}
						/*else
						if(check==-1)
							throw new NumberFormatException();
							*/

					}
					if(che.equalsIgnoreCase(skey)){
						//check=-1;
						//throw new NumberFormatException();
					}
					else
						throw new NumberFormatException();
				}

				//Tutorial4 logic
				if(tutorialno.equals("Tutorial No 4")){
					if(skey.equalsIgnoreCase(tutorial4[count])||code==Integer.parseInt(tutorial4[count])){			//32=keycode of spacebar, 59=keycode of semicolon
						for(int index=0;index<rowchar.length;index++){
							if(skey.equalsIgnoreCase(rowchar[index])){
								bref[index].setBackground(Color.green);
								count++;
								space.setBackground(clr);
								semicol.setBackground(clr);
								if(count>=0){
									bref[index-1].setBackground(clr);
									bref[index+1].setBackground(clr);

								}
							}
						}
						if(code==32){																				//32=keycode of spacebar
							space.setBackground(Color.green);
							T.setBackground(clr);
							count++;
						}
					}
					else
						throw new NumberFormatException();
					if(count==tutorial4.length){
						count=0;
						Y.setBackground(clr);
					}
				}

				//Tutorial5 logic
				if(tutorialno.equals("Tutorial No 5")){
					for(int x=0;x<tutorial5.length;x++){
						if(skey.equalsIgnoreCase(tutorial5[x])){			//32=keycode of spacebar, 59=keycode of semicolon
							check=0;
							for(int index=0;index<rowchar.length;index++){
								if(skey.equalsIgnoreCase(rowchar[index])){
									bref[index].setBackground(Color.green);
									che=skey;
									space.setBackground(clr);
									semicol.setBackground(clr);
									if(count>=0){
										bref[tem].setBackground(clr);
										//bref[index+1].setBackground(clr);
									}
									tem = index;
								}
							}

							/*if(code==32){																				//32=keycode of spacebar
								space.setBackground(Color.green);
								//T.setBackground(clr);
								//count++;
							}*/
						}
						else
						if(x == tutorial5.length-1 || x == tutorial5.length){
							//check=0;
							if(code==32){
								space.setBackground(Color.green);
								bref[tem].setBackground(clr);
								semicol.setBackground(clr);
							}
							if(code==59){
								semicol.setBackground(Color.green);
								bref[tem].setBackground(clr);
								space.setBackground(clr);
							}
						}
					}
					if(che.equalsIgnoreCase(skey) || skey.equals(";")){
						//check=-1;
						//throw new NumberFormatException();
					}
					else
						throw new NumberFormatException();

				}


				//Tutorial6
				if(tutorialno.equals("Tutorial No 6")){
					if(skey.equalsIgnoreCase(tutorial6[count])||code==Integer.parseInt(tutorial6[count])){			//32=keycode of spacebar, 59=keycode of semicolon
						for(int index=0;index<rowchar.length;index++){
							if(skey.equalsIgnoreCase(rowchar[index])){
								bref[index].setBackground(Color.green);
								count++;
								space.setBackground(clr);
								semicol.setBackground(clr);
								if(count>=0){
									bref[index-1].setBackground(clr);
									bref[index+1].setBackground(clr);

								}
							}
						}
						if(code==32){																				//32=keycode of spacebar
							space.setBackground(Color.green);
							V.setBackground(clr);
							count++;
						}
						if(code==44){																				//59=keycode of semicolon
							comma.setBackground(Color.green);
							//count++;
						}
					}
					else
						throw new NumberFormatException();
					if(count==tutorial6.length){
						count=0;
						B.setBackground(clr);
					}
				}

				//Tutorial7 logic
				if(tutorialno.equals("Tutorial No 7")){
					for(int x=0;x<tutorial7.length;x++){
						if(skey.equalsIgnoreCase(tutorial7[x])){			//32=keycode of spacebar, 59=keycode of semicolon
							check=0;
							for(int index=0;index<rowchar.length;index++){
								if(skey.equalsIgnoreCase(rowchar[index])){
									bref[index].setBackground(Color.green);
									che=skey;
									space.setBackground(clr);
									semicol.setBackground(clr);
									comma.setBackground(clr);
									if(count>=0){
										bref[tem].setBackground(clr);
										//bref[index+1].setBackground(clr);
									}
									tem = index;

								}
							}
							/*if(code==32){																				//32=keycode of spacebar
								space.setBackground(Color.green);
								//T.setBackground(clr);
								//count++;
							}*/
						}
						else
						if(x == tutorial7.length-2 || x == tutorial7.length-1 || x == tutorial7.length){
								check=0;
								if(code==44){
									comma.setBackground(Color.green);
									bref[tem].setBackground(clr);
									semicol.setBackground(clr);
									space.setBackground(clr);
								}
								if(code==32){
									space.setBackground(Color.green);
									bref[tem].setBackground(clr);
									semicol.setBackground(clr);
									comma.setBackground(clr);
								}
								if(code==59){
									semicol.setBackground(Color.green);
									bref[tem].setBackground(clr);
									space.setBackground(clr);
									comma.setBackground(clr);
								}
						}
					}
					if(che.equalsIgnoreCase(skey) || skey.equals(";") || skey.equals(",")){
						//check=-1;
						//throw new NumberFormatException();
					}
					else
						throw new NumberFormatException();

				}


				//Tutorial8 logic
				if(tutorialno.equals("Tutorial No 8")){
					//skey = "b"+skey;
					if(skey.equalsIgnoreCase(tutorial8[count])||code==Integer.parseInt(tutorial8[count])){			//32=keycode of spacebar, 59=keycode of semicolon
						for(int index=0;index<rowchar.length;index++){
							if(skey.equalsIgnoreCase(rowchar[index])){
								bref[index].setBackground(Color.green);
								count++;
								space.setBackground(clr);
								semicol.setBackground(clr);
								if(count>=0){
									bref[index-1].setBackground(clr);
									bref[index+1].setBackground(clr);

								}
							}
						}
						if(code==32){																				//32=keycode of spacebar
							space.setBackground(Color.green);
							b5.setBackground(clr);
							count++;
						}
					}
					else
						throw new NumberFormatException();
					if(count==tutorial8.length){
						count=0;
						b6.setBackground(clr);
					}
				}

				//Tutorial9 logic
				if(tutorialno.equals("Tutorial No 9")){
 			 		for(int index=0;index<rowchar.length;index++){
 						if(skey.equalsIgnoreCase(rowchar[index])){
 							bref[index].setBackground(Color.green);
 							space.setBackground(clr);
 							countw--;
 							if(tem!=index||countw==1){
 								bref[tem].setBackground(clr);
 								countw--;
 							}
 							countw++;
 							tem=index;
 						}
 						if("space".equals("space")){
							check=0;
							if(code==32){
								space.setBackground(Color.green);
								bref[tem].setBackground(clr);
								semicol.setBackground(clr);
								comma.setBackground(clr);
							}
						}
 					}
				}

				//Tutorial10 logic
				if(tutorialno.equals("Tutorial No 10")){
 			 		for(int index=0;index<rowchar.length;index++){
 						if(skey.equalsIgnoreCase(rowchar[index])){
 							bref[index].setBackground(Color.green);
 							space.setBackground(clr);
 							countw--;
 							if(tem!=index||countw==1){
 								bref[tem].setBackground(clr);
 								countw--;
 							}
 							countw++;
 							tem=index;
 						}
 						if("space".equals("space")){
							check=0;
							if(code==32){
								space.setBackground(Color.green);
								bref[tem].setBackground(clr);
								semicol.setBackground(clr);
								comma.setBackground(clr);
							}
						}
 					}
				}

			}catch(NumberFormatException ne){
			 	for(int index=0;index<rowchar.length;index++){
					if(skey.equalsIgnoreCase(rowchar[index])){
						bref[index].setBackground(Color.red);
						countw--;
						if(tem!=index||countw==1){
							bref[tem].setBackground(clr);
							countw--;
						}
						countw++;
						tem=index;
					}
				}
			 }

			//System.out.println(code);
			//System.out.println(skey);
			//int ind = temarray.indexOf(key);
			//bref[ind].setBackground(Color.green);

		}
	}

	public static void main(String args[]){
		Home h = new Home();
		h.setDefaultCloseOperation(EXIT_ON_CLOSE);
		h.setVisible(true);
	}
}