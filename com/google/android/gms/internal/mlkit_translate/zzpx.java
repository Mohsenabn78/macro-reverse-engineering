package com.google.android.gms.internal.mlkit_translate;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzpx implements zzpj {
    private final zzlf zza;
    private zznp zzb = new zznp();

    private zzpx(zzlf zzlfVar, int i4) {
        this.zza = zzlfVar;
        zzrf.zza();
    }

    public static zzpj zzf(zzlf zzlfVar) {
        return new zzpx(zzlfVar, 0);
    }

    public static zzpj zzg() {
        return new zzpx(new zzlf(), 0);
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpj
    public final zzpj zza(zzle zzleVar) {
        this.zza.zzg(zzleVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpj
    public final zzpj zzb(zzll zzllVar) {
        this.zza.zzi(zzllVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpj
    public final zzpj zzc(zznp zznpVar) {
        this.zzb = zznpVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpj
    public final String zzd() {
        zznr zzh = this.zza.zzm().zzh();
        if (zzh != null && !zzl.zzc(zzh.zzk())) {
            return (String) Preconditions.checkNotNull(zzh.zzk());
        }
        return "NA";
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpj
    public final byte[] zze(int i4, boolean z3) {
        boolean z4;
        zznp zznpVar = this.zzb;
        if (1 != (i4 ^ 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        zznpVar.zzf(Boolean.valueOf(z4));
        this.zzb.zze(Boolean.FALSE);
        this.zza.zzl(this.zzb.zzm());
        try {
            zzrf.zza();
            if (i4 == 0) {
                return new JsonDataEncoderBuilder().configureWith(zzjp.zza).ignoreNullValues(true).build().encode(this.zza.zzm()).getBytes("utf-8");
            }
            zzlh zzm = this.zza.zzm();
            zzbk zzbkVar = new zzbk();
            zzjp.zza.configure(zzbkVar);
            return zzbkVar.zza().zza(zzm);
        } catch (UnsupportedEncodingException e4) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e4);
        }
    }
}
