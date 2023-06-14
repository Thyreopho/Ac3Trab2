package domain;

public class RegisterElement {
    public boolean busy;
    public Byte value;
    public int id;

    public RegisterElement(int identificator) {
        busy = false;
        value = null;
        id = identificator;
    }
}
