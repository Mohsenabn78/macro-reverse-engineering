package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class DrawerActionBlockViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerActionBlockViewHolder f11472a;

    /* renamed from: b  reason: collision with root package name */
    private View f11473b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerActionBlockViewHolder f11474a;

        a(DrawerActionBlockViewHolder drawerActionBlockViewHolder) {
            this.f11474a = drawerActionBlockViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11474a.handleClick();
        }
    }

    @UiThread
    public DrawerActionBlockViewHolder_ViewBinding(DrawerActionBlockViewHolder drawerActionBlockViewHolder, View view) {
        this.f11472a = drawerActionBlockViewHolder;
        drawerActionBlockViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerActionBlockViewHolder.actionBlockName = (TextView) Utils.findRequiredViewAsType(view, R.id.action_block_name, "field 'actionBlockName'", TextView.class);
        drawerActionBlockViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.macro_container, "method 'handleClick'");
        this.f11473b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerActionBlockViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerActionBlockViewHolder drawerActionBlockViewHolder = this.f11472a;
        if (drawerActionBlockViewHolder != null) {
            this.f11472a = null;
            drawerActionBlockViewHolder.icon = null;
            drawerActionBlockViewHolder.actionBlockName = null;
            drawerActionBlockViewHolder.dragHandle = null;
            this.f11473b.setOnClickListener(null);
            this.f11473b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
