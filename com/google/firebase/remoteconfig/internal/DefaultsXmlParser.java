package com.google.firebase.remoteconfig.internal;

/* loaded from: classes5.dex */
public class DefaultsXmlParser {
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082 A[Catch: IOException -> 0x008b, IOException | XmlPullParserException -> 0x008d, TryCatch #2 {IOException | XmlPullParserException -> 0x008d, blocks: (B:3:0x0007, B:5:0x000d, B:7:0x0013, B:12:0x0025, B:43:0x0086, B:15:0x002d, B:19:0x003d, B:20:0x0041, B:26:0x004f, B:40:0x0077, B:41:0x007d, B:42:0x0082, B:31:0x005e, B:34:0x0068), top: B:50:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> getDefaultsFromXml(android.content.Context r8, int r9) {
        /*
            java.lang.String r0 = "FirebaseRemoteConfig"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            if (r8 != 0) goto L13
            java.lang.String r8 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r0, r8)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            return r1
        L13:
            android.content.res.XmlResourceParser r8 = r8.getXml(r9)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            int r9 = r8.getEventType()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L1f:
            r6 = 1
            if (r9 == r6) goto L93
            r7 = 2
            if (r9 != r7) goto L2a
            java.lang.String r3 = r8.getName()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            goto L86
        L2a:
            r7 = 3
            if (r9 != r7) goto L4a
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            java.lang.String r3 = "entry"
            boolean r9 = r9.equals(r3)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            if (r9 == 0) goto L48
            if (r4 == 0) goto L41
            if (r5 == 0) goto L41
            r1.put(r4, r5)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            goto L46
        L41:
            java.lang.String r9 = "An entry in the defaults XML has an invalid key and/or value tag."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
        L46:
            r4 = r2
            r5 = r4
        L48:
            r3 = r2
            goto L86
        L4a:
            r7 = 4
            if (r9 != r7) goto L86
            if (r3 == 0) goto L86
            int r9 = r3.hashCode()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            r7 = 106079(0x19e5f, float:1.48648E-40)
            if (r9 == r7) goto L68
            r7 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r9 == r7) goto L5e
            goto L72
        L5e:
            java.lang.String r9 = "value"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            if (r9 == 0) goto L72
            r9 = 1
            goto L73
        L68:
            java.lang.String r9 = "key"
            boolean r9 = r3.equals(r9)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            if (r9 == 0) goto L72
            r9 = 0
            goto L73
        L72:
            r9 = -1
        L73:
            if (r9 == 0) goto L82
            if (r9 == r6) goto L7d
            java.lang.String r9 = "Encountered an unexpected tag while parsing the defaults XML."
            android.util.Log.w(r0, r9)     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            goto L86
        L7d:
            java.lang.String r5 = r8.getText()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            goto L86
        L82:
            java.lang.String r4 = r8.getText()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
        L86:
            int r9 = r8.next()     // Catch: java.io.IOException -> L8b org.xmlpull.v1.XmlPullParserException -> L8d
            goto L1f
        L8b:
            r8 = move-exception
            goto L8e
        L8d:
            r8 = move-exception
        L8e:
            java.lang.String r9 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r0, r9, r8)
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.DefaultsXmlParser.getDefaultsFromXml(android.content.Context, int):java.util.Map");
    }
}
