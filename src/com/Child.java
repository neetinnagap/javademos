package com;

import java.io.Serializable;

public class Child extends Parent implements Serializable {

    public int getNum() {
        return 2;
    }

    @Override
    public int getNum2() {
        return 2;
    }
}
