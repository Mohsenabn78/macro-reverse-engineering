package com.arlosoft.macrodroid.wizard;

import android.view.View;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WizardFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private WizardFragment f16545a;

    @UiThread
    public WizardFragment_ViewBinding(WizardFragment wizardFragment, View view) {
        this.f16545a = wizardFragment;
        wizardFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WizardFragment wizardFragment = this.f16545a;
        if (wizardFragment != null) {
            this.f16545a = null;
            wizardFragment.recyclerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
