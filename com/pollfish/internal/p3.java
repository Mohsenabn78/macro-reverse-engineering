package com.pollfish.internal;

import com.pollfish.builder.Position;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class p3 {

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37151a;

        static {
            int[] iArr = new int[Position.values().length];
            try {
                iArr[Position.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Position.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Position.MIDDLE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Position.MIDDLE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Position.BOTTOM_LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Position.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f37151a = iArr;
        }
    }

    @NotNull
    public static int a(@NotNull Position position) {
        switch (a.f37151a[position.ordinal()]) {
            case 1:
            case 3:
            case 5:
                return 1;
            case 2:
            case 4:
            case 6:
                return 2;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
