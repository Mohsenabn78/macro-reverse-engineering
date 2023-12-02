package com.arlosoft.macrodroid.quicksettings;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickSettingsData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class QuickSettingsData {
    public static final int NUM_BUTTONS = 16;
    @NotNull
    public static final String QUICK_SETTINGS_CACHE = "QuickSettings";
    @NotNull
    public static final String QUICK_SETTINGS_DATA_KEY = "QuickSettingsData";
    @NotNull
    public static final String QUICK_SETTINGS_IMPORT_DATA_KEY = "QuickSettingsImportData";
    @SerializedName(alternate = {"a"}, value = "quickSettingsButtonList")
    @NotNull
    private final List<QuickSettingButton> quickSettingsButtonList;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: QuickSettingsData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final QuickSettingsData createDefault() {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < 16; i4++) {
                arrayList.add(QuickSettingButton.Companion.createDefault());
            }
            return new QuickSettingsData(arrayList);
        }
    }

    public QuickSettingsData(@NotNull List<QuickSettingButton> quickSettingsButtonList) {
        Intrinsics.checkNotNullParameter(quickSettingsButtonList, "quickSettingsButtonList");
        this.quickSettingsButtonList = quickSettingsButtonList;
    }

    private final List<QuickSettingButton> component1() {
        return this.quickSettingsButtonList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuickSettingsData copy$default(QuickSettingsData quickSettingsData, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = quickSettingsData.quickSettingsButtonList;
        }
        return quickSettingsData.copy(list);
    }

    @JvmStatic
    @NotNull
    public static final QuickSettingsData createDefault() {
        return Companion.createDefault();
    }

    @NotNull
    public final QuickSettingsData copy(@NotNull List<QuickSettingButton> quickSettingsButtonList) {
        Intrinsics.checkNotNullParameter(quickSettingsButtonList, "quickSettingsButtonList");
        return new QuickSettingsData(quickSettingsButtonList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof QuickSettingsData) && Intrinsics.areEqual(this.quickSettingsButtonList, ((QuickSettingsData) obj).quickSettingsButtonList)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<QuickSettingButton> getQSButtonList() {
        upddateFrom4or8To16IfRequired();
        return this.quickSettingsButtonList;
    }

    public int hashCode() {
        return this.quickSettingsButtonList.hashCode();
    }

    public final void replaceButton(@NotNull QuickSettingButton buttonToReplace, @NotNull QuickSettingButton buttonToAdd) {
        Intrinsics.checkNotNullParameter(buttonToReplace, "buttonToReplace");
        Intrinsics.checkNotNullParameter(buttonToAdd, "buttonToAdd");
        int indexOf = this.quickSettingsButtonList.indexOf(buttonToReplace);
        if (indexOf >= 0) {
            this.quickSettingsButtonList.remove(indexOf);
            this.quickSettingsButtonList.add(indexOf, buttonToAdd);
        }
    }

    public final void replaceButtonAtIndex(int i4, @NotNull QuickSettingButton buttonToAdd) {
        Intrinsics.checkNotNullParameter(buttonToAdd, "buttonToAdd");
        if (i4 >= 0) {
            this.quickSettingsButtonList.remove(i4);
            this.quickSettingsButtonList.add(i4, buttonToAdd);
        }
    }

    @NotNull
    public String toString() {
        List<QuickSettingButton> list = this.quickSettingsButtonList;
        return "QuickSettingsData(quickSettingsButtonList=" + list + ")";
    }

    public final void upddateFrom4or8To16IfRequired() {
        if (this.quickSettingsButtonList.size() == 4) {
            for (int i4 = 4; i4 < 16; i4++) {
                this.quickSettingsButtonList.add(QuickSettingButton.Companion.createDefault());
            }
            return;
        }
        if (this.quickSettingsButtonList.size() == 8) {
            for (int i5 = 8; i5 < 16; i5++) {
                this.quickSettingsButtonList.add(QuickSettingButton.Companion.createDefault());
            }
        }
    }
}
