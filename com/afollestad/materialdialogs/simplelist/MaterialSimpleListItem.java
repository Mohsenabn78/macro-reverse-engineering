package com.afollestad.materialdialogs.simplelist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.util.DialogUtils;

/* loaded from: classes2.dex */
public class MaterialSimpleListItem {

    /* renamed from: a  reason: collision with root package name */
    private final Builder f1195a;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1196a;

        /* renamed from: b  reason: collision with root package name */
        protected Drawable f1197b;

        /* renamed from: c  reason: collision with root package name */
        protected CharSequence f1198c;

        /* renamed from: d  reason: collision with root package name */
        protected long f1199d;

        /* renamed from: e  reason: collision with root package name */
        int f1200e;

        /* renamed from: f  reason: collision with root package name */
        int f1201f = Color.parseColor("#BCBCBC");

        /* renamed from: g  reason: collision with root package name */
        Object f1202g;

        public Builder(Context context) {
            this.f1196a = context;
        }

        public Builder backgroundColor(@ColorInt int i4) {
            this.f1201f = i4;
            return this;
        }

        public Builder backgroundColorAttr(@AttrRes int i4) {
            return backgroundColor(DialogUtils.resolveColor(this.f1196a, i4));
        }

        public Builder backgroundColorRes(@ColorRes int i4) {
            return backgroundColor(DialogUtils.getColor(this.f1196a, i4));
        }

        public MaterialSimpleListItem build() {
            return new MaterialSimpleListItem(this);
        }

        public Builder content(CharSequence charSequence) {
            this.f1198c = charSequence;
            return this;
        }

        public Builder icon(Drawable drawable) {
            this.f1197b = drawable;
            return this;
        }

        public Builder iconPadding(@IntRange(from = 0, to = 2147483647L) int i4) {
            this.f1200e = i4;
            return this;
        }

        public Builder iconPaddingDp(@IntRange(from = 0, to = 2147483647L) int i4) {
            this.f1200e = (int) TypedValue.applyDimension(1, i4, this.f1196a.getResources().getDisplayMetrics());
            return this;
        }

        public Builder iconPaddingRes(@DimenRes int i4) {
            return iconPadding(this.f1196a.getResources().getDimensionPixelSize(i4));
        }

        public Builder id(long j4) {
            this.f1199d = j4;
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            this.f1202g = obj;
            return this;
        }

        public Builder content(@StringRes int i4) {
            return content(this.f1196a.getString(i4));
        }

        public Builder icon(@DrawableRes int i4) {
            return icon(ContextCompat.getDrawable(this.f1196a, i4));
        }
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.f1195a.f1201f;
    }

    public CharSequence getContent() {
        return this.f1195a.f1198c;
    }

    public Drawable getIcon() {
        return this.f1195a.f1197b;
    }

    public int getIconPadding() {
        return this.f1195a.f1200e;
    }

    public long getId() {
        return this.f1195a.f1199d;
    }

    @Nullable
    public Object getTag() {
        return this.f1195a.f1202g;
    }

    public String toString() {
        if (getContent() != null) {
            return getContent().toString();
        }
        return "(no content)";
    }

    private MaterialSimpleListItem(Builder builder) {
        this.f1195a = builder;
    }
}
