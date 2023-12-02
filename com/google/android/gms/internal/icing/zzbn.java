package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzbn<T> implements zzbm<T> {
    volatile zzbm<T> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(zzbm<T> zzbmVar) {
        this.zza = zzbmVar;
    }

    public final String toString() {
        Object obj = this.zza;
        if (obj == null) {
            StringBuilder sb = new StringBuilder("null".length() + 25);
            sb.append("<supplier that returned ");
            sb.append("null");
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
