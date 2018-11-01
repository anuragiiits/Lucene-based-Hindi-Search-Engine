package file;

import java.util.ArrayList; 
import org.apache.commons.lang3.StringUtils;

public class SimpleHindiStemmer {

/* This is not coming while pasting the code better copy from Python Code as given in suffixes[1]  */
private static String [] stem1 = new String [] { "ो", "े", "ू", "ु", "ी", "ि", "ा" };

/* This is not coming while pasting the code better copy from Python Code as given in suffixes[2]  */
private static String [] stem2 = new String [] { "कर", "ाओ", "िए", "ाई", "ाए", "ने", "नी", "ना", "ते", "ीं", "ती", "ता", "ाँ", "ां", "ों", "ें" };

private static String [] stem3 = new String [] { "ाकर", "ाइए", "ाईं", "ाया", "ेगी", "ेगा", "ोगी", "ोगे", "ाने", "ाना", "ाते", "ाती", "ाता", "तीं", "ाओं", "ाएं", "ुओं", "ुएं", "ुआं" };

private static String [] stem4 = new String [] { "ाएगी", "ाएगा", "ाओगी", "ाओगे", "एंगी", "ेंगी", "एंगे", "ेंगे", "ूंगी", "ूंगा", "ातीं", "नाओं", "नाएं", "ताओं", "ताएं", "ियाँ", "ियों", "ियां" };

private static String [] stem5 = new String [] { "ाएंगी", "ाएंगे", "ाऊंगी", "ाऊंगा", "ाइयाँ", "ाइयों", "ाइयां" };

private static ArrayList<String []> stemList = new ArrayList<String []>(5);

static int [] cut = new int [] { 0, 1, 1, 1, 2, 2 };

static {

    stemList.add(stem5);
    stemList.add(stem4);
    stemList.add(stem3);
    stemList.add(stem2);
    stemList.add(stem1);

}

public SimpleHindiStemmer(){

}

public static void main(String [] argv){

    SimpleHindiStemmer sm = new SimpleHindiStemmer();
    String word = "रास्ते";
    System.out.println(sm.stemprocess(word));
}

public String stemprocess(String word){

//	String word1 = "";
    int wlen = word.length();
//    System.out.println(wlen);
    int wordlen = wlen*3;
    int icnt = 5;
    for (String [] stemwords : stemList){
        if(wordlen > (icnt + 1)){
            for(String sw: stemwords){
                if(StringUtils.endsWith(word, sw)){
                    return StringUtils.substring(word, 0, wlen - cut[icnt]);

                }
            }

        }


        icnt--;
    }

    return word;
}
}