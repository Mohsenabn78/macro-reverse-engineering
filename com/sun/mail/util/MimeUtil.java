package com.sun.mail.util;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.mail.internet.MimePart;

/* loaded from: classes6.dex */
public class MimeUtil {
    private static final Method cleanContentType;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019 A[Catch: all -> 0x0030, ClassNotFoundException | NoSuchMethodException | RuntimeException -> 0x0034, TRY_ENTER, TryCatch #0 {all -> 0x0030, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0010, B:13:0x0019, B:14:0x001d), top: B:22:0x0001 }] */
    static {
        /*
            r0 = 0
            java.lang.String r1 = "mail.mime.contenttypehandler"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            if (r1 == 0) goto L34
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            r3 = 0
            if (r2 == 0) goto L16
            java.lang.Class r2 = java.lang.Class.forName(r1, r3, r2)     // Catch: java.lang.ClassNotFoundException -> L15 java.lang.Throwable -> L30 java.lang.Throwable -> L34 java.lang.Throwable -> L34
            goto L17
        L15:
        L16:
            r2 = r0
        L17:
            if (r2 != 0) goto L1d
            java.lang.Class r2 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
        L1d:
            java.lang.String r1 = "cleanContentType"
            r4 = 2
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            java.lang.Class<javax.mail.internet.MimePart> r5 = javax.mail.internet.MimePart.class
            r4[r3] = r5     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r5 = 1
            r4[r5] = r3     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            java.lang.reflect.Method r0 = r2.getMethod(r1, r4)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L34
            goto L34
        L30:
            r1 = move-exception
            com.sun.mail.util.MimeUtil.cleanContentType = r0
            throw r1
        L34:
            com.sun.mail.util.MimeUtil.cleanContentType = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.MimeUtil.<clinit>():void");
    }

    private MimeUtil() {
    }

    public static String cleanContentType(MimePart mimePart, String str) {
        Method method = cleanContentType;
        if (method != null) {
            try {
                return (String) method.invoke(null, mimePart, str);
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: com.sun.mail.util.MimeUtil.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }
}
