package com.facebook.stetho.inspector.console;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class ConsolePeerManager extends ChromePeerManager {
    private static ConsolePeerManager sInstance;

    private ConsolePeerManager() {
    }

    @Nullable
    public static synchronized ConsolePeerManager getInstanceOrNull() {
        ConsolePeerManager consolePeerManager;
        synchronized (ConsolePeerManager.class) {
            consolePeerManager = sInstance;
        }
        return consolePeerManager;
    }

    public static synchronized ConsolePeerManager getOrCreateInstance() {
        ConsolePeerManager consolePeerManager;
        synchronized (ConsolePeerManager.class) {
            if (sInstance == null) {
                sInstance = new ConsolePeerManager();
            }
            consolePeerManager = sInstance;
        }
        return consolePeerManager;
    }
}
