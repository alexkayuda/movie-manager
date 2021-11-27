package com.example.invoice.enums;

public enum ResponseCode {
    UNKNOWN(0, 0),
    SUCCESSFUL(1,1),
    ERROR(2,2);

    private int index;
    private int value;

    public final static int UNKNOWN_VALUE = 0;
    public final static int SUCCESSFUL_VALUE = 1;
    public final static int ERROR_VALUE = 2;

    private ResponseCode(int index, int value){
        this.index = index;
        this.value = value;
    }

    public static ResponseCode valueOf(int value){
        switch (value){
            case 0:
                return UNKNOWN;
            case 1:
                return SUCCESSFUL;
            case 2:
                return ERROR;
            default:
                return null;
        }
    }
}
