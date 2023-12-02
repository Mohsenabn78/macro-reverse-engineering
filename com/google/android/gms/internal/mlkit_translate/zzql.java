package com.google.android.gms.internal.mlkit_translate;

import android.content.Context;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzql {
    private static final Pattern zza = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzqw zzf;

    public zzql(Context context, String str, String str2, String str3, long j4, long j5, zzqw zzqwVar) {
        String str4;
        this.zzb = context;
        this.zzc = str;
        this.zzd = str2;
        Matcher matcher = zza.matcher(str);
        if (matcher.matches()) {
            str4 = matcher.group(1);
        } else {
            str4 = null;
        }
        this.zze = str4;
        this.zzf = zzqwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:(3:78|79|80)|81|82|83|84|(1:86)|87|88|(1:90)|91|92|79|80) */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0314, code lost:
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x036c A[Catch: all -> 0x040b, TryCatch #4 {all -> 0x0429, blocks: (B:52:0x0216, B:53:0x021f, B:74:0x02ed, B:75:0x02f0, B:78:0x02ff, B:80:0x0304, B:81:0x030d, B:85:0x0318, B:86:0x031b, B:90:0x0325, B:91:0x0328, B:92:0x032c, B:96:0x033a, B:97:0x0349, B:130:0x0411, B:131:0x0428, B:54:0x023c, B:57:0x0252, B:67:0x029f, B:68:0x02a5, B:69:0x02ba, B:71:0x02c1, B:72:0x02c6, B:73:0x02cf, B:99:0x034b, B:100:0x035a, B:102:0x035c, B:103:0x036b, B:60:0x0259, B:61:0x0265, B:63:0x026b, B:64:0x027b, B:66:0x0281, B:104:0x036c, B:114:0x03c9, B:116:0x03d0, B:118:0x03d6, B:120:0x03e7, B:121:0x03f8, B:122:0x0401, B:124:0x0403, B:125:0x040a, B:107:0x037c, B:108:0x0388, B:110:0x038e, B:111:0x039e, B:113:0x03a4), top: B:143:0x0216, inners: #3, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a6 A[LOOP:0: B:12:0x00a0->B:14:0x00a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0252 A[Catch: all -> 0x040b, TRY_ENTER, TryCatch #4 {all -> 0x0429, blocks: (B:52:0x0216, B:53:0x021f, B:74:0x02ed, B:75:0x02f0, B:78:0x02ff, B:80:0x0304, B:81:0x030d, B:85:0x0318, B:86:0x031b, B:90:0x0325, B:91:0x0328, B:92:0x032c, B:96:0x033a, B:97:0x0349, B:130:0x0411, B:131:0x0428, B:54:0x023c, B:57:0x0252, B:67:0x029f, B:68:0x02a5, B:69:0x02ba, B:71:0x02c1, B:72:0x02c6, B:73:0x02cf, B:99:0x034b, B:100:0x035a, B:102:0x035c, B:103:0x036b, B:60:0x0259, B:61:0x0265, B:63:0x026b, B:64:0x027b, B:66:0x0281, B:104:0x036c, B:114:0x03c9, B:116:0x03d0, B:118:0x03d6, B:120:0x03e7, B:121:0x03f8, B:122:0x0401, B:124:0x0403, B:125:0x040a, B:107:0x037c, B:108:0x0388, B:110:0x038e, B:111:0x039e, B:113:0x03a4), top: B:143:0x0216, inners: #3, #7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.mlkit_translate.zzqn zza(java.net.HttpURLConnection r17, java.lang.String r18, java.lang.String r19, java.util.Map r20, java.lang.String r21, java.util.Map r22, java.util.Date r23, java.lang.String r24, @androidx.annotation.Nullable java.lang.String r25, com.google.android.gms.internal.mlkit_translate.zzox r26) throws com.google.android.gms.internal.mlkit_translate.zzqv {
        /*
            Method dump skipped, instructions count: 1083
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzql.zza(java.net.HttpURLConnection, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.util.Date, java.lang.String, java.lang.String, com.google.android.gms.internal.mlkit_translate.zzox):com.google.android.gms.internal.mlkit_translate.zzqn");
    }

    public final HttpURLConnection zzb() throws zzqv {
        try {
            return (HttpURLConnection) new URL(String.format(RemoteConfigConstants.FETCH_REGEX_URL, this.zze, "firebase")).openConnection();
        } catch (IOException e4) {
            throw new zzqv(e4.getMessage());
        }
    }
}
