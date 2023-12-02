package com.google.android.gms.internal.mlkit_translate;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzpg extends zzpv {
    private zzld zza;
    private String zzb;
    private boolean zzc;
    private ModelType zzd;
    private zzlj zze;
    private int zzf;
    private byte zzg;

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zza(zzlj zzljVar) {
        if (zzljVar != null) {
            this.zze = zzljVar;
            return this;
        }
        throw new NullPointerException("Null downloadStatus");
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zzb(zzld zzldVar) {
        if (zzldVar != null) {
            this.zza = zzldVar;
            return this;
        }
        throw new NullPointerException("Null errorCode");
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zzc(int i4) {
        this.zzf = i4;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zzd(ModelType modelType) {
        if (modelType != null) {
            this.zzd = modelType;
            return this;
        }
        throw new NullPointerException("Null modelType");
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zze(boolean z3) {
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpv zzf(boolean z3) {
        this.zzc = z3;
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    public final zzpv zzg(String str) {
        this.zzb = "NA";
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpv
    public final zzpw zzh() {
        zzld zzldVar;
        String str;
        ModelType modelType;
        zzlj zzljVar;
        if (this.zzg == 7 && (zzldVar = this.zza) != null && (str = this.zzb) != null && (modelType = this.zzd) != null && (zzljVar = this.zze) != null) {
            return new zzpi(zzldVar, str, this.zzc, false, modelType, zzljVar, this.zzf, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" errorCode");
        }
        if (this.zzb == null) {
            sb.append(" tfliteSchemaVersion");
        }
        if ((this.zzg & 1) == 0) {
            sb.append(" shouldLogRoughDownloadTime");
        }
        if ((this.zzg & 2) == 0) {
            sb.append(" shouldLogExactDownloadTime");
        }
        if (this.zzd == null) {
            sb.append(" modelType");
        }
        if (this.zze == null) {
            sb.append(" downloadStatus");
        }
        if ((this.zzg & 4) == 0) {
            sb.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
