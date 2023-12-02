package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzasv extends zzath {
    public zzasv(zzart zzartVar, String str, String str2, zzanq zzanqVar, int i4, int i5) {
        super(zzartVar, "MaMum1gy44m6JY9Yl3WvxKuatqxbLd+TDTFZCPGq8yp5qgeEGUri2jXkJQRPEPHe", "leMw6wdbg7yTx0Ew+oCz/A25ggsdiYC0Nz8e1tg0+qk=", zzanqVar, i4, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzath
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaqz zzaqzVar = new zzaqz((String) this.zzf.invoke(null, this.zzb.zzb(), Boolean.valueOf(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcs)).booleanValue())));
        synchronized (this.zze) {
            this.zze.zzj(zzaqzVar.zza);
            this.zze.zzC(zzaqzVar.zzb);
        }
    }
}
