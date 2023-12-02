package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgmq {
    public static final zzgmq zza = new zzgmq(new zzgmr());
    public static final zzgmq zzb = new zzgmq(new zzgmv());
    public static final zzgmq zzc = new zzgmq(new zzgmx());
    public static final zzgmq zzd = new zzgmq(new zzgmw());
    public static final zzgmq zze = new zzgmq(new zzgms());
    public static final zzgmq zzf = new zzgmq(new zzgmu());
    public static final zzgmq zzg = new zzgmq(new zzgmt());
    private final zzgmp zzh;

    public zzgmq(zzgmy zzgmyVar) {
        if (zzgdi.zzb()) {
            this.zzh = new zzgmo(zzgmyVar, null);
        } else if (zzgnh.zza()) {
            this.zzh = new zzgmk(zzgmyVar, null);
        } else {
            this.zzh = new zzgmm(zzgmyVar, null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}
