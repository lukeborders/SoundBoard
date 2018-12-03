import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Soundboard
{
	public Soundboard()
	{
		//Create a new frame
		JFrame frame = new JFrame();

        
        //make sure the program exits when the frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set the size of the frame
        frame.setSize(900,500);
		
		//create the Audrey Hepburn button			
		JButton button = makeSoundboardButton("audrey.jpg","Hepburn.wav");
		
		//create the Sylvia Mathews Burwell button
		JButton button2 = makeSoundboardButton("JFK.jpg","JFKSPEECH.wav");
		
		//create a JPanel for the button
		JPanel panel = new JPanel();
		
		//add the button to a JPanel
		panel.add(button);
		panel.add(button2);
		
		//add the panel to the content pane of the frame
		frame.getContentPane().add(panel);
		
		
		//make sure the JFrame is visible
		frame.setVisible(true);
	}
	
	/**
	 * Creates a JButton which displays the specified image and plays the specified sound when it is clicked.
	 * @param imageFile the name of the image to display on the button, including the file extension
	 * @param soundFile the name of the audio clip to play when the button is clicked
	 * @return the JButton
	 **/
	private JButton makeSoundboardButton(String imageFile, String soundFile)
	{
		JButton button;
		try{
			BufferedImage icon = ImageIO.read(new File(imageFile));
			button = new JButton(new ImageIcon(icon));
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.setContentAreaFilled(false);
			//add action listener
			button.addActionListener(new SoundboardActionListener(soundFile));
		}
		catch (IOException e) {
			System.out.println(e);
			button = new JButton();
		}
		return button;
	}
}