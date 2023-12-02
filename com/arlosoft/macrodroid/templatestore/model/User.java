package com.arlosoft.macrodroid.templatestore.model;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.google.android.gms.location.places.Place;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: User.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class User {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String description;
    @NotNull
    private final String image;
    private final boolean isErrorUser;
    private final boolean isGuest;
    private final boolean isModerator;
    private final boolean isPirateUser;
    private final int numMacros;
    private final int rating;
    private final int totalUsers;
    private final int userId;
    private final int userRank;
    @NotNull
    private final String username;

    /* compiled from: User.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final User createErrorUser() {
            return new User(-1, null, null, 0, null, 0, 0, 0, false, false, Place.TYPE_SUBLOCALITY, null);
        }

        @NotNull
        public final User createPirateUser() {
            return new User(-10, null, null, 0, null, 0, 0, 0, false, false, Place.TYPE_SUBLOCALITY, null);
        }
    }

    public User() {
        this(0, null, null, 0, null, 0, 0, 0, false, false, Place.TYPE_SUBLOCALITY_LEVEL_1, null);
    }

    public static /* synthetic */ User copy$default(User user, int i4, String str, String str2, int i5, String str3, int i6, int i7, int i8, boolean z3, boolean z4, int i9, Object obj) {
        int i10;
        String str4;
        String str5;
        int i11;
        String str6;
        int i12;
        int i13;
        int i14;
        boolean z5;
        boolean z6;
        if ((i9 & 1) != 0) {
            i10 = user.userId;
        } else {
            i10 = i4;
        }
        if ((i9 & 2) != 0) {
            str4 = user.username;
        } else {
            str4 = str;
        }
        if ((i9 & 4) != 0) {
            str5 = user.description;
        } else {
            str5 = str2;
        }
        if ((i9 & 8) != 0) {
            i11 = user.rating;
        } else {
            i11 = i5;
        }
        if ((i9 & 16) != 0) {
            str6 = user.image;
        } else {
            str6 = str3;
        }
        if ((i9 & 32) != 0) {
            i12 = user.numMacros;
        } else {
            i12 = i6;
        }
        if ((i9 & 64) != 0) {
            i13 = user.userRank;
        } else {
            i13 = i7;
        }
        if ((i9 & 128) != 0) {
            i14 = user.totalUsers;
        } else {
            i14 = i8;
        }
        if ((i9 & 256) != 0) {
            z5 = user.isModerator;
        } else {
            z5 = z3;
        }
        if ((i9 & 512) != 0) {
            z6 = user.isGuest;
        } else {
            z6 = z4;
        }
        return user.copy(i10, str4, str5, i11, str6, i12, i13, i14, z5, z6);
    }

    public final int component1() {
        return this.userId;
    }

    public final boolean component10() {
        return this.isGuest;
    }

    @NotNull
    public final String component2() {
        return this.username;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    public final int component4() {
        return this.rating;
    }

    @NotNull
    public final String component5() {
        return this.image;
    }

    public final int component6() {
        return this.numMacros;
    }

    public final int component7() {
        return this.userRank;
    }

    public final int component8() {
        return this.totalUsers;
    }

    public final boolean component9() {
        return this.isModerator;
    }

    @NotNull
    public final User copy(int i4, @NotNull String username, @NotNull String description, int i5, @NotNull String image, int i6, int i7, int i8, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(image, "image");
        return new User(i4, username, description, i5, image, i6, i7, i8, z3, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        if (this.userId == user.userId && Intrinsics.areEqual(this.username, user.username) && Intrinsics.areEqual(this.description, user.description) && this.rating == user.rating && Intrinsics.areEqual(this.image, user.image) && this.numMacros == user.numMacros && this.userRank == user.userRank && this.totalUsers == user.totalUsers && this.isModerator == user.isModerator && this.isGuest == user.isGuest) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final int getNumMacros() {
        return this.numMacros;
    }

    public final int getRating() {
        return this.rating;
    }

    public final int getTotalUsers() {
        return this.totalUsers;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final int getUserRank() {
        return this.userRank;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.userId * 31) + this.username.hashCode()) * 31) + this.description.hashCode()) * 31) + this.rating) * 31) + this.image.hashCode()) * 31) + this.numMacros) * 31) + this.userRank) * 31) + this.totalUsers) * 31;
        boolean z3 = this.isModerator;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode + i5) * 31;
        boolean z4 = this.isGuest;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return i6 + i4;
    }

    public final boolean isCloudBackupOnly() {
        if (this.userId == -2) {
            return true;
        }
        return false;
    }

    public final boolean isErrorUser() {
        return this.isErrorUser;
    }

    public final boolean isGuest() {
        return this.isGuest;
    }

    public final boolean isModerator() {
        return this.isModerator;
    }

    public final boolean isPirateUser() {
        return this.isPirateUser;
    }

    public final boolean isValid() {
        boolean z3;
        String str = this.username;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        return !z3;
    }

    @NotNull
    public String toString() {
        int i4 = this.userId;
        String str = this.username;
        String str2 = this.description;
        int i5 = this.rating;
        String str3 = this.image;
        int i6 = this.numMacros;
        int i7 = this.userRank;
        int i8 = this.totalUsers;
        boolean z3 = this.isModerator;
        boolean z4 = this.isGuest;
        return "User(userId=" + i4 + ", username=" + str + ", description=" + str2 + ", rating=" + i5 + ", image=" + str3 + ", numMacros=" + i6 + ", userRank=" + i7 + ", totalUsers=" + i8 + ", isModerator=" + z3 + ", isGuest=" + z4 + ")";
    }

    public User(int i4, @NotNull String username, @NotNull String description, int i5, @NotNull String image, int i6, int i7, int i8, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(image, "image");
        this.userId = i4;
        this.username = username;
        this.description = description;
        this.rating = i5;
        this.image = image;
        this.numMacros = i6;
        this.userRank = i7;
        this.totalUsers = i8;
        this.isModerator = z3;
        this.isGuest = z4;
        this.isErrorUser = i4 == -1;
        this.isPirateUser = i4 == -10;
    }

    public /* synthetic */ User(int i4, String str, String str2, int i5, String str3, int i6, int i7, int i8, boolean z3, boolean z4, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? 0 : i4, (i9 & 2) != 0 ? "" : str, (i9 & 4) != 0 ? "" : str2, (i9 & 8) != 0 ? 0 : i5, (i9 & 16) == 0 ? str3 : "", (i9 & 32) != 0 ? 0 : i6, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) != 0 ? 0 : i8, (i9 & 256) != 0 ? false : z3, (i9 & 512) == 0 ? z4 : false);
    }
}
