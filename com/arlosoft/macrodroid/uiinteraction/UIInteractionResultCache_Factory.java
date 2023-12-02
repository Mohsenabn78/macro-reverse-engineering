package com.arlosoft.macrodroid.uiinteraction;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class UIInteractionResultCache_Factory implements Factory<UIInteractionResultCache> {

    /* renamed from: a  reason: collision with root package name */
    private static final UIInteractionResultCache_Factory f15863a = new UIInteractionResultCache_Factory();

    public static UIInteractionResultCache_Factory create() {
        return f15863a;
    }

    public static UIInteractionResultCache newUIInteractionResultCache() {
        return new UIInteractionResultCache();
    }

    public static UIInteractionResultCache provideInstance() {
        return new UIInteractionResultCache();
    }

    @Override // javax.inject.Provider
    public UIInteractionResultCache get() {
        return provideInstance();
    }
}
