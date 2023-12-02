package com.pollfish.internal;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public abstract class y5 implements w0 {

    /* loaded from: classes6.dex */
    public static final class a extends y5 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f37365a = new a();

        public a() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends y5 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final b f37366a = new b();

        public b() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends y5 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final c f37367a = new c();

        public c() {
            super(0);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends y5 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final d f37368a = new d();

        public d() {
            super(0);
        }
    }

    public y5() {
    }

    public /* synthetic */ y5(int i4) {
        this();
    }

    @NotNull
    public final String toString() {
        if (this instanceof a) {
            return "Pollfish Indicator Creation Request";
        }
        if (this instanceof b) {
            return "Pollfish Survey Panel Creation Request";
        }
        if (this instanceof c) {
            return "Pollfish Views Destruction Request";
        }
        if (this instanceof d) {
            return "Pollfish Views Hide Request";
        }
        throw new NoWhenBranchMatchedException();
    }
}
