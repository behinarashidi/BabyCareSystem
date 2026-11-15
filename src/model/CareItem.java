package model;

public abstract class CareItem {
    protected String name;
    protected String description;

    public CareItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract String getInfo();
    public String getName() { return name; }
    public String getDescription() { return description; }
}