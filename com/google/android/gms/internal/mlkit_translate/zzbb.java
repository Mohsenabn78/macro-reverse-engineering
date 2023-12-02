package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzbb implements zzbg {
    private final int zza;
    private final zzbf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(int i4, zzbf zzbfVar) {
        this.zza = i4;
        this.zzb = zzbfVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzbg.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbg)) {
            return false;
        }
        zzbg zzbgVar = (zzbg) obj;
        if (this.zza == zzbgVar.zza() && this.zzb.equals(zzbgVar.zzb())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.zza ^ 14552422) + (this.zzb.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.zza + "intEncoding=" + this.zzb + ')';
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbg
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzbg
    public final zzbf zzb() {
        return this.zzb;
    }
}
