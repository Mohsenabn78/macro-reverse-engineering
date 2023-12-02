package com.arlosoft.macrodroid.helper;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class HelperResultHandler_Factory implements Factory<HelperResultHandler> {

    /* renamed from: a  reason: collision with root package name */
    private static final HelperResultHandler_Factory f12288a = new HelperResultHandler_Factory();

    public static HelperResultHandler_Factory create() {
        return f12288a;
    }

    public static HelperResultHandler newHelperResultHandler() {
        return new HelperResultHandler();
    }

    public static HelperResultHandler provideInstance() {
        return new HelperResultHandler();
    }

    @Override // javax.inject.Provider
    public HelperResultHandler get() {
        return provideInstance();
    }
}
