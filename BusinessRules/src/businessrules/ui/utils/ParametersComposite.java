package businessrules.ui.utils;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import businessrules.ui.features.AddParameterDialog;
import businessrulesruntime.core.engine.FieldInfo;

public class ParametersComposite extends Composite implements IEventSupport, PropertyChangeListener {

	private TableComposite tableComposite;

	private List<FieldInfo> fieldInfos;
	private List<FieldInfo> workflowParamsInfo;
	private boolean injectRequired;
	private EventManager evtManager;
	private String groupName;
	private Map<String, FieldInfo> previousFieldInfos = new HashMap<String, FieldInfo>();

	private String stepName;

	public ParametersComposite(Composite parent, int style, List<FieldInfo> fieldInfos,
			List<FieldInfo> workflowParamsInfo, String groupName, String stepName, boolean injectRequired) {
		super(parent, style);
		this.fieldInfos = CloneObjectUtil.cloneObject(fieldInfos);
		this.injectRequired = injectRequired;
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		this.groupName = groupName;
		this.stepName = stepName;
		this.workflowParamsInfo = workflowParamsInfo;
		setLayout(gridLayout);
		createCompositeArea();
	}

	private void createCompositeArea() {
		String[] columnCaption = new String[] { "Field name", "Description", "Data type", "Array" };
		int[] columnWidth = new int[] { 100, 120, 120, 120 };
		int columnCount = 4;
		if (injectRequired) {
			columnCaption = new String[] { "Field name", "Description", "Data type", "Array", "Inject" };
			columnWidth = new int[] { 100, 120, 120, 120, 120 };
			columnCount = 5;
		}

		final String[] columnCaptions = columnCaption;
		final int[] columnWidths = columnWidth;

		tableComposite = new TableComposite(this, SWT.NONE, columnCount, true, true, true, true, false) {

			@Override
			public int getColumnWidth(int index) {
				return columnWidths[index];
			}

			@Override
			public List<?> getData() {
				return fieldInfos;
			}

			@Override
			public String getColumnCaption(int index) {
				return columnCaptions[index];
			}

			@Override
			public String getTableColumnLabel(Object element, int columnIndex) {
				switch (columnIndex) {
				case 0:
					return ((FieldInfo) element).getName();
				case 1:
					return ((FieldInfo) element).getDescription();
				case 2:
					return ((FieldInfo) element).getDataType();
				case 3:
					return String.valueOf(((FieldInfo) element).isArray());
				case 4:
					return ((FieldInfo) element).getInjectText();
				default:
					return "";
				}
			}

			@Override
			public void doOperation(OperationType operationType, int index) {
				if (operationType.equals(OperationType.Add)) {
					AddParameterDialog addParameterDialog = new AddParameterDialog(getShell(), new FieldInfo(),
							injectRequired, workflowParamsInfo, false);
					addParameterDialog.setStepName(stepName);
					addParameterDialog.setGroupName(groupName);
					if (addParameterDialog.open() == Window.OK) {
						fieldInfos.add(addParameterDialog.getFieldInfo());
						if (evtManager != null) {
							evtManager.publish("Parameters", getFieldInfos());
						}
					}
				} else if (operationType.equals(OperationType.Del)) {
					fieldInfos.remove(index);
					if (evtManager != null) {
						evtManager.publish("Parameters", getFieldInfos());
					}
				} else if (operationType.equals(OperationType.Edit)) {
					FieldInfo fieldInfo = fieldInfos.get(index);
					AddParameterDialog addParameterDialog = new AddParameterDialog(getShell(), fieldInfo,
							injectRequired, workflowParamsInfo, false);
					addParameterDialog.setStepName(stepName);
					addParameterDialog.setGroupName(groupName);
					addParameterDialog.open();
					if (evtManager != null) {
						evtManager.publish("Parameters", getFieldInfos());
					}
				}
				tableComposite.refreshTable();
			}

			@Override
			protected void onMouseHover(Object object) {
				setToolTip(getTableColumnLabel(object, 1));
			}

		};
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}

	public List<FieldInfo> getFieldInfos() {
		return fieldInfos;
	}

	public FieldInfo getFieldInfo(String fieldName) {
		for (FieldInfo fieldInfo : fieldInfos) {
			if (fieldInfo.getName().equals(fieldName)) {
				return fieldInfo;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (!event.getPropertyName().equalsIgnoreCase("Parameters")) {
			List<FieldInfo> parameterFieldInfos = (List<FieldInfo>) event.getNewValue();
			if (parameterFieldInfos != null) {
				for (FieldInfo fieldInfo : fieldInfos) {
					previousFieldInfos.put(fieldInfo.getName(), fieldInfo);
				}
				List<FieldInfo> parametersToPublish = new ArrayList<FieldInfo>();
				for (FieldInfo parameter : parameterFieldInfos) {
					if (previousFieldInfos.containsKey(parameter.getName()) == false) {
						parametersToPublish.add(parameter);
					}
				}
				fieldInfos = parametersToPublish;
				fieldInfos.addAll(previousFieldInfos.values());
			}
			tableComposite.setViewerInput();
			tableComposite.refreshTable();
		} else {
			previousFieldInfos.clear();
			for (FieldInfo fieldInfo : fieldInfos) {
				previousFieldInfos.put(fieldInfo.getName(), fieldInfo);
			}
		}
	}

	@Override
	public void setEventManager(EventManager evtManager) {
		evtManager.subscribe(this);
		this.evtManager = evtManager;
	}

	public void publishParameters() {
		if (evtManager != null && fieldInfos != null) {
			evtManager.publish("Parameters", getFieldInfos());
		}
	}
}