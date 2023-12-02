package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class zzap {
    private static volatile boolean zzez = false;
    private static volatile zzap zzfb;
    private final Map<zzb, zzbc.zzf<?, ?>> zzfd;
    private static final Class<?> zzfa = zzan();
    static final zzap zzfc = new zzap(true);

    /* loaded from: classes4.dex */
    static final class zzb {
        private final int number;
        private final Object object;

        zzb(Object obj, int i4) {
            this.object = obj;
            this.number = i4;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.object != zzbVar.object || this.number != zzbVar.number) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzap() {
        this.zzfd = new HashMap();
    }

    private static Class<?> zzan() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzap zzao() {
        zzap zzapVar = zzfb;
        if (zzapVar == null) {
            synchronized (zzap.class) {
                zzapVar = zzfb;
                if (zzapVar == null) {
                    zzapVar = zzaq.zzaq();
                    zzfb = zzapVar;
                }
            }
        }
        return zzapVar;
    }

    public final <ContainingType extends zzck> zzbc.zzf<ContainingType, ?> zzb(ContainingType containingtype, int i4) {
        return (zzbc.zzf<ContainingType, ?>) this.zzfd.get(new zzb(containingtype, i4));
    }

    private zzap(boolean z3) {
        this.zzfd = Collections.emptyMap();
    }
}
