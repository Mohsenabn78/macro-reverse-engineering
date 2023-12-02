package crashguard.android.library;

/* loaded from: classes6.dex */
abstract class v {

    /* renamed from: a  reason: collision with root package name */
    private final c0 f39069a;

    /* loaded from: classes6.dex */
    static abstract class a<B extends a<B, ?>, W extends v> {

        /* renamed from: a  reason: collision with root package name */
        protected final c0 f39070a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Class<? extends m0> cls) {
            this.f39070a = new c0(cls);
        }

        protected abstract B a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final B b(long j4) {
            this.f39070a.j(j4);
            return a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final B c(long j4) {
            this.f39070a.m(j4);
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public v(c0 c0Var) {
        this.f39069a = c0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c0 a() {
        return this.f39069a;
    }
}
