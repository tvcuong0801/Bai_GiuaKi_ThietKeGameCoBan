/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_giua_ki;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game_Loop_Flee implements Runnable{
	private boolean isRunning;
	private Demo_Flee demo;
	private List<Character> characters;
        private Character target;

        private List<KinematicFlee> kinematicFlees ;
	public Game_Loop_Flee(boolean isRunning, Demo_Flee demo) {
		super();
		this.isRunning = isRunning;
		this.demo = demo;
		
		Character c1 = new Character(new Vector2D(470, 150), 0, new Vector2D(0, 0), 0, Color.RED);
		Character c2 = new Character(new Vector2D(450, 200), 0, new Vector2D(0, 0), 0, Color.GREEN);
		
                target= new Character(new Vector2D (500, 200),80,new Vector2D(0,0),0,Color.BLACK);
		this.characters = new ArrayList<Character>();
		
		this.kinematicFlees= new ArrayList<KinematicFlee>();
		this.characters.add(c1);
		this.characters.add(c2);
		for (Character c: this.characters) {
			//this.kinematicWandering = new KinematicWandering(c, 5, 1);
			this.kinematicFlees.add(new KinematicFlee(c,target,6));
                        //this.kinematicSeeks.add(new KinematicSeek(c,target , 2));
		}
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public Demo_Flee getDemo() {
		return demo;
	}

	public void setDemo(Demo_Flee demo) {
		this.demo = demo;
	}

	@Override
	public void run() {

		while (true) {
			demo.getGraphics().clearRect(0,  0,  demo.getWidth(), demo.getHeight());
                        this.target.render(this.demo.getGraphics());
			for (Character c: this.characters) {
				c.update(this.kinematicFlees.get(this.characters.indexOf(c)).generateKinematicOutput(), 2);
				c.render(this.demo.getGraphics());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}
