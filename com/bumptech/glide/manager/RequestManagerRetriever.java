package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: i  reason: collision with root package name */
    private static final RequestManagerFactory f17353i = new a();

    /* renamed from: a  reason: collision with root package name */
    private volatile RequestManager f17354a;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f17357d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestManagerFactory f17358e;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f17355b = new HashMap();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f17356c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayMap<View, Fragment> f17359f = new ArrayMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f17360g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f17361h = new Bundle();

    /* loaded from: classes3.dex */
    public interface RequestManagerFactory {
        @NonNull
        RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    /* loaded from: classes3.dex */
    class a implements RequestManagerFactory {
        a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory
        @NonNull
        public RequestManager build(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        this.f17358e = requestManagerFactory == null ? f17353i : requestManagerFactory;
        this.f17357d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (!activity.isDestroyed()) {
            return;
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @Nullable
    private Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        List<android.app.Fragment> fragments;
        if (Build.VERSION.SDK_INT >= 26) {
            fragments = fragmentManager.getFragments();
            for (android.app.Fragment fragment : fragments) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    c(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        d(fragmentManager, arrayMap);
    }

    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            this.f17361h.putInt("key", i4);
            try {
                fragment = fragmentManager.getFragment(this.f17361h, "key");
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), arrayMap);
            }
            i4 = i5;
        }
    }

    private static void e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                e(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment f(@NonNull View view, @NonNull Activity activity) {
        this.f17360g.clear();
        c(activity.getFragmentManager(), this.f17360g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f17360g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f17360g.clear();
        return fragment;
    }

    @Nullable
    private Fragment g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f17359f.clear();
        e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f17359f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f17359f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f17359f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private RequestManager h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z3) {
        RequestManagerFragment k4 = k(fragmentManager, fragment, z3);
        RequestManager requestManager = k4.getRequestManager();
        if (requestManager == null) {
            RequestManager build = this.f17358e.build(Glide.get(context), k4.c(), k4.getRequestManagerTreeNode(), context);
            k4.setRequestManager(build);
            return build;
        }
        return requestManager;
    }

    @NonNull
    private RequestManager i(@NonNull Context context) {
        if (this.f17354a == null) {
            synchronized (this) {
                if (this.f17354a == null) {
                    this.f17354a = this.f17358e.build(Glide.get(context.getApplicationContext()), new b(), new d(), context.getApplicationContext());
                }
            }
        }
        return this.f17354a;
    }

    @NonNull
    private RequestManagerFragment k(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z3) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f17355b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.h(fragment);
            if (z3) {
                requestManagerFragment.c().b();
            }
            this.f17355b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f17357d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    private SupportRequestManagerFragment m(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z3) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f17356c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.i(fragment);
            if (z3) {
                supportRequestManagerFragment.d().b();
            }
            this.f17356c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f17357d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private static boolean n(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    private RequestManager o(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z3) {
        SupportRequestManagerFragment m4 = m(fragmentManager, fragment, z3);
        RequestManager requestManager = m4.getRequestManager();
        if (requestManager == null) {
            RequestManager build = this.f17358e.build(Glide.get(context), m4.d(), m4.getRequestManagerTreeNode(), context);
            m4.setRequestManager(build);
            return build;
        }
        return requestManager;
    }

    @NonNull
    public RequestManager get(@NonNull Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return get(((ContextWrapper) context).getBaseContext());
                }
            }
            return i(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks remove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i4 = message.what;
        boolean z3 = true;
        if (i4 != 1) {
            if (i4 != 2) {
                componentCallbacks = null;
                z3 = false;
                obj2 = null;
                if (z3 && componentCallbacks == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z3;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f17356c.remove(obj);
        } else {
            obj = (FragmentManager) message.obj;
            remove = this.f17355b.remove(obj);
        }
        ComponentCallbacks componentCallbacks2 = remove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z3) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public RequestManagerFragment j(Activity activity) {
        return k(activity.getFragmentManager(), null, n(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment l(FragmentActivity fragmentActivity) {
        return m(fragmentActivity.getSupportFragmentManager(), null, n(fragmentActivity));
    }

    @NonNull
    public RequestManager get(@NonNull FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return o(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, n(fragmentActivity));
    }

    @NonNull
    public RequestManager get(@NonNull Fragment fragment) {
        Preconditions.checkNotNull(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.isOnBackgroundThread()) {
            return get(fragment.getActivity().getApplicationContext());
        }
        return o(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public RequestManager get(@NonNull Activity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), null, n(activity));
    }

    @NonNull
    public RequestManager get(@NonNull View view) {
        if (Util.isOnBackgroundThread()) {
            return get(view.getContext().getApplicationContext());
        }
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity b4 = b(view.getContext());
        if (b4 == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (b4 instanceof FragmentActivity) {
            Fragment g4 = g(view, (FragmentActivity) b4);
            return g4 != null ? get(g4) : get(b4);
        }
        android.app.Fragment f4 = f(view, b4);
        if (f4 == null) {
            return get(b4);
        }
        return get(f4);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public RequestManager get(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.isOnBackgroundThread()) {
                return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
