package net.tydaniel.commons.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.web.util.HtmlUtils;

/**
 * @description：继承PropertyEditorSupport编辑器  防 XXS攻击
 * @author：
 * @date：
 */
public class StringEscapeEditor extends PropertyEditorSupport {
	public StringEscapeEditor() 
	{
		super();
	}

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else {
            setValue(HtmlUtils.htmlEscape(text));
        }
    }
}
