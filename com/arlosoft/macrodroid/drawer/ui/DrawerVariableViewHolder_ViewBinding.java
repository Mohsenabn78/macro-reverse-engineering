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
public class DrawerVariableViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerVariableViewHolder f11549a;

    /* renamed from: b  reason: collision with root package name */
    private View f11550b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerVariableViewHolder f11551a;

        a(DrawerVariableViewHolder drawerVariableViewHolder) {
            this.f11551a = drawerVariableViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11551a.onClicked();
        }
    }

    @UiThread
    public DrawerVariableViewHolder_ViewBinding(DrawerVariableViewHolder drawerVariableViewHolder, View view) {
        this.f11549a = drawerVariableViewHolder;
        drawerVariableViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerVariableViewHolder.varName = (TextView) Utils.findRequiredViewAsType(view, R.id.var_name, "field 'varName'", TextView.class);
        drawerVariableViewHolder.varValue = (TextView) Utils.findRequiredViewAsType(view, R.id.var_value, "field 'varValue'", TextView.class);
        drawerVariableViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.variable_container, "method 'onClicked'");
        this.f11550b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerVariableViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerVariableViewHolder drawerVariableViewHolder = this.f11549a;
        if (drawerVariableViewHolder != null) {
            this.f11549a = null;
            drawerVariableViewHolder.icon = null;
            drawerVariableViewHolder.varName = null;
            drawerVariableViewHolder.varValue = null;
            drawerVariableViewHolder.dragHandle = null;
            this.f11550b.setOnClickListener(null);
            this.f11550b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
