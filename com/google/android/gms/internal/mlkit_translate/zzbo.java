package com.google.android.gms.internal.mlkit_translate;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public class zzbo {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzdv zzdvVar = new zzdv(stringWriter);
            zzdvVar.zzj(true);
            zzdr.zzV.zzb(zzdvVar, this);
            return stringWriter.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public final zzbr zzb() {
        if (this instanceof zzbr) {
            return (zzbr) this;
        }
        toString();
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }
}
