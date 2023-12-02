package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzajt {
    public final int zza;
    @Nullable
    public final String zzb;
    public final List zzc;
    public final byte[] zzd;

    public zzajt(int i4, @Nullable String str, @Nullable List list, byte[] bArr) {
        List unmodifiableList;
        this.zza = i4;
        this.zzb = str;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.zzc = unmodifiableList;
        this.zzd = bArr;
    }
}
