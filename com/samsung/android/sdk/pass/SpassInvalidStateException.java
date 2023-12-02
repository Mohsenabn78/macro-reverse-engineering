package com.samsung.android.sdk.pass;

/* loaded from: classes6.dex */
public class SpassInvalidStateException extends IllegalStateException {
    public static final int STATUS_OPERATION_DENIED = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f37406a;

    public SpassInvalidStateException(String str, int i4) {
        super(str);
        this.f37406a = i4;
    }

    public int getType() {
        return this.f37406a;
    }
}
