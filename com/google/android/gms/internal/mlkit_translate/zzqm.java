package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzqm {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084 A[Catch: IOException -> 0x008d, IOException | XmlPullParserException -> 0x008f, TryCatch #2 {IOException | XmlPullParserException -> 0x008f, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0013, B:12:0x0025, B:44:0x0088, B:15:0x002e, B:19:0x003e, B:21:0x0044, B:26:0x0051, B:41:0x0079, B:42:0x007f, B:43:0x0084), top: B:51:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map zza(android.content.Context r8, int r9) {
        /*
            java.lang.String r0 = "DefaultsXmlParser"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            if (r8 != 0) goto L13
            java.lang.String r8 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r0, r8)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            return r1
        L13:
            android.content.res.XmlResourceParser r8 = r8.getXml(r9)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            int r9 = r8.getEventType()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L1f:
            r6 = 1
            if (r9 == r6) goto L95
            r7 = 2
            if (r9 != r7) goto L2b
            java.lang.String r5 = r8.getName()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            goto L88
        L2b:
            r7 = 3
            if (r9 != r7) goto L4c
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            java.lang.String r5 = "entry"
            boolean r9 = r9.equals(r5)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            if (r9 == 0) goto L4a
            if (r3 == 0) goto L44
            if (r4 == 0) goto L44
            r1.put(r3, r4)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
        L41:
            r3 = r2
            r4 = r3
            goto L4a
        L44:
            java.lang.String r9 = "An entry in the defaults XML has an invalid key and/or value tag."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            goto L41
        L4a:
            r5 = r2
            goto L88
        L4c:
            r7 = 4
            if (r9 != r7) goto L88
            if (r5 == 0) goto L88
            int r9 = r5.hashCode()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            r7 = 106079(0x19e5f, float:1.48648E-40)
            if (r9 == r7) goto L6a
            r7 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r9 == r7) goto L60
            goto L74
        L60:
            java.lang.String r9 = "value"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L74
            r9 = 1
            goto L75
        L6a:
            java.lang.String r9 = "key"
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L74
            r9 = 0
            goto L75
        L74:
            r9 = -1
        L75:
            if (r9 == 0) goto L84
            if (r9 == r6) goto L7f
            java.lang.String r9 = "Encountered an unexpected tag while parsing the defaults XML."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            goto L88
        L7f:
            java.lang.String r4 = r8.getText()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            goto L88
        L84:
            java.lang.String r3 = r8.getText()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
        L88:
            int r9 = r8.next()     // Catch: java.io.IOException -> L8d org.xmlpull.v1.XmlPullParserException -> L8f
            goto L1f
        L8d:
            r8 = move-exception
            goto L90
        L8f:
            r8 = move-exception
        L90:
            java.lang.String r9 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r0, r9, r8)
        L95:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_translate.zzqm.zza(android.content.Context, int):java.util.Map");
    }
}
