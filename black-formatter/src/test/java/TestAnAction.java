import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class TestAnAction extends LightPlatformCodeInsightFixtureTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected String getTestDataPath() {
        File f = new File("src/test/testData/");
        String absolute = f.getAbsolutePath();
        return absolute;
//        return "./src/";
    }

    public void testEnabledDisabled() {
        String a = System.getProperty("user.dir");

//        myFixture.getTempDirFixture().createFile("a.py");
        myFixture.configureByFile("a.py");
        AnAction action = new MyAction();
        Presentation presentation = myFixture.testAction(action);
        assertTrue(presentation.isEnabledAndVisible());
    }
}
