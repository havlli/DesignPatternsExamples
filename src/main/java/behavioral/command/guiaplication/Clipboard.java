package behavioral.command.guiaplication;

public class Clipboard {
    private String contents;

    public void copy(String text) {
        contents = text;
    }

    public String getContents() {
        return contents;
    }
}
