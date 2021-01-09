package com;

public interface TestInterface {
    int num=1;

    default int getNum() {
        return num;
    }

    int getnum2();
}
