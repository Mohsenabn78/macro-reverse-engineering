package com.arlosoft.macrodroid.drawer.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DrawerLogViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerLogViewHolder f11487a;

    /* renamed from: b  reason: collision with root package name */
    private View f11488b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerLogViewHolder f11489a;

        a(DrawerLogViewHolder drawerLogViewHolder) {
            this.f11489a = drawerLogViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11489a.handleClick();
        }
    }

    @UiThread
    public DrawerLogViewHolder_ViewBinding(DrawerLogViewHolder drawerLogViewHolder, View view) {
        this.f11487a = drawerLogViewHolder;
        drawerLogViewHolder.logText = (TextView) Utils.findRequiredViewAsType(view, R.id.log_text, "field 'logText'", TextView.class);
        drawerLogViewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        drawerLogViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.log_container, "method 'handleClick'");
        this.f11488b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerLogViewHolder));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        DrawerLogViewHolder drawerLogViewHolder = this.f11487a;
        if (drawerLogViewHolder != null) {
            this.f11487a = null;
            drawerLogViewHolder.logText = null;
            drawerLogViewHolder.title = null;
            drawerLogViewHolder.dragHandle = null;
            this.f11488b.setOnClickListener(null);
            this.f11488b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
