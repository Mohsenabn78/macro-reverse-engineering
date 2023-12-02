package com.arlosoft.macrodroid.geofences;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public class GeofenceListActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private GeofenceListActivity f12206a;

    /* renamed from: b  reason: collision with root package name */
    private View f12207b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GeofenceListActivity f12208a;

        a(GeofenceListActivity geofenceListActivity) {
            this.f12208a = geofenceListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f12208a.addGeofenceButtonClick();
        }
    }

    @UiThread
    public GeofenceListActivity_ViewBinding(GeofenceListActivity geofenceListActivity) {
        this(geofenceListActivity, geofenceListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        GeofenceListActivity geofenceListActivity = this.f12206a;
        if (geofenceListActivity != null) {
            this.f12206a = null;
            geofenceListActivity.emptyView = null;
            geofenceListActivity.addGeofenceButton = null;
            geofenceListActivity.recyclerView = null;
            geofenceListActivity.infoCardView = null;
            geofenceListActivity.infoCardTitle = null;
            geofenceListActivity.infoCardDetail = null;
            geofenceListActivity.infoCardGotIt = null;
            this.f12207b.setOnClickListener(null);
            this.f12207b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public GeofenceListActivity_ViewBinding(GeofenceListActivity geofenceListActivity, View view) {
        this.f12206a = geofenceListActivity;
        geofenceListActivity.emptyView = Utils.findRequiredView(view, R.id.geofences_emptyView, "field 'emptyView'");
        View findRequiredView = Utils.findRequiredView(view, R.id.geofence_add_button, "field 'addGeofenceButton' and method 'addGeofenceButtonClick'");
        geofenceListActivity.addGeofenceButton = (FloatingActionButton) Utils.castView(findRequiredView, R.id.geofence_add_button, "field 'addGeofenceButton'", FloatingActionButton.class);
        this.f12207b = findRequiredView;
        findRequiredView.setOnClickListener(new a(geofenceListActivity));
        geofenceListActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        geofenceListActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        geofenceListActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        geofenceListActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        geofenceListActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
    }
}
