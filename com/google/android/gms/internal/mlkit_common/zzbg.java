package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzbg implements zzbl {
    private final int zza;
    private final zzbk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(int i4, zzbk zzbkVar) {
        this.zza = i4;
        this.zzb = zzbkVar;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return zzbl.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbl)) {
            return false;
        }
        zzbl zzblVar = (zzbl) obj;
        if (this.zza == zzblVar.zza() && this.zzb.equals(zzblVar.zzb())) {
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

    @Override // com.google.android.gms.internal.mlkit_common.zzbl
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzbl
    public final zzbk zzb() {
        return this.zzb;
    }
}
