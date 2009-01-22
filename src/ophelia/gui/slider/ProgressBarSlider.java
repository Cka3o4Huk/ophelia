package ophelia.gui.slider;

import javax.swing.JSlider;

public class ProgressBarSlider extends JSlider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected boolean isDisable;
	
	public void disable() {
		this.isDisable = true;
	}
	
	public void enable() {
		this.isDisable = false;
	}

	protected String text = "";

	public void setString(String text) {
		this.text = text;
	}

	public String getString() {
		return text;
	}
	
	public boolean isDisable() {
		return isDisable;
	}
}
