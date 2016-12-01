# Android MVP Architecture

### Summary

This library contains a <b>Presentation Layer</b> implementing the MVP-VM pattern.

MVP-VM improves the [MVP Pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) by adding a ViewModel whose only responsibility is to bind the model to the view and gather the input from the view to deliber it back to the presenter whenever it is needed.

In <b>android-mvp-vm</b> I implement the ViewModel <-> View interaction with the help of [Android Data Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html).

I recommend to use <b>android-mvp-vm</b> in conjuntion with the <b>[Domain Layer](https://github.com/chiara-jm/android-clean)</b> base classes inspired by the principles of [Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html) for a simpler and cleaner android full app Architecture.

You could also take a look at this [Task Scheduler](https://github.com/chiara-jm/android-sample) to see a sample of the whole architecture. 

<img src="https://goo.gl/H0l4Kh" alt="Diagram"/>
