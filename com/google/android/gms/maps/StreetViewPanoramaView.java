package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class StreetViewPanoramaView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final zzb f21255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class zza implements StreetViewLifecycleDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f21256a;

        /* renamed from: b  reason: collision with root package name */
        private final IStreetViewPanoramaViewDelegate f21257b;

        /* renamed from: c  reason: collision with root package name */
        private View f21258c;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.f21257b = (IStreetViewPanoramaViewDelegate) Preconditions.checkNotNull(iStreetViewPanoramaViewDelegate);
            this.f21256a = (ViewGroup) Preconditions.checkNotNull(viewGroup);
        }

        @Override // com.google.android.gms.maps.internal.StreetViewLifecycleDelegate
        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.f21257b.getStreetViewPanoramaAsync(new zzaj(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21257b.onCreate(bundle2);
                zzby.zza(bundle2, bundle);
                this.f21258c = (View) ObjectWrapper.unwrap(this.f21257b.getView());
                this.f21256a.removeAllViews();
                this.f21256a.addView(this.f21258c);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroy() {
            try {
                this.f21257b.onDestroy();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onLowMemory() {
            try {
                this.f21257b.onLowMemory();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onPause() {
            try {
                this.f21257b.onPause();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onResume() {
            try {
                this.f21257b.onResume();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21257b.onSaveInstanceState(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStart() {
            try {
                this.f21257b.onStart();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStop() {
            try {
                this.f21257b.onStop();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    static class zzb extends DeferredLifecycleHelper<zza> {

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f21259e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f21260f;

        /* renamed from: g  reason: collision with root package name */
        private OnDelegateCreatedListener<zza> f21261g;

        /* renamed from: h  reason: collision with root package name */
        private final StreetViewPanoramaOptions f21262h;

        /* renamed from: i  reason: collision with root package name */
        private final List<OnStreetViewPanoramaReadyCallback> f21263i = new ArrayList();

        @VisibleForTesting
        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f21259e = viewGroup;
            this.f21260f = context;
            this.f21262h = streetViewPanoramaOptions;
        }

        @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
        protected final void a(OnDelegateCreatedListener<zza> onDelegateCreatedListener) {
            this.f21261g = onDelegateCreatedListener;
            if (onDelegateCreatedListener != null && getDelegate() == null) {
                try {
                    MapsInitializer.initialize(this.f21260f);
                    this.f21261g.onDelegateCreated(new zza(this.f21259e, zzbz.zza(this.f21260f).zza(ObjectWrapper.wrap(this.f21260f), this.f21262h)));
                    for (OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback : this.f21263i) {
                        getDelegate().getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
                    }
                    this.f21263i.clear();
                } catch (RemoteException e4) {
                    throw new RuntimeRemoteException(e4);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        public final void i(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (getDelegate() != null) {
                getDelegate().getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.f21263i.add(onStreetViewPanoramaReadyCallback);
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.f21255a = new zzb(this, context, null);
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f21255a.i(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f21255a.onCreate(bundle);
            if (this.f21255a.getDelegate() == null) {
                DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onDestroy() {
        this.f21255a.onDestroy();
    }

    public final void onLowMemory() {
        this.f21255a.onLowMemory();
    }

    public final void onPause() {
        this.f21255a.onPause();
    }

    public void onResume() {
        this.f21255a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f21255a.onSaveInstanceState(bundle);
    }

    public void onStart() {
        this.f21255a.onStart();
    }

    public void onStop() {
        this.f21255a.onStop();
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21255a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f21255a = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.f21255a = new zzb(this, context, streetViewPanoramaOptions);
    }
}
