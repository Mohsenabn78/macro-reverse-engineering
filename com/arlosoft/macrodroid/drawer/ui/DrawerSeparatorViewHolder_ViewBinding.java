package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerSeparatorViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerSeparatorViewHolder f11530a;

    @UiThread
    public DrawerSeparatorViewHolder_ViewBinding(DrawerSeparatorViewHolder drawerSeparatorViewHolder, View view) {
        this.f11530a = drawerSeparatorViewHolder;
        drawerSeparatorViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerSeparatorViewHolder drawerSeparatorViewHolder = this.f11530a;
        if (drawerSeparatorViewHolder != null) {
            this.f11530a = null;
            drawerSeparatorViewHolder.dragHandle = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
