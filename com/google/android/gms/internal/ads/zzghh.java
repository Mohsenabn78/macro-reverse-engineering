package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghh implements zzfyn {
    private static final Logger zza = Logger.getLogger(zzghh.class.getName());
    private static final byte[] zzb = {0};
    private static final zzghh zzc = new zzghh();

    zzghh() {
    }

    public static void zze() throws GeneralSecurityException {
        zzfyp.zzf(zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfyn
    public final Class zza() {
        return zzfye.class;
    }

    @Override // com.google.android.gms.internal.ads.zzfyn
    public final Class zzb() {
        return zzfye.class;
    }

    @Override // com.google.android.gms.internal.ads.zzfyn
    public final /* bridge */ /* synthetic */ Object zzc(zzfym zzfymVar) throws GeneralSecurityException {
        for (List<zzfyi> list : zzfymVar.zzd()) {
            for (zzfyi zzfyiVar : list) {
                if (zzfyiVar.zzb() instanceof zzghd) {
                    zzghd zzghdVar = (zzghd) zzfyiVar.zzb();
                    zzgnk zzb2 = zzgnk.zzb(zzfyiVar.zzg());
                    if (!zzb2.equals(zzghdVar.zzb())) {
                        String valueOf = String.valueOf(zzghdVar.zza());
                        String obj = zzghdVar.zzb().toString();
                        String obj2 = zzb2.toString();
                        throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                    }
                }
            }
        }
        return new zzghg(zzfymVar, null);
    }
}
