// Original code from https://github.com/pablogsal/black-pycharm
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * This ProjectConfigurable class appears on Settings dialog,
 * to let user to configure this plugin's behavior.
 */
public class BlackPycharmConfigurable implements SearchableConfigurable {

    private BlackPycharmGUI mGUI;
    private final BlackPycharmConfig mConfig;

    @SuppressWarnings("FieldCanBeLocal")
    private final Project mProject;

    public BlackPycharmConfigurable(@NotNull Project project) {
        mProject = project;
        mConfig = BlackPycharmConfig.getInstance(project);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "BlackPycharm Configuration";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "preference.BlackPycharmConfigurable";
    }

    @NotNull
    @Override
    public String getId() {
        return "preference.BlackPycharmConfigurable";
    }

    @Nullable
    @Override
    public Runnable enableSearch(String s) {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mGUI = new BlackPycharmGUI();
        mGUI.createUI(mProject);
        return mGUI.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return mGUI.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        mGUI.apply();
    }

    @Override
    public void reset() {
        mGUI.reset();
    }

    @Override
    public void disposeUIResources() {
        mGUI = null;
    }
}
