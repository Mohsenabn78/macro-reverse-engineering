package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class AnimatorSet extends Animator {

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<Animator> f36295b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<Animator, e> f36296c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<e> f36297d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<e> f36298e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f36299f = true;

    /* renamed from: g  reason: collision with root package name */
    private b f36300g = null;

    /* renamed from: h  reason: collision with root package name */
    boolean f36301h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f36302i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f36303j = 0;

    /* renamed from: k  reason: collision with root package name */
    private ValueAnimator f36304k = null;

    /* renamed from: l  reason: collision with root package name */
    private long f36305l = -1;

    /* loaded from: classes6.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        boolean f36308a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f36309b;

        a(ArrayList arrayList) {
            this.f36309b = arrayList;
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f36308a = true;
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f36308a) {
                int size = this.f36309b.size();
                for (int i4 = 0; i4 < size; i4++) {
                    e eVar = (e) this.f36309b.get(i4);
                    eVar.f36318a.start();
                    AnimatorSet.this.f36295b.add(eVar.f36318a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public e f36313a;

        /* renamed from: b  reason: collision with root package name */
        public int f36314b;

        public c(e eVar, int i4) {
            this.f36313a = eVar;
            this.f36314b = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class e implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public Animator f36318a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<c> f36319b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<c> f36320c = null;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<e> f36321d = null;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<e> f36322e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36323f = false;

        public e(Animator animator) {
            this.f36318a = animator;
        }

        public void a(c cVar) {
            if (this.f36319b == null) {
                this.f36319b = new ArrayList<>();
                this.f36321d = new ArrayList<>();
            }
            this.f36319b.add(cVar);
            if (!this.f36321d.contains(cVar.f36313a)) {
                this.f36321d.add(cVar.f36313a);
            }
            e eVar = cVar.f36313a;
            if (eVar.f36322e == null) {
                eVar.f36322e = new ArrayList<>();
            }
            eVar.f36322e.add(this);
        }

        /* renamed from: b */
        public e clone() {
            try {
                e eVar = (e) super.clone();
                eVar.f36318a = this.f36318a.mo4175clone();
                return eVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void f() {
        if (this.f36299f) {
            this.f36298e.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f36297d.size();
            for (int i4 = 0; i4 < size; i4++) {
                e eVar = this.f36297d.get(i4);
                ArrayList<c> arrayList2 = eVar.f36319b;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(eVar);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    e eVar2 = (e) arrayList.get(i5);
                    this.f36298e.add(eVar2);
                    ArrayList<e> arrayList4 = eVar2.f36322e;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i6 = 0; i6 < size3; i6++) {
                            e eVar3 = eVar2.f36322e.get(i6);
                            eVar3.f36321d.remove(eVar2);
                            if (eVar3.f36321d.size() == 0) {
                                arrayList3.add(eVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.f36299f = false;
            if (this.f36298e.size() != this.f36297d.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f36297d.size();
        for (int i7 = 0; i7 < size4; i7++) {
            e eVar4 = this.f36297d.get(i7);
            ArrayList<c> arrayList5 = eVar4.f36319b;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = eVar4.f36319b.size();
                for (int i8 = 0; i8 < size5; i8++) {
                    c cVar = eVar4.f36319b.get(i8);
                    if (eVar4.f36321d == null) {
                        eVar4.f36321d = new ArrayList<>();
                    }
                    if (!eVar4.f36321d.contains(cVar.f36313a)) {
                        eVar4.f36321d.add(cVar.f36313a);
                    }
                }
            }
            eVar4.f36323f = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void cancel() {
        ArrayList arrayList;
        this.f36301h = true;
        if (isStarted()) {
            ArrayList<Animator.AnimatorListener> arrayList2 = this.f36291a;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            } else {
                arrayList = null;
            }
            ValueAnimator valueAnimator = this.f36304k;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f36304k.cancel();
            } else if (this.f36298e.size() > 0) {
                Iterator<e> it2 = this.f36298e.iterator();
                while (it2.hasNext()) {
                    it2.next().f36318a.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.f36302i = false;
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void end() {
        this.f36301h = true;
        if (isStarted()) {
            if (this.f36298e.size() != this.f36297d.size()) {
                f();
                Iterator<e> it = this.f36298e.iterator();
                while (it.hasNext()) {
                    e next = it.next();
                    if (this.f36300g == null) {
                        this.f36300g = new b(this);
                    }
                    next.f36318a.addListener(this.f36300g);
                }
            }
            ValueAnimator valueAnimator = this.f36304k;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.f36298e.size() > 0) {
                Iterator<e> it2 = this.f36298e.iterator();
                while (it2.hasNext()) {
                    it2.next().f36318a.end();
                }
            }
            ArrayList<Animator.AnimatorListener> arrayList = this.f36291a;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.f36302i = false;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> arrayList = new ArrayList<>();
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f36318a);
        }
        return arrayList;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getDuration() {
        return this.f36305l;
    }

    @Override // com.nineoldandroids.animation.Animator
    public long getStartDelay() {
        return this.f36303j;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isRunning() {
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            if (it.next().f36318a.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nineoldandroids.animation.Animator
    public boolean isStarted() {
        return this.f36302i;
    }

    public Builder play(Animator animator) {
        if (animator != null) {
            this.f36299f = true;
            return new Builder(animator);
        }
        return null;
    }

    public void playSequentially(Animator... animatorArr) {
        if (animatorArr != null) {
            this.f36299f = true;
            int i4 = 0;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i4 < animatorArr.length - 1) {
                i4++;
                play(animatorArr[i4]).before(animatorArr[i4]);
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        if (animatorArr != null) {
            this.f36299f = true;
            Builder play = play(animatorArr[0]);
            for (int i4 = 1; i4 < animatorArr.length; i4++) {
                play.with(animatorArr[i4]);
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setInterpolator(Interpolator interpolator) {
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            it.next().f36318a.setInterpolator(interpolator);
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setStartDelay(long j4) {
        this.f36303j = j4;
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setTarget(Object obj) {
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            Animator animator = it.next().f36318a;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupEndValues() {
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            it.next().f36318a.setupEndValues();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void setupStartValues() {
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            it.next().f36318a.setupStartValues();
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public void start() {
        this.f36301h = false;
        this.f36302i = true;
        f();
        int size = this.f36298e.size();
        for (int i4 = 0; i4 < size; i4++) {
            e eVar = this.f36298e.get(i4);
            ArrayList<Animator.AnimatorListener> listeners = eVar.f36318a.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it = new ArrayList(listeners).iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
                    if ((animatorListener instanceof d) || (animatorListener instanceof b)) {
                        eVar.f36318a.removeListener(animatorListener);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar2 = this.f36298e.get(i5);
            if (this.f36300g == null) {
                this.f36300g = new b(this);
            }
            ArrayList<c> arrayList2 = eVar2.f36319b;
            if (arrayList2 != null && arrayList2.size() != 0) {
                int size2 = eVar2.f36319b.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    c cVar = eVar2.f36319b.get(i6);
                    cVar.f36313a.f36318a.addListener(new d(this, eVar2, cVar.f36314b));
                }
                eVar2.f36320c = (ArrayList) eVar2.f36319b.clone();
            } else {
                arrayList.add(eVar2);
            }
            eVar2.f36318a.addListener(this.f36300g);
        }
        if (this.f36303j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                e eVar3 = (e) it2.next();
                eVar3.f36318a.start();
                this.f36295b.add(eVar3.f36318a);
            }
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f36304k = ofFloat;
            ofFloat.setDuration(this.f36303j);
            this.f36304k.addListener(new a(arrayList));
            this.f36304k.start();
        }
        ArrayList<Animator.AnimatorListener> arrayList3 = this.f36291a;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i7 = 0; i7 < size3; i7++) {
                ((Animator.AnimatorListener) arrayList4.get(i7)).onAnimationStart(this);
            }
        }
        if (this.f36297d.size() == 0 && this.f36303j == 0) {
            this.f36302i = false;
            ArrayList<Animator.AnimatorListener> arrayList5 = this.f36291a;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i8 = 0; i8 < size4; i8++) {
                    ((Animator.AnimatorListener) arrayList6.get(i8)).onAnimationEnd(this);
                }
            }
        }
    }

    @Override // com.nineoldandroids.animation.Animator
    public AnimatorSet setDuration(long j4) {
        if (j4 >= 0) {
            Iterator<e> it = this.f36297d.iterator();
            while (it.hasNext()) {
                it.next().f36318a.setDuration(j4);
            }
            this.f36305l = j4;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    @Override // com.nineoldandroids.animation.Animator
    /* renamed from: clone */
    public AnimatorSet mo4175clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.mo4175clone();
        animatorSet.f36299f = true;
        animatorSet.f36301h = false;
        animatorSet.f36302i = false;
        animatorSet.f36295b = new ArrayList<>();
        animatorSet.f36296c = new HashMap<>();
        animatorSet.f36297d = new ArrayList<>();
        animatorSet.f36298e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<e> it = this.f36297d.iterator();
        while (it.hasNext()) {
            e next = it.next();
            e clone = next.clone();
            hashMap.put(next, clone);
            animatorSet.f36297d.add(clone);
            animatorSet.f36296c.put(clone.f36318a, clone);
            ArrayList arrayList = null;
            clone.f36319b = null;
            clone.f36320c = null;
            clone.f36322e = null;
            clone.f36321d = null;
            ArrayList<Animator.AnimatorListener> listeners = clone.f36318a.getListeners();
            if (listeners != null) {
                Iterator<Animator.AnimatorListener> it2 = listeners.iterator();
                while (it2.hasNext()) {
                    Animator.AnimatorListener next2 = it2.next();
                    if (next2 instanceof b) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        listeners.remove((Animator.AnimatorListener) it3.next());
                    }
                }
            }
        }
        Iterator<e> it4 = this.f36297d.iterator();
        while (it4.hasNext()) {
            e next3 = it4.next();
            e eVar = (e) hashMap.get(next3);
            ArrayList<c> arrayList2 = next3.f36319b;
            if (arrayList2 != null) {
                Iterator<c> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    c next4 = it5.next();
                    eVar.a(new c((e) hashMap.get(next4.f36313a), next4.f36314b));
                }
            }
        }
        return animatorSet;
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f36299f = true;
        Builder builder = null;
        for (Animator animator : collection) {
            if (builder == null) {
                builder = play(animator);
            } else {
                builder.with(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class Builder {

        /* renamed from: a  reason: collision with root package name */
        private e f36306a;

        Builder(Animator animator) {
            e eVar = (e) AnimatorSet.this.f36296c.get(animator);
            this.f36306a = eVar;
            if (eVar == null) {
                this.f36306a = new e(animator);
                AnimatorSet.this.f36296c.put(animator, this.f36306a);
                AnimatorSet.this.f36297d.add(this.f36306a);
            }
        }

        public Builder after(Animator animator) {
            e eVar = (e) AnimatorSet.this.f36296c.get(animator);
            if (eVar == null) {
                eVar = new e(animator);
                AnimatorSet.this.f36296c.put(animator, eVar);
                AnimatorSet.this.f36297d.add(eVar);
            }
            this.f36306a.a(new c(eVar, 1));
            return this;
        }

        public Builder before(Animator animator) {
            e eVar = (e) AnimatorSet.this.f36296c.get(animator);
            if (eVar == null) {
                eVar = new e(animator);
                AnimatorSet.this.f36296c.put(animator, eVar);
                AnimatorSet.this.f36297d.add(eVar);
            }
            eVar.a(new c(this.f36306a, 1));
            return this;
        }

        public Builder with(Animator animator) {
            e eVar = (e) AnimatorSet.this.f36296c.get(animator);
            if (eVar == null) {
                eVar = new e(animator);
                AnimatorSet.this.f36296c.put(animator, eVar);
                AnimatorSet.this.f36297d.add(eVar);
            }
            eVar.a(new c(this.f36306a, 0));
            return this;
        }

        public Builder after(long j4) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j4);
            after(ofFloat);
            return this;
        }
    }

    public void playSequentially(List<Animator> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f36299f = true;
        int i4 = 0;
        if (list.size() == 1) {
            play(list.get(0));
            return;
        }
        while (i4 < list.size() - 1) {
            i4++;
            play(list.get(i4)).before(list.get(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private AnimatorSet f36311a;

        b(AnimatorSet animatorSet) {
            this.f36311a = animatorSet;
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ArrayList<Animator.AnimatorListener> arrayList;
            AnimatorSet animatorSet = AnimatorSet.this;
            if (!animatorSet.f36301h && animatorSet.f36295b.size() == 0 && (arrayList = AnimatorSet.this.f36291a) != null) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    AnimatorSet.this.f36291a.get(i4).onAnimationCancel(this.f36311a);
                }
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animator.removeListener(this);
            AnimatorSet.this.f36295b.remove(animator);
            boolean z3 = true;
            ((e) this.f36311a.f36296c.get(animator)).f36323f = true;
            if (!AnimatorSet.this.f36301h) {
                ArrayList arrayList = this.f36311a.f36298e;
                int size = arrayList.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    } else if (!((e) arrayList.get(i4)).f36323f) {
                        z3 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z3) {
                    ArrayList<Animator.AnimatorListener> arrayList2 = AnimatorSet.this.f36291a;
                    if (arrayList2 != null) {
                        ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                        int size2 = arrayList3.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            ((Animator.AnimatorListener) arrayList3.get(i5)).onAnimationEnd(this.f36311a);
                        }
                    }
                    this.f36311a.f36302i = false;
                }
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes6.dex */
    private static class d implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private AnimatorSet f36315a;

        /* renamed from: b  reason: collision with root package name */
        private e f36316b;

        /* renamed from: c  reason: collision with root package name */
        private int f36317c;

        public d(AnimatorSet animatorSet, e eVar, int i4) {
            this.f36315a = animatorSet;
            this.f36316b = eVar;
            this.f36317c = i4;
        }

        private void a(Animator animator) {
            c cVar;
            if (this.f36315a.f36301h) {
                return;
            }
            int size = this.f36316b.f36320c.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    cVar = this.f36316b.f36320c.get(i4);
                    if (cVar.f36314b == this.f36317c && cVar.f36313a.f36318a == animator) {
                        animator.removeListener(this);
                        break;
                    }
                    i4++;
                } else {
                    cVar = null;
                    break;
                }
            }
            this.f36316b.f36320c.remove(cVar);
            if (this.f36316b.f36320c.size() == 0) {
                this.f36316b.f36318a.start();
                this.f36315a.f36295b.add(this.f36316b.f36318a);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f36317c == 1) {
                a(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f36317c == 0) {
                a(animator);
            }
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
