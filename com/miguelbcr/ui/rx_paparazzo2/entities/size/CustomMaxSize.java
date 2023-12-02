package com.miguelbcr.ui.rx_paparazzo2.entities.size;

/* loaded from: classes6.dex */
public class CustomMaxSize implements Size {

    /* renamed from: a  reason: collision with root package name */
    private int f36190a;

    public CustomMaxSize() {
        this.f36190a = 1024;
    }

    public int getMaxImageSize() {
        return this.f36190a;
    }

    public CustomMaxSize(int i4) {
        this.f36190a = i4;
    }
}
