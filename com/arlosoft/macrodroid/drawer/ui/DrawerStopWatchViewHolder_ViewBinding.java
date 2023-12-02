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
public class DrawerStopWatchViewHolder_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private DrawerStopWatchViewHolder f11533a;

    /* renamed from: b  reason: collision with root package name */
    private View f11534b;

    /* renamed from: c  reason: collision with root package name */
    private View f11535c;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerStopWatchViewHolder f11536a;

        a(DrawerStopWatchViewHolder drawerStopWatchViewHolder) {
            this.f11536a = drawerStopWatchViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11536a.onPlayPauseClicked();
        }
    }

    /* loaded from: classes3.dex */
    class b extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerStopWatchViewHolder f11538a;

        b(DrawerStopWatchViewHolder drawerStopWatchViewHolder) {
            this.f11538a = drawerStopWatchViewHolder;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f11538a.onClearButton();
        }
    }

    @UiThread
    public DrawerStopWatchViewHolder_ViewBinding(DrawerStopWatchViewHolder drawerStopWatchViewHolder, View view) {
        this.f11533a = drawerStopWatchViewHolder;
        drawerStopWatchViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        drawerStopWatchViewHolder.stopWatchName = (TextView) Utils.findRequiredViewAsType(view, R.id.stopwatch_name, "field 'stopWatchName'", TextView.class);
        drawerStopWatchViewHolder.stopWatchTime = (TextView) Utils.findRequiredViewAsType(view, R.id.stopwatch_time, "field 'stopWatchTime'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.play_pause_button, "field 'playPauseButton' and method 'onPlayPauseClicked'");
        drawerStopWatchViewHolder.playPauseButton = (ImageView) Utils.castView(findRequiredView, R.id.play_pause_button, "field 'playPauseButton'", ImageView.class);
        this.f11534b = findRequiredView;
        findRequiredView.setOnClickListener(new a(drawerStopWatchViewHolder));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.clear_button, "field 'clearButton' and method 'onClearButton'");
        drawerStopWatchViewHolder.clearButton = (ImageView) Utils.castView(findRequiredView2, R.id.clear_button, "field 'clearButton'", ImageView.class);
        this.f11535c = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(drawerStopWatchViewHolder));
        drawerStopWatchViewHolder.dragHandle = (ImageView) Utils.findRequiredViewAsType(view, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        DrawerStopWatchViewHolder drawerStopWatchViewHolder = this.f11533a;
        if (drawerStopWatchViewHolder != null) {
            this.f11533a = null;
            drawerStopWatchViewHolder.icon = null;
            drawerStopWatchViewHolder.stopWatchName = null;
            drawerStopWatchViewHolder.stopWatchTime = null;
            drawerStopWatchViewHolder.playPauseButton = null;
            drawerStopWatchViewHolder.clearButton = null;
            drawerStopWatchViewHolder.dragHandle = null;
            this.f11534b.setOnClickListener(null);
            this.f11534b = null;
            this.f11535c.setOnClickListener(null);
            this.f11535c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
