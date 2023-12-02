package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzmt implements zzmh {
    private final zzja zza;
    private zzle zzb = new zzle();

    private zzmt(zzja zzjaVar, int i4) {
        this.zza = zzjaVar;
        zzne.zza();
    }

    public static zzmh zzf(zzja zzjaVar) {
        return new zzmt(zzjaVar, 0);
    }

    public static zzmh zzg() {
        return new zzmt(new zzja(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmh
    public final zzmh zza(zziz zzizVar) {
        this.zza.zzf(zzizVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmh
    public final zzmh zzb(zzjg zzjgVar) {
        this.zza.zzi(zzjgVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmh
    public final zzmh zzc(zzle zzleVar) {
        this.zzb = zzleVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmh
    public final String zzd() {
        zzlg zzf = this.zza.zzk().zzf();
        if (zzf != null && !zzad.zzc(zzf.zzk())) {
            return (String) Preconditions.checkNotNull(zzf.zzk());
        }
        return "NA";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzmh
    public final byte[] zze(int i4, boolean z3) {
        boolean z4;
        zzle zzleVar = this.zzb;
        if (1 != (i4 ^ 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        zzleVar.zzf(Boolean.valueOf(z4));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzj(this.zzb.zzm());
        try {
            zzne.zza();
            if (i4 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzhk.zza).ignoreNullValues(true).build().encode(this.zza.zzk()).getBytes("utf-8");
            }
            zzjc zzk = this.zza.zzk();
            zzbp zzbpVar = new zzbp();
            zzhk.zza.configure(zzbpVar);
            return zzbpVar.zza().zza(zzk);
        } catch (UnsupportedEncodingException e4) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e4);
        }
    }
}
