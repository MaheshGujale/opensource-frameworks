/*
 * generated by Xtext
 */
package org.br.excel.exceldsl.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;

public class AbstractExcelDSLValidator extends org.eclipse.xtext.validation.AbstractDeclarativeValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.br.excel.exceldsl.excelDSL.ExcelDSLPackage.eINSTANCE);
		return result;
	}
}