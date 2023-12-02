package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes5.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f23543a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final CalendarConstraints f23544b;

    /* renamed from: c  reason: collision with root package name */
    private final DateSelector<?> f23545c;

    /* renamed from: d  reason: collision with root package name */
    private final MaterialCalendar.OnDayClickListener f23546d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23547e;

    /* loaded from: classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        final TextView f23550a;

        /* renamed from: b  reason: collision with root package name */
        final MaterialCalendarGridView f23551b;

        ViewHolder(@NonNull LinearLayout linearLayout, boolean z3) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.f23550a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.f23551b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z3) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.OnDayClickListener onDayClickListener) {
        int i4;
        Month i5 = calendarConstraints.i();
        Month f4 = calendarConstraints.f();
        Month h4 = calendarConstraints.h();
        if (i5.compareTo(h4) <= 0) {
            if (h4.compareTo(f4) <= 0) {
                int o4 = MonthAdapter.f23537f * MaterialCalendar.o(context);
                if (MaterialDatePicker.n(context)) {
                    i4 = MaterialCalendar.o(context);
                } else {
                    i4 = 0;
                }
                this.f23543a = context;
                this.f23547e = o4 + i4;
                this.f23544b = calendarConstraints;
                this.f23545c = dateSelector;
                this.f23546d = onDayClickListener;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month b(int i4) {
        return this.f23544b.i().j(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CharSequence c(int i4) {
        return b(i4).h(this.f23543a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(@NonNull Month month) {
        return this.f23544b.i().k(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i4) {
        Month j4 = this.f23544b.i().j(i4);
        viewHolder.f23550a.setText(j4.h(viewHolder.itemView.getContext()));
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.f23551b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && j4.equals(materialCalendarGridView.getAdapter2().f23538a)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().m(materialCalendarGridView);
        } else {
            MonthAdapter monthAdapter = new MonthAdapter(j4, this.f23545c, this.f23544b);
            materialCalendarGridView.setNumColumns(j4.f23533d);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i5, long j5) {
                if (materialCalendarGridView.getAdapter2().n(i5)) {
                    MonthsPagerAdapter.this.f23546d.a(materialCalendarGridView.getAdapter2().getItem(i5).longValue());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: f */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i4) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.n(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f23547e));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f23544b.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f23544b.i().j(i4).i();
    }
}
