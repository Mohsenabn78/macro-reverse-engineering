package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    static final Object f23454m = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting

    /* renamed from: n  reason: collision with root package name */
    static final Object f23455n = "NAVIGATION_PREV_TAG";
    @VisibleForTesting

    /* renamed from: o  reason: collision with root package name */
    static final Object f23456o = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting

    /* renamed from: p  reason: collision with root package name */
    static final Object f23457p = "SELECTOR_TOGGLE_TAG";
    @StyleRes

    /* renamed from: c  reason: collision with root package name */
    private int f23458c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private DateSelector<S> f23459d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private CalendarConstraints f23460e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Month f23461f;

    /* renamed from: g  reason: collision with root package name */
    private CalendarSelector f23462g;

    /* renamed from: h  reason: collision with root package name */
    private CalendarStyle f23463h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f23464i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView f23465j;

    /* renamed from: k  reason: collision with root package name */
    private View f23466k;

    /* renamed from: l  reason: collision with root package name */
    private View f23467l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface OnDayClickListener {
        void a(long j4);
    }

    private void j(@NonNull View view, @NonNull final MonthsPagerAdapter monthsPagerAdapter) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f23457p);
        ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.5
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                String string;
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                if (MaterialCalendar.this.f23467l.getVisibility() == 0) {
                    string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
                } else {
                    string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
                }
                accessibilityNodeInfoCompat.setHintText(string);
            }
        });
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f23455n);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f23456o);
        this.f23466k = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f23467l = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        t(CalendarSelector.DAY);
        materialButton.setText(this.f23461f.h(view.getContext()));
        this.f23465j.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i4) {
                if (i4 == 0) {
                    recyclerView.announceForAccessibility(materialButton.getText());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i4, int i5) {
                int findLastVisibleItemPosition;
                if (i4 < 0) {
                    findLastVisibleItemPosition = MaterialCalendar.this.q().findFirstVisibleItemPosition();
                } else {
                    findLastVisibleItemPosition = MaterialCalendar.this.q().findLastVisibleItemPosition();
                }
                MaterialCalendar.this.f23461f = monthsPagerAdapter.b(findLastVisibleItemPosition);
                materialButton.setText(monthsPagerAdapter.c(findLastVisibleItemPosition));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MaterialCalendar.this.u();
            }
        });
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int findFirstVisibleItemPosition = MaterialCalendar.this.q().findFirstVisibleItemPosition() + 1;
                if (findFirstVisibleItemPosition < MaterialCalendar.this.f23465j.getAdapter().getItemCount()) {
                    MaterialCalendar.this.s(monthsPagerAdapter.b(findFirstVisibleItemPosition));
                }
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int findLastVisibleItemPosition = MaterialCalendar.this.q().findLastVisibleItemPosition() - 1;
                if (findLastVisibleItemPosition >= 0) {
                    MaterialCalendar.this.s(monthsPagerAdapter.b(findLastVisibleItemPosition));
                }
            }
        });
    }

    @NonNull
    private RecyclerView.ItemDecoration k() {
        return new RecyclerView.ItemDecoration() { // from class: com.google.android.material.datepicker.MaterialCalendar.4

            /* renamed from: a  reason: collision with root package name */
            private final Calendar f23474a = UtcDates.q();

            /* renamed from: b  reason: collision with root package name */
            private final Calendar f23475b = UtcDates.q();

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                int i4;
                int width;
                if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (Pair<Long, Long> pair : MaterialCalendar.this.f23459d.getSelectedRanges()) {
                        Long l4 = pair.first;
                        if (l4 != null && pair.second != null) {
                            this.f23474a.setTimeInMillis(l4.longValue());
                            this.f23475b.setTimeInMillis(pair.second.longValue());
                            int c4 = yearGridAdapter.c(this.f23474a.get(1));
                            int c5 = yearGridAdapter.c(this.f23475b.get(1));
                            View findViewByPosition = gridLayoutManager.findViewByPosition(c4);
                            View findViewByPosition2 = gridLayoutManager.findViewByPosition(c5);
                            int spanCount = c4 / gridLayoutManager.getSpanCount();
                            int spanCount2 = c5 / gridLayoutManager.getSpanCount();
                            for (int i5 = spanCount; i5 <= spanCount2; i5++) {
                                View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i5);
                                if (findViewByPosition3 != null) {
                                    int top = findViewByPosition3.getTop() + MaterialCalendar.this.f23463h.f23429d.c();
                                    int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.f23463h.f23429d.b();
                                    if (i5 == spanCount) {
                                        i4 = findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2);
                                    } else {
                                        i4 = 0;
                                    }
                                    if (i5 == spanCount2) {
                                        width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                    } else {
                                        width = recyclerView.getWidth();
                                    }
                                    canvas.drawRect(i4, top, width, bottom, MaterialCalendar.this.f23463h.f23433h);
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> dateSelector, @StyleRes int i4, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i4);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.h());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Px
    public static int o(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int p(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i4 = MonthAdapter.f23537f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i4) + ((i4 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private void r(final int i4) {
        this.f23465j.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.f23465j.smoothScrollToPosition(i4);
            }
        });
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.f23459d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CalendarConstraints l() {
        return this.f23460e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarStyle m() {
        return this.f23463h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month n() {
        return this.f23461f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f23458c = bundle.getInt("THEME_RES_ID_KEY");
        this.f23459d = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f23460e = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f23461f = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i4;
        final int i5;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f23458c);
        this.f23463h = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month i6 = this.f23460e.i();
        if (MaterialDatePicker.n(contextThemeWrapper)) {
            i4 = R.layout.mtrl_calendar_vertical;
            i5 = 1;
        } else {
            i4 = R.layout.mtrl_calendar_horizontal;
            i5 = 0;
        }
        View inflate = cloneInContext.inflate(i4, viewGroup, false);
        inflate.setMinimumHeight(p(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionInfo(null);
            }
        });
        gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
        gridView.setNumColumns(i6.f23533d);
        gridView.setEnabled(false);
        this.f23465j = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.f23465j.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), i5, false) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
                if (i5 == 0) {
                    iArr[0] = MaterialCalendar.this.f23465j.getWidth();
                    iArr[1] = MaterialCalendar.this.f23465j.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.f23465j.getHeight();
                iArr[1] = MaterialCalendar.this.f23465j.getHeight();
            }
        });
        this.f23465j.setTag(f23454m);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.f23459d, this.f23460e, new OnDayClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.3
            @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
            public void a(long j4) {
                if (MaterialCalendar.this.f23460e.getDateValidator().isValid(j4)) {
                    MaterialCalendar.this.f23459d.select(j4);
                    Iterator<OnSelectionChangedListener<S>> it = MaterialCalendar.this.f23552b.iterator();
                    while (it.hasNext()) {
                        it.next().onSelectionChanged((S) MaterialCalendar.this.f23459d.getSelection());
                    }
                    MaterialCalendar.this.f23465j.getAdapter().notifyDataSetChanged();
                    if (MaterialCalendar.this.f23464i != null) {
                        MaterialCalendar.this.f23464i.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.f23465j.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f23464i = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f23464i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f23464i.setAdapter(new YearGridAdapter(this));
            this.f23464i.addItemDecoration(k());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            j(inflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.n(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f23465j);
        }
        this.f23465j.scrollToPosition(monthsPagerAdapter.d(this.f23461f));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f23458c);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f23459d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f23460e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f23461f);
    }

    @NonNull
    LinearLayoutManager q() {
        return (LinearLayoutManager) this.f23465j.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Month month) {
        boolean z3;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.f23465j.getAdapter();
        int d4 = monthsPagerAdapter.d(month);
        int d5 = d4 - monthsPagerAdapter.d(this.f23461f);
        boolean z4 = true;
        if (Math.abs(d5) > 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (d5 <= 0) {
            z4 = false;
        }
        this.f23461f = month;
        if (z3 && z4) {
            this.f23465j.scrollToPosition(d4 - 3);
            r(d4);
        } else if (z3) {
            this.f23465j.scrollToPosition(d4 + 3);
            r(d4);
        } else {
            r(d4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(CalendarSelector calendarSelector) {
        this.f23462g = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f23464i.getLayoutManager().scrollToPosition(((YearGridAdapter) this.f23464i.getAdapter()).c(this.f23461f.f23532c));
            this.f23466k.setVisibility(0);
            this.f23467l.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f23466k.setVisibility(8);
            this.f23467l.setVisibility(0);
            s(this.f23461f);
        }
    }

    void u() {
        CalendarSelector calendarSelector = this.f23462g;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            t(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            t(calendarSelector2);
        }
    }
}
