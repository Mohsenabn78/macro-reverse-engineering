package com.arlosoft.macrodroid.intro;

import agency.tango.materialintroscreen.SlideFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConstraintOnboardFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ConstraintOnboardFragment extends SlideFragment {
    public static final int $stable = 0;

    @Override // agency.tango.materialintroscreen.SlideFragment
    public int backgroundColor() {
        return R.color.design_default_color_primary;
    }

    @Override // agency.tango.materialintroscreen.SlideFragment
    public int buttonsColor() {
        return R.color.white_very_transparent;
    }

    @Override // agency.tango.materialintroscreen.SlideFragment
    public int dotsOffColor() {
        return R.color.white_very_transparent;
    }

    @Override // agency.tango.materialintroscreen.SlideFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup viewGroup, @Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_constraint_onboard, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nboard, container, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.captionText);
        CharSequence text = textView.getText();
        textView.setText("\"" + ((Object) text) + "\"");
        return inflate;
    }
}
