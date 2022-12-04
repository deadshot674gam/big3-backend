package com.big3anime.backend.finance;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;


/**
 * Class created for Defining Salary of each employee, contains every element inside of it, which a Salary contains
 * @author Divyanshu Tiwari
 */

public class Salary {
    private float baseAmount;
    private float internetAllowance;
    private float houseRentAllowance;
    private float leaveTravelAllowance;
    private float statutoryBonus;
    private float specialAllowance;
    private ConcurrentHashMap<String, Float> taxComponents = new ConcurrentHashMap<>();
    private float netSalary;

    public Salary(float baseAmount, float internetAllowance, float houseRentAllowance, float leaveTravelAllowance,
            float statutoryBonus, float specialAllowance) {
        this.baseAmount = baseAmount;
        this.internetAllowance = internetAllowance;
        this.houseRentAllowance = houseRentAllowance;
        this.leaveTravelAllowance = leaveTravelAllowance;
        this.statutoryBonus = statutoryBonus;
        this.specialAllowance = specialAllowance;
    }

    public void addTaxComponent(String componentName, float amount) {
        this.taxComponents.put(componentName, amount);
    }

    public void addTaxComponents(Map<String, Float> components) {
        for (Entry<String, Float> component : components.entrySet()) {
            this.addTaxComponent(component.getKey(), component.getValue());
        }
    }

    public void calculateNetSalary() {
        this.netSalary = this.baseAmount + this.statutoryBonus + this.houseRentAllowance + this.internetAllowance
                + this.leaveTravelAllowance + this.specialAllowance;


        for(Map.Entry<String,Float> taxComponent : this.taxComponents.entrySet()){
            this.netSalary -= taxComponent.getValue()==null? 0: taxComponent.getValue();
        }
    }

    public float getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(float baseAmount) {
        this.baseAmount = baseAmount;
    }

    public float getInternetAllowance() {
        return internetAllowance;
    }

    public void setInternetAllowance(float internetAllowance) {
        this.internetAllowance = internetAllowance;
    }

    public float getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(float houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public float getLeaveTravelAllowance() {
        return leaveTravelAllowance;
    }

    public void setLeaveTravelAllowance(float leaveTravelAllowance) {
        this.leaveTravelAllowance = leaveTravelAllowance;
    }

    public float getStatutoryBonus() {
        return statutoryBonus;
    }

    public void setStatutoryBonus(float statutoryBonus) {
        this.statutoryBonus = statutoryBonus;
    }

    public float getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(float specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public ConcurrentHashMap<String, Float> getTaxComponents() {
        return taxComponents;
    }


    public float getNetSalary() {
        this.calculateNetSalary();
        return netSalary;
    }


    public JSONObject generateSalarySlip(){
        JSONObject slipComponents = new JSONObject();

        slipComponents.put("Base Salary", this.baseAmount);
        slipComponents.put("House Rent Allowance", this.houseRentAllowance);
        slipComponents.put("Special Allowance", this.specialAllowance);
        slipComponents.put("Statutory Bonus", this.statutoryBonus);
        slipComponents.put("Internet Allowance", this.internetAllowance);
        slipComponents.put("Leave Travel Allowance", this.leaveTravelAllowance);

        slipComponents.put("Tax Components", this.taxComponents);


        return slipComponents;
    }
    

}
