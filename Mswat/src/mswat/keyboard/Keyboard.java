package mswat.keyboard;

import android.content.Context;
import mswat.core.CoreController;

/**
 *
 * @author Andre Rodrigues
 *
 */
public abstract class Keyboard {
	

	
	public static void writeChar(char c){
		int code=c;
		CoreController.callKeyboardWriteChar(code);
	}
	
	public static void backSpace(){
		CoreController.callKeyboardWriteChar(-5);
	}
	
	public static void writeString(String s){
		int size= s.length();
		int [] array = new int [size];
		
		for(int i=0 ;i<size;i++){
			array[i]=s.charAt(i);
		}
		
		CoreController.callKeyboardWriteString(array);
		
	}
	
	/**
	 * Can give false negatives (keyboard active but state is not)
	 * @return if keyboard is on screen
	 */
	public static boolean keyboardState(){
		return CoreController.keyboardState;
	}
	
	public abstract void show(Context c);
	
	public abstract void hide();
	
}
