package Controllers;

public class Validators {
    public static Validator validDate = (integer) -> {
        try{
            int date = (Integer) integer;
            if (date <= 0 || date > 31)
                return false;
        } catch (Exception e){
            return false;
        }

        return true;
    };

    public static Validator validMonth = (integer) -> {
      try {
          int month = (Integer) integer;
          if (month <= 0 || month > 12)
              return false;
      } catch (Exception e) {
          return false;
      }

      return true;
    };

   public  static Validator validPassword = (string) -> {
        int requirements = 0;
        String password = (String) string;
        String[] specialCharacters = {"|", "°", "¬", "!", "\"", "#", "$", "%", "&", "/", "(", ")", "=",
        "?", "'", "¿", "¡", "´", "+", "*", "~", "[", "]", "{", "}", "^", "`", ",", ";", ".", ":", "-", "_"};
        String[] lowerCase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
        "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
       String[] upperCase = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
               "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
       String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //Checking special characters
        for (String s : specialCharacters){
            if (password.contains(s)) {
                requirements ++;
                break;
            }
        }

        //Checking lower case
        for (String s : lowerCase) {
            if (password.contains(s)) {
                requirements ++;
                break;
            }
        }

       //Checking upper case
       for (String s : upperCase) {
           if (password.contains(s)) {
               requirements ++;
               break;
           }
       }

        //Checking for numbers
        for (String s : numbers) {
            if (password.contains(s)){
                requirements ++;
                break;
            }
        }

        return requirements == 4;
    };
}
