/*
* generated by Xtext
*/
package org.br.excel.exceldsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ExcelDSLAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/br/excel/exceldsl/parser/antlr/internal/InternalExcelDSL.tokens");
	}
}
