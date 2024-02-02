package org.xsampled

import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName

@Suite
@SuiteDisplayName("Unit tests")
@SelectPackages("org.xsampled")
internal class TestRunner