package model;
import java.util.List;

public class Baby {
    private String name;
    private int ageInMonths;
    private double weight;

    public Baby(String name, int ageInMonths, double weight) {
        this.name = name;
        this.ageInMonths = ageInMonths;
        this.weight = weight;
    }

    public String getName() { return name; }
    public int getAgeInMonths() { return ageInMonths; }

    public String generateFullReport(List<Vaccine> vaccines) {
        StringBuilder sb = new StringBuilder();
        sb.append("==========================================\n");
        sb.append("       گزارش مراقبتی و واکسیناسیون نوزاد\n");
        sb.append("==========================================\n\n");
        sb.append("👤 نام نوزاد: ").append(name).append("\n");
        sb.append("📅 سن فعلی: ").append(ageInMonths).append(" ماهگی\n");
        sb.append("⚖️ وزن ثبت شده: ").append(weight).append(" کیلوگرم\n");
        sb.append("----------------------------------------------------------------------\n");
        
        sb.append("💡 توصیه‌های مراقبتی این ماه:\n");
        if (ageInMonths < 6) sb.append("- تاکید بر تغذیه انحصاری با شیر مادر.\n");
        else sb.append("- شروع تدریجی غذای کمکی مجاز است.\n");
        
        if (weight < 2.5) sb.append("- هشدار: وزن نوزاد کمتر از حد نرمال است.\n");
        
        sb.append("\n💉 واکسن‌های مورد نیاز:\n");
        if (vaccines.isEmpty()) {
            sb.append("- در این ماه واکسن زمان‌بندی شده‌ای وجود ندارد.\n");
        } else {
            for (Vaccine v : vaccines) {
                sb.append("• ").append(v.getName()).append(" (").append(v.getDescription()).append(")\n");
            }
        }
        sb.append("\n==========================================");
        return sb.toString();
    }
}