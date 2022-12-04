package com.big3anime.backend.finance;

import org.json.JSONObject;

public class Revenue {
    private String id;
    private String type;
    private String transactionId;
    private String modeOfPayment;
    private int timeTakenToGenerateRevenueInMonths;

    public Revenue() {
    }

    public Revenue(String type, String transactionId, String modeOfPayment, int timeTakenToGenerateRevenueInMonths) {
        this.type = type;
        this.transactionId = transactionId;
        this.modeOfPayment = modeOfPayment;
        this.timeTakenToGenerateRevenueInMonths = timeTakenToGenerateRevenueInMonths;
    }

    public JSONObject generateRevenueSlip(){
        JSONObject slipComponents = new JSONObject();

        slipComponents.put("Type of Revenue", this.type);
        slipComponents.put("Transaction Id from Payment Mode", this.transactionId);
        slipComponents.put("Mode of Payment", this.modeOfPayment);
        slipComponents.put("Time Period of Revenue in Months", this.timeTakenToGenerateRevenueInMonths);

        return slipComponents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getTimeTakenToGenerateRevenueInMonths() {
        return timeTakenToGenerateRevenueInMonths;
    }

    public void setTimeTakenToGenerateRevenueInMonths(int timeTakenToGenerateRevenueInMonths) {
        this.timeTakenToGenerateRevenueInMonths = timeTakenToGenerateRevenueInMonths;
    }

}
