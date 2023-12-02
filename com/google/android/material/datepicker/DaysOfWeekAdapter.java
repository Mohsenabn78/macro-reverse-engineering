package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes5.dex */
class DaysOfWeekAdapter extends BaseAdapter {

    /* renamed from: d  reason: collision with root package name */
    private static final int f23450d;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f23451a;

    /* renamed from: b  reason: collision with root package name */
    private final int f23452b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23453c;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 26) {
            i4 = 4;
        } else {
            i4 = 1;
        }
        f23450d = i4;
    }

    public DaysOfWeekAdapter() {
        Calendar q4 = UtcDates.q();
        this.f23451a = q4;
        this.f23452b = q4.getMaximum(7);
        this.f23453c = q4.getFirstDayOfWeek();
    }

    private int b(int i4) {
        int i5 = i4 + this.f23453c;
        int i6 = this.f23452b;
        if (i5 > i6) {
            return i5 - i6;
        }
        return i5;
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: a */
    public Integer getItem(int i4) {
        if (i4 >= this.f23452b) {
            return null;
        }
        return Integer.valueOf(b(i4));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f23452b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i4, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f23451a.set(7, b(i4));
        textView.setText(this.f23451a.getDisplayName(7, f23450d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f23451a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
