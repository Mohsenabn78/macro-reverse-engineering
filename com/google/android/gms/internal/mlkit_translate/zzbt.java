package com.google.android.gms.internal.mlkit_translate;

import java.io.IOException;
import java.io.StringReader;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzbt {
    public static zzbo zza(zzdt zzdtVar) throws zzbp, zzbv {
        boolean zzl = zzdtVar.zzl();
        zzdtVar.zzj(true);
        try {
            try {
                return zzcj.zza(zzdtVar);
            } catch (OutOfMemoryError e4) {
                throw new zzbs("Failed parsing JSON source: " + zzdtVar + " to Json", e4);
            } catch (StackOverflowError e5) {
                throw new zzbs("Failed parsing JSON source: " + zzdtVar + " to Json", e5);
            }
        } finally {
            zzdtVar.zzj(zzl);
        }
    }

    public static zzbo zzb(String str) throws zzbv {
        try {
            zzdt zzdtVar = new zzdt(new StringReader(str));
            zzbo zza = zza(zzdtVar);
            if (!(zza instanceof zzbq) && zzdtVar.zzn() != 10) {
                throw new zzbv("Did not consume the entire document.");
            }
            return zza;
        } catch (zzdw e4) {
            throw new zzbv(e4);
        } catch (IOException e5) {
            throw new zzbp(e5);
        } catch (NumberFormatException e6) {
            throw new zzbv(e6);
        }
    }
}
