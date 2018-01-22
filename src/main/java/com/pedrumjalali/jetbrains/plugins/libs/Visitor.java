package com.pedrumjalali.jetbrains.plugins.libs;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.impl.source.html.HtmlTagImpl;

import java.util.ArrayList;
import java.util.List;

public class Visitor extends PsiRecursiveElementVisitor {
    public List<HtmlTagImpl> psiElements = new ArrayList<HtmlTagImpl>();
    public List<HtmlIncludeStatement> extSourceStatements = new ArrayList<>();
    private String extraPath;
    public Visitor(String __extraPath){
        extraPath = __extraPath;
    }
    @Override
    public void visitElement(PsiElement element) {
        if (isHtmlIncludeElement(element)){
            HtmlTagImpl _htmlTagIml =  (HtmlTagImpl)element;
            HtmlIncludeStatement _extSourceStatement = new HtmlIncludeStatement(_htmlTagIml, extraPath);
            extSourceStatements.add(_extSourceStatement);
        }
        super.visitElement(element);
    }

    private boolean isHtmlElement(PsiElement __psiElement){
        if (__psiElement instanceof HtmlTagImpl){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isHtmlIncludeElement(PsiElement __psiElement){
        if (!isHtmlElement(__psiElement)){
            return false;
        }
        HtmlTagImpl _htmlTagImpl = (HtmlTagImpl) __psiElement;
        if (_htmlTagImpl.getName().equals("script") ||
                _htmlTagImpl.getName().equals("link")){
            return true;
        }
        else{
            return false;
        }
    }
}
