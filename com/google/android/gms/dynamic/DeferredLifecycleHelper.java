package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private LifecycleDelegate f20807a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Bundle f20808b;

    /* renamed from: c  reason: collision with root package name */
    private LinkedList f20809c;

    /* renamed from: d  reason: collision with root package name */
    private final OnDelegateCreatedListener f20810d = new zaa(this);

    private final void g(int i4) {
        while (!this.f20809c.isEmpty() && ((zah) this.f20809c.getLast()).zaa() >= i4) {
            this.f20809c.removeLast();
        }
    }

    private final void h(@Nullable Bundle bundle, zah zahVar) {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            zahVar.a(lifecycleDelegate);
            return;
        }
        if (this.f20809c == null) {
            this.f20809c = new LinkedList();
        }
        this.f20809c.add(zahVar);
        if (bundle != null) {
            Bundle bundle2 = this.f20808b;
            if (bundle2 == null) {
                this.f20808b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f20810d);
    }

    @KeepForSdk
    public static void showGooglePlayUnavailableMessage(@NonNull FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        String zad = com.google.android.gms.common.internal.zac.zad(context, isGooglePlayServicesAvailable);
        String zac = com.google.android.gms.common.internal.zac.zac(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zad);
        linearLayout.addView(textView);
        Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, null);
        if (errorResolutionIntent != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zac);
            linearLayout.addView(button);
            button.setOnClickListener(new zae(context, errorResolutionIntent));
        }
    }

    @KeepForSdk
    protected abstract void a(@NonNull OnDelegateCreatedListener<T> onDelegateCreatedListener);

    @KeepForSdk
    protected void b(@NonNull FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    @NonNull
    @KeepForSdk
    public T getDelegate() {
        return (T) this.f20807a;
    }

    @KeepForSdk
    public void onCreate(@Nullable Bundle bundle) {
        h(bundle, new zac(this, bundle));
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        h(bundle, new zad(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f20807a == null) {
            b(frameLayout);
        }
        return frameLayout;
    }

    @KeepForSdk
    public void onDestroy() {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroy();
        } else {
            g(1);
        }
    }

    @KeepForSdk
    public void onDestroyView() {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onDestroyView();
        } else {
            g(2);
        }
    }

    @KeepForSdk
    public void onInflate(@NonNull Activity activity, @NonNull Bundle bundle, @Nullable Bundle bundle2) {
        h(bundle2, new zab(this, activity, bundle, bundle2));
    }

    @KeepForSdk
    public void onLowMemory() {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onLowMemory();
        }
    }

    @KeepForSdk
    public void onPause() {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onPause();
        } else {
            g(5);
        }
    }

    @KeepForSdk
    public void onResume() {
        h(null, new zag(this));
    }

    @KeepForSdk
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f20808b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    @KeepForSdk
    public void onStart() {
        h(null, new zaf(this));
    }

    @KeepForSdk
    public void onStop() {
        LifecycleDelegate lifecycleDelegate = this.f20807a;
        if (lifecycleDelegate != null) {
            lifecycleDelegate.onStop();
        } else {
            g(4);
        }
    }
}
