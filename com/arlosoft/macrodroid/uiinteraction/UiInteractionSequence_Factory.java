package com.arlosoft.macrodroid.uiinteraction;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class UiInteractionSequence_Factory implements Factory<UiInteractionSequence> {

    /* renamed from: a  reason: collision with root package name */
    private static final UiInteractionSequence_Factory f15871a = new UiInteractionSequence_Factory();

    public static UiInteractionSequence_Factory create() {
        return f15871a;
    }

    public static UiInteractionSequence newUiInteractionSequence() {
        return new UiInteractionSequence();
    }

    public static UiInteractionSequence provideInstance() {
        return new UiInteractionSequence();
    }

    @Override // javax.inject.Provider
    public UiInteractionSequence get() {
        return provideInstance();
    }
}
