package com.miguelbcr.ui.rx_paparazzo2.interactors;

import java.io.Serializable;

/* loaded from: classes6.dex */
public final class Dimensions implements Serializable {
    private static final long serialVersionUID = 1;
    private int height;
    private int width;

    public Dimensions() {
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasSize() {
        if (this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    public void setHeight(int i4) {
        this.height = i4;
    }

    public void setWidth(int i4) {
        this.width = i4;
    }

    public Dimensions(int i4, int i5) {
        this.width = i4;
        this.height = i5;
    }
}
