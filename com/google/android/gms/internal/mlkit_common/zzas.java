package com.google.android.gms.internal.mlkit_common;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public abstract class zzas extends zzak implements Set {
    @CheckForNull
    private transient zzao zza;

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
        return zzba.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzak, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzbb iterator();

    public final zzao zzf() {
        zzao zzaoVar = this.zza;
        if (zzaoVar == null) {
            zzao zzg = zzg();
            this.zza = zzg;
            return zzg;
        }
        return zzaoVar;
    }

    zzao zzg() {
        return zzao.zzh(toArray());
    }
}
