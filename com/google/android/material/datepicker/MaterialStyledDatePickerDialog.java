package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP, RestrictTo.Scope.TESTS})
/* loaded from: classes5.dex */
public class MaterialStyledDatePickerDialog extends DatePickerDialog {
    @StyleRes

    /* renamed from: c  reason: collision with root package name */
    private static final int f23523c = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f23524a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f23525b;

    public MaterialStyledDatePickerDialog(@NonNull Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f23524a);
        getWindow().getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(this, this.f23525b));
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i4) {
        this(context, i4, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i4, int i5, int i6) {
        this(context, 0, onDateSetListener, i4, i5, i6);
    }

    public MaterialStyledDatePickerDialog(@NonNull Context context, int i4, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener, int i5, int i6, int i7) {
        super(context, i4, onDateSetListener, i5, i6, i7);
        Context context2 = getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i8 = f23523c;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, 16843612, i8);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Rect dialogBackgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, 16843612, i8);
        this.f23525b = dialogBackgroundInsets;
        this.f23524a = MaterialDialogs.insetDrawable(materialShapeDrawable, dialogBackgroundInsets);
    }
}
