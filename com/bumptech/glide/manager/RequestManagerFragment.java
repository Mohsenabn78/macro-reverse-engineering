package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes3.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.manager.a f17346a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestManagerTreeNode f17347b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<RequestManagerFragment> f17348c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private RequestManager f17349d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private RequestManagerFragment f17350e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Fragment f17351f;

    /* loaded from: classes3.dex */
    private class a implements RequestManagerTreeNode {
        a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> b4 = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(b4.size());
            for (RequestManagerFragment requestManagerFragment : b4) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f17348c.add(requestManagerFragment);
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.f17351f;
        }
        return parentFragment;
    }

    @TargetApi(17)
    private boolean e(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 != null) {
                if (parentFragment2.equals(parentFragment)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void f(@NonNull Activity activity) {
        i();
        RequestManagerFragment j4 = Glide.get(activity).getRequestManagerRetriever().j(activity);
        this.f17350e = j4;
        if (!equals(j4)) {
            this.f17350e.a(this);
        }
    }

    private void g(RequestManagerFragment requestManagerFragment) {
        this.f17348c.remove(requestManagerFragment);
    }

    private void i() {
        RequestManagerFragment requestManagerFragment = this.f17350e;
        if (requestManagerFragment != null) {
            requestManagerFragment.g(this);
            this.f17350e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<RequestManagerFragment> b() {
        if (equals(this.f17350e)) {
            return Collections.unmodifiableSet(this.f17348c);
        }
        if (this.f17350e != null) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f17350e.b()) {
                if (e(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a c() {
        return this.f17346a;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f17349d;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f17347b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(@Nullable Fragment fragment) {
        this.f17351f = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            f(fragment.getActivity());
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            f(activity);
        } catch (IllegalStateException e4) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e4);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f17346a.a();
        i();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        i();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f17346a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f17346a.c();
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f17349d = requestManager;
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    RequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f17347b = new a();
        this.f17348c = new HashSet();
        this.f17346a = aVar;
    }
}
