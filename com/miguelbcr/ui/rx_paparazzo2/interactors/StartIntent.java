package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.entities.UserCanceledException;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import rx_activity_result2.OnPreResult;
import rx_activity_result2.Result;
import rx_activity_result2.RxActivityResult;

/* loaded from: classes6.dex */
public final class StartIntent extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final TargetUi f36240a;

    /* renamed from: b  reason: collision with root package name */
    private Intent f36241b;

    /* renamed from: c  reason: collision with root package name */
    private OnPreResult f36242c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Function<Result<Fragment>, Intent> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Intent apply(Result<Fragment> result) throws Exception {
            return StartIntent.this.b(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements Function<Result<FragmentActivity>, Intent> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Intent apply(Result<FragmentActivity> result) throws Exception {
            return StartIntent.this.b(result);
        }
    }

    public StartIntent(TargetUi targetUi) {
        this.f36240a = targetUi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent b(Result result) {
        this.f36240a.setUi(result.targetUI());
        if (result.resultCode() == -1) {
            if (result.data() == null) {
                return new Intent();
            }
            return result.data();
        }
        throw new UserCanceledException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartIntent c(Intent intent) {
        this.f36241b = intent;
        this.f36242c = null;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartIntent d(Intent intent, OnPreResult onPreResult) {
        this.f36241b = intent;
        this.f36242c = onPreResult;
        return this;
    }

    public Observable<Intent> react() {
        Fragment fragment = this.f36240a.fragment();
        if (fragment != null) {
            return RxActivityResult.on(fragment).startIntent(this.f36241b, this.f36242c).map(new a());
        }
        return RxActivityResult.on(this.f36240a.activity()).startIntent(this.f36241b, this.f36242c).map(new b());
    }
}
