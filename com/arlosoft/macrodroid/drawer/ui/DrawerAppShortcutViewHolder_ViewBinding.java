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
public class DrawerAppShortcutViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerAppShortcutViewHolder f11477a;

    /* renamed from: b  reason: collision with root package name */
    private View f11478b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerAppShortcutViewHolder f11479a;

        a(DrawerAppShortcutViewHolder drawerAppShortcutViewHolder) {
            this.f11479a = drawerAppShortcutViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11479a.handleClick();
        }
    }

    @UiThread
    public DrawerAppShortcutViewHolder_ViewBinding(DrawerAppShortcutViewHolder drawerAppShortcutViewHolder, View view) {
        this.f11477a = drawerAppShortcutViewHolder;
        drawerAppShortcutViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerAppShortcutViewHolder.appName = (TextView) Utils.findRequiredViewAsType(view, R.id.app_name, "field 'appName'", TextView.class);
        drawerAppShortcutViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.macro_container, "method 'handleClick'");
        this.f11478b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerAppShortcutViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerAppShortcutViewHolder drawerAppShortcutViewHolder = this.f11477a;
        if (drawerAppShortcutViewHolder != null) {
            this.f11477a = null;
            drawerAppShortcutViewHolder.icon = null;
            drawerAppShortcutViewHolder.appName = null;
            drawerAppShortcutViewHolder.dragHandle = null;
            this.f11478b.setOnClickListener(null);
            this.f11478b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
