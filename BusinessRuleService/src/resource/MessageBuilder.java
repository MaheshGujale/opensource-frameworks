package resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

import businessrulesruntime.core.engine.model.Message;

public class MessageBuilder {
	
	public static final ThreadLocal<DateFormat> transmissionDateTimeFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("MMddHHmmss");
		}
	};
	
	public static final ThreadLocal<DateFormat> transactionLocalDateTimeFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("yyMMddHHmmss");
		}
	};
	
	public static final ThreadLocal<DateFormat> settlementDateFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("yyMMdd");
		}
	};
	
	public static final ThreadLocal<DateFormat> dateConversionFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("MMdd");
		}
	};
	
	public static final ThreadLocal<DateFormat> dateCaptureFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("MMdd");
		}
	};
	
	public static final ThreadLocal<DateFormat> dateExpirationFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {

			return new SimpleDateFormat("yyMM");
		}
	};
	

	public static void main(String[] args) throws ParseException {
		Message msg = new Message();
		msg.setMti("1200");
		msg.setPrimaryAccountNumber("5242479284253047");
		msg.setProcessingCode("000000");
		msg.setAmountTransaction((double) 100);
		//msg.setAmountSettlement(new Double(13));
		//msg.setAmountCardholderBilling(new Double(14));
		msg.setTranmissionDate(transmissionDateTimeFormat.get().parse("1101064708"));
		//msg.setAmountCardholderBillingRate("");
		//msg.setConversionRateReconcilation("");
		msg.setConversionRateCardholderBill("70215054");
		msg.setTraceAuditNumber("003977");
		//msg.setDateTimeLocalTransaction(transactionLocalDateTimeFormat.get().parse("171101121708"));
		//msg.setDateEffective(new Date());
		/*msg.setDateExpiration(dateExpirationFormat.get().parse("2011"));
		msg.setDateSettlement(settlementDateFormat.get().parse("110117"));*/
		//msg.setDateConversion(new Date());
		/*msg.setDateCapture(dateCaptureFormat.get().parse("1102"));*/
		msg.setMerchantType("5999");
		msg.setCountryCodeAcquring("356");
		//msg.setCountryCode("");
		//msg.setForwardingInstitution("");
		msg.setPointOfServiceDataCode("A01101200000");
		/*msg.setCardSequenceNumber("");
		msg.setFunctionCode("");
		msg.setMessageReasonCode("");
		msg.setCardAcceptorBusinesscode("");
		msg.setApprovalCodeLength("");
		msg.setDateReconcilciation("");
		msg.setReconciliationIndicator("");
		msg.setAmountOriginal("");
		msg.setAcquirerRefrenceData("");*/
		msg.setAcqInstitutionIdentificationCode("445566");
		msg.setForwardingInstitutionIdentificationCode("445567");
		/*msg.setPanExtended("");
		msg.setTrack2Data("");
		msg.setTrack3Data("");*/
		msg.setRetrievalReferenceNumber("730506003977");
		msg.setApprovalCode("005427");
		msg.setResponseCode("000");
		msg.setServiceCode("");
		msg.setCardAcceptorTerminalIdentification("");
		msg.setCardAcceptorIdentificationCode("");
		msg.setCardAcceptorName("");
		msg.setAdditionalResponseData("");
		msg.setTrack1Data("");
		msg.setAmountFees("");
		msg.setAdditionalDataNational("");
		msg.setAdditionalDataPrivate("");
		msg.setCurrencyCodeTransaction("");
		msg.setCurrencyCodeReconciliation("");
		msg.setCurrencyCodeCardholderBilling("");
		msg.setPersonalIdentificationNumber("");
		msg.setSecurityRelatedInformation("");
		msg.setAmountsAdditionals("");
		msg.setIcCardData("");
		msg.setOriginalDataElements("");
		msg.setAuthorizationLifecycleCode("");
		msg.setAuthorizationAgentInstitutionIdentificationCode("");
		msg.setTransportdData("");
		msg.setReservedNational1("");
		msg.setReservednational2("");
		msg.setReservedPrivateChequeDetails("");
		msg.setReservedPrivateConsumerNumber("");
		msg.setMessageAuthenticationCodeField1("");
		msg.setReservedForISOUse("");
		msg.setAmountOriginalFees("");
		msg.setExtendedPaymentData("");
		msg.setCountryCodeRecevingInstitution("");
		msg.setCountryCodeSettlement("");
		msg.setAuthorizingAgentInstitution("");
		msg.setMessageNumber("");
		msg.setDataRecord("");
		msg.setDataAction("");
		msg.setCreditsNumber("");
		msg.setCreditReversalNumber("");
		msg.setDebitsNumber("");
		msg.setDebitsReversalNumber("");
		msg.setTransferNumber("");
		msg.setTransaferReversalNumber("");
		msg.setInquiriesNumber("");
		msg.setAuthorizationsNumber("");
		msg.setInquiriesReversalNumber("");
		msg.setPaymentNumber("");
		msg.setPaymentSreversalNumber("");
		msg.setFeeCollectionNumber("");
		msg.setCreditsAmount("");
		msg.setCreditsReversalAmount("");
		msg.setDebitsAmount("");
		msg.setDebitsReversalAmounts("");
		msg.setAuthorizationsReversalNumber("");
		msg.setCountryCodeTransactionDestinationInstitution("");
		msg.setCountryCodeTransactionOriginatorInstitution("");
		msg.setTransactionDestinationInstitutionIdCode("");
		msg.setTransactionOriginatorInstitutionIdCode("");
		msg.setCardIssuerReferenceData("");
		msg.setKeyManagementData("");
		msg.setAmountNetReconciliation("");
		msg.setPayee("");
		msg.setSettlementInstitutionIdentificationCode("");
		msg.setReceivingInstitutionIdentificationCode("");
		msg.setFileName("");
		msg.setAccountIdentification1("");
		msg.setAccountIdentification2("");
		msg.setTransactionDescription("");
		msg.setCreditsChargeBackAmount("");
		msg.setDebitChargeBackAmount("");
		msg.setCreditsChargeBackNumber("");
		msg.setDebitsChargeBackNumber("");
		msg.setCreditsfeAmounts("");
		msg.setDebitsfeAmounts("");
		msg.setReservedISO("");
		msg.setReservedForISOUse1("");
		msg.setReservedForISOUse2("");
		msg.setReservedForISOUse3("");
		msg.setReservedForISOUse4("");
		msg.setReservedForNationalUse1("");
		msg.setReservedForNationalUse2("");
		msg.setReservedForNationalUse3("");
		msg.setReservedForNationalUse4("");
		msg.setReservedForNationalUse5("");
		msg.setReservedForNationalUse6("");
		msg.setReservedForNationalUse7("");
		msg.setReservedForPrivateUserDeliveryChannelControllerId("");
		msg.setReservedForPrivateUseTerminalType("");
		msg.setReservedForPrivateUseStatementPrintData("");
		msg.setReservedForPrivateUseYearPartOfDate("");
		msg.setReservedForPrivateUse("");
		msg.setMessageAuthenticationCodeField2("");
		msg.setTransactionMonitorData("");

		System.out.println((new JSONObject(msg)));
	}
}
