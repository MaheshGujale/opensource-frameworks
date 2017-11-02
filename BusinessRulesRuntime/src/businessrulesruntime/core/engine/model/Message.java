package businessrulesruntime.core.engine.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import businessrulesruntime.core.engine.IMessage;

@XmlRootElement
@SuppressWarnings("serial")
public class Message implements IMessage, Serializable {
	private String mti; /* Message Type */
	private String primaryAccountNumber; /* Card Number */
	private String processingCode; /* Processing Code */
	private Double amountTransaction; /* Transaction Amount */
	private Double amountSettlement;
	private Double amountCardholderBilling; /* Billing Amount */
	private Date tranmissionDate;
	private String amountCardholderBillingFee;
	private String conversionRateReconcilation;
	private String conversionRateCardholderBill;
	private String traceAuditNumber; /* STAN */
	private Date dateTimeLocalTransaction; /* Local Transaction Date */
	private Date dateEffective;
	private Date dateExpiration; /* Expiry Date */
	private Date dateSettlement;
	private Date dateConversion;
	private Date dateCapture; /* Capture Date */
	private String merchantType;
	private String countryCodeAcquring;
	private String countryCode;
	private String forwardingInstitution;
	private String pointOfServiceDataCode; /* POS Data */
	private String cardSequenceNumber;
	private String functionCode;
	private String messageReasonCode;
	private String cardAcceptorBusinesscode;
	private String approvalCodeLength;
	private String dateReconcilciation;
	private String reconciliationIndicator;
	private String amountOriginal;
	private String acquirerRefrenceData;
	private String acqInstitutionIdentificationCode;
	private String forwardingInstitutionIdentificationCode;
	private String panExtended;
	private String track2Data;
	private String track3Data;
	private String retrievalReferenceNumber;
	private String approvalCode;
	private String responseCode;
	private String serviceCode;
	private String cardAcceptorTerminalIdentification;
	private String cardAcceptorIdentificationCode;
	private String cardAcceptorName;
	private String additionalResponseData;
	private String track1Data;
	private String amountFees;
	private String additionalDataNational;
	private String additionalDataPrivate;
	private String currencyCodeTransaction;
	private String currencyCodeReconciliation;
	private String currencyCodeCardholderBilling;
	private String personalIdentificationNumber;
	private String securityRelatedInformation;
	private String amountsAdditionals;
	private String icCardData;
	private String originalDataElements;
	private String authorizationLifecycleCode;
	private String authorizationAgentInstitutionIdentificationCode;
	private String transportdData;
	private String reservedNational1;
	private String reservednational2;
	private String reservedPrivateChequeDetails;
	private String reservedPrivateConsumerNumber;
	private String messageAuthenticationCodeField1;
	private String reservedForISOUse;
	private String amountOriginalFees;
	private String extendedPaymentData;
	private String countryCodeRecevingInstitution;
	private String countryCodeSettlement;
	private String authorizingAgentInstitution;
	private String messageNumber;
	private String dataRecord;
	private String dataAction;
	private String creditsNumber;
	private String creditReversalNumber;
	private String debitsNumber;
	private String debitsReversalNumber;
	private String transferNumber;
	private String transaferReversalNumber;
	private String inquiriesNumber;
	private String authorizationsNumber;
	private String inquiriesReversalNumber;
	private String paymentNumber;
	private String paymentSreversalNumber;
	private String feeCollectionNumber;
	private String creditsAmount;
	private String creditsReversalAmount;
	private String debitsAmount;
	private String debitsReversalAmounts;
	private String authorizationsReversalNumber;
	private String countryCodeTransactionDestinationInstitution;
	private String countryCodeTransactionOriginatorInstitution;
	private String transactionDestinationInstitutionIdCode;
	private String transactionOriginatorInstitutionIdCode;
	private String cardIssuerReferenceData;
	private String keyManagementData;
	private String amountNetReconciliation;
	private String payee;
	private String settlementInstitutionIdentificationCode;
	private String receivingInstitutionIdentificationCode;
	private String fileName;
	private String accountIdentification1;
	private String accountIdentification2;
	private String transactionDescription;
	private String creditsChargeBackAmount;
	private String debitChargeBackAmount;
	private String creditsChargeBackNumber;
	private String debitsChargeBackNumber;
	private String creditsfeAmounts;
	private String debitsfeAmounts;
	private String reservedISO;
	private String reservedForISOUse1;
	private String reservedForISOUse2;
	private String reservedForISOUse3;
	private String reservedForISOUse4;
	private String reservedForNationalUse1;
	private String reservedForNationalUse2;
	private String reservedForNationalUse3;
	private String reservedForNationalUse4;
	private String reservedForNationalUse5;
	private String reservedForNationalUse6;
	private String reservedForNationalUse7;
	private String reservedForPrivateUserDeliveryChannelControllerId;
	private String reservedForPrivateUseTerminalType;
	private String reservedForPrivateUseStatementPrintData;
	private String reservedForPrivateUseYearPartOfDate;
	private String reservedForPrivateUse;
	private String messageAuthenticationCodeField2;
	private String transactionMonitorData;
	
	/**
	 * @return the transactionMonitorData
	 */
	public String getTransactionMonitorData() {
		return transactionMonitorData;
	}

	/**
	 * @param transactionMonitorData the transactionMonitorData to set
	 */
	public void setTransactionMonitorData(String transactionMonitorData) {
		this.transactionMonitorData = transactionMonitorData;
	}

	private String transactionCode;

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	public String getMti() {
		return mti;
	}

	public void setPrimaryAccountNumber(String primaryAccountNumber) {
		this.primaryAccountNumber = primaryAccountNumber;
	}

	public String getPrimaryAccountNumber() {
		return primaryAccountNumber;
	}

	public void setProcessingCode(String processingCode) {
		this.processingCode = processingCode;
	}

	public String getProcessingCode() {
		return processingCode;
	}

	public void setAmountTransaction(Double amountTransaction) {
		this.amountTransaction = amountTransaction;
	}

	public Double getAmountTransaction() {
		return amountTransaction;
	}

	public void setAmountSettlement(Double amountSettlement) {
		this.amountSettlement = amountSettlement;
	}

	public Double getAmountSettlement() {
		return amountSettlement;
	}

	public void setAmountCardholderBilling(Double amountCardholderBilling) {
		this.amountCardholderBilling = amountCardholderBilling;
	}

	/*
	 * getAmountCardHolder
	 */
	public Double getAmountCardholderBilling() {
		return amountCardholderBilling;
	}

	public void setTranmissionDate(Date tranmissionDate) {
		this.tranmissionDate = tranmissionDate;
	}

	public Date getTranmissionDate() {
		return tranmissionDate;
	}

	public void setAmountCardholderBillingRate(String amountCardholderBillingRate) {
		this.amountCardholderBillingFee = amountCardholderBillingRate;
	}

	public String getAmountCardholderBillingRate() {
		return amountCardholderBillingFee;
	}

	public void setConversionRateReconcilation(
			String conversionRateReconcilation) {
		this.conversionRateReconcilation = conversionRateReconcilation;
	}

	public String getConversionRateReconcilation() {
		return conversionRateReconcilation;
	}

	public void setConversionRateCardholderBill(
			String conversionRateCardholderBill) {
		this.conversionRateCardholderBill = conversionRateCardholderBill;
	}

	public String getConversionRateCardholderBill() {
		return conversionRateCardholderBill;
	}

	public void setTraceAuditNumber(String traceAuditNumber) {
		this.traceAuditNumber = traceAuditNumber;
	}

	public String getTraceAuditNumber() {
		return traceAuditNumber;
	}

	public void setDateTimeLocalTransaction(Date dateTimeLocalTransaction) {
		this.dateTimeLocalTransaction = dateTimeLocalTransaction;
	}

	public Date getDateTimeLocalTransaction() {
		return dateTimeLocalTransaction;
	}

	public void setDateEffective(Date dateEffective) {
		this.dateEffective = dateEffective;
	}

	public Date getDateEffective() {
		return dateEffective;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateSettlement(Date dateSettlement) {
		this.dateSettlement = dateSettlement;
	}

	public Date getDateSettlement() {
		return dateSettlement;
	}

	public void setDateConversion(Date dateConversion) {
		this.dateConversion = dateConversion;
	}

	public Date getDateConversion() {
		return dateConversion;
	}

	public void setDateCapture(Date dateCapture) {
		this.dateCapture = dateCapture;
	}

	public Date getDateCapture() {
		return dateCapture;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setCountryCodeAcquring(String countryCodeAcquring) {
		this.countryCodeAcquring = countryCodeAcquring;
	}

	public String getCountryCodeAcquring() {
		return countryCodeAcquring;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setForwardingInstitution(String forwardingInstitution) {
		this.forwardingInstitution = forwardingInstitution;
	}

	public String getForwardingInstitution() {
		return forwardingInstitution;
	}

	public void setPointOfServiceDataCode(String pointOfServiceDataCode) {
		this.pointOfServiceDataCode = pointOfServiceDataCode;
	}

	public String getPointOfServiceDataCode() {
		return pointOfServiceDataCode;
	}

	public void setCardSequenceNumber(String cardSequenceNumber) {
		this.cardSequenceNumber = cardSequenceNumber;
	}

	public String getCardSequenceNumber() {
		return cardSequenceNumber;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setMessageReasonCode(String messageReasonCode) {
		this.messageReasonCode = messageReasonCode;
	}

	public String getMessageReasonCode() {
		return messageReasonCode;
	}

	public void setCardAcceptorBusinesscode(String cardAcceptorBusinesscode) {
		this.cardAcceptorBusinesscode = cardAcceptorBusinesscode;
	}

	public String getCardAcceptorBusinesscode() {
		return cardAcceptorBusinesscode;
	}

	public void setApprovalCodeLength(String approvalCodeLength) {
		this.approvalCodeLength = approvalCodeLength;
	}

	public String getApprovalCodeLength() {
		return approvalCodeLength;
	}

	public void setDateReconcilciation(String dateReconcilciation) {
		this.dateReconcilciation = dateReconcilciation;
	}

	public String getDateReconcilciation() {
		return dateReconcilciation;
	}

	public void setReconciliationIndicator(String reconciliationIndicator) {
		this.reconciliationIndicator = reconciliationIndicator;
	}

	public String getReconciliationIndicator() {
		return reconciliationIndicator;
	}

	public void setAmountOriginal(String amountOriginal) {
		this.amountOriginal = amountOriginal;
	}

	public String getAmountOriginal() {
		return amountOriginal;
	}

	public void setAcquirerRefrenceData(String acquirerRefrenceData) {
		this.acquirerRefrenceData = acquirerRefrenceData;
	}

	public String getAcquirerRefrenceData() {
		return acquirerRefrenceData;
	}

	public void setAcqInstitutionIdentificationCode(
			String acqInstitutionIdentificationCode) {
		this.acqInstitutionIdentificationCode = acqInstitutionIdentificationCode;
	}

	public String getAcqInstitutionIdentificationCode() {
		return acqInstitutionIdentificationCode;
	}

	public void setForwardingInstitutionIdentificationCode(
			String forwardingInstitutionIdentificationCode) {
		this.forwardingInstitutionIdentificationCode = forwardingInstitutionIdentificationCode;
	}

	public String getForwardingInstitutionIdentificationCode() {
		return forwardingInstitutionIdentificationCode;
	}

	public void setPanExtended(String panExtended) {
		this.panExtended = panExtended;
	}

	public String getPanExtended() {
		return panExtended;
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	public String getTrack2Data() {
		return track2Data;
	}

	public void setTrack3Data(String track3Data) {
		this.track3Data = track3Data;
	}

	public String getTrack3Data() {
		return track3Data;
	}

	public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
		this.retrievalReferenceNumber = retrievalReferenceNumber;
	}

	public String getRetrievalReferenceNumber() {
		return retrievalReferenceNumber;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setCardAcceptorTerminalIdentification(
			String cardAcceptorTerminalIdentification) {
		this.cardAcceptorTerminalIdentification = cardAcceptorTerminalIdentification;
	}

	public String getCardAcceptorTerminalIdentification() {
		return cardAcceptorTerminalIdentification;
	}

	public void setCardAcceptorIdentificationCode(
			String cardAcceptorIdentificationCode) {
		this.cardAcceptorIdentificationCode = cardAcceptorIdentificationCode;
	}

	public String getCardAcceptorIdentificationCode() {
		return cardAcceptorIdentificationCode;
	}

	public void setCardAcceptorName(String cardAcceptorName) {
		this.cardAcceptorName = cardAcceptorName;
	}

	public String getCardAcceptorName() {
		return cardAcceptorName;
	}

	public void setAdditionalResponseData(String additionalResponseData) {
		this.additionalResponseData = additionalResponseData;
	}

	public String getAdditionalResponseData() {
		return additionalResponseData;
	}

	public void setTrack1Data(String track1Data) {
		this.track1Data = track1Data;
	}

	public String getTrack1Data() {
		return track1Data;
	}

	public void setAmountFees(String amountFees) {
		this.amountFees = amountFees;
	}

	public String getAmountFees() {
		return amountFees;
	}

	public void setAdditionalDataNational(String additionalDataNational) {
		this.additionalDataNational = additionalDataNational;
	}

	public String getAdditionalDataNational() {
		return additionalDataNational;
	}

	public void setAdditionalDataPrivate(String additionalDataPrivate) {
		this.additionalDataPrivate = additionalDataPrivate;
	}

	public String getAdditionalDataPrivate() {
		return additionalDataPrivate;
	}

	public void setCurrencyCodeTransaction(String currencyCodeTransaction) {
		this.currencyCodeTransaction = currencyCodeTransaction;
	}

	public String getCurrencyCodeTransaction() {
		return currencyCodeTransaction;
	}

	public void setCurrencyCodeReconciliation(String currencyCodeReconciliation) {
		this.currencyCodeReconciliation = currencyCodeReconciliation;
	}

	public String getCurrencyCodeReconciliation() {
		return currencyCodeReconciliation;
	}

	public void setCurrencyCodeCardholderBilling(
			String currencyCodeCardholderBilling) {
		this.currencyCodeCardholderBilling = currencyCodeCardholderBilling;
	}

	public String getCurrencyCodeCardholderBilling() {
		return currencyCodeCardholderBilling;
	}

	public void setPersonalIdentificationNumber(
			String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setSecurityRelatedInformation(String securityRelatedInformation) {
		this.securityRelatedInformation = securityRelatedInformation;
	}

	public String getSecurityRelatedInformation() {
		return securityRelatedInformation;
	}

	public void setAmountsAdditionals(String amountsAdditionals) {
		this.amountsAdditionals = amountsAdditionals;
	}

	public String getAmountsAdditionals() {
		return amountsAdditionals;
	}

	public void setIcCardData(String icCardData) {
		this.icCardData = icCardData;
	}

	public String getIcCardData() {
		return icCardData;
	}

	public void setOriginalDataElements(String originalDataElements) {
		this.originalDataElements = originalDataElements;
	}

	public String getOriginalDataElements() {
		return originalDataElements;
	}

	public void setAuthorizationLifecycleCode(String authorizationLifecycleCode) {
		this.authorizationLifecycleCode = authorizationLifecycleCode;
	}

	public String getAuthorizationLifecycleCode() {
		return authorizationLifecycleCode;
	}

	public void setAuthorizationAgentInstitutionIdentificationCode(
			String authorizationAgentInstitutionIdentificationCode) {
		this.authorizationAgentInstitutionIdentificationCode = authorizationAgentInstitutionIdentificationCode;
	}

	public String getAuthorizationAgentInstitutionIdentificationCode() {
		return authorizationAgentInstitutionIdentificationCode;
	}

	public void setTransportdData(String transportdData) {
		this.transportdData = transportdData;
	}

	public String getTransportdData() {
		return transportdData;
	}

	public void setReservedNational1(String reservedNational1) {
		this.reservedNational1 = reservedNational1;
	}

	public String getReservedNational1() {
		return reservedNational1;
	}

	public void setReservednational2(String reservednational2) {
		this.reservednational2 = reservednational2;
	}

	public String getReservednational2() {
		return reservednational2;
	}

	public void setReservedPrivateChequeDetails(
			String reservedPrivateChequeDetails) {
		this.reservedPrivateChequeDetails = reservedPrivateChequeDetails;
	}

	public String getReservedPrivateChequeDetails() {
		return reservedPrivateChequeDetails;
	}

	public void setReservedPrivateConsumerNumber(
			String reservedPrivateConsumerNumber) {
		this.reservedPrivateConsumerNumber = reservedPrivateConsumerNumber;
	}

	public String getReservedPrivateConsumerNumber() {
		return reservedPrivateConsumerNumber;
	}

	public void setMessageAuthenticationCodeField1(
			String messageAuthenticationCodeField1) {
		this.messageAuthenticationCodeField1 = messageAuthenticationCodeField1;
	}

	public String getMessageAuthenticationCodeField1() {
		return messageAuthenticationCodeField1;
	}

	public void setReservedForISOUse(String reservedForISOUse) {
		this.reservedForISOUse = reservedForISOUse;
	}

	public String getReservedForISOUse() {
		return reservedForISOUse;
	}

	public void setAmountOriginalFees(String amountOriginalFees) {
		this.amountOriginalFees = amountOriginalFees;
	}

	public String getAmountOriginalFees() {
		return amountOriginalFees;
	}

	public void setExtendedPaymentData(String extendedPaymentData) {
		this.extendedPaymentData = extendedPaymentData;
	}

	public String getExtendedPaymentData() {
		return extendedPaymentData;
	}

	public void setCountryCodeRecevingInstitution(
			String countryCodeRecevingInstitution) {
		this.countryCodeRecevingInstitution = countryCodeRecevingInstitution;
	}

	public String getCountryCodeRecevingInstitution() {
		return countryCodeRecevingInstitution;
	}

	public void setCountryCodeSettlement(String countryCodeSettlement) {
		this.countryCodeSettlement = countryCodeSettlement;
	}

	public String getCountryCodeSettlement() {
		return countryCodeSettlement;
	}

	public void setAuthorizingAgentInstitution(
			String authorizingAgentInstitution) {
		this.authorizingAgentInstitution = authorizingAgentInstitution;
	}

	public String getAuthorizingAgentInstitution() {
		return authorizingAgentInstitution;
	}

	public void setMessageNumber(String messageNumber) {
		this.messageNumber = messageNumber;
	}

	public String getMessageNumber() {
		return messageNumber;
	}

	public void setDataRecord(String dataRecord) {
		this.dataRecord = dataRecord;
	}

	public String getDataRecord() {
		return dataRecord;
	}

	public void setDataAction(String dataAction) {
		this.dataAction = dataAction;
	}

	public String getDataAction() {
		return dataAction;
	}

	public void setCreditsNumber(String creditsNumber) {
		this.creditsNumber = creditsNumber;
	}

	public String getCreditsNumber() {
		return creditsNumber;
	}

	public void setCreditReversalNumber(String creditReversalNumber) {
		this.creditReversalNumber = creditReversalNumber;
	}

	public String getCreditReversalNumber() {
		return creditReversalNumber;
	}

	public void setDebitsNumber(String debitsNumber) {
		this.debitsNumber = debitsNumber;
	}

	public String getDebitsNumber() {
		return debitsNumber;
	}

	public void setDebitsReversalNumber(String debitsReversalNumber) {
		this.debitsReversalNumber = debitsReversalNumber;
	}

	public String getDebitsReversalNumber() {
		return debitsReversalNumber;
	}

	public void setTransferNumber(String transferNumber) {
		this.transferNumber = transferNumber;
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public void setTransaferReversalNumber(String transaferReversalNumber) {
		this.transaferReversalNumber = transaferReversalNumber;
	}

	public String getTransaferReversalNumber() {
		return transaferReversalNumber;
	}

	public void setInquiriesNumber(String inquiriesNumber) {
		this.inquiriesNumber = inquiriesNumber;
	}

	public String getInquiriesNumber() {
		return inquiriesNumber;
	}

	public void setAuthorizationsNumber(String authorizationsNumber) {
		this.authorizationsNumber = authorizationsNumber;
	}

	public String getAuthorizationsNumber() {
		return authorizationsNumber;
	}

	public void setInquiriesReversalNumber(String inquiriesReversalNumber) {
		this.inquiriesReversalNumber = inquiriesReversalNumber;
	}

	public String getInquiriesReversalNumber() {
		return inquiriesReversalNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentSreversalNumber(String paymentSreversalNumber) {
		this.paymentSreversalNumber = paymentSreversalNumber;
	}

	public String getPaymentSreversalNumber() {
		return paymentSreversalNumber;
	}

	public void setFeeCollectionNumber(String feeCollectionNumber) {
		this.feeCollectionNumber = feeCollectionNumber;
	}

	public String getFeeCollectionNumber() {
		return feeCollectionNumber;
	}

	public void setCreditsAmount(String creditsAmount) {
		this.creditsAmount = creditsAmount;
	}

	public String getCreditsAmount() {
		return creditsAmount;
	}

	public void setCreditsReversalAmount(String creditsReversalAmount) {
		this.creditsReversalAmount = creditsReversalAmount;
	}

	public String getCreditsReversalAmount() {
		return creditsReversalAmount;
	}

	public void setDebitsAmount(String debitsAmount) {
		this.debitsAmount = debitsAmount;
	}

	public String getDebitsAmount() {
		return debitsAmount;
	}

	public void setDebitsReversalAmounts(String debitsReversalAmounts) {
		this.debitsReversalAmounts = debitsReversalAmounts;
	}

	public String getDebitsReversalAmounts() {
		return debitsReversalAmounts;
	}

	public void setAuthorizationsReversalNumber(
			String authorizationsReversalNumber) {
		this.authorizationsReversalNumber = authorizationsReversalNumber;
	}

	public String getAuthorizationsReversalNumber() {
		return authorizationsReversalNumber;
	}

	public void setCountryCodeTransactionDestinationInstitution(
			String countryCodeTransactionDestinationInstitution) {
		this.countryCodeTransactionDestinationInstitution = countryCodeTransactionDestinationInstitution;
	}

	public String getCountryCodeTransactionDestinationInstitution() {
		return countryCodeTransactionDestinationInstitution;
	}

	public void setCountryCodeTransactionOriginatorInstitution(
			String countryCodeTransactionOriginatorInstitution) {
		this.countryCodeTransactionOriginatorInstitution = countryCodeTransactionOriginatorInstitution;
	}

	public String getCountryCodeTransactionOriginatorInstitution() {
		return countryCodeTransactionOriginatorInstitution;
	}

	public void setTransactionDestinationInstitutionIdCode(
			String transactionDestinationInstitutionIdCode) {
		this.transactionDestinationInstitutionIdCode = transactionDestinationInstitutionIdCode;
	}

	public String getTransactionDestinationInstitutionIdCode() {
		return transactionDestinationInstitutionIdCode;
	}

	public void setTransactionOriginatorInstitutionIdCode(
			String transactionOriginatorInstitutionIdCode) {
		this.transactionOriginatorInstitutionIdCode = transactionOriginatorInstitutionIdCode;
	}

	public String getTransactionOriginatorInstitutionIdCode() {
		return transactionOriginatorInstitutionIdCode;
	}

	public void setCardIssuerReferenceData(String cardIssuerReferenceData) {
		this.cardIssuerReferenceData = cardIssuerReferenceData;
	}

	public String getCardIssuerReferenceData() {
		return cardIssuerReferenceData;
	}

	public void setKeyManagementData(String keyManagementData) {
		this.keyManagementData = keyManagementData;
	}

	public String getKeyManagementData() {
		return keyManagementData;
	}

	public void setAmountNetReconciliation(String amountNetReconciliation) {
		this.amountNetReconciliation = amountNetReconciliation;
	}

	public String getAmountNetReconciliation() {
		return amountNetReconciliation;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayee() {
		return payee;
	}

	public void setSettlementInstitutionIdentificationCode(
			String settlementInstitutionIdentificationCode) {
		this.settlementInstitutionIdentificationCode = settlementInstitutionIdentificationCode;
	}

	public String getSettlementInstitutionIdentificationCode() {
		return settlementInstitutionIdentificationCode;
	}

	public void setReceivingInstitutionIdentificationCode(
			String receivingInstitutionIdentificationCode) {
		this.receivingInstitutionIdentificationCode = receivingInstitutionIdentificationCode;
	}

	public String getReceivingInstitutionIdentificationCode() {
		return receivingInstitutionIdentificationCode;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setAccountIdentification1(String accountIdentification1) {
		this.accountIdentification1 = accountIdentification1;
	}

	public String getAccountIdentification1() {
		return accountIdentification1;
	}

	public void setAccountIdentification2(String accountIdentification2) {
		this.accountIdentification2 = accountIdentification2;
	}

	public String getAccountIdentification2() {
		return accountIdentification2;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setCreditsChargeBackAmount(String creditsChargeBackAmount) {
		this.creditsChargeBackAmount = creditsChargeBackAmount;
	}

	public String getCreditsChargeBackAmount() {
		return creditsChargeBackAmount;
	}

	public void setDebitChargeBackAmount(String debitChargeBackAmount) {
		this.debitChargeBackAmount = debitChargeBackAmount;
	}

	public String getDebitChargeBackAmount() {
		return debitChargeBackAmount;
	}

	public void setCreditsChargeBackNumber(String creditsChargeBackNumber) {
		this.creditsChargeBackNumber = creditsChargeBackNumber;
	}

	public String getCreditsChargeBackNumber() {
		return creditsChargeBackNumber;
	}

	public void setDebitsChargeBackNumber(String debitsChargeBackNumber) {
		this.debitsChargeBackNumber = debitsChargeBackNumber;
	}

	public String getDebitsChargeBackNumber() {
		return debitsChargeBackNumber;
	}

	public void setCreditsfeAmounts(String creditsfeAmounts) {
		this.creditsfeAmounts = creditsfeAmounts;
	}

	public String getCreditsfeAmounts() {
		return creditsfeAmounts;
	}

	public void setDebitsfeAmounts(String debitsfeAmounts) {
		this.debitsfeAmounts = debitsfeAmounts;
	}

	public String getDebitsfeAmounts() {
		return debitsfeAmounts;
	}

	public void setReservedISO(String reservedISO) {
		this.reservedISO = reservedISO;
	}

	public String getReservedISO() {
		return reservedISO;
	}

	public void setReservedForISOUse1(String reservedForISOUse1) {
		this.reservedForISOUse1 = reservedForISOUse1;
	}

	public String getReservedForISOUse1() {
		return reservedForISOUse1;
	}

	public void setReservedForISOUse2(String reservedForISOUse2) {
		this.reservedForISOUse2 = reservedForISOUse2;
	}

	public String getReservedForISOUse2() {
		return reservedForISOUse2;
	}

	public void setReservedForISOUse3(String reservedForISOUse3) {
		this.reservedForISOUse3 = reservedForISOUse3;
	}

	public String getReservedForISOUse3() {
		return reservedForISOUse3;
	}

	public void setReservedForISOUse4(String reservedForISOUse4) {
		this.reservedForISOUse4 = reservedForISOUse4;
	}

	public String getReservedForISOUse4() {
		return reservedForISOUse4;
	}

	public void setReservedForNationalUse1(String reservedForNationalUse1) {
		this.reservedForNationalUse1 = reservedForNationalUse1;
	}

	public String getReservedForNationalUse1() {
		return reservedForNationalUse1;
	}

	public void setReservedForNationalUse2(String reservedForNationalUse2) {
		this.reservedForNationalUse2 = reservedForNationalUse2;
	}

	public String getReservedForNationalUse2() {
		return reservedForNationalUse2;
	}

	public void setReservedForNationalUse3(String reservedForNationalUse3) {
		this.reservedForNationalUse3 = reservedForNationalUse3;
	}

	public String getReservedForNationalUse3() {
		return reservedForNationalUse3;
	}

	public void setReservedForNationalUse4(String reservedForNationalUse4) {
		this.reservedForNationalUse4 = reservedForNationalUse4;
	}

	public String getReservedForNationalUse4() {
		return reservedForNationalUse4;
	}

	public void setReservedForNationalUse5(String reservedForNationalUse5) {
		this.reservedForNationalUse5 = reservedForNationalUse5;
	}

	public String getReservedForNationalUse5() {
		return reservedForNationalUse5;
	}

	public void setReservedForNationalUse6(String reservedForNationalUse6) {
		this.reservedForNationalUse6 = reservedForNationalUse6;
	}

	public String getReservedForNationalUse6() {
		return reservedForNationalUse6;
	}

	public void setReservedForNationalUse7(String reservedForNationalUse7) {
		this.reservedForNationalUse7 = reservedForNationalUse7;
	}

	public String getReservedForNationalUse7() {
		return reservedForNationalUse7;
	}

	public void setReservedForPrivateUserDeliveryChannelControllerId(
			String reservedForPrivateUserDeliveryChannelControllerId) {
		this.reservedForPrivateUserDeliveryChannelControllerId = reservedForPrivateUserDeliveryChannelControllerId;
	}

	public String getReservedForPrivateUserDeliveryChannelControllerId() {
		return reservedForPrivateUserDeliveryChannelControllerId;
	}

	public void setReservedForPrivateUseTerminalType(
			String reservedForPrivateUseTerminalType) {
		this.reservedForPrivateUseTerminalType = reservedForPrivateUseTerminalType;
	}

	public String getReservedForPrivateUseTerminalType() {
		return reservedForPrivateUseTerminalType;
	}

	public void setReservedForPrivateUseStatementPrintData(
			String reservedForPrivateUseStatementPrintData) {
		this.reservedForPrivateUseStatementPrintData = reservedForPrivateUseStatementPrintData;
	}

	public String getReservedForPrivateUseStatementPrintData() {
		return reservedForPrivateUseStatementPrintData;
	}

	public void setReservedForPrivateUseYearPartOfDate(
			String reservedForPrivateUseYearPartOfDate) {
		this.reservedForPrivateUseYearPartOfDate = reservedForPrivateUseYearPartOfDate;
	}

	public String getReservedForPrivateUseYearPartOfDate() {
		return reservedForPrivateUseYearPartOfDate;
	}

	public void setReservedForPrivateUse(String reservedForPrivateUse) {
		this.reservedForPrivateUse = reservedForPrivateUse;
	}

	public String getReservedForPrivateUse() {
		return reservedForPrivateUse;
	}

	public void setMessageAuthenticationCodeField2(
			String messageAuthenticationCodeField2) {
		this.messageAuthenticationCodeField2 = messageAuthenticationCodeField2;
	}

	public String getMessageAuthenticationCodeField2() {
		return messageAuthenticationCodeField2;
	}

	public void setValue(String fieldName, Object value) {
	}

	public Object getValue(String fieldName) {
		return null;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}