package com.arlosoft.macrodroid.quicksettings;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class QuickSettingsActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private QuickSettingsActivity f13278a;

    @UiThread
    public QuickSettingsActivity_ViewBinding(QuickSettingsActivity quickSettingsActivity) {
        this(quickSettingsActivity, quickSettingsActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        QuickSettingsActivity quickSettingsActivity = this.f13278a;
        if (quickSettingsActivity != null) {
            this.f13278a = null;
            quickSettingsActivity.infoCardView = null;
            quickSettingsActivity.infoCardTitle = null;
            quickSettingsActivity.infoCardDetail = null;
            quickSettingsActivity.infoCardGotIt = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public QuickSettingsActivity_ViewBinding(QuickSettingsActivity quickSettingsActivity, View view) {
        this.f13278a = quickSettingsActivity;
        quickSettingsActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        quickSettingsActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        quickSettingsActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        quickSettingsActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
    }
}
