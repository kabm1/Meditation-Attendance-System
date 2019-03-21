package edu.mum.meditaion_attendance.util;

import java.time.LocalDate;
import java.util.HashMap;

public class Entries {



    public static HashMap<String, LocalDate> getEntries(){
         HashMap<String, LocalDate> entries= new HashMap<>();
        entries.put("August,2017",LocalDate.of(2017,8,1));
        entries.put("November,2017",LocalDate.of(2017,11,1));
        entries.put("February,2017",LocalDate.of(2017,2,1));
        entries.put("April,2017",LocalDate.of(2017,4,1));

        entries.put("August,2018",LocalDate.of(2018,8,1));
        entries.put("November,2018",LocalDate.of(2018,11,1));
        entries.put("February,2018",LocalDate.of(2018,2,1));
        entries.put("April,2018",LocalDate.of(2018,4,1));

        entries.put("August,2019",LocalDate.of(2019,8,1));
        entries.put("November,2019",LocalDate.of(2019,11,1));
        entries.put("February,2019",LocalDate.of(2019,2,1));
        entries.put("April,2019",LocalDate.of(2019,4,1));

        entries.put("August,2016",LocalDate.of(2016,8,1));
        entries.put("November,2016",LocalDate.of(2016,11,1));
        entries.put("February,2016",LocalDate.of(2016,2,1));
        entries.put("April,2016",LocalDate.of(2016,4,1));

        return entries;
    }
}
