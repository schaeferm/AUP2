package org.jcryptool.visual.aup2.views;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;
import org.jcryptool.visual.aup2.Aup2Activator;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class Aup2View extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.jcryptool.visual.aup2.views.Aup2View"; //$NON-NLS-1$

	private Composite parent;
	private Button btnSave;
	private Button btnCancel;
	private Button btnRadioSet;
	private Button btnRadioChange;
	private Button btnRadioCheck;
	private Spinner spinnerSize;
	private Group grpOperation;
	private Composite optBox;
	private SashForm contentForm;
	private Composite headingBox;
	private Group grpMatrix;
	private Group grpDesc;
	private Composite middleBox;
	private SashForm descForm;
	private Composite descStep;
	private Composite descPlugin;
	private StyledText descStepHeading;
	private StyledText descStep1;
	private StyledText descStep2;
	private StyledText descStep3;
	private StyledText descPluginHeading;
	private StyledText descPluginText;

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
		
		contentForm = new SashForm(rootBox, SWT.VERTICAL);
		FormData fd_contentForm = new FormData();
		fd_contentForm.left = new FormAttachment(headingBox, 10, SWT.LEFT);
		fd_contentForm.top = new FormAttachment(headingBox, 6);
		
		Label heading = new Label(headingBox, SWT.NONE);
		FormData fd_heading = new FormData();
		fd_heading.bottom = new FormAttachment(100, -5);
		fd_heading.left = new FormAttachment(0, 10);
		heading.setLayoutData(fd_heading);
		heading.setText(Messages.Aup2View_Heading);
		fd_contentForm.bottom = new FormAttachment(100, -10);
		fd_contentForm.right = new FormAttachment(100, -10);
		contentForm.setLayoutData(fd_contentForm);
		
		middleBox = new Composite(contentForm, SWT.NONE);
		middleBox.setLayout(new FormLayout());
		
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
		
		grpDesc = new Group(contentForm, SWT.NONE);
		grpDesc.setText(Messages.Aup2View_GrpDesc);
		grpDesc.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		descForm = new SashForm(grpDesc, SWT.NONE);
		
		descStep = new Composite(descForm, SWT.NONE);
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
		
		descPlugin = new Composite(descForm, SWT.NONE);
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
		descForm.setWeights(new int[] {1, 1});
		contentForm.setWeights(new int[] {3, 1});
		
		sc.setContent(rootBox);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		parent.setFocus();
	}
	
	//sashform minimum width:
	//http://forums.pentaho.com/showthread.php?61793-Creating-a-Minimum-Width-Constraint-on-an-SWT-SashForm
	//http://www.javadocexamples.com/java_source/org/eclipse/swt/examples/controlexample/SashTab.java.html
	
	public void reset() {
		//TODO implement reset function
	}
}