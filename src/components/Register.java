package components;

import domain.RegisterElement;

public class Register {
    
    private RegisterElement[] data;
    
    public Register(int size) {
        data = new RegisterElement[size];
        for(int i = 0; i < size; i++){
            RegisterElement reg = new RegisterElement();
             data[i] = reg;
        }
    }

    public int size() {
        return data.length;
    }

    public RegisterElement get(int index) {
        return data[index];
    }

    public void set(int index, RegisterElement element) {
        data[index] = element;
    }
}