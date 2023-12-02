package com.arlosoft.macrodroid.autobackup.ui.cloud;

import android.content.Context;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.firebase.FirestoreHelper;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AutoBackupCloudViewModel_Factory implements Factory<AutoBackupCloudViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f9370a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SignInHelper> f9371b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f9372c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FirestoreHelper> f9373d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f9374e;

    public AutoBackupCloudViewModel_Factory(Provider<Context> provider, Provider<SignInHelper> provider2, Provider<UserProvider> provider3, Provider<FirestoreHelper> provider4, Provider<PremiumStatusHandler> provider5) {
        this.f9370a = provider;
        this.f9371b = provider2;
        this.f9372c = provider3;
        this.f9373d = provider4;
        this.f9374e = provider5;
    }

    public static AutoBackupCloudViewModel_Factory create(Provider<Context> provider, Provider<SignInHelper> provider2, Provider<UserProvider> provider3, Provider<FirestoreHelper> provider4, Provider<PremiumStatusHandler> provider5) {
        return new AutoBackupCloudViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoBackupCloudViewModel newAutoBackupCloudViewModel(Context context, SignInHelper signInHelper, UserProvider userProvider, FirestoreHelper firestoreHelper, PremiumStatusHandler premiumStatusHandler) {
        return new AutoBackupCloudViewModel(context, signInHelper, userProvider, firestoreHelper, premiumStatusHandler);
    }

    public static AutoBackupCloudViewModel provideInstance(Provider<Context> provider, Provider<SignInHelper> provider2, Provider<UserProvider> provider3, Provider<FirestoreHelper> provider4, Provider<PremiumStatusHandler> provider5) {
        return new AutoBackupCloudViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public AutoBackupCloudViewModel get() {
        return provideInstance(this.f9370a, this.f9371b, this.f9372c, this.f9373d, this.f9374e);
    }
}
