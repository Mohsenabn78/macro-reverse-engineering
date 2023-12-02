package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzbz implements zzch {
    private zzch[] zzki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbz(zzch... zzchVarArr) {
        this.zzki = zzchVarArr;
    }

    @Override // com.google.android.gms.internal.places.zzch
    public final boolean zzb(Class<?> cls) {
        for (zzch zzchVar : this.zzki) {
            if (zzchVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzch
    public final zzci zzc(Class<?> cls) {
        zzch[] zzchVarArr;
        String str;
        for (zzch zzchVar : this.zzki) {
            if (zzchVar.zzb(cls)) {
                return zzchVar.zzc(cls);
            }
        }
        String name = cls.getName();
        if (name.length() != 0) {
            str = "No factory is available for message type: ".concat(name);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }
}
