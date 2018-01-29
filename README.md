# Dagger2NoModule

Illustration that Dagger2 does not necessarily require a module to be able to inject dependencies.

You only need a module if you want to write Provides methods.

Otherwise a component is enough.

## Inject

A class requiring dependencies should be marked with @Inject.
eg if Foo requires an implementation of the Bar interface:

    public class Foo {
        private final Bar bar;
        @Inject public Foo(Bar bar) {
            this.bar = bar;
        }
    }

## Modules
  A class annotated @Module has methods annotated @Provides which
  can provide implementations of types. By convention, @Provides methods are named with a provide prefix and module classes are named with a Module suffix, so a more conventional module would be
eg
  
    @Module
    public class AModule {
       @Provides YourInterface providesYourInterface() {
           return new Implementation();
       }
    }

Also possible to use @Singleton to have the same instance injected each time,
and @Named to differentiate.

Thus if a dependency can be provided simply by instantiating the required type, no module needed.
ie this is superfluous

    @Module
    public class ThisClassIsntNeeded {
        @Provides Implementation anyNameYouLike() {
            return new Implementation();
        }
    }
    
    
    
## Components

Components are always required.
A class annotataed @Component builds the dependency tree if more than one component,
and provides the ability to inject into classes.
If just one class needing inject, then a component might be:

    @Component
    public class AComponent {
       void anyOtherNameYouChoose(ClassWantingInject clazz);
    }
 
If modules are required:

    @Component(modules = { AModule.class, ...anyOtherModules})
    public class AComponent {
       void anyOtherNameYouChoose(ClassWantingInject clazz);
    }

If submodules provides dependencies, then also define the dependency in the Component

    @Component(modules = { AModule.class, ...anyOtherModules})
    public class AComponent {
       Something provideSomething();
       void anyOtherNameYouChoose(Foo clazz);
    }


So

Module: contains methods that fulfill provides. 
Needed when calling a constructor isnt enough (such as dependency on an interface, dependencies reqiure configuration).


Component: Dagger uses this to tie toegther the modules.

