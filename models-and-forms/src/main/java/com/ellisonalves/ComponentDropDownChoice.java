package com.ellisonalves;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

import com.ellisonalves.forms.ComponentDropDownChoiceForm;

public class ComponentDropDownChoice extends WebPage {

	private static final long	serialVersionUID	= 1L;

	private Form<Serializable>	form;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(this.form = new ComponentDropDownChoiceForm("form"));
	}

}
