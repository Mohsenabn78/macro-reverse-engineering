package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TriggerHeadingViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private TriggerHeadingViewHolder f11871a;

    @UiThread
    public TriggerHeadingViewHolder_ViewBinding(TriggerHeadingViewHolder triggerHeadingViewHolder, View view) {
        this.f11871a = triggerHeadingViewHolder;
        triggerHeadingViewHolder.pasteTriggerButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.pasteTriggerButton, "field 'pasteTriggerButton'", ImageButton.class);
        triggerHeadingViewHolder.reorderTriggersButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.reorderTriggersButton, "field 'reorderTriggersButton'", ImageButton.class);
        triggerHeadingViewHolder.addTriggerButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.edit_macro_addTriggerButton, "field 'addTriggerButton'", ImageButton.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TriggerHeadingViewHolder triggerHeadingViewHolder = this.f11871a;
        if (triggerHeadingViewHolder != null) {
            this.f11871a = null;
            triggerHeadingViewHolder.pasteTriggerButton = null;
            triggerHeadingViewHolder.reorderTriggersButton = null;
            triggerHeadingViewHolder.addTriggerButton = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
