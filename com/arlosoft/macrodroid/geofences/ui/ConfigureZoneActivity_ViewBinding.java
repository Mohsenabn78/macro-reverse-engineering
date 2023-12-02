package com.arlosoft.macrodroid.geofences.ui;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class ConfigureZoneActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ConfigureZoneActivity f12256a;

    /* renamed from: b  reason: collision with root package name */
    private View f12257b;

    /* renamed from: c  reason: collision with root package name */
    private View f12258c;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConfigureZoneActivity f12259a;

        a(ConfigureZoneActivity configureZoneActivity) {
            this.f12259a = configureZoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f12259a.onRadiusTextClicked();
        }
    }

    /* loaded from: classes3.dex */
    class b extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConfigureZoneActivity f12261a;

        b(ConfigureZoneActivity configureZoneActivity) {
            this.f12261a = configureZoneActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f12261a.onSaveClicked();
        }
    }

    @UiThread
    public ConfigureZoneActivity_ViewBinding(ConfigureZoneActivity configureZoneActivity) {
        this(configureZoneActivity, configureZoneActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ConfigureZoneActivity configureZoneActivity = this.f12256a;
        if (configureZoneActivity != null) {
            this.f12256a = null;
            configureZoneActivity.zoneName = null;
            configureZoneActivity.areaSeekBar = null;
            configureZoneActivity.radiusValueText = null;
            configureZoneActivity.areaRadius = null;
            configureZoneActivity.searchBox = null;
            this.f12257b.setOnClickListener(null);
            this.f12257b = null;
            this.f12258c.setOnClickListener(null);
            this.f12258c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public ConfigureZoneActivity_ViewBinding(ConfigureZoneActivity configureZoneActivity, View view) {
        this.f12256a = configureZoneActivity;
        configureZoneActivity.zoneName = (EditText) Utils.findRequiredViewAsType(view, R.id.zone_name, "field 'zoneName'", EditText.class);
        configureZoneActivity.areaSeekBar = (SeekBar) Utils.findRequiredViewAsType(view, R.id.area_seek_bar, "field 'areaSeekBar'", SeekBar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.radius_value_text, "field 'radiusValueText' and method 'onRadiusTextClicked'");
        configureZoneActivity.radiusValueText = (TextView) Utils.castView(findRequiredView, R.id.radius_value_text, "field 'radiusValueText'", TextView.class);
        this.f12257b = findRequiredView;
        findRequiredView.setOnClickListener(new a(configureZoneActivity));
        configureZoneActivity.areaRadius = Utils.findRequiredView(view, R.id.area_radius, "field 'areaRadius'");
        configureZoneActivity.searchBox = (TextView) Utils.findRequiredViewAsType(view, R.id.search_box, "field 'searchBox'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.save_button, "method 'onSaveClicked'");
        this.f12258c = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(configureZoneActivity));
    }
}
