package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class CycleDetector {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ComponentNode {

        /* renamed from: a  reason: collision with root package name */
        private final Component<?> f29204a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<ComponentNode> f29205b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<ComponentNode> f29206c = new HashSet();

        ComponentNode(Component<?> component) {
            this.f29204a = component;
        }

        void a(ComponentNode componentNode) {
            this.f29205b.add(componentNode);
        }

        void b(ComponentNode componentNode) {
            this.f29206c.add(componentNode);
        }

        Component<?> c() {
            return this.f29204a;
        }

        Set<ComponentNode> d() {
            return this.f29205b;
        }

        boolean e() {
            return this.f29205b.isEmpty();
        }

        boolean f() {
            return this.f29206c.isEmpty();
        }

        void g(ComponentNode componentNode) {
            this.f29206c.remove(componentNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Dep {

        /* renamed from: a  reason: collision with root package name */
        private final Qualified<?> f29207a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f29208b;

        public boolean equals(Object obj) {
            if (!(obj instanceof Dep)) {
                return false;
            }
            Dep dep = (Dep) obj;
            if (!dep.f29207a.equals(this.f29207a) || dep.f29208b != this.f29208b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f29207a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f29208b).hashCode();
        }

        private Dep(Qualified<?> qualified, boolean z3) {
            this.f29207a = qualified;
            this.f29208b = z3;
        }
    }

    CycleDetector() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<Component<?>> list) {
        Set<ComponentNode> c4 = c(list);
        Set<ComponentNode> b4 = b(c4);
        int i4 = 0;
        while (!b4.isEmpty()) {
            ComponentNode next = b4.iterator().next();
            b4.remove(next);
            i4++;
            for (ComponentNode componentNode : next.d()) {
                componentNode.g(next);
                if (componentNode.f()) {
                    b4.add(componentNode);
                }
            }
        }
        if (i4 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (ComponentNode componentNode2 : c4) {
            if (!componentNode2.f() && !componentNode2.e()) {
                arrayList.add(componentNode2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<ComponentNode> b(Set<ComponentNode> set) {
        HashSet hashSet = new HashSet();
        for (ComponentNode componentNode : set) {
            if (componentNode.f()) {
                hashSet.add(componentNode);
            }
        }
        return hashSet;
    }

    private static Set<ComponentNode> c(List<Component<?>> list) {
        Set<ComponentNode> set;
        HashMap hashMap = new HashMap(list.size());
        for (Component<?> component : list) {
            ComponentNode componentNode = new ComponentNode(component);
            for (Qualified<? super Object> qualified : component.getProvidedInterfaces()) {
                Dep dep = new Dep(qualified, !component.isValue());
                if (!hashMap.containsKey(dep)) {
                    hashMap.put(dep, new HashSet());
                }
                Set set2 = (Set) hashMap.get(dep);
                if (!set2.isEmpty() && !dep.f29208b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", qualified));
                }
                set2.add(componentNode);
            }
        }
        for (Set<ComponentNode> set3 : hashMap.values()) {
            for (ComponentNode componentNode2 : set3) {
                for (Dependency dependency : componentNode2.c().getDependencies()) {
                    if (dependency.isDirectInjection() && (set = (Set) hashMap.get(new Dep(dependency.getInterface(), dependency.isSet()))) != null) {
                        for (ComponentNode componentNode3 : set) {
                            componentNode2.a(componentNode3);
                            componentNode3.b(componentNode2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
