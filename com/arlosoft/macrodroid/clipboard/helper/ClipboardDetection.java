package com.arlosoft.macrodroid.clipboard.helper;

import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.FileOperationAction;
import com.arlosoft.macrodroid.extensions.StripArrayList;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Predicate.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ClipboardDetection {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a */
    private final String f9762a;
    @NotNull

    /* renamed from: b */
    private final StripArrayList<AEvent> f9763b;
    @NotNull

    /* renamed from: c */
    private final StripArrayList<Integer> f9764c;
    @Nullable

    /* renamed from: d */
    private AEvent f9765d;

    /* compiled from: Predicate.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class AEvent {
        @Nullable

        /* renamed from: a */
        private Integer f9767a;
        @Nullable

        /* renamed from: b */
        private Long f9768b;
        @Nullable

        /* renamed from: c */
        private CharSequence f9769c;
        @Nullable

        /* renamed from: d */
        private Integer f9770d;
        @Nullable

        /* renamed from: e */
        private Integer f9771e;
        @Nullable

        /* renamed from: f */
        private CharSequence f9772f;
        @Nullable

        /* renamed from: g */
        private List<? extends CharSequence> f9773g;
        @Nullable

        /* renamed from: h */
        private CharSequence f9774h;
        @Nullable

        /* renamed from: i */
        private Integer f9775i;
        @Nullable

        /* renamed from: j */
        private Integer f9776j;
        @Nullable

        /* renamed from: k */
        private Integer f9777k;
        @Nullable

        /* renamed from: l */
        private Integer f9778l;
        @Nullable

        /* renamed from: m */
        private Integer f9779m;
        @Nullable

        /* renamed from: n */
        private Integer f9780n;
        @NotNull

        /* renamed from: o */
        private List<AccessibilityNodeInfo.AccessibilityAction> f9781o;
        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        @NotNull

        /* renamed from: p */
        private static final Regex f9766p = new Regex("(copied)|(Copied)|(clipboard)");

        /* compiled from: Predicate.kt */
        /* loaded from: classes3.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final AEvent from(@NotNull AccessibilityEvent event) {
                List emptyList;
                Intrinsics.checkNotNullParameter(event, "event");
                int eventType = event.getEventType();
                long eventTime = event.getEventTime();
                CharSequence packageName = event.getPackageName();
                int movementGranularity = event.getMovementGranularity();
                int action = event.getAction();
                CharSequence className = event.getClassName();
                List<CharSequence> text = event.getText();
                int contentChangeTypes = event.getContentChangeTypes();
                CharSequence contentDescription = event.getContentDescription();
                int currentItemIndex = event.getCurrentItemIndex();
                int fromIndex = event.getFromIndex();
                int toIndex = event.getToIndex();
                int scrollX = event.getScrollX();
                int scrollY = event.getScrollY();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return new AEvent(Integer.valueOf(eventType), Long.valueOf(eventTime), packageName, Integer.valueOf(movementGranularity), Integer.valueOf(action), className, text, contentDescription, Integer.valueOf(contentChangeTypes), Integer.valueOf(currentItemIndex), Integer.valueOf(fromIndex), Integer.valueOf(toIndex), Integer.valueOf(scrollX), Integer.valueOf(scrollY), emptyList);
            }

            @NotNull
            public final Regex getCopyKeyWords$app_standardRelease() {
                return AEvent.f9766p;
            }
        }

        public AEvent() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Advice.MethodSizeHandler.UNDEFINED_SIZE, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AEvent copy$default(AEvent aEvent, Integer num, Long l4, CharSequence charSequence, Integer num2, Integer num3, CharSequence charSequence2, List list, CharSequence charSequence3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, List list2, int i4, Object obj) {
            Integer num10;
            Long l5;
            CharSequence charSequence4;
            Integer num11;
            Integer num12;
            CharSequence charSequence5;
            List<? extends CharSequence> list3;
            CharSequence charSequence6;
            Integer num13;
            Integer num14;
            Integer num15;
            Integer num16;
            Integer num17;
            Integer num18;
            List<AccessibilityNodeInfo.AccessibilityAction> list4;
            if ((i4 & 1) != 0) {
                num10 = aEvent.f9767a;
            } else {
                num10 = num;
            }
            if ((i4 & 2) != 0) {
                l5 = aEvent.f9768b;
            } else {
                l5 = l4;
            }
            if ((i4 & 4) != 0) {
                charSequence4 = aEvent.f9769c;
            } else {
                charSequence4 = charSequence;
            }
            if ((i4 & 8) != 0) {
                num11 = aEvent.f9770d;
            } else {
                num11 = num2;
            }
            if ((i4 & 16) != 0) {
                num12 = aEvent.f9771e;
            } else {
                num12 = num3;
            }
            if ((i4 & 32) != 0) {
                charSequence5 = aEvent.f9772f;
            } else {
                charSequence5 = charSequence2;
            }
            if ((i4 & 64) != 0) {
                list3 = aEvent.f9773g;
            } else {
                list3 = list;
            }
            if ((i4 & 128) != 0) {
                charSequence6 = aEvent.f9774h;
            } else {
                charSequence6 = charSequence3;
            }
            if ((i4 & 256) != 0) {
                num13 = aEvent.f9775i;
            } else {
                num13 = num4;
            }
            if ((i4 & 512) != 0) {
                num14 = aEvent.f9776j;
            } else {
                num14 = num5;
            }
            if ((i4 & 1024) != 0) {
                num15 = aEvent.f9777k;
            } else {
                num15 = num6;
            }
            if ((i4 & 2048) != 0) {
                num16 = aEvent.f9778l;
            } else {
                num16 = num7;
            }
            if ((i4 & 4096) != 0) {
                num17 = aEvent.f9779m;
            } else {
                num17 = num8;
            }
            if ((i4 & 8192) != 0) {
                num18 = aEvent.f9780n;
            } else {
                num18 = num9;
            }
            if ((i4 & 16384) != 0) {
                list4 = aEvent.f9781o;
            } else {
                list4 = list2;
            }
            return aEvent.copy(num10, l5, charSequence4, num11, num12, charSequence5, list3, charSequence6, num13, num14, num15, num16, num17, num18, list4);
        }

        @Nullable
        public final Integer component1() {
            return this.f9767a;
        }

        @Nullable
        public final Integer component10() {
            return this.f9776j;
        }

        @Nullable
        public final Integer component11() {
            return this.f9777k;
        }

        @Nullable
        public final Integer component12() {
            return this.f9778l;
        }

        @Nullable
        public final Integer component13() {
            return this.f9779m;
        }

        @Nullable
        public final Integer component14() {
            return this.f9780n;
        }

        @NotNull
        public final List<AccessibilityNodeInfo.AccessibilityAction> component15() {
            return this.f9781o;
        }

        @Nullable
        public final Long component2() {
            return this.f9768b;
        }

        @Nullable
        public final CharSequence component3() {
            return this.f9769c;
        }

        @Nullable
        public final Integer component4() {
            return this.f9770d;
        }

        @Nullable
        public final Integer component5() {
            return this.f9771e;
        }

        @Nullable
        public final CharSequence component6() {
            return this.f9772f;
        }

        @Nullable
        public final List<CharSequence> component7() {
            return this.f9773g;
        }

        @Nullable
        public final CharSequence component8() {
            return this.f9774h;
        }

        @Nullable
        public final Integer component9() {
            return this.f9775i;
        }

        @NotNull
        public final AEvent copy(@Nullable Integer num, @Nullable Long l4, @Nullable CharSequence charSequence, @Nullable Integer num2, @Nullable Integer num3, @Nullable CharSequence charSequence2, @Nullable List<? extends CharSequence> list, @Nullable CharSequence charSequence3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @NotNull List<AccessibilityNodeInfo.AccessibilityAction> SourceActions) {
            Intrinsics.checkNotNullParameter(SourceActions, "SourceActions");
            return new AEvent(num, l4, charSequence, num2, num3, charSequence2, list, charSequence3, num4, num5, num6, num7, num8, num9, SourceActions);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AEvent)) {
                return false;
            }
            AEvent aEvent = (AEvent) obj;
            if (Intrinsics.areEqual(this.f9767a, aEvent.f9767a) && Intrinsics.areEqual(this.f9768b, aEvent.f9768b) && Intrinsics.areEqual(this.f9769c, aEvent.f9769c) && Intrinsics.areEqual(this.f9770d, aEvent.f9770d) && Intrinsics.areEqual(this.f9771e, aEvent.f9771e) && Intrinsics.areEqual(this.f9772f, aEvent.f9772f) && Intrinsics.areEqual(this.f9773g, aEvent.f9773g) && Intrinsics.areEqual(this.f9774h, aEvent.f9774h) && Intrinsics.areEqual(this.f9775i, aEvent.f9775i) && Intrinsics.areEqual(this.f9776j, aEvent.f9776j) && Intrinsics.areEqual(this.f9777k, aEvent.f9777k) && Intrinsics.areEqual(this.f9778l, aEvent.f9778l) && Intrinsics.areEqual(this.f9779m, aEvent.f9779m) && Intrinsics.areEqual(this.f9780n, aEvent.f9780n) && Intrinsics.areEqual(this.f9781o, aEvent.f9781o)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final Integer getAction() {
            return this.f9771e;
        }

        @Nullable
        public final CharSequence getClassName() {
            return this.f9772f;
        }

        @Nullable
        public final Integer getContentChangeTypes() {
            return this.f9775i;
        }

        @Nullable
        public final CharSequence getContentDescription() {
            return this.f9774h;
        }

        @Nullable
        public final Integer getCurrentItemIndex() {
            return this.f9776j;
        }

        @Nullable
        public final Long getEventTime() {
            return this.f9768b;
        }

        @Nullable
        public final Integer getEventType() {
            return this.f9767a;
        }

        @Nullable
        public final Integer getFromIndex() {
            return this.f9777k;
        }

        @Nullable
        public final Integer getMovementGranularity() {
            return this.f9770d;
        }

        @Nullable
        public final CharSequence getPackageName() {
            return this.f9769c;
        }

        @Nullable
        public final Integer getScrollX() {
            return this.f9779m;
        }

        @Nullable
        public final Integer getScrollY() {
            return this.f9780n;
        }

        @NotNull
        public final List<AccessibilityNodeInfo.AccessibilityAction> getSourceActions() {
            return this.f9781o;
        }

        @Nullable
        public final List<CharSequence> getText() {
            return this.f9773g;
        }

        @Nullable
        public final Integer getToIndex() {
            return this.f9778l;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            int hashCode9;
            int hashCode10;
            int hashCode11;
            int hashCode12;
            int hashCode13;
            Integer num = this.f9767a;
            int i4 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i5 = hashCode * 31;
            Long l4 = this.f9768b;
            if (l4 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = l4.hashCode();
            }
            int i6 = (i5 + hashCode2) * 31;
            CharSequence charSequence = this.f9769c;
            if (charSequence == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = charSequence.hashCode();
            }
            int i7 = (i6 + hashCode3) * 31;
            Integer num2 = this.f9770d;
            if (num2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = num2.hashCode();
            }
            int i8 = (i7 + hashCode4) * 31;
            Integer num3 = this.f9771e;
            if (num3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num3.hashCode();
            }
            int i9 = (i8 + hashCode5) * 31;
            CharSequence charSequence2 = this.f9772f;
            if (charSequence2 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = charSequence2.hashCode();
            }
            int i10 = (i9 + hashCode6) * 31;
            List<? extends CharSequence> list = this.f9773g;
            if (list == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = list.hashCode();
            }
            int i11 = (i10 + hashCode7) * 31;
            CharSequence charSequence3 = this.f9774h;
            if (charSequence3 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = charSequence3.hashCode();
            }
            int i12 = (i11 + hashCode8) * 31;
            Integer num4 = this.f9775i;
            if (num4 == null) {
                hashCode9 = 0;
            } else {
                hashCode9 = num4.hashCode();
            }
            int i13 = (i12 + hashCode9) * 31;
            Integer num5 = this.f9776j;
            if (num5 == null) {
                hashCode10 = 0;
            } else {
                hashCode10 = num5.hashCode();
            }
            int i14 = (i13 + hashCode10) * 31;
            Integer num6 = this.f9777k;
            if (num6 == null) {
                hashCode11 = 0;
            } else {
                hashCode11 = num6.hashCode();
            }
            int i15 = (i14 + hashCode11) * 31;
            Integer num7 = this.f9778l;
            if (num7 == null) {
                hashCode12 = 0;
            } else {
                hashCode12 = num7.hashCode();
            }
            int i16 = (i15 + hashCode12) * 31;
            Integer num8 = this.f9779m;
            if (num8 == null) {
                hashCode13 = 0;
            } else {
                hashCode13 = num8.hashCode();
            }
            int i17 = (i16 + hashCode13) * 31;
            Integer num9 = this.f9780n;
            if (num9 != null) {
                i4 = num9.hashCode();
            }
            return ((i17 + i4) * 31) + this.f9781o.hashCode();
        }

        public final void setAction(@Nullable Integer num) {
            this.f9771e = num;
        }

        public final void setClassName(@Nullable CharSequence charSequence) {
            this.f9772f = charSequence;
        }

        public final void setContentChangeTypes(@Nullable Integer num) {
            this.f9775i = num;
        }

        public final void setContentDescription(@Nullable CharSequence charSequence) {
            this.f9774h = charSequence;
        }

        public final void setCurrentItemIndex(@Nullable Integer num) {
            this.f9776j = num;
        }

        public final void setEventTime(@Nullable Long l4) {
            this.f9768b = l4;
        }

        public final void setEventType(@Nullable Integer num) {
            this.f9767a = num;
        }

        public final void setFromIndex(@Nullable Integer num) {
            this.f9777k = num;
        }

        public final void setMovementGranularity(@Nullable Integer num) {
            this.f9770d = num;
        }

        public final void setPackageName(@Nullable CharSequence charSequence) {
            this.f9769c = charSequence;
        }

        public final void setScrollX(@Nullable Integer num) {
            this.f9779m = num;
        }

        public final void setScrollY(@Nullable Integer num) {
            this.f9780n = num;
        }

        public final void setSourceActions(@NotNull List<AccessibilityNodeInfo.AccessibilityAction> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.f9781o = list;
        }

        public final void setText(@Nullable List<? extends CharSequence> list) {
            this.f9773g = list;
        }

        public final void setToIndex(@Nullable Integer num) {
            this.f9778l = num;
        }

        @NotNull
        public String toString() {
            Integer num = this.f9767a;
            Long l4 = this.f9768b;
            CharSequence charSequence = this.f9769c;
            Integer num2 = this.f9770d;
            Integer num3 = this.f9771e;
            CharSequence charSequence2 = this.f9772f;
            List<? extends CharSequence> list = this.f9773g;
            CharSequence charSequence3 = this.f9774h;
            Integer num4 = this.f9775i;
            Integer num5 = this.f9776j;
            Integer num6 = this.f9777k;
            Integer num7 = this.f9778l;
            Integer num8 = this.f9779m;
            Integer num9 = this.f9780n;
            List<AccessibilityNodeInfo.AccessibilityAction> list2 = this.f9781o;
            return "AEvent(EventType=" + num + ", EventTime=" + l4 + ", PackageName=" + ((Object) charSequence) + ", MovementGranularity=" + num2 + ", Action=" + num3 + ", ClassName=" + ((Object) charSequence2) + ", Text=" + list + ", ContentDescription=" + ((Object) charSequence3) + ", ContentChangeTypes=" + num4 + ", CurrentItemIndex=" + num5 + ", FromIndex=" + num6 + ", ToIndex=" + num7 + ", ScrollX=" + num8 + ", ScrollY=" + num9 + ", SourceActions=" + list2 + ")";
        }

        public AEvent(@Nullable Integer num, @Nullable Long l4, @Nullable CharSequence charSequence, @Nullable Integer num2, @Nullable Integer num3, @Nullable CharSequence charSequence2, @Nullable List<? extends CharSequence> list, @Nullable CharSequence charSequence3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable Integer num9, @NotNull List<AccessibilityNodeInfo.AccessibilityAction> SourceActions) {
            Intrinsics.checkNotNullParameter(SourceActions, "SourceActions");
            this.f9767a = num;
            this.f9768b = l4;
            this.f9769c = charSequence;
            this.f9770d = num2;
            this.f9771e = num3;
            this.f9772f = charSequence2;
            this.f9773g = list;
            this.f9774h = charSequence3;
            this.f9775i = num4;
            this.f9776j = num5;
            this.f9777k = num6;
            this.f9778l = num7;
            this.f9779m = num8;
            this.f9780n = num9;
            this.f9781o = SourceActions;
        }

        public /* synthetic */ AEvent(Integer num, Long l4, CharSequence charSequence, Integer num2, Integer num3, CharSequence charSequence2, List list, CharSequence charSequence3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? null : num, (i4 & 2) != 0 ? null : l4, (i4 & 4) != 0 ? null : charSequence, (i4 & 8) != 0 ? null : num2, (i4 & 16) != 0 ? null : num3, (i4 & 32) != 0 ? null : charSequence2, (i4 & 64) != 0 ? null : list, (i4 & 128) != 0 ? null : charSequence3, (i4 & 256) != 0 ? null : num4, (i4 & 512) != 0 ? null : num5, (i4 & 1024) != 0 ? null : num6, (i4 & 2048) != 0 ? null : num7, (i4 & 4096) != 0 ? null : num8, (i4 & 8192) == 0 ? num9 : null, (i4 & 16384) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
        }
    }

    public ClipboardDetection() {
        this(null, 1, null);
    }

    private final AEvent a(AEvent aEvent) {
        List<CharSequence> text = aEvent.getText();
        if (text == null) {
            text = CollectionsKt__CollectionsKt.emptyList();
        }
        return AEvent.copy$default(aEvent, null, null, null, null, null, null, new ArrayList(text), null, null, null, null, null, null, null, null, 32703, null);
    }

    public static /* synthetic */ boolean detectAppropriateEvents$default(ClipboardDetection clipboardDetection, AEvent aEvent, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        return clipboardDetection.detectAppropriateEvents(aEvent, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean getSupportedEventTypes$default(ClipboardDetection clipboardDetection, AccessibilityEvent accessibilityEvent, Function1 function1, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            function1 = null;
        }
        return clipboardDetection.getSupportedEventTypes(accessibilityEvent, function1);
    }

    public final void addEvent(int i4) {
        this.f9764c.add(Integer.valueOf(i4));
    }

    /* JADX WARN: Code restructure failed: missing block: B:148:0x0067, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7.getContentDescription(), r6.f9762a) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0173, code lost:
        if (r0 == false) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x017f  */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean detectAppropriateEvents(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection.AEvent r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection.detectAppropriateEvents(com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection$AEvent, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0017, code lost:
        if (r4.invoke(r3).booleanValue() == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getSupportedEventTypes(@org.jetbrains.annotations.Nullable android.view.accessibility.AccessibilityEvent r3, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection.AEvent, java.lang.Boolean> r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection$AEvent$Companion r1 = com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection.AEvent.Companion
            com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection$AEvent r3 = r1.from(r3)
            if (r4 == 0) goto L1a
            java.lang.Object r4 = r4.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r1 = 1
            if (r4 != r1) goto L1a
            goto L1b
        L1a:
            r1 = 0
        L1b:
            if (r1 == 0) goto L1e
            return r0
        L1e:
            r4 = 2
            r1 = 0
            boolean r3 = detectAppropriateEvents$default(r2, r3, r0, r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.clipboard.helper.ClipboardDetection.getSupportedEventTypes(android.view.accessibility.AccessibilityEvent, kotlin.jvm.functions.Function1):boolean");
    }

    public ClipboardDetection(@NotNull String copyWord) {
        Intrinsics.checkNotNullParameter(copyWord, "copyWord");
        this.f9762a = copyWord;
        this.f9763b = new StripArrayList<>(2);
        this.f9764c = new StripArrayList<>(4);
    }

    public /* synthetic */ ClipboardDetection(String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? FileOperationAction.OPTION_COPY_FIXED : str);
    }
}
