package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghq {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzghn zzb = zzghn.zza;
    @Nullable
    private Integer zzc = null;

    public final zzghq zza(zzfxs zzfxsVar, int i4, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzghs(zzfxsVar, i4, str, str2, null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzghq zzb(zzghn zzghnVar) {
        if (this.zza != null) {
            this.zzb = zzghnVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzghq zzc(int i4) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i4);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzghu zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    int zza = ((zzghs) arrayList.get(i4)).zza();
                    i4++;
                    if (zza == intValue) {
                        zzghu zzghuVar = new zzghu(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
                        this.zza = null;
                        return zzghuVar;
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzghu zzghuVar2 = new zzghu(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
            this.zza = null;
            return zzghuVar2;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
