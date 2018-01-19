package com.pedrumjalali.jetbrains.plugins.libs;

import java.io.BufferedWriter;
import java.util.List;

//Converts a list of html include statements into php include statements
public class Convertor {
    private String prevJs;
    private List<HtmlIncludeStatement> htmlIncludeStatements;
    
    public Convertor(List<HtmlIncludeStatement> __htmlIncludeStatements){
        htmlIncludeStatements = __htmlIncludeStatements;
        prevJs = "";
    }

    
    public String run(){
        StringBuilder _output = new StringBuilder();
        _output.append("<?php \n");
        for (int i =0 ;i < htmlIncludeStatements.size();i++){
            _output.append(convertElement(htmlIncludeStatements.get(i)));
            _output.append("\n");
        }
        return _output.toString();
    }

    private String convertElement(HtmlIncludeStatement __htmlIncludeStatement){
        if (__htmlIncludeStatement.type == HtmlIncludeStatement.Type.CSS){
            return getCssString(__htmlIncludeStatement);
        }
        else{
            return getJavaScriptString(__htmlIncludeStatement);
        }
    }

    private String getCssString(HtmlIncludeStatement __htmlIncludeStatement){
        return "wp_enqueue_style( '"+__htmlIncludeStatement.name+"', get_template_directory_uri() . '"+
        __htmlIncludeStatement.source + "');";
    }

    private String getJavaScriptString(HtmlIncludeStatement __htmlIncludeStatement){
        String _output;
        if (prevJs.equals("")){
            _output ="wp_enqueue_script( '"+__htmlIncludeStatement.name+"', get_template_directory_uri() . '"+
                    __htmlIncludeStatement.source + "', array());";
        }
        else{
            _output = "wp_enqueue_script( '"+__htmlIncludeStatement.name+"', get_template_directory_uri() . '"+
                    __htmlIncludeStatement.source + "', array('"+prevJs+"'));";
        }
        prevJs = __htmlIncludeStatement.name;
        return _output;

    }

}
