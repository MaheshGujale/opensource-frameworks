/*
 * generated by Xtext
 */
package org.br.excel.exceldsl.ui.contentassist;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import businessrulesruntime.core.engine.excel.ExcelFormulaContentProvider;
import businessrulesruntime.core.engine.excel.ExcelFunctionInfo;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to
 * customize content assistant
 */
public class ExcelDSLProposalProvider extends AbstractExcelDSLProposalProvider {
	ExcelFormulaContentProvider excelFormulaContentProvider = ExcelFormulaContentProvider.getInstance();
	Image imageMethod = ResourceManager.getPluginImage("org.br.excel.exceldsl.ui", "icons/icon_method.gif");
	Image imageVariable = ResourceManager.getPluginImage("org.br.excel.exceldsl.ui", "icons/icon_variable.gif");
	Image imageInBuildFunction = ResourceManager.getPluginImage("org.br.excel.exceldsl.ui",
			"icons/icon_functions.gif");

	public void complete_BasicExpression(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.complete_BasicExpression(model, ruleCall, context, acceptor);
		if (excelFormulaContentProvider.getVariableNames() != null) {
			for (String variableName : excelFormulaContentProvider.getVariableNames()) {
				acceptor.accept(createCompletionProposal(variableName, variableName, imageVariable, context));
			}
		}
	}

	@Override
	public void complete_ExcelFunction(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.complete_ExcelFunction(model, ruleCall, context, acceptor);
		if (excelFormulaContentProvider.getInBuildFunction() != null) {
			for (Iterator<ExcelFunctionInfo> iterator = excelFormulaContentProvider.getInBuildFunction()
					.iterator(); iterator.hasNext();) {
				ExcelFunctionInfo excelFunctionInfo = iterator.next();
				acceptor.accept(createCompletionProposal(excelFunctionInfo.getSyntax(), excelFunctionInfo.getName(),
						imageInBuildFunction, context));
			}
		}
	}
}
