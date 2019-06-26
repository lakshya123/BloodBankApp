
package com.billy.bloodbank;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("last_donation_date")
    @Expose
    private String lastDonationDate;
    @SerializedName("next_donation_date")
    @Expose
    private String nextDonationDate;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(String lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    public String getNextDonationDate() {
        return nextDonationDate;
    }

    public void setNextDonationDate(String nextDonationDate) {
        this.nextDonationDate = nextDonationDate;
    }

}
