package org.jcryptool.visual.aup2.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.jcryptool.visual.aup2.Aup2Activator;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class Aup2View extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.jcryptool.visual.aup2.views.MainView"; //$NON-NLS-1$

	//UI constants
	private static final int LIMIT_middleBox = 300;	//minimum height of middleBox
	private static final int LIMIT_grpDesc = 80; //minimum height of grpDesc
	private static final int LIMIT_Desc = 150; //minimum weight of descStep and descPlugin
	private static final int PERCENT_contentBox = 75; //initial height of middleBox in percent of contentBox's height
	private static final int PERCENT_grpDesc = 40; //initial weight of descStep in percent of grpDesc's weight
	
	//UI elements
	private Composite parent;
	private Button btnSave;
	private Button btnCancel;
	private Button btnRadioSet;
	private Button btnRadioChange;
	private Button btnRadioCheck;
	private Spinner spinnerSize;
	private Group grpOperation;
	private Composite optBox;
	private Composite contentBox;
	private Composite headingBox;
	private Group grpMatrix;
	private Group grpDesc;
	private Composite middleBox;
	private Composite descStep;
	private Composite descPlugin;
	private StyledText descStepHeading;
	private StyledText descStep1;
	private StyledText descStep2;
	private StyledText descStep3;
	private StyledText descPluginHeading;
	private StyledText descPluginText;
	private Sash sashContentBox;
	private FormData fd_sashCB;
	private Sash sashGrpDesc;
	private FormData fd_sashGD;

	/**
	 * The constructor.
	 */
	public Aup2View() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		this.parent = parent;
		
		// set context help
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(
						parent,
						Aup2Activator.PLUGIN_ID
								+ ".ContextHelpView"); //$NON-NLS-1$

		// Create the ScrolledComposite to scroll horizontally and vertically
		final ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL
				| SWT.V_SCROLL);
		sc.setMinHeight(500);
		sc.setMinWidth(500);
		
		// Create a child composite to hold the controls
		final Composite rootBox = new Composite(sc, SWT.NONE);
		rootBox.setLayout(new FormLayout());
		
		headingBox = new Composite(rootBox, SWT.NONE);
		headingBox.setLayout(new FormLayout());
		FormData fd_headingBox = new FormData();
		fd_headingBox.bottom = new FormAttachment(0, 30);
		fd_headingBox.right = new FormAttachment(100);
		fd_headingBox.top = new FormAttachment(0);
		fd_headingBox.left = new FormAttachment(0);
		headingBox.setLayoutData(fd_headingBox);
		
		contentBox = new Composite(rootBox, SWT.NONE);
		FormData fd_contentBox = new FormData();
		fd_contentBox.left = new FormAttachment(headingBox, 10, SWT.LEFT);
		fd_contentBox.top = new FormAttachment(headingBox, 6);
		
		Label heading = new Label(headingBox, SWT.NONE);
		FormData fd_heading = new FormData();
		fd_heading.bottom = new FormAttachment(100, -5);
		fd_heading.left = new FormAttachment(0, 10);
		heading.setLayoutData(fd_heading);
		heading.setText(Messages.Aup2View_Heading);
		contentBox.setLayout(new FormLayout());
		fd_contentBox.bottom = new FormAttachment(100, -10);
		fd_contentBox.right = new FormAttachment(100, -10);
		contentBox.setLayoutData(fd_contentBox);
		
		middleBox = new Composite(contentBox, SWT.NONE);
		sashContentBox = new Sash(contentBox, SWT.HORIZONTAL);
		grpDesc = new Group(contentBox, SWT.NONE);
		
		FormData fd_middleBox = new FormData();
		fd_middleBox.left = new FormAttachment(0);
		fd_middleBox.right = new FormAttachment(100);
		fd_middleBox.bottom = new FormAttachment(sashContentBox, 0);
		fd_middleBox.top = new FormAttachment(0);
		middleBox.setLayoutData(fd_middleBox);
		middleBox.setLayout(new FormLayout());
		
		fd_sashCB = new FormData();
		fd_sashCB.left = new FormAttachment(0);
		fd_sashCB.right = new FormAttachment(100);
		fd_sashCB.top = new FormAttachment(PERCENT_contentBox, 0);
		sashContentBox.setLayoutData(fd_sashCB);
		
		grpDesc.setLayout(new FormLayout());
		FormData fd_grpDesc = new FormData();
		fd_grpDesc.top = new FormAttachment(sashContentBox, 0);
		fd_grpDesc.left = new FormAttachment(0);
		fd_grpDesc.right = new FormAttachment(100);
		fd_grpDesc.bottom = new FormAttachment(100, 0);
		grpDesc.setLayoutData(fd_grpDesc);
		grpDesc.setText(Messages.Aup2View_GrpDesc);
		
		optBox = new Composite(middleBox, SWT.NONE);
		FormData fd_optBox = new FormData();
		fd_optBox.left = new FormAttachment(0);
		fd_optBox.top = new FormAttachment(0);
		fd_optBox.bottom = new FormAttachment(100);
		optBox.setLayoutData(fd_optBox);
		optBox.setLayout(new FormLayout());
		
		grpOperation = new Group(optBox, SWT.NONE);
		FormData fd_grpOperation = new FormData();
		fd_grpOperation.bottom = new FormAttachment(0, 74);
		fd_grpOperation.top = new FormAttachment(0);
		fd_grpOperation.left = new FormAttachment(0);
		fd_grpOperation.right = new FormAttachment(100, -10);
		grpOperation.setLayoutData(fd_grpOperation);
		grpOperation.setText(Messages.Aup2View_GrpOpts);
		FillLayout fl_grpOperation = new FillLayout(SWT.VERTICAL);
		fl_grpOperation.marginWidth = 2;
		fl_grpOperation.marginHeight = 2;
		fl_grpOperation.spacing = 2;
		grpOperation.setLayout(fl_grpOperation);
		
		btnRadioSet = new Button(grpOperation, SWT.RADIO);
		btnRadioSet.setText(Messages.Aup2View_OptsSet);
		
		btnRadioChange = new Button(grpOperation, SWT.RADIO);
		btnRadioChange.setText(Messages.Aup2View_OptsChange);
		
		btnRadioCheck = new Button(grpOperation, SWT.RADIO);
		btnRadioCheck.setText(Messages.Aup2View_OptsCheck);
		
		btnSave = new Button(optBox, SWT.NONE);
		btnSave.setEnabled(true);
		FormData fd_btnSave = new FormData();
		fd_btnSave.top = new FormAttachment(grpOperation, 6);
		fd_btnSave.left = new FormAttachment(grpOperation, 0, SWT.LEFT);
		fd_btnSave.right = new FormAttachment(100, -10);
		btnSave.setLayoutData(fd_btnSave);
		btnSave.setText(Messages.Aup2View_BtnSave);
		
		btnCancel = new Button(optBox, SWT.NONE);
		fd_btnSave.bottom = new FormAttachment(btnCancel, -6);
		btnCancel.setGrayed(true);
		FormData fd_btnCancel = new FormData();
		fd_btnCancel.top = new FormAttachment(0, 116);
		fd_btnCancel.left = new FormAttachment(grpOperation, 0, SWT.LEFT);
		fd_btnCancel.right = new FormAttachment(grpOperation, 0, SWT.RIGHT);
		btnCancel.setLayoutData(fd_btnCancel);
		btnCancel.setText(Messages.Aup2View_BtnChancel);
		
		spinnerSize = new Spinner(optBox, SWT.BORDER);
		fd_btnCancel.bottom = new FormAttachment(spinnerSize, -6);
		spinnerSize.setTextLimit(2);
		spinnerSize.setPageIncrement(1);
		spinnerSize.setMaximum(10);
		spinnerSize.setMinimum(3);
		spinnerSize.setEnabled(true);
		FormData fd_spinnerSize = new FormData();
		fd_spinnerSize.top = new FormAttachment(0, 152);
		fd_spinnerSize.right = new FormAttachment(grpOperation, 0, SWT.RIGHT);
		spinnerSize.setLayoutData(fd_spinnerSize);
		
		Label lblSize = new Label(optBox, SWT.NONE);
		FormData fd_lblSize = new FormData();
		fd_lblSize.top = new FormAttachment(spinnerSize, 3, SWT.TOP);
		fd_lblSize.right = new FormAttachment(spinnerSize, -6);
		fd_lblSize.left = new FormAttachment(0);
		lblSize.setLayoutData(fd_lblSize);
		lblSize.setText(Messages.Aup2View_OptsSize);
		
		grpMatrix = new Group(middleBox, SWT.NONE);
		fd_optBox.right = new FormAttachment(grpMatrix, -6);
		FormData fd_grpMatrix = new FormData();
		fd_grpMatrix.left = new FormAttachment(0, 146);
		fd_grpMatrix.right = new FormAttachment(100);
		fd_grpMatrix.top = new FormAttachment(0);
		fd_grpMatrix.bottom = new FormAttachment(100);
		grpMatrix.setLayoutData(fd_grpMatrix);
		grpMatrix.setText(Messages.Aup2View_GrpMatrix);
		grpMatrix.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		sashGrpDesc = new Sash(grpDesc, SWT.VERTICAL);
		
		descStep = new Composite(grpDesc, SWT.NONE);
		FormData fd_descStep = new FormData();
		fd_descStep.bottom = new FormAttachment(100, 0);
		fd_descStep.right = new FormAttachment(sashGrpDesc, 0);
		fd_descStep.top = new FormAttachment(0, 0);
		fd_descStep.left = new FormAttachment(0, 0);
		descStep.setLayoutData(fd_descStep);
		descStep.setLayout(new GridLayout(1, false));
		
		fd_sashGD = new FormData();
		fd_sashGD.left = new FormAttachment(PERCENT_grpDesc, 0);
		fd_sashGD.top = new FormAttachment(0);
		fd_sashGD.bottom = new FormAttachment(100);
		sashGrpDesc.setLayoutData(fd_sashGD);
		
		descStepHeading = new StyledText(descStep, SWT.READ_ONLY | SWT.WRAP);
		descStepHeading.setDoubleClickEnabled(false);
		descStepHeading.setText(Messages.Aup2View_DescBoxL_Heading);
		descStepHeading.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		descStep1 = new StyledText(descStep, SWT.READ_ONLY | SWT.WRAP);
		descStep1.setDoubleClickEnabled(false);
		descStep1.setText(String.format(Messages.Aup2View_DescBoxL_Step, 1, Messages.Aup2View_Mode_Set_1));
		descStep1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		descStep2 = new StyledText(descStep, SWT.READ_ONLY | SWT.WRAP);
		descStep2.setDoubleClickEnabled(false);
		descStep2.setText(String.format(Messages.Aup2View_DescBoxL_Step, 2, Messages.Aup2View_Mode_Set_2));
		descStep2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		descStep3 = new StyledText(descStep, SWT.READ_ONLY | SWT.WRAP);
		descStep3.setDoubleClickEnabled(false);
		descStep3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		descPlugin = new Composite(grpDesc, SWT.NONE);
		FormData fd_descPlugin = new FormData();
		fd_descPlugin.bottom = new FormAttachment(100, 0);
		fd_descPlugin.right = new FormAttachment(100, 0);
		fd_descPlugin.top = new FormAttachment(0, 0);
		fd_descPlugin.left = new FormAttachment(sashGrpDesc, 0);
		descPlugin.setLayoutData(fd_descPlugin);
		descPlugin.setLayout(new GridLayout(1, false));
		
		descPluginHeading = new StyledText(descPlugin, SWT.READ_ONLY | SWT.WRAP);
		descPluginHeading.setEditable(false);
		descPluginHeading.setDoubleClickEnabled(false);
		descPluginHeading.setText(Messages.Aup2View_DescBoxR_Heading);
		descPluginHeading.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		
		descPluginText = new StyledText(descPlugin, SWT.READ_ONLY | SWT.WRAP);
		descPluginText.setDoubleClickEnabled(false);
		descPluginText.setText(String.format(Messages.Aup2View_DescBoxR_Text, ""));
		descPluginText.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
		
		sc.setContent(rootBox);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		
		hookResize();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		parent.setFocus();
	}
	
	/**
	 * Hook resize events to enforce minimum dimensions 
	 */
	private void hookResize() {
		//enable the user to resize contentBox's children
		sashContentBox.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				Rectangle sashRect = sashContentBox.getBounds();
				Rectangle contentRect = contentBox.getClientArea();
				int space = contentRect.height - sashRect.height;
				if (e.y <= LIMIT_middleBox)
					e.y = LIMIT_middleBox; // enforce LIMIT_middleBox
				else if (e.y >= space - LIMIT_grpDesc)
					e.y = space - LIMIT_grpDesc; // enforce LIMIT_grpDesc
				if (e.y != sashRect.y) 
					fd_sashCB.top = new FormAttachment(e.y * 100 / space, 0); //set new layout information
				if(e.detail != SWT.DRAG)
					contentBox.layout(); //layout when user ends the drag
			}
		});
		
		//enable the user to resize grpDesc's children
		sashGrpDesc.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				Rectangle sashRect = sashGrpDesc.getBounds();
				Rectangle contentRect = grpDesc.getClientArea();
				int space = contentRect.width - sashRect.width;
				e.x = Math.max(Math.min(e.x, (space - LIMIT_Desc)), LIMIT_Desc);
				if (e.x != sashRect.x) 
					fd_sashGD.left = new FormAttachment(e.x * 100 / space, 0); //set new layout information
				if(e.detail != SWT.DRAG)	
					grpDesc.layout(); //layout when user ends the drag
			}
		});
		
	    //enforce minimum size for contentBox's children		
		contentBox.addListener(SWT.Resize, new Listener() {
			int time = 0; //time of the last handled event
			
			public void handleEvent(Event e) {
				if(e.time == time) return; //quit if event was already handled
				else time = e.time; //save time to filter already served events
				Point middleBoxSize = middleBox.getSize();
				if(middleBoxSize.y == 0) return; //UI not fully initialized -> quit
				int size = 0;
				Rectangle sashRect = sashContentBox.getBounds();
				Rectangle contentRect = contentBox.getClientArea();
				int space = contentRect.height - sashRect.height;
				if(middleBoxSize.y <= LIMIT_middleBox) size = LIMIT_middleBox; //enforce LIMIT_middleBox
				else if (middleBoxSize.y >= space - LIMIT_grpDesc) size = space - LIMIT_grpDesc; //enforce LIMIT_grpDesc
				if (size != 0) {
					fd_sashCB.top = new FormAttachment(size*100/space, 0);
					contentBox.layout();
				}
//				contentBox.redraw();
			}
		});
		
	    //enforce minimum size for grpDesc's children
		grpDesc.addListener(SWT.Resize, new Listener() {
			int time = 0; //time of the last handled event
			
			public void handleEvent(Event e) {
				if(e.time == time) return; //quit if event was already handled
				else time = e.time; //save time to filter already served events
				Point descStepSize = descStep.getSize();
				if(descStepSize.x == 0) return; //UI not fully initialized -> quit
				Rectangle sashRect = sashGrpDesc.getBounds();
				Rectangle contentRect = grpDesc.getClientArea();
				int space = contentRect.width - sashRect.width;
				int size = 0;
				if(descStepSize.x <= LIMIT_Desc) size = LIMIT_Desc; //enforce LIMIT_Desc for descStep
				else if (descStepSize.x >= space - LIMIT_Desc) size = space - LIMIT_Desc; //enforce LIMIT_Desc for descPlugin
				if (size != 0) {
					fd_sashGD.left = new FormAttachment(size*100/space, 0);
					grpDesc.layout();
				}
//				contentBox.redraw();
			}
		});
	}
	
	public void reset() {
		//TODO implement reset function
	}
	
	public void dispose() {
	}
	
	public class ResizeHandler extends ControlAdapter{

		final int LIMIT;
		
		ResizeHandler(int limit) {
			LIMIT = limit;
		}
		
		@Override
		public void controlResized(ControlEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}