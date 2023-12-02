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
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final zzb f21226a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class zza implements MapLifecycleDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f21227a;

        /* renamed from: b  reason: collision with root package name */
        private final IMapViewDelegate f21228b;

        /* renamed from: c  reason: collision with root package name */
        private View f21229c;

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.f21228b = (IMapViewDelegate) Preconditions.checkNotNull(iMapViewDelegate);
            this.f21227a = (ViewGroup) Preconditions.checkNotNull(viewGroup);
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21228b.onEnterAmbient(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        public final void b() {
            try {
                this.f21228b.onExitAmbient();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.maps.internal.MapLifecycleDelegate
        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f21228b.getMapAsync(new zzac(this, onMapReadyCallback));
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21228b.onCreate(bundle2);
                zzby.zza(bundle2, bundle);
                this.f21229c = (View) ObjectWrapper.unwrap(this.f21228b.getView());
                this.f21227a.removeAllViews();
                this.f21227a.addView(this.f21229c);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroy() {
            try {
                this.f21228b.onDestroy();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onLowMemory() {
            try {
                this.f21228b.onLowMemory();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onPause() {
            try {
                this.f21228b.onPause();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onResume() {
            try {
                this.f21228b.onResume();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21228b.onSaveInstanceState(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStart() {
            try {
                this.f21228b.onStart();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStop() {
            try {
                this.f21228b.onStop();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    static class zzb extends DeferredLifecycleHelper<zza> {

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f21230e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f21231f;

        /* renamed from: g  reason: collision with root package name */
        private OnDelegateCreatedListener<zza> f21232g;

        /* renamed from: h  reason: collision with root package name */
        private final GoogleMapOptions f21233h;

        /* renamed from: i  reason: collision with root package name */
        private final List<OnMapReadyCallback> f21234i = new ArrayList();

        @VisibleForTesting
        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f21230e = viewGroup;
            this.f21231f = context;
            this.f21233h = googleMapOptions;
        }

        @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
        protected final void a(OnDelegateCreatedListener<zza> onDelegateCreatedListener) {
            this.f21232g = onDelegateCreatedListener;
            if (onDelegateCreatedListener != null && getDelegate() == null) {
                try {
                    MapsInitializer.initialize(this.f21231f);
                    IMapViewDelegate zza = zzbz.zza(this.f21231f).zza(ObjectWrapper.wrap(this.f21231f), this.f21233h);
                    if (zza == null) {
                        return;
                    }
                    this.f21232g.onDelegateCreated(new zza(this.f21230e, zza));
                    for (OnMapReadyCallback onMapReadyCallback : this.f21234i) {
                        getDelegate().getMapAsync(onMapReadyCallback);
                    }
                    this.f21234i.clear();
                } catch (RemoteException e4) {
                    throw new RuntimeRemoteException(e4);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        public final void i(OnMapReadyCallback onMapReadyCallback) {
            if (getDelegate() != null) {
                getDelegate().getMapAsync(onMapReadyCallback);
            } else {
                this.f21234i.add(onMapReadyCallback);
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f21226a = new zzb(this, context, null);
        setClickable(true);
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        Preconditions.checkMainThread("getMapAsync() must be called on the main thread");
        this.f21226a.i(onMapReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f21226a.onCreate(bundle);
            if (this.f21226a.getDelegate() == null) {
                DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void onDestroy() {
        this.f21226a.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle) {
        Preconditions.checkMainThread("onEnterAmbient() must be called on the main thread");
        zzb zzbVar = this.f21226a;
        if (zzbVar.getDelegate() != null) {
            zzbVar.getDelegate().a(bundle);
        }
    }

    public final void onExitAmbient() {
        Preconditions.checkMainThread("onExitAmbient() must be called on the main thread");
        zzb zzbVar = this.f21226a;
        if (zzbVar.getDelegate() != null) {
            zzbVar.getDelegate().b();
        }
    }

    public final void onLowMemory() {
        this.f21226a.onLowMemory();
    }

    public final void onPause() {
        this.f21226a.onPause();
    }

    public final void onResume() {
        this.f21226a.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.f21226a.onSaveInstanceState(bundle);
    }

    public final void onStart() {
        this.f21226a.onStart();
    }

    public final void onStop() {
        this.f21226a.onStop();
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21226a = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f21226a = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f21226a = new zzb(this, context, googleMapOptions);
        setClickable(true);
    }
}
