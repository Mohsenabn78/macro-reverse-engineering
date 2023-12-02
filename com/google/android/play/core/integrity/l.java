package com.google.android.play.core.integrity;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class l {

    /* renamed from: a  reason: collision with root package name */
    private static j f25294a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized j a(Context context) {
        j jVar;
        synchronized (l.class) {
            if (f25294a == null) {
                h hVar = new h(null);
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                hVar.a(context);
                f25294a = hVar.b();
            }
            jVar = f25294a;
        }
        return jVar;
    }
}
