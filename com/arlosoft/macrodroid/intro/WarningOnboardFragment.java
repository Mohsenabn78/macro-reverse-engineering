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
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: WarningOnboardFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class WarningOnboardFragment extends SlideFragment {
    public static final int $stable = 0;
    @NotNull
    public static final String ARG_DEVICE_TYPE = "device_type";
    @NotNull
    public static final String ARG_WEB_LINK = "web_link";
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: WarningOnboardFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WarningOnboardFragment createInstance(@NotNull String deviceType, @NotNull String webLink) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(webLink, "webLink");
            Bundle bundle = new Bundle();
            bundle.putString(WarningOnboardFragment.ARG_DEVICE_TYPE, deviceType);
            bundle.putString(WarningOnboardFragment.ARG_WEB_LINK, webLink);
            WarningOnboardFragment warningOnboardFragment = new WarningOnboardFragment();
            warningOnboardFragment.setArguments(bundle);
            return warningOnboardFragment;
        }
    }

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
        String string;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_warning_onboard, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…nboard, container, false)");
        View findViewById = inflate.findViewById(R.id.badDeviceText);
        Intrinsics.checkNotNull(findViewById);
        TextView textView = (TextView) findViewById;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.bad_device_brand_device_detected);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.bad_d…ce_brand_device_detected)");
        Object[] objArr = new Object[1];
        Bundle arguments = getArguments();
        String str = "";
        objArr[0] = (arguments == null || (r3 = arguments.getString(ARG_DEVICE_TYPE)) == null) ? "" : "";
        String format = String.format(string2, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        View findViewById2 = inflate.findViewById(R.id.warningText);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView2 = (TextView) findViewById2;
        String string3 = getString(R.string.bad_device_brand_short_warning);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.bad_device_brand_short_warning)");
        Object[] objArr2 = new Object[1];
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(ARG_WEB_LINK)) != null) {
            str = string;
        }
        objArr2[0] = str;
        String format2 = String.format(string3, Arrays.copyOf(objArr2, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView2.setText(format2);
        return inflate;
    }
}
