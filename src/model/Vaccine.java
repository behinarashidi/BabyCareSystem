package model;

public class Vaccine extends CareItem {
    private int month;

    public Vaccine(String name, int month, String description) {
        super(name, description);
        this.month = month;
    }

    public int getMonth() { return month; }

    @Override
    public String getInfo() {
        return "💉 واکسن: " + name + " | " + (month == 0 ? "بدو تولد" : month + " ماهگی") + "\n" + description;
    }
}