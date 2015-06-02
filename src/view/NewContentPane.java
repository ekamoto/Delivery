package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class NewContentPane extends JPanel {

	// método implementado de JPanel

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image bImage;

	NewContentPane(Image im) {

		this.bImage = im;
	}

	protected void paintComponent(final Graphics g) {

		super.paintComponent(g);

		g.drawImage(bImage, 300, 300, this);

	}

}
