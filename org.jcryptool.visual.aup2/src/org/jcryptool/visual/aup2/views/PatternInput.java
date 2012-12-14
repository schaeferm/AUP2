// http://www.eclipse.org/articles/Article-Writing%20Your%20Own%20Widget/Writing%20Your%20Own%20Widget.htm

package org.jcryptool.visual.aup2.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CLabel;

public class PatternInput extends Composite {

	Label btnBox;
	CLabel statusBox;
	int matrixSize;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PatternInput(Composite parent, int style) {
		super(parent, style);
		FormLayout formLayout = new FormLayout();
		formLayout.spacing = 2;
		formLayout.marginHeight = 5;
		formLayout.marginBottom = 5;
		setLayout(formLayout);
		
		btnBox = new Label(this, SWT.NONE);
		FormData fd_btnBox = new FormData();
		fd_btnBox.right = new FormAttachment(100);
		fd_btnBox.bottom = new FormAttachment(100, -25);
		fd_btnBox.top = new FormAttachment(statusBox, 0, SWT.TOP);
		fd_btnBox.left = new FormAttachment(statusBox, 0, SWT.LEFT);
		btnBox.setLayoutData(fd_btnBox);
		
		statusBox = new CLabel(this, SWT.NONE);
		FormData fd_statusBox = new FormData();
		fd_statusBox.top = new FormAttachment(btnBox);
		fd_statusBox.bottom = new FormAttachment(100);
		fd_statusBox.left = new FormAttachment(0);
		fd_statusBox.right = new FormAttachment(100);
		statusBox.setLayoutData(fd_statusBox);
		
		addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				PatternInput.this.widgetDisposed(e);
			}
		});
		
	     addControlListener(new ControlAdapter() {
	         public void controlResized(ControlEvent e) {
	        	 PatternInput.this.controlResized(e);
	         }
	     }); 
	}

	void widgetDisposed(DisposeEvent e) {
		//TODO dispose graphic resources here
   	 
    }
	
	void controlResized(ControlEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void updateMatrixSize() {
		//TODO reinitialise after size changes
		//use layout
	}
	
	public void setMatrixSize(int size) {
		this.matrixSize = size;
		updateMatrixSize();
	}
	
	public int getMatrixSize() {
		return matrixSize;
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
