public class StringManipulator {
    public String trimAndConcat(String first, String second) {
        String firstTrimmed = first.trim();
        String secondTrimmed = second.trim();
        return firstTrimmed.concat(secondTrimmed);
    }
    public Integer getIndexOrNull(String phrase, char anyChar) {
        Integer result = phrase.indexOf(anyChar);
        if (result == -1){
            return null;
        }
        return result;
    }
    public Integer getIndexorNullStr(String phrase, String subPhrase) {
        Integer result = phrase.indexOf(subPhrase);
        if (result == -1){
            return null;
        }
        return result;
    }
    public String concatSubstring(String first, int start, int end, String second) {
        String newFirst = first.substring(start, end);
        return newFirst.concat(second);
    }
}