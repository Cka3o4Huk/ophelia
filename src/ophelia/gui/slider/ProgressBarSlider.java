package ophelia.gui.slider;

import javax.swing.JSlider;

public class ProgressBarSlider extends JSlider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String text = "";

	public void setString(String text) {
		this.text = text;
	}

	public String getString() {
		return text;
	}
}
