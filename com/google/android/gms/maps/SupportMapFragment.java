package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.internal.zzbz;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class SupportMapFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private final zzb f21264b = new zzb(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public static class zza implements MapLifecycleDelegate {

        /* renamed from: a  reason: collision with root package name */
        private final Fragment f21265a;

        /* renamed from: b  reason: collision with root package name */
        private final IMapFragmentDelegate f21266b;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.f21266b = (IMapFragmentDelegate) Preconditions.checkNotNull(iMapFragmentDelegate);
            this.f21265a = (Fragment) Preconditions.checkNotNull(fragment);
        }

        public final void a(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21266b.onEnterAmbient(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        public final void b() {
            try {
                this.f21266b.onExitAmbient();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.maps.internal.MapLifecycleDelegate
        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.f21266b.getMapAsync(new zzak(this, onMapReadyCallback));
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                Bundle arguments = this.f21265a.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    zzby.zza(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.f21266b.onCreate(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                IObjectWrapper onCreateView = this.f21266b.onCreateView(ObjectWrapper.wrap(layoutInflater), ObjectWrapper.wrap(viewGroup), bundle2);
                zzby.zza(bundle2, bundle);
                return (View) ObjectWrapper.unwrap(onCreateView);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroy() {
            try {
                this.f21266b.onDestroy();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onDestroyView() {
            try {
                this.f21266b.onDestroyView();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                zzby.zza(bundle2, bundle3);
                this.f21266b.onInflate(ObjectWrapper.wrap(activity), googleMapOptions, bundle3);
                zzby.zza(bundle3, bundle2);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onLowMemory() {
            try {
                this.f21266b.onLowMemory();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onPause() {
            try {
                this.f21266b.onPause();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onResume() {
            try {
                this.f21266b.onResume();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zza(bundle, bundle2);
                this.f21266b.onSaveInstanceState(bundle2);
                zzby.zza(bundle2, bundle);
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStart() {
            try {
                this.f21266b.onStart();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }

        @Override // com.google.android.gms.dynamic.LifecycleDelegate
        public final void onStop() {
            try {
                this.f21266b.onStop();
            } catch (RemoteException e4) {
                throw new RuntimeRemoteException(e4);
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes4.dex */
    static class zzb extends DeferredLifecycleHelper<zza> {

        /* renamed from: e  reason: collision with root package name */
        private final Fragment f21267e;

        /* renamed from: f  reason: collision with root package name */
        private OnDelegateCreatedListener<zza> f21268f;

        /* renamed from: g  reason: collision with root package name */
        private Activity f21269g;

        /* renamed from: h  reason: collision with root package name */
        private final List<OnMapReadyCallback> f21270h = new ArrayList();

        @VisibleForTesting
        zzb(Fragment fragment) {
            this.f21267e = fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(Activity activity) {
            this.f21269g = activity;
            l();
        }

        private final void l() {
            if (this.f21269g != null && this.f21268f != null && getDelegate() == null) {
                try {
                    MapsInitializer.initialize(this.f21269g);
                    IMapFragmentDelegate zzc = zzbz.zza(this.f21269g).zzc(ObjectWrapper.wrap(this.f21269g));
                    if (zzc == null) {
                        return;
                    }
                    this.f21268f.onDelegateCreated(new zza(this.f21267e, zzc));
                    for (OnMapReadyCallback onMapReadyCallback : this.f21270h) {
                        getDelegate().getMapAsync(onMapReadyCallback);
                    }
                    this.f21270h.clear();
                } catch (RemoteException e4) {
                    throw new RuntimeRemoteException(e4);
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            }
        }

        @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
        protected final void a(OnDelegateCreatedListener<zza> onDelegateCreatedListener) {
            this.f21268f = onDelegateCreatedListener;
            l();
        }

        public final void i(OnMapReadyCallback onMapReadyCallback) {
            if (getDelegate() != null) {
                getDelegate().getMapAsync(onMapReadyCallback);
            } else {
                this.f21270h.add(onMapReadyCallback);
            }
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        Preconditions.checkMainThread("getMapAsync must be called on the main thread.");
        this.f21264b.i(onMapReadyCallback);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f21264b.j(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21264b.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.f21264b.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f21264b.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f21264b.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        Preconditions.checkMainThread("onEnterAmbient must be called on the main thread.");
        zzb zzbVar = this.f21264b;
        if (zzbVar.getDelegate() != null) {
            zzbVar.getDelegate().a(bundle);
        }
    }

    public final void onExitAmbient() {
        Preconditions.checkMainThread("onExitAmbient must be called on the main thread.");
        zzb zzbVar = this.f21264b;
        if (zzbVar.getDelegate() != null) {
            zzbVar.getDelegate().b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.f21264b.j(activity);
            GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", createFromAttributes);
            this.f21264b.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f21264b.onLowMemory();
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f21264b.onPause();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f21264b.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.f21264b.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f21264b.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f21264b.onStop();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    public static SupportMapFragment newInstance(GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }
}
