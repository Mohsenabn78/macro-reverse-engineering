package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.R;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() { // from class: com.google.android.material.datepicker.RangeDateSelector.3
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.f23555c = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.f23556d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public RangeDateSelector[] newArray(int i4) {
            return new RangeDateSelector[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f23553a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23554b = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Long f23555c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Long f23556d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Long f23557e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Long f23558f = null;

    private void f(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f23553a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() != null && MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR.contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError(null);
        }
    }

    private boolean g(long j4, long j5) {
        if (j4 <= j5) {
            return true;
        }
        return false;
    }

    private void h(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f23553a);
        textInputLayout2.setError(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        Long l4 = this.f23557e;
        if (l4 != null && this.f23558f != null) {
            if (g(l4.longValue(), this.f23558f.longValue())) {
                this.f23555c = this.f23557e;
                this.f23556d = this.f23558f;
                onSelectionChangedListener.onSelectionChanged(getSelection());
                return;
            }
            h(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
            return;
        }
        f(textInputLayout, textInputLayout2);
        onSelectionChangedListener.onIncompleteSelectionChanged();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@NonNull Context context) {
        int i4;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis)) {
            i4 = R.attr.materialCalendarTheme;
        } else {
            i4 = R.attr.materialCalendarFullscreenTheme;
        }
        return MaterialAttributes.resolveOrThrow(context, i4, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l4 = this.f23555c;
        if (l4 != null) {
            arrayList.add(l4);
        }
        Long l5 = this.f23556d;
        if (l5 != null) {
            arrayList.add(l5);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        if (this.f23555c != null && this.f23556d != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(this.f23555c, this.f23556d));
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String getSelectionDisplayString(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l4 = this.f23555c;
        if (l4 == null && this.f23556d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l5 = this.f23556d;
        if (l5 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, DateStrings.c(l4.longValue()));
        }
        if (l4 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, DateStrings.c(l5.longValue()));
        }
        Pair<String, String> a4 = DateStrings.a(l4, l5);
        return resources.getString(R.string.mtrl_picker_range_header_selected, a4.first, a4.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        Long l4 = this.f23555c;
        if (l4 != null && this.f23556d != null && g(l4.longValue(), this.f23556d.longValue())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull final OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        final TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f23553a = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat k4 = UtcDates.k();
        Long l4 = this.f23555c;
        if (l4 != null) {
            editText.setText(k4.format(l4));
            this.f23557e = this.f23555c;
        }
        Long l5 = this.f23556d;
        if (l5 != null) {
            editText2.setText(k4.format(l5));
            this.f23558f = this.f23556d;
        }
        String l6 = UtcDates.l(inflate.getResources(), k4);
        textInputLayout.setPlaceholderText(l6);
        textInputLayout2.setPlaceholderText(l6);
        editText.addTextChangedListener(new DateFormatTextWatcher(l6, k4, textInputLayout, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.1
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void e() {
                RangeDateSelector.this.f23557e = null;
                RangeDateSelector.this.i(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void f(@Nullable Long l7) {
                RangeDateSelector.this.f23557e = l7;
                RangeDateSelector.this.i(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        editText2.addTextChangedListener(new DateFormatTextWatcher(l6, k4, textInputLayout2, calendarConstraints) { // from class: com.google.android.material.datepicker.RangeDateSelector.2
            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void e() {
                RangeDateSelector.this.f23558f = null;
                RangeDateSelector.this.i(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }

            @Override // com.google.android.material.datepicker.DateFormatTextWatcher
            void f(@Nullable Long l7) {
                RangeDateSelector.this.f23558f = l7;
                RangeDateSelector.this.i(textInputLayout, textInputLayout2, onSelectionChangedListener);
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j4) {
        Long l4 = this.f23555c;
        if (l4 == null) {
            this.f23555c = Long.valueOf(j4);
        } else if (this.f23556d == null && g(l4.longValue(), j4)) {
            this.f23556d = Long.valueOf(j4);
        } else {
            this.f23556d = null;
            this.f23555c = Long.valueOf(j4);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeValue(this.f23555c);
        parcel.writeValue(this.f23556d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.f23555c, this.f23556d);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@NonNull Pair<Long, Long> pair) {
        Long l4 = pair.first;
        if (l4 != null && pair.second != null) {
            Preconditions.checkArgument(g(l4.longValue(), pair.second.longValue()));
        }
        Long l5 = pair.first;
        this.f23555c = l5 == null ? null : Long.valueOf(UtcDates.a(l5.longValue()));
        Long l6 = pair.second;
        this.f23556d = l6 != null ? Long.valueOf(UtcDates.a(l6.longValue())) : null;
    }
}
