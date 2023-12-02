package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabl {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group(1);
                int i4 = zzfj.zza;
                int parseInt = Integer.parseInt(group, 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zza = parseInt;
                    this.zzb = parseInt2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean zza() {
        if (this.zza != -1 && this.zzb != -1) {
            return true;
        }
        return false;
    }

    public final boolean zzb(zzbz zzbzVar) {
        for (int i4 = 0; i4 < zzbzVar.zza(); i4++) {
            zzby zzb = zzbzVar.zzb(i4);
            if (zzb instanceof zzaeg) {
                zzaeg zzaegVar = (zzaeg) zzb;
                if ("iTunSMPB".equals(zzaegVar.zzb) && zzc(zzaegVar.zzc)) {
                    return true;
                }
            } else if (zzb instanceof zzaep) {
                zzaep zzaepVar = (zzaep) zzb;
                if ("com.apple.iTunes".equals(zzaepVar.zza) && "iTunSMPB".equals(zzaepVar.zzb) && zzc(zzaepVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
