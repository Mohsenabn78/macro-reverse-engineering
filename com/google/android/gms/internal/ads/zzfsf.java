package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfsf implements Map, Serializable {
    @CheckForNull
    private transient zzfsh zza;
    @CheckForNull
    private transient zzfsh zzb;
    @CheckForNull
    private transient zzfrx zzc;

    public static zzfsf zzc(Map map) {
        int i4;
        Set entrySet = map.entrySet();
        if (entrySet instanceof Collection) {
            i4 = entrySet.size();
        } else {
            i4 = 4;
        }
        zzfse zzfseVar = new zzfse(i4);
        zzfseVar.zzb(entrySet);
        return zzfseVar.zzc();
    }

    public static zzfsf zzd() {
        return zzftr.zza;
    }

    public static zzfsf zze(Object obj, Object obj2) {
        zzfqz.zzb("dialog_not_shown_reason", obj2);
        return zzftr.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
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
        return zzfsx.zzb(this, obj);
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
        return zzfty.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
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
        zzfqz.zza(size, "size");
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

    abstract zzfrx zza();

    @Override // java.util.Map
    /* renamed from: zzb */
    public final zzfrx values() {
        zzfrx zzfrxVar = this.zzc;
        if (zzfrxVar == null) {
            zzfrx zza = zza();
            this.zzc = zza;
            return zza;
        }
        return zzfrxVar;
    }

    abstract zzfsh zzf();

    abstract zzfsh zzg();

    @Override // java.util.Map
    /* renamed from: zzh */
    public final zzfsh entrySet() {
        zzfsh zzfshVar = this.zza;
        if (zzfshVar == null) {
            zzfsh zzf = zzf();
            this.zza = zzf;
            return zzf;
        }
        return zzfshVar;
    }

    @Override // java.util.Map
    /* renamed from: zzi */
    public final zzfsh keySet() {
        zzfsh zzfshVar = this.zzb;
        if (zzfshVar == null) {
            zzfsh zzg = zzg();
            this.zzb = zzg;
            return zzg;
        }
        return zzfshVar;
    }
}
