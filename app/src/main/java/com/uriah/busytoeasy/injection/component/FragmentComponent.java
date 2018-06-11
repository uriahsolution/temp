package com.uriah.busytoeasy.injection.component;

import dagger.Subcomponent;
import com.uriah.busytoeasy.injection.PerFragment;
import com.uriah.busytoeasy.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
