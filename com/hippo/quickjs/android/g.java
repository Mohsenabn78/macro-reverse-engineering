package com.hippo.quickjs.android;

import com.google.android.gms.nearby.uwb.RangingPosition;
import net.bytebuddy.asm.Advice;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JSInt.java */
/* loaded from: classes6.dex */
public final class g extends JSNumber {

    /* renamed from: c  reason: collision with root package name */
    private final int f34087c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(long j4, JSContext jSContext, int i4) {
        super(j4, jSContext);
        this.f34087c = i4;
    }

    private int b(String str, int i4, int i5) {
        int i6 = this.f34087c;
        if (i4 <= i6 && i6 <= i5) {
            return i6;
        }
        throw new JSDataException("Can't treat " + i6 + " as " + str);
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public byte getByte() {
        return (byte) b("byte", RangingPosition.RSSI_UNKNOWN, 127);
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public double getDouble() {
        return this.f34087c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public float getFloat() {
        return this.f34087c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public int getInt() {
        return this.f34087c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public long getLong() {
        return this.f34087c;
    }

    @Override // com.hippo.quickjs.android.JSNumber
    public short getShort() {
        return (short) b("short", -32768, Advice.MethodSizeHandler.UNDEFINED_SIZE);
    }
}
