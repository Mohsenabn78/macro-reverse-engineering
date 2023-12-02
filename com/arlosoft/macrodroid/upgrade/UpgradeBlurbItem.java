package com.arlosoft.macrodroid.upgrade;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UpgradeBlurbItem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UpgradeBlurbItem {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f15885a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15886b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15887c;

    public UpgradeBlurbItem(@StringRes int i4, @StringRes int i5, @DrawableRes int i6) {
        this.f15885a = i4;
        this.f15886b = i5;
        this.f15887c = i6;
    }

    public static /* synthetic */ UpgradeBlurbItem copy$default(UpgradeBlurbItem upgradeBlurbItem, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i4 = upgradeBlurbItem.f15885a;
        }
        if ((i7 & 2) != 0) {
            i5 = upgradeBlurbItem.f15886b;
        }
        if ((i7 & 4) != 0) {
            i6 = upgradeBlurbItem.f15887c;
        }
        return upgradeBlurbItem.copy(i4, i5, i6);
    }

    public final int component1() {
        return this.f15885a;
    }

    public final int component2() {
        return this.f15886b;
    }

    public final int component3() {
        return this.f15887c;
    }

    @NotNull
    public final UpgradeBlurbItem copy(@StringRes int i4, @StringRes int i5, @DrawableRes int i6) {
        return new UpgradeBlurbItem(i4, i5, i6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpgradeBlurbItem)) {
            return false;
        }
        UpgradeBlurbItem upgradeBlurbItem = (UpgradeBlurbItem) obj;
        if (this.f15885a == upgradeBlurbItem.f15885a && this.f15886b == upgradeBlurbItem.f15886b && this.f15887c == upgradeBlurbItem.f15887c) {
            return true;
        }
        return false;
    }

    public final int getDescription() {
        return this.f15886b;
    }

    public final int getImage() {
        return this.f15887c;
    }

    public final int getTitle() {
        return this.f15885a;
    }

    public int hashCode() {
        return (((this.f15885a * 31) + this.f15886b) * 31) + this.f15887c;
    }

    @NotNull
    public String toString() {
        int i4 = this.f15885a;
        int i5 = this.f15886b;
        int i6 = this.f15887c;
        return "UpgradeBlurbItem(title=" + i4 + ", description=" + i5 + ", image=" + i6 + ")";
    }
}
