import javax.sound.sampled.*;
import java.awt.event.*;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;

public class SoundboardActionListener implements ActionListener
{
	private Clip clip;
    private AudioInputStream audioInputStream;
	private URL defaultSound;
	
	public SoundboardActionListener(String url)
	{
		try
		{
		defaultSound = this.getClass().getClassLoader().getResource(url);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		play();
	}
	
	public void play() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(defaultSound);

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop(20000);
                clip.start();

            } catch (LineUnavailableException e) {
				System.out.println(e);
            }

        } catch (UnsupportedAudioFileException | IOException e) {
			System.out.println(e);
        }
    }
}