package com.arlosoft.macrodroid.database;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextData.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FloatingTextData {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f10755a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10756b;

    /* renamed from: c  reason: collision with root package name */
    private final float f10757c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10758d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10759e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10760f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10761g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10762h;

    /* renamed from: i  reason: collision with root package name */
    private final int f10763i;

    /* renamed from: j  reason: collision with root package name */
    private final int f10764j;

    /* renamed from: k  reason: collision with root package name */
    private final int f10765k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f10766l;

    /* renamed from: m  reason: collision with root package name */
    private final long f10767m;

    /* renamed from: n  reason: collision with root package name */
    private final long f10768n;

    /* renamed from: o  reason: collision with root package name */
    private final long f10769o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f10770p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f10771q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f10772r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private final TriggerContextInfo f10773s;

    public FloatingTextData(@NotNull String id, @NotNull String text, float f4, float f5, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3, long j4, long j5, long j6, boolean z4, boolean z5, boolean z6, @Nullable TriggerContextInfo triggerContextInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        this.f10755a = id;
        this.f10756b = text;
        this.f10757c = f4;
        this.f10758d = f5;
        this.f10759e = i4;
        this.f10760f = i5;
        this.f10761g = i6;
        this.f10762h = i7;
        this.f10763i = i8;
        this.f10764j = i9;
        this.f10765k = i10;
        this.f10766l = z3;
        this.f10767m = j4;
        this.f10768n = j5;
        this.f10769o = j6;
        this.f10770p = z4;
        this.f10771q = z5;
        this.f10772r = z6;
        this.f10773s = triggerContextInfo;
    }

    @NotNull
    public final String component1() {
        return this.f10755a;
    }

    public final int component10() {
        return this.f10764j;
    }

    public final int component11() {
        return this.f10765k;
    }

    public final boolean component12() {
        return this.f10766l;
    }

    public final long component13() {
        return this.f10767m;
    }

    public final long component14() {
        return this.f10768n;
    }

    public final long component15() {
        return this.f10769o;
    }

    public final boolean component16() {
        return this.f10770p;
    }

    public final boolean component17() {
        return this.f10771q;
    }

    public final boolean component18() {
        return this.f10772r;
    }

    @Nullable
    public final TriggerContextInfo component19() {
        return this.f10773s;
    }

    @NotNull
    public final String component2() {
        return this.f10756b;
    }

    public final float component3() {
        return this.f10757c;
    }

    public final float component4() {
        return this.f10758d;
    }

    public final int component5() {
        return this.f10759e;
    }

    public final int component6() {
        return this.f10760f;
    }

    public final int component7() {
        return this.f10761g;
    }

    public final int component8() {
        return this.f10762h;
    }

    public final int component9() {
        return this.f10763i;
    }

    @NotNull
    public final FloatingTextData copy(@NotNull String id, @NotNull String text, float f4, float f5, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3, long j4, long j5, long j6, boolean z4, boolean z5, boolean z6, @Nullable TriggerContextInfo triggerContextInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        return new FloatingTextData(id, text, f4, f5, i4, i5, i6, i7, i8, i9, i10, z3, j4, j5, j6, z4, z5, z6, triggerContextInfo);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatingTextData)) {
            return false;
        }
        FloatingTextData floatingTextData = (FloatingTextData) obj;
        if (Intrinsics.areEqual(this.f10755a, floatingTextData.f10755a) && Intrinsics.areEqual(this.f10756b, floatingTextData.f10756b) && Float.compare(this.f10757c, floatingTextData.f10757c) == 0 && Float.compare(this.f10758d, floatingTextData.f10758d) == 0 && this.f10759e == floatingTextData.f10759e && this.f10760f == floatingTextData.f10760f && this.f10761g == floatingTextData.f10761g && this.f10762h == floatingTextData.f10762h && this.f10763i == floatingTextData.f10763i && this.f10764j == floatingTextData.f10764j && this.f10765k == floatingTextData.f10765k && this.f10766l == floatingTextData.f10766l && this.f10767m == floatingTextData.f10767m && this.f10768n == floatingTextData.f10768n && this.f10769o == floatingTextData.f10769o && this.f10770p == floatingTextData.f10770p && this.f10771q == floatingTextData.f10771q && this.f10772r == floatingTextData.f10772r && Intrinsics.areEqual(this.f10773s, floatingTextData.f10773s)) {
            return true;
        }
        return false;
    }

    public final int getAlignemnt() {
        return this.f10764j;
    }

    public final int getAlpha() {
        return this.f10765k;
    }

    public final long getAutoHideDelay() {
        return this.f10768n;
    }

    public final int getBgColor() {
        return this.f10760f;
    }

    public final int getCorners() {
        return this.f10763i;
    }

    public final long getDisplayedTimestamp() {
        return this.f10769o;
    }

    public final boolean getHtmlFormatting() {
        return this.f10770p;
    }

    @NotNull
    public final String getId() {
        return this.f10755a;
    }

    public final long getMacroId() {
        return this.f10767m;
    }

    public final int getPadding() {
        return this.f10762h;
    }

    public final boolean getPreventRemoveByDrag() {
        return this.f10772r;
    }

    public final boolean getShowOverStatusBar() {
        return this.f10771q;
    }

    @NotNull
    public final String getText() {
        return this.f10756b;
    }

    public final int getTextColor() {
        return this.f10759e;
    }

    public final int getTextSize() {
        return this.f10761g;
    }

    @Nullable
    public final TriggerContextInfo getTriggerContextInfo() {
        return this.f10773s;
    }

    public final float getXPosition() {
        return this.f10757c;
    }

    public final float getYPosition() {
        return this.f10758d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((((((((((this.f10755a.hashCode() * 31) + this.f10756b.hashCode()) * 31) + Float.floatToIntBits(this.f10757c)) * 31) + Float.floatToIntBits(this.f10758d)) * 31) + this.f10759e) * 31) + this.f10760f) * 31) + this.f10761g) * 31) + this.f10762h) * 31) + this.f10763i) * 31) + this.f10764j) * 31) + this.f10765k) * 31;
        boolean z3 = this.f10766l;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int a4 = (((((((hashCode2 + i5) * 31) + androidx.compose.animation.a.a(this.f10767m)) * 31) + androidx.compose.animation.a.a(this.f10768n)) * 31) + androidx.compose.animation.a.a(this.f10769o)) * 31;
        boolean z4 = this.f10770p;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (a4 + i6) * 31;
        boolean z5 = this.f10771q;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z6 = this.f10772r;
        if (!z6) {
            i4 = z6 ? 1 : 0;
        }
        int i10 = (i9 + i4) * 31;
        TriggerContextInfo triggerContextInfo = this.f10773s;
        if (triggerContextInfo == null) {
            hashCode = 0;
        } else {
            hashCode = triggerContextInfo.hashCode();
        }
        return i10 + hashCode;
    }

    public final boolean isVisible() {
        return this.f10766l;
    }

    @NotNull
    public String toString() {
        String str = this.f10755a;
        String str2 = this.f10756b;
        float f4 = this.f10757c;
        float f5 = this.f10758d;
        int i4 = this.f10759e;
        int i5 = this.f10760f;
        int i6 = this.f10761g;
        int i7 = this.f10762h;
        int i8 = this.f10763i;
        int i9 = this.f10764j;
        int i10 = this.f10765k;
        boolean z3 = this.f10766l;
        long j4 = this.f10767m;
        long j5 = this.f10768n;
        long j6 = this.f10769o;
        boolean z4 = this.f10770p;
        boolean z5 = this.f10771q;
        boolean z6 = this.f10772r;
        TriggerContextInfo triggerContextInfo = this.f10773s;
        return "FloatingTextData(id=" + str + ", text=" + str2 + ", xPosition=" + f4 + ", yPosition=" + f5 + ", textColor=" + i4 + ", bgColor=" + i5 + ", textSize=" + i6 + ", padding=" + i7 + ", corners=" + i8 + ", alignemnt=" + i9 + ", alpha=" + i10 + ", isVisible=" + z3 + ", macroId=" + j4 + ", autoHideDelay=" + j5 + ", displayedTimestamp=" + j6 + ", htmlFormatting=" + z4 + ", showOverStatusBar=" + z5 + ", preventRemoveByDrag=" + z6 + ", triggerContextInfo=" + triggerContextInfo + ")";
    }
}
