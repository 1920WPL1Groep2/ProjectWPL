package Dao;

import java.sql.PreparedStatement;

public interface Queries {

    // Alles om Daozoekscherm op te vullen
    public static final String GETALLFAMILIEBYINITIALISE =
            "SELECT DISTINCT * FROM familie";
    //Voor combobox Type
    static final String GETALLTYPEBYINITIALISE =
            "SELECT DISTINCT * FROM type";

    //Voor Combobox Geslacht
     static final String GETALLGESLACHTBYINITIALISE =
            "SELECT DISTINCT * FROM geslacht";

    //Voor Combobox Soort
     static final String GETALLSOORTBYINITIALISE =
            "SELECT DISTINCT * FROM soort";


    //Planten opvragen bij opstart, indien geen ingegeven zoekcriteria er toch iets weergegeven wordt.
    static final String GETALLPLANTSBYINITIALISE =
            "SELECT * FROM plant ";


    //Planten opzoeken d.m.v.  plantennaam
   static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE fgsv LIKE ?";

    //Planten opzoeken d.m.v. Volledige PlantenFamilie
  static final String GETPLANTTBYFAMILIE =
            "SELECT * FROM plant WHERE familie LIKE ?";

    //Planten opzoeken d.m.v. Volledige plantentype
     static final String GETPLANTTBYTYPE =
            "SELECT * FROM plant WHERE type = ?";

    //Planten opzoeken d.m.v. Volledige plantenGeslacht
 static final String GETPLANTTBYGESLACHT =
            "SELECT * FROM plant WHERE geslacht = ?";

    //Planten opzoeken d.m.v. Volledige plantenSoort
     static final String GETPLANTTBYSOORT =
            "SELECT * FROM plant WHERE soort = ?";





    //Voor Combobox kleuren
     static final String GETALLKLEURENBYINITIALISE =
            "SELECT DISTINCT * FROM kleuren";

    //Voor Combobox Grootte
     static final String GETALLGROOTTESBYINITIALISE =
            "SELECT DISTINCT * FROM maxbladgrootte";

    //Voor Combobox bladvorm
     static final String GETALLBLADVORMNBYINITIALISE =
            "SELECT DISTINCT * FROM bladvorm";

    //Voor Combobox spruitfenologie
     static final String GETALLSPRUITFENOBYINITIALISE =
            "SELECT DISTINCT * FROM spruitfenologie";
}
