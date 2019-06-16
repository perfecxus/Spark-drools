package com.khusin;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sinchan on 07/09/17.
 */
public class Garage  implements Serializable{

    private String name;
    private String adddress;

    private List<Car> cars;

    private Action action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdddress() {
        return adddress;
    }

    public void setAdddress(String adddress) {
        this.adddress = adddress;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
