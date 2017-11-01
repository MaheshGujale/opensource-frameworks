package businessrules.ui.utils;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.LineNumberRulerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("restriction")
public class ExceptionDialog extends TitleAreaDialog {

	private Text txtErrorMessage;
	
	private Exception exception;
	private String javaCode;

	public ExceptionDialog(Shell parentShell, Exception exception, String javaCode) {
		super(parentShell);
		this.exception = exception;
		this.javaCode = javaCode;
		setHelpAvailable(false);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		contents.getShell().setText("Exception");
		setTitle("Exception dialog");
		setMessage("Detailed exception information shown.");
		return contents;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite fixedComposite = new Composite(parent, SWT.NONE);
		fixedComposite.setLayout(new GridLayout(4, false));
		fixedComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label lblError = new Label(fixedComposite, SWT.NONE);
		lblError.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2, 1));
		lblError.setText("Error Message");

		Label lblColon = new Label(fixedComposite, SWT.NONE);
		lblColon.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblColon.setText(":");

		txtErrorMessage = new Text(fixedComposite, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.MULTI);
		txtErrorMessage.setBackground(new Color(null, new RGB(244, 244, 244)));
		txtErrorMessage.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtErrorMessage.setText(exception.getCause() == null ? "" : exception.getCause().toString());

		Label lblDetailedMessage = new Label(fixedComposite, SWT.NONE);
		lblDetailedMessage.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblDetailedMessage.setText("Javacode");

		Label label = new Label(fixedComposite, SWT.NONE);
		label.setText(":");
		new Label(fixedComposite, SWT.NONE);

		Composite javaSourceViewerComposite = new Composite(fixedComposite, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		javaSourceViewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
		javaSourceViewerComposite.setLayout(gridLayout);

		CompositeRuler ruler = new CompositeRuler();
		LineNumberRulerColumn lineNumberRuleColumn = new LineNumberRulerColumn();
		lineNumberRuleColumn.setFont(new Font(null, new FontData("Courier New", 9, SWT.NONE)));
		lineNumberRuleColumn.setForeground(new Color(null, new RGB(128, 128, 128)));
		lineNumberRuleColumn.setBackground(new Color(getShell().getDisplay(), new RGB(244, 244, 244)));
		ruler.addDecorator(0, lineNumberRuleColumn);

		Document document = new Document();
		JavaTextTools tools = JavaPlugin.getDefault().getJavaTextTools();
		tools.setupJavaDocumentPartitioner(document, IJavaPartitions.JAVA_PARTITIONING);
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();

		JavaSourceViewer viewer = new JavaSourceViewer(javaSourceViewerComposite, ruler, null, false, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL, store);

		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		viewer.setDocument(document);
		viewer.getTextWidget().setFont(JFaceResources.getFont(PreferenceConstants.EDITOR_TEXT_FONT));

		JavaSourceViewerConfiguration configuration = new JavaSourceViewerConfiguration(tools.getColorManager(), store,
				null, IJavaPartitions.JAVA_PARTITIONING);

		viewer.configure(configuration);
		viewer.setEditable(false);
		viewer.getTextWidget().setBackground(new Color(getShell().getDisplay(), new RGB(244, 244, 244)));
		viewer.getTextWidget().setText(javaCode);

		return parent;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(700, 500);
	}

}
