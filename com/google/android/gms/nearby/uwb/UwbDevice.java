package com.google.android.gms.nearby.uwb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class UwbDevice {

    /* renamed from: a  reason: collision with root package name */
    private final UwbAddress f22548a;

    private UwbDevice(UwbAddress uwbAddress) {
        this.f22548a = uwbAddress;
    }

    @NonNull
    public static UwbDevice createForAddress(@NonNull String str) {
        return new UwbDevice(new UwbAddress(str));
    }

    @SuppressLint({"NewApi"})
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbDevice)) {
            return false;
        }
        UwbAddress uwbAddress = this.f22548a;
        UwbAddress uwbAddress2 = ((UwbDevice) obj).f22548a;
        if (uwbAddress == uwbAddress2 || uwbAddress.equals(uwbAddress2)) {
            return true;
        }
        return false;
    }

    @NonNull
    public UwbAddress getAddress() {
        return this.f22548a;
    }

    @SuppressLint({"NewApi"})
    public int hashCode() {
        return this.f22548a.hashCode();
    }

    @NonNull
    public String toString() {
        return String.format("UwbDevice {%s}", this.f22548a);
    }

    @NonNull
    public static UwbDevice createForAddress(@NonNull byte[] bArr) {
        return new UwbDevice(new UwbAddress(bArr));
    }
}
