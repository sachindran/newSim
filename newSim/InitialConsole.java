package newSim;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class InitialConsole extends JFrame  implements WindowListener {
	private GridBagLayout theLayout;
	private GridBagConstraints theConstraint;
   private Container theContainer;
   private Insets inset;
   private boolean initialised = false;
   JLabel ele = new JLabel("No. of Elevators(max 4): ");
   JLabel floors = new JLabel("No. of Floors(max 12): ");
   JTextField numOfEleveators = new JTextField(10);
   JTextField numOfFloors = new JTextField(10);
   JButton ok = new JButton("Ok");
	public InitialConsole(String source) {
		init();
		pack();
		setVisible(true);
	}
	
   private void init()
   {
	   addWindowListener(this);
	   ele = new JLabel("No. of Elevators(max 4): ");
	   floors = new JLabel("No. of Floors(max 12): ");
	   numOfEleveators = new JTextField(10);
	   numOfFloors = new JTextField(10);
	   ok = new JButton("Ok");
	   ok.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int noEle= Integer.parseInt(numOfEleveators.getText());
			int noFloor= Integer.parseInt(numOfFloors.getText());
			if(((noEle>0)&&(noEle<5)) && ((noFloor>0)&&(noFloor<13)))
			{
				Building.MAX_ELEVATORS = noEle;
				Building.MAX_FLOORS = noFloor;	
				theContainer.remove(ele);
				theContainer.remove(floors);
				theContainer.remove(numOfEleveators);
				theContainer.remove(numOfFloors);
				initialised = true;	
				
			}
		}
	});
	   inset = new Insets(0,2,0,2);
      theContainer = getContentPane();
      theContainer.setBackground(new Color(255,255,255));
      theContainer.setFont(new Font("Dialog",Font.PLAIN,9));
      theLayout = new GridBagLayout();
      theConstraint = new GridBagConstraints();
      theConstraint.insets = inset;
      theContainer.setLayout(theLayout);
      constrain(ele, 0 , -1);
      constrain(numOfEleveators, 0 , -1);
      constrain(floors, 0 , -1);
      constrain(numOfFloors, 0 , -1);
      constrain(ok, 0, -1);
   }
   private void constrain( JLabel lb, int x ,int y, int height, int width) {
		theConstraint.gridheight = height;
		theConstraint.gridwidth = width;
		theConstraint.anchor = GridBagConstraints.NORTH;
		theConstraint.gridx = x;
		theConstraint.gridy = y;
		theLayout.setConstraints(lb, theConstraint);
		theContainer.add(lb);
	}
   private void constrain( JLabel lb, int x ,int y) {
		theConstraint.gridheight = 1;
		theConstraint.gridwidth = 1;
		theConstraint.anchor = GridBagConstraints.NORTH;
		theConstraint.gridx = x;
		theConstraint.gridy = y;
		theLayout.setConstraints(lb, theConstraint);
		theContainer.add(lb);
	}
   private void constrain( JTextField lb, int x ,int y) {
		theConstraint.gridheight = 1;
		theConstraint.gridwidth = 1;
		theConstraint.anchor = GridBagConstraints.NORTH;
		theConstraint.gridx = x;
		theConstraint.gridy = y;
		theLayout.setConstraints(lb, theConstraint);
		theContainer.add(lb);
	}
   private void constrain( JButton lb, int x ,int y) {
		theConstraint.gridheight = 1;
		theConstraint.gridwidth = 1;
		theConstraint.anchor = GridBagConstraints.NORTH;
		theConstraint.gridx = x;
		theConstraint.gridy = y;
		theLayout.setConstraints(lb, theConstraint);
		theContainer.add(lb);
   }
   public boolean initialised()
   {
	   return initialised;
   }
	public  void windowActivated ( WindowEvent e ){}
	public void windowClosed ( WindowEvent e ){Simulator.stopProgram();}
	public void windowClosing (WindowEvent e ){}
	public void windowDeactivated ( WindowEvent  e){}
   public void windowDeiconified (WindowEvent e ){}
   public void windowIconified (WindowEvent  e){}
   public void windowOpened (WindowEvent e){}

}