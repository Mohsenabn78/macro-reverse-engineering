package com.arlosoft.macrodroid.firebase;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class FirestoreHelper_Factory implements Factory<FirestoreHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12145a;

    public FirestoreHelper_Factory(Provider<Context> provider) {
        this.f12145a = provider;
    }

    public static FirestoreHelper_Factory create(Provider<Context> provider) {
        return new FirestoreHelper_Factory(provider);
    }

    public static FirestoreHelper newFirestoreHelper(Context context) {
        return new FirestoreHelper(context);
    }

    public static FirestoreHelper provideInstance(Provider<Context> provider) {
        return new FirestoreHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public FirestoreHelper get() {
        return provideInstance(this.f12145a);
    }
}
