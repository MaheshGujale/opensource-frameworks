<list>
  <ExcelFunctionInfo>
    <name>IF</name>
    <groupName>Standard</groupName>
    <description>The IF function returns one value if a condition you specify evaluates to TRUE, and another value if that condition evaluates to FALSE.</description>
    <syntax>IF(logicalTest, valueIfTrue, valueIfFalse)</syntax>
    <syntaxDescription>The IF function syntax has the following arguments:
 logical_test-  Required. Any value or expression that can be evaluated to TRUE or FALSE.
 valueIfTrue-  Required. The value that you want to be returned if the logicalTest argument evaluates to TRUE.
 valueIfFalse-Required. The value that you want to be returned if the logicalTest argument evaluates to FALSE.</syntaxDescription>
    <example>IF(EXACT(DE-7,&quot;0420&quot;), 1, 0)</example>
    <exampleDescription>If the value of the field DE-7 is equal to the &quot;0420&quot;, it returns the value 1. Otherwise, it returns the value 0.</exampleDescription>
    <code></code>
    <imports></imports>
    <returnType></returnType>
    <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
      <name>AND</name>
      <groupName>Standard</groupName>
      <description>The AND function returns TRUE if all of its arguments are TRUE; returns FALSE if one or more arguments evaluate to FALSE.</description>
      <syntax>AND(condition1, condition2, [condition3],.. [condition5])</syntax>
      <syntaxDescription>The AND function syntax has the following arguments:
   condition1- Required. The first condition that you want to test that can evaluate to either TRUE or FALSE.
   condition2- Required. The second condition that you want to test that can evaluate to either TRUE or FALSE.
   [condition3],.. [condition5]-Optional. Additional conditions that you want to test that can evaluate to either TRUE or FALSE, up to a total of 5 tests.</syntaxDescription>
      <example>AND(EXACT(DE-0, &quot;0430&quot;), EXACT(DE-1, &quot;0080&quot;), STARTSWITH(DE-3, &quot;17&quot;, 0))</example>
      <exampleDescription>Returns true if the DE-0 field value is equal to &quot;0430&quot; 
  and DE-1 field value is equal to &quot;0080&quot; 
  and if the DE-3 field value beginning from index &quot;0&quot;, starts with &quot;17&quot;; returns FALSE if any one of the conditions evaluate to FALSE.</exampleDescription>
    <code></code>
      <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
      <systemDefined>true</systemDefined>
    </ExcelFunctionInfo>
    <ExcelFunctionInfo>
      <name>OR</name>
      <groupName>Standard</groupName>
      <description>The OR function returns TRUE if any argument is TRUE; returns FALSE if all arguments are FALSE.</description>
      <syntax>OR(condition1, condition2, [condition3],.. [condition5])</syntax>
      <syntaxDescription>The OR function syntax has the following arguments:
   condition1- Required. The first condition that you want to test that can evaluate to either TRUE or FALSE.
   condition2- Required. The second condition that you want to test that can evaluate to either TRUE or FALSE.
   [condition3],.. [condition5]-Optional. Additional conditions that you want to test that can evaluate to either TRUE or FALSE, up to a total of 5 tests.</syntaxDescription>
      <example>OR(EXACT(DE-5, &quot;0030&quot;), EXACT(DE-1, &quot;0180&quot;), STARTSWITH(DE-3, &quot;17&quot;, 0))</example>
      <exampleDescription>Returns true if the DE-5 field value is equal to &quot;0030&quot; 
  or DE-1 field value is equal to &quot;0180&quot; 
  or if the DE-3 field value beginning from index &quot;0&quot;, starts with &quot;17&quot;; returns FALSE if all the conditions evaluate to FALSE.</exampleDescription>
    <code></code>
      <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
      <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>SUM</name>
    <groupName>Standard</groupName>
    <description>The SUM function adds all the numbers that you specify as arguments. Each argument can be a constant, a fieldName or the result from another function.</description>
    <syntax>SUM(expression...)</syntax>
    <syntaxDescription>The SUM function syntax has the following arguments:
 expression1-  Required. The first item that you want to add. Expression can be a constant, fieldName or the result from another function.
 expression2-  Required. The second item that you want to add.
 [expression3],.. [expression5]- Optional. The remaining expressions that you want to add, up to a total of 5 expressions.</syntaxDescription>
    <example>SUM(DE-1, DE-2, &quot;1&quot;, &quot;80&quot;, INT(DE-4))</example>
    <exampleDescription>Adds the value of fields DE-1 and DE-2 and then adds 1 to that result, then adds 80 to that result and then adds the int value of the field DE-4.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>INT</name>
    <groupName>Standard</groupName>
    <description>The INT function rounds a number down to the nearest integer.Argument can be a constant or fieldName.</description>
    <syntax>INT(expression)</syntax>
    <syntaxDescription>The INT function syntax has the following arguments:
 expression-  It can be a constant or the fieldName, you want to round down to an integer.</syntaxDescription>
    <example>INT(DE-9)</example>
    <exampleDescription>Returns the rounded value of a field DE-9.
 INT(8.9) Rounds 8.9 down (8)</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LUHN</name>
    <groupName>Standard</groupName>
    <description>The LUHN function validates the card number.</description>
    <syntax>LUHN(expression)</syntax>
    <syntaxDescription>The LUHN function syntax has the following arguments:
 expression-  It can be a constant or the fieldName, you want to validate.</syntaxDescription>
    <example>LUHN(primaryAccountNumber)</example>
    <exampleDescription>Returns true if number is as per Luhn algorithm.
 LUHN(5454540000054820) returns true</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>SUBSTR</name>
    <groupName>Standard</groupName>
    <description>The SUBSTR function returns the substring of the value of the given fieldName or of the constant.
 The substring begins at the specified beginIndex -1 and extends to the character at index endIndex - 1.</description>
    <syntax>SUBSTR(expression, beginIndex, endIndex)</syntax>
    <syntaxDescription>The SUBSTR function syntax has the following arguments:
 expression-  Required. It can be a constant or the fieldName, from which you want to get the substring.
 beginIndex- Required. The beginning Index. It should be a positive integer value, greater than 0 and it should be less than endIndex.
 endIndex- Required. The ending Index. The endIndex should be less than the length of the specified constant value or the specified field value.</syntaxDescription>
    <example>SUBSTR(&quot;stringvalue&quot;, 1, 3)</example>
    <exampleDescription>returns the &quot;str&quot; as a result.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LENGTH</name>
    <groupName>Standard</groupName>
    <description>The LENGTH function returns the number of characters in the value of a given field or in a constant value.</description>
    <syntax>LENGTH(expression)</syntax>
    <syntaxDescription>The LENGTH function syntax has the following arguments:
 expression-  It can be a constant or the fieldName.</syntaxDescription>
    <example>LENGTH(DE-1)</example>
    <exampleDescription>It returns the number of characters in a value of DE-1 field.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>INDEXOF</name>
    <groupName>Standard</groupName>
    <description>The INDEXOF function returns the index of first occurrence of the specified string in the given expression result value.
If the string argument occurs as a substring within the expression result, then the index of the first character of the first such substring is returned;
 if it does not occur as a substring, -1 is returned.</description>
    <syntax>INDEXOF(expression, string)</syntax>
    <syntaxDescription>The INDEXOF function syntax has the following arguments:
 expression-  Required. It can be a constant or the fieldName, from which you want to get the index of the specified string.
 string- Required. the string</syntaxDescription>
    <example>INDEXOF(DE-8, &quot;00&quot;)</example>
    <exampleDescription>It returns the index of string &quot;00&quot; in the value of the field DE-8. 
 If DE-8 has value &quot;0800&quot;, then it returns the index as 2.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LONG</name>
    <groupName>Standard</groupName>
    <description>The LONG function parses the given string and returns the long value.Argument can be a constant or fieldName.</description>
    <syntax>LONG(expression)</syntax>
    <syntaxDescription>The LONG function syntax has the following arguments:
 expression-  It can be a constant or the fieldName, or the result from another function, from which you want to get long value.</syntaxDescription>
    <example>LONG(DE-9)</example>
    <exampleDescription>Returns the long value for a field DE-9.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>DOUBLE</name>
    <groupName>Standard</groupName>
    <description>The DOUBLE function parses the given string and returns the double value.Argument can be a constant or fieldName.</description>
    <syntax>DOUBLE(expression)</syntax>
    <syntaxDescription>The DOUBLE function syntax has the following arguments:
 expression-  It can be a constant or the fieldName, or the result from another function, from which you want to get double value.</syntaxDescription>
    <example>DOUBLE(DE-9)</example>
    <exampleDescription>Returns the double value for a field DE-9.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LEFT</name>
    <groupName>Standard</groupName>
    <description>The LEFT function returns the leftmost characters in a value of the given expression, based on the number of characters you specify.</description>
    <syntax>LEFT(expression, numChars)</syntax>
    <syntaxDescription>The LEFT function syntax has the following arguments:
 expression- Required. It can be a constant, fieldName, or the result from another function.
 numChars-Required. It specifies the number of characters you want LEFT to extract.
 numChars must be greater than or equal to zero.
 If numChars is greater than the length of text, LEFT returns all of text.</syntaxDescription>
    <example>LEFT(DE-8, 2)</example>
    <exampleDescription>If DE-8 has value &quot;01700&quot;, it returns the first two characters, &quot;01&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>RIGHT</name>
    <groupName>Standard</groupName>
    <description>The RIGHT function returns the rightmost characters in a value of the given expression, based on the number of characters you specify.</description>
    <syntax>RIGHT(expression, numChars)</syntax>
    <syntaxDescription>The RIGHT function syntax has the following arguments:
 expression- Required. It can be a constant, fieldName, or the result from another function.
 numChars-Required. It specifies the number of characters you want RIGHT to extract.
 numChars must be greater than or equal to zero.
 If numChars is greater than the length of text, RIGHT returns all of text.</syntaxDescription>
    <example>RIGHT(DE-4, 3)</example>
    <exampleDescription>If DE-4 has value &quot;0090&quot;, it returns the last three characters, &quot;090&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>REPLACE</name>
    <groupName>Standard</groupName>
    <description>The REPLACE function replaces part of the given field value, based on the number of characters you specify, with a different text string</description>
    <syntax>REPLACE(expression, beginIndex, numChars, newString)</syntax>
    <syntaxDescription>The REPLACE function syntax has the following arguments:
 expression- Required. It can be a constant or fieldName, or the result from another function
 beginIndex- Required. The position of the character in expression value that you want to replace with newString.
 numChars- Required. The number of characters in expression value that you want REPLACE to replace with newString.
 newString- Required. The text that will replace characters in expression value.</syntaxDescription>
    <example>REPLACE(DE-8, 3, 2, &quot;80&quot;)</example>
    <exampleDescription>It replaces the 2 characters starting with the 3rd character by &quot;80&quot; in the DE-8 field value.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>EXACT</name>
    <groupName>Standard</groupName>
    <description>The EXACT function returns true if the value of the given field is equal to the specified value else it returns false.</description>
    <syntax>EXACT(expression, expression)</syntax>
    <syntaxDescription>The EXACT function syntax has the following arguments:
 fieldName- Required.the fieldName.
 expression- Required. It can be a constant or fieldName, or the result from another function.</syntaxDescription>
    <example>EXACT(DE-6, &quot;0430&quot;)</example>
    <exampleDescription>In the above example, it returns true if the DE-6 value is equal to the &quot;0430&quot;; else it returns false.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>TRIM</name>
    <groupName>Standard</groupName>
    <description>The TRIM function removes the leading and trailing whitespace from the given text.</description>
    <syntax>TRIM(expression)</syntax>
    <syntaxDescription>The TRIM function syntax has the following arguments:
 expression- The expression can be a constant or fieldName, or the result from another function, from which you want spaces removed.</syntaxDescription>
    <example>TRIM(DE-5)</example>
    <exampleDescription>It returns the value of the field DE-5 with the leading and trailing whitespace removed.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LOWER</name>
    <groupName>Standard</groupName>
    <description>The LOWER function converts the all the characters in the text to lower case.</description>
    <syntax>LOWER(expression)</syntax>
    <syntaxDescription>The LOWER function syntax has the following arguments:
 expression- The expression can be a constant or fieldName.</syntaxDescription>
    <example>LOWER(DE-11)</example>
    <exampleDescription>It converts the characters in the value of the field DE-11 to lower case. If DE-11 has value &quot;STRING&quot;, then LOWER(DE-11)  returns &quot;string&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>UPPER</name>
    <groupName>Standard</groupName>
    <description>The UPPER function converts the all the characters in the text to upper case.</description>
    <syntax>UPPER(expression)</syntax>
    <syntaxDescription>The UPPER function syntax has the following arguments:
 expression- The expression can be a constant or fieldName.</syntaxDescription>
    <example>UPPER(DE-11)</example>
    <exampleDescription>It converts the characters in the value of the field DE-11 to upper case. If DE-11 has value &quot;string&quot;, then UPPER(DE-11)  returns &quot;STRING&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>STARTSWITH</name>
    <groupName>Standard</groupName>
    <description>The STARTSWITH function returns true if the value of the given field starts with the given value beginning a specified index else it returns false.
The result is false if beginIndex is negative or greater than the length of the value of the given field.</description>
    <syntax>STARTSWITH(fieldName, whatString, beginIndex)</syntax>
    <syntaxDescription>The STARTSWITH function syntax has the following arguments:
 fieldName-  Required. the functionname of the field of which the value needs to be checked.
 whatString- Required. the string to check as a prefix of the substring beginning at the specified index. 
 beginIndex- Required the beginning index. Note that the index is zero based.</syntaxDescription>
    <example>STARTSWITH(DE-5, &quot;08&quot;, 2)</example>
    <exampleDescription>If the DE-5 field value is &quot;0008&quot;, the STARTSWITH(DE-5, &quot;08&quot;, 2) returns true.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>NOW</name>
    <groupName>Standard</groupName>
    <description>The NOW function returns the system date and time in the specified format.</description>
    <syntax>NOW()</syntax>
    <syntaxDescription></syntaxDescription>
    <example>NOW()</example>
    <exampleDescription>It returns the current date and time.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>STR</name>
    <groupName>Standard</groupName>
    <description>The STR function returns the specified object as a String.</description>
    <syntax>STR(object)</syntax>
    <syntaxDescription>The STR function syntax has the following arguments:
 object- the object to be converted into String.</syntaxDescription>
    <example>STR(IF(EXACT(DE-54, &quot;0080&quot;), &quot;+&quot;, &quot;-&quot;))</example>
    <exampleDescription>If DE-54 has the value &quot;0080&quot;, then IF function returns the &quot;+&quot; as a object.
The STR function converts the object into the String and returns it.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>CONCAT</name>
    <groupName>Standard</groupName>
    <description>The CONCAT function concatenates the concatValue to the expression result value depending on the paddingType.</description>
    <syntax>CONCAT(expression, concatValue, paddingType)</syntax>
    <syntaxDescription>The CONCAT function syntax has the following arguments:
 expression-  Required. It can be a constant or the fieldName, to which you want to concatenate the specified concatValue.
 concatValue- Required. the concat value that is to be concatenated to the value returned by the expression. 
 paddingType- Required. The padding type value can be &quot;LEFT&quot; or &quot;RIGHT&quot;. 
	If the paddingType is &quot;LEFT&quot;, the concatValue is concatenated to the start of the expression value, else it is concatenated to the end of the expression value.</syntaxDescription>
    <example>CONCAT(DE-1, &quot;17&quot;, &quot;LEFT&quot;)</example>
    <exampleDescription>It concatenates the &quot;17&quot; to the start of the value of the field DE-1.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>CONCATENATE</name>
    <groupName>Standard</groupName>
    <description>The CONCATENATE function concatenates the given concat values to the right of the given expression result value.</description>
    <syntax>CONCATENATE(expression, concatValue...)</syntax>
    <syntaxDescription>The CONCATENATE function syntax has the following arguments:
 expression-  Required. It can be a constant or the fieldName, to which you want to concatenate the specified concatValues.
 concatValue1- Required. the first concatValue that is to be concatenated to the end of the value returned by the expression. 
 concatValue2- Required. the second concatValue that is to be concatenated.
 [concatValue3],.. [concatValue5]- Optional. The remaining concatValues that you want to concatenate, up to a total of 5 values.</syntaxDescription>
    <example>CONCATENATE(DE-2, &quot;1&quot;, &quot;10&quot;)</example>
    <exampleDescription>It concatenates &quot;1&quot; to the right of the value of the field DE-2 and then concatenates &quot;10&quot; to the concatenated value.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>DATEFORMAT</name>
    <groupName>Standard</groupName>
    <description>The DATEFORMAT function formats the value of given expression to the specified format and it returns the formatted value as String.</description>
    <syntax>DATEFORMAT(date, [inFormat], outFormat)</syntax>
    <syntaxDescription>The DATEFORMAT function syntax has the following arguments:
 date-  Required. It can be a Date or String. 
If the inFormat is given, then expression should be a String.
 If the expression is Date, then inFormat is not Required.
 inFormat- Optional. The input format of the String value 
 outFormat- Required. The required format of the given date.

Note:Date and time formats are specified by date and time pattern strings.
The following pattern letters are defined:
Letter		Date or Time Component		Examples
	y			Year										1996; 96
	M			Month in year						July; Jul; 07
	D			Day in year							189
	d			Day in month						10
	a			Am/pm marker						PM
	H			Hour in day (0-23)				0
	k			Hour in day (1-24)				24
	K			Hour in am/pm (0-11)			0
	h			Hour in am/pm (1-12)			12
	m			Minute in hour						30
	s			Second in minute					55
	S			Millisecond							978
</syntaxDescription>
    <example>DATEFORMAT(NOW(), &quot;dd-MM-yyyy&quot;)</example>
    <exampleDescription>If NOW() has the value as &quot;12-04-2008&quot;, it returns the result as &quot;04-12-2008&quot;.
 DATEFORMAT(DE-5, &quot;MM-dd-yyyy&quot;, &quot;dd-MM-yyyy&quot;)
If DE-5 has the value as &quot;11-14-2009&quot;, it returns the result as &quot;14-11-2009&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>MID</name>
    <groupName>Standard</groupName>
    <description>The MID function returns a specific number of characters from a field value starting at the position you specify, based on the number of characters you specify.</description>
    <syntax>MID(expression, beginIndex, numChars)</syntax>
    <syntaxDescription>The MID function syntax has the following arguments:
 expression- Required. It can be a constant, fieldName, or the result from another function.
 beginIndex- Required. The position of the first character you want to extract in text.It should be greater than or equal to 1.
 	If start_num is greater than the length of text, MID returns &quot;&quot; 
 	If startNum is less than the length of text, but startNum plus numChars exceeds the length of text, MID returns the characters up to the end of text. 
 numChars-Required. It specifies the number of characters you want MID to return from text.
 numChars must be greater than or equal to zero.</syntaxDescription>
    <example>MID(DE-9, 4, 2)</example>
    <exampleDescription>If DE-9 has the value &quot;017010&quot;, it returns the result as &quot;01&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>SUBSTITUTE</name>
    <groupName>Standard</groupName>
    <description>The SUBSTITUTE function substitutes new value for old value in the value of a specified field. 
If the instanceNum is specified, then only that occurence gets replaced.</description>
    <syntax>SUBSTITUTE(expression, oldString, newString, [instanceNum])</syntax>
    <syntaxDescription>The SUBSTITUTE function syntax has the following arguments:
 expression- Required. It can be a constant, fieldName,  or the result from another function
 oldString- Required. The text you want to replace.
 newString- Required. The text you want to replace oldString with.
 instanceNum- Optional. specifies which occurrence of oldString you want to replace with newString. If you specify instanceNum, only that instance of oldString is replaced. Otherwise, every occurrence of oldString in text is changed to newString.</syntaxDescription>
    <example>SUBSTITUTE(DE-8, &quot;00&quot;, &quot;08&quot;, 1)</example>
    <exampleDescription>If DE-8 has the value &quot;09001700&quot;, then the above SUBSTITUTE function call will result into DE-8 value as &quot;09081700&quot;.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>SEARCH</name>
    <groupName>Standard</groupName>
    <description>The SEARCH function locate one text string within a second text string, 
 and return the number of the starting position of the first text string from the first character of the second text string.(not case-sensitive)</description>
    <syntax>SEARCH(findExpression, withInExpression, beginIndex)</syntax>
    <syntaxDescription>The SEARCH function syntax has the following arguments:
 findExpression- Required. The expression can be a constant or fieldName, or the result from another function.
 If it is not found in withinExpression, then SEARCH function returns result as -1.
 withInExpression- Required. It can be a constant or fieldName, or the result from another function, in which you want to search the required text.
 beginIndex- Required. The begin Index in the withInExpression argument at which you want to start searching.
 Note that the index is zero based.</syntaxDescription>
    <example>SEARCH(&quot;60&quot;, DE-4, 0)</example>
    <exampleDescription>If DE-4 field has the value &quot;0060&quot; then for the above example,
 it searches the string &quot;60&quot; in DE-4 field value beginning at index 0 and returns result as 2.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>NOT</name>
    <groupName>Standard</groupName>
    <description>The NOT function reverses the value of the given expression.Use NOT when you want to make sure a value is not equal to one particular value.</description>
    <syntax>NOT(expression)</syntax>
    <syntaxDescription>The NOT function syntax has the following arguments:
 expression-  Required. expression that can be evaluated to true or false.</syntaxDescription>
    <example>NOT(EXACT(DE-39, &quot;000&quot;))</example>
    <exampleDescription>It checks whether DE-39 has the value 000, if it has then NOT(EXACT(DE-39, &quot;000&quot;)) will return false else it returns true.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>FLOAT</name>
    <groupName>Standard</groupName>
    <description>The FLOAT function parses the given string and returns the float value.Argument can be a constant or fieldName.</description>
    <syntax>FLOAT(expression)</syntax>
    <syntaxDescription>The FLOAT function syntax has the following arguments:
   expression-  It can be a constant or the fieldName, or the result from another function, from which you want to get float value.</syntaxDescription>
    <example>FLOAT(DE-9)</example>
    <exampleDescription>Returns the float value for a field DE-9.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>ISNUMBER</name>
    <groupName>Standard</groupName>
    <description>The ISNUMBER function validates whether the given expression is a digit and returns either true or false.Argument can be a constant or fieldName.</description>
    <syntax>ISNUMBER(expression)</syntax>
    <syntaxDescription>The ISNUMBER function syntax has the following arguments:
     expression-  It can be a constant or the fieldName, or the result from another function.</syntaxDescription>
    <example>ISNUMBER(DE-9)</example>
    <exampleDescription>Checks whether the given expression is a digit or not</exampleDescription>
 <code></code>
    <imports></imports>
       <returnType></returnType>
       <parameters></parameters>
    <systemDefined>true</systemDefined>
 </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>ISALPHANUMERIC</name>
    <groupName>Standard</groupName>
    <description>The ISALPHANUMERIC function validates whether the given expression is alphanumeric and returns either true or false.Argument can be a constant or fieldName.</description>
    <syntax>ISALPHANUMERIC(expression)</syntax>
    <syntaxDescription>The ISALPHANUMERIC function syntax has the following arguments:
       expression-  It can be a constant or the fieldName, or the result from another function.</syntaxDescription>
    <example>ISALPHANUMERIC(DE-9)</example>
    <exampleDescription>Checks whether the given expression is alphanumeric or not</exampleDescription>
 <code></code>
    <imports></imports>
       <returnType></returnType>
       <parameters></parameters>
    <systemDefined>true</systemDefined>
 </ExcelFunctionInfo>
 <ExcelFunctionInfo>
    <name>ISALPHA</name>
    <groupName>Standard</groupName>
    <description>The ISALPHA function validates whether the given expression is alphabetical and returns either true or false.Argument can be a constant or fieldName.</description>
    <syntax>ISALPHA(expression)</syntax>
    <syntaxDescription>The ISALPHA function syntax has the following arguments:
       expression-  It can be a constant or the fieldName, or the result from another function.</syntaxDescription>
    <example>ISALPHA(FHeader)</example>
    <exampleDescription>Checks whether the given expression is alphabetical or not</exampleDescription>
 <code></code>
    <imports></imports>
       <returnType></returnType>
       <parameters></parameters>
    <systemDefined>true</systemDefined>
 </ExcelFunctionInfo>
 <ExcelFunctionInfo>
    <name>ISPATTERN</name>
    <groupName>Standard</groupName>
    <description>The ISPATTERN function validates the given expression with pattern("a-zA-Z0-9$#") and returns either true or false.Argument can be a constant or fieldName.</description>
    <syntax>ISPATTERN(expression)</syntax>
    <syntaxDescription>The ISALPHA function syntax has the following arguments:
       expression-  It can be a constant or the fieldName, or the result from another function.</syntaxDescription>
    <example>ISPATTERN("Pattern#")</example>
    <exampleDescription>Checks whether the given expression match with pattern</exampleDescription>
 <code></code>
    <imports></imports>
       <returnType></returnType>
       <parameters></parameters>
    <systemDefined>true</systemDefined>
 </ExcelFunctionInfo>
 <ExcelFunctionInfo>
    <name>ISSUCCESS</name>
    <groupName>Standard</groupName>
    <description>The ISSUCCESS function executes the context ISSUCCESS method.</description>
    <syntax>ISSUCCESS()</syntax>
    <syntaxDescription>The ISSUCCESS function syntax has the following arguments:
     context.ISSUCCESS()</syntaxDescription>
    <example>context.ISSUCCESS()</example>
    <exampleDescription>Execute the ISSUCCESS() method present in the given context.</exampleDescription>
 <code></code>
    <imports></imports>
       <returnType></returnType>
       <parameters></parameters>
    <systemDefined>true</systemDefined>
 </ExcelFunctionInfo>
 <ExcelFunctionInfo>
    <name>ISVALID</name>
    <groupName>Standard</groupName>
    <description>The ISVALID function validates whether the given expression matches the given pattern and returns either true or false.Argument can be a constant or fieldName.</description>
    <syntax>ISVALID(expression,pattern)</syntax>
    <syntaxDescription>The ISVALID function syntax has the following arguments:
         expression-  It can be a constant or the fieldName, or the result from another function.
         pattern-   Pattern to match</syntaxDescription>
    <example>ISVALID(DE-9,&quot;//d+&quot;)</example>
    <exampleDescription>Checks whether the given expression matches the given pattern or not</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>TODAY</name>
    <groupName>Standard</groupName>
    <description>The TODAY function returns the current system date.</description>
    <syntax>TODAY()</syntax>
    <syntaxDescription></syntaxDescription>
    <example>TODAY()</example>
    <exampleDescription>It returns the current date.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>TODATE</name>
    <groupName>Standard</groupName>
    <description>The TODATE function converts given date into specified format.</description>
    <syntax>TODATE(strValue, pattern, timeZone)</syntax>
    <syntaxDescription>The TODATE function syntax has the following arguments:
	 strValue- It is the date in string.
	 pattern- It is the pattern to which given date is to be converted.
	 timeZone- It is the time zone.
	 </syntaxDescription>
    <example>TODATE("01.11.2011","dd-MMM-yy","GMT-08:00")</example>
    <exampleDescription>It returns the current date.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>ISVALIDDATE</name>
    <groupName>Standard</groupName>
    <description>The ISVALIDDATE function validates the given date with specified format and returns true or false.</description>
    <syntax>ISVALIDDATE(format, date)</syntax>
    <syntaxDescription>The ISVALIDDATE function syntax has the following arguments:
     format- It is the format to validate given date.
	 date- It is the date in string.
	 </syntaxDescription>
    <example>ISVALIDDATE("dd-MMM-yy", "01.11.2011")</example>
    <exampleDescription>It checks whether given date is in specified format or not.</exampleDescription>
  <code></code>
    <imports></imports>
      <returnType></returnType>
      <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>ISEMPTY</name>
    <groupName>Standard</groupName>
    <description>The ISEMPTY function checks whether the given value is empty or not.</description>
    <syntax>ISEMPTY(value)</syntax>
    <syntaxDescription>The ISEMPTY function syntax has the following arguments:
         value-  It can be a constant or the fieldName, or the result from another function.
     </syntaxDescription>
    <example>ISEMPTY(value)</example>
    <exampleDescription>Return true if given value is empty otherwise return false.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>ISBLANK</name>
    <groupName>Standard</groupName>
    <description>The ISBLANK function checks whether the given value is blank or not.</description>
    <syntax>ISBLANK(value)</syntax>
    <syntaxDescription>The ISBLANK function syntax has the following arguments:
         value-  It can be a constant or the fieldName, or the result from another function.
    </syntaxDescription>
    <example>ISBLANK(value)</example>
    <exampleDescription>Return true if given value is blank otherwise return false.</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LONGINC</name>
    <groupName>Standard</groupName>
    <description>The LONGINC function increments the given long value with specified increment value.</description>
    <syntax>LONGINC(atomicLongValue, incrementVal)</syntax>
    <syntaxDescription>The LONGINC function syntax has the following arguments:
         atomicLongValue-  It is atomicLong value to be increment.
		 incrementVal- It is increment value.
	</syntaxDescription>
    <example>LONGINC(10, 2)</example>
    <exampleDescription>Returns incremented value i.e. 12</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>DBLINC</name>
    <groupName>Standard</groupName>
    <description>The DBLINC function increments the given double value with specified increment value.</description>
    <syntax>DBLINC(doubleValue, incrementVal)</syntax>
    <syntaxDescription>The DBLINC function syntax has the following arguments:
         doubleValue-  It is double value to be increment.
		 incrementVal- It is increment value.
	</syntaxDescription>
    <example>DBLINC(78.25, 5.40)</example>
    <exampleDescription>Returns incremented value i.e. 83.65</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>INTVAL</name>
    <groupName>Standard</groupName>
    <description>The INTVAL function returns the integer value of given object value.</description>
    <syntax>INTVAL(atomicIntegerValue)</syntax>
    <syntaxDescription>The INTVAL function syntax has the following arguments:
         atomicIntegerValue-  It is atomicInteger value to be converted into integer value.
    </syntaxDescription>
    <example>INTVAL(23)</example>
    <exampleDescription>Returns converted value i.e. 23</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>INTINC</name>
    <groupName>Standard</groupName>
    <description>The INTINC function increments the given integer value with specified increment value.</description>
    <syntax>INTINC(atomicIntegerValue, incrementVal)</syntax>
    <syntaxDescription>The INTINC function syntax has the following arguments:
         atomicIntegerValue-  It is atomicInteger value to be increment.
		 incrementVal- It is increment value.
	</syntaxDescription>
    <example>INTINC(78, 5)</example>
    <exampleDescription>Returns incremented value i.e. 83</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>LONGVAL</name>
    <groupName>Standard</groupName>
    <description>The LONGVAL function returns the long value of given object value.</description>
    <syntax>LONGVAL(atomicLongValue)</syntax>
    <syntaxDescription>The LONGVAL function syntax has the following arguments:
         atomicLongValue-  It is atomicLong value to be converted into long value.
    </syntaxDescription>
    <example>LONGVAL(23)</example>
    <exampleDescription>Returns converted value i.e. 23</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>DBLVAL</name>
    <groupName>Standard</groupName>
    <description>The DBLVAL function returns the double value of given object value.</description>
    <syntax>DBLVAL(doubleValue)</syntax>
    <syntaxDescription>The DBLVAL function syntax has the following arguments:
         doubleValue-  It is double value to be converted into double value.
    </syntaxDescription>
    <example>DBLVAL(34.29)</example>
    <exampleDescription>Returns converted value i.e. 34.29</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
      <name>SWITCH</name>
      <groupName>Standard</groupName>
      <description>The SWITCH function evaluates a list of test expressions and returning the result for the first test that evaluates to true.</description>
      <syntax>SWITCH(expression,caseVal1,return1,caseVal2,return2,[caseVal3],[return3],..,defaultValue)</syntax>
      <syntaxDescription>The IF function syntax has the following arguments:
      	expression- Required. Any value or expression that can be evaluated.
      	caseVal1- Required. First case expression that results TRUE or FALSE.
      	return1- Required. First result value that is returned if caseVal1 returns TRUE.
      	caseVal2- Required. Second case expression that results TRUE or FALSE.
      	return2- Required. Second result value that is returned if caseVal2 returns TRUE.
      	[caseVal3],[return3]..- Optional. Remaining case and return values.
      	defaultReturn- Required. Default return value.
      </syntaxDescription>
      <example>SWITCH(RECORDTYPE(),EXACT(RECORDTYPE(),"header"),"header",EXACT(RECORDTYPE(),"footer"),"footer","Not defined"))</example>
      <exampleDescription>Return record type of given record</exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>LEFTPAD</name>
    <groupName>Standard</groupName>
    <description> There are three LEFTPAD functions:
    1. Left pad a String with spaces (' '). The String is padded to the size of size.
    2. Left pad a String with a specified character. Pad to a size of size.
    3. Left pad a String with a specified String. Pad to a size of size.
    </description>
    <syntax>LEFTPAD(value, size, padString)</syntax>
    <syntaxDescription>The LEFTPAD function has following arguments: 
    		value- It is the String to pad out, may be null.
    		size- It is the size to pad to value.
    		padChar- It is the character to pad with value.
    		padString- It is the String to pad with, null or empty treated as single space. 
    </syntaxDescription>
    <example>
    1. LEFTPAD("Padding", 9)
    2. LEFTPAD("Padding", 9,"z")
    3. LEFTPAD("Padding", 11,"new");
    </example>
    <exampleDescription>
    1. Returns left padded string with spaces i.e. "  Padding".
	2. Returns left padded string with character 'z' i.e. "zzPadding".
	3. Returns left padded string with String 'new' i.e. "newnPadding".
    </exampleDescription>
   <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
   </ExcelFunctionInfo>
   <ExcelFunctionInfo>
    <name>RIGHTPAD</name>
    <groupName>Standard</groupName>
    <description> There are three RIGHTPAD functions:
    1. Right pad a String with spaces (' '). The String is padded to the size of size.
    2. Right pad a String with a specified character. Pad to a size of size.
    3. Right pad a String with a specified String. Pad to a size of size.
    </description>
    <syntax>RIGHTPAD(value, size, padString)</syntax>
    <syntaxDescription>The RIGHTPAD function has following arguments: 
    		value- It is the String to pad out, may be null.
    		size- It is the size to pad to value.
    		padChar- It is the character to pad with value.
    		padString- It is the String to pad with, null or empty treated as single space. 
    </syntaxDescription>
    <example>
    1. RIGHTPAD("Pad", 5)
    2. RIGHTPAD("Pad", 5,"a")
    3. RIGHTPAD("Pad", 9,"right");
    </example>
    <exampleDescription>
    1. Returns right padded string with spaces i.e. "Pad  ".
	2. Returns right padded string with character 'z' i.e. "Padaa".
	3. Returns right padded string with String "new" i.e. "Padrightr".
    </exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>true</name>
    <groupName>Standard</groupName>
    <description></description>
    <syntax>true</syntax>
    <syntaxDescription>
    </syntaxDescription>
    <example>true</example>
    <exampleDescription></exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>true</systemDefined>
  </ExcelFunctionInfo>
  <ExcelFunctionInfo>
    <name>false</name>
    <groupName>Standard</groupName>
    <description></description>
    <syntax>false</syntax>
    <syntaxDescription>
    </syntaxDescription>
    <example>false</example>
    <exampleDescription></exampleDescription>
  <code></code>
    <imports></imports>
        <returnType></returnType>
        <parameters></parameters>
    <systemDefined>false</systemDefined>
  </ExcelFunctionInfo>
</list>