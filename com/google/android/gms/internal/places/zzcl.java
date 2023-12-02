package com.google.android.gms.internal.places;

import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzcl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(zzck zzckVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzb(zzckVar, sb, 0);
        return sb.toString();
    }

    private static final String zzl(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01e5, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e7, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f7, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0208, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x021a, code lost:
        if (((java.lang.Double) r11).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzb(com.google.android.gms.internal.places.zzck r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzcl.zzb(com.google.android.gms.internal.places.zzck, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i4, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i4, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i4, str, entry);
            }
        } else {
            sb.append('\n');
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzdo.zzd(zzw.zzi((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzw) {
                sb.append(": \"");
                sb.append(zzdo.zzd((zzw) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzbc) {
                sb.append(" {");
                zzb((zzbc) obj, sb, i4 + 2);
                sb.append("\n");
                while (i5 < i4) {
                    sb.append(' ');
                    i5++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i7 = i4 + 2;
                zzb(sb, i7, "key", entry2.getKey());
                zzb(sb, i7, "value", entry2.getValue());
                sb.append("\n");
                while (i5 < i4) {
                    sb.append(' ');
                    i5++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }
}
