package crashguard.android.library;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

@RequiresApi(api = 21)
/* loaded from: classes6.dex */
final class z0 implements a1 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<? extends JobService> f39154a;

    /* renamed from: b  reason: collision with root package name */
    private final JobParameters f39155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(JobService jobService, JobParameters jobParameters) {
        this.f39154a = new WeakReference<>(jobService);
        this.f39155b = jobParameters;
    }

    @Override // crashguard.android.library.a1
    public final void onWorkFinished() {
        try {
            this.f39154a.get().jobFinished(this.f39155b, false);
        } catch (Throwable unused) {
        }
    }
}
