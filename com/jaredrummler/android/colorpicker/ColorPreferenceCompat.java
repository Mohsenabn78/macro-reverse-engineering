package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* loaded from: classes6.dex */
public class ColorPreferenceCompat extends Preference implements ColorPickerDialogListener {

    /* renamed from: a  reason: collision with root package name */
    private OnShowDialogListener f34553a;

    /* renamed from: b  reason: collision with root package name */
    private int f34554b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34555c;
    @ColorPickerDialog.DialogType

    /* renamed from: d  reason: collision with root package name */
    private int f34556d;

    /* renamed from: e  reason: collision with root package name */
    private int f34557e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f34558f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34559g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f34560h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f34561i;

    /* renamed from: j  reason: collision with root package name */
    private int f34562j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f34563k;

    /* renamed from: l  reason: collision with root package name */
    private int f34564l;

    /* loaded from: classes6.dex */
    public interface OnShowDialogListener {
        void onShowColorPickerDialog(String str, int i4);
    }

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34554b = -16777216;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        int i4;
        int i5;
        setPersistent(true);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPreference);
        this.f34555c = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showDialog, true);
        this.f34556d = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_dialogType, 1);
        this.f34557e = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_colorShape, 1);
        this.f34558f = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_allowPresets, true);
        this.f34559g = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_allowCustom, true);
        this.f34560h = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showAlphaSlider, false);
        this.f34561i = obtainStyledAttributes.getBoolean(R.styleable.ColorPreference_cpv_showColorShades, true);
        this.f34562j = obtainStyledAttributes.getInt(R.styleable.ColorPreference_cpv_previewSize, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ColorPreference_cpv_colorPresets, 0);
        this.f34564l = obtainStyledAttributes.getResourceId(R.styleable.ColorPreference_cpv_dialogTitle, R.string.cpv_default_title);
        if (resourceId != 0) {
            this.f34563k = getContext().getResources().getIntArray(resourceId);
        } else {
            this.f34563k = ColorPickerDialog.MATERIAL_COLORS;
        }
        if (this.f34557e == 1) {
            if (this.f34562j == 1) {
                i5 = R.layout.cpv_preference_circle_large;
            } else {
                i5 = R.layout.cpv_preference_circle;
            }
            setWidgetLayoutResource(i5);
        } else {
            if (this.f34562j == 1) {
                i4 = R.layout.cpv_preference_square_large;
            } else {
                i4 = R.layout.cpv_preference_square;
            }
            setWidgetLayoutResource(i4);
        }
        obtainStyledAttributes.recycle();
    }

    public FragmentActivity getActivity() {
        Context context = getContext();
        if (context instanceof FragmentActivity) {
            return (FragmentActivity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof FragmentActivity) {
                return (FragmentActivity) baseContext;
            }
        }
        throw new IllegalStateException("Error getting activity from context");
    }

    public String getFragmentTag() {
        return "color_" + getKey();
    }

    public int[] getPresets() {
        return this.f34563k;
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        ColorPickerDialog colorPickerDialog;
        super.onAttached();
        if (this.f34555c && (colorPickerDialog = (ColorPickerDialog) getActivity().getSupportFragmentManager().findFragmentByTag(getFragmentTag())) != null) {
            colorPickerDialog.setColorPickerDialogListener(this);
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        super.onBindViewHolder(preferenceViewHolder);
        ColorPanelView colorPanelView = (ColorPanelView) preferenceViewHolder.itemView.findViewById(R.id.cpv_preference_preview_color_panel);
        if (colorPanelView != null) {
            colorPanelView.setColor(this.f34554b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onClick() {
        super.onClick();
        OnShowDialogListener onShowDialogListener = this.f34553a;
        if (onShowDialogListener != null) {
            onShowDialogListener.onShowColorPickerDialog((String) getTitle(), this.f34554b);
        } else if (this.f34555c) {
            ColorPickerDialog create = ColorPickerDialog.newBuilder().setDialogType(this.f34556d).setDialogTitle(this.f34564l).setColorShape(this.f34557e).setPresets(this.f34563k).setAllowPresets(this.f34558f).setAllowCustom(this.f34559g).setShowAlphaSlider(this.f34560h).setShowColorShades(this.f34561i).setColor(this.f34554b).create();
            create.setColorPickerDialogListener(this);
            getActivity().getSupportFragmentManager().beginTransaction().add(create, getFragmentTag()).commitAllowingStateLoss();
        }
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onColorSelected(int i4, @ColorInt int i5) {
        saveValue(i5);
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i4) {
        return Integer.valueOf(typedArray.getInteger(i4, -16777216));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onSetInitialValue(Object obj) {
        super.onSetInitialValue(obj);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.f34554b = intValue;
            persistInt(intValue);
            return;
        }
        this.f34554b = getPersistedInt(-16777216);
    }

    public void saveValue(@ColorInt int i4) {
        this.f34554b = i4;
        persistInt(i4);
        notifyChanged();
        callChangeListener(Integer.valueOf(i4));
    }

    public void setOnShowDialogListener(OnShowDialogListener onShowDialogListener) {
        this.f34553a = onShowDialogListener;
    }

    public void setPresets(@NonNull int[] iArr) {
        this.f34563k = iArr;
    }

    public ColorPreferenceCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f34554b = -16777216;
        a(attributeSet);
    }

    @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
    public void onDialogDismissed(int i4) {
    }
}
