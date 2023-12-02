package com.google.firebase.firestore.core;

import android.app.Activity;
import android.app.Fragment;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class ActivityScope {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CallbackList {

        /* renamed from: a  reason: collision with root package name */
        private final List<Runnable> f30301a;

        private CallbackList() {
            this.f30301a = new ArrayList();
        }

        synchronized void a(Runnable runnable) {
            this.f30301a.add(runnable);
        }

        void b() {
            for (Runnable runnable : this.f30301a) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class StopListenerFragment extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        CallbackList f30302a = new CallbackList();

        @Override // android.app.Fragment
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.f30302a) {
                callbackList = this.f30302a;
                this.f30302a = new CallbackList();
            }
            callbackList.b();
        }
    }

    /* loaded from: classes5.dex */
    public static class StopListenerSupportFragment extends androidx.fragment.app.Fragment {

        /* renamed from: b  reason: collision with root package name */
        CallbackList f30303b = new CallbackList();

        @Override // androidx.fragment.app.Fragment
        public void onStop() {
            CallbackList callbackList;
            super.onStop();
            synchronized (this.f30303b) {
                callbackList = this.f30303b;
                this.f30303b = new CallbackList();
            }
            callbackList.b();
        }
    }

    public static ListenerRegistration bind(@Nullable Activity activity, final ListenerRegistration listenerRegistration) {
        if (activity != null) {
            if (activity instanceof FragmentActivity) {
                Objects.requireNonNull(listenerRegistration);
                g((FragmentActivity) activity, new Runnable() { // from class: com.google.firebase.firestore.core.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ListenerRegistration.this.remove();
                    }
                });
            } else {
                Objects.requireNonNull(listenerRegistration);
                f(activity, new Runnable() { // from class: com.google.firebase.firestore.core.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ListenerRegistration.this.remove();
                    }
                });
            }
        }
        return listenerRegistration;
    }

    @Nullable
    private static <T> T c(Class<T> cls, @Nullable Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Fragment with tag '" + str + "' is a " + obj.getClass().getName() + " but should be a " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Activity activity, Runnable runnable) {
        StopListenerFragment stopListenerFragment = (StopListenerFragment) c(StopListenerFragment.class, activity.getFragmentManager().findFragmentByTag("FirestoreOnStopObserverFragment"), "FirestoreOnStopObserverFragment");
        if (stopListenerFragment == null || stopListenerFragment.isRemoving()) {
            stopListenerFragment = new StopListenerFragment();
            activity.getFragmentManager().beginTransaction().add(stopListenerFragment, "FirestoreOnStopObserverFragment").commitAllowingStateLoss();
            activity.getFragmentManager().executePendingTransactions();
        }
        stopListenerFragment.f30302a.a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(FragmentActivity fragmentActivity, Runnable runnable) {
        StopListenerSupportFragment stopListenerSupportFragment = (StopListenerSupportFragment) c(StopListenerSupportFragment.class, fragmentActivity.getSupportFragmentManager().findFragmentByTag("FirestoreOnStopObserverSupportFragment"), "FirestoreOnStopObserverSupportFragment");
        if (stopListenerSupportFragment == null || stopListenerSupportFragment.isRemoving()) {
            stopListenerSupportFragment = new StopListenerSupportFragment();
            fragmentActivity.getSupportFragmentManager().beginTransaction().add(stopListenerSupportFragment, "FirestoreOnStopObserverSupportFragment").commitAllowingStateLoss();
            fragmentActivity.getSupportFragmentManager().executePendingTransactions();
        }
        stopListenerSupportFragment.f30303b.a(runnable);
    }

    private static void f(final Activity activity, final Runnable runnable) {
        Assert.hardAssert(!(activity instanceof FragmentActivity), "onActivityStopCallOnce must be called with a *non*-FragmentActivity Activity.", new Object[0]);
        activity.runOnUiThread(new Runnable() { // from class: com.google.firebase.firestore.core.b
            @Override // java.lang.Runnable
            public final void run() {
                ActivityScope.d(activity, runnable);
            }
        });
    }

    private static void g(final FragmentActivity fragmentActivity, final Runnable runnable) {
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.google.firebase.firestore.core.c
            @Override // java.lang.Runnable
            public final void run() {
                ActivityScope.e(FragmentActivity.this, runnable);
            }
        });
    }
}
