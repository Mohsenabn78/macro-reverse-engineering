package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CrashlyticsFileMarker {

    /* renamed from: a  reason: collision with root package name */
    private final String f29493a;

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f29494b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f29493a = str;
        this.f29494b = fileStore;
    }

    private File b() {
        return this.f29494b.getCommonFile(this.f29493a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e4) {
            Logger logger = Logger.getLogger();
            logger.e("Error creating marker: " + this.f29493a, e4);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
