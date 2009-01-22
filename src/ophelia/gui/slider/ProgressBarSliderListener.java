package ophelia.gui.slider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ProgressBarSliderListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		Object l = e.getSource();
		if(l instanceof ProgressBarSlider){
			ProgressBarSlider slider = (ProgressBarSlider)l;
			System.out.println("New position: " + slider.getValue());
		}
	}

}
