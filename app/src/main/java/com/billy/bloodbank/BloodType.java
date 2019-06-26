
package com.billy.bloodbank;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BloodType {

    @SerializedName("blood_group")
    @Expose
    private String bloodGroup;
    @SerializedName("component_name")
    @Expose
    private String componentName;
    @SerializedName("units_available")
    @Expose
    private String unitsAvailable;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getUnitsAvailable() {
        return unitsAvailable;
    }

    public void setUnitsAvailable(String unitsAvailable) {
        this.unitsAvailable = unitsAvailable;
    }

}
