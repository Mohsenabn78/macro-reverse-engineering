package com.arlosoft.macrodroid.app.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppCompatDaggerBaseActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class AppCompatDaggerBaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    public static final int $stable = 8;
    @Inject
    public DispatchingAndroidInjector<Fragment> dispatchingFragmentAndroidInjector;

    @NotNull
    public final DispatchingAndroidInjector<Fragment> getDispatchingFragmentAndroidInjector() {
        DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector = this.dispatchingFragmentAndroidInjector;
        if (dispatchingAndroidInjector != null) {
            return dispatchingAndroidInjector;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dispatchingFragmentAndroidInjector");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject(this);
        super.onCreate(bundle);
    }

    public final void setDispatchingFragmentAndroidInjector(@NotNull DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        Intrinsics.checkNotNullParameter(dispatchingAndroidInjector, "<set-?>");
        this.dispatchingFragmentAndroidInjector = dispatchingAndroidInjector;
    }

    @Override // dagger.android.support.HasSupportFragmentInjector
    @NotNull
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return getDispatchingFragmentAndroidInjector();
    }
}
