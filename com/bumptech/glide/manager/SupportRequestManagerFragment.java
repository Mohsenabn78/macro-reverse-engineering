package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.manager.a f17365b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManagerTreeNode f17366c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f17367d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private SupportRequestManagerFragment f17368e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RequestManager f17369f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Fragment f17370g;

    /* loaded from: classes3.dex */
    private class a implements RequestManagerTreeNode {
        a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> c4 = SupportRequestManagerFragment.this.c();
            HashSet hashSet = new HashSet(c4.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : c4) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f17367d.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            return this.f17370g;
        }
        return parentFragment;
    }

    private boolean f(@NonNull Fragment fragment) {
        Fragment e4 = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment.equals(e4)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void g(@NonNull FragmentActivity fragmentActivity) {
        j();
        SupportRequestManagerFragment l4 = Glide.get(fragmentActivity).getRequestManagerRetriever().l(fragmentActivity);
        this.f17368e = l4;
        if (!equals(l4)) {
            this.f17368e.b(this);
        }
    }

    private void h(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f17367d.remove(supportRequestManagerFragment);
    }

    private void j() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17368e;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.h(this);
            this.f17368e = null;
        }
    }

    @NonNull
    Set<SupportRequestManagerFragment> c() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17368e;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f17367d);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f17368e.c()) {
            if (f(supportRequestManagerFragment2.e())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a d() {
        return this.f17365b;
    }

    @Nullable
    public RequestManager getRequestManager() {
        return this.f17369f;
    }

    @NonNull
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.f17366c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(@Nullable Fragment fragment) {
        this.f17370g = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            g(fragment.getActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            g(getActivity());
        } catch (IllegalStateException e4) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e4);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f17365b.a();
        j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17370g = null;
        j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f17365b.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f17365b.c();
    }

    public void setRequestManager(@Nullable RequestManager requestManager) {
        this.f17369f = requestManager;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f17366c = new a();
        this.f17367d = new HashSet();
        this.f17365b = aVar;
    }
}
