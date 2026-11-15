package data;

import model.Vaccine;
import java.util.ArrayList;
import java.util.List;

public class VaccineData {

    public static List<Vaccine> getAllVaccines() {
        List<Vaccine> list = new ArrayList<>();

        list.add(new Vaccine("BCG", 0, "پیشگیری از سل"));
        list.add(new Vaccine("هپاتیت B (HepB)", 0, "پیشگیری از هپاتیت B"));
        list.add(new Vaccine("فلج اطفال خوراکی (OPV)", 0, "پیشگیری از فلج اطفال"));

        list.add(new Vaccine("پنج‌گانه (DTP + Hib + HepB)", 2, "دیفتری، کزاز، سیاه‌سرفه، هموفیلوس آنفلوانزا، هپاتیت B"));
        list.add(new Vaccine("فلج اطفال تزریقی (IPV)", 2, "پیشگیری از فلج اطفال"));
        list.add(new Vaccine("روتا ویروس (Rotavirus)", 2, "جلوگیری از اسهال شدید و کم‌آبی"));

        list.add(new Vaccine("پنج‌گانه", 4, "همان ترکیب 5 تایی بالا (دوز دوم)"));
        list.add(new Vaccine("فلج اطفال (IPV)", 4, "تزریقی (دوز دوم)"));
        list.add(new Vaccine("روتا ویروس", 4, "خوراکی (دوز دوم)"));

        list.add(new Vaccine("پنج‌گانه", 6, "دوز سوم"));
        list.add(new Vaccine("فلج اطفال (OPV یا IPV)", 6, "بر اساس مراکز (دوز سوم)"));

        list.add(new Vaccine("MMR (یک سال)", 12, "سرخک + سرخجه + اوریون"));

        list.add(new Vaccine("پنج‌گانه (یادآور)", 18, "تقویت ایمنی 5 بیماری"));
        list.add(new Vaccine("فلج اطفال یادآور (OPV/IPV)", 18, "تقویتی"));
        list.add(new Vaccine("آبله‌مرغان (Varicella)", 18, "اختیاری / غیردولتی (مناسب برای 18 تا 19 ماهگی)"));

        return list;
    }
}
