import sun.audio.*;
import java.io.*;
import java.util.Random;

class Voldemort
{
	public int getRand(int max)
	{
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(max)+1;
	}
	public synchronized void play(String filename) 
    	{
        	try 
		{
                	InputStream in = new FileInputStream(filename);
	                AudioStream as = new AudioStream(in);
	                AudioPlayer.player.start(as); 
			AudioPlayer.player.join(4000);
			AudioPlayer.player.stop();
	        } 
		catch (Exception e) 
		{
	                e.printStackTrace();
	        }
    	}
	public synchronized String getTrack(int num)
	{
		return "sounds/"+Integer.toString(num)+".wav";
	}
	
	public static void main(String[] args) 
	{
		Voldemort voldemort = new Voldemort();
		int answer =(voldemort.getRand(3));
		System.out.println("my answer is: "+answer);
		voldemort.play(voldemort.getTrack(0));
		voldemort.play(voldemort.getTrack(answer));
	}
}
