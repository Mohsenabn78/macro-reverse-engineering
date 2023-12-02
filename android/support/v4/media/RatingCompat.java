package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;

    /* renamed from: a */
    private final int f280a;

    /* renamed from: b */
    private final float f281b;

    /* renamed from: c */
    private Object f282c;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Style {
    }

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RatingCompat[] newArray(int i4) {
            return new RatingCompat[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(19)
    /* loaded from: classes.dex */
    public static class b {
        @DoNotInline
        static float a(Rating rating) {
            return rating.getPercentRating();
        }

        @DoNotInline
        static int b(Rating rating) {
            return rating.getRatingStyle();
        }

        @DoNotInline
        static float c(Rating rating) {
            return rating.getStarRating();
        }

        @DoNotInline
        static boolean d(Rating rating) {
            return rating.hasHeart();
        }

        @DoNotInline
        static boolean e(Rating rating) {
            return rating.isRated();
        }

        @DoNotInline
        static boolean f(Rating rating) {
            return rating.isThumbUp();
        }

        @DoNotInline
        static Rating g(boolean z3) {
            return Rating.newHeartRating(z3);
        }

        @DoNotInline
        static Rating h(float f4) {
            return Rating.newPercentageRating(f4);
        }

        @DoNotInline
        static Rating i(int i4, float f4) {
            return Rating.newStarRating(i4, f4);
        }

        @DoNotInline
        static Rating j(boolean z3) {
            return Rating.newThumbRating(z3);
        }

        @DoNotInline
        static Rating k(int i4) {
            return Rating.newUnratedRating(i4);
        }
    }

    RatingCompat(int i4, float f4) {
        this.f280a = i4;
        this.f281b = f4;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int b4 = b.b(rating);
            if (b.e(rating)) {
                switch (b4) {
                    case 1:
                        ratingCompat = newHeartRating(b.d(rating));
                        break;
                    case 2:
                        ratingCompat = newThumbRating(b.f(rating));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompat = newStarRating(b4, b.c(rating));
                        break;
                    case 6:
                        ratingCompat = newPercentageRating(b.a(rating));
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompat = newUnratedRating(b4);
            }
            ratingCompat.f282c = obj;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean z3) {
        float f4;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        return new RatingCompat(1, f4);
    }

    public static RatingCompat newPercentageRating(float f4) {
        if (f4 >= 0.0f && f4 <= 100.0f) {
            return new RatingCompat(6, f4);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int i4, float f4) {
        float f5;
        if (i4 != 3) {
            if (i4 != 4) {
                if (i4 != 5) {
                    Log.e("Rating", "Invalid rating style (" + i4 + ") for a star rating");
                    return null;
                }
                f5 = 5.0f;
            } else {
                f5 = 4.0f;
            }
        } else {
            f5 = 3.0f;
        }
        if (f4 >= 0.0f && f4 <= f5) {
            return new RatingCompat(i4, f4);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean z3) {
        float f4;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        return new RatingCompat(2, f4);
    }

    public static RatingCompat newUnratedRating(int i4) {
        switch (i4) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i4, -1.0f);
            default:
                return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f280a;
    }

    public float getPercentRating() {
        if (this.f280a == 6 && isRated()) {
            return this.f281b;
        }
        return -1.0f;
    }

    public Object getRating() {
        if (this.f282c == null) {
            if (isRated()) {
                int i4 = this.f280a;
                switch (i4) {
                    case 1:
                        this.f282c = b.g(hasHeart());
                        break;
                    case 2:
                        this.f282c = b.j(isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f282c = b.i(i4, getStarRating());
                        break;
                    case 6:
                        this.f282c = b.h(getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f282c = b.k(this.f280a);
            }
        }
        return this.f282c;
    }

    public int getRatingStyle() {
        return this.f280a;
    }

    public float getStarRating() {
        int i4 = this.f280a;
        if ((i4 == 3 || i4 == 4 || i4 == 5) && isRated()) {
            return this.f281b;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        if (this.f280a != 1 || this.f281b != 1.0f) {
            return false;
        }
        return true;
    }

    public boolean isRated() {
        if (this.f281b >= 0.0f) {
            return true;
        }
        return false;
    }

    public boolean isThumbUp() {
        if (this.f280a != 2 || this.f281b != 1.0f) {
            return false;
        }
        return true;
    }

    public String toString() {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f280a);
        sb.append(" rating=");
        float f4 = this.f281b;
        if (f4 < 0.0f) {
            valueOf = "unrated";
        } else {
            valueOf = String.valueOf(f4);
        }
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f280a);
        parcel.writeFloat(this.f281b);
    }
}
