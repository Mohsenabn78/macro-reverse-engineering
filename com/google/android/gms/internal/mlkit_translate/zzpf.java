package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzpf extends zzpl {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpf(String str, boolean z3, int i4, zzpe zzpeVar) {
        this.zza = str;
        this.zzb = z3;
        this.zzc = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpl) {
            zzpl zzplVar = (zzpl) obj;
            if (this.zza.equals(zzplVar.zzb()) && this.zzb == zzplVar.zzc() && this.zzc == zzplVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i4;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        if (true != this.zzb) {
            i4 = 1237;
        } else {
            i4 = 1231;
        }
        return ((hashCode ^ i4) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z3 = this.zzb;
        int i4 = this.zzc;
        return "MLKitLoggingOptions{libraryName=" + str + ", enableFirelog=" + z3 + ", firelogEventType=" + i4 + "}";
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpl
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpl
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzpl
    public final boolean zzc() {
        return this.zzb;
    }
}
