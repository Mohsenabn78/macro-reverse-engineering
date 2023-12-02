package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.nearby.zztk;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class UwbAddress {

    /* renamed from: b  reason: collision with root package name */
    private static final zztk f22542b = zztk.zzh().zze(":", 2);

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22543a;

    public UwbAddress(@NonNull byte[] bArr) {
        this.f22543a = bArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UwbAddress)) {
            return false;
        }
        return Arrays.equals(this.f22543a, ((UwbAddress) obj).f22543a);
    }

    @NonNull
    public byte[] getAddress() {
        return this.f22543a;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f22543a);
    }

    @NonNull
    public String toString() {
        zztk zztkVar = f22542b;
        byte[] bArr = this.f22543a;
        return zztkVar.zzi(bArr, 0, bArr.length);
    }

    public UwbAddress(@NonNull String str) {
        this.f22543a = f22542b.zzj(str);
    }
}
