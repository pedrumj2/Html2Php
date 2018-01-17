package com.pedrumjalali.jetbrains.plugins.tests;

import com.pedrumjalali.jetbrains.plugins.libs.Convertor;
import com.pedrumjalali.jetbrains.plugins.libs.HtmlIncludeStatement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertorTest {
    List<HtmlIncludeStatement> htmlIncludeStatments;
    private Convertor convertor;
    @Before
    public void setUp() throws Exception {
        htmlIncludeStatments = new ArrayList<>();
        HtmlIncludeStatement _htmlIncludeStatement =
                new HtmlIncludeStatement("temp/path", HtmlIncludeStatement.Type.JAVASCRIPT);
        htmlIncludeStatments.add(_htmlIncludeStatement);
        _htmlIncludeStatement =
                new HtmlIncludeStatement("temp/path2", HtmlIncludeStatement.Type.CSS);
        htmlIncludeStatments.add(_htmlIncludeStatement);
        convertor = new Convertor(htmlIncludeStatments);
    }

    @Test
    public void testConvertor(){
        String _res = convertor.convert();
        assertEquals(_res, "wp_enqueue_script( 'path', get_template_directory_uri() . 'temp/path', array());\n" +
                "wp_enqueue_style( 'path2', get_template_directory_uri() . 'temp/path2');\n");
    }
    @After
    public void tearDown() throws Exception {

    }

}