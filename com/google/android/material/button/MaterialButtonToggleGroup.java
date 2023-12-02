package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k  reason: collision with root package name */
    private static final String f23233k = "MaterialButtonToggleGroup";

    /* renamed from: l  reason: collision with root package name */
    private static final int f23234l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a  reason: collision with root package name */
    private final List<CornerData> f23235a;

    /* renamed from: b  reason: collision with root package name */
    private final CheckedStateTracker f23236b;

    /* renamed from: c  reason: collision with root package name */
    private final PressedStateTracker f23237c;

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<OnButtonCheckedListener> f23238d;

    /* renamed from: e  reason: collision with root package name */
    private final Comparator<MaterialButton> f23239e;

    /* renamed from: f  reason: collision with root package name */
    private Integer[] f23240f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23241g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23242h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f23243i;
    @IdRes

    /* renamed from: j  reason: collision with root package name */
    private int f23244j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class CheckedStateTracker implements MaterialButton.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull MaterialButton materialButton, boolean z3) {
            int i4;
            if (MaterialButtonToggleGroup.this.f23241g) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f23242h) {
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                if (z3) {
                    i4 = materialButton.getId();
                } else {
                    i4 = -1;
                }
                materialButtonToggleGroup.f23244j = i4;
            }
            if (MaterialButtonToggleGroup.this.r(materialButton.getId(), z3)) {
                MaterialButtonToggleGroup.this.j(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class CornerData {

        /* renamed from: e  reason: collision with root package name */
        private static final CornerSize f23248e = new AbsoluteCornerSize(0.0f);

        /* renamed from: a  reason: collision with root package name */
        CornerSize f23249a;

        /* renamed from: b  reason: collision with root package name */
        CornerSize f23250b;

        /* renamed from: c  reason: collision with root package name */
        CornerSize f23251c;

        /* renamed from: d  reason: collision with root package name */
        CornerSize f23252d;

        CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f23249a = cornerSize;
            this.f23250b = cornerSize3;
            this.f23251c = cornerSize4;
            this.f23252d = cornerSize2;
        }

        public static CornerData a(CornerData cornerData) {
            CornerSize cornerSize = f23248e;
            return new CornerData(cornerSize, cornerData.f23252d, cornerSize, cornerData.f23251c);
        }

        public static CornerData b(CornerData cornerData, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return c(cornerData);
            }
            return d(cornerData);
        }

        public static CornerData c(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f23249a;
            CornerSize cornerSize2 = cornerData.f23252d;
            CornerSize cornerSize3 = f23248e;
            return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static CornerData d(CornerData cornerData) {
            CornerSize cornerSize = f23248e;
            return new CornerData(cornerSize, cornerSize, cornerData.f23250b, cornerData.f23251c);
        }

        public static CornerData e(CornerData cornerData, View view) {
            if (ViewUtils.isLayoutRtl(view)) {
                return d(cornerData);
            }
            return c(cornerData);
        }

        public static CornerData f(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f23249a;
            CornerSize cornerSize2 = f23248e;
            return new CornerData(cornerSize, cornerSize2, cornerData.f23250b, cornerSize2);
        }
    }

    /* loaded from: classes5.dex */
    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i4, boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void a(@NonNull MaterialButton materialButton, boolean z3) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void g() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i4 = firstVisibleChildIndex + 1; i4 < getChildCount(); i4++) {
            MaterialButton k4 = k(i4);
            int min = Math.min(k4.getStrokeWidth(), k(i4 - 1).getStrokeWidth());
            LinearLayout.LayoutParams h4 = h(k4);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(h4, 0);
                MarginLayoutParamsCompat.setMarginStart(h4, -min);
                h4.topMargin = 0;
            } else {
                h4.bottomMargin = 0;
                h4.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(h4, 0);
            }
            k4.setLayoutParams(h4);
        }
        o(firstVisibleChildIndex);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (n(i4)) {
                return i4;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (n(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if ((getChildAt(i5) instanceof MaterialButton) && n(i5)) {
                i4++;
            }
        }
        return i4;
    }

    @NonNull
    private LinearLayout.LayoutParams h(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void i(int i4, boolean z3) {
        MaterialButton materialButton = (MaterialButton) findViewById(i4);
        if (materialButton != null) {
            materialButton.setChecked(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(@IdRes int i4, boolean z3) {
        Iterator<OnButtonCheckedListener> it = this.f23238d.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i4, z3);
        }
    }

    private MaterialButton k(int i4) {
        return (MaterialButton) getChildAt(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) == view) {
                return i4;
            }
            if ((getChildAt(i5) instanceof MaterialButton) && n(i5)) {
                i4++;
            }
        }
        return -1;
    }

    @Nullable
    private CornerData m(int i4, int i5, int i6) {
        boolean z3;
        CornerData cornerData = this.f23235a.get(i4);
        if (i5 == i6) {
            return cornerData;
        }
        if (getOrientation() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i4 == i5) {
            if (z3) {
                return CornerData.e(cornerData, this);
            }
            return CornerData.f(cornerData);
        } else if (i4 == i6) {
            if (z3) {
                return CornerData.b(cornerData, this);
            }
            return CornerData.a(cornerData);
        } else {
            return null;
        }
    }

    private boolean n(int i4) {
        if (getChildAt(i4).getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void o(int i4) {
        if (getChildCount() != 0 && i4 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) k(i4).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void p(@IdRes int i4, boolean z3) {
        View findViewById = findViewById(i4);
        if (findViewById instanceof MaterialButton) {
            this.f23241g = true;
            ((MaterialButton) findViewById).setChecked(z3);
            this.f23241g = false;
        }
    }

    private static void q(ShapeAppearanceModel.Builder builder, @Nullable CornerData cornerData) {
        if (cornerData == null) {
            builder.setAllCornerSizes(0.0f);
        } else {
            builder.setTopLeftCornerSize(cornerData.f23249a).setBottomLeftCornerSize(cornerData.f23252d).setTopRightCornerSize(cornerData.f23250b).setBottomRightCornerSize(cornerData.f23251c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(int i4, boolean z3) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f23243i && checkedButtonIds.isEmpty()) {
            p(i4, true);
            this.f23244j = i4;
            return false;
        }
        if (z3 && this.f23242h) {
            checkedButtonIds.remove(Integer.valueOf(i4));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                p(intValue, false);
                j(intValue, false);
            }
        }
        return true;
    }

    private void s() {
        TreeMap treeMap = new TreeMap(this.f23239e);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            treeMap.put(k(i4), Integer.valueOf(i4));
        }
        this.f23240f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setCheckedId(int i4) {
        this.f23244j = i4;
        j(i4, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.f23236b);
        materialButton.setOnPressedChangeListenerInternal(this.f23237c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void addOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.f23238d.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f23233k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i4, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            r(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f23235a.add(new CornerData(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
        ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.l(view2), 1, false, ((MaterialButton) view2).isChecked()));
            }
        });
    }

    public void check(@IdRes int i4) {
        if (i4 == this.f23244j) {
            return;
        }
        i(i4, true);
    }

    public void clearChecked() {
        this.f23241g = true;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            MaterialButton k4 = k(i4);
            k4.setChecked(false);
            j(k4.getId(), false);
        }
        this.f23241g = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.f23238d.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NonNull Canvas canvas) {
        s();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f23242h) {
            return this.f23244j;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            MaterialButton k4 = k(i4);
            if (k4.isChecked()) {
                arrayList.add(Integer.valueOf(k4.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i4, int i5) {
        Integer[] numArr = this.f23240f;
        if (numArr != null && i5 < numArr.length) {
            return numArr[i5].intValue();
        }
        Log.w(f23233k, "Child order wasn't updated");
        return i5;
    }

    public boolean isSelectionRequired() {
        return this.f23243i;
    }

    public boolean isSingleSelection() {
        return this.f23242h;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i4 = this.f23244j;
        if (i4 != -1) {
            i(i4, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        int i4;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        int visibleButtonCount = getVisibleButtonCount();
        if (isSingleSelection()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        wrap.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, visibleButtonCount, false, i4));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        t();
        g();
        super.onMeasure(i4, i5);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.f23236b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f23235a.remove(indexOfChild);
        }
        t();
        g();
    }

    public void removeOnButtonCheckedListener(@NonNull OnButtonCheckedListener onButtonCheckedListener) {
        this.f23238d.remove(onButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z3) {
        this.f23243i = z3;
    }

    public void setSingleSelection(boolean z3) {
        if (this.f23242h != z3) {
            this.f23242h = z3;
            clearChecked();
        }
    }

    @VisibleForTesting
    void t() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i4 = 0; i4 < childCount; i4++) {
            MaterialButton k4 = k(i4);
            if (k4.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builder = k4.getShapeAppearanceModel().toBuilder();
                q(builder, m(i4, firstVisibleChildIndex, lastVisibleChildIndex));
                k4.setShapeAppearanceModel(builder.build());
            }
        }
    }

    public void uncheck(@IdRes int i4) {
        i(i4, false);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f23234l
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f23235a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$CheckedStateTracker r7 = new com.google.android.material.button.MaterialButtonToggleGroup$CheckedStateTracker
            r0 = 0
            r7.<init>()
            r6.f23236b = r7
            com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker r7 = new com.google.android.material.button.MaterialButtonToggleGroup$PressedStateTracker
            r7.<init>()
            r6.f23237c = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f23238d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.f23239e = r7
            r7 = 0
            r6.f23241g = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f23244j = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f23243i = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i4) {
        setSingleSelection(getResources().getBoolean(i4));
    }
}
