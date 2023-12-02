package com.takisoft.preferencex;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes6.dex */
public class PreferenceCategory extends androidx.preference.PreferenceCategory {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f37965c = {R.attr.colorAccent};

    /* renamed from: a  reason: collision with root package name */
    protected int f37966a;

    /* renamed from: b  reason: collision with root package name */
    protected View f37967b;

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceCategory, i4, 0);
        this.f37966a = obtainStyledAttributes.getColor(R.styleable.PreferenceCategory_pref_categoryColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void a(View view, boolean z3) {
        boolean z4;
        RecyclerView.LayoutParams layoutParams;
        if (view == null) {
            return;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (view.getTag() != null && ((ViewGroup.MarginLayoutParams) layoutParams2).width == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (view.getTag() == null) {
            layoutParams = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
            view.setTag(layoutParams);
        } else {
            layoutParams = (RecyclerView.LayoutParams) view.getTag();
        }
        if (z3) {
            if (view.getVisibility() == 8 || z4) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                view.setVisibility(0);
            }
        } else if (view.getVisibility() == 0 || !z4) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
            view.setVisibility(8);
        }
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        this.f37967b = preferenceViewHolder.itemView;
        TextView textView = (TextView) preferenceViewHolder.findViewById(16908310);
        if (textView != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f37965c);
            if (obtainStyledAttributes.length() > 0 && obtainStyledAttributes.getIndexCount() > 0) {
                int color = obtainStyledAttributes.getColor(obtainStyledAttributes.getIndex(0), 16728193);
                int i4 = this.f37966a;
                if (i4 != 0) {
                    color = i4;
                }
                textView.setTextColor(color);
            }
            obtainStyledAttributes.recycle();
        }
        a(preferenceViewHolder.itemView, !TextUtils.isEmpty(getTitle()));
    }

    public void setColor(@ColorInt int i4) {
        this.f37966a = i4;
    }

    public void setColorResource(@ColorRes int i4) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = getContext().getColor(i4);
        } else {
            color = getContext().getResources().getColor(i4);
        }
        setColor(color);
    }

    @Override // androidx.preference.Preference
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a(this.f37967b, !TextUtils.isEmpty(getTitle()));
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public PreferenceCategory(Context context) {
        this(context, null);
    }
}
