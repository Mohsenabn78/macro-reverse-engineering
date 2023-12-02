package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class LocalVarsHeadingViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalVarsHeadingViewHolder f11820a;

    @UiThread
    public LocalVarsHeadingViewHolder_ViewBinding(LocalVarsHeadingViewHolder localVarsHeadingViewHolder, View view) {
        this.f11820a = localVarsHeadingViewHolder;
        localVarsHeadingViewHolder.addVariableButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.addVariableButton, "field 'addVariableButton'", ImageButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LocalVarsHeadingViewHolder localVarsHeadingViewHolder = this.f11820a;
        if (localVarsHeadingViewHolder != null) {
            this.f11820a = null;
            localVarsHeadingViewHolder.addVariableButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
