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
public class DrawerOpenShortcutViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerOpenShortcutViewHolder f11498a;

    /* renamed from: b  reason: collision with root package name */
    private View f11499b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerOpenShortcutViewHolder f11500a;

        a(DrawerOpenShortcutViewHolder drawerOpenShortcutViewHolder) {
            this.f11500a = drawerOpenShortcutViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11500a.handleClick();
        }
    }

    @UiThread
    public DrawerOpenShortcutViewHolder_ViewBinding(DrawerOpenShortcutViewHolder drawerOpenShortcutViewHolder, View view) {
        this.f11498a = drawerOpenShortcutViewHolder;
        drawerOpenShortcutViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerOpenShortcutViewHolder.appName = (TextView) Utils.findRequiredViewAsType(view, R.id.app_name, "field 'appName'", TextView.class);
        drawerOpenShortcutViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.macro_container, "method 'handleClick'");
        this.f11499b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerOpenShortcutViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerOpenShortcutViewHolder drawerOpenShortcutViewHolder = this.f11498a;
        if (drawerOpenShortcutViewHolder != null) {
            this.f11498a = null;
            drawerOpenShortcutViewHolder.icon = null;
            drawerOpenShortcutViewHolder.appName = null;
            drawerOpenShortcutViewHolder.dragHandle = null;
            this.f11499b.setOnClickListener(null);
            this.f11499b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
