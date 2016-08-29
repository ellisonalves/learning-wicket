package com.ellisonalves.pages;

import com.ellisonalves.forms.DropDownChoiceForm;

public class DropDownChoicePage extends HomePage {

    private static final long serialVersionUID = 1L;

    public DropDownChoicePage() {
        add(new DropDownChoiceForm("form"));
    }

}
