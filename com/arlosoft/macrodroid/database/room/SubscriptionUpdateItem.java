package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SubscriptionUpdateItem.kt */
@StabilityInferred(parameters = 0)
@Entity(tableName = SubscriptionUpdateItem.TABLE_NAME)
/* loaded from: classes3.dex */
public final class SubscriptionUpdateItem {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "SubscriptionUpdateItem";
    @PrimaryKey(autoGenerate = true)

    /* renamed from: a  reason: collision with root package name */
    private final long f10851a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SubcriptionUpdateType f10852b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10853c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f10854d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f10855e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10856f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final String f10857g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f10858h;

    /* renamed from: i  reason: collision with root package name */
    private final long f10859i;

    /* compiled from: SubscriptionUpdateItem.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubscriptionUpdateItem(long j4, @NotNull SubcriptionUpdateType type, int i4, @NotNull String macroName, @NotNull String username, int i5, @NotNull String userImage, @NotNull String comment, long j5) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.f10851a = j4;
        this.f10852b = type;
        this.f10853c = i4;
        this.f10854d = macroName;
        this.f10855e = username;
        this.f10856f = i5;
        this.f10857g = userImage;
        this.f10858h = comment;
        this.f10859i = j5;
    }

    public static /* synthetic */ SubscriptionUpdateItem copy$default(SubscriptionUpdateItem subscriptionUpdateItem, long j4, SubcriptionUpdateType subcriptionUpdateType, int i4, String str, String str2, int i5, String str3, String str4, long j5, int i6, Object obj) {
        long j6;
        SubcriptionUpdateType subcriptionUpdateType2;
        int i7;
        String str5;
        String str6;
        int i8;
        String str7;
        String str8;
        long j7;
        if ((i6 & 1) != 0) {
            j6 = subscriptionUpdateItem.f10851a;
        } else {
            j6 = j4;
        }
        if ((i6 & 2) != 0) {
            subcriptionUpdateType2 = subscriptionUpdateItem.f10852b;
        } else {
            subcriptionUpdateType2 = subcriptionUpdateType;
        }
        if ((i6 & 4) != 0) {
            i7 = subscriptionUpdateItem.f10853c;
        } else {
            i7 = i4;
        }
        if ((i6 & 8) != 0) {
            str5 = subscriptionUpdateItem.f10854d;
        } else {
            str5 = str;
        }
        if ((i6 & 16) != 0) {
            str6 = subscriptionUpdateItem.f10855e;
        } else {
            str6 = str2;
        }
        if ((i6 & 32) != 0) {
            i8 = subscriptionUpdateItem.f10856f;
        } else {
            i8 = i5;
        }
        if ((i6 & 64) != 0) {
            str7 = subscriptionUpdateItem.f10857g;
        } else {
            str7 = str3;
        }
        if ((i6 & 128) != 0) {
            str8 = subscriptionUpdateItem.f10858h;
        } else {
            str8 = str4;
        }
        if ((i6 & 256) != 0) {
            j7 = subscriptionUpdateItem.f10859i;
        } else {
            j7 = j5;
        }
        return subscriptionUpdateItem.copy(j6, subcriptionUpdateType2, i7, str5, str6, i8, str7, str8, j7);
    }

    public final long component1() {
        return this.f10851a;
    }

    @NotNull
    public final SubcriptionUpdateType component2() {
        return this.f10852b;
    }

    public final int component3() {
        return this.f10853c;
    }

    @NotNull
    public final String component4() {
        return this.f10854d;
    }

    @NotNull
    public final String component5() {
        return this.f10855e;
    }

    public final int component6() {
        return this.f10856f;
    }

    @NotNull
    public final String component7() {
        return this.f10857g;
    }

    @NotNull
    public final String component8() {
        return this.f10858h;
    }

    public final long component9() {
        return this.f10859i;
    }

    @NotNull
    public final SubscriptionUpdateItem copy(long j4, @NotNull SubcriptionUpdateType type, int i4, @NotNull String macroName, @NotNull String username, int i5, @NotNull String userImage, @NotNull String comment, long j5) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        Intrinsics.checkNotNullParameter(comment, "comment");
        return new SubscriptionUpdateItem(j4, type, i4, macroName, username, i5, userImage, comment, j5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionUpdateItem)) {
            return false;
        }
        SubscriptionUpdateItem subscriptionUpdateItem = (SubscriptionUpdateItem) obj;
        if (this.f10851a == subscriptionUpdateItem.f10851a && this.f10852b == subscriptionUpdateItem.f10852b && this.f10853c == subscriptionUpdateItem.f10853c && Intrinsics.areEqual(this.f10854d, subscriptionUpdateItem.f10854d) && Intrinsics.areEqual(this.f10855e, subscriptionUpdateItem.f10855e) && this.f10856f == subscriptionUpdateItem.f10856f && Intrinsics.areEqual(this.f10857g, subscriptionUpdateItem.f10857g) && Intrinsics.areEqual(this.f10858h, subscriptionUpdateItem.f10858h) && this.f10859i == subscriptionUpdateItem.f10859i) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getComment() {
        return this.f10858h;
    }

    public final long getId() {
        return this.f10851a;
    }

    public final int getMacroId() {
        return this.f10853c;
    }

    @NotNull
    public final String getMacroName() {
        return this.f10854d;
    }

    public final long getTimestamp() {
        return this.f10859i;
    }

    @NotNull
    public final SubcriptionUpdateType getType() {
        return this.f10852b;
    }

    public final int getUserId() {
        return this.f10856f;
    }

    @NotNull
    public final String getUserImage() {
        return this.f10857g;
    }

    @NotNull
    public final String getUsername() {
        return this.f10855e;
    }

    public int hashCode() {
        return (((((((((((((((androidx.compose.animation.a.a(this.f10851a) * 31) + this.f10852b.hashCode()) * 31) + this.f10853c) * 31) + this.f10854d.hashCode()) * 31) + this.f10855e.hashCode()) * 31) + this.f10856f) * 31) + this.f10857g.hashCode()) * 31) + this.f10858h.hashCode()) * 31) + androidx.compose.animation.a.a(this.f10859i);
    }

    @NotNull
    public String toString() {
        long j4 = this.f10851a;
        SubcriptionUpdateType subcriptionUpdateType = this.f10852b;
        int i4 = this.f10853c;
        String str = this.f10854d;
        String str2 = this.f10855e;
        int i5 = this.f10856f;
        String str3 = this.f10857g;
        String str4 = this.f10858h;
        long j5 = this.f10859i;
        return "SubscriptionUpdateItem(id=" + j4 + ", type=" + subcriptionUpdateType + ", macroId=" + i4 + ", macroName=" + str + ", username=" + str2 + ", userId=" + i5 + ", userImage=" + str3 + ", comment=" + str4 + ", timestamp=" + j5 + ")";
    }

    public /* synthetic */ SubscriptionUpdateItem(long j4, SubcriptionUpdateType subcriptionUpdateType, int i4, String str, String str2, int i5, String str3, String str4, long j5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 0L : j4, subcriptionUpdateType, i4, str, str2, i5, str3, str4, j5);
    }
}
