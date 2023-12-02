package com.arlosoft.macrodroid.database.room;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserSubscription.kt */
@StabilityInferred(parameters = 0)
@Entity(tableName = UserSubscription.TABLE_NAME)
/* loaded from: classes3.dex */
public final class UserSubscription {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TABLE_NAME = "UserSubscription";
    @PrimaryKey

    /* renamed from: a  reason: collision with root package name */
    private final int f10908a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f10909b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f10910c;

    /* compiled from: UserSubscription.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UserSubscription(int i4, @NotNull String userName, @NotNull String userImage) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        this.f10908a = i4;
        this.f10909b = userName;
        this.f10910c = userImage;
    }

    public static /* synthetic */ UserSubscription copy$default(UserSubscription userSubscription, int i4, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = userSubscription.f10908a;
        }
        if ((i5 & 2) != 0) {
            str = userSubscription.f10909b;
        }
        if ((i5 & 4) != 0) {
            str2 = userSubscription.f10910c;
        }
        return userSubscription.copy(i4, str, str2);
    }

    public final int component1() {
        return this.f10908a;
    }

    @NotNull
    public final String component2() {
        return this.f10909b;
    }

    @NotNull
    public final String component3() {
        return this.f10910c;
    }

    @NotNull
    public final UserSubscription copy(int i4, @NotNull String userName, @NotNull String userImage) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        return new UserSubscription(i4, userName, userImage);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserSubscription)) {
            return false;
        }
        UserSubscription userSubscription = (UserSubscription) obj;
        if (this.f10908a == userSubscription.f10908a && Intrinsics.areEqual(this.f10909b, userSubscription.f10909b) && Intrinsics.areEqual(this.f10910c, userSubscription.f10910c)) {
            return true;
        }
        return false;
    }

    public final int getUserId() {
        return this.f10908a;
    }

    @NotNull
    public final String getUserImage() {
        return this.f10910c;
    }

    @NotNull
    public final String getUserName() {
        return this.f10909b;
    }

    public int hashCode() {
        return (((this.f10908a * 31) + this.f10909b.hashCode()) * 31) + this.f10910c.hashCode();
    }

    @NotNull
    public String toString() {
        int i4 = this.f10908a;
        String str = this.f10909b;
        String str2 = this.f10910c;
        return "UserSubscription(userId=" + i4 + ", userName=" + str + ", userImage=" + str2 + ")";
    }
}
