public class WrongFileFormatException extends RuntimeException {
    public WrongFileFormatException(String keyword) {
        super( "Wrong file format (first word must be \"" + keyword + "\")" );
    }
}
