package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConstraintHeadingViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ConstraintHeadingViewHolder f11734a;

    @UiThread
    public ConstraintHeadingViewHolder_ViewBinding(ConstraintHeadingViewHolder constraintHeadingViewHolder, View view) {
        this.f11734a = constraintHeadingViewHolder;
        constraintHeadingViewHolder.pasteConstraintButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.pasteConstraintButton, "field 'pasteConstraintButton'", ImageButton.class);
        constraintHeadingViewHolder.reorderConstraintsButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.reorderConstraintsButton, "field 'reorderConstraintsButton'", ImageButton.class);
        constraintHeadingViewHolder.addConstraintButton = (ImageButton) Utils.findRequiredViewAsType(view, R.id.edit_macro_addConstraintButton, "field 'addConstraintButton'", ImageButton.class);
        constraintHeadingViewHolder.constraintAndOrSpinner = (Spinner) Utils.findRequiredViewAsType(view, R.id.constraintAndOrSpinner, "field 'constraintAndOrSpinner'", Spinner.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ConstraintHeadingViewHolder constraintHeadingViewHolder = this.f11734a;
        if (constraintHeadingViewHolder != null) {
            this.f11734a = null;
            constraintHeadingViewHolder.pasteConstraintButton = null;
            constraintHeadingViewHolder.reorderConstraintsButton = null;
            constraintHeadingViewHolder.addConstraintButton = null;
            constraintHeadingViewHolder.constraintAndOrSpinner = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
