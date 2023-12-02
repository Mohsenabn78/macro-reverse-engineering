package com.google.android.gms.internal.mlkit_translate;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzcj {
    public static zzbo zza(zzdt zzdtVar) throws zzbs {
        boolean z3;
        try {
            try {
                zzdtVar.zzn();
                try {
                    return (zzbo) zzdr.zzV.zza(zzdtVar);
                } catch (EOFException e4) {
                    e = e4;
                    z3 = false;
                    if (z3) {
                        return zzbq.zza;
                    }
                    throw new zzbv(e);
                }
            } catch (zzdw e5) {
                throw new zzbv(e5);
            } catch (IOException e6) {
                throw new zzbp(e6);
            } catch (NumberFormatException e7) {
                throw new zzbv(e7);
            }
        } catch (EOFException e8) {
            e = e8;
            z3 = true;
        }
    }
}
