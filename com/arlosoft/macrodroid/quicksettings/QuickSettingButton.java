package com.arlosoft.macrodroid.quicksettings;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickSettingButton.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class QuickSettingButton {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(alternate = {"f"}, value = "collapseOnPress")
    private final boolean collapseOnPress;
    @SerializedName(alternate = {CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT}, value = "enabled")
    private final boolean enabled;
    @SerializedName(alternate = {"b"}, value = "image")
    private final int image;
    @Nullable
    private final String imageName;
    @SerializedName(alternate = {"d"}, value = "isToggle")
    private final boolean isToggle;
    @SerializedName(alternate = {"a"}, value = Constants.ScionAnalytics.PARAM_LABEL)
    @NotNull
    private final String label;
    @SerializedName(alternate = {"e"}, value = "toggleOn")
    private final boolean toggleOn;

    /* compiled from: QuickSettingButton.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QuickSettingButton create(@NotNull String label, int i4, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new QuickSettingButton(label, i4, z3, z4, z5, z6, str);
        }

        @JvmStatic
        @NotNull
        public final QuickSettingButton createDefault() {
            return new QuickSettingButton("", R.drawable.ic_settings_applications_white_24dp, false, true, false, false, "ic_settings_applications_white_24dp");
        }
    }

    public QuickSettingButton(@NotNull String label, int i4, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str) {
        Intrinsics.checkNotNullParameter(label, "label");
        this.label = label;
        this.image = i4;
        this.enabled = z3;
        this.isToggle = z4;
        this.toggleOn = z5;
        this.collapseOnPress = z6;
        this.imageName = str;
    }

    public static /* synthetic */ QuickSettingButton copy$default(QuickSettingButton quickSettingButton, String str, int i4, boolean z3, boolean z4, boolean z5, boolean z6, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = quickSettingButton.label;
        }
        if ((i5 & 2) != 0) {
            i4 = quickSettingButton.image;
        }
        int i6 = i4;
        if ((i5 & 4) != 0) {
            z3 = quickSettingButton.enabled;
        }
        boolean z7 = z3;
        if ((i5 & 8) != 0) {
            z4 = quickSettingButton.isToggle;
        }
        boolean z8 = z4;
        if ((i5 & 16) != 0) {
            z5 = quickSettingButton.toggleOn;
        }
        boolean z9 = z5;
        if ((i5 & 32) != 0) {
            z6 = quickSettingButton.collapseOnPress;
        }
        boolean z10 = z6;
        if ((i5 & 64) != 0) {
            str2 = quickSettingButton.imageName;
        }
        return quickSettingButton.copy(str, i6, z7, z8, z9, z10, str2);
    }

    @JvmStatic
    @NotNull
    public static final QuickSettingButton create(@NotNull String str, int i4, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str2) {
        return Companion.create(str, i4, z3, z4, z5, z6, str2);
    }

    @JvmStatic
    @NotNull
    public static final QuickSettingButton createDefault() {
        return Companion.createDefault();
    }

    @NotNull
    public final String component1() {
        return this.label;
    }

    public final int component2() {
        return this.image;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final boolean component4() {
        return this.isToggle;
    }

    public final boolean component5() {
        return this.toggleOn;
    }

    public final boolean component6() {
        return this.collapseOnPress;
    }

    @Nullable
    public final String component7() {
        return this.imageName;
    }

    @NotNull
    public final QuickSettingButton copy(@NotNull String label, int i4, boolean z3, boolean z4, boolean z5, boolean z6, @Nullable String str) {
        Intrinsics.checkNotNullParameter(label, "label");
        return new QuickSettingButton(label, i4, z3, z4, z5, z6, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickSettingButton)) {
            return false;
        }
        QuickSettingButton quickSettingButton = (QuickSettingButton) obj;
        if (Intrinsics.areEqual(this.label, quickSettingButton.label) && this.image == quickSettingButton.image && this.enabled == quickSettingButton.enabled && this.isToggle == quickSettingButton.isToggle && this.toggleOn == quickSettingButton.toggleOn && this.collapseOnPress == quickSettingButton.collapseOnPress && Intrinsics.areEqual(this.imageName, quickSettingButton.imageName)) {
            return true;
        }
        return false;
    }

    public final boolean getCollapseOnPress() {
        return this.collapseOnPress;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final int getImage() {
        return this.image;
    }

    @Nullable
    public final String getImageName() {
        return this.imageName;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    public final boolean getToggleOn() {
        return this.toggleOn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.label.hashCode() * 31) + this.image) * 31;
        boolean z3 = this.enabled;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode2 + i5) * 31;
        boolean z4 = this.isToggle;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z5 = this.toggleOn;
        int i9 = z5;
        if (z5 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z6 = this.collapseOnPress;
        if (!z6) {
            i4 = z6 ? 1 : 0;
        }
        int i11 = (i10 + i4) * 31;
        String str = this.imageName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i11 + hashCode;
    }

    public final boolean isToggle() {
        return this.isToggle;
    }

    @NotNull
    public String toString() {
        String str = this.label;
        int i4 = this.image;
        boolean z3 = this.enabled;
        boolean z4 = this.isToggle;
        boolean z5 = this.toggleOn;
        boolean z6 = this.collapseOnPress;
        String str2 = this.imageName;
        return "QuickSettingButton(label=" + str + ", image=" + i4 + ", enabled=" + z3 + ", isToggle=" + z4 + ", toggleOn=" + z5 + ", collapseOnPress=" + z6 + ", imageName=" + str2 + ")";
    }
}
