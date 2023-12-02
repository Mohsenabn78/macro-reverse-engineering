package com.hippo.quickjs.android;

import com.arlosoft.macrodroid.helper.HelperCommandsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JSFloat64.java */
/* loaded from: classes6.dex */
public final class f extends JSNumber {

    /* renamed from: c  reason: collision with root package name */
    private final double f34086c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(long j4, JSContext jSContext, double d4) {
        super(j4, jSContext);
        this.f34086c = d4;
    }

    private String b(String str, double d4) {
        return "Can't treat " + d4 + " as " + str;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public byte getByte() {
        double d4 = this.f34086c;
        byte b4 = (byte) d4;
        if (b4 == d4) {
            return b4;
        }
        throw new JSDataException(b("byte", d4));
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public double getDouble() {
        return this.f34086c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public float getFloat() {
        return (float) this.f34086c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public int getInt() {
        double d4 = this.f34086c;
        int i4 = (int) d4;
        if (i4 == d4) {
            return i4;
        }
        throw new JSDataException(b(HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, d4));
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public long getLong() {
        double d4 = this.f34086c;
        long j4 = (long) d4;
        if (j4 == d4) {
            return j4;
        }
        throw new JSDataException(b(HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_LONG, d4));
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public short getShort() {
        double d4 = this.f34086c;
        short s3 = (short) d4;
        if (s3 == d4) {
            return s3;
        }
        throw new JSDataException(b("short", d4));
    }
}
