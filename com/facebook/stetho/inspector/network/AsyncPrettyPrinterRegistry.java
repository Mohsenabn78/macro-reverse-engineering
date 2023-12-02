package com.facebook.stetho.inspector.network;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public class AsyncPrettyPrinterRegistry {
    private final Map<String, AsyncPrettyPrinterFactory> mRegistry = new HashMap();

    @Nullable
    public synchronized AsyncPrettyPrinterFactory lookup(String str) {
        return this.mRegistry.get(str);
    }

    public synchronized void register(String str, AsyncPrettyPrinterFactory asyncPrettyPrinterFactory) {
        this.mRegistry.put(str, asyncPrettyPrinterFactory);
    }

    public synchronized boolean unregister(String str) {
        boolean z3;
        if (this.mRegistry.remove(str) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        return z3;
    }
}
