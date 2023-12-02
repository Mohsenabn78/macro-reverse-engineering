package com.firebase.ui.auth.viewmodel;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.lifecycle.Observer;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.R;
import com.firebase.ui.auth.data.model.Resource;
import com.firebase.ui.auth.data.model.State;
import com.firebase.ui.auth.ui.FragmentBase;
import com.firebase.ui.auth.ui.HelperActivityBase;
import com.firebase.ui.auth.ui.ProgressView;
import com.firebase.ui.auth.util.ui.FlowUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public abstract class ResourceObserver<T> implements Observer<Resource<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final ProgressView f18250a;

    /* renamed from: b  reason: collision with root package name */
    private final HelperActivityBase f18251b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentBase f18252c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18253d;

    /* JADX INFO: Access modifiers changed from: protected */
    public ResourceObserver(@NonNull HelperActivityBase helperActivityBase) {
        this(helperActivityBase, null, helperActivityBase, R.string.fui_progress_dialog_loading);
    }

    protected abstract void a(@NonNull Exception exc);

    protected abstract void b(@NonNull T t3);

    @Override // androidx.lifecycle.Observer
    public /* bridge */ /* synthetic */ void onChanged(Object obj) {
        onChanged((Resource) ((Resource) obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResourceObserver(@NonNull HelperActivityBase helperActivityBase, @StringRes int i4) {
        this(helperActivityBase, null, helperActivityBase, i4);
    }

    public final void onChanged(Resource<T> resource) {
        boolean unhandled;
        if (resource.getState() == State.LOADING) {
            this.f18250a.showProgress(this.f18253d);
            return;
        }
        this.f18250a.hideProgress();
        if (resource.isUsed()) {
            return;
        }
        if (resource.getState() == State.SUCCESS) {
            b(resource.getValue());
        } else if (resource.getState() == State.FAILURE) {
            Exception exception = resource.getException();
            FragmentBase fragmentBase = this.f18252c;
            if (fragmentBase == null) {
                unhandled = FlowUtils.unhandled(this.f18251b, exception);
            } else {
                unhandled = FlowUtils.unhandled(fragmentBase, exception);
            }
            if (unhandled) {
                Log.e(AuthUI.TAG, "A sign-in error occurred.", exception);
                a(exception);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResourceObserver(@NonNull FragmentBase fragmentBase) {
        this(null, fragmentBase, fragmentBase, R.string.fui_progress_dialog_loading);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResourceObserver(@NonNull FragmentBase fragmentBase, @StringRes int i4) {
        this(null, fragmentBase, fragmentBase, i4);
    }

    private ResourceObserver(HelperActivityBase helperActivityBase, FragmentBase fragmentBase, ProgressView progressView, int i4) {
        this.f18251b = helperActivityBase;
        this.f18252c = fragmentBase;
        if (helperActivityBase == null && fragmentBase == null) {
            throw new IllegalStateException("ResourceObserver must be attached to an Activity or a Fragment");
        }
        this.f18250a = progressView;
        this.f18253d = i4;
    }
}
