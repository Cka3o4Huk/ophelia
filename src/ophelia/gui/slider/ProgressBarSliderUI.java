package ophelia.gui.slider;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import sun.swing.SwingUtilities2;

public class ProgressBarSliderUI extends BasicSliderUI {

	public ProgressBarSliderUI(JSlider b) {
		super(b);		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Dimension getThumbSize() {
		// TODO Auto-generated method stub
		Dimension s = super.getThumbSize();
		s.width = 4;
		return s;
	}
	
	@Override
	public void paintThumb(Graphics g) {
		// TODO Auto-generated method stub
		if(slider instanceof ProgressBarSlider && !((ProgressBarSlider)slider).isDisable()){
			super.paintThumb(g);
		} else if ( !(slider instanceof ProgressBarSlider)){
			super.paintThumb(g);
		}
	}
		
	@Override
	public void paintTrack(Graphics g) {
		// TODO Auto-generated method stub
		Rectangle trackBounds = trackRect;

        if ( slider.getOrientation() == JSlider.HORIZONTAL ) {
            int cy = (trackBounds.height / 2) - 2;
            int cw = trackBounds.width;

            //hack
            cy = 1;
            
            g.translate(trackBounds.x, trackBounds.y + cy);

            g.setColor(getShadowColor());
            g.drawLine(0, 0, cw - 1, 0);
            g.drawLine(0, 1, 0, trackBounds.height - 3);
            g.setColor(getHighlightColor());
            g.drawLine(0, trackBounds.height - 3, cw, trackBounds.height - 3);
            g.drawLine(cw, 0, cw, trackBounds.height - 3);

            if(slider instanceof ProgressBarSlider && !((ProgressBarSlider)slider).isDisable()){
                
	            ProgressBarSlider barslider = (ProgressBarSlider)slider;

		        //Draw filled rectangle
	            g.setColor(new Color(156,0,0));
	            g.fillRect(1, 1, thumbRect.x-1, trackBounds.height - 5);
	            //(1, 3, thumbRect.x-2, 3);
	
	            g.setColor(getHighlightColor());
            
            	Font currentFont = barslider.getFont();
            	            	
            	FontMetrics fontSizer = SwingUtilities2.getFontMetrics(barslider, g,
            			currentFont);
            	      
            	String text = barslider.getString();
            	
            	int sWidth = SwingUtilities2.stringWidth(barslider, fontSizer, barslider.getString());
            	
            	if(sWidth >= cw - 2){
            		text = text.substring(0, (int)Math.floor((cw - 2)*text.length()/sWidth) - 3);
            		text += "...";
            		sWidth = SwingUtilities2.stringWidth(barslider, fontSizer, text);            		
            	}
            	
            	int sHeight = currentFont.getSize();            	
            	int x = (cw - 2 - sWidth)/2;
            	int y = (trackBounds.height - 2 - sHeight)/2 + sHeight;
            	SwingUtilities2.drawString(barslider, g, text, x, y);             
            }
            g.translate(-trackBounds.x, -(trackBounds.y + cy));            
        }
        else {
        	//TODO:
            int cx = (trackBounds.width / 2) - 2;
            int ch = trackBounds.height;

            g.translate(trackBounds.x + cx, trackBounds.y);

            g.setColor(getShadowColor());
            g.drawLine(0, 0, 0, ch - 1);
            g.drawLine(1, 0, 2, 0);
            g.setColor(getHighlightColor());
            g.drawLine(3, 0, 3, ch);
            g.drawLine(0, ch, 3, ch);
            g.setColor(Color.black);
            g.drawLine(1, 1, 1, ch-2);

            g.translate(-(trackBounds.x + cx), -trackBounds.y);
        }		
	}
	
	@Override
	public void paintFocus(Graphics g) {
	}
}
