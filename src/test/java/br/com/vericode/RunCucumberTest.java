package br.com.vericode;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("br/com/vericode")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.vericode.steps")
@ExcludeTags("ignore")
public class RunCucumberTest {
}
