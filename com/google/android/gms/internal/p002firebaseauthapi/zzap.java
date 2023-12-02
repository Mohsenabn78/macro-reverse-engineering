package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzap  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzap implements Map, Serializable {
    @CheckForNull
    private transient zzaq zza;
    @CheckForNull
    private transient zzaq zzb;
    @CheckForNull
    private transient zzai zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public static zzap zzc(Iterable iterable) {
        int i4;
        if (iterable instanceof Collection) {
            i4 = iterable.size();
        } else {
            i4 = 4;
        }
        zzao zzaoVar = new zzao(i4);
        zzaoVar.zza(iterable);
        zzan zzanVar = zzaoVar.zzc;
        if (zzanVar == null) {
            zzax zzg = zzax.zzg(zzaoVar.zzb, zzaoVar.zza, zzaoVar);
            zzan zzanVar2 = zzaoVar.zzc;
            if (zzanVar2 == null) {
                return zzg;
            }
            throw zzanVar2.zza();
        }
        throw zzanVar.zza();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzay.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaq zzaqVar = this.zzb;
        if (zzaqVar == null) {
            zzaq zze = zze();
            this.zzb = zze;
            return zze;
        }
        return zzaqVar;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
            sb.append('{');
            boolean z3 = true;
            for (Map.Entry entry : entrySet()) {
                if (!z3) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append(SignatureVisitor.INSTANCEOF);
                sb.append(entry.getValue());
                z3 = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    abstract zzai zza();

    @Override // java.util.Map
    /* renamed from: zzb */
    public final zzai values() {
        zzai zzaiVar = this.zzc;
        if (zzaiVar == null) {
            zzai zza = zza();
            this.zzc = zza;
            return zza;
        }
        return zzaiVar;
    }

    abstract zzaq zzd();

    abstract zzaq zze();

    @Override // java.util.Map
    /* renamed from: zzf */
    public final zzaq entrySet() {
        zzaq zzaqVar = this.zza;
        if (zzaqVar == null) {
            zzaq zzd = zzd();
            this.zza = zzd;
            return zzd;
        }
        return zzaqVar;
    }
}
