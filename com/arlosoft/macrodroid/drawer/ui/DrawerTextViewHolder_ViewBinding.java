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
public class DrawerTextViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerTextViewHolder f11541a;

    /* renamed from: b  reason: collision with root package name */
    private View f11542b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerTextViewHolder f11543a;

        a(DrawerTextViewHolder drawerTextViewHolder) {
            this.f11543a = drawerTextViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11543a.handleClick();
        }
    }

    @UiThread
    public DrawerTextViewHolder_ViewBinding(DrawerTextViewHolder drawerTextViewHolder, View view) {
        this.f11541a = drawerTextViewHolder;
        drawerTextViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerTextViewHolder.text = (TextView) Utils.findRequiredViewAsType(view, R.id.text, "field 'text'", TextView.class);
        drawerTextViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.macro_container, "method 'handleClick'");
        this.f11542b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerTextViewHolder));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerTextViewHolder drawerTextViewHolder = this.f11541a;
        if (drawerTextViewHolder != null) {
            this.f11541a = null;
            drawerTextViewHolder.icon = null;
            drawerTextViewHolder.text = null;
            drawerTextViewHolder.dragHandle = null;
            this.f11542b.setOnClickListener(null);
            this.f11542b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
