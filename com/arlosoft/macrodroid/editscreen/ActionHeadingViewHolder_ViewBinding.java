package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActionHeadingViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ActionHeadingViewHolder f11680a;

    @UiThread
    public ActionHeadingViewHolder_ViewBinding(ActionHeadingViewHolder actionHeadingViewHolder, View view) {
        this.f11680a = actionHeadingViewHolder;
        actionHeadingViewHolder.pasteActionButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.pasteActionButton, "field 'pasteActionButton'", ImageButton.class);
        actionHeadingViewHolder.reorderActionsButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.reorderActionsButton, "field 'reorderActionsButton'", ImageButton.class);
        actionHeadingViewHolder.addActionButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.edit_macro_addActionButton, "field 'addActionButton'", ImageButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ActionHeadingViewHolder actionHeadingViewHolder = this.f11680a;
        if (actionHeadingViewHolder != null) {
            this.f11680a = null;
            actionHeadingViewHolder.pasteActionButton = null;
            actionHeadingViewHolder.reorderActionsButton = null;
            actionHeadingViewHolder.addActionButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
