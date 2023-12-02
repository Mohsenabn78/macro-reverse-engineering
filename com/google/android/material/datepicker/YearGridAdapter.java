package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCalendar<?> f23575a;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        final TextView f23578a;

        ViewHolder(TextView textView) {
            super(textView);
            this.f23578a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.f23575a = materialCalendar;
    }

    @NonNull
    private View.OnClickListener b(final int i4) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YearGridAdapter.this.f23575a.s(YearGridAdapter.this.f23575a.l().e(Month.b(i4, YearGridAdapter.this.f23575a.n().f23531b)));
                YearGridAdapter.this.f23575a.t(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return i4 - this.f23575a.l().i().f23532c;
    }

    int d(int i4) {
        return this.f23575a.l().i().f23532c + i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i4) {
        CalendarItemStyle calendarItemStyle;
        int d4 = d(i4);
        String string = viewHolder.f23578a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder.f23578a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(d4)));
        viewHolder.f23578a.setContentDescription(String.format(string, Integer.valueOf(d4)));
        CalendarStyle m4 = this.f23575a.m();
        Calendar o4 = UtcDates.o();
        if (o4.get(1) == d4) {
            calendarItemStyle = m4.f23431f;
        } else {
            calendarItemStyle = m4.f23429d;
        }
        for (Long l4 : this.f23575a.getDateSelector().getSelectedDays()) {
            o4.setTimeInMillis(l4.longValue());
            if (o4.get(1) == d4) {
                calendarItemStyle = m4.f23430e;
            }
        }
        calendarItemStyle.d(viewHolder.f23578a);
        viewHolder.f23578a.setOnClickListener(b(d4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23575a.l().j();
    }
}
