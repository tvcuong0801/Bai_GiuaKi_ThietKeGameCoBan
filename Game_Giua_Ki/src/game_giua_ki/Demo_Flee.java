/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_giua_ki;

import javax.swing.JFrame;

/**
 *
 * @author tvcuo
 */
public class Demo_Flee extends JFrame {
    private Game_Loop_Flee gameLoop;
	
	public Demo_Flee() {
		this.setSize(600, 600);
	
                this.setVisible(true);
		gameLoop = new Game_Loop_Flee(true, this);
		new Thread((Runnable) gameLoop).start();
	}
	
	public static void main(String[] args) {
		 new Demo_Flee();
	}

    
}
