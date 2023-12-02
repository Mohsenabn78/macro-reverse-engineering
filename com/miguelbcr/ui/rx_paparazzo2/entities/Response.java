package com.miguelbcr.ui.rx_paparazzo2.entities;

/* loaded from: classes6.dex */
public class Response<T, D> {

    /* renamed from: a  reason: collision with root package name */
    private final T f36186a;

    /* renamed from: b  reason: collision with root package name */
    private final D f36187b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36188c;

    public Response(T t3, D d4, int i4) {
        this.f36186a = t3;
        this.f36187b = d4;
        this.f36188c = i4;
    }

    public D data() {
        return this.f36187b;
    }

    public int resultCode() {
        return this.f36188c;
    }

    public T targetUI() {
        return this.f36186a;
    }
}
