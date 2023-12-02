package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class EmptyItemsViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private EmptyItemsViewHolder f11801a;

    @UiThread
    public EmptyItemsViewHolder_ViewBinding(EmptyItemsViewHolder emptyItemsViewHolder, View view) {
        this.f11801a = emptyItemsViewHolder;
        emptyItemsViewHolder.topLevelContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.topLevelContainer, "field 'topLevelContainer'", ViewGroup.class);
        emptyItemsViewHolder.topLevelExtrasContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.topLevelExtrasContainer, "field 'topLevelExtrasContainer'", ViewGroup.class);
        emptyItemsViewHolder.constraintContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.constraintContainer, "field 'constraintContainer'", ViewGroup.class);
        emptyItemsViewHolder.constraintLinkUnderAction = Utils.findRequiredView(view, R.id.constraintLinkUnderAction, "field 'constraintLinkUnderAction'");
        emptyItemsViewHolder.dragHandle = Utils.findRequiredView(view, R.id.dragHandle, "field 'dragHandle'");
        emptyItemsViewHolder.collapseExpandButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.collapse_expand_button, "field 'collapseExpandButton'", ImageView.class);
        emptyItemsViewHolder.cardView = (MaterialCardView) Utils.findRequiredViewAsType(view, R.id.cardView, "field 'cardView'", MaterialCardView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        EmptyItemsViewHolder emptyItemsViewHolder = this.f11801a;
        if (emptyItemsViewHolder != null) {
            this.f11801a = null;
            emptyItemsViewHolder.topLevelContainer = null;
            emptyItemsViewHolder.topLevelExtrasContainer = null;
            emptyItemsViewHolder.constraintContainer = null;
            emptyItemsViewHolder.constraintLinkUnderAction = null;
            emptyItemsViewHolder.dragHandle = null;
            emptyItemsViewHolder.collapseExpandButton = null;
            emptyItemsViewHolder.cardView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
