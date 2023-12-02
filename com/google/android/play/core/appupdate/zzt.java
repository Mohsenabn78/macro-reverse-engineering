package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzt {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25259a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(Context context) {
        this.f25259a = context;
    }

    private static long b(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles != null) {
            for (File file2 : listFiles) {
                j4 += b(file2);
            }
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long a() {
        return b(new File(this.f25259a.getFilesDir(), "assetpacks"));
    }
}
