package com.arlosoft.macrodroid.editscreen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class LocalVarsViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LocalVarsViewHolder f11824a;

    @UiThread
    public LocalVarsViewHolder_ViewBinding(LocalVarsViewHolder localVarsViewHolder, View view) {
        this.f11824a = localVarsViewHolder;
        localVarsViewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.macro_edit_entry_name, "field 'name'", TextView.class);
        localVarsViewHolder.value = (TextView) Utils.findRequiredViewAsType(view, R.id.macro_edit_entry_detail, "field 'value'", TextView.class);
        localVarsViewHolder.mainContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.topLevelContainer, "field 'mainContainer'", ViewGroup.class);
        localVarsViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.macro_edit_entry_icon, "field 'icon'", ImageView.class);
        localVarsViewHolder.iconText = (TextView) Utils.findRequiredViewAsType(view, R.id.iconText, "field 'iconText'", TextView.class);
        localVarsViewHolder.cardView = (MaterialCardView) Utils.findRequiredViewAsType(view, R.id.cardView, "field 'cardView'", MaterialCardView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LocalVarsViewHolder localVarsViewHolder = this.f11824a;
        if (localVarsViewHolder != null) {
            this.f11824a = null;
            localVarsViewHolder.name = null;
            localVarsViewHolder.value = null;
            localVarsViewHolder.mainContainer = null;
            localVarsViewHolder.icon = null;
            localVarsViewHolder.iconText = null;
            localVarsViewHolder.cardView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
