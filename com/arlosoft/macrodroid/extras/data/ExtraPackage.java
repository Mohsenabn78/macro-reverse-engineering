package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraPackage.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class ExtraPackage {
    public static final int $stable = 8;
    @NotNull
    private final StringWithLanguages details;
    @Nullable
    private final StringWithLanguages disclaimer;
    @NotNull
    private final String iconUrl;
    @NotNull
    private final String id;
    @NotNull
    private final String macroSet;
    @Nullable
    private final Map<String, StringWithLanguages> macroShortcutButtons;
    @NotNull
    private final List<Macro> macros;
    @NotNull
    private final ExtraMinVersion minMacroDroidVersion;
    @NotNull
    private final List<String> permissions;
    @Nullable
    private final String settingsMacroName;
    @NotNull
    private final SubscriptionData subscriptionData;
    @NotNull
    private final String subscriptionId;
    @NotNull
    private final StringWithLanguages summary;
    @NotNull
    private final SupportChannels supportChannels;
    @NotNull
    private final List<String> supportedLocales;
    @NotNull
    private final StringWithLanguages title;
    private final int versionCode;
    @NotNull
    private final List<ExtraVersionHistoryEntry> versionHistory;
    @NotNull
    private final String versionString;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraPackage(@NotNull String id, @NotNull StringWithLanguages title, @NotNull StringWithLanguages summary, @NotNull StringWithLanguages details, @NotNull String iconUrl, @NotNull ExtraMinVersion minMacroDroidVersion, @NotNull List<String> supportedLocales, @NotNull String versionString, int i4, @NotNull String macroSet, @NotNull String subscriptionId, @NotNull SubscriptionData subscriptionData, @NotNull List<? extends Macro> macros, @Nullable StringWithLanguages stringWithLanguages, @NotNull SupportChannels supportChannels, @NotNull List<ExtraVersionHistoryEntry> versionHistory, @NotNull List<String> permissions, @Nullable Map<String, StringWithLanguages> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(minMacroDroidVersion, "minMacroDroidVersion");
        Intrinsics.checkNotNullParameter(supportedLocales, "supportedLocales");
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        Intrinsics.checkNotNullParameter(macroSet, "macroSet");
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(subscriptionData, "subscriptionData");
        Intrinsics.checkNotNullParameter(macros, "macros");
        Intrinsics.checkNotNullParameter(supportChannels, "supportChannels");
        Intrinsics.checkNotNullParameter(versionHistory, "versionHistory");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.details = details;
        this.iconUrl = iconUrl;
        this.minMacroDroidVersion = minMacroDroidVersion;
        this.supportedLocales = supportedLocales;
        this.versionString = versionString;
        this.versionCode = i4;
        this.macroSet = macroSet;
        this.subscriptionId = subscriptionId;
        this.subscriptionData = subscriptionData;
        this.macros = macros;
        this.disclaimer = stringWithLanguages;
        this.supportChannels = supportChannels;
        this.versionHistory = versionHistory;
        this.permissions = permissions;
        this.macroShortcutButtons = map;
        this.settingsMacroName = str;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component10() {
        return this.macroSet;
    }

    @NotNull
    public final String component11() {
        return this.subscriptionId;
    }

    @NotNull
    public final SubscriptionData component12() {
        return this.subscriptionData;
    }

    @NotNull
    public final List<Macro> component13() {
        return this.macros;
    }

    @Nullable
    public final StringWithLanguages component14() {
        return this.disclaimer;
    }

    @NotNull
    public final SupportChannels component15() {
        return this.supportChannels;
    }

    @NotNull
    public final List<ExtraVersionHistoryEntry> component16() {
        return this.versionHistory;
    }

    @NotNull
    public final List<String> component17() {
        return this.permissions;
    }

    @Nullable
    public final Map<String, StringWithLanguages> component18() {
        return this.macroShortcutButtons;
    }

    @Nullable
    public final String component19() {
        return this.settingsMacroName;
    }

    @NotNull
    public final StringWithLanguages component2() {
        return this.title;
    }

    @NotNull
    public final StringWithLanguages component3() {
        return this.summary;
    }

    @NotNull
    public final StringWithLanguages component4() {
        return this.details;
    }

    @NotNull
    public final String component5() {
        return this.iconUrl;
    }

    @NotNull
    public final ExtraMinVersion component6() {
        return this.minMacroDroidVersion;
    }

    @NotNull
    public final List<String> component7() {
        return this.supportedLocales;
    }

    @NotNull
    public final String component8() {
        return this.versionString;
    }

    public final int component9() {
        return this.versionCode;
    }

    @NotNull
    public final ExtraPackage copy(@NotNull String id, @NotNull StringWithLanguages title, @NotNull StringWithLanguages summary, @NotNull StringWithLanguages details, @NotNull String iconUrl, @NotNull ExtraMinVersion minMacroDroidVersion, @NotNull List<String> supportedLocales, @NotNull String versionString, int i4, @NotNull String macroSet, @NotNull String subscriptionId, @NotNull SubscriptionData subscriptionData, @NotNull List<? extends Macro> macros, @Nullable StringWithLanguages stringWithLanguages, @NotNull SupportChannels supportChannels, @NotNull List<ExtraVersionHistoryEntry> versionHistory, @NotNull List<String> permissions, @Nullable Map<String, StringWithLanguages> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(minMacroDroidVersion, "minMacroDroidVersion");
        Intrinsics.checkNotNullParameter(supportedLocales, "supportedLocales");
        Intrinsics.checkNotNullParameter(versionString, "versionString");
        Intrinsics.checkNotNullParameter(macroSet, "macroSet");
        Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
        Intrinsics.checkNotNullParameter(subscriptionData, "subscriptionData");
        Intrinsics.checkNotNullParameter(macros, "macros");
        Intrinsics.checkNotNullParameter(supportChannels, "supportChannels");
        Intrinsics.checkNotNullParameter(versionHistory, "versionHistory");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new ExtraPackage(id, title, summary, details, iconUrl, minMacroDroidVersion, supportedLocales, versionString, i4, macroSet, subscriptionId, subscriptionData, macros, stringWithLanguages, supportChannels, versionHistory, permissions, map, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtraPackage)) {
            return false;
        }
        ExtraPackage extraPackage = (ExtraPackage) obj;
        if (Intrinsics.areEqual(this.id, extraPackage.id) && Intrinsics.areEqual(this.title, extraPackage.title) && Intrinsics.areEqual(this.summary, extraPackage.summary) && Intrinsics.areEqual(this.details, extraPackage.details) && Intrinsics.areEqual(this.iconUrl, extraPackage.iconUrl) && Intrinsics.areEqual(this.minMacroDroidVersion, extraPackage.minMacroDroidVersion) && Intrinsics.areEqual(this.supportedLocales, extraPackage.supportedLocales) && Intrinsics.areEqual(this.versionString, extraPackage.versionString) && this.versionCode == extraPackage.versionCode && Intrinsics.areEqual(this.macroSet, extraPackage.macroSet) && Intrinsics.areEqual(this.subscriptionId, extraPackage.subscriptionId) && Intrinsics.areEqual(this.subscriptionData, extraPackage.subscriptionData) && Intrinsics.areEqual(this.macros, extraPackage.macros) && Intrinsics.areEqual(this.disclaimer, extraPackage.disclaimer) && Intrinsics.areEqual(this.supportChannels, extraPackage.supportChannels) && Intrinsics.areEqual(this.versionHistory, extraPackage.versionHistory) && Intrinsics.areEqual(this.permissions, extraPackage.permissions) && Intrinsics.areEqual(this.macroShortcutButtons, extraPackage.macroShortcutButtons) && Intrinsics.areEqual(this.settingsMacroName, extraPackage.settingsMacroName)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final StringWithLanguages getDetails() {
        return this.details;
    }

    @Nullable
    public final StringWithLanguages getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getMacroSet() {
        return this.macroSet;
    }

    @Nullable
    public final Map<String, StringWithLanguages> getMacroShortcutButtons() {
        return this.macroShortcutButtons;
    }

    @NotNull
    public final List<Macro> getMacros() {
        return this.macros;
    }

    @NotNull
    public final ExtraMinVersion getMinMacroDroidVersion() {
        return this.minMacroDroidVersion;
    }

    @NotNull
    public final List<String> getPermissions() {
        return this.permissions;
    }

    @Nullable
    public final String getSettingsMacroName() {
        return this.settingsMacroName;
    }

    @NotNull
    public final SubscriptionData getSubscriptionData() {
        return this.subscriptionData;
    }

    @NotNull
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @NotNull
    public final StringWithLanguages getSummary() {
        return this.summary;
    }

    @NotNull
    public final SupportChannels getSupportChannels() {
        return this.supportChannels;
    }

    @NotNull
    public final List<String> getSupportedLocales() {
        return this.supportedLocales;
    }

    @NotNull
    public final StringWithLanguages getTitle() {
        return this.title;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @NotNull
    public final List<ExtraVersionHistoryEntry> getVersionHistory() {
        return this.versionHistory;
    }

    @NotNull
    public final String getVersionString() {
        return this.versionString;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = ((((((((((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.details.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.minMacroDroidVersion.hashCode()) * 31) + this.supportedLocales.hashCode()) * 31) + this.versionString.hashCode()) * 31) + this.versionCode) * 31) + this.macroSet.hashCode()) * 31) + this.subscriptionId.hashCode()) * 31) + this.subscriptionData.hashCode()) * 31) + this.macros.hashCode()) * 31;
        StringWithLanguages stringWithLanguages = this.disclaimer;
        int i4 = 0;
        if (stringWithLanguages == null) {
            hashCode = 0;
        } else {
            hashCode = stringWithLanguages.hashCode();
        }
        int hashCode4 = (((((((hashCode3 + hashCode) * 31) + this.supportChannels.hashCode()) * 31) + this.versionHistory.hashCode()) * 31) + this.permissions.hashCode()) * 31;
        Map<String, StringWithLanguages> map = this.macroShortcutButtons;
        if (map == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = map.hashCode();
        }
        int i5 = (hashCode4 + hashCode2) * 31;
        String str = this.settingsMacroName;
        if (str != null) {
            i4 = str.hashCode();
        }
        return i5 + i4;
    }

    @NotNull
    public String toString() {
        String str = this.id;
        StringWithLanguages stringWithLanguages = this.title;
        StringWithLanguages stringWithLanguages2 = this.summary;
        StringWithLanguages stringWithLanguages3 = this.details;
        String str2 = this.iconUrl;
        ExtraMinVersion extraMinVersion = this.minMacroDroidVersion;
        List<String> list = this.supportedLocales;
        String str3 = this.versionString;
        int i4 = this.versionCode;
        String str4 = this.macroSet;
        String str5 = this.subscriptionId;
        SubscriptionData subscriptionData = this.subscriptionData;
        List<Macro> list2 = this.macros;
        StringWithLanguages stringWithLanguages4 = this.disclaimer;
        SupportChannels supportChannels = this.supportChannels;
        List<ExtraVersionHistoryEntry> list3 = this.versionHistory;
        List<String> list4 = this.permissions;
        Map<String, StringWithLanguages> map = this.macroShortcutButtons;
        String str6 = this.settingsMacroName;
        return "ExtraPackage(id=" + str + ", title=" + stringWithLanguages + ", summary=" + stringWithLanguages2 + ", details=" + stringWithLanguages3 + ", iconUrl=" + str2 + ", minMacroDroidVersion=" + extraMinVersion + ", supportedLocales=" + list + ", versionString=" + str3 + ", versionCode=" + i4 + ", macroSet=" + str4 + ", subscriptionId=" + str5 + ", subscriptionData=" + subscriptionData + ", macros=" + list2 + ", disclaimer=" + stringWithLanguages4 + ", supportChannels=" + supportChannels + ", versionHistory=" + list3 + ", permissions=" + list4 + ", macroShortcutButtons=" + map + ", settingsMacroName=" + str6 + ")";
    }
}
