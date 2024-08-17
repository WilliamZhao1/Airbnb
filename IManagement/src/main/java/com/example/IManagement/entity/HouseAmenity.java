package com.example.IManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseAmenity {
    private boolean attic;
    @JsonProperty("basketball court")
    private boolean basketballCourt;
    @JsonProperty("air conditioning")
    private boolean airConditioning;
    private boolean lawn;
    @JsonProperty("swimming pool")
    private boolean swimmingPool;
    @JsonProperty("barbeque")
    private boolean bbq;
    private boolean microwave;
    @JsonProperty("tv cable")
    private boolean tvCable;
    private boolean dryer;
    @JsonProperty("outdoor shower")
    private boolean outdoorShower;
    private boolean washer;
    private boolean gym;
    @JsonProperty("ocean view")
    private boolean oceanView;
    @JsonProperty("private space")
    private boolean privateSpace;
    @JsonProperty("lake view")
    private boolean lakeView;
    @JsonProperty("wine cellar")
    private boolean wineCeller;
    @JsonProperty("front yard")
    private boolean frontYard;
    private boolean refrigerator;
    private boolean wifi;
    private boolean laundry;
    private boolean sauna;
    
	public boolean isAttic() {
		return attic;
	}
	public void setAttic(boolean attic) {
		this.attic = attic;
	}
	public boolean isBasketballCourt() {
		return basketballCourt;
	}
	public void setBasketballCourt(boolean basketballCourt) {
		this.basketballCourt = basketballCourt;
	}
	public boolean isAirConditioning() {
		return airConditioning;
	}
	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}
	public boolean isLawn() {
		return lawn;
	}
	public void setLawn(boolean lawn) {
		this.lawn = lawn;
	}
	public boolean isSwimmingPool() {
		return swimmingPool;
	}
	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}
	public boolean isBbq() {
		return bbq;
	}
	public void setBbq(boolean bbq) {
		this.bbq = bbq;
	}
	public boolean isMicrowave() {
		return microwave;
	}
	public void setMicrowave(boolean microwave) {
		this.microwave = microwave;
	}
	public boolean isTvCable() {
		return tvCable;
	}
	public void setTvCable(boolean tvCable) {
		this.tvCable = tvCable;
	}
	public boolean isDryer() {
		return dryer;
	}
	public void setDryer(boolean dryer) {
		this.dryer = dryer;
	}
	public boolean isOutdoorShower() {
		return outdoorShower;
	}
	public void setOutdoorShower(boolean outdoorShower) {
		this.outdoorShower = outdoorShower;
	}
	public boolean isWasher() {
		return washer;
	}
	public void setWasher(boolean washer) {
		this.washer = washer;
	}
	public boolean isGym() {
		return gym;
	}
	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public boolean isOceanView() {
		return oceanView;
	}
	public void setOceanView(boolean oceanView) {
		this.oceanView = oceanView;
	}
	public boolean isPrivateSpace() {
		return privateSpace;
	}
	public void setPrivateSpace(boolean privateSpace) {
		this.privateSpace = privateSpace;
	}
	public boolean isLakeView() {
		return lakeView;
	}
	public void setLakeView(boolean lakeView) {
		this.lakeView = lakeView;
	}
	public boolean isWineCeller() {
		return wineCeller;
	}
	public void setWineCeller(boolean wineCeller) {
		this.wineCeller = wineCeller;
	}
	public boolean isFrontYard() {
		return frontYard;
	}
	public void setFrontYard(boolean frontYard) {
		this.frontYard = frontYard;
	}
	public boolean isRefrigerator() {
		return refrigerator;
	}
	public void setRefrigerator(boolean refrigerator) {
		this.refrigerator = refrigerator;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isLaundry() {
		return laundry;
	}
	public void setLaundry(boolean laundry) {
		this.laundry = laundry;
	}
	public boolean isSauna() {
		return sauna;
	}
	public void setSauna(boolean sauna) {
		this.sauna = sauna;
	}
	
    
}
