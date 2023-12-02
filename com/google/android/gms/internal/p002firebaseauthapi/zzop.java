package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzop  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzop {
    @Nullable
    private ArrayList zza = new ArrayList();
    private zzom zzb = zzom.zza;
    @Nullable
    private Integer zzc = null;

    public final zzop zza(zzbu zzbuVar, int i4, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzor(zzbuVar, i4, str, str2, null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzop zzb(zzom zzomVar) {
        if (this.zza != null) {
            this.zzb = zzomVar;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzop zzc(int i4) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i4);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzot zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    int zza = ((zzor) arrayList.get(i4)).zza();
                    i4++;
                    if (zza == intValue) {
                        zzot zzotVar = new zzot(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
                        this.zza = null;
                        return zzotVar;
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzot zzotVar2 = new zzot(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, null);
            this.zza = null;
            return zzotVar2;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
