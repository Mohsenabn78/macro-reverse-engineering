package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
class zzfmf {
    static final String zza = new UUID(0, 0).toString();
    final zzfmg zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfmf(Context context, String str, String str2, String str3) {
        this.zzb = zzfmg.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        String str4;
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str5 = this.zzg;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        String str6 = "null";
        if (str2 == null) {
            str4 = "null";
        } else {
            str4 = "not null";
        }
        sb.append(str4);
        sb.append(", hashKey is ");
        if (str3 != null) {
            str6 = "not null";
        }
        sb.append(str6);
        throw new IllegalArgumentException(sb.toString());
    }

    final long zza(boolean z3) {
        String str;
        zzfmg zzfmgVar = this.zzb;
        if (z3) {
            str = this.zzf;
        } else {
            str = this.zze;
        }
        return zzfmgVar.zza(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfme zzb(@Nullable String str, @Nullable String str2, long j4, boolean z3) throws IOException {
        String str3;
        boolean z4 = true;
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String zze = zze(true);
                    String zzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (zze != null && zzc != null && !zze.equals(zzh(str, str2, zzc))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfme();
        }
        if (str == null) {
            z4 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            long zza2 = zza(z4);
            if (zza2 != -1) {
                if (currentTimeMillis < zza2) {
                    zzfmg zzfmgVar = this.zzb;
                    if (z4) {
                        str3 = this.zzf;
                    } else {
                        str3 = this.zze;
                    }
                    zzfmgVar.zzd(str3, Long.valueOf(currentTimeMillis));
                } else if (currentTimeMillis >= zza2 + j4) {
                    return zzc(str, str2);
                }
            }
            String zze2 = zze(z4);
            if (zze2 == null && !z3) {
                return zzc(str, str2);
            }
            return new zzfme(zze2, zza(z4));
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    final zzfme zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String uuid = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", uuid);
        return zzd(zzh(str, str2, uuid), true);
    }

    final zzfme zzd(String str, boolean z3) throws IOException {
        String str2;
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= 0) {
            zzfmg zzfmgVar = this.zzb;
            if (z3) {
                str2 = this.zzf;
            } else {
                str2 = this.zze;
            }
            zzfmgVar.zzd(str2, Long.valueOf(currentTimeMillis));
            zzfmg zzfmgVar2 = this.zzb;
            if (z3) {
                str3 = this.zzd;
            } else {
                str3 = this.zzc;
            }
            zzfmgVar2.zzd(str3, str);
            return new zzfme(str, currentTimeMillis);
        }
        throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
    }

    final String zze(boolean z3) {
        String str;
        zzfmg zzfmgVar = this.zzb;
        if (z3) {
            str = this.zzd;
        } else {
            str = this.zzc;
        }
        return zzfmgVar.zzc(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf(boolean z3) throws IOException {
        String str;
        String str2;
        zzfmg zzfmgVar = this.zzb;
        if (z3) {
            str = this.zzf;
        } else {
            str = this.zze;
        }
        zzfmgVar.zze(str);
        zzfmg zzfmgVar2 = this.zzb;
        if (z3) {
            str2 = this.zzd;
        } else {
            str2 = this.zzc;
        }
        zzfmgVar2.zze(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzg(boolean z3) {
        return this.zzb.zzg(this.zzc);
    }
}
