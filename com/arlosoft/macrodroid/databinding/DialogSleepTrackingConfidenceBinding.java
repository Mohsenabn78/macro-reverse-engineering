package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.innovattic.rangeseekbar.RangeSeekBar;

/* loaded from: classes3.dex */
public final class DialogSleepTrackingConfidenceBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11130a;
    @NonNull
    public final TextView asleepThresholdText;
    @NonNull
    public final TextView asleepThresholdValue;
    @NonNull
    public final TextView awakeThresholdText;
    @NonNull
    public final TextView awakeThresholdValue;
    @NonNull
    public final RangeSeekBar rangeSeekBar;

    private DialogSleepTrackingConfidenceBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RangeSeekBar rangeSeekBar) {
        this.f11130a = scrollView;
        this.asleepThresholdText = textView;
        this.asleepThresholdValue = textView2;
        this.awakeThresholdText = textView3;
        this.awakeThresholdValue = textView4;
        this.rangeSeekBar = rangeSeekBar;
    }

    @NonNull
    public static DialogSleepTrackingConfidenceBinding bind(@NonNull View view) {
        int i4 = R.id.asleepThresholdText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.asleepThresholdText);
        if (textView != null) {
            i4 = R.id.asleepThresholdValue;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.asleepThresholdValue);
            if (textView2 != null) {
                i4 = R.id.awakeThresholdText;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.awakeThresholdText);
                if (textView3 != null) {
                    i4 = R.id.awakeThresholdValue;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.awakeThresholdValue);
                    if (textView4 != null) {
                        i4 = R.id.rangeSeekBar;
                        RangeSeekBar rangeSeekBar = (RangeSeekBar) ViewBindings.findChildViewById(view, R.id.rangeSeekBar);
                        if (rangeSeekBar != null) {
                            return new DialogSleepTrackingConfidenceBinding((ScrollView) view, textView, textView2, textView3, textView4, rangeSeekBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogSleepTrackingConfidenceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSleepTrackingConfidenceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sleep_tracking_confidence, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11130a;
    }
}
