package com.miguelbcr.ui.rx_paparazzo2.entities;

/* loaded from: classes6.dex */
public class PermissionDeniedException extends RuntimeException {
    private int code;

    public PermissionDeniedException(int i4) {
        this.code = i4;
    }

    public int getCode() {
        return this.code;
    }
}
