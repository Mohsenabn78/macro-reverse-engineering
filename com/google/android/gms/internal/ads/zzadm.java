package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzadm {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0088, code lost:
        r7 = -9223372036854775807L;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzadi zza(java.lang.String r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadm.zza(java.lang.String):com.google.android.gms.internal.ads.zzadi");
    }

    private static zzfsc zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j4;
        long j5;
        zzfrz zzfrzVar = new zzfrz();
        do {
            String concat = str.concat(":Item");
            xmlPullParser.next();
            if (zzfk.zzc(xmlPullParser, concat)) {
                String concat2 = str2.concat(":Mime");
                String concat3 = str2.concat(":Semantic");
                String concat4 = str2.concat(":Length");
                String concat5 = str2.concat(":Padding");
                String zza2 = zzfk.zza(xmlPullParser, concat2);
                String zza3 = zzfk.zza(xmlPullParser, concat3);
                String zza4 = zzfk.zza(xmlPullParser, concat4);
                String zza5 = zzfk.zza(xmlPullParser, concat5);
                if (zza2 != null && zza3 != null) {
                    if (zza4 != null) {
                        j4 = Long.parseLong(zza4);
                    } else {
                        j4 = 0;
                    }
                    if (zza5 != null) {
                        j5 = Long.parseLong(zza5);
                    } else {
                        j5 = 0;
                    }
                    zzfrzVar.zzf(new zzadh(zza2, zza3, j4, j5));
                } else {
                    return zzfsc.zzl();
                }
            }
        } while (!zzfk.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfrzVar.zzi();
    }
}
