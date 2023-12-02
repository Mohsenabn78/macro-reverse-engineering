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
public class DrawerMacroViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerMacroViewHolder f11493a;

    /* renamed from: b  reason: collision with root package name */
    private View f11494b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerMacroViewHolder f11495a;

        a(DrawerMacroViewHolder drawerMacroViewHolder) {
            this.f11495a = drawerMacroViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11495a.handleClick();
        }
    }

    @UiThread
    public DrawerMacroViewHolder_ViewBinding(DrawerMacroViewHolder drawerMacroViewHolder, View view) {
        this.f11493a = drawerMacroViewHolder;
        drawerMacroViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerMacroViewHolder.macroName = (TextView) Utils.findRequiredViewAsType(view, R.id.macro_name, "field 'macroName'", TextView.class);
        drawerMacroViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.macro_container, "method 'handleClick'");
        this.f11494b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerMacroViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerMacroViewHolder drawerMacroViewHolder = this.f11493a;
        if (drawerMacroViewHolder != null) {
            this.f11493a = null;
            drawerMacroViewHolder.icon = null;
            drawerMacroViewHolder.macroName = null;
            drawerMacroViewHolder.dragHandle = null;
            this.f11494b.setOnClickListener(null);
            this.f11494b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
