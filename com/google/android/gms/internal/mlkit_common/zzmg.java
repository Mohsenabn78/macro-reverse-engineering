package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzmg extends zzms {
    private final zziy zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final ModelType zze;
    private final zzje zzf;
    private final int zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmg(zziy zziyVar, String str, boolean z3, boolean z4, ModelType modelType, zzje zzjeVar, int i4, zzmf zzmfVar) {
        this.zza = zziyVar;
        this.zzb = str;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = modelType;
        this.zzf = zzjeVar;
        this.zzg = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzms) {
            zzms zzmsVar = (zzms) obj;
            if (this.zza.equals(zzmsVar.zzc()) && this.zzb.equals(zzmsVar.zze()) && this.zzc == zzmsVar.zzg() && this.zzd == zzmsVar.zzf() && this.zze.equals(zzmsVar.zzb()) && this.zzf.equals(zzmsVar.zzd()) && this.zzg == zzmsVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003;
        int i5 = 1237;
        if (true != this.zzc) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        int i6 = (hashCode ^ i4) * 1000003;
        if (true == this.zzd) {
            i5 = 1231;
        }
        return ((((((i6 ^ i5) * 1000003) ^ this.zze.hashCode()) * 1000003) ^ this.zzf.hashCode()) * 1000003) ^ this.zzg;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        boolean z3 = this.zzc;
        boolean z4 = this.zzd;
        String obj2 = this.zze.toString();
        String obj3 = this.zzf.toString();
        int i4 = this.zzg;
        return "RemoteModelLoggingOptions{errorCode=" + obj + ", tfliteSchemaVersion=" + str + ", shouldLogRoughDownloadTime=" + z3 + ", shouldLogExactDownloadTime=" + z4 + ", modelType=" + obj2 + ", downloadStatus=" + obj3 + ", failureStatusCode=" + i4 + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final ModelType zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final zziy zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final zzje zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final String zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzms
    public final boolean zzg() {
        return this.zzc;
    }
}
