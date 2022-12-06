package br.com.vericode;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("br/com/vericode")
public class RunCucumberTest { }
