package com.takisoft.preferencex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.preference.PreferenceViewHolder;

/* loaded from: classes6.dex */
public class SwitchPreferenceCompat extends androidx.preference.SwitchPreferenceCompat {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f37981d = {androidx.appcompat.R.attr.controlBackground, R.attr.colorControlNormal};

    /* renamed from: a  reason: collision with root package name */
    private final View.OnClickListener f37982a;

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f37983b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37984c;

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @SuppressLint({"RestrictedApi"})
        public void onClick(View view) {
            SwitchPreferenceCompat.this.performClick((View) view.getParent());
        }
    }

    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z3 = !SwitchPreferenceCompat.this.isChecked();
            if (SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z3))) {
                SwitchPreferenceCompat.this.setChecked(z3);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f37982a = new a();
        this.f37983b = new b();
        this.f37984c = false;
        c(false);
    }

    private void c(boolean z3) {
        boolean z4;
        if (getFragment() != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (d(z4) && z3) {
            notifyHierarchyChanged();
        }
    }

    private boolean d(boolean z3) {
        if (this.f37984c == z3) {
            return false;
        }
        this.f37984c = z3;
        if (z3) {
            setLayoutResource(R.layout.preference_material_ext);
            return true;
        }
        setLayoutResource(androidx.preference.R.layout.preference_material);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (!this.f37984c) {
            return;
        }
        boolean persistedBoolean = getPersistedBoolean(false);
        boolean isPersistent = isPersistent();
        setPersistent(false);
        setChecked(persistedBoolean);
        setPersistent(isPersistent);
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        if (this.f37984c) {
            preferenceViewHolder.findViewById(16908312).setOnClickListener(this.f37983b);
            preferenceViewHolder.findViewById(R.id.pref_content_frame).setOnClickListener(this.f37982a);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f37981d);
            if (obtainStyledAttributes.length() > 0 && obtainStyledAttributes.getIndexCount() > 0) {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId != 0) {
                    preferenceViewHolder.findViewById(androidx.preference.R.id.switchWidget).setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), resourceId));
                }
                ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
                if (colorStateList != null) {
                    preferenceViewHolder.findViewById(R.id.pref_separator).setBackgroundColor(colorStateList.getColorForState(isEnabled() ? new int[]{16842910} : new int[]{-16842910}, colorStateList.getDefaultColor()));
                }
            }
            obtainStyledAttributes.recycle();
        }
        preferenceViewHolder.itemView.setClickable(!this.f37984c);
        preferenceViewHolder.itemView.setFocusable(!this.f37984c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        if (!this.f37984c) {
            super.onClick();
        }
    }

    @Override // androidx.preference.Preference
    public void setFragment(String str) {
        super.setFragment(str);
        c(true);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f37982a = new a();
        this.f37983b = new b();
        this.f37984c = false;
        c(false);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37982a = new a();
        this.f37983b = new b();
        this.f37984c = false;
        c(false);
    }

    public SwitchPreferenceCompat(Context context) {
        super(context);
        this.f37982a = new a();
        this.f37983b = new b();
        this.f37984c = false;
        c(false);
    }
}
