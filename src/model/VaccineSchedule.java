package model;

import java.util.ArrayList;
import java.util.List;

public class VaccineSchedule {
    private List<Vaccine> vaccines;

    public VaccineSchedule(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public List<Vaccine> getVaccinesForMonth(int month) {
        List<Vaccine> result = new ArrayList<>();
        for (Vaccine v : vaccines) {
            if (v.getMonth() == month) result.add(v);
        }
        return result;
    }
}