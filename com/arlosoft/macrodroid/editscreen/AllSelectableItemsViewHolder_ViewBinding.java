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
public final class AllSelectableItemsViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private AllSelectableItemsViewHolder f11731a;

    @UiThread
    public AllSelectableItemsViewHolder_ViewBinding(AllSelectableItemsViewHolder allSelectableItemsViewHolder, View view) {
        this.f11731a = allSelectableItemsViewHolder;
        allSelectableItemsViewHolder.topLevelContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.topLevelContainer, "field 'topLevelContainer'", ViewGroup.class);
        allSelectableItemsViewHolder.topLevelExtrasContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.topLevelExtrasContainer, "field 'topLevelExtrasContainer'", ViewGroup.class);
        allSelectableItemsViewHolder.constraintContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.constraintContainer, "field 'constraintContainer'", ViewGroup.class);
        allSelectableItemsViewHolder.constraintLinkUnderAction = Utils.findRequiredView(view, R.id.constraintLinkUnderAction, "field 'constraintLinkUnderAction'");
        allSelectableItemsViewHolder.dragHandle = Utils.findRequiredView(view, R.id.dragHandle, "field 'dragHandle'");
        allSelectableItemsViewHolder.collapseExpandButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.collapse_expand_button, "field 'collapseExpandButton'", ImageView.class);
        allSelectableItemsViewHolder.cardView = (MaterialCardView) Utils.findRequiredViewAsType(view, R.id.cardView, "field 'cardView'", MaterialCardView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AllSelectableItemsViewHolder allSelectableItemsViewHolder = this.f11731a;
        if (allSelectableItemsViewHolder != null) {
            this.f11731a = null;
            allSelectableItemsViewHolder.topLevelContainer = null;
            allSelectableItemsViewHolder.topLevelExtrasContainer = null;
            allSelectableItemsViewHolder.constraintContainer = null;
            allSelectableItemsViewHolder.constraintLinkUnderAction = null;
            allSelectableItemsViewHolder.dragHandle = null;
            allSelectableItemsViewHolder.collapseExpandButton = null;
            allSelectableItemsViewHolder.cardView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
