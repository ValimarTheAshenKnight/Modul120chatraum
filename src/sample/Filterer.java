package sample;

import java.util.regex.Pattern;

/**
 * Created by d.buetikofer on 27.04.2017.
 */
abstract public class Filterer {

    private static final String[] kiddyFilter = {
            "dick", "cock", "douche", "fuck", "ass", "bitch",
            "retard", "shit", "reatard", "pussy", "cunt", "wank", "faggot"
    };

    public static String filter(String word) {

        for (String badWord : kiddyFilter) {

            if (word.contains(badWord)) {
                word = word.replace(badWord, "CENSORED");
            }
        }
        return word;
    }

    public static boolean foundSwearWord(String usersname) {
        boolean containsSwearWords = false;

        for (String badWord : kiddyFilter) {

            if (usersname.contains(badWord)) {
                containsSwearWords = true;
            }
        }
        return containsSwearWords;
    }
}
