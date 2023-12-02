package com.arlosoft.macrodroid.screenread;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class ScreenContentsCache_Factory implements Factory<ScreenContentsCache> {

    /* renamed from: a  reason: collision with root package name */
    private static final ScreenContentsCache_Factory f13308a = new ScreenContentsCache_Factory();

    public static ScreenContentsCache_Factory create() {
        return f13308a;
    }

    public static ScreenContentsCache newScreenContentsCache() {
        return new ScreenContentsCache();
    }

    public static ScreenContentsCache provideInstance() {
        return new ScreenContentsCache();
    }

    @Override // javax.inject.Provider
    public ScreenContentsCache get() {
        return provideInstance();
    }
}
