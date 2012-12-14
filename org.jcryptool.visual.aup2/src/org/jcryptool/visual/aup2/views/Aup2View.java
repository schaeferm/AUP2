package org.jcryptool.visual.aup2.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.jcryptool.visual.aup2.Aup2Activator;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.SashForm;

public class Aup2View extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.jcryptool.visual.aup2.views.MainView"; //$NON-NLS-1$
	
	//UI elements
	private Composite parent;
	private Button btnSave;
	private Button btnCancel;
	private Button btnRadioSet;
	private Button btnRadioCheck;
	private Spinner spinnerSize;
	private Group grpOperation;
	private Composite optBox;
	private SashForm contentSashForm;
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
	private Group grpActions;
	private Button btnSetSize;
	private Group grpSize;
	private Label heading;
	private SashForm grpDescSashForm;

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
		
		contentSashForm = new SashForm(rootBox, SWT.VERTICAL);
		FormData fd_contentSashForm = new FormData();
		fd_contentSashForm.left = new FormAttachment(headingBox, 10, SWT.LEFT);
		fd_contentSashForm.top = new FormAttachment(headingBox, 6);
		
		heading = new Label(headingBox, SWT.NONE);
		FormData fd_heading = new FormData();
		fd_heading.bottom = new FormAttachment(100, -5);
		fd_heading.left = new FormAttachment(0, 10);
		heading.setLayoutData(fd_heading);
		heading.setText(Messages.Aup2View_Heading);
		fd_contentSashForm.bottom = new FormAttachment(100, -10);
		fd_contentSashForm.right = new FormAttachment(100, -10);
		contentSashForm.setLayoutData(fd_contentSashForm);
		
		middleBox = new Composite(contentSashForm, SWT.NONE);
		middleBox.setBounds(0, 0, 557, 340);
		grpDesc = new Group(contentSashForm, SWT.NONE);
		grpDesc.setBounds(0, 343, 557, 111);
		middleBox.setLayout(new FormLayout());
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
		fd_grpOperation.bottom = new FormAttachment(0, 56);
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
		btnRadioSet.setSelection(true);
		btnRadioSet.setText(Messages.Aup2View_OptsSet);
		
		btnRadioCheck = new Button(grpOperation, SWT.RADIO);
		btnRadioCheck.setEnabled(false);
		btnRadioCheck.setText(Messages.Aup2View_OptsCheck);
		
		grpSize = new Group(optBox, SWT.NONE);
		grpSize.setText(Messages.Aup2View_GrpSize);
		FormLayout fl_grpSize = new FormLayout();
		fl_grpSize.marginWidth = 2;
		fl_grpSize.marginHeight = 2;
		grpSize.setLayout(fl_grpSize);
		FormData fd_grpSize = new FormData();
		fd_grpSize.bottom = new FormAttachment(grpOperation, 56, SWT.BOTTOM);
		fd_grpSize.right = new FormAttachment(grpOperation, 0, SWT.RIGHT);
		fd_grpSize.top = new FormAttachment(grpOperation, 6);
		fd_grpSize.left = new FormAttachment(grpOperation, 0, SWT.LEFT);
		grpSize.setLayoutData(fd_grpSize);
		
		spinnerSize = new Spinner(grpSize, SWT.BORDER);
		FormData fd_spinnerSize = new FormData();
		fd_spinnerSize.bottom = new FormAttachment(0, 28);
		fd_spinnerSize.top = new FormAttachment(0, 3);
		fd_spinnerSize.left = new FormAttachment(0);
		spinnerSize.setLayoutData(fd_spinnerSize);
		spinnerSize.setTextLimit(2);
		spinnerSize.setPageIncrement(1);
		spinnerSize.setMaximum(10);
		spinnerSize.setMinimum(3);
		spinnerSize.setEnabled(true);
		
		grpMatrix = new Group(middleBox, SWT.NONE);
		fd_optBox.right = new FormAttachment(grpMatrix, -6);
		
		grpActions = new Group(optBox, SWT.NONE);
		grpActions.setText(Messages.Aup2View_GrpActions);
		FillLayout fl_grpActions = new FillLayout(SWT.VERTICAL);
		fl_grpActions.marginWidth = 2;
		fl_grpActions.marginHeight = 2;
		fl_grpActions.spacing = 2;
		grpActions.setLayout(fl_grpActions);
		FormData fd_grpActions = new FormData();
		fd_grpActions.top = new FormAttachment(grpSize, 6);
		fd_grpActions.left = new FormAttachment(grpOperation, 0, SWT.LEFT);
		fd_grpActions.right = new FormAttachment(grpOperation, 0, SWT.RIGHT);
		
		btnSetSize = new Button(grpSize, SWT.NONE);
		FormData fd_btnSetSize = new FormData();
		fd_btnSetSize.left = new FormAttachment(spinnerSize, 5);
		fd_btnSetSize.right = new FormAttachment(100);
		fd_btnSetSize.top = new FormAttachment(spinnerSize, 0, SWT.TOP);
		fd_btnSetSize.bottom = new FormAttachment(spinnerSize, 0, SWT.BOTTOM);
		btnSetSize.setLayoutData(fd_btnSetSize);
		btnSetSize.setText(Messages.Aup2View_BtnSetSize);
		grpActions.setLayoutData(fd_grpActions);
		
		btnSave = new Button(grpActions, SWT.NONE);
		btnSave.setEnabled(false);
		btnSave.setText(Messages.Aup2View_BtnSave);
		
		btnCancel = new Button(grpActions, SWT.NONE);
		btnCancel.setEnabled(false);
		btnCancel.setGrayed(true);
		btnCancel.setText(Messages.Aup2View_BtnChancel);
		FormData fd_grpMatrix = new FormData();
		fd_grpMatrix.left = new FormAttachment(0, 146);
		fd_grpMatrix.right = new FormAttachment(100);
		fd_grpMatrix.top = new FormAttachment(0);
		fd_grpMatrix.bottom = new FormAttachment(100);
		grpMatrix.setLayoutData(fd_grpMatrix);
		grpMatrix.setText(Messages.Aup2View_GrpMatrix);
		grpMatrix.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpDesc.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		grpDescSashForm = new SashForm(grpDesc, SWT.NONE);
		
		descStep = new Composite(grpDescSashForm, SWT.NONE);
		descStep.setLayout(new GridLayout(1, false));
		
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
		
		descPlugin = new Composite(grpDescSashForm, SWT.NONE);
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
		grpDescSashForm.setWeights(new int[] {40, 60});
		contentSashForm.setWeights(new int[] {70, 30});
		
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