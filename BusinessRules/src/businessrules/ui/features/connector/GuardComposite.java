package businessrules.ui.features.connector;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import businessrulesruntime.core.engine.CodeDetail;

public class GuardComposite extends Composite {

	private Spinner spinner;
//	private CodeComposite codeComposite;

	private int priority;
	private CodeDetail codeDetail;
	private EventManager eventManager;
	private String groupName;
	private Label lblPriority;

	public GuardComposite(Composite parent, int style, int priority, CodeDetail codeDetail, String groupName,
			EventManager eventManager) {
		super(parent, style);
		this.priority = priority;
		this.codeDetail = codeDetail;
		this.eventManager = eventManager;
		this.groupName = groupName;
		setLayout(new GridLayout(2, false));
		createCompositeArea(this);
	}

	private void createCompositeArea(Composite parent) {
		lblPriority = new Label(parent, SWT.NONE);
		lblPriority.setText("Priority : ");

		spinner = new Spinner(parent, SWT.BORDER);
		spinner.setMaximum(32);
		spinner.setMinimum(0);
		spinner.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		spinner.setSelection(priority);

		Label lblCondition = new Label(parent, SWT.NONE);
		lblCondition.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		lblCondition.setText("Condition : ");

/*		List<SQLType> sqlTypeList = new ArrayList<SQLType>();
		sqlTypeList.add(SQLType.Function);
*/
		List<String> returnRestrictedList = new ArrayList<String>();
		returnRestrictedList.add("boolean");

/*		codeComposite = new CodeComposite(parent, SWT.NONE, codeDetail, groupName, eventManager, sqlTypeList,
				returnRestrictedList);
		codeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
*/	}

	public int getPriority() {
		return spinner.getSelection();
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}
}
