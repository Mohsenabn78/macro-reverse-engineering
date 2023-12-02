package com.google.android.gms.internal.mlkit_translate;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzpi extends zzpw {
    private final zzld zza;
    private final String zzb;
    private final boolean zzc;
    private final ModelType zzd;
    private final zzlj zze;
    private final int zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpi(zzld zzldVar, String str, boolean z3, boolean z4, ModelType modelType, zzlj zzljVar, int i4, zzph zzphVar) {
        this.zza = zzldVar;
        this.zzb = str;
        this.zzc = z3;
        this.zzd = modelType;
        this.zze = zzljVar;
        this.zzf = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpw) {
            zzpw zzpwVar = (zzpw) obj;
            if (this.zza.equals(zzpwVar.zzc()) && this.zzb.equals(zzpwVar.zze()) && this.zzc == zzpwVar.zzg()) {
                zzpwVar.zzf();
                if (this.zzd.equals(zzpwVar.zzb()) && this.zze.equals(zzpwVar.zzd()) && this.zzf == zzpwVar.zza()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003;
        if (true != this.zzc) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        return ((((((((hashCode ^ i4) * 1000003) ^ 1237) * 1000003) ^ this.zzd.hashCode()) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        boolean z3 = this.zzc;
        String obj2 = this.zzd.toString();
        String obj3 = this.zze.toString();
        int i4 = this.zzf;
        return "RemoteModelLoggingOptions{errorCode=" + obj + ", tfliteSchemaVersion=" + str + ", shouldLogRoughDownloadTime=" + z3 + ", shouldLogExactDownloadTime=false, modelType=" + obj2 + ", downloadStatus=" + obj3 + ", failureStatusCode=" + i4 + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final ModelType zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final zzld zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final zzlj zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpw
    public final boolean zzg() {
        return this.zzc;
    }
}
