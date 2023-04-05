package region;

public class CityTools {

    public static String code(String city){
        switch (city.length()){
            case 0:
                return "___";
            case 1:
                return city.toUpperCase() + "__";
            case 2:
                return city.toUpperCase() + "_";
            default:
                return city.substring(0,3).toUpperCase();
        }
    }
}
