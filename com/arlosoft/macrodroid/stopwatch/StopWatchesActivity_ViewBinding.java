package com.arlosoft.macrodroid.stopwatch;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class StopWatchesActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private StopWatchesActivity f13599a;

    /* renamed from: b  reason: collision with root package name */
    private View f13600b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StopWatchesActivity f13601a;

        a(StopWatchesActivity stopWatchesActivity) {
            this.f13601a = stopWatchesActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f13601a.onPlusButtonClicked();
        }
    }

    @UiThread
    public StopWatchesActivity_ViewBinding(StopWatchesActivity stopWatchesActivity) {
        this(stopWatchesActivity, stopWatchesActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        StopWatchesActivity stopWatchesActivity = this.f13599a;
        if (stopWatchesActivity != null) {
            this.f13599a = null;
            stopWatchesActivity.recyclerView = null;
            stopWatchesActivity.viewFlipper = null;
            stopWatchesActivity.infoCardView = null;
            stopWatchesActivity.infoCardTitle = null;
            stopWatchesActivity.infoCardDetail = null;
            stopWatchesActivity.infoCardGotIt = null;
            this.f13600b.setOnClickListener(null);
            this.f13600b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public StopWatchesActivity_ViewBinding(StopWatchesActivity stopWatchesActivity, View view) {
        this.f13599a = stopWatchesActivity;
        stopWatchesActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        stopWatchesActivity.viewFlipper = (ViewFlipper) Utils.findRequiredViewAsType(view, R.id.view_flipper, "field 'viewFlipper'", ViewFlipper.class);
        stopWatchesActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        stopWatchesActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        stopWatchesActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        stopWatchesActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fab, "method 'onPlusButtonClicked'");
        this.f13600b = findRequiredView;
        findRequiredView.setOnClickListener(new a(stopWatchesActivity));
    }
}
