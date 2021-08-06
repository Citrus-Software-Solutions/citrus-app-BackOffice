package com.citrus.backoffice.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.citrus.backoffice.integration.MapperTest;
import com.citrus.backoffice.integration.UserListTest;
import com.citrus.backoffice.unit.APITest;
import com.citrus.backoffice.unit.TranslatorTest;

@RunWith(Suite.class)
@SuiteClasses({
	MapperTest.class,
	UserListTest.class,
	APITest.class,
	TranslatorTest.class})
public class AllTests {

}
