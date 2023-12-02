package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzaq extends zzai implements Set {
    @CheckForNull
    private transient zzam zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzay.zza(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzam zzf() {
        zzam zzamVar = this.zza;
        if (zzamVar == null) {
            zzam zzg = zzg();
            this.zza = zzg;
            return zzg;
        }
        return zzamVar;
    }

    zzam zzg() {
        Object[] array = toArray();
        int i4 = zzam.zzd;
        return zzam.zzg(array, array.length);
    }
}
