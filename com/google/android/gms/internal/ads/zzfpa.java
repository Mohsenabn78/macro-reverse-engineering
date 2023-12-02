package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfpa {
    private final String zza;
    private final zzfoy zzb;
    private zzfoy zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfpa(String str, zzfoz zzfozVar) {
        zzfoy zzfoyVar = new zzfoy(null);
        this.zzb = zzfoyVar;
        this.zzc = zzfoyVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfoy zzfoyVar = this.zzb.zzb;
        String str = "";
        while (zzfoyVar != null) {
            Object obj = zzfoyVar.zza;
            sb.append(str);
            if (obj != null && obj.getClass().isArray()) {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            } else {
                sb.append(obj);
            }
            zzfoyVar = zzfoyVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfpa zza(@CheckForNull Object obj) {
        zzfoy zzfoyVar = new zzfoy(null);
        this.zzc.zzb = zzfoyVar;
        this.zzc = zzfoyVar;
        zzfoyVar.zza = obj;
        return this;
    }
}
