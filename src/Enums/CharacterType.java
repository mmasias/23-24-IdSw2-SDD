package Enums;

public enum CharacterType {
    Playable("\033[38;5;220m"),
    NonPlayable("\033[38;5;52m");

    private final String asciiColor;
    CharacterType(String asciiColor) {
        this.asciiColor = asciiColor;
    }
    public String getAsciiColor() {
        return asciiColor;
    }
}

