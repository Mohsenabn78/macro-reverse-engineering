package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* loaded from: classes6.dex */
public class ColorPreference extends Preference implements ColorPickerDialogListener {

    /* renamed from: a  reason: collision with root package name */
    private OnShowDialogListener f34541a;

    /* renamed from: b  reason: collision with root package name */
    private int f34542b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34543c;
    @ColorPickerDialog.DialogType

    /* renamed from: d  reason: collision with root package name */
    private int f34544d;

    /* renamed from: e  reason: collision with root package name */
    private int f34545e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34546f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34547g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34548h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f34549i;

    /* renamed from: j  reason: collision with root package name */
    private int f34550j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f34551k;

    /* renamed from: l  reason: collision with root package name */
    private int f34552l;

    /* loaded from: classes6.dex */
    public interface OnShowDialogListener {
        void onShowColorPickerDialog(String str, int i4);
    }

    public ColorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34542b = -16777216;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        int i4;
        int i5;
        setPersistent(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPreference);
        this.f34543c = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showDialog, true);
        this.f34544d = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_dialogType, 1);
        this.f34545e = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_colorShape, 1);
        this.f34546f = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_allowPresets, true);
        this.f34547g = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_allowCustom, true);
        this.f34548h = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showAlphaSlider, false);
        this.f34549i = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showColorShades, true);
        this.f34550j = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_previewSize, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ColorPreference_cpv_colorPresets, 0);
        this.f34552l = obtainStyledAttributes.getResourceId(R.styleable.ColorPreference_cpv_dialogTitle, R.string.cpv_default_title);
        if (resourceId != 0) {
            this.f34551k = getContext().getResources().getIntArray(resourceId);
        } else {
            this.f34551k = ColorPickerDialog.MATERIAL_COLORS;
        }
        if (this.f34545e == 1) {
            if (this.f34550j == 1) {
                i5 = R.layout.cpv_preference_circle_large;
            } else {
                i5 = R.layout.cpv_preference_circle;
            }
            setWidgetLayoutResource(i5);
        } else {
            if (this.f34550j == 1) {
                i4 = R.layout.cpv_preference_square_large;
            } else {
                i4 = R.layout.cpv_preference_square;
            }
            setWidgetLayoutResource(i4);
        }
        obtainStyledAttributes.recycle();
    }

    public String getFragmentTag() {
        return "color_" + getKey();
    }

    public int[] getPresets() {
        return this.f34551k;
    }

    @Override // android.preference.Preference
    protected void onAttachedToActivity() {
        ColorPickerDialog colorPickerDialog;
        super.onAttachedToActivity();
        if (this.f34543c && (colorPickerDialog = (ColorPickerDialog) ((FragmentActivity) getContext()).getSupportFragmentManager().findFragmentByTag(getFragmentTag())) != null) {
            colorPickerDialog.setColorPickerDialogListener(this);
        }
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        ColorPanelView colorPanelView = (ColorPanelView) view.findViewById(R.id.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.f34542b);
        }
    }

    @Override // android.preference.Preference
    protected void onClick() {
        super.onClick();
        OnShowDialogListener onShowDialogListener = this.f34541a;
        if (onShowDialogListener != null) {
            onShowDialogListener.onShowColorPickerDialog((String) getTitle(), this.f34542b);
        } else if (this.f34543c) {
            ColorPickerDialog create = ColorPickerDialog.newBuilder().setDialogType(this.f34544d).setDialogTitle(this.f34552l).setColorShape(this.f34545e).setPresets(this.f34551k).setAllowPresets(this.f34546f).setAllowCustom(this.f34547g).setShowAlphaSlider(this.f34548h).setShowColorShades(this.f34549i).setColor(this.f34542b).create();
            create.setColorPickerDialogListener(this);
            ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction().add(create, getFragmentTag()).commitAllowingStateLoss();
        }
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onColorSelected(int i4, @ColorInt int i5) {
        saveValue(i5);
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInteger(i4, -16777216));
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z3, Object obj) {
        if (z3) {
            this.f34542b = getPersistedInt(-16777216);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        this.f34542b = intValue;
        persistInt(intValue);
    }

    public void saveValue(@ColorInt int i4) {
        this.f34542b = i4;
        persistInt(i4);
        notifyChanged();
        callChangeListener(Integer.valueOf(i4));
    }

    public void setOnShowDialogListener(OnShowDialogListener onShowDialogListener) {
        this.f34541a = onShowDialogListener;
    }

    public void setPresets(@NonNull int[] iArr) {
        this.f34551k = iArr;
    }

    public ColorPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34542b = -16777216;
        a(attributeSet);
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onDialogDismissed(int i4) {
    }
}
