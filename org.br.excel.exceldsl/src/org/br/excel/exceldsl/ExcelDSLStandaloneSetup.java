/*
* generated by Xtext
*/
package org.br.excel.exceldsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExcelDSLStandaloneSetup extends ExcelDSLStandaloneSetupGenerated{

	public static void doSetup() {
		new ExcelDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

