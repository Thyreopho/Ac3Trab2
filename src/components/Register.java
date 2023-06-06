package components;

import domain.RegisterElement;

public class Register {
    
    private int size = 10;
    private RegisterElement[] data = new RegisterElement[size];
    
    public Register() {
        for(int i = 0; i < size; i++){
            data[0].value = 0;
            data[0].busy = false;
        }
    }

    public RegisterElement get(int index) {
        return data[index];
    }

    public void set(int index, RegisterElement element) {
        data[index] = element;
    }
}