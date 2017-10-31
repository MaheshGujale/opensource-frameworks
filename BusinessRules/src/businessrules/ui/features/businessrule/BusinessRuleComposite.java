package businessrules.ui.features.businessrule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.thoughtworks.xstream.XStream;

import businessrules.Activator;
import businessrules.ui.utils.OperationType;
import businessrules.ui.utils.TableComposite;
import businessrulesruntime.core.engine.BusinessRuleInfo;
import businessrulesruntime.core.engine.FieldInfo;
import businessrulesruntime.core.engine.IContext;
import businessrulesruntime.core.engine.IMessage;

@SuppressWarnings("rawtypes")
public class BusinessRuleComposite extends Composite {

	public static final String commonCategory = "common";
	public static final String Const_BizflowRule = "$$$BizflowRule$$$";

	private TableComposite tableComposite;
	private Composite categoryComposite;
	private Composite categoryTitleComposite;
	private CLabel lblTitle;
	private ToolBar tbrOptions;
	private ToolItem toolItemAdd;
	private ToolItem toolItemDelete;
	private ToolItem toolItemUp;
	private ToolItem toolItemDown;
	private org.eclipse.swt.widgets.List lstCategories;
	private Table tblBase;
	private Table tblReference;

	final String[] columnCaptions = new String[] { "Rule name" };
	final int[] columnWidths = new int[] { 350 };
	private Map<String, List<BusinessRuleInfo>> businessRuleInfos = new LinkedHashMap<String, List<BusinessRuleInfo>>();
	private List<BusinessRuleInfo> bRuleList;
	private String selectedCategory;
	private List<String> categories = new ArrayList<String>();
	private String groupName;
	private String stepName;

	public BusinessRuleComposite(Composite parent, int style, String groupName, String stepName) {
		super(parent, style);
		this.groupName = groupName;
		this.stepName = stepName;
		GridLayout parentGridLayout = new GridLayout(2, false);
		parentGridLayout.horizontalSpacing = 0;
		parentGridLayout.marginLeft = 0;
		setLayout(parentGridLayout);
		createCompositeArea();
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	protected void createCompositeArea() {
		SashForm sashForm = new SashForm(this, SWT.NONE);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		categoryComposite = new Composite(sashForm, SWT.NONE);
		categoryComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout categoryCompositeLayout = new GridLayout(1, false);
		categoryCompositeLayout.marginHeight = 0;
		categoryCompositeLayout.marginLeft = 5;
		categoryCompositeLayout.marginWidth = 0;
		categoryCompositeLayout.verticalSpacing = 0;
		categoryCompositeLayout.marginTop = -1;
		categoryCompositeLayout.horizontalSpacing = 0;
		categoryComposite.setLayout(categoryCompositeLayout);

		categoryTitleComposite = new Composite(categoryComposite, SWT.NONE);
		categoryTitleComposite.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, true, false, 1, 1));
		GridLayout categoryTitleCompositeLayout = new GridLayout(2, false);
		categoryTitleCompositeLayout.marginWidth = 0;
		categoryTitleCompositeLayout.marginHeight = 0;
		categoryTitleCompositeLayout.marginLeft = -1;
		categoryTitleCompositeLayout.marginRight = 0;
		categoryTitleCompositeLayout.marginTop = -1;
		categoryTitleCompositeLayout.horizontalSpacing = -1;
		categoryTitleCompositeLayout.verticalSpacing = -1;
		categoryTitleComposite.setLayout(categoryTitleCompositeLayout);
		{
			lblTitle = new CLabel(categoryTitleComposite, SWT.NONE);
			lblTitle.setText("Category :");
			GridData lblTitleGData = new GridData();
			lblTitleGData.horizontalAlignment = SWT.LEFT;
			lblTitleGData.verticalAlignment = SWT.RIGHT;
			lblTitleGData.horizontalIndent = 0;
			lblTitleGData.verticalIndent = 0;
		}
		{
			tbrOptions = new ToolBar(categoryTitleComposite, SWT.NONE);
			{
				toolItemAdd = new ToolItem(tbrOptions, SWT.NONE);
				toolItemAdd.setImage(Activator.getImageDescriptor("/icons/icon_category_add.png").createImage());
				toolItemAdd.setToolTipText("Add");
				toolItemAdd.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						onAddCategory();
					}
				});
			}
			{
				toolItemDelete = new ToolItem(tbrOptions, SWT.NONE);
				toolItemDelete.setImage(Activator.getImageDescriptor("/icons/icon_category_delete.png").createImage());
				toolItemDelete.setToolTipText("Delete");
				toolItemDelete.setEnabled(false);
				toolItemDelete.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						onDeleteCategory();
					}
				});
			}
			{
				toolItemUp = new ToolItem(tbrOptions, SWT.NONE);
				toolItemUp.setImage(Activator.getImageDescriptor("/icons/icon_previous.png").createImage());
				toolItemUp.setToolTipText("Up");
				toolItemUp.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						onUpCategory();
					}
				});
			}
			{
				toolItemDown = new ToolItem(tbrOptions, SWT.NONE);
				toolItemDown.setImage(Activator.getImageDescriptor("/icons/icon_next.png").createImage());
				toolItemDown.setToolTipText("Down");
				toolItemDown.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						onDownCategory();
					}
				});
			}
		}

		lstCategories = new org.eclipse.swt.widgets.List(categoryComposite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		lstCategories.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lstCategories.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				int index = lstCategories.getSelectionIndex();
				if (index != -1) {
					onCategorySelect(index);
					enableDisableDeleteCategoryBtn();
				}
			}
		});
		lstCategories.addListener(SWT.MouseDoubleClick, new Listener() {

			@Override
			public void handleEvent(Event event) {
				int index = lstCategories.getSelectionIndex();
				onEditCategory(lstCategories.getItem(index));
			}
		});

		tableComposite = new InnerTableComposite(sashForm, SWT.NONE, 1, true, true, true, true);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableComposite.addPopupMenu();
		sashForm.setWeights(new int[] { 26, 74 });
	}

	public void populateAllCategories() {
		// populate all category from businessRuleInfos
		categories.clear();
		Set<String> categorySet = businessRuleInfos.keySet();
		if (!categorySet.contains(commonCategory)) {
			categories.add(commonCategory);
		}
		categories.addAll(categorySet);
		populateCategoryList();

		// select first category
		onCategorySelect(0);
		enableDisableDeleteCategoryBtn();
	}

	private void enableDisableDeleteCategoryBtn() {
		if (selectedCategory.equals(commonCategory)) {
			toolItemDelete.setEnabled(false);
		} else {
			toolItemDelete.setEnabled(true);
		}
	}

	private void onCategorySelect(int index) {
		selectedCategory = lstCategories.getItem(index);
		tableComposite.setViewerInput();
		tableComposite.refreshTable();
		lstCategories.setSelection(index);
	}

	protected void populateCategoryList() {
		lstCategories.removeAll();
		if (categories != null && categories.size() != 0) {
			for (String category : categories) {
				if (category != null) {
					lstCategories.add(category);
				}
			}
		}
	}

	protected void onAddCategory() {
		AddCategoryDialog categoryDialog = new AddCategoryDialog(getShell(), categories, null);
		if (categoryDialog.open() == Window.OK) {
			selectedCategory = categoryDialog.getCategoryName();
			categories.add(selectedCategory);
			populateCategoryList();
			onCategorySelect(categories.indexOf(selectedCategory));
			enableDisableDeleteCategoryBtn();
		}
	}

	protected void onEditCategory(String category) {
		if (category.equals(commonCategory) == false) {
			AddCategoryDialog categoryDialog = new AddCategoryDialog(getShell(), categories, category);
			if (categoryDialog.open() == Window.OK) {
				selectedCategory = categoryDialog.getCategoryName();
				if (categoryDialog.getCategoryName().equals(category) == false) {
					int index = categories.indexOf(category);
					categories.remove(index);
					categories.add(index, selectedCategory);
					if (businessRuleInfos.get(category) != null) {
						List<BusinessRuleInfo> businessRules = businessRuleInfos.remove(category);
						businessRuleInfos.put(selectedCategory, businessRules);
					}
					populateCategoryList();
				}
				lstCategories.setSelection(new String[] { selectedCategory });
				onCategorySelect(lstCategories.getSelectionIndex());
			}
		}
	}

	protected void onDeleteCategory() {
		int index = categories.indexOf(selectedCategory);
		if (index > 0) {
			if (MessageDialog.openConfirm(getShell(), "Confirm", "Are you sure you want to delete '" + selectedCategory
					+ "' category?")) {
				categories.remove(selectedCategory);
				populateCategoryList();
				if (index < categories.size()) {
					onCategorySelect(index);
					enableDisableDeleteCategoryBtn();
				}
			}
		}
	}

	protected void onDownCategory() {
		int index = lstCategories.getSelectionIndex();
		if (index != -1 && index < categories.size() - 1) {
			Collections.swap(categories, index, index + 1);
			populateCategoryList();
			onCategorySelect(index + 1);
		}
	}

	protected void onUpCategory() {
		int index = lstCategories.getSelectionIndex();
		if (index != -1 && index > 0) {
			Collections.swap(categories, index, index - 1);
			populateCategoryList();
			onCategorySelect(index - 1);
		}
	}

	public Map<String, List<BusinessRuleInfo>> getBusinessRuleInfos() {
		Map<String, List<BusinessRuleInfo>> businessRuleMap = new LinkedHashMap<String, List<BusinessRuleInfo>>();
		List<BusinessRuleInfo> businessRuleList;
		for (String category : categories) {
			if (category != null) {
				businessRuleList = businessRuleInfos.remove(category);
				if (businessRuleList != null) {
					businessRuleMap.put(category, businessRuleList);
				} else {
					businessRuleMap.put(category, new ArrayList<BusinessRuleInfo>());
				}
			}
		}
		return businessRuleMap;
	}

	public class InnerTableComposite extends TableComposite {

		public InnerTableComposite(Composite parent, int style, int columnCount, boolean addReq, boolean delReq,
				boolean editReq, boolean arrange) {
			super(parent, style, columnCount, addReq, delReq, editReq, arrange, false);
		}

		@Override
		public int getColumnWidth(int index) {
			return columnWidths[index];
		}

		@Override
		public List<?> getData() {
			if (selectedCategory == null) {
				return null;
			}
			bRuleList = businessRuleInfos.get(selectedCategory);
			if (bRuleList == null) {
				bRuleList = new ArrayList<BusinessRuleInfo>();
				businessRuleInfos.put(selectedCategory, bRuleList);
			}
			return bRuleList;
		}

		@Override
		public String getColumnCaption(int index) {
			return columnCaptions[index];
		}

		@Override
		public String getTableColumnLabel(Object element, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return ((BusinessRuleInfo) element).getDisplayName();
			default:
				return "";
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void doOperation(OperationType operationType, int index) {
			bRuleList = businessRuleInfos.get(selectedCategory);
			List<String> returnTypeRequiredList = new ArrayList<String>();
			returnTypeRequiredList.add("int");
			returnTypeRequiredList.add("boolean");
			if (operationType.equals(OperationType.Add)) {
				BusinessRuleInfo<IMessage, IContext> businessRuleInfo = new BusinessRuleInfo<IMessage, IContext>(null,
						null, null);
				AddBusinessRuleDialog addBusinessRuleDialog = new AddBusinessRuleDialog(getShell(), businessRuleInfo,
						"Add BusinessRule", "Provide BusinessRule details", "Rule", groupName, stepName, true,
						returnTypeRequiredList, getBusinessRuleNames(getRuleList()));
				if (addBusinessRuleDialog.open() == Window.OK) {
					bRuleList.add(addBusinessRuleDialog.getBusinessRuleInfo());
				}
			} else if (operationType.equals(OperationType.Del)) {
				bRuleList.remove(index);
			} else if (operationType.equals(OperationType.Edit)) {
				BusinessRuleInfo<IMessage, IContext> businessRuleInfo = bRuleList.get(index);
				Set<String> businessRuleNames = getBusinessRuleNames(getRuleList());
				businessRuleNames.remove(businessRuleInfo.getName());
				AddBusinessRuleDialog businessRuleDialog = new AddBusinessRuleDialog(getShell(), businessRuleInfo,
						"Edit BusinessRule", "Provide BusinessRule details", "Rule", groupName, stepName, true,
						returnTypeRequiredList, businessRuleNames);
				if (businessRuleDialog.open() == Window.OK) {
					bRuleList.set(index, businessRuleDialog.getBusinessRuleInfo());
				}
			}
			tableComposite.refreshTable();
		}

		@SuppressWarnings("unchecked")
		@Override
		protected int[] copyFromTable() {
			XStream stream = new XStream();
			List<BusinessRuleInfo<IMessage, IContext>> businessRuleInfos = new ArrayList<BusinessRuleInfo<IMessage, IContext>>();
			Clipboard clipboard = new Clipboard(getShell().getDisplay());
			int[] selectedIndices = super.copyFromTable();
			for (int index : selectedIndices) {
				businessRuleInfos.add(bRuleList.get(index));
			}
			clipboard.setContents(new Object[] { Const_BizflowRule + stream.toXML(businessRuleInfos) },
					new Transfer[] { TextTransfer.getInstance() });
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void pasteOnTable() {
			XStream stream = new XStream();
			Clipboard clipboard = new Clipboard(getShell().getDisplay());
			String clipboardText = (String) clipboard.getContents(TextTransfer.getInstance());

			if (clipboardText != null && clipboardText.startsWith(Const_BizflowRule)) {
				try {
					List<BusinessRuleInfo<IMessage, IContext>> businessRuleInfos = (List<BusinessRuleInfo<IMessage, IContext>>) stream
							.fromXML(clipboardText.replace(Const_BizflowRule, ""));
					String error = checkForDuplicateRule(businessRuleInfos);
					if (error.equals("") == false) {
						MessageDialog.openError(getShell(), "Error", error);
					} else {
						bRuleList.addAll(businessRuleInfos);
						tableComposite.refreshTable();
					}
				} catch (Exception exception) {
					MessageDialog.openError(getShell(), "Error", "Copied content is improper");
				}
			}
		}

		@SuppressWarnings("unchecked")
		private String checkForDuplicateRule(List<BusinessRuleInfo<IMessage, IContext>> businessRuleInfos) {
			String error = "";
			for (BusinessRuleInfo<IMessage, IContext> bRuleInfo : businessRuleInfos) {
				for (BusinessRuleInfo<IMessage, IContext> businessRuleInfo : bRuleList) {
					if (bRuleInfo.getName().equalsIgnoreCase(businessRuleInfo.getName())) {
						error = "Rule " + bRuleInfo.getName() + " allready exists";
						break;
					}
				}
			}
			return error;
		}

		private Set<String> getBusinessRuleNames(List<BusinessRuleInfo> businessRuleInfos) {
			Set<String> ruleNames = new HashSet<String>();
			for (BusinessRuleInfo businessRuleInfo : businessRuleInfos) {
				ruleNames.add(businessRuleInfo.getName());
			}
			return ruleNames;
		}
	}

	public void setBusinessRuleInfos(Map<String, List<BusinessRuleInfo>> businessRuleInfos) {
		if (businessRuleInfos != null) {
			this.businessRuleInfos = businessRuleInfos;
		}
		populateAllCategories();
	}

	public List<BusinessRuleInfo> getRuleList() {
		List<BusinessRuleInfo> ruleInfos = new ArrayList<BusinessRuleInfo>();
		for (Map.Entry<String, List<BusinessRuleInfo>> entry : businessRuleInfos.entrySet()) {
			ruleInfos.addAll(entry.getValue());
		}
		return ruleInfos;
	}
}
