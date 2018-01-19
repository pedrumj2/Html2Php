//package com.pedrumjalali.jetbrains.plugins;
//
//import com.intellij.openapi.actionSystem.ActionManager;
//import com.intellij.openapi.actionSystem.DefaultActionGroup;
//import com.intellij.openapi.components.ApplicationComponent;
//import org.jetbrains.annotations.NotNull;
//
//import java.io.IOException;
//
//public class PluginReg implements ApplicationComponent {
//    // Returns the component name (any unique string value).
//    @NotNull
//    public String getComponentName() {
//        return "MyPlugin";
//    }
//
//
//    // If you register the MyPluginRegistration class in the <application-components> section of
//    // the plugin.xml file, this method is called on IDEA start-up.
//    public void initComponent() {
//        ActionManager am = ActionManager.getInstance();
//        HtmlToPhp action = null;
//        try {
//            action = new HtmlToPhp();
//        } catch (IOException __e) {
//            __e.printStackTrace();
//        }
//
//        // Passes an instance of your custom TextBoxes class to the registerAction method of the ActionManager class.
//        am.registerAction("MyPluginAction", action);
//
//        // Gets an instance of the WindowMenu action group.
//        //DefaultActionGroup windowM = (DefaultActionGroup) am.getAction();
//
//        // Adds a separator and a new menu command to the WindowMenu group on the main menu.
//        windowM.addSeparator();
//        windowM.add(action);
//    }
//
//    // Disposes system resources.
//    public void disposeComponent() {
//    }
//}