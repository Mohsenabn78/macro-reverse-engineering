package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzum implements zzxy, zztd {
    final /* synthetic */ zzur zza;
    private final Uri zzc;
    private final zzhf zzd;
    private final zzuh zze;
    private final zzaaz zzf;
    private final zzeb zzg;
    private volatile boolean zzi;
    private long zzk;
    @Nullable
    private zzabz zzm;
    private boolean zzn;
    private final zzabs zzh = new zzabs();
    private boolean zzj = true;
    private final long zzb = zztf.zza();
    private zzgj zzl = zzi(0);

    public zzum(zzur zzurVar, Uri uri, zzge zzgeVar, zzuh zzuhVar, zzaaz zzaazVar, zzeb zzebVar) {
        this.zza = zzurVar;
        this.zzc = uri;
        this.zzd = new zzhf(zzgeVar);
        this.zze = zzuhVar;
        this.zzf = zzaazVar;
        this.zzg = zzebVar;
    }

    public static /* bridge */ /* synthetic */ long zzb(zzum zzumVar) {
        return zzumVar.zzb;
    }

    public static /* bridge */ /* synthetic */ long zzc(zzum zzumVar) {
        return zzumVar.zzk;
    }

    public static /* bridge */ /* synthetic */ zzgj zzd(zzum zzumVar) {
        return zzumVar.zzl;
    }

    public static /* bridge */ /* synthetic */ zzhf zze(zzum zzumVar) {
        return zzumVar.zzd;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzum zzumVar, long j4, long j5) {
        zzumVar.zzh.zza = j4;
        zzumVar.zzk = j5;
        zzumVar.zzj = true;
        zzumVar.zzn = false;
    }

    private final zzgj zzi(long j4) {
        Map map;
        zzgh zzghVar = new zzgh();
        zzghVar.zzd(this.zzc);
        zzghVar.zzc(j4);
        zzghVar.zza(6);
        map = zzur.zzb;
        zzghVar.zzb(map);
        return zzghVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zztd
    public final void zza(zzfa zzfaVar) {
        long zzQ;
        long max;
        if (this.zzn) {
            zzQ = this.zza.zzQ(true);
            max = Math.max(zzQ, this.zzk);
        } else {
            max = this.zzk;
        }
        int zza = zzfaVar.zza();
        zzabz zzabzVar = this.zzm;
        zzabzVar.getClass();
        zzabx.zzb(zzabzVar, zzfaVar, zza);
        zzabzVar.zzs(max, 1, zza, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0082 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0098 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00ae A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00c4 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00e0 A[Catch: all -> 0x01eb, TRY_LEAVE, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0116 A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x012a A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x016a A[Catch: all -> 0x01eb, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0173 A[Catch: all -> 0x01eb, TRY_LEAVE, TryCatch #6 {all -> 0x01eb, blocks: (B:135:0x000b, B:137:0x001f, B:138:0x0025, B:141:0x003b, B:142:0x0041, B:151:0x0077, B:153:0x0082, B:155:0x008e, B:157:0x0098, B:159:0x00a4, B:161:0x00ae, B:163:0x00ba, B:165:0x00c4, B:167:0x00d6, B:169:0x00e0, B:170:0x00e6, B:179:0x0116, B:180:0x011d, B:182:0x012a, B:184:0x0132, B:186:0x014f, B:188:0x016a, B:189:0x016f, B:191:0x0173, B:173:0x00f0, B:176:0x0104, B:146:0x004d, B:149:0x0063), top: B:245:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0186 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x020b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x01c9 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzum.zzh():void");
    }
}
