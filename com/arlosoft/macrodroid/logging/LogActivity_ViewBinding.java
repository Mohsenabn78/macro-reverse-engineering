package com.arlosoft.macrodroid.logging;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class LogActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private LogActivity f12674a;

    @UiThread
    public LogActivity_ViewBinding(LogActivity logActivity) {
        this(logActivity, logActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        LogActivity logActivity = this.f12674a;
        if (logActivity != null) {
            this.f12674a = null;
            logActivity.recyclerView = null;
            logActivity.viewFlipper = null;
            logActivity.infoCardView = null;
            logActivity.infoCardTitle = null;
            logActivity.infoCardDetail = null;
            logActivity.infoCardGotIt = null;
            logActivity.emptyView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public LogActivity_ViewBinding(LogActivity logActivity, View view) {
        this.f12674a = logActivity;
        logActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        logActivity.viewFlipper = (ViewFlipper) Utils.findRequiredViewAsType(view, R.id.view_flipper, "field 'viewFlipper'", ViewFlipper.class);
        logActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        logActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        logActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        logActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
        logActivity.emptyView = (LottieAnimationView) Utils.findRequiredViewAsType(view, R.id.animation_view, "field 'emptyView'", LottieAnimationView.class);
    }
}
