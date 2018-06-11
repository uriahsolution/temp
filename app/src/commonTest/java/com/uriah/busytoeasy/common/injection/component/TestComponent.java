package com.uriah.busytoeasy.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.uriah.busytoeasy.common.injection.module.ApplicationTestModule;
import com.uriah.busytoeasy.injection.component.AppComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends AppComponent {
}
