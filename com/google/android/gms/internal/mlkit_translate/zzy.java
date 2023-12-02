package com.google.android.gms.internal.mlkit_translate;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public abstract class zzy implements Map, Serializable {
    @CheckForNull
    private transient zzaa zza;
    @CheckForNull
    private transient zzaa zzb;
    @CheckForNull
    private transient zzr zzc;

    public static zzy zzc() {
        return zzai.zza;
    }

    public static zzy zzd(Object obj, Object obj2) {
        zzn.zza("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
        return zzai.zzi(1, new Object[]{"optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID}, null);
    }

    public static zzy zze(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        zzn.zza("iw", TranslateLanguage.HEBREW);
        zzn.zza("in", "id");
        zzn.zza("nb", TranslateLanguage.NORWEGIAN);
        return zzai.zzi(3, new Object[]{"iw", TranslateLanguage.HEBREW, "in", "id", "nb", TranslateLanguage.NORWEGIAN}, null);
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
        return zzak.zza(entrySet());
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
        zzaa zzaaVar = this.zzb;
        if (zzaaVar == null) {
            zzaa zzg = zzg();
            this.zzb = zzg;
            return zzg;
        }
        return zzaaVar;
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

    abstract zzr zza();

    @Override // java.util.Map
    /* renamed from: zzb */
    public final zzr values() {
        zzr zzrVar = this.zzc;
        if (zzrVar == null) {
            zzr zza = zza();
            this.zzc = zza;
            return zza;
        }
        return zzrVar;
    }

    abstract zzaa zzf();

    abstract zzaa zzg();

    @Override // java.util.Map
    /* renamed from: zzh */
    public final zzaa entrySet() {
        zzaa zzaaVar = this.zza;
        if (zzaaVar == null) {
            zzaa zzf = zzf();
            this.zza = zzf;
            return zzf;
        }
        return zzaaVar;
    }
}
