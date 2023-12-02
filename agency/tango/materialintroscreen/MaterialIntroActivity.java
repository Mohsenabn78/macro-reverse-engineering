package agency.tango.materialintroscreen;

import agency.tango.materialintroscreen.adapter.SlidesAdapter;
import agency.tango.materialintroscreen.animations.ViewTranslationWrapper;
import agency.tango.materialintroscreen.animations.wrappers.BackButtonTranslationWrapper;
import agency.tango.materialintroscreen.animations.wrappers.NextButtonTranslationWrapper;
import agency.tango.materialintroscreen.animations.wrappers.PageIndicatorTranslationWrapper;
import agency.tango.materialintroscreen.animations.wrappers.SkipButtonTranslationWrapper;
import agency.tango.materialintroscreen.animations.wrappers.ViewPagerTranslationWrapper;
import agency.tango.materialintroscreen.listeners.IPageScrolledListener;
import agency.tango.materialintroscreen.listeners.IPageSelectedListener;
import agency.tango.materialintroscreen.listeners.MessageButtonBehaviourOnPageSelected;
import agency.tango.materialintroscreen.listeners.SwipeStateTouchListener;
import agency.tango.materialintroscreen.listeners.ViewBehavioursOnPageChangeListener;
import agency.tango.materialintroscreen.listeners.clickListeners.PermissionNotGrantedClickListener;
import agency.tango.materialintroscreen.listeners.scrollListeners.ParallaxScrollListener;
import agency.tango.materialintroscreen.widgets.InkPageIndicator;
import agency.tango.materialintroscreen.widgets.SwipeableViewPager;
import android.animation.ArgbEvaluator;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.snackbar.Snackbar;

/* loaded from: classes.dex */
public abstract class MaterialIntroActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private SwipeableViewPager f51c;

    /* renamed from: d  reason: collision with root package name */
    private InkPageIndicator f52d;

    /* renamed from: e  reason: collision with root package name */
    private SlidesAdapter f53e;

    /* renamed from: f  reason: collision with root package name */
    private ImageButton f54f;

    /* renamed from: g  reason: collision with root package name */
    protected ImageButton f55g;

    /* renamed from: h  reason: collision with root package name */
    private ImageButton f56h;

    /* renamed from: i  reason: collision with root package name */
    private CoordinatorLayout f57i;

    /* renamed from: j  reason: collision with root package name */
    private Button f58j;

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f59k;

    /* renamed from: m  reason: collision with root package name */
    private ViewTranslationWrapper f61m;

    /* renamed from: n  reason: collision with root package name */
    private ViewTranslationWrapper f62n;

    /* renamed from: o  reason: collision with root package name */
    private ViewTranslationWrapper f63o;

    /* renamed from: p  reason: collision with root package name */
    private ViewTranslationWrapper f64p;

    /* renamed from: q  reason: collision with root package name */
    private ViewTranslationWrapper f65q;

    /* renamed from: r  reason: collision with root package name */
    private MessageButtonBehaviourOnPageSelected f66r;

    /* renamed from: s  reason: collision with root package name */
    private View.OnClickListener f67s;

    /* renamed from: t  reason: collision with root package name */
    private View.OnClickListener f68t;

    /* renamed from: l  reason: collision with root package name */
    private ArgbEvaluator f60l = new ArgbEvaluator();

    /* renamed from: u  reason: collision with root package name */
    private SparseArray<MessageButtonBehaviour> f69u = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MaterialIntroActivity.this.f53e.slidesCount() == 0) {
                MaterialIntroActivity.this.finish();
                return;
            }
            int currentItem = MaterialIntroActivity.this.f51c.getCurrentItem();
            MaterialIntroActivity.this.f66r.pageSelected(currentItem);
            MaterialIntroActivity materialIntroActivity = MaterialIntroActivity.this;
            materialIntroActivity.z(currentItem, materialIntroActivity.f53e.getItem(currentItem));
        }
    }

    /* loaded from: classes.dex */
    class b extends OnBackPressedCallback {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (MaterialIntroActivity.this.f51c.getCurrentItem() == 0) {
                MaterialIntroActivity.this.finish();
            } else {
                MaterialIntroActivity.this.f51c.setCurrentItem(MaterialIntroActivity.this.f51c.getPreviousItem());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends Snackbar.Callback {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.snackbar.Snackbar.Callback, com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i4) {
            MaterialIntroActivity.this.f59k.setTranslationY(0.0f);
            super.onDismissed(snackbar, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements IPageSelectedListener {
        d() {
        }

        @Override // agency.tango.materialintroscreen.listeners.IPageSelectedListener
        public void pageSelected(int i4) {
            MaterialIntroActivity materialIntroActivity = MaterialIntroActivity.this;
            materialIntroActivity.z(i4, materialIntroActivity.f53e.getItem(i4));
            if (MaterialIntroActivity.this.f53e.shouldFinish(i4)) {
                MaterialIntroActivity.this.onFinish();
                MaterialIntroActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements IPageScrolledListener {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f75a;

            a(int i4) {
                this.f75a = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (MaterialIntroActivity.this.f53e.getItem(this.f75a).hasNeededPermissionsToGrant() || !MaterialIntroActivity.this.f53e.getItem(this.f75a).canMoveFurther()) {
                    MaterialIntroActivity.this.f51c.setCurrentItem(this.f75a);
                    MaterialIntroActivity.this.f52d.clearJoiningFractions();
                }
            }
        }

        e() {
        }

        @Override // agency.tango.materialintroscreen.listeners.IPageScrolledListener
        public void pageScrolled(int i4, float f4) {
            MaterialIntroActivity.this.f51c.post(new a(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlideFragment f77a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f78b;

        f(SlideFragment slideFragment, int i4) {
            this.f77a = slideFragment;
            this.f78b = i4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f77a.canMoveFurther()) {
                MaterialIntroActivity.this.f61m.error();
                MaterialIntroActivity.this.showError(this.f77a.cantMoveFurtherErrorMessage());
                return;
            }
            MaterialIntroActivity.this.f51c.setCurrentItem(this.f78b + 1);
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int currentItem = MaterialIntroActivity.this.f51c.getCurrentItem(); currentItem < MaterialIntroActivity.this.f53e.slidesCount(); currentItem++) {
                if (!MaterialIntroActivity.this.f53e.getItem(currentItem).canMoveFurther()) {
                    MaterialIntroActivity.this.f51c.setCurrentItem(currentItem);
                    MaterialIntroActivity materialIntroActivity = MaterialIntroActivity.this;
                    materialIntroActivity.showError(materialIntroActivity.f53e.getItem(currentItem).cantMoveFurtherErrorMessage());
                    return;
                }
            }
            MaterialIntroActivity.this.f51c.setCurrentItem(MaterialIntroActivity.this.f53e.getLastItemPosition());
        }
    }

    /* loaded from: classes.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialIntroActivity.this.f51c.setCurrentItem(MaterialIntroActivity.this.f51c.getPreviousItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class i implements IPageScrolledListener {
        private i() {
        }

        private void a(int i4, float f4) {
            int intValue = MaterialIntroActivity.this.v(i4, f4).intValue();
            MaterialIntroActivity.this.f51c.setBackgroundColor(intValue);
            MaterialIntroActivity.this.f58j.setTextColor(intValue);
            int intValue2 = MaterialIntroActivity.this.w(i4, f4).intValue();
            MaterialIntroActivity.this.f52d.setPageIndicatorColor(MaterialIntroActivity.this.x(i4, f4).intValue());
            b(ColorStateList.valueOf(intValue2));
        }

        private void b(ColorStateList colorStateList) {
            ViewCompat.setBackgroundTintList(MaterialIntroActivity.this.f56h, colorStateList);
            ViewCompat.setBackgroundTintList(MaterialIntroActivity.this.f54f, colorStateList);
            ViewCompat.setBackgroundTintList(MaterialIntroActivity.this.f55g, colorStateList);
            MaterialIntroActivity.this.f56h.refreshDrawableState();
            MaterialIntroActivity.this.f54f.refreshDrawableState();
            MaterialIntroActivity.this.f55g.refreshDrawableState();
        }

        @Override // agency.tango.materialintroscreen.listeners.IPageScrolledListener
        public void pageScrolled(int i4, float f4) {
            if (i4 < MaterialIntroActivity.this.f53e.getCount() - 1) {
                a(i4, f4);
            } else if (MaterialIntroActivity.this.f53e.getCount() == 1) {
                MaterialIntroActivity.this.f51c.setBackgroundColor(MaterialIntroActivity.this.f53e.getItem(i4).backgroundColor());
                MaterialIntroActivity.this.f58j.setTextColor(MaterialIntroActivity.this.f53e.getItem(i4).backgroundColor());
                b(ColorStateList.valueOf(MaterialIntroActivity.this.f53e.getItem(i4).buttonsColor()));
            }
        }

        /* synthetic */ i(MaterialIntroActivity materialIntroActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class j implements View.OnClickListener {
        private j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SlideFragment item = MaterialIntroActivity.this.f53e.getItem(MaterialIntroActivity.this.f53e.getLastItemPosition());
            if (!item.canMoveFurther()) {
                MaterialIntroActivity.this.f61m.error();
                MaterialIntroActivity.this.showError(item.cantMoveFurtherErrorMessage());
                return;
            }
            MaterialIntroActivity.this.onFinish();
        }

        /* synthetic */ j(MaterialIntroActivity materialIntroActivity, a aVar) {
            this();
        }
    }

    private int u(@ColorRes int i4) {
        return ContextCompat.getColor(this, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer v(int i4, float f4) {
        return (Integer) this.f60l.evaluate(f4, Integer.valueOf(u(this.f53e.getItem(i4).backgroundColor())), Integer.valueOf(u(this.f53e.getItem(i4 + 1).backgroundColor())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer w(int i4, float f4) {
        return (Integer) this.f60l.evaluate(f4, Integer.valueOf(u(this.f53e.getItem(i4).buttonsColor())), Integer.valueOf(u(this.f53e.getItem(i4 + 1).buttonsColor())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer x(int i4, float f4) {
        return (Integer) this.f60l.evaluate(f4, Integer.valueOf(u(this.f53e.getItem(i4).dotsOffColor())), Integer.valueOf(u(this.f53e.getItem(i4 + 1).buttonsColor())));
    }

    private void y() {
        this.f66r = new MessageButtonBehaviourOnPageSelected(this.f58j, this.f53e, this.f69u);
        SwipeableViewPager swipeableViewPager = this.f51c;
        swipeableViewPager.registerOnTouchEventListener(new SwipeStateTouchListener(swipeableViewPager, this.f53e));
        this.f62n = new BackButtonTranslationWrapper(this.f54f);
        this.f63o = new PageIndicatorTranslationWrapper(this.f52d);
        this.f64p = new ViewPagerTranslationWrapper(this.f51c);
        this.f65q = new SkipButtonTranslationWrapper(this.f55g);
        this.f51c.addOnPageChangeListener(new ViewBehavioursOnPageChangeListener(this.f53e).registerViewTranslationWrapper(this.f61m).registerViewTranslationWrapper(this.f63o).registerViewTranslationWrapper(this.f64p).registerOnPageScrolled(new e()).registerOnPageScrolled(new i(this, null)).registerOnPageScrolled(new ParallaxScrollListener(this.f53e)).registerPageSelectedListener(this.f66r).registerPageSelectedListener(new d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i4, SlideFragment slideFragment) {
        if (slideFragment.hasNeededPermissionsToGrant()) {
            this.f56h.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_next));
            this.f56h.setOnClickListener(this.f67s);
        } else if (this.f53e.isLastSlide(i4)) {
            this.f56h.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_finish));
            this.f56h.setOnClickListener(this.f68t);
        } else {
            this.f56h.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_next));
            this.f56h.setOnClickListener(new f(slideFragment, i4));
        }
    }

    public void addSlide(SlideFragment slideFragment) {
        this.f53e.addItem(slideFragment);
    }

    public void enableLastSlideAlphaExitTransition(boolean z3) {
        this.f53e.addEmptySlide(new LastEmptySlideFragment());
    }

    public ViewTranslationWrapper getBackButtonTranslationWrapper() {
        return this.f62n;
    }

    public ViewTranslationWrapper getNextButtonTranslationWrapper() {
        return this.f61m;
    }

    public ViewTranslationWrapper getPageIndicatorTranslationWrapper() {
        return this.f63o;
    }

    public ViewTranslationWrapper getSkipButtonTranslationWrapper() {
        return this.f65q;
    }

    public ViewTranslationWrapper getViewPagerTranslationWrapper() {
        return this.f64p;
    }

    public void hideBackButton() {
        this.f54f.setVisibility(4);
        this.f55g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_material_intro);
        this.f51c = (SwipeableViewPager) findViewById(R.id.view_pager_slides);
        this.f52d = (InkPageIndicator) findViewById(R.id.indicator);
        this.f54f = (ImageButton) findViewById(R.id.button_back);
        this.f56h = (ImageButton) findViewById(R.id.button_next);
        this.f55g = (ImageButton) findViewById(R.id.button_skip);
        this.f58j = (Button) findViewById(R.id.button_message);
        this.f57i = (CoordinatorLayout) findViewById(R.id.coordinator_layout_slide);
        this.f59k = (LinearLayout) findViewById(R.id.navigation_view);
        SlidesAdapter slidesAdapter = new SlidesAdapter(getSupportFragmentManager());
        this.f53e = slidesAdapter;
        this.f51c.setAdapter(slidesAdapter);
        this.f51c.setOffscreenPageLimit(4);
        this.f52d.setViewPager(this.f51c);
        this.f61m = new NextButtonTranslationWrapper(this.f56h);
        y();
        this.f67s = new PermissionNotGrantedClickListener(this, this.f61m);
        this.f68t = new j(this, null);
        this.f51c.post(new a());
        getOnBackPressedDispatcher().addCallback(this, new b(true));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        SlideFragment item = this.f53e.getItem(this.f51c.getCurrentItem());
        if (!item.hasNeededPermissionsToGrant()) {
            this.f51c.setAllowedSwipeDirection(SwipeableViewPager.SwipeDirection.all);
            z(this.f51c.getCurrentItem(), item);
            this.f66r.pageSelected(this.f51c.getCurrentItem());
        } else {
            showPermissionsNotGrantedError();
        }
        super.onRequestPermissionsResult(i4, strArr, iArr);
    }

    public void setBackButtonVisible() {
        this.f55g.setVisibility(8);
        this.f54f.setVisibility(0);
        this.f54f.setOnClickListener(new h());
    }

    public void setSkipButtonVisible() {
        this.f54f.setVisibility(8);
        this.f55g.setVisibility(0);
        this.f55g.setOnClickListener(new g());
    }

    public void showError(String str) {
        Snackbar.make(this.f57i, str, -1).setCallback(new c()).show();
    }

    public void showPermissionsNotGrantedError() {
        showError(getString(R.string.please_grant_permissions));
    }

    public void addSlide(SlideFragment slideFragment, MessageButtonBehaviour messageButtonBehaviour) {
        this.f53e.addItem(slideFragment);
        this.f69u.put(this.f53e.getLastItemPosition(), messageButtonBehaviour);
    }

    public void onFinish() {
    }
}
